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
 * 农作物
 *
 * @author 
 * @email
 */
@TableName("nongzuowu")
public class NongzuowuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongzuowuEntity() {

	}

	public NongzuowuEntity(T t) {
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
     * 土地
     */
    @ColumnInfo(comment="土地",type="int(11)")
    @TableField(value = "tudi_id")

    private Integer tudiId;


    /**
     * 农作物编号
     */
    @ColumnInfo(comment="农作物编号",type="varchar(200)")
    @TableField(value = "nongzuowu_uuid_number")

    private String nongzuowuUuidNumber;


    /**
     * 农作物名称
     */
    @ColumnInfo(comment="农作物名称",type="varchar(200)")
    @TableField(value = "nongzuowu_name")

    private String nongzuowuName;


    /**
     * 农作物照片
     */
    @ColumnInfo(comment="农作物照片",type="varchar(200)")
    @TableField(value = "nongzuowu_photo")

    private String nongzuowuPhoto;


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
     * 农作物类型
     */
    @ColumnInfo(comment="农作物类型",type="int(11)")
    @TableField(value = "nongzuowu_types")

    private Integer nongzuowuTypes;


    /**
     * 种植数量
     */
    @ColumnInfo(comment="种植数量",type="int(11)")
    @TableField(value = "nongzuowu_kucun_number")

    private Integer nongzuowuKucunNumber;


    /**
     * 农作物热度
     */
    @ColumnInfo(comment="农作物热度",type="int(11)")
    @TableField(value = "nongzuowu_clicknum")

    private Integer nongzuowuClicknum;


    /**
     * 种植开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="种植开始时间",type="timestamp")
    @TableField(value = "nongzuowu_kaishi_time")

    private Date nongzuowuKaishiTime;


    /**
     * 种植预计结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="种植预计结束时间",type="timestamp")
    @TableField(value = "nongzuowu_yujijieshu_time")

    private Date nongzuowuYujijieshuTime;


    /**
     * 农作物种植备注
     */
    @ColumnInfo(comment="农作物种植备注",type="longtext")
    @TableField(value = "nongzuowu_content")

    private String nongzuowuContent;


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
	 * 获取：土地
	 */
    public Integer getTudiId() {
        return tudiId;
    }
    /**
	 * 设置：土地
	 */

    public void setTudiId(Integer tudiId) {
        this.tudiId = tudiId;
    }
    /**
	 * 获取：农作物编号
	 */
    public String getNongzuowuUuidNumber() {
        return nongzuowuUuidNumber;
    }
    /**
	 * 设置：农作物编号
	 */

    public void setNongzuowuUuidNumber(String nongzuowuUuidNumber) {
        this.nongzuowuUuidNumber = nongzuowuUuidNumber;
    }
    /**
	 * 获取：农作物名称
	 */
    public String getNongzuowuName() {
        return nongzuowuName;
    }
    /**
	 * 设置：农作物名称
	 */

    public void setNongzuowuName(String nongzuowuName) {
        this.nongzuowuName = nongzuowuName;
    }
    /**
	 * 获取：农作物照片
	 */
    public String getNongzuowuPhoto() {
        return nongzuowuPhoto;
    }
    /**
	 * 设置：农作物照片
	 */

    public void setNongzuowuPhoto(String nongzuowuPhoto) {
        this.nongzuowuPhoto = nongzuowuPhoto;
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
	 * 获取：农作物类型
	 */
    public Integer getNongzuowuTypes() {
        return nongzuowuTypes;
    }
    /**
	 * 设置：农作物类型
	 */

    public void setNongzuowuTypes(Integer nongzuowuTypes) {
        this.nongzuowuTypes = nongzuowuTypes;
    }
    /**
	 * 获取：种植数量
	 */
    public Integer getNongzuowuKucunNumber() {
        return nongzuowuKucunNumber;
    }
    /**
	 * 设置：种植数量
	 */

    public void setNongzuowuKucunNumber(Integer nongzuowuKucunNumber) {
        this.nongzuowuKucunNumber = nongzuowuKucunNumber;
    }
    /**
	 * 获取：农作物热度
	 */
    public Integer getNongzuowuClicknum() {
        return nongzuowuClicknum;
    }
    /**
	 * 设置：农作物热度
	 */

    public void setNongzuowuClicknum(Integer nongzuowuClicknum) {
        this.nongzuowuClicknum = nongzuowuClicknum;
    }
    /**
	 * 获取：种植开始时间
	 */
    public Date getNongzuowuKaishiTime() {
        return nongzuowuKaishiTime;
    }
    /**
	 * 设置：种植开始时间
	 */

    public void setNongzuowuKaishiTime(Date nongzuowuKaishiTime) {
        this.nongzuowuKaishiTime = nongzuowuKaishiTime;
    }
    /**
	 * 获取：种植预计结束时间
	 */
    public Date getNongzuowuYujijieshuTime() {
        return nongzuowuYujijieshuTime;
    }
    /**
	 * 设置：种植预计结束时间
	 */

    public void setNongzuowuYujijieshuTime(Date nongzuowuYujijieshuTime) {
        this.nongzuowuYujijieshuTime = nongzuowuYujijieshuTime;
    }
    /**
	 * 获取：农作物种植备注
	 */
    public String getNongzuowuContent() {
        return nongzuowuContent;
    }
    /**
	 * 设置：农作物种植备注
	 */

    public void setNongzuowuContent(String nongzuowuContent) {
        this.nongzuowuContent = nongzuowuContent;
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
        return "Nongzuowu{" +
            ", id=" + id +
            ", tudiId=" + tudiId +
            ", nongzuowuUuidNumber=" + nongzuowuUuidNumber +
            ", nongzuowuName=" + nongzuowuName +
            ", nongzuowuPhoto=" + nongzuowuPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", nongzuowuTypes=" + nongzuowuTypes +
            ", nongzuowuKucunNumber=" + nongzuowuKucunNumber +
            ", nongzuowuClicknum=" + nongzuowuClicknum +
            ", nongzuowuKaishiTime=" + DateUtil.convertString(nongzuowuKaishiTime,"yyyy-MM-dd") +
            ", nongzuowuYujijieshuTime=" + DateUtil.convertString(nongzuowuYujijieshuTime,"yyyy-MM-dd") +
            ", nongzuowuContent=" + nongzuowuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
