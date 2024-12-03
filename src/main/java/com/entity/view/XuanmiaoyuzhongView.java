package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XuanmiaoyuzhongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 选苗育种
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xuanmiaoyuzhong")
public class XuanmiaoyuzhongView extends XuanmiaoyuzhongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 选苗育种类型的值
	*/
	@ColumnInfo(comment="选苗育种类型的字典表值",type="varchar(200)")
	private String xuanmiaoyuzhongValue;




	public XuanmiaoyuzhongView() {

	}

	public XuanmiaoyuzhongView(XuanmiaoyuzhongEntity xuanmiaoyuzhongEntity) {
		try {
			BeanUtils.copyProperties(this, xuanmiaoyuzhongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 选苗育种类型的值
	*/
	public String getXuanmiaoyuzhongValue() {
		return xuanmiaoyuzhongValue;
	}
	/**
	* 设置： 选苗育种类型的值
	*/
	public void setXuanmiaoyuzhongValue(String xuanmiaoyuzhongValue) {
		this.xuanmiaoyuzhongValue = xuanmiaoyuzhongValue;
	}




	@Override
	public String toString() {
		return "XuanmiaoyuzhongView{" +
			", xuanmiaoyuzhongValue=" + xuanmiaoyuzhongValue +
			"} " + super.toString();
	}
}
