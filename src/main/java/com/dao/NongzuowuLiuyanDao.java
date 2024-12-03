package com.dao;

import com.entity.NongzuowuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongzuowuLiuyanView;

/**
 * 农作物留言 Dao 接口
 *
 * @author 
 */
public interface NongzuowuLiuyanDao extends BaseMapper<NongzuowuLiuyanEntity> {

   List<NongzuowuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
