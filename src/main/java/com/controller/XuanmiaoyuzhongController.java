
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
 * 选苗育种
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuanmiaoyuzhong")
public class XuanmiaoyuzhongController {
    private static final Logger logger = LoggerFactory.getLogger(XuanmiaoyuzhongController.class);

    private static final String TABLE_NAME = "xuanmiaoyuzhong";

    @Autowired
    private XuanmiaoyuzhongService xuanmiaoyuzhongService;


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
    private NongshianpaiService nongshianpaiService;//农事安排
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
        PageUtils page = xuanmiaoyuzhongService.queryPage(params);

        //字典表数据转换
        List<XuanmiaoyuzhongView> list =(List<XuanmiaoyuzhongView>)page.getList();
        for(XuanmiaoyuzhongView c:list){
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
        XuanmiaoyuzhongEntity xuanmiaoyuzhong = xuanmiaoyuzhongService.selectById(id);
        if(xuanmiaoyuzhong !=null){
            //entity转view
            XuanmiaoyuzhongView view = new XuanmiaoyuzhongView();
            BeanUtils.copyProperties( xuanmiaoyuzhong , view );//把实体数据重构到view中
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
    public R save(@RequestBody XuanmiaoyuzhongEntity xuanmiaoyuzhong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuanmiaoyuzhong:{}",this.getClass().getName(),xuanmiaoyuzhong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XuanmiaoyuzhongEntity> queryWrapper = new EntityWrapper<XuanmiaoyuzhongEntity>()
            .eq("xuanmiaoyuzhong_name", xuanmiaoyuzhong.getXuanmiaoyuzhongName())
            .eq("xuanmiaoyuzhong_address", xuanmiaoyuzhong.getXuanmiaoyuzhongAddress())
            .eq("xuanmiaoyuzhong_types", xuanmiaoyuzhong.getXuanmiaoyuzhongTypes())
            .eq("xuanmiaoyuzhong_tiaoxuan_number", xuanmiaoyuzhong.getXuanmiaoyuzhongTiaoxuanNumber())
            .eq("xuanmiaoyuzhong_tiaoxuanhou_number", xuanmiaoyuzhong.getXuanmiaoyuzhongTiaoxuanhouNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanmiaoyuzhongEntity xuanmiaoyuzhongEntity = xuanmiaoyuzhongService.selectOne(queryWrapper);
        if(xuanmiaoyuzhongEntity==null){
            xuanmiaoyuzhong.setInsertTime(new Date());
            xuanmiaoyuzhong.setCreateTime(new Date());
            xuanmiaoyuzhongService.insert(xuanmiaoyuzhong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuanmiaoyuzhongEntity xuanmiaoyuzhong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuanmiaoyuzhong:{}",this.getClass().getName(),xuanmiaoyuzhong.toString());
        XuanmiaoyuzhongEntity oldXuanmiaoyuzhongEntity = xuanmiaoyuzhongService.selectById(xuanmiaoyuzhong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xuanmiaoyuzhong.getXuanmiaoyuzhongPhoto()) || "null".equals(xuanmiaoyuzhong.getXuanmiaoyuzhongPhoto())){
                xuanmiaoyuzhong.setXuanmiaoyuzhongPhoto(null);
        }
        if("".equals(xuanmiaoyuzhong.getXuanmiaoyuzhongContent()) || "null".equals(xuanmiaoyuzhong.getXuanmiaoyuzhongContent())){
                xuanmiaoyuzhong.setXuanmiaoyuzhongContent(null);
        }

            xuanmiaoyuzhongService.updateById(xuanmiaoyuzhong);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XuanmiaoyuzhongEntity> oldXuanmiaoyuzhongList =xuanmiaoyuzhongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xuanmiaoyuzhongService.deleteBatchIds(Arrays.asList(ids));

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
            List<XuanmiaoyuzhongEntity> xuanmiaoyuzhongList = new ArrayList<>();//上传的东西
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
                            XuanmiaoyuzhongEntity xuanmiaoyuzhongEntity = new XuanmiaoyuzhongEntity();
//                            xuanmiaoyuzhongEntity.setXuanmiaoyuzhongUuidNumber(data.get(0));                    //选苗育种编号 要改的
//                            xuanmiaoyuzhongEntity.setXuanmiaoyuzhongName(data.get(0));                    //选苗育种标题 要改的
//                            xuanmiaoyuzhongEntity.setXuanmiaoyuzhongPhoto("");//详情和图片
//                            xuanmiaoyuzhongEntity.setXuanmiaoyuzhongAddress(data.get(0));                    //选苗育种地点 要改的
//                            xuanmiaoyuzhongEntity.setXuanmiaoyuzhongTypes(Integer.valueOf(data.get(0)));   //选苗育种类型 要改的
//                            xuanmiaoyuzhongEntity.setXuanmiaoyuzhongTiaoxuanNumber(Integer.valueOf(data.get(0)));   //挑选数量 要改的
//                            xuanmiaoyuzhongEntity.setXuanmiaoyuzhongTiaoxuanhouNumber(Integer.valueOf(data.get(0)));   //挑选出数量 要改的
//                            xuanmiaoyuzhongEntity.setXuanmiaoyuzhongTime(sdf.parse(data.get(0)));          //挑选时间 要改的
//                            xuanmiaoyuzhongEntity.setXuanmiaoyuzhongContent("");//详情和图片
//                            xuanmiaoyuzhongEntity.setInsertTime(date);//时间
//                            xuanmiaoyuzhongEntity.setCreateTime(date);//时间
                            xuanmiaoyuzhongList.add(xuanmiaoyuzhongEntity);


                            //把要查询是否重复的字段放入map中
                                //选苗育种编号
                                if(seachFields.containsKey("xuanmiaoyuzhongUuidNumber")){
                                    List<String> xuanmiaoyuzhongUuidNumber = seachFields.get("xuanmiaoyuzhongUuidNumber");
                                    xuanmiaoyuzhongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuanmiaoyuzhongUuidNumber = new ArrayList<>();
                                    xuanmiaoyuzhongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xuanmiaoyuzhongUuidNumber",xuanmiaoyuzhongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //选苗育种编号
                        List<XuanmiaoyuzhongEntity> xuanmiaoyuzhongEntities_xuanmiaoyuzhongUuidNumber = xuanmiaoyuzhongService.selectList(new EntityWrapper<XuanmiaoyuzhongEntity>().in("xuanmiaoyuzhong_uuid_number", seachFields.get("xuanmiaoyuzhongUuidNumber")));
                        if(xuanmiaoyuzhongEntities_xuanmiaoyuzhongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuanmiaoyuzhongEntity s:xuanmiaoyuzhongEntities_xuanmiaoyuzhongUuidNumber){
                                repeatFields.add(s.getXuanmiaoyuzhongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [选苗育种编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuanmiaoyuzhongService.insertBatch(xuanmiaoyuzhongList);
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
        PageUtils page = xuanmiaoyuzhongService.queryPage(params);

        //字典表数据转换
        List<XuanmiaoyuzhongView> list =(List<XuanmiaoyuzhongView>)page.getList();
        for(XuanmiaoyuzhongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuanmiaoyuzhongEntity xuanmiaoyuzhong = xuanmiaoyuzhongService.selectById(id);
            if(xuanmiaoyuzhong !=null){


                //entity转view
                XuanmiaoyuzhongView view = new XuanmiaoyuzhongView();
                BeanUtils.copyProperties( xuanmiaoyuzhong , view );//把实体数据重构到view中

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
    public R add(@RequestBody XuanmiaoyuzhongEntity xuanmiaoyuzhong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuanmiaoyuzhong:{}",this.getClass().getName(),xuanmiaoyuzhong.toString());
        Wrapper<XuanmiaoyuzhongEntity> queryWrapper = new EntityWrapper<XuanmiaoyuzhongEntity>()
            .eq("xuanmiaoyuzhong_uuid_number", xuanmiaoyuzhong.getXuanmiaoyuzhongUuidNumber())
            .eq("xuanmiaoyuzhong_name", xuanmiaoyuzhong.getXuanmiaoyuzhongName())
            .eq("xuanmiaoyuzhong_address", xuanmiaoyuzhong.getXuanmiaoyuzhongAddress())
            .eq("xuanmiaoyuzhong_types", xuanmiaoyuzhong.getXuanmiaoyuzhongTypes())
            .eq("xuanmiaoyuzhong_tiaoxuan_number", xuanmiaoyuzhong.getXuanmiaoyuzhongTiaoxuanNumber())
            .eq("xuanmiaoyuzhong_tiaoxuanhou_number", xuanmiaoyuzhong.getXuanmiaoyuzhongTiaoxuanhouNumber())
//            .notIn("xuanmiaoyuzhong_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanmiaoyuzhongEntity xuanmiaoyuzhongEntity = xuanmiaoyuzhongService.selectOne(queryWrapper);
        if(xuanmiaoyuzhongEntity==null){
            xuanmiaoyuzhong.setInsertTime(new Date());
            xuanmiaoyuzhong.setCreateTime(new Date());
        xuanmiaoyuzhongService.insert(xuanmiaoyuzhong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

