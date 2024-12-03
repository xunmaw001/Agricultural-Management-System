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
 * 监控节点
 *
 * @author 
 * @email
 */
@TableName("jiankongjiedian")
public class JiankongjiedianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankongjiedianEntity() {

	}

	public JiankongjiedianEntity(T t) {
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
     * 监控节点编号
     */
    @ColumnInfo(comment="监控节点编号",type="varchar(200)")
    @TableField(value = "jiankongjiedian_uuid_number")

    private String jiankongjiedianUuidNumber;


    /**
     * 监控节点名称
     */
    @ColumnInfo(comment="监控节点名称",type="varchar(200)")
    @TableField(value = "jiankongjiedian_name")

    private String jiankongjiedianName;


    /**
     * 监控节点照片
     */
    @ColumnInfo(comment="监控节点照片",type="varchar(200)")
    @TableField(value = "jiankongjiedian_photo")

    private String jiankongjiedianPhoto;


    /**
     * 监控位置
     */
    @ColumnInfo(comment="监控位置",type="varchar(200)")
    @TableField(value = "jiankongjiedian_address")

    private String jiankongjiedianAddress;


    /**
     * 监控节点类型
     */
    @ColumnInfo(comment="监控节点类型",type="int(11)")
    @TableField(value = "jiankongjiedian_types")

    private Integer jiankongjiedianTypes;


    /**
     * 监控节点备注
     */
    @ColumnInfo(comment="监控节点备注",type="longtext")
    @TableField(value = "jiankongjiedian_content")

    private String jiankongjiedianContent;


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
	 * 获取：监控节点编号
	 */
    public String getJiankongjiedianUuidNumber() {
        return jiankongjiedianUuidNumber;
    }
    /**
	 * 设置：监控节点编号
	 */

    public void setJiankongjiedianUuidNumber(String jiankongjiedianUuidNumber) {
        this.jiankongjiedianUuidNumber = jiankongjiedianUuidNumber;
    }
    /**
	 * 获取：监控节点名称
	 */
    public String getJiankongjiedianName() {
        return jiankongjiedianName;
    }
    /**
	 * 设置：监控节点名称
	 */

    public void setJiankongjiedianName(String jiankongjiedianName) {
        this.jiankongjiedianName = jiankongjiedianName;
    }
    /**
	 * 获取：监控节点照片
	 */
    public String getJiankongjiedianPhoto() {
        return jiankongjiedianPhoto;
    }
    /**
	 * 设置：监控节点照片
	 */

    public void setJiankongjiedianPhoto(String jiankongjiedianPhoto) {
        this.jiankongjiedianPhoto = jiankongjiedianPhoto;
    }
    /**
	 * 获取：监控位置
	 */
    public String getJiankongjiedianAddress() {
        return jiankongjiedianAddress;
    }
    /**
	 * 设置：监控位置
	 */

    public void setJiankongjiedianAddress(String jiankongjiedianAddress) {
        this.jiankongjiedianAddress = jiankongjiedianAddress;
    }
    /**
	 * 获取：监控节点类型
	 */
    public Integer getJiankongjiedianTypes() {
        return jiankongjiedianTypes;
    }
    /**
	 * 设置：监控节点类型
	 */

    public void setJiankongjiedianTypes(Integer jiankongjiedianTypes) {
        this.jiankongjiedianTypes = jiankongjiedianTypes;
    }
    /**
	 * 获取：监控节点备注
	 */
    public String getJiankongjiedianContent() {
        return jiankongjiedianContent;
    }
    /**
	 * 设置：监控节点备注
	 */

    public void setJiankongjiedianContent(String jiankongjiedianContent) {
        this.jiankongjiedianContent = jiankongjiedianContent;
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
        return "Jiankongjiedian{" +
            ", id=" + id +
            ", jiankongjiedianUuidNumber=" + jiankongjiedianUuidNumber +
            ", jiankongjiedianName=" + jiankongjiedianName +
            ", jiankongjiedianPhoto=" + jiankongjiedianPhoto +
            ", jiankongjiedianAddress=" + jiankongjiedianAddress +
            ", jiankongjiedianTypes=" + jiankongjiedianTypes +
            ", jiankongjiedianContent=" + jiankongjiedianContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
