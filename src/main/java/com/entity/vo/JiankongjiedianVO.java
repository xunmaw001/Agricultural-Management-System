package com.entity.vo;

import com.entity.JiankongjiedianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 监控节点
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankongjiedian")
public class JiankongjiedianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 监控节点编号
     */

    @TableField(value = "jiankongjiedian_uuid_number")
    private String jiankongjiedianUuidNumber;


    /**
     * 监控节点名称
     */

    @TableField(value = "jiankongjiedian_name")
    private String jiankongjiedianName;


    /**
     * 监控节点照片
     */

    @TableField(value = "jiankongjiedian_photo")
    private String jiankongjiedianPhoto;


    /**
     * 监控位置
     */

    @TableField(value = "jiankongjiedian_address")
    private String jiankongjiedianAddress;


    /**
     * 监控节点类型
     */

    @TableField(value = "jiankongjiedian_types")
    private Integer jiankongjiedianTypes;


    /**
     * 监控节点备注
     */

    @TableField(value = "jiankongjiedian_content")
    private String jiankongjiedianContent;


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
	 * 设置：监控节点编号
	 */
    public String getJiankongjiedianUuidNumber() {
        return jiankongjiedianUuidNumber;
    }


    /**
	 * 获取：监控节点编号
	 */

    public void setJiankongjiedianUuidNumber(String jiankongjiedianUuidNumber) {
        this.jiankongjiedianUuidNumber = jiankongjiedianUuidNumber;
    }
    /**
	 * 设置：监控节点名称
	 */
    public String getJiankongjiedianName() {
        return jiankongjiedianName;
    }


    /**
	 * 获取：监控节点名称
	 */

    public void setJiankongjiedianName(String jiankongjiedianName) {
        this.jiankongjiedianName = jiankongjiedianName;
    }
    /**
	 * 设置：监控节点照片
	 */
    public String getJiankongjiedianPhoto() {
        return jiankongjiedianPhoto;
    }


    /**
	 * 获取：监控节点照片
	 */

    public void setJiankongjiedianPhoto(String jiankongjiedianPhoto) {
        this.jiankongjiedianPhoto = jiankongjiedianPhoto;
    }
    /**
	 * 设置：监控位置
	 */
    public String getJiankongjiedianAddress() {
        return jiankongjiedianAddress;
    }


    /**
	 * 获取：监控位置
	 */

    public void setJiankongjiedianAddress(String jiankongjiedianAddress) {
        this.jiankongjiedianAddress = jiankongjiedianAddress;
    }
    /**
	 * 设置：监控节点类型
	 */
    public Integer getJiankongjiedianTypes() {
        return jiankongjiedianTypes;
    }


    /**
	 * 获取：监控节点类型
	 */

    public void setJiankongjiedianTypes(Integer jiankongjiedianTypes) {
        this.jiankongjiedianTypes = jiankongjiedianTypes;
    }
    /**
	 * 设置：监控节点备注
	 */
    public String getJiankongjiedianContent() {
        return jiankongjiedianContent;
    }


    /**
	 * 获取：监控节点备注
	 */

    public void setJiankongjiedianContent(String jiankongjiedianContent) {
        this.jiankongjiedianContent = jiankongjiedianContent;
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
