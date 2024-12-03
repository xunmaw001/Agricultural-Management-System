package com.entity.model;

import com.entity.NongzuowuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农作物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NongzuowuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 土地
     */
    private Integer tudiId;


    /**
     * 农作物编号
     */
    private String nongzuowuUuidNumber;


    /**
     * 农作物名称
     */
    private String nongzuowuName;


    /**
     * 农作物照片
     */
    private String nongzuowuPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 农作物类型
     */
    private Integer nongzuowuTypes;


    /**
     * 种植数量
     */
    private Integer nongzuowuKucunNumber;


    /**
     * 农作物热度
     */
    private Integer nongzuowuClicknum;


    /**
     * 种植开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date nongzuowuKaishiTime;


    /**
     * 种植预计结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date nongzuowuYujijieshuTime;


    /**
     * 农作物种植备注
     */
    private String nongzuowuContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
