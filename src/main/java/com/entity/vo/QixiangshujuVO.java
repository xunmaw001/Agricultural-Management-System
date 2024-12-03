package com.entity.vo;

import com.entity.QixiangshujuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 气象数据
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qixiangshuju")
public class QixiangshujuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 气象数据标题
     */

    @TableField(value = "qixiangshuju_name")
    private String qixiangshujuName;


    /**
     * 气象数据编号
     */

    @TableField(value = "qixiangshuju_uuid_number")
    private String qixiangshujuUuidNumber;


    /**
     * 封面
     */

    @TableField(value = "qixiangshuju_photo")
    private String qixiangshujuPhoto;


    /**
     * 气象地址
     */

    @TableField(value = "qixiangshuju_address")
    private String qixiangshujuAddress;


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
     * 气象类型
     */

    @TableField(value = "qixiangshuju_types")
    private Integer qixiangshujuTypes;


    /**
     * 气象值(大)
     */

    @TableField(value = "qixiangshuju_da_zhi")
    private Double qixiangshujuDaZhi;


    /**
     * 气象值(小)
     */

    @TableField(value = "qixiangshuju_xiao_zhi")
    private Double qixiangshujuXiaoZhi;


    /**
     * 气象热度
     */

    @TableField(value = "qixiangshuju_clicknum")
    private Integer qixiangshujuClicknum;


    /**
     * 所属时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qixiangshuju_time")
    private Date qixiangshujuTime;


    /**
     * 气象数据详情
     */

    @TableField(value = "qixiangshuju_content")
    private String qixiangshujuContent;


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
	 * 设置：气象数据标题
	 */
    public String getQixiangshujuName() {
        return qixiangshujuName;
    }


    /**
	 * 获取：气象数据标题
	 */

    public void setQixiangshujuName(String qixiangshujuName) {
        this.qixiangshujuName = qixiangshujuName;
    }
    /**
	 * 设置：气象数据编号
	 */
    public String getQixiangshujuUuidNumber() {
        return qixiangshujuUuidNumber;
    }


    /**
	 * 获取：气象数据编号
	 */

    public void setQixiangshujuUuidNumber(String qixiangshujuUuidNumber) {
        this.qixiangshujuUuidNumber = qixiangshujuUuidNumber;
    }
    /**
	 * 设置：封面
	 */
    public String getQixiangshujuPhoto() {
        return qixiangshujuPhoto;
    }


    /**
	 * 获取：封面
	 */

    public void setQixiangshujuPhoto(String qixiangshujuPhoto) {
        this.qixiangshujuPhoto = qixiangshujuPhoto;
    }
    /**
	 * 设置：气象地址
	 */
    public String getQixiangshujuAddress() {
        return qixiangshujuAddress;
    }


    /**
	 * 获取：气象地址
	 */

    public void setQixiangshujuAddress(String qixiangshujuAddress) {
        this.qixiangshujuAddress = qixiangshujuAddress;
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
	 * 设置：气象类型
	 */
    public Integer getQixiangshujuTypes() {
        return qixiangshujuTypes;
    }


    /**
	 * 获取：气象类型
	 */

    public void setQixiangshujuTypes(Integer qixiangshujuTypes) {
        this.qixiangshujuTypes = qixiangshujuTypes;
    }
    /**
	 * 设置：气象值(大)
	 */
    public Double getQixiangshujuDaZhi() {
        return qixiangshujuDaZhi;
    }


    /**
	 * 获取：气象值(大)
	 */

    public void setQixiangshujuDaZhi(Double qixiangshujuDaZhi) {
        this.qixiangshujuDaZhi = qixiangshujuDaZhi;
    }
    /**
	 * 设置：气象值(小)
	 */
    public Double getQixiangshujuXiaoZhi() {
        return qixiangshujuXiaoZhi;
    }


    /**
	 * 获取：气象值(小)
	 */

    public void setQixiangshujuXiaoZhi(Double qixiangshujuXiaoZhi) {
        this.qixiangshujuXiaoZhi = qixiangshujuXiaoZhi;
    }
    /**
	 * 设置：气象热度
	 */
    public Integer getQixiangshujuClicknum() {
        return qixiangshujuClicknum;
    }


    /**
	 * 获取：气象热度
	 */

    public void setQixiangshujuClicknum(Integer qixiangshujuClicknum) {
        this.qixiangshujuClicknum = qixiangshujuClicknum;
    }
    /**
	 * 设置：所属时间
	 */
    public Date getQixiangshujuTime() {
        return qixiangshujuTime;
    }


    /**
	 * 获取：所属时间
	 */

    public void setQixiangshujuTime(Date qixiangshujuTime) {
        this.qixiangshujuTime = qixiangshujuTime;
    }
    /**
	 * 设置：气象数据详情
	 */
    public String getQixiangshujuContent() {
        return qixiangshujuContent;
    }


    /**
	 * 获取：气象数据详情
	 */

    public void setQixiangshujuContent(String qixiangshujuContent) {
        this.qixiangshujuContent = qixiangshujuContent;
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
