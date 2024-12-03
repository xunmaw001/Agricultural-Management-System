
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 农事安排
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nongshianpai")
public class NongshianpaiController {
    private static final Logger logger = LoggerFactory.getLogger(NongshianpaiController.class);

    private static final String TABLE_NAME = "nongshianpai";

    @Autowired
    private NongshianpaiService nongshianpaiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private JiankongjiedianService jiankongjiedianService;//监控节点
    @Autowired
    private JiankongjiedianJiluService jiankongjiedianJiluService;//监控记录
    @Autowired
    private NongzuowuService nongzuowuService;//农作物
    @Autowired
    private NongzuowuCollectionService nongzuowuCollectionService;//农作物收藏
    @Autowired
    private NongzuowuLiuyanService nongzuowuLiuyanService;//农作物留言
    @Autowired
    private QixiangshujuService qixiangshujuService;//气象数据
    @Autowired
    private QixiangshujuCollectionService qixiangshujuCollectionService;//气象数据收藏
    @Autowired
    private QixiangshujuLiuyanService qixiangshujuLiuyanService;//气象数据留言
    @Autowired
    private ShangpinService shangpinService;//商品
    @Autowired
    private ShangpinCollectionService shangpinCollectionService;//商品收藏
    @Autowired
    private ShangpinCommentbackService shangpinCommentbackService;//商品评价
    @Autowired
    private ShangpinOrderService shangpinOrderService;//商品订单
    @Autowired
    private TudiService tudiService;//土地规划
    @Autowired
    private TudiCollectionService tudiCollectionService;//土地规划收藏
    @Autowired
    private TudiLiuyanService tudiLiuyanService;//土地留言
    @Autowired
    private XuanmiaoyuzhongService xuanmiaoyuzhongService;//选苗育种
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = nongshianpaiService.queryPage(params);

        //字典表数据转换
        List<NongshianpaiView> list =(List<NongshianpaiView>)page.getList();
        for(NongshianpaiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongshianpaiEntity nongshianpai = nongshianpaiService.selectById(id);
        if(nongshianpai !=null){
            //entity转view
            NongshianpaiView view = new NongshianpaiView();
            BeanUtils.copyProperties( nongshianpai , view );//把实体数据重构到view中
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(nongshianpai.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody NongshianpaiEntity nongshianpai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nongshianpai:{}",this.getClass().getName(),nongshianpai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            nongshianpai.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<NongshianpaiEntity> queryWrapper = new EntityWrapper<NongshianpaiEntity>()
            .eq("yuangong_id", nongshianpai.getYuangongId())
            .eq("nongshianpai_name", nongshianpai.getNongshianpaiName())
            .eq("nongshianpai_address", nongshianpai.getNongshianpaiAddress())
            .eq("nongshianpai_types", nongshianpai.getNongshianpaiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongshianpaiEntity nongshianpaiEntity = nongshianpaiService.selectOne(queryWrapper);
        if(nongshianpaiEntity==null){
            nongshianpai.setInsertTime(new Date());
            nongshianpai.setCreateTime(new Date());
            nongshianpaiService.insert(nongshianpai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NongshianpaiEntity nongshianpai, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nongshianpai:{}",this.getClass().getName(),nongshianpai.toString());
        NongshianpaiEntity oldNongshianpaiEntity = nongshianpaiService.selectById(nongshianpai.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            nongshianpai.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(nongshianpai.getNongshianpaiFile()) || "null".equals(nongshianpai.getNongshianpaiFile())){
                nongshianpai.setNongshianpaiFile(null);
        }
        if("".equals(nongshianpai.getNongshianpaiContent()) || "null".equals(nongshianpai.getNongshianpaiContent())){
                nongshianpai.setNongshianpaiContent(null);
        }

            nongshianpaiService.updateById(nongshianpai);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NongshianpaiEntity> oldNongshianpaiList =nongshianpaiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        nongshianpaiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<NongshianpaiEntity> nongshianpaiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            NongshianpaiEntity nongshianpaiEntity = new NongshianpaiEntity();
//                            nongshianpaiEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            nongshianpaiEntity.setNongshianpaiUuidNumber(data.get(0));                    //农事安排编号 要改的
//                            nongshianpaiEntity.setNongshianpaiName(data.get(0));                    //农事安排标题 要改的
//                            nongshianpaiEntity.setNongshianpaiFile(data.get(0));                    //农事安排附件 要改的
//                            nongshianpaiEntity.setNongshianpaiAddress(data.get(0));                    //安排地点 要改的
//                            nongshianpaiEntity.setInsertTime(date);//时间
//                            nongshianpaiEntity.setNongshianpaiTime(sdf.parse(data.get(0)));          //要执行时间 要改的
//                            nongshianpaiEntity.setNongshianpaiTypes(Integer.valueOf(data.get(0)));   //农事安排类型 要改的
//                            nongshianpaiEntity.setNongshianpaiContent("");//详情和图片
//                            nongshianpaiEntity.setCreateTime(date);//时间
                            nongshianpaiList.add(nongshianpaiEntity);


                            //把要查询是否重复的字段放入map中
                                //农事安排编号
                                if(seachFields.containsKey("nongshianpaiUuidNumber")){
                                    List<String> nongshianpaiUuidNumber = seachFields.get("nongshianpaiUuidNumber");
                                    nongshianpaiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> nongshianpaiUuidNumber = new ArrayList<>();
                                    nongshianpaiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("nongshianpaiUuidNumber",nongshianpaiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //农事安排编号
                        List<NongshianpaiEntity> nongshianpaiEntities_nongshianpaiUuidNumber = nongshianpaiService.selectList(new EntityWrapper<NongshianpaiEntity>().in("nongshianpai_uuid_number", seachFields.get("nongshianpaiUuidNumber")));
                        if(nongshianpaiEntities_nongshianpaiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NongshianpaiEntity s:nongshianpaiEntities_nongshianpaiUuidNumber){
                                repeatFields.add(s.getNongshianpaiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [农事安排编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        nongshianpaiService.insertBatch(nongshianpaiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = nongshianpaiService.queryPage(params);

        //字典表数据转换
        List<NongshianpaiView> list =(List<NongshianpaiView>)page.getList();
        for(NongshianpaiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongshianpaiEntity nongshianpai = nongshianpaiService.selectById(id);
            if(nongshianpai !=null){


                //entity转view
                NongshianpaiView view = new NongshianpaiView();
                BeanUtils.copyProperties( nongshianpai , view );//把实体数据重构到view中

                //级联表
                    YuangongEntity yuangong = yuangongService.selectById(nongshianpai.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody NongshianpaiEntity nongshianpai, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nongshianpai:{}",this.getClass().getName(),nongshianpai.toString());
        Wrapper<NongshianpaiEntity> queryWrapper = new EntityWrapper<NongshianpaiEntity>()
            .eq("yuangong_id", nongshianpai.getYuangongId())
            .eq("nongshianpai_uuid_number", nongshianpai.getNongshianpaiUuidNumber())
            .eq("nongshianpai_name", nongshianpai.getNongshianpaiName())
            .eq("nongshianpai_address", nongshianpai.getNongshianpaiAddress())
            .eq("nongshianpai_types", nongshianpai.getNongshianpaiTypes())
//            .notIn("nongshianpai_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongshianpaiEntity nongshianpaiEntity = nongshianpaiService.selectOne(queryWrapper);
        if(nongshianpaiEntity==null){
            nongshianpai.setInsertTime(new Date());
            nongshianpai.setCreateTime(new Date());
        nongshianpaiService.insert(nongshianpai);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

