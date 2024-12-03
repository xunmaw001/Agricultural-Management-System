package com.dao;

import com.entity.JiankongjiedianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankongjiedianView;

/**
 * 监控节点 Dao 接口
 *
 * @author 
 */
public interface JiankongjiedianDao extends BaseMapper<JiankongjiedianEntity> {

   List<JiankongjiedianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
