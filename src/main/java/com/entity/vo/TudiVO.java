package com.entity.vo;

import com.entity.TudiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 土地规划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tudi")
public class TudiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 土地名称
     */

    @TableField(value = "tudi_name")
    private String tudiName;


    /**
     * 土地编号
     */

    @TableField(value = "tudi_uuid_number")
    private String tudiUuidNumber;


    /**
     * 土地照片
     */

    @TableField(value = "tudi_photo")
    private String tudiPhoto;


    /**
     * 土地位置
     */

    @TableField(value = "tudi_address")
    private String tudiAddress;


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
     * 土地类型
     */

    @TableField(value = "tudi_types")
    private Integer tudiTypes;


    /**
     * 土地面积(平方)
     */

    @TableField(value = "tudi_mianji")
    private Integer tudiMianji;


    /**
     * 土地热度
     */

    @TableField(value = "tudi_clicknum")
    private Integer tudiClicknum;


    /**
     * 规划时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "tudi_time")
    private Date tudiTime;


    /**
     * 土地备注
     */

    @TableField(value = "tudi_content")
    private String tudiContent;


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
	 * 设置：土地名称
	 */
    public String getTudiName() {
        return tudiName;
    }


    /**
	 * 获取：土地名称
	 */

    public void setTudiName(String tudiName) {
        this.tudiName = tudiName;
    }
    /**
	 * 设置：土地编号
	 */
    public String getTudiUuidNumber() {
        return tudiUuidNumber;
    }


    /**
	 * 获取：土地编号
	 */

    public void setTudiUuidNumber(String tudiUuidNumber) {
        this.tudiUuidNumber = tudiUuidNumber;
    }
    /**
	 * 设置：土地照片
	 */
    public String getTudiPhoto() {
        return tudiPhoto;
    }


    /**
	 * 获取：土地照片
	 */

    public void setTudiPhoto(String tudiPhoto) {
        this.tudiPhoto = tudiPhoto;
    }
    /**
	 * 设置：土地位置
	 */
    public String getTudiAddress() {
        return tudiAddress;
    }


    /**
	 * 获取：土地位置
	 */

    public void setTudiAddress(String tudiAddress) {
        this.tudiAddress = tudiAddress;
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
	 * 设置：土地类型
	 */
    public Integer getTudiTypes() {
        return tudiTypes;
    }


    /**
	 * 获取：土地类型
	 */

    public void setTudiTypes(Integer tudiTypes) {
        this.tudiTypes = tudiTypes;
    }
    /**
	 * 设置：土地面积(平方)
	 */
    public Integer getTudiMianji() {
        return tudiMianji;
    }


    /**
	 * 获取：土地面积(平方)
	 */

    public void setTudiMianji(Integer tudiMianji) {
        this.tudiMianji = tudiMianji;
    }
    /**
	 * 设置：土地热度
	 */
    public Integer getTudiClicknum() {
        return tudiClicknum;
    }


    /**
	 * 获取：土地热度
	 */

    public void setTudiClicknum(Integer tudiClicknum) {
        this.tudiClicknum = tudiClicknum;
    }
    /**
	 * 设置：规划时间
	 */
    public Date getTudiTime() {
        return tudiTime;
    }


    /**
	 * 获取：规划时间
	 */

    public void setTudiTime(Date tudiTime) {
        this.tudiTime = tudiTime;
    }
    /**
	 * 设置：土地备注
	 */
    public String getTudiContent() {
        return tudiContent;
    }


    /**
	 * 获取：土地备注
	 */

    public void setTudiContent(String tudiContent) {
        this.tudiContent = tudiContent;
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
