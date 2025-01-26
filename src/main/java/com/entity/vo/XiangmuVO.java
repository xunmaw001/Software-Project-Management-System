package com.entity.vo;

import com.entity.XiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiangmu")
public class XiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 项目经理
     */

    @TableField(value = "xiangmujingli_id")
    private Integer xiangmujingliId;


    /**
     * 项目名称
     */

    @TableField(value = "xiangmu_name")
    private String xiangmuName;


    /**
     * 项目编号
     */

    @TableField(value = "xiangmu_uuid_number")
    private String xiangmuUuidNumber;


    /**
     * 项目类型
     */

    @TableField(value = "xiangmu_types")
    private Integer xiangmuTypes;


    /**
     * 项目金额
     */

    @TableField(value = "xiangmu_jine")
    private Double xiangmuJine;


    /**
     * 剩余金额
     */

    @TableField(value = "xiangmu_shengyu_jine")
    private Double xiangmuShengyuJine;


    /**
     * 项目附件
     */

    @TableField(value = "xiangmu_file")
    private String xiangmuFile;


    /**
     * 项目介绍
     */

    @TableField(value = "xiangmu_content")
    private String xiangmuContent;


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
	 * 设置：项目经理
	 */
    public Integer getXiangmujingliId() {
        return xiangmujingliId;
    }


    /**
	 * 获取：项目经理
	 */

    public void setXiangmujingliId(Integer xiangmujingliId) {
        this.xiangmujingliId = xiangmujingliId;
    }
    /**
	 * 设置：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }


    /**
	 * 获取：项目名称
	 */

    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 设置：项目编号
	 */
    public String getXiangmuUuidNumber() {
        return xiangmuUuidNumber;
    }


    /**
	 * 获取：项目编号
	 */

    public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
        this.xiangmuUuidNumber = xiangmuUuidNumber;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }


    /**
	 * 获取：项目类型
	 */

    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 设置：项目金额
	 */
    public Double getXiangmuJine() {
        return xiangmuJine;
    }


    /**
	 * 获取：项目金额
	 */

    public void setXiangmuJine(Double xiangmuJine) {
        this.xiangmuJine = xiangmuJine;
    }
    /**
	 * 设置：剩余金额
	 */
    public Double getXiangmuShengyuJine() {
        return xiangmuShengyuJine;
    }


    /**
	 * 获取：剩余金额
	 */

    public void setXiangmuShengyuJine(Double xiangmuShengyuJine) {
        this.xiangmuShengyuJine = xiangmuShengyuJine;
    }
    /**
	 * 设置：项目附件
	 */
    public String getXiangmuFile() {
        return xiangmuFile;
    }


    /**
	 * 获取：项目附件
	 */

    public void setXiangmuFile(String xiangmuFile) {
        this.xiangmuFile = xiangmuFile;
    }
    /**
	 * 设置：项目介绍
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }


    /**
	 * 获取：项目介绍
	 */

    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
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
