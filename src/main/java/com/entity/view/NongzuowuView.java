package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongzuowuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农作物
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongzuowu")
public class NongzuowuView extends NongzuowuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 农作物类型的值
	*/
	@ColumnInfo(comment="农作物类型的字典表值",type="varchar(200)")
	private String nongzuowuValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;

	//级联表 土地规划
		/**
		* 土地名称
		*/

		@ColumnInfo(comment="土地名称",type="varchar(200)")
		private String tudiName;
		/**
		* 土地编号
		*/

		@ColumnInfo(comment="土地编号",type="varchar(200)")
		private String tudiUuidNumber;
		/**
		* 土地照片
		*/

		@ColumnInfo(comment="土地照片",type="varchar(200)")
		private String tudiPhoto;
		/**
		* 土地位置
		*/

		@ColumnInfo(comment="土地位置",type="varchar(200)")
		private String tudiAddress;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 土地类型
		*/
		@ColumnInfo(comment="土地类型",type="int(11)")
		private Integer tudiTypes;
			/**
			* 土地类型的值
			*/
			@ColumnInfo(comment="土地类型的字典表值",type="varchar(200)")
			private String tudiValue;
		/**
		* 土地面积(平方)
		*/

		@ColumnInfo(comment="土地面积(平方)",type="int(11)")
		private Integer tudiMianji;
		/**
		* 土地热度
		*/

		@ColumnInfo(comment="土地热度",type="int(11)")
		private Integer tudiClicknum;
		/**
		* 规划时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="规划时间",type="timestamp")
		private Date tudiTime;
		/**
		* 土地备注
		*/

		@ColumnInfo(comment="土地备注",type="longtext")
		private String tudiContent;

	//重复字段


	public NongzuowuView() {

	}

	public NongzuowuView(NongzuowuEntity nongzuowuEntity) {
		try {
			BeanUtils.copyProperties(this, nongzuowuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 农作物类型的值
	*/
	public String getNongzuowuValue() {
		return nongzuowuValue;
	}
	/**
	* 设置： 农作物类型的值
	*/
	public void setNongzuowuValue(String nongzuowuValue) {
		this.nongzuowuValue = nongzuowuValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}


	//级联表的get和set 土地规划

		/**
		* 获取： 土地名称
		*/
		public String getTudiName() {
			return tudiName;
		}
		/**
		* 设置： 土地名称
		*/
		public void setTudiName(String tudiName) {
			this.tudiName = tudiName;
		}

		/**
		* 获取： 土地编号
		*/
		public String getTudiUuidNumber() {
			return tudiUuidNumber;
		}
		/**
		* 设置： 土地编号
		*/
		public void setTudiUuidNumber(String tudiUuidNumber) {
			this.tudiUuidNumber = tudiUuidNumber;
		}

		/**
		* 获取： 土地照片
		*/
		public String getTudiPhoto() {
			return tudiPhoto;
		}
		/**
		* 设置： 土地照片
		*/
		public void setTudiPhoto(String tudiPhoto) {
			this.tudiPhoto = tudiPhoto;
		}

		/**
		* 获取： 土地位置
		*/
		public String getTudiAddress() {
			return tudiAddress;
		}
		/**
		* 设置： 土地位置
		*/
		public void setTudiAddress(String tudiAddress) {
			this.tudiAddress = tudiAddress;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 土地类型
		*/
		public Integer getTudiTypes() {
			return tudiTypes;
		}
		/**
		* 设置： 土地类型
		*/
		public void setTudiTypes(Integer tudiTypes) {
			this.tudiTypes = tudiTypes;
		}


			/**
			* 获取： 土地类型的值
			*/
			public String getTudiValue() {
				return tudiValue;
			}
			/**
			* 设置： 土地类型的值
			*/
			public void setTudiValue(String tudiValue) {
				this.tudiValue = tudiValue;
			}

		/**
		* 获取： 土地面积(平方)
		*/
		public Integer getTudiMianji() {
			return tudiMianji;
		}
		/**
		* 设置： 土地面积(平方)
		*/
		public void setTudiMianji(Integer tudiMianji) {
			this.tudiMianji = tudiMianji;
		}

		/**
		* 获取： 土地热度
		*/
		public Integer getTudiClicknum() {
			return tudiClicknum;
		}
		/**
		* 设置： 土地热度
		*/
		public void setTudiClicknum(Integer tudiClicknum) {
			this.tudiClicknum = tudiClicknum;
		}

		/**
		* 获取： 规划时间
		*/
		public Date getTudiTime() {
			return tudiTime;
		}
		/**
		* 设置： 规划时间
		*/
		public void setTudiTime(Date tudiTime) {
			this.tudiTime = tudiTime;
		}

		/**
		* 获取： 土地备注
		*/
		public String getTudiContent() {
			return tudiContent;
		}
		/**
		* 设置： 土地备注
		*/
		public void setTudiContent(String tudiContent) {
			this.tudiContent = tudiContent;
		}

	//重复字段

	@Override
	public String toString() {
		return "NongzuowuView{" +
			", nongzuowuValue=" + nongzuowuValue +
			", shangxiaValue=" + shangxiaValue +
			", tudiName=" + tudiName +
			", tudiUuidNumber=" + tudiUuidNumber +
			", tudiPhoto=" + tudiPhoto +
			", tudiAddress=" + tudiAddress +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", tudiMianji=" + tudiMianji +
			", tudiClicknum=" + tudiClicknum +
			", tudiTime=" + DateUtil.convertString(tudiTime,"yyyy-MM-dd") +
			", tudiContent=" + tudiContent +
			"} " + super.toString();
	}
}
