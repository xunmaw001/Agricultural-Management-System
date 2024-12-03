package com.dao;

import com.entity.QixiangshujuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QixiangshujuCollectionView;

/**
 * 气象数据收藏 Dao 接口
 *
 * @author 
 */
public interface QixiangshujuCollectionDao extends BaseMapper<QixiangshujuCollectionEntity> {

   List<QixiangshujuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
