
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
 * 土地留言
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tudiLiuyan")
public class TudiLiuyanController {
    private static final Logger logger = LoggerFactory.getLogger(TudiLiuyanController.class);

    private static final String TABLE_NAME = "tudiLiuyan";

    @Autowired
    private TudiLiuyanService tudiLiuyanService;


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
        PageUtils page = tudiLiuyanService.queryPage(params);

        //字典表数据转换
        List<TudiLiuyanView> list =(List<TudiLiuyanView>)page.getList();
        for(TudiLiuyanView c:list){
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
        TudiLiuyanEntity tudiLiuyan = tudiLiuyanService.selectById(id);
        if(tudiLiuyan !=null){
            //entity转view
            TudiLiuyanView view = new TudiLiuyanView();
            BeanUtils.copyProperties( tudiLiuyan , view );//把实体数据重构到view中
            //级联表 土地规划
            //级联表
            TudiEntity tudi = tudiService.selectById(tudiLiuyan.getTudiId());
            if(tudi != null){
            BeanUtils.copyProperties( tudi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setTudiId(tudi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(tudiLiuyan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody TudiLiuyanEntity tudiLiuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tudiLiuyan:{}",this.getClass().getName(),tudiLiuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            tudiLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        tudiLiuyan.setCreateTime(new Date());
        tudiLiuyan.setInsertTime(new Date());
        tudiLiuyanService.insert(tudiLiuyan);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TudiLiuyanEntity tudiLiuyan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tudiLiuyan:{}",this.getClass().getName(),tudiLiuyan.toString());
        TudiLiuyanEntity oldTudiLiuyanEntity = tudiLiuyanService.selectById(tudiLiuyan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            tudiLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(tudiLiuyan.getTudiLiuyanText()) || "null".equals(tudiLiuyan.getTudiLiuyanText())){
                tudiLiuyan.setTudiLiuyanText(null);
        }
        if("".equals(tudiLiuyan.getReplyText()) || "null".equals(tudiLiuyan.getReplyText())){
                tudiLiuyan.setReplyText(null);
        }
        tudiLiuyan.setUpdateTime(new Date());

            tudiLiuyanService.updateById(tudiLiuyan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TudiLiuyanEntity> oldTudiLiuyanList =tudiLiuyanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        tudiLiuyanService.deleteBatchIds(Arrays.asList(ids));

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
            List<TudiLiuyanEntity> tudiLiuyanList = new ArrayList<>();//上传的东西
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
                            TudiLiuyanEntity tudiLiuyanEntity = new TudiLiuyanEntity();
//                            tudiLiuyanEntity.setTudiId(Integer.valueOf(data.get(0)));   //土地 要改的
//                            tudiLiuyanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            tudiLiuyanEntity.setTudiLiuyanText(data.get(0));                    //留言内容 要改的
//                            tudiLiuyanEntity.setInsertTime(date);//时间
//                            tudiLiuyanEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            tudiLiuyanEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            tudiLiuyanEntity.setCreateTime(date);//时间
                            tudiLiuyanList.add(tudiLiuyanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        tudiLiuyanService.insertBatch(tudiLiuyanList);
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
        PageUtils page = tudiLiuyanService.queryPage(params);

        //字典表数据转换
        List<TudiLiuyanView> list =(List<TudiLiuyanView>)page.getList();
        for(TudiLiuyanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TudiLiuyanEntity tudiLiuyan = tudiLiuyanService.selectById(id);
            if(tudiLiuyan !=null){


                //entity转view
                TudiLiuyanView view = new TudiLiuyanView();
                BeanUtils.copyProperties( tudiLiuyan , view );//把实体数据重构到view中

                //级联表
                    TudiEntity tudi = tudiService.selectById(tudiLiuyan.getTudiId());
                if(tudi != null){
                    BeanUtils.copyProperties( tudi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTudiId(tudi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(tudiLiuyan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody TudiLiuyanEntity tudiLiuyan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tudiLiuyan:{}",this.getClass().getName(),tudiLiuyan.toString());
        tudiLiuyan.setCreateTime(new Date());
        tudiLiuyan.setInsertTime(new Date());
        tudiLiuyanService.insert(tudiLiuyan);

            return R.ok();
        }

}

