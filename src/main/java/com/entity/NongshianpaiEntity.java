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
 * 农事安排
 *
 * @author 
 * @email
 */
@TableName("nongshianpai")
public class NongshianpaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongshianpaiEntity() {

	}

	public NongshianpaiEntity(T t) {
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
     * 员工
     */
    @ColumnInfo(comment="员工",type="int(11)")
    @TableField(value = "yuangong_id")

    private Integer yuangongId;


    /**
     * 农事安排编号
     */
    @ColumnInfo(comment="农事安排编号",type="varchar(200)")
    @TableField(value = "nongshianpai_uuid_number")

    private String nongshianpaiUuidNumber;


    /**
     * 农事安排标题
     */
    @ColumnInfo(comment="农事安排标题",type="varchar(200)")
    @TableField(value = "nongshianpai_name")

    private String nongshianpaiName;


    /**
     * 农事安排附件
     */
    @ColumnInfo(comment="农事安排附件",type="varchar(200)")
    @TableField(value = "nongshianpai_file")

    private String nongshianpaiFile;


    /**
     * 安排地点
     */
    @ColumnInfo(comment="安排地点",type="varchar(200)")
    @TableField(value = "nongshianpai_address")

    private String nongshianpaiAddress;


    /**
     * 安排时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="安排时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 要执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="要执行时间",type="timestamp")
    @TableField(value = "nongshianpai_time")

    private Date nongshianpaiTime;


    /**
     * 农事安排类型
     */
    @ColumnInfo(comment="农事安排类型",type="int(11)")
    @TableField(value = "nongshianpai_types")

    private Integer nongshianpaiTypes;


    /**
     * 农事安排内容
     */
    @ColumnInfo(comment="农事安排内容",type="longtext")
    @TableField(value = "nongshianpai_content")

    private String nongshianpaiContent;


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
	 * 获取：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }
    /**
	 * 设置：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 获取：农事安排编号
	 */
    public String getNongshianpaiUuidNumber() {
        return nongshianpaiUuidNumber;
    }
    /**
	 * 设置：农事安排编号
	 */

    public void setNongshianpaiUuidNumber(String nongshianpaiUuidNumber) {
        this.nongshianpaiUuidNumber = nongshianpaiUuidNumber;
    }
    /**
	 * 获取：农事安排标题
	 */
    public String getNongshianpaiName() {
        return nongshianpaiName;
    }
    /**
	 * 设置：农事安排标题
	 */

    public void setNongshianpaiName(String nongshianpaiName) {
        this.nongshianpaiName = nongshianpaiName;
    }
    /**
	 * 获取：农事安排附件
	 */
    public String getNongshianpaiFile() {
        return nongshianpaiFile;
    }
    /**
	 * 设置：农事安排附件
	 */

    public void setNongshianpaiFile(String nongshianpaiFile) {
        this.nongshianpaiFile = nongshianpaiFile;
    }
    /**
	 * 获取：安排地点
	 */
    public String getNongshianpaiAddress() {
        return nongshianpaiAddress;
    }
    /**
	 * 设置：安排地点
	 */

    public void setNongshianpaiAddress(String nongshianpaiAddress) {
        this.nongshianpaiAddress = nongshianpaiAddress;
    }
    /**
	 * 获取：安排时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：安排时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：要执行时间
	 */
    public Date getNongshianpaiTime() {
        return nongshianpaiTime;
    }
    /**
	 * 设置：要执行时间
	 */

    public void setNongshianpaiTime(Date nongshianpaiTime) {
        this.nongshianpaiTime = nongshianpaiTime;
    }
    /**
	 * 获取：农事安排类型
	 */
    public Integer getNongshianpaiTypes() {
        return nongshianpaiTypes;
    }
    /**
	 * 设置：农事安排类型
	 */

    public void setNongshianpaiTypes(Integer nongshianpaiTypes) {
        this.nongshianpaiTypes = nongshianpaiTypes;
    }
    /**
	 * 获取：农事安排内容
	 */
    public String getNongshianpaiContent() {
        return nongshianpaiContent;
    }
    /**
	 * 设置：农事安排内容
	 */

    public void setNongshianpaiContent(String nongshianpaiContent) {
        this.nongshianpaiContent = nongshianpaiContent;
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
        return "Nongshianpai{" +
            ", id=" + id +
            ", yuangongId=" + yuangongId +
            ", nongshianpaiUuidNumber=" + nongshianpaiUuidNumber +
            ", nongshianpaiName=" + nongshianpaiName +
            ", nongshianpaiFile=" + nongshianpaiFile +
            ", nongshianpaiAddress=" + nongshianpaiAddress +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", nongshianpaiTime=" + DateUtil.convertString(nongshianpaiTime,"yyyy-MM-dd") +
            ", nongshianpaiTypes=" + nongshianpaiTypes +
            ", nongshianpaiContent=" + nongshianpaiContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
