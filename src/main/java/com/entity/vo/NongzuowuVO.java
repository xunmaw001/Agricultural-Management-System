package com.entity.vo;

import com.entity.NongzuowuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农作物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongzuowu")
public class NongzuowuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 土地
     */

    @TableField(value = "tudi_id")
    private Integer tudiId;


    /**
     * 农作物编号
     */

    @TableField(value = "nongzuowu_uuid_number")
    private String nongzuowuUuidNumber;


    /**
     * 农作物名称
     */

    @TableField(value = "nongzuowu_name")
    private String nongzuowuName;


    /**
     * 农作物照片
     */

    @TableField(value = "nongzuowu_photo")
    private String nongzuowuPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 农作物类型
     */

    @TableField(value = "nongzuowu_types")
    private Integer nongzuowuTypes;


    /**
     * 种植数量
     */

    @TableField(value = "nongzuowu_kucun_number")
    private Integer nongzuowuKucunNumber;


    /**
     * 农作物热度
     */

    @TableField(value = "nongzuowu_clicknum")
    private Integer nongzuowuClicknum;


    /**
     * 种植开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "nongzuowu_kaishi_time")
    private Date nongzuowuKaishiTime;


    /**
     * 种植预计结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "nongzuowu_yujijieshu_time")
    private Date nongzuowuYujijieshuTime;


    /**
     * 农作物种植备注
     */

    @TableField(value = "nongzuowu_content")
    private String nongzuowuContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：土地
	 */
    public Integer getTudiId() {
        return tudiId;
    }


    /**
	 * 获取：土地
	 */

    public void setTudiId(Integer tudiId) {
        this.tudiId = tudiId;
    }
    /**
	 * 设置：农作物编号
	 */
    public String getNongzuowuUuidNumber() {
        return nongzuowuUuidNumber;
    }


    /**
	 * 获取：农作物编号
	 */

    public void setNongzuowuUuidNumber(String nongzuowuUuidNumber) {
        this.nongzuowuUuidNumber = nongzuowuUuidNumber;
    }
    /**
	 * 设置：农作物名称
	 */
    public String getNongzuowuName() {
        return nongzuowuName;
    }


    /**
	 * 获取：农作物名称
	 */

    public void setNongzuowuName(String nongzuowuName) {
        this.nongzuowuName = nongzuowuName;
    }
    /**
	 * 设置：农作物照片
	 */
    public String getNongzuowuPhoto() {
        return nongzuowuPhoto;
    }


    /**
	 * 获取：农作物照片
	 */

    public void setNongzuowuPhoto(String nongzuowuPhoto) {
        this.nongzuowuPhoto = nongzuowuPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：农作物类型
	 */
    public Integer getNongzuowuTypes() {
        return nongzuowuTypes;
    }


    /**
	 * 获取：农作物类型
	 */

    public void setNongzuowuTypes(Integer nongzuowuTypes) {
        this.nongzuowuTypes = nongzuowuTypes;
    }
    /**
	 * 设置：种植数量
	 */
    public Integer getNongzuowuKucunNumber() {
        return nongzuowuKucunNumber;
    }


    /**
	 * 获取：种植数量
	 */

    public void setNongzuowuKucunNumber(Integer nongzuowuKucunNumber) {
        this.nongzuowuKucunNumber = nongzuowuKucunNumber;
    }
    /**
	 * 设置：农作物热度
	 */
    public Integer getNongzuowuClicknum() {
        return nongzuowuClicknum;
    }


    /**
	 * 获取：农作物热度
	 */

    public void setNongzuowuClicknum(Integer nongzuowuClicknum) {
        this.nongzuowuClicknum = nongzuowuClicknum;
    }
    /**
	 * 设置：种植开始时间
	 */
    public Date getNongzuowuKaishiTime() {
        return nongzuowuKaishiTime;
    }


    /**
	 * 获取：种植开始时间
	 */

    public void setNongzuowuKaishiTime(Date nongzuowuKaishiTime) {
        this.nongzuowuKaishiTime = nongzuowuKaishiTime;
    }
    /**
	 * 设置：种植预计结束时间
	 */
    public Date getNongzuowuYujijieshuTime() {
        return nongzuowuYujijieshuTime;
    }


    /**
	 * 获取：种植预计结束时间
	 */

    public void setNongzuowuYujijieshuTime(Date nongzuowuYujijieshuTime) {
        this.nongzuowuYujijieshuTime = nongzuowuYujijieshuTime;
    }
    /**
	 * 设置：农作物种植备注
	 */
    public String getNongzuowuContent() {
        return nongzuowuContent;
    }


    /**
	 * 获取：农作物种植备注
	 */

    public void setNongzuowuContent(String nongzuowuContent) {
        this.nongzuowuContent = nongzuowuContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
