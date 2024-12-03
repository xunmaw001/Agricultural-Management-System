package com.entity.model;

import com.entity.JiankongjiedianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 监控节点
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankongjiedianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 监控节点编号
     */
    private String jiankongjiedianUuidNumber;


    /**
     * 监控节点名称
     */
    private String jiankongjiedianName;


    /**
     * 监控节点照片
     */
    private String jiankongjiedianPhoto;


    /**
     * 监控位置
     */
    private String jiankongjiedianAddress;


    /**
     * 监控节点类型
     */
    private Integer jiankongjiedianTypes;


    /**
     * 监控节点备注
     */
    private String jiankongjiedianContent;


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
	 * 获取：监控节点编号
	 */
    public String getJiankongjiedianUuidNumber() {
        return jiankongjiedianUuidNumber;
    }


    /**
	 * 设置：监控节点编号
	 */
    public void setJiankongjiedianUuidNumber(String jiankongjiedianUuidNumber) {
        this.jiankongjiedianUuidNumber = jiankongjiedianUuidNumber;
    }
    /**
	 * 获取：监控节点名称
	 */
    public String getJiankongjiedianName() {
        return jiankongjiedianName;
    }


    /**
	 * 设置：监控节点名称
	 */
    public void setJiankongjiedianName(String jiankongjiedianName) {
        this.jiankongjiedianName = jiankongjiedianName;
    }
    /**
	 * 获取：监控节点照片
	 */
    public String getJiankongjiedianPhoto() {
        return jiankongjiedianPhoto;
    }


    /**
	 * 设置：监控节点照片
	 */
    public void setJiankongjiedianPhoto(String jiankongjiedianPhoto) {
        this.jiankongjiedianPhoto = jiankongjiedianPhoto;
    }
    /**
	 * 获取：监控位置
	 */
    public String getJiankongjiedianAddress() {
        return jiankongjiedianAddress;
    }


    /**
	 * 设置：监控位置
	 */
    public void setJiankongjiedianAddress(String jiankongjiedianAddress) {
        this.jiankongjiedianAddress = jiankongjiedianAddress;
    }
    /**
	 * 获取：监控节点类型
	 */
    public Integer getJiankongjiedianTypes() {
        return jiankongjiedianTypes;
    }


    /**
	 * 设置：监控节点类型
	 */
    public void setJiankongjiedianTypes(Integer jiankongjiedianTypes) {
        this.jiankongjiedianTypes = jiankongjiedianTypes;
    }
    /**
	 * 获取：监控节点备注
	 */
    public String getJiankongjiedianContent() {
        return jiankongjiedianContent;
    }


    /**
	 * 设置：监控节点备注
	 */
    public void setJiankongjiedianContent(String jiankongjiedianContent) {
        this.jiankongjiedianContent = jiankongjiedianContent;
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
