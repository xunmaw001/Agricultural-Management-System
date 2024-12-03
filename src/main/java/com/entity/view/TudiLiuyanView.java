package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TudiLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 土地留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tudi_liuyan")
public class TudiLiuyanView extends TudiLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

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



	public TudiLiuyanView() {

	}

	public TudiLiuyanView(TudiLiuyanEntity tudiLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, tudiLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		return "TudiLiuyanView{" +
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
