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
 * 监控记录
 *
 * @author 
 * @email
 */
@TableName("jiankongjiedian_jilu")
public class JiankongjiedianJiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankongjiedianJiluEntity() {

	}

	public JiankongjiedianJiluEntity(T t) {
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
     * 监控记录编号
     */
    @ColumnInfo(comment="监控记录编号",type="varchar(200)")
    @TableField(value = "jiankongjiedian_jilu_uuid_number")

    private String jiankongjiedianJiluUuidNumber;


    /**
     * 监控记录名称
     */
    @ColumnInfo(comment="监控记录名称",type="varchar(200)")
    @TableField(value = "jiankongjiedian_jilu_name")

    private String jiankongjiedianJiluName;


    /**
     * 监拍照片
     */
    @ColumnInfo(comment="监拍照片",type="varchar(200)")
    @TableField(value = "jiankongjiedian_jilu_photo")

    private String jiankongjiedianJiluPhoto;


    /**
     * 监控数值
     */
    @ColumnInfo(comment="监控数值",type="varchar(200)")
    @TableField(value = "jiankongjiedian_shuzhi")

    private String jiankongjiedianShuzhi;


    /**
     * 监控记录备注
     */
    @ColumnInfo(comment="监控记录备注",type="longtext")
    @TableField(value = "jiankongjiedian_jilu_content")

    private String jiankongjiedianJiluContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
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
	 * 获取：监控记录编号
	 */
    public String getJiankongjiedianJiluUuidNumber() {
        return jiankongjiedianJiluUuidNumber;
    }
    /**
	 * 设置：监控记录编号
	 */

    public void setJiankongjiedianJiluUuidNumber(String jiankongjiedianJiluUuidNumber) {
        this.jiankongjiedianJiluUuidNumber = jiankongjiedianJiluUuidNumber;
    }
    /**
	 * 获取：监控记录名称
	 */
    public String getJiankongjiedianJiluName() {
        return jiankongjiedianJiluName;
    }
    /**
	 * 设置：监控记录名称
	 */

    public void setJiankongjiedianJiluName(String jiankongjiedianJiluName) {
        this.jiankongjiedianJiluName = jiankongjiedianJiluName;
    }
    /**
	 * 获取：监拍照片
	 */
    public String getJiankongjiedianJiluPhoto() {
        return jiankongjiedianJiluPhoto;
    }
    /**
	 * 设置：监拍照片
	 */

    public void setJiankongjiedianJiluPhoto(String jiankongjiedianJiluPhoto) {
        this.jiankongjiedianJiluPhoto = jiankongjiedianJiluPhoto;
    }
    /**
	 * 获取：监控数值
	 */
    public String getJiankongjiedianShuzhi() {
        return jiankongjiedianShuzhi;
    }
    /**
	 * 设置：监控数值
	 */

    public void setJiankongjiedianShuzhi(String jiankongjiedianShuzhi) {
        this.jiankongjiedianShuzhi = jiankongjiedianShuzhi;
    }
    /**
	 * 获取：监控记录备注
	 */
    public String getJiankongjiedianJiluContent() {
        return jiankongjiedianJiluContent;
    }
    /**
	 * 设置：监控记录备注
	 */

    public void setJiankongjiedianJiluContent(String jiankongjiedianJiluContent) {
        this.jiankongjiedianJiluContent = jiankongjiedianJiluContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：上传时间
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
        return "JiankongjiedianJilu{" +
            ", id=" + id +
            ", jiankongjiedianJiluUuidNumber=" + jiankongjiedianJiluUuidNumber +
            ", jiankongjiedianJiluName=" + jiankongjiedianJiluName +
            ", jiankongjiedianJiluPhoto=" + jiankongjiedianJiluPhoto +
            ", jiankongjiedianShuzhi=" + jiankongjiedianShuzhi +
            ", jiankongjiedianJiluContent=" + jiankongjiedianJiluContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
