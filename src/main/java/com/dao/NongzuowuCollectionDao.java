package com.dao;

import com.entity.NongzuowuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongzuowuCollectionView;

/**
 * 农作物收藏 Dao 接口
 *
 * @author 
 */
public interface NongzuowuCollectionDao extends BaseMapper<NongzuowuCollectionEntity> {

   List<NongzuowuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
