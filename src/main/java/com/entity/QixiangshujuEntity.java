package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 气象数据
 *
 * @author 
 * @email
 */
@TableName("qixiangshuju")
public class QixiangshujuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QixiangshujuEntity() {

	}

	public QixiangshujuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 气象数据标题
     */
    @ColumnInfo(comment="气象数据标题",type="varchar(200)")
    @TableField(value = "qixiangshuju_name")

    private String qixiangshujuName;


    /**
     * 气象数据编号
     */
    @ColumnInfo(comment="气象数据编号",type="varchar(200)")
    @TableField(value = "qixiangshuju_uuid_number")

    private String qixiangshujuUuidNumber;


    /**
     * 封面
     */
    @ColumnInfo(comment="封面",type="varchar(200)")
    @TableField(value = "qixiangshuju_photo")

    private String qixiangshujuPhoto;


    /**
     * 气象地址
     */
    @ColumnInfo(comment="气象地址",type="varchar(200)")
    @TableField(value = "qixiangshuju_address")

    private String qixiangshujuAddress;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 气象类型
     */
    @ColumnInfo(comment="气象类型",type="int(11)")
    @TableField(value = "qixiangshuju_types")

    private Integer qixiangshujuTypes;


    /**
     * 气象值(大)
     */
    @ColumnInfo(comment="气象值(大)",type="decimal(10,2)")
    @TableField(value = "qixiangshuju_da_zhi")

    private Double qixiangshujuDaZhi;


    /**
     * 气象值(小)
     */
    @ColumnInfo(comment="气象值(小)",type="decimal(10,2)")
    @TableField(value = "qixiangshuju_xiao_zhi")

    private Double qixiangshujuXiaoZhi;


    /**
     * 气象热度
     */
    @ColumnInfo(comment="气象热度",type="int(11)")
    @TableField(value = "qixiangshuju_clicknum")

    private Integer qixiangshujuClicknum;


    /**
     * 所属时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="所属时间",type="timestamp")
    @TableField(value = "qixiangshuju_time")

    private Date qixiangshujuTime;


    /**
     * 气象数据详情
     */
    @ColumnInfo(comment="气象数据详情",type="longtext")
    @TableField(value = "qixiangshuju_content")

    private String qixiangshujuContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：气象数据标题
	 */
    public String getQixiangshujuName() {
        return qixiangshujuName;
    }
    /**
	 * 设置：气象数据标题
	 */

    public void setQixiangshujuName(String qixiangshujuName) {
        this.qixiangshujuName = qixiangshujuName;
    }
    /**
	 * 获取：气象数据编号
	 */
    public String getQixiangshujuUuidNumber() {
        return qixiangshujuUuidNumber;
    }
    /**
	 * 设置：气象数据编号
	 */

    public void setQixiangshujuUuidNumber(String qixiangshujuUuidNumber) {
        this.qixiangshujuUuidNumber = qixiangshujuUuidNumber;
    }
    /**
	 * 获取：封面
	 */
    public String getQixiangshujuPhoto() {
        return qixiangshujuPhoto;
    }
    /**
	 * 设置：封面
	 */

    public void setQixiangshujuPhoto(String qixiangshujuPhoto) {
        this.qixiangshujuPhoto = qixiangshujuPhoto;
    }
    /**
	 * 获取：气象地址
	 */
    public String getQixiangshujuAddress() {
        return qixiangshujuAddress;
    }
    /**
	 * 设置：气象地址
	 */

    public void setQixiangshujuAddress(String qixiangshujuAddress) {
        this.qixiangshujuAddress = qixiangshujuAddress;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：气象类型
	 */
    public Integer getQixiangshujuTypes() {
        return qixiangshujuTypes;
    }
    /**
	 * 设置：气象类型
	 */

    public void setQixiangshujuTypes(Integer qixiangshujuTypes) {
        this.qixiangshujuTypes = qixiangshujuTypes;
    }
    /**
	 * 获取：气象值(大)
	 */
    public Double getQixiangshujuDaZhi() {
        return qixiangshujuDaZhi;
    }
    /**
	 * 设置：气象值(大)
	 */

    public void setQixiangshujuDaZhi(Double qixiangshujuDaZhi) {
        this.qixiangshujuDaZhi = qixiangshujuDaZhi;
    }
    /**
	 * 获取：气象值(小)
	 */
    public Double getQixiangshujuXiaoZhi() {
        return qixiangshujuXiaoZhi;
    }
    /**
	 * 设置：气象值(小)
	 */

    public void setQixiangshujuXiaoZhi(Double qixiangshujuXiaoZhi) {
        this.qixiangshujuXiaoZhi = qixiangshujuXiaoZhi;
    }
    /**
	 * 获取：气象热度
	 */
    public Integer getQixiangshujuClicknum() {
        return qixiangshujuClicknum;
    }
    /**
	 * 设置：气象热度
	 */

    public void setQixiangshujuClicknum(Integer qixiangshujuClicknum) {
        this.qixiangshujuClicknum = qixiangshujuClicknum;
    }
    /**
	 * 获取：所属时间
	 */
    public Date getQixiangshujuTime() {
        return qixiangshujuTime;
    }
    /**
	 * 设置：所属时间
	 */

    public void setQixiangshujuTime(Date qixiangshujuTime) {
        this.qixiangshujuTime = qixiangshujuTime;
    }
    /**
	 * 获取：气象数据详情
	 */
    public String getQixiangshujuContent() {
        return qixiangshujuContent;
    }
    /**
	 * 设置：气象数据详情
	 */

    public void setQixiangshujuContent(String qixiangshujuContent) {
        this.qixiangshujuContent = qixiangshujuContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Qixiangshuju{" +
            ", id=" + id +
            ", qixiangshujuName=" + qixiangshujuName +
            ", qixiangshujuUuidNumber=" + qixiangshujuUuidNumber +
            ", qixiangshujuPhoto=" + qixiangshujuPhoto +
            ", qixiangshujuAddress=" + qixiangshujuAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", qixiangshujuTypes=" + qixiangshujuTypes +
            ", qixiangshujuDaZhi=" + qixiangshujuDaZhi +
            ", qixiangshujuXiaoZhi=" + qixiangshujuXiaoZhi +
            ", qixiangshujuClicknum=" + qixiangshujuClicknum +
            ", qixiangshujuTime=" + DateUtil.convertString(qixiangshujuTime,"yyyy-MM-dd") +
            ", qixiangshujuContent=" + qixiangshujuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
