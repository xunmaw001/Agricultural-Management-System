package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiankongjiedianEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 监控节点
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiankongjiedian")
public class JiankongjiedianView extends JiankongjiedianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 监控节点类型的值
	*/
	@ColumnInfo(comment="监控节点类型的字典表值",type="varchar(200)")
	private String jiankongjiedianValue;




	public JiankongjiedianView() {

	}

	public JiankongjiedianView(JiankongjiedianEntity jiankongjiedianEntity) {
		try {
			BeanUtils.copyProperties(this, jiankongjiedianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 监控节点类型的值
	*/
	public String getJiankongjiedianValue() {
		return jiankongjiedianValue;
	}
	/**
	* 设置： 监控节点类型的值
	*/
	public void setJiankongjiedianValue(String jiankongjiedianValue) {
		this.jiankongjiedianValue = jiankongjiedianValue;
	}




	@Override
	public String toString() {
		return "JiankongjiedianView{" +
			", jiankongjiedianValue=" + jiankongjiedianValue +
			"} " + super.toString();
	}
}
