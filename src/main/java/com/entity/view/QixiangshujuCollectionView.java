package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.QixiangshujuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 气象数据收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qixiangshuju_collection")
public class QixiangshujuCollectionView extends QixiangshujuCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String qixiangshujuCollectionValue;

	//级联表 气象数据
		/**
		* 气象数据标题
		*/

		@ColumnInfo(comment="气象数据标题",type="varchar(200)")
		private String qixiangshujuName;
		/**
		* 气象数据编号
		*/

		@ColumnInfo(comment="气象数据编号",type="varchar(200)")
		private String qixiangshujuUuidNumber;
		/**
		* 封面
		*/

		@ColumnInfo(comment="封面",type="varchar(200)")
		private String qixiangshujuPhoto;
		/**
		* 气象地址
		*/

		@ColumnInfo(comment="气象地址",type="varchar(200)")
		private String qixiangshujuAddress;
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
		* 气象类型
		*/
		@ColumnInfo(comment="气象类型",type="int(11)")
		private Integer qixiangshujuTypes;
			/**
			* 气象类型的值
			*/
			@ColumnInfo(comment="气象类型的字典表值",type="varchar(200)")
			private String qixiangshujuValue;
		/**
		* 气象值(大)
		*/
		@ColumnInfo(comment="气象值(大)",type="decimal(10,2)")
		private Double qixiangshujuDaZhi;
		/**
		* 气象值(小)
		*/
		@ColumnInfo(comment="气象值(小)",type="decimal(10,2)")
		private Double qixiangshujuXiaoZhi;
		/**
		* 气象热度
		*/

		@ColumnInfo(comment="气象热度",type="int(11)")
		private Integer qixiangshujuClicknum;
		/**
		* 所属时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="所属时间",type="timestamp")
		private Date qixiangshujuTime;
		/**
		* 气象数据详情
		*/

		@ColumnInfo(comment="气象数据详情",type="longtext")
		private String qixiangshujuContent;
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



	public QixiangshujuCollectionView() {

	}

	public QixiangshujuCollectionView(QixiangshujuCollectionEntity qixiangshujuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, qixiangshujuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getQixiangshujuCollectionValue() {
		return qixiangshujuCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setQixiangshujuCollectionValue(String qixiangshujuCollectionValue) {
		this.qixiangshujuCollectionValue = qixiangshujuCollectionValue;
	}


	//级联表的get和set 气象数据

		/**
		* 获取： 气象数据标题
		*/
		public String getQixiangshujuName() {
			return qixiangshujuName;
		}
		/**
		* 设置： 气象数据标题
		*/
		public void setQixiangshujuName(String qixiangshujuName) {
			this.qixiangshujuName = qixiangshujuName;
		}

		/**
		* 获取： 气象数据编号
		*/
		public String getQixiangshujuUuidNumber() {
			return qixiangshujuUuidNumber;
		}
		/**
		* 设置： 气象数据编号
		*/
		public void setQixiangshujuUuidNumber(String qixiangshujuUuidNumber) {
			this.qixiangshujuUuidNumber = qixiangshujuUuidNumber;
		}

		/**
		* 获取： 封面
		*/
		public String getQixiangshujuPhoto() {
			return qixiangshujuPhoto;
		}
		/**
		* 设置： 封面
		*/
		public void setQixiangshujuPhoto(String qixiangshujuPhoto) {
			this.qixiangshujuPhoto = qixiangshujuPhoto;
		}

		/**
		* 获取： 气象地址
		*/
		public String getQixiangshujuAddress() {
			return qixiangshujuAddress;
		}
		/**
		* 设置： 气象地址
		*/
		public void setQixiangshujuAddress(String qixiangshujuAddress) {
			this.qixiangshujuAddress = qixiangshujuAddress;
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
		* 获取： 气象类型
		*/
		public Integer getQixiangshujuTypes() {
			return qixiangshujuTypes;
		}
		/**
		* 设置： 气象类型
		*/
		public void setQixiangshujuTypes(Integer qixiangshujuTypes) {
			this.qixiangshujuTypes = qixiangshujuTypes;
		}


			/**
			* 获取： 气象类型的值
			*/
			public String getQixiangshujuValue() {
				return qixiangshujuValue;
			}
			/**
			* 设置： 气象类型的值
			*/
			public void setQixiangshujuValue(String qixiangshujuValue) {
				this.qixiangshujuValue = qixiangshujuValue;
			}

		/**
		* 获取： 气象值(大)
		*/
		public Double getQixiangshujuDaZhi() {
			return qixiangshujuDaZhi;
		}
		/**
		* 设置： 气象值(大)
		*/
		public void setQixiangshujuDaZhi(Double qixiangshujuDaZhi) {
			this.qixiangshujuDaZhi = qixiangshujuDaZhi;
		}

		/**
		* 获取： 气象值(小)
		*/
		public Double getQixiangshujuXiaoZhi() {
			return qixiangshujuXiaoZhi;
		}
		/**
		* 设置： 气象值(小)
		*/
		public void setQixiangshujuXiaoZhi(Double qixiangshujuXiaoZhi) {
			this.qixiangshujuXiaoZhi = qixiangshujuXiaoZhi;
		}

		/**
		* 获取： 气象热度
		*/
		public Integer getQixiangshujuClicknum() {
			return qixiangshujuClicknum;
		}
		/**
		* 设置： 气象热度
		*/
		public void setQixiangshujuClicknum(Integer qixiangshujuClicknum) {
			this.qixiangshujuClicknum = qixiangshujuClicknum;
		}

		/**
		* 获取： 所属时间
		*/
		public Date getQixiangshujuTime() {
			return qixiangshujuTime;
		}
		/**
		* 设置： 所属时间
		*/
		public void setQixiangshujuTime(Date qixiangshujuTime) {
			this.qixiangshujuTime = qixiangshujuTime;
		}

		/**
		* 获取： 气象数据详情
		*/
		public String getQixiangshujuContent() {
			return qixiangshujuContent;
		}
		/**
		* 设置： 气象数据详情
		*/
		public void setQixiangshujuContent(String qixiangshujuContent) {
			this.qixiangshujuContent = qixiangshujuContent;
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
		return "QixiangshujuCollectionView{" +
			", qixiangshujuCollectionValue=" + qixiangshujuCollectionValue +
			", qixiangshujuName=" + qixiangshujuName +
			", qixiangshujuUuidNumber=" + qixiangshujuUuidNumber +
			", qixiangshujuPhoto=" + qixiangshujuPhoto +
			", qixiangshujuAddress=" + qixiangshujuAddress +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", qixiangshujuDaZhi=" + qixiangshujuDaZhi +
			", qixiangshujuXiaoZhi=" + qixiangshujuXiaoZhi +
			", qixiangshujuClicknum=" + qixiangshujuClicknum +
			", qixiangshujuTime=" + DateUtil.convertString(qixiangshujuTime,"yyyy-MM-dd") +
			", qixiangshujuContent=" + qixiangshujuContent +
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
