package com.dao;

import com.entity.NongshianpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongshianpaiView;

/**
 * 农事安排 Dao 接口
 *
 * @author 
 */
public interface NongshianpaiDao extends BaseMapper<NongshianpaiEntity> {

   List<NongshianpaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
