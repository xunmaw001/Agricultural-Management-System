package com.entity.model;

import com.entity.JiankongjiedianJiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 监控记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankongjiedianJiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 监控记录编号
     */
    private String jiankongjiedianJiluUuidNumber;


    /**
     * 监控记录名称
     */
    private String jiankongjiedianJiluName;


    /**
     * 监拍照片
     */
    private String jiankongjiedianJiluPhoto;


    /**
     * 监控数值
     */
    private String jiankongjiedianShuzhi;


    /**
     * 监控记录备注
     */
    private String jiankongjiedianJiluContent;


    /**
     * 上传时间
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
	 * 获取：监控记录编号
	 */
    public String getJiankongjiedianJiluUuidNumber() {
        return jiankongjiedianJiluUuidNumber;
    }


    /**
	 * 设置：监控记录编号
	 */
    public void setJiankongjiedianJiluUuidNumber(String jiankongjiedianJiluUuidNumber) {
        this.jiankongjiedianJiluUuidNumber = jiankongjiedianJiluUuidNumber;
    }
    /**
	 * 获取：监控记录名称
	 */
    public String getJiankongjiedianJiluName() {
        return jiankongjiedianJiluName;
    }


    /**
	 * 设置：监控记录名称
	 */
    public void setJiankongjiedianJiluName(String jiankongjiedianJiluName) {
        this.jiankongjiedianJiluName = jiankongjiedianJiluName;
    }
    /**
	 * 获取：监拍照片
	 */
    public String getJiankongjiedianJiluPhoto() {
        return jiankongjiedianJiluPhoto;
    }


    /**
	 * 设置：监拍照片
	 */
    public void setJiankongjiedianJiluPhoto(String jiankongjiedianJiluPhoto) {
        this.jiankongjiedianJiluPhoto = jiankongjiedianJiluPhoto;
    }
    /**
	 * 获取：监控数值
	 */
    public String getJiankongjiedianShuzhi() {
        return jiankongjiedianShuzhi;
    }


    /**
	 * 设置：监控数值
	 */
    public void setJiankongjiedianShuzhi(String jiankongjiedianShuzhi) {
        this.jiankongjiedianShuzhi = jiankongjiedianShuzhi;
    }
    /**
	 * 获取：监控记录备注
	 */
    public String getJiankongjiedianJiluContent() {
        return jiankongjiedianJiluContent;
    }


    /**
	 * 设置：监控记录备注
	 */
    public void setJiankongjiedianJiluContent(String jiankongjiedianJiluContent) {
        this.jiankongjiedianJiluContent = jiankongjiedianJiluContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：上传时间
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
