package com.dao;

import com.entity.NongzuowuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongzuowuView;

/**
 * 农作物 Dao 接口
 *
 * @author 
 */
public interface NongzuowuDao extends BaseMapper<NongzuowuEntity> {

   List<NongzuowuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
