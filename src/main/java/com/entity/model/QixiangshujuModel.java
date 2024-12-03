package com.entity.model;

import com.entity.QixiangshujuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 气象数据
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QixiangshujuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 气象数据标题
     */
    private String qixiangshujuName;


    /**
     * 气象数据编号
     */
    private String qixiangshujuUuidNumber;


    /**
     * 封面
     */
    private String qixiangshujuPhoto;


    /**
     * 气象地址
     */
    private String qixiangshujuAddress;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 气象类型
     */
    private Integer qixiangshujuTypes;


    /**
     * 气象值(大)
     */
    private Double qixiangshujuDaZhi;


    /**
     * 气象值(小)
     */
    private Double qixiangshujuXiaoZhi;


    /**
     * 气象热度
     */
    private Integer qixiangshujuClicknum;


    /**
     * 所属时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qixiangshujuTime;


    /**
     * 气象数据详情
     */
    private String qixiangshujuContent;


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
	 * 获取：气象数据标题
	 */
    public String getQixiangshujuName() {
        return qixiangshujuName;
    }


    /**
	 * 设置：气象数据标题
	 */
    public void setQixiangshujuName(String qixiangshujuName) {
        this.qixiangshujuName = qixiangshujuName;
    }
    /**
	 * 获取：气象数据编号
	 */
    public String getQixiangshujuUuidNumber() {
        return qixiangshujuUuidNumber;
    }


    /**
	 * 设置：气象数据编号
	 */
    public void setQixiangshujuUuidNumber(String qixiangshujuUuidNumber) {
        this.qixiangshujuUuidNumber = qixiangshujuUuidNumber;
    }
    /**
	 * 获取：封面
	 */
    public String getQixiangshujuPhoto() {
        return qixiangshujuPhoto;
    }


    /**
	 * 设置：封面
	 */
    public void setQixiangshujuPhoto(String qixiangshujuPhoto) {
        this.qixiangshujuPhoto = qixiangshujuPhoto;
    }
    /**
	 * 获取：气象地址
	 */
    public String getQixiangshujuAddress() {
        return qixiangshujuAddress;
    }


    /**
	 * 设置：气象地址
	 */
    public void setQixiangshujuAddress(String qixiangshujuAddress) {
        this.qixiangshujuAddress = qixiangshujuAddress;
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
	 * 获取：气象类型
	 */
    public Integer getQixiangshujuTypes() {
        return qixiangshujuTypes;
    }


    /**
	 * 设置：气象类型
	 */
    public void setQixiangshujuTypes(Integer qixiangshujuTypes) {
        this.qixiangshujuTypes = qixiangshujuTypes;
    }
    /**
	 * 获取：气象值(大)
	 */
    public Double getQixiangshujuDaZhi() {
        return qixiangshujuDaZhi;
    }


    /**
	 * 设置：气象值(大)
	 */
    public void setQixiangshujuDaZhi(Double qixiangshujuDaZhi) {
        this.qixiangshujuDaZhi = qixiangshujuDaZhi;
    }
    /**
	 * 获取：气象值(小)
	 */
    public Double getQixiangshujuXiaoZhi() {
        return qixiangshujuXiaoZhi;
    }


    /**
	 * 设置：气象值(小)
	 */
    public void setQixiangshujuXiaoZhi(Double qixiangshujuXiaoZhi) {
        this.qixiangshujuXiaoZhi = qixiangshujuXiaoZhi;
    }
    /**
	 * 获取：气象热度
	 */
    public Integer getQixiangshujuClicknum() {
        return qixiangshujuClicknum;
    }


    /**
	 * 设置：气象热度
	 */
    public void setQixiangshujuClicknum(Integer qixiangshujuClicknum) {
        this.qixiangshujuClicknum = qixiangshujuClicknum;
    }
    /**
	 * 获取：所属时间
	 */
    public Date getQixiangshujuTime() {
        return qixiangshujuTime;
    }


    /**
	 * 设置：所属时间
	 */
    public void setQixiangshujuTime(Date qixiangshujuTime) {
        this.qixiangshujuTime = qixiangshujuTime;
    }
    /**
	 * 获取：气象数据详情
	 */
    public String getQixiangshujuContent() {
        return qixiangshujuContent;
    }


    /**
	 * 设置：气象数据详情
	 */
    public void setQixiangshujuContent(String qixiangshujuContent) {
        this.qixiangshujuContent = qixiangshujuContent;
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
