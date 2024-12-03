package com.dao;

import com.entity.JiankongjiedianJiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankongjiedianJiluView;

/**
 * 监控记录 Dao 接口
 *
 * @author 
 */
public interface JiankongjiedianJiluDao extends BaseMapper<JiankongjiedianJiluEntity> {

   List<JiankongjiedianJiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
