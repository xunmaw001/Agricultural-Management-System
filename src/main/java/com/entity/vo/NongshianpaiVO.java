package com.entity.vo;

import com.entity.NongshianpaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农事安排
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongshianpai")
public class NongshianpaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 农事安排编号
     */

    @TableField(value = "nongshianpai_uuid_number")
    private String nongshianpaiUuidNumber;


    /**
     * 农事安排标题
     */

    @TableField(value = "nongshianpai_name")
    private String nongshianpaiName;


    /**
     * 农事安排附件
     */

    @TableField(value = "nongshianpai_file")
    private String nongshianpaiFile;


    /**
     * 安排地点
     */

    @TableField(value = "nongshianpai_address")
    private String nongshianpaiAddress;


    /**
     * 安排时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 要执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "nongshianpai_time")
    private Date nongshianpaiTime;


    /**
     * 农事安排类型
     */

    @TableField(value = "nongshianpai_types")
    private Integer nongshianpaiTypes;


    /**
     * 农事安排内容
     */

    @TableField(value = "nongshianpai_content")
    private String nongshianpaiContent;


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
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：农事安排编号
	 */
    public String getNongshianpaiUuidNumber() {
        return nongshianpaiUuidNumber;
    }


    /**
	 * 获取：农事安排编号
	 */

    public void setNongshianpaiUuidNumber(String nongshianpaiUuidNumber) {
        this.nongshianpaiUuidNumber = nongshianpaiUuidNumber;
    }
    /**
	 * 设置：农事安排标题
	 */
    public String getNongshianpaiName() {
        return nongshianpaiName;
    }


    /**
	 * 获取：农事安排标题
	 */

    public void setNongshianpaiName(String nongshianpaiName) {
        this.nongshianpaiName = nongshianpaiName;
    }
    /**
	 * 设置：农事安排附件
	 */
    public String getNongshianpaiFile() {
        return nongshianpaiFile;
    }


    /**
	 * 获取：农事安排附件
	 */

    public void setNongshianpaiFile(String nongshianpaiFile) {
        this.nongshianpaiFile = nongshianpaiFile;
    }
    /**
	 * 设置：安排地点
	 */
    public String getNongshianpaiAddress() {
        return nongshianpaiAddress;
    }


    /**
	 * 获取：安排地点
	 */

    public void setNongshianpaiAddress(String nongshianpaiAddress) {
        this.nongshianpaiAddress = nongshianpaiAddress;
    }
    /**
	 * 设置：安排时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：安排时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：要执行时间
	 */
    public Date getNongshianpaiTime() {
        return nongshianpaiTime;
    }


    /**
	 * 获取：要执行时间
	 */

    public void setNongshianpaiTime(Date nongshianpaiTime) {
        this.nongshianpaiTime = nongshianpaiTime;
    }
    /**
	 * 设置：农事安排类型
	 */
    public Integer getNongshianpaiTypes() {
        return nongshianpaiTypes;
    }


    /**
	 * 获取：农事安排类型
	 */

    public void setNongshianpaiTypes(Integer nongshianpaiTypes) {
        this.nongshianpaiTypes = nongshianpaiTypes;
    }
    /**
	 * 设置：农事安排内容
	 */
    public String getNongshianpaiContent() {
        return nongshianpaiContent;
    }


    /**
	 * 获取：农事安排内容
	 */

    public void setNongshianpaiContent(String nongshianpaiContent) {
        this.nongshianpaiContent = nongshianpaiContent;
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
