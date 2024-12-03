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
 * 土地规划
 *
 * @author 
 * @email
 */
@TableName("tudi")
public class TudiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TudiEntity() {

	}

	public TudiEntity(T t) {
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
     * 土地名称
     */
    @ColumnInfo(comment="土地名称",type="varchar(200)")
    @TableField(value = "tudi_name")

    private String tudiName;


    /**
     * 土地编号
     */
    @ColumnInfo(comment="土地编号",type="varchar(200)")
    @TableField(value = "tudi_uuid_number")

    private String tudiUuidNumber;


    /**
     * 土地照片
     */
    @ColumnInfo(comment="土地照片",type="varchar(200)")
    @TableField(value = "tudi_photo")

    private String tudiPhoto;


    /**
     * 土地位置
     */
    @ColumnInfo(comment="土地位置",type="varchar(200)")
    @TableField(value = "tudi_address")

    private String tudiAddress;


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
     * 土地类型
     */
    @ColumnInfo(comment="土地类型",type="int(11)")
    @TableField(value = "tudi_types")

    private Integer tudiTypes;


    /**
     * 土地面积(平方)
     */
    @ColumnInfo(comment="土地面积(平方)",type="int(11)")
    @TableField(value = "tudi_mianji")

    private Integer tudiMianji;


    /**
     * 土地热度
     */
    @ColumnInfo(comment="土地热度",type="int(11)")
    @TableField(value = "tudi_clicknum")

    private Integer tudiClicknum;


    /**
     * 规划时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="规划时间",type="timestamp")
    @TableField(value = "tudi_time")

    private Date tudiTime;


    /**
     * 土地备注
     */
    @ColumnInfo(comment="土地备注",type="longtext")
    @TableField(value = "tudi_content")

    private String tudiContent;


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
	 * 获取：土地名称
	 */
    public String getTudiName() {
        return tudiName;
    }
    /**
	 * 设置：土地名称
	 */

    public void setTudiName(String tudiName) {
        this.tudiName = tudiName;
    }
    /**
	 * 获取：土地编号
	 */
    public String getTudiUuidNumber() {
        return tudiUuidNumber;
    }
    /**
	 * 设置：土地编号
	 */

    public void setTudiUuidNumber(String tudiUuidNumber) {
        this.tudiUuidNumber = tudiUuidNumber;
    }
    /**
	 * 获取：土地照片
	 */
    public String getTudiPhoto() {
        return tudiPhoto;
    }
    /**
	 * 设置：土地照片
	 */

    public void setTudiPhoto(String tudiPhoto) {
        this.tudiPhoto = tudiPhoto;
    }
    /**
	 * 获取：土地位置
	 */
    public String getTudiAddress() {
        return tudiAddress;
    }
    /**
	 * 设置：土地位置
	 */

    public void setTudiAddress(String tudiAddress) {
        this.tudiAddress = tudiAddress;
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
	 * 获取：土地类型
	 */
    public Integer getTudiTypes() {
        return tudiTypes;
    }
    /**
	 * 设置：土地类型
	 */

    public void setTudiTypes(Integer tudiTypes) {
        this.tudiTypes = tudiTypes;
    }
    /**
	 * 获取：土地面积(平方)
	 */
    public Integer getTudiMianji() {
        return tudiMianji;
    }
    /**
	 * 设置：土地面积(平方)
	 */

    public void setTudiMianji(Integer tudiMianji) {
        this.tudiMianji = tudiMianji;
    }
    /**
	 * 获取：土地热度
	 */
    public Integer getTudiClicknum() {
        return tudiClicknum;
    }
    /**
	 * 设置：土地热度
	 */

    public void setTudiClicknum(Integer tudiClicknum) {
        this.tudiClicknum = tudiClicknum;
    }
    /**
	 * 获取：规划时间
	 */
    public Date getTudiTime() {
        return tudiTime;
    }
    /**
	 * 设置：规划时间
	 */

    public void setTudiTime(Date tudiTime) {
        this.tudiTime = tudiTime;
    }
    /**
	 * 获取：土地备注
	 */
    public String getTudiContent() {
        return tudiContent;
    }
    /**
	 * 设置：土地备注
	 */

    public void setTudiContent(String tudiContent) {
        this.tudiContent = tudiContent;
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
        return "Tudi{" +
            ", id=" + id +
            ", tudiName=" + tudiName +
            ", tudiUuidNumber=" + tudiUuidNumber +
            ", tudiPhoto=" + tudiPhoto +
            ", tudiAddress=" + tudiAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", tudiTypes=" + tudiTypes +
            ", tudiMianji=" + tudiMianji +
            ", tudiClicknum=" + tudiClicknum +
            ", tudiTime=" + DateUtil.convertString(tudiTime,"yyyy-MM-dd") +
            ", tudiContent=" + tudiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
