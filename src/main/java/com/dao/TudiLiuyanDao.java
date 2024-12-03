package com.dao;

import com.entity.TudiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TudiLiuyanView;

/**
 * 土地留言 Dao 接口
 *
 * @author 
 */
public interface TudiLiuyanDao extends BaseMapper<TudiLiuyanEntity> {

   List<TudiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
