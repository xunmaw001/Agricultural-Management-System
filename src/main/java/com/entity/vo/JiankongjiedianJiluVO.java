package com.entity.vo;

import com.entity.JiankongjiedianJiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 监控记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankongjiedian_jilu")
public class JiankongjiedianJiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 监控记录编号
     */

    @TableField(value = "jiankongjiedian_jilu_uuid_number")
    private String jiankongjiedianJiluUuidNumber;


    /**
     * 监控记录名称
     */

    @TableField(value = "jiankongjiedian_jilu_name")
    private String jiankongjiedianJiluName;


    /**
     * 监拍照片
     */

    @TableField(value = "jiankongjiedian_jilu_photo")
    private String jiankongjiedianJiluPhoto;


    /**
     * 监控数值
     */

    @TableField(value = "jiankongjiedian_shuzhi")
    private String jiankongjiedianShuzhi;


    /**
     * 监控记录备注
     */

    @TableField(value = "jiankongjiedian_jilu_content")
    private String jiankongjiedianJiluContent;


    /**
     * 上传时间
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
	 * 设置：监控记录编号
	 */
    public String getJiankongjiedianJiluUuidNumber() {
        return jiankongjiedianJiluUuidNumber;
    }


    /**
	 * 获取：监控记录编号
	 */

    public void setJiankongjiedianJiluUuidNumber(String jiankongjiedianJiluUuidNumber) {
        this.jiankongjiedianJiluUuidNumber = jiankongjiedianJiluUuidNumber;
    }
    /**
	 * 设置：监控记录名称
	 */
    public String getJiankongjiedianJiluName() {
        return jiankongjiedianJiluName;
    }


    /**
	 * 获取：监控记录名称
	 */

    public void setJiankongjiedianJiluName(String jiankongjiedianJiluName) {
        this.jiankongjiedianJiluName = jiankongjiedianJiluName;
    }
    /**
	 * 设置：监拍照片
	 */
    public String getJiankongjiedianJiluPhoto() {
        return jiankongjiedianJiluPhoto;
    }


    /**
	 * 获取：监拍照片
	 */

    public void setJiankongjiedianJiluPhoto(String jiankongjiedianJiluPhoto) {
        this.jiankongjiedianJiluPhoto = jiankongjiedianJiluPhoto;
    }
    /**
	 * 设置：监控数值
	 */
    public String getJiankongjiedianShuzhi() {
        return jiankongjiedianShuzhi;
    }


    /**
	 * 获取：监控数值
	 */

    public void setJiankongjiedianShuzhi(String jiankongjiedianShuzhi) {
        this.jiankongjiedianShuzhi = jiankongjiedianShuzhi;
    }
    /**
	 * 设置：监控记录备注
	 */
    public String getJiankongjiedianJiluContent() {
        return jiankongjiedianJiluContent;
    }


    /**
	 * 获取：监控记录备注
	 */

    public void setJiankongjiedianJiluContent(String jiankongjiedianJiluContent) {
        this.jiankongjiedianJiluContent = jiankongjiedianJiluContent;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
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
