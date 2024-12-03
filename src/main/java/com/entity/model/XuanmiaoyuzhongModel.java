package com.entity.model;

import com.entity.XuanmiaoyuzhongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 选苗育种
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuanmiaoyuzhongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 选苗育种编号
     */
    private String xuanmiaoyuzhongUuidNumber;


    /**
     * 选苗育种标题
     */
    private String xuanmiaoyuzhongName;


    /**
     * 选苗育种照片
     */
    private String xuanmiaoyuzhongPhoto;


    /**
     * 选苗育种地点
     */
    private String xuanmiaoyuzhongAddress;


    /**
     * 选苗育种类型
     */
    private Integer xuanmiaoyuzhongTypes;


    /**
     * 挑选数量
     */
    private Integer xuanmiaoyuzhongTiaoxuanNumber;


    /**
     * 挑选出数量
     */
    private Integer xuanmiaoyuzhongTiaoxuanhouNumber;


    /**
     * 挑选时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xuanmiaoyuzhongTime;


    /**
     * 选苗育种备注
     */
    private String xuanmiaoyuzhongContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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

    }
