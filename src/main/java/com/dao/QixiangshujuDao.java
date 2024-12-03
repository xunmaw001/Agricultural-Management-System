package com.dao;

import com.entity.QixiangshujuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QixiangshujuView;

/**
 * 气象数据 Dao 接口
 *
 * @author 
 */
public interface QixiangshujuDao extends BaseMapper<QixiangshujuEntity> {

   List<QixiangshujuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
