
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
 * 监控节点
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiankongjiedian")
public class JiankongjiedianController {
    private static final Logger logger = LoggerFactory.getLogger(JiankongjiedianController.class);

    private static final String TABLE_NAME = "jiankongjiedian";

    @Autowired
    private JiankongjiedianService jiankongjiedianService;


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
        PageUtils page = jiankongjiedianService.queryPage(params);

        //字典表数据转换
        List<JiankongjiedianView> list =(List<JiankongjiedianView>)page.getList();
        for(JiankongjiedianView c:list){
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
        JiankongjiedianEntity jiankongjiedian = jiankongjiedianService.selectById(id);
        if(jiankongjiedian !=null){
            //entity转view
            JiankongjiedianView view = new JiankongjiedianView();
            BeanUtils.copyProperties( jiankongjiedian , view );//把实体数据重构到view中
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
    public R save(@RequestBody JiankongjiedianEntity jiankongjiedian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiankongjiedian:{}",this.getClass().getName(),jiankongjiedian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiankongjiedianEntity> queryWrapper = new EntityWrapper<JiankongjiedianEntity>()
            .eq("jiankongjiedian_name", jiankongjiedian.getJiankongjiedianName())
            .eq("jiankongjiedian_address", jiankongjiedian.getJiankongjiedianAddress())
            .eq("jiankongjiedian_types", jiankongjiedian.getJiankongjiedianTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankongjiedianEntity jiankongjiedianEntity = jiankongjiedianService.selectOne(queryWrapper);
        if(jiankongjiedianEntity==null){
            jiankongjiedian.setInsertTime(new Date());
            jiankongjiedian.setCreateTime(new Date());
            jiankongjiedianService.insert(jiankongjiedian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiankongjiedianEntity jiankongjiedian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiankongjiedian:{}",this.getClass().getName(),jiankongjiedian.toString());
        JiankongjiedianEntity oldJiankongjiedianEntity = jiankongjiedianService.selectById(jiankongjiedian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jiankongjiedian.getJiankongjiedianPhoto()) || "null".equals(jiankongjiedian.getJiankongjiedianPhoto())){
                jiankongjiedian.setJiankongjiedianPhoto(null);
        }
        if("".equals(jiankongjiedian.getJiankongjiedianContent()) || "null".equals(jiankongjiedian.getJiankongjiedianContent())){
                jiankongjiedian.setJiankongjiedianContent(null);
        }

            jiankongjiedianService.updateById(jiankongjiedian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiankongjiedianEntity> oldJiankongjiedianList =jiankongjiedianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiankongjiedianService.deleteBatchIds(Arrays.asList(ids));

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
            List<JiankongjiedianEntity> jiankongjiedianList = new ArrayList<>();//上传的东西
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
                            JiankongjiedianEntity jiankongjiedianEntity = new JiankongjiedianEntity();
//                            jiankongjiedianEntity.setJiankongjiedianUuidNumber(data.get(0));                    //监控节点编号 要改的
//                            jiankongjiedianEntity.setJiankongjiedianName(data.get(0));                    //监控节点名称 要改的
//                            jiankongjiedianEntity.setJiankongjiedianPhoto("");//详情和图片
//                            jiankongjiedianEntity.setJiankongjiedianAddress(data.get(0));                    //监控位置 要改的
//                            jiankongjiedianEntity.setJiankongjiedianTypes(Integer.valueOf(data.get(0)));   //监控节点类型 要改的
//                            jiankongjiedianEntity.setJiankongjiedianContent("");//详情和图片
//                            jiankongjiedianEntity.setInsertTime(date);//时间
//                            jiankongjiedianEntity.setCreateTime(date);//时间
                            jiankongjiedianList.add(jiankongjiedianEntity);


                            //把要查询是否重复的字段放入map中
                                //监控节点编号
                                if(seachFields.containsKey("jiankongjiedianUuidNumber")){
                                    List<String> jiankongjiedianUuidNumber = seachFields.get("jiankongjiedianUuidNumber");
                                    jiankongjiedianUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiankongjiedianUuidNumber = new ArrayList<>();
                                    jiankongjiedianUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiankongjiedianUuidNumber",jiankongjiedianUuidNumber);
                                }
                        }

                        //查询是否重复
                         //监控节点编号
                        List<JiankongjiedianEntity> jiankongjiedianEntities_jiankongjiedianUuidNumber = jiankongjiedianService.selectList(new EntityWrapper<JiankongjiedianEntity>().in("jiankongjiedian_uuid_number", seachFields.get("jiankongjiedianUuidNumber")));
                        if(jiankongjiedianEntities_jiankongjiedianUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiankongjiedianEntity s:jiankongjiedianEntities_jiankongjiedianUuidNumber){
                                repeatFields.add(s.getJiankongjiedianUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [监控节点编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiankongjiedianService.insertBatch(jiankongjiedianList);
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
        PageUtils page = jiankongjiedianService.queryPage(params);

        //字典表数据转换
        List<JiankongjiedianView> list =(List<JiankongjiedianView>)page.getList();
        for(JiankongjiedianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiankongjiedianEntity jiankongjiedian = jiankongjiedianService.selectById(id);
            if(jiankongjiedian !=null){


                //entity转view
                JiankongjiedianView view = new JiankongjiedianView();
                BeanUtils.copyProperties( jiankongjiedian , view );//把实体数据重构到view中

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
    public R add(@RequestBody JiankongjiedianEntity jiankongjiedian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiankongjiedian:{}",this.getClass().getName(),jiankongjiedian.toString());
        Wrapper<JiankongjiedianEntity> queryWrapper = new EntityWrapper<JiankongjiedianEntity>()
            .eq("jiankongjiedian_uuid_number", jiankongjiedian.getJiankongjiedianUuidNumber())
            .eq("jiankongjiedian_name", jiankongjiedian.getJiankongjiedianName())
            .eq("jiankongjiedian_address", jiankongjiedian.getJiankongjiedianAddress())
            .eq("jiankongjiedian_types", jiankongjiedian.getJiankongjiedianTypes())
//            .notIn("jiankongjiedian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankongjiedianEntity jiankongjiedianEntity = jiankongjiedianService.selectOne(queryWrapper);
        if(jiankongjiedianEntity==null){
            jiankongjiedian.setInsertTime(new Date());
            jiankongjiedian.setCreateTime(new Date());
        jiankongjiedianService.insert(jiankongjiedian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

