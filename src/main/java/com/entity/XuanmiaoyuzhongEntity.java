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
 * 选苗育种
 *
 * @author 
 * @email
 */
@TableName("xuanmiaoyuzhong")
public class XuanmiaoyuzhongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuanmiaoyuzhongEntity() {

	}

	public XuanmiaoyuzhongEntity(T t) {
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
     * 选苗育种编号
     */
    @ColumnInfo(comment="选苗育种编号",type="varchar(200)")
    @TableField(value = "xuanmiaoyuzhong_uuid_number")

    private String xuanmiaoyuzhongUuidNumber;


    /**
     * 选苗育种标题
     */
    @ColumnInfo(comment="选苗育种标题",type="varchar(200)")
    @TableField(value = "xuanmiaoyuzhong_name")

    private String xuanmiaoyuzhongName;


    /**
     * 选苗育种照片
     */
    @ColumnInfo(comment="选苗育种照片",type="varchar(200)")
    @TableField(value = "xuanmiaoyuzhong_photo")

    private String xuanmiaoyuzhongPhoto;


    /**
     * 选苗育种地点
     */
    @ColumnInfo(comment="选苗育种地点",type="varchar(200)")
    @TableField(value = "xuanmiaoyuzhong_address")

    private String xuanmiaoyuzhongAddress;


    /**
     * 选苗育种类型
     */
    @ColumnInfo(comment="选苗育种类型",type="int(11)")
    @TableField(value = "xuanmiaoyuzhong_types")

    private Integer xuanmiaoyuzhongTypes;


    /**
     * 挑选数量
     */
    @ColumnInfo(comment="挑选数量",type="int(11)")
    @TableField(value = "xuanmiaoyuzhong_tiaoxuan_number")

    private Integer xuanmiaoyuzhongTiaoxuanNumber;


    /**
     * 挑选出数量
     */
    @ColumnInfo(comment="挑选出数量",type="int(11)")
    @TableField(value = "xuanmiaoyuzhong_tiaoxuanhou_number")

    private Integer xuanmiaoyuzhongTiaoxuanhouNumber;


    /**
     * 挑选时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="挑选时间",type="timestamp")
    @TableField(value = "xuanmiaoyuzhong_time")

    private Date xuanmiaoyuzhongTime;


    /**
     * 选苗育种备注
     */
    @ColumnInfo(comment="选苗育种备注",type="longtext")
    @TableField(value = "xuanmiaoyuzhong_content")

    private String xuanmiaoyuzhongContent;


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
	 * 获取：选苗育种编号
	 */
    public String getXuanmiaoyuzhongUuidNumber() {
        return xuanmiaoyuzhongUuidNumber;
    }
    /**
	 * 设置：选苗育种编号
	 */

    public void setXuanmiaoyuzhongUuidNumber(String xuanmiaoyuzhongUuidNumber) {
        this.xuanmiaoyuzhongUuidNumber = xuanmiaoyuzhongUuidNumber;
    }
    /**
	 * 获取：选苗育种标题
	 */
    public String getXuanmiaoyuzhongName() {
        return xuanmiaoyuzhongName;
    }
    /**
	 * 设置：选苗育种标题
	 */

    public void setXuanmiaoyuzhongName(String xuanmiaoyuzhongName) {
        this.xuanmiaoyuzhongName = xuanmiaoyuzhongName;
    }
    /**
	 * 获取：选苗育种照片
	 */
    public String getXuanmiaoyuzhongPhoto() {
        return xuanmiaoyuzhongPhoto;
    }
    /**
	 * 设置：选苗育种照片
	 */

    public void setXuanmiaoyuzhongPhoto(String xuanmiaoyuzhongPhoto) {
        this.xuanmiaoyuzhongPhoto = xuanmiaoyuzhongPhoto;
    }
    /**
	 * 获取：选苗育种地点
	 */
    public String getXuanmiaoyuzhongAddress() {
        return xuanmiaoyuzhongAddress;
    }
    /**
	 * 设置：选苗育种地点
	 */

    public void setXuanmiaoyuzhongAddress(String xuanmiaoyuzhongAddress) {
        this.xuanmiaoyuzhongAddress = xuanmiaoyuzhongAddress;
    }
    /**
	 * 获取：选苗育种类型
	 */
    public Integer getXuanmiaoyuzhongTypes() {
        return xuanmiaoyuzhongTypes;
    }
    /**
	 * 设置：选苗育种类型
	 */

    public void setXuanmiaoyuzhongTypes(Integer xuanmiaoyuzhongTypes) {
        this.xuanmiaoyuzhongTypes = xuanmiaoyuzhongTypes;
    }
    /**
	 * 获取：挑选数量
	 */
    public Integer getXuanmiaoyuzhongTiaoxuanNumber() {
        return xuanmiaoyuzhongTiaoxuanNumber;
    }
    /**
	 * 设置：挑选数量
	 */

    public void setXuanmiaoyuzhongTiaoxuanNumber(Integer xuanmiaoyuzhongTiaoxuanNumber) {
        this.xuanmiaoyuzhongTiaoxuanNumber = xuanmiaoyuzhongTiaoxuanNumber;
    }
    /**
	 * 获取：挑选出数量
	 */
    public Integer getXuanmiaoyuzhongTiaoxuanhouNumber() {
        return xuanmiaoyuzhongTiaoxuanhouNumber;
    }
    /**
	 * 设置：挑选出数量
	 */

    public void setXuanmiaoyuzhongTiaoxuanhouNumber(Integer xuanmiaoyuzhongTiaoxuanhouNumber) {
        this.xuanmiaoyuzhongTiaoxuanhouNumber = xuanmiaoyuzhongTiaoxuanhouNumber;
    }
    /**
	 * 获取：挑选时间
	 */
    public Date getXuanmiaoyuzhongTime() {
        return xuanmiaoyuzhongTime;
    }
    /**
	 * 设置：挑选时间
	 */

    public void setXuanmiaoyuzhongTime(Date xuanmiaoyuzhongTime) {
        this.xuanmiaoyuzhongTime = xuanmiaoyuzhongTime;
    }
    /**
	 * 获取：选苗育种备注
	 */
    public String getXuanmiaoyuzhongContent() {
        return xuanmiaoyuzhongContent;
    }
    /**
	 * 设置：选苗育种备注
	 */

    public void setXuanmiaoyuzhongContent(String xuanmiaoyuzhongContent) {
        this.xuanmiaoyuzhongContent = xuanmiaoyuzhongContent;
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
        return "Xuanmiaoyuzhong{" +
            ", id=" + id +
            ", xuanmiaoyuzhongUuidNumber=" + xuanmiaoyuzhongUuidNumber +
            ", xuanmiaoyuzhongName=" + xuanmiaoyuzhongName +
            ", xuanmiaoyuzhongPhoto=" + xuanmiaoyuzhongPhoto +
            ", xuanmiaoyuzhongAddress=" + xuanmiaoyuzhongAddress +
            ", xuanmiaoyuzhongTypes=" + xuanmiaoyuzhongTypes +
            ", xuanmiaoyuzhongTiaoxuanNumber=" + xuanmiaoyuzhongTiaoxuanNumber +
            ", xuanmiaoyuzhongTiaoxuanhouNumber=" + xuanmiaoyuzhongTiaoxuanhouNumber +
            ", xuanmiaoyuzhongTime=" + DateUtil.convertString(xuanmiaoyuzhongTime,"yyyy-MM-dd") +
            ", xuanmiaoyuzhongContent=" + xuanmiaoyuzhongContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
