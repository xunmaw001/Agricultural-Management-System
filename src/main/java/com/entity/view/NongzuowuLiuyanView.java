package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongzuowuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农作物留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongzuowu_liuyan")
public class NongzuowuLiuyanView extends NongzuowuLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 农作物
							/**
		* 农作物编号
		*/

		@ColumnInfo(comment="农作物编号",type="varchar(200)")
		private String nongzuowuUuidNumber;
		/**
		* 农作物名称
		*/

		@ColumnInfo(comment="农作物名称",type="varchar(200)")
		private String nongzuowuName;
		/**
		* 农作物照片
		*/

		@ColumnInfo(comment="农作物照片",type="varchar(200)")
		private String nongzuowuPhoto;
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
		* 农作物类型
		*/
		@ColumnInfo(comment="农作物类型",type="int(11)")
		private Integer nongzuowuTypes;
			/**
			* 农作物类型的值
			*/
			@ColumnInfo(comment="农作物类型的字典表值",type="varchar(200)")
			private String nongzuowuValue;
		/**
		* 种植数量
		*/

		@ColumnInfo(comment="种植数量",type="int(11)")
		private Integer nongzuowuKucunNumber;
		/**
		* 农作物热度
		*/

		@ColumnInfo(comment="农作物热度",type="int(11)")
		private Integer nongzuowuClicknum;
		/**
		* 种植开始时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="种植开始时间",type="timestamp")
		private Date nongzuowuKaishiTime;
		/**
		* 种植预计结束时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="种植预计结束时间",type="timestamp")
		private Date nongzuowuYujijieshuTime;
		/**
		* 农作物种植备注
		*/

		@ColumnInfo(comment="农作物种植备注",type="longtext")
		private String nongzuowuContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public NongzuowuLiuyanView() {

	}

	public NongzuowuLiuyanView(NongzuowuLiuyanEntity nongzuowuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, nongzuowuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 农作物

		/**
		* 获取： 农作物编号
		*/
		public String getNongzuowuUuidNumber() {
			return nongzuowuUuidNumber;
		}
		/**
		* 设置： 农作物编号
		*/
		public void setNongzuowuUuidNumber(String nongzuowuUuidNumber) {
			this.nongzuowuUuidNumber = nongzuowuUuidNumber;
		}

		/**
		* 获取： 农作物名称
		*/
		public String getNongzuowuName() {
			return nongzuowuName;
		}
		/**
		* 设置： 农作物名称
		*/
		public void setNongzuowuName(String nongzuowuName) {
			this.nongzuowuName = nongzuowuName;
		}

		/**
		* 获取： 农作物照片
		*/
		public String getNongzuowuPhoto() {
			return nongzuowuPhoto;
		}
		/**
		* 设置： 农作物照片
		*/
		public void setNongzuowuPhoto(String nongzuowuPhoto) {
			this.nongzuowuPhoto = nongzuowuPhoto;
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
		* 获取： 农作物类型
		*/
		public Integer getNongzuowuTypes() {
			return nongzuowuTypes;
		}
		/**
		* 设置： 农作物类型
		*/
		public void setNongzuowuTypes(Integer nongzuowuTypes) {
			this.nongzuowuTypes = nongzuowuTypes;
		}


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

		/**
		* 获取： 种植数量
		*/
		public Integer getNongzuowuKucunNumber() {
			return nongzuowuKucunNumber;
		}
		/**
		* 设置： 种植数量
		*/
		public void setNongzuowuKucunNumber(Integer nongzuowuKucunNumber) {
			this.nongzuowuKucunNumber = nongzuowuKucunNumber;
		}

		/**
		* 获取： 农作物热度
		*/
		public Integer getNongzuowuClicknum() {
			return nongzuowuClicknum;
		}
		/**
		* 设置： 农作物热度
		*/
		public void setNongzuowuClicknum(Integer nongzuowuClicknum) {
			this.nongzuowuClicknum = nongzuowuClicknum;
		}

		/**
		* 获取： 种植开始时间
		*/
		public Date getNongzuowuKaishiTime() {
			return nongzuowuKaishiTime;
		}
		/**
		* 设置： 种植开始时间
		*/
		public void setNongzuowuKaishiTime(Date nongzuowuKaishiTime) {
			this.nongzuowuKaishiTime = nongzuowuKaishiTime;
		}

		/**
		* 获取： 种植预计结束时间
		*/
		public Date getNongzuowuYujijieshuTime() {
			return nongzuowuYujijieshuTime;
		}
		/**
		* 设置： 种植预计结束时间
		*/
		public void setNongzuowuYujijieshuTime(Date nongzuowuYujijieshuTime) {
			this.nongzuowuYujijieshuTime = nongzuowuYujijieshuTime;
		}

		/**
		* 获取： 农作物种植备注
		*/
		public String getNongzuowuContent() {
			return nongzuowuContent;
		}
		/**
		* 设置： 农作物种植备注
		*/
		public void setNongzuowuContent(String nongzuowuContent) {
			this.nongzuowuContent = nongzuowuContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "NongzuowuLiuyanView{" +
			", nongzuowuUuidNumber=" + nongzuowuUuidNumber +
			", nongzuowuName=" + nongzuowuName +
			", nongzuowuPhoto=" + nongzuowuPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", nongzuowuKucunNumber=" + nongzuowuKucunNumber +
			", nongzuowuClicknum=" + nongzuowuClicknum +
			", nongzuowuKaishiTime=" + DateUtil.convertString(nongzuowuKaishiTime,"yyyy-MM-dd") +
			", nongzuowuYujijieshuTime=" + DateUtil.convertString(nongzuowuYujijieshuTime,"yyyy-MM-dd") +
			", nongzuowuContent=" + nongzuowuContent +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
