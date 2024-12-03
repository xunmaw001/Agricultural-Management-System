package com.entity.model;

import com.entity.NongshianpaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农事安排
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NongshianpaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yuangongId;


    /**
     * 农事安排编号
     */
    private String nongshianpaiUuidNumber;


    /**
     * 农事安排标题
     */
    private String nongshianpaiName;


    /**
     * 农事安排附件
     */
    private String nongshianpaiFile;


    /**
     * 安排地点
     */
    private String nongshianpaiAddress;


    /**
     * 安排时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 要执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date nongshianpaiTime;


    /**
     * 农事安排类型
     */
    private Integer nongshianpaiTypes;


    /**
     * 农事安排内容
     */
    private String nongshianpaiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
