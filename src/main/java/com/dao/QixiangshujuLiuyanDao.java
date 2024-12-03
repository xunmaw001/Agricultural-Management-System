package com.dao;

import com.entity.QixiangshujuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QixiangshujuLiuyanView;

/**
 * 气象数据留言 Dao 接口
 *
 * @author 
 */
public interface QixiangshujuLiuyanDao extends BaseMapper<QixiangshujuLiuyanEntity> {

   List<QixiangshujuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
