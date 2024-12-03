
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
 * 农作物
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nongzuowu")
public class NongzuowuController {
    private static final Logger logger = LoggerFactory.getLogger(NongzuowuController.class);

    private static final String TABLE_NAME = "nongzuowu";

    @Autowired
    private NongzuowuService nongzuowuService;


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
        PageUtils page = nongzuowuService.queryPage(params);

        //字典表数据转换
        List<NongzuowuView> list =(List<NongzuowuView>)page.getList();
        for(NongzuowuView c:list){
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
        NongzuowuEntity nongzuowu = nongzuowuService.selectById(id);
        if(nongzuowu !=null){
            //entity转view
            NongzuowuView view = new NongzuowuView();
            BeanUtils.copyProperties( nongzuowu , view );//把实体数据重构到view中
            //级联表 土地规划
            //级联表
            TudiEntity tudi = tudiService.selectById(nongzuowu.getTudiId());
            if(tudi != null){
            BeanUtils.copyProperties( tudi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setTudiId(tudi.getId());
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
    public R save(@RequestBody NongzuowuEntity nongzuowu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nongzuowu:{}",this.getClass().getName(),nongzuowu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<NongzuowuEntity> queryWrapper = new EntityWrapper<NongzuowuEntity>()
            .eq("tudi_id", nongzuowu.getTudiId())
            .eq("nongzuowu_name", nongzuowu.getNongzuowuName())
            .eq("zan_number", nongzuowu.getZanNumber())
            .eq("cai_number", nongzuowu.getCaiNumber())
            .eq("nongzuowu_types", nongzuowu.getNongzuowuTypes())
            .eq("nongzuowu_kucun_number", nongzuowu.getNongzuowuKucunNumber())
            .eq("shangxia_types", nongzuowu.getShangxiaTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongzuowuEntity nongzuowuEntity = nongzuowuService.selectOne(queryWrapper);
        if(nongzuowuEntity==null){
            nongzuowu.setZanNumber(1);
            nongzuowu.setCaiNumber(1);
            nongzuowu.setNongzuowuClicknum(1);
            nongzuowu.setShangxiaTypes(1);
            nongzuowu.setInsertTime(new Date());
            nongzuowu.setCreateTime(new Date());
            nongzuowuService.insert(nongzuowu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NongzuowuEntity nongzuowu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nongzuowu:{}",this.getClass().getName(),nongzuowu.toString());
        NongzuowuEntity oldNongzuowuEntity = nongzuowuService.selectById(nongzuowu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(nongzuowu.getNongzuowuPhoto()) || "null".equals(nongzuowu.getNongzuowuPhoto())){
                nongzuowu.setNongzuowuPhoto(null);
        }
        if("".equals(nongzuowu.getNongzuowuContent()) || "null".equals(nongzuowu.getNongzuowuContent())){
                nongzuowu.setNongzuowuContent(null);
        }

            nongzuowuService.updateById(nongzuowu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NongzuowuEntity> oldNongzuowuList =nongzuowuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        nongzuowuService.deleteBatchIds(Arrays.asList(ids));

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
            List<NongzuowuEntity> nongzuowuList = new ArrayList<>();//上传的东西
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
                            NongzuowuEntity nongzuowuEntity = new NongzuowuEntity();
//                            nongzuowuEntity.setTudiId(Integer.valueOf(data.get(0)));   //土地 要改的
//                            nongzuowuEntity.setNongzuowuUuidNumber(data.get(0));                    //农作物编号 要改的
//                            nongzuowuEntity.setNongzuowuName(data.get(0));                    //农作物名称 要改的
//                            nongzuowuEntity.setNongzuowuPhoto("");//详情和图片
//                            nongzuowuEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            nongzuowuEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            nongzuowuEntity.setNongzuowuTypes(Integer.valueOf(data.get(0)));   //农作物类型 要改的
//                            nongzuowuEntity.setNongzuowuKucunNumber(Integer.valueOf(data.get(0)));   //种植数量 要改的
//                            nongzuowuEntity.setNongzuowuClicknum(Integer.valueOf(data.get(0)));   //农作物热度 要改的
//                            nongzuowuEntity.setNongzuowuKaishiTime(sdf.parse(data.get(0)));          //种植开始时间 要改的
//                            nongzuowuEntity.setNongzuowuYujijieshuTime(sdf.parse(data.get(0)));          //种植预计结束时间 要改的
//                            nongzuowuEntity.setNongzuowuContent("");//详情和图片
//                            nongzuowuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            nongzuowuEntity.setInsertTime(date);//时间
//                            nongzuowuEntity.setCreateTime(date);//时间
                            nongzuowuList.add(nongzuowuEntity);


                            //把要查询是否重复的字段放入map中
                                //农作物编号
                                if(seachFields.containsKey("nongzuowuUuidNumber")){
                                    List<String> nongzuowuUuidNumber = seachFields.get("nongzuowuUuidNumber");
                                    nongzuowuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> nongzuowuUuidNumber = new ArrayList<>();
                                    nongzuowuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("nongzuowuUuidNumber",nongzuowuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //农作物编号
                        List<NongzuowuEntity> nongzuowuEntities_nongzuowuUuidNumber = nongzuowuService.selectList(new EntityWrapper<NongzuowuEntity>().in("nongzuowu_uuid_number", seachFields.get("nongzuowuUuidNumber")));
                        if(nongzuowuEntities_nongzuowuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NongzuowuEntity s:nongzuowuEntities_nongzuowuUuidNumber){
                                repeatFields.add(s.getNongzuowuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [农作物编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        nongzuowuService.insertBatch(nongzuowuList);
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
        List<NongzuowuView> returnNongzuowuViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("nongzuowuYesnoTypes",2);
        PageUtils pageUtils = nongzuowuCollectionService.queryPage(params1);
        List<NongzuowuCollectionView> collectionViewsList =(List<NongzuowuCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(NongzuowuCollectionView collectionView:collectionViewsList){
            Integer nongzuowuTypes = collectionView.getNongzuowuTypes();
            if(typeMap.containsKey(nongzuowuTypes)){
                typeMap.put(nongzuowuTypes,typeMap.get(nongzuowuTypes)+1);
            }else{
                typeMap.put(nongzuowuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("nongzuowuTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("nongzuowuYesnoTypes",2);
            PageUtils pageUtils1 = nongzuowuService.queryPage(params2);
            List<NongzuowuView> nongzuowuViewList =(List<NongzuowuView>)pageUtils1.getList();
            returnNongzuowuViewList.addAll(nongzuowuViewList);
            if(returnNongzuowuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("nongzuowuYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = nongzuowuService.queryPage(params);
        if(returnNongzuowuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnNongzuowuViewList.size();//要添加的数量
            List<NongzuowuView> nongzuowuViewList =(List<NongzuowuView>)page.getList();
            for(NongzuowuView nongzuowuView:nongzuowuViewList){
                Boolean addFlag = true;
                for(NongzuowuView returnNongzuowuView:returnNongzuowuViewList){
                    if(returnNongzuowuView.getId().intValue() ==nongzuowuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnNongzuowuViewList.add(nongzuowuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnNongzuowuViewList = returnNongzuowuViewList.subList(0, limit);
        }

        for(NongzuowuView c:returnNongzuowuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnNongzuowuViewList);
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
        PageUtils page = nongzuowuService.queryPage(params);

        //字典表数据转换
        List<NongzuowuView> list =(List<NongzuowuView>)page.getList();
        for(NongzuowuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongzuowuEntity nongzuowu = nongzuowuService.selectById(id);
            if(nongzuowu !=null){

                //点击数量加1
                nongzuowu.setNongzuowuClicknum(nongzuowu.getNongzuowuClicknum()+1);
                nongzuowuService.updateById(nongzuowu);

                //entity转view
                NongzuowuView view = new NongzuowuView();
                BeanUtils.copyProperties( nongzuowu , view );//把实体数据重构到view中

                //级联表
                    TudiEntity tudi = tudiService.selectById(nongzuowu.getTudiId());
                if(tudi != null){
                    BeanUtils.copyProperties( tudi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTudiId(tudi.getId());
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
    public R add(@RequestBody NongzuowuEntity nongzuowu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nongzuowu:{}",this.getClass().getName(),nongzuowu.toString());
        Wrapper<NongzuowuEntity> queryWrapper = new EntityWrapper<NongzuowuEntity>()
            .eq("tudi_id", nongzuowu.getTudiId())
            .eq("nongzuowu_uuid_number", nongzuowu.getNongzuowuUuidNumber())
            .eq("nongzuowu_name", nongzuowu.getNongzuowuName())
            .eq("zan_number", nongzuowu.getZanNumber())
            .eq("cai_number", nongzuowu.getCaiNumber())
            .eq("nongzuowu_types", nongzuowu.getNongzuowuTypes())
            .eq("nongzuowu_kucun_number", nongzuowu.getNongzuowuKucunNumber())
            .eq("nongzuowu_clicknum", nongzuowu.getNongzuowuClicknum())
            .eq("shangxia_types", nongzuowu.getShangxiaTypes())
//            .notIn("nongzuowu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongzuowuEntity nongzuowuEntity = nongzuowuService.selectOne(queryWrapper);
        if(nongzuowuEntity==null){
                nongzuowu.setZanNumber(1);
                nongzuowu.setCaiNumber(1);
            nongzuowu.setNongzuowuClicknum(1);
            nongzuowu.setInsertTime(new Date());
            nongzuowu.setCreateTime(new Date());
        nongzuowuService.insert(nongzuowu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

