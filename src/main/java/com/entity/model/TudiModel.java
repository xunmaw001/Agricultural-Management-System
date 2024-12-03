package com.entity.model;

import com.entity.TudiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 土地规划
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TudiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 土地名称
     */
    private String tudiName;


    /**
     * 土地编号
     */
    private String tudiUuidNumber;


    /**
     * 土地照片
     */
    private String tudiPhoto;


    /**
     * 土地位置
     */
    private String tudiAddress;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 土地类型
     */
    private Integer tudiTypes;


    /**
     * 土地面积(平方)
     */
    private Integer tudiMianji;


    /**
     * 土地热度
     */
    private Integer tudiClicknum;


    /**
     * 规划时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date tudiTime;


    /**
     * 土地备注
     */
    private String tudiContent;


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
