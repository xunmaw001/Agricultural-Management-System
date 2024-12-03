
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
 * 气象数据
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qixiangshuju")
public class QixiangshujuController {
    private static final Logger logger = LoggerFactory.getLogger(QixiangshujuController.class);

    private static final String TABLE_NAME = "qixiangshuju";

    @Autowired
    private QixiangshujuService qixiangshujuService;


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
        PageUtils page = qixiangshujuService.queryPage(params);

        //字典表数据转换
        List<QixiangshujuView> list =(List<QixiangshujuView>)page.getList();
        for(QixiangshujuView c:list){
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
        QixiangshujuEntity qixiangshuju = qixiangshujuService.selectById(id);
        if(qixiangshuju !=null){
            //entity转view
            QixiangshujuView view = new QixiangshujuView();
            BeanUtils.copyProperties( qixiangshuju , view );//把实体数据重构到view中
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
    public R save(@RequestBody QixiangshujuEntity qixiangshuju, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qixiangshuju:{}",this.getClass().getName(),qixiangshuju.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<QixiangshujuEntity> queryWrapper = new EntityWrapper<QixiangshujuEntity>()
            .eq("qixiangshuju_name", qixiangshuju.getQixiangshujuName())
            .eq("qixiangshuju_address", qixiangshuju.getQixiangshujuAddress())
            .eq("zan_number", qixiangshuju.getZanNumber())
            .eq("cai_number", qixiangshuju.getCaiNumber())
            .eq("qixiangshuju_types", qixiangshuju.getQixiangshujuTypes())
            .eq("shangxia_types", qixiangshuju.getShangxiaTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QixiangshujuEntity qixiangshujuEntity = qixiangshujuService.selectOne(queryWrapper);
        if(qixiangshujuEntity==null){
            qixiangshuju.setZanNumber(1);
            qixiangshuju.setCaiNumber(1);
            qixiangshuju.setQixiangshujuClicknum(1);
            qixiangshuju.setShangxiaTypes(1);
            qixiangshuju.setInsertTime(new Date());
            qixiangshuju.setCreateTime(new Date());
            qixiangshujuService.insert(qixiangshuju);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QixiangshujuEntity qixiangshuju, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qixiangshuju:{}",this.getClass().getName(),qixiangshuju.toString());
        QixiangshujuEntity oldQixiangshujuEntity = qixiangshujuService.selectById(qixiangshuju.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(qixiangshuju.getQixiangshujuPhoto()) || "null".equals(qixiangshuju.getQixiangshujuPhoto())){
                qixiangshuju.setQixiangshujuPhoto(null);
        }
        if("".equals(qixiangshuju.getQixiangshujuContent()) || "null".equals(qixiangshuju.getQixiangshujuContent())){
                qixiangshuju.setQixiangshujuContent(null);
        }

            qixiangshujuService.updateById(qixiangshuju);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<QixiangshujuEntity> oldQixiangshujuList =qixiangshujuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        qixiangshujuService.deleteBatchIds(Arrays.asList(ids));

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
            List<QixiangshujuEntity> qixiangshujuList = new ArrayList<>();//上传的东西
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
                            QixiangshujuEntity qixiangshujuEntity = new QixiangshujuEntity();
//                            qixiangshujuEntity.setQixiangshujuName(data.get(0));                    //气象数据标题 要改的
//                            qixiangshujuEntity.setQixiangshujuUuidNumber(data.get(0));                    //气象数据编号 要改的
//                            qixiangshujuEntity.setQixiangshujuPhoto("");//详情和图片
//                            qixiangshujuEntity.setQixiangshujuAddress(data.get(0));                    //气象地址 要改的
//                            qixiangshujuEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            qixiangshujuEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            qixiangshujuEntity.setQixiangshujuTypes(Integer.valueOf(data.get(0)));   //气象类型 要改的
//                            qixiangshujuEntity.setQixiangshujuDaZhi(data.get(0));                    //气象值(大) 要改的
//                            qixiangshujuEntity.setQixiangshujuXiaoZhi(data.get(0));                    //气象值(小) 要改的
//                            qixiangshujuEntity.setQixiangshujuClicknum(Integer.valueOf(data.get(0)));   //气象热度 要改的
//                            qixiangshujuEntity.setQixiangshujuTime(sdf.parse(data.get(0)));          //所属时间 要改的
//                            qixiangshujuEntity.setQixiangshujuContent("");//详情和图片
//                            qixiangshujuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            qixiangshujuEntity.setInsertTime(date);//时间
//                            qixiangshujuEntity.setCreateTime(date);//时间
                            qixiangshujuList.add(qixiangshujuEntity);


                            //把要查询是否重复的字段放入map中
                                //气象数据编号
                                if(seachFields.containsKey("qixiangshujuUuidNumber")){
                                    List<String> qixiangshujuUuidNumber = seachFields.get("qixiangshujuUuidNumber");
                                    qixiangshujuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qixiangshujuUuidNumber = new ArrayList<>();
                                    qixiangshujuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qixiangshujuUuidNumber",qixiangshujuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //气象数据编号
                        List<QixiangshujuEntity> qixiangshujuEntities_qixiangshujuUuidNumber = qixiangshujuService.selectList(new EntityWrapper<QixiangshujuEntity>().in("qixiangshuju_uuid_number", seachFields.get("qixiangshujuUuidNumber")));
                        if(qixiangshujuEntities_qixiangshujuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QixiangshujuEntity s:qixiangshujuEntities_qixiangshujuUuidNumber){
                                repeatFields.add(s.getQixiangshujuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [气象数据编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qixiangshujuService.insertBatch(qixiangshujuList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<QixiangshujuView> returnQixiangshujuViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("qixiangshujuYesnoTypes",2);
        PageUtils pageUtils = qixiangshujuCollectionService.queryPage(params1);
        List<QixiangshujuCollectionView> collectionViewsList =(List<QixiangshujuCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(QixiangshujuCollectionView collectionView:collectionViewsList){
            Integer qixiangshujuTypes = collectionView.getQixiangshujuTypes();
            if(typeMap.containsKey(qixiangshujuTypes)){
                typeMap.put(qixiangshujuTypes,typeMap.get(qixiangshujuTypes)+1);
            }else{
                typeMap.put(qixiangshujuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("qixiangshujuTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("qixiangshujuYesnoTypes",2);
            PageUtils pageUtils1 = qixiangshujuService.queryPage(params2);
            List<QixiangshujuView> qixiangshujuViewList =(List<QixiangshujuView>)pageUtils1.getList();
            returnQixiangshujuViewList.addAll(qixiangshujuViewList);
            if(returnQixiangshujuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("qixiangshujuYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = qixiangshujuService.queryPage(params);
        if(returnQixiangshujuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnQixiangshujuViewList.size();//要添加的数量
            List<QixiangshujuView> qixiangshujuViewList =(List<QixiangshujuView>)page.getList();
            for(QixiangshujuView qixiangshujuView:qixiangshujuViewList){
                Boolean addFlag = true;
                for(QixiangshujuView returnQixiangshujuView:returnQixiangshujuViewList){
                    if(returnQixiangshujuView.getId().intValue() ==qixiangshujuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnQixiangshujuViewList.add(qixiangshujuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnQixiangshujuViewList = returnQixiangshujuViewList.subList(0, limit);
        }

        for(QixiangshujuView c:returnQixiangshujuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnQixiangshujuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = qixiangshujuService.queryPage(params);

        //字典表数据转换
        List<QixiangshujuView> list =(List<QixiangshujuView>)page.getList();
        for(QixiangshujuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QixiangshujuEntity qixiangshuju = qixiangshujuService.selectById(id);
            if(qixiangshuju !=null){

                //点击数量加1
                qixiangshuju.setQixiangshujuClicknum(qixiangshuju.getQixiangshujuClicknum()+1);
                qixiangshujuService.updateById(qixiangshuju);

                //entity转view
                QixiangshujuView view = new QixiangshujuView();
                BeanUtils.copyProperties( qixiangshuju , view );//把实体数据重构到view中

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
    public R add(@RequestBody QixiangshujuEntity qixiangshuju, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qixiangshuju:{}",this.getClass().getName(),qixiangshuju.toString());
        Wrapper<QixiangshujuEntity> queryWrapper = new EntityWrapper<QixiangshujuEntity>()
            .eq("qixiangshuju_name", qixiangshuju.getQixiangshujuName())
            .eq("qixiangshuju_uuid_number", qixiangshuju.getQixiangshujuUuidNumber())
            .eq("qixiangshuju_address", qixiangshuju.getQixiangshujuAddress())
            .eq("zan_number", qixiangshuju.getZanNumber())
            .eq("cai_number", qixiangshuju.getCaiNumber())
            .eq("qixiangshuju_types", qixiangshuju.getQixiangshujuTypes())
            .eq("qixiangshuju_clicknum", qixiangshuju.getQixiangshujuClicknum())
            .eq("shangxia_types", qixiangshuju.getShangxiaTypes())
//            .notIn("qixiangshuju_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QixiangshujuEntity qixiangshujuEntity = qixiangshujuService.selectOne(queryWrapper);
        if(qixiangshujuEntity==null){
                qixiangshuju.setZanNumber(1);
                qixiangshuju.setCaiNumber(1);
            qixiangshuju.setQixiangshujuClicknum(1);
            qixiangshuju.setInsertTime(new Date());
            qixiangshuju.setCreateTime(new Date());
        qixiangshujuService.insert(qixiangshuju);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

