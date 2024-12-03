package com.entity.vo;

import com.entity.XuanmiaoyuzhongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 选苗育种
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuanmiaoyuzhong")
public class XuanmiaoyuzhongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 选苗育种编号
     */

    @TableField(value = "xuanmiaoyuzhong_uuid_number")
    private String xuanmiaoyuzhongUuidNumber;


    /**
     * 选苗育种标题
     */

    @TableField(value = "xuanmiaoyuzhong_name")
    private String xuanmiaoyuzhongName;


    /**
     * 选苗育种照片
     */

    @TableField(value = "xuanmiaoyuzhong_photo")
    private String xuanmiaoyuzhongPhoto;


    /**
     * 选苗育种地点
     */

    @TableField(value = "xuanmiaoyuzhong_address")
    private String xuanmiaoyuzhongAddress;


    /**
     * 选苗育种类型
     */

    @TableField(value = "xuanmiaoyuzhong_types")
    private Integer xuanmiaoyuzhongTypes;


    /**
     * 挑选数量
     */

    @TableField(value = "xuanmiaoyuzhong_tiaoxuan_number")
    private Integer xuanmiaoyuzhongTiaoxuanNumber;


    /**
     * 挑选出数量
     */

    @TableField(value = "xuanmiaoyuzhong_tiaoxuanhou_number")
    private Integer xuanmiaoyuzhongTiaoxuanhouNumber;


    /**
     * 挑选时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xuanmiaoyuzhong_time")
    private Date xuanmiaoyuzhongTime;


    /**
     * 选苗育种备注
     */

    @TableField(value = "xuanmiaoyuzhong_content")
    private String xuanmiaoyuzhongContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：选苗育种编号
	 */
    public String getXuanmiaoyuzhongUuidNumber() {
        return xuanmiaoyuzhongUuidNumber;
    }


    /**
	 * 获取：选苗育种编号
	 */

    public void setXuanmiaoyuzhongUuidNumber(String xuanmiaoyuzhongUuidNumber) {
        this.xuanmiaoyuzhongUuidNumber = xuanmiaoyuzhongUuidNumber;
    }
    /**
	 * 设置：选苗育种标题
	 */
    public String getXuanmiaoyuzhongName() {
        return xuanmiaoyuzhongName;
    }


    /**
	 * 获取：选苗育种标题
	 */

    public void setXuanmiaoyuzhongName(String xuanmiaoyuzhongName) {
        this.xuanmiaoyuzhongName = xuanmiaoyuzhongName;
    }
    /**
	 * 设置：选苗育种照片
	 */
    public String getXuanmiaoyuzhongPhoto() {
        return xuanmiaoyuzhongPhoto;
    }


    /**
	 * 获取：选苗育种照片
	 */

    public void setXuanmiaoyuzhongPhoto(String xuanmiaoyuzhongPhoto) {
        this.xuanmiaoyuzhongPhoto = xuanmiaoyuzhongPhoto;
    }
    /**
	 * 设置：选苗育种地点
	 */
    public String getXuanmiaoyuzhongAddress() {
        return xuanmiaoyuzhongAddress;
    }


    /**
	 * 获取：选苗育种地点
	 */

    public void setXuanmiaoyuzhongAddress(String xuanmiaoyuzhongAddress) {
        this.xuanmiaoyuzhongAddress = xuanmiaoyuzhongAddress;
    }
    /**
	 * 设置：选苗育种类型
	 */
    public Integer getXuanmiaoyuzhongTypes() {
        return xuanmiaoyuzhongTypes;
    }


    /**
	 * 获取：选苗育种类型
	 */

    public void setXuanmiaoyuzhongTypes(Integer xuanmiaoyuzhongTypes) {
        this.xuanmiaoyuzhongTypes = xuanmiaoyuzhongTypes;
    }
    /**
	 * 设置：挑选数量
	 */
    public Integer getXuanmiaoyuzhongTiaoxuanNumber() {
        return xuanmiaoyuzhongTiaoxuanNumber;
    }


    /**
	 * 获取：挑选数量
	 */

    public void setXuanmiaoyuzhongTiaoxuanNumber(Integer xuanmiaoyuzhongTiaoxuanNumber) {
        this.xuanmiaoyuzhongTiaoxuanNumber = xuanmiaoyuzhongTiaoxuanNumber;
    }
    /**
	 * 设置：挑选出数量
	 */
    public Integer getXuanmiaoyuzhongTiaoxuanhouNumber() {
        return xuanmiaoyuzhongTiaoxuanhouNumber;
    }


    /**
	 * 获取：挑选出数量
	 */

    public void setXuanmiaoyuzhongTiaoxuanhouNumber(Integer xuanmiaoyuzhongTiaoxuanhouNumber) {
        this.xuanmiaoyuzhongTiaoxuanhouNumber = xuanmiaoyuzhongTiaoxuanhouNumber;
    }
    /**
	 * 设置：挑选时间
	 */
    public Date getXuanmiaoyuzhongTime() {
        return xuanmiaoyuzhongTime;
    }


    /**
	 * 获取：挑选时间
	 */

    public void setXuanmiaoyuzhongTime(Date xuanmiaoyuzhongTime) {
        this.xuanmiaoyuzhongTime = xuanmiaoyuzhongTime;
    }
    /**
	 * 设置：选苗育种备注
	 */
    public String getXuanmiaoyuzhongContent() {
        return xuanmiaoyuzhongContent;
    }


    /**
	 * 获取：选苗育种备注
	 */

    public void setXuanmiaoyuzhongContent(String xuanmiaoyuzhongContent) {
        this.xuanmiaoyuzhongContent = xuanmiaoyuzhongContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
