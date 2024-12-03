package com.dao;

import com.entity.XuanmiaoyuzhongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuanmiaoyuzhongView;

/**
 * 选苗育种 Dao 接口
 *
 * @author 
 */
public interface XuanmiaoyuzhongDao extends BaseMapper<XuanmiaoyuzhongEntity> {

   List<XuanmiaoyuzhongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
