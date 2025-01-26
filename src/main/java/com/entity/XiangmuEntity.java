package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 项目
 *
 * @author 
 * @email
 */
@TableName("xiangmu")
public class XiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuEntity() {

	}

	public XiangmuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 项目经理
     */
    @ColumnInfo(comment="项目经理",type="int(11)")
    @TableField(value = "xiangmujingli_id")

    private Integer xiangmujingliId;


    /**
     * 项目名称
     */
    @ColumnInfo(comment="项目名称",type="varchar(200)")
    @TableField(value = "xiangmu_name")

    private String xiangmuName;


    /**
     * 项目编号
     */
    @ColumnInfo(comment="项目编号",type="varchar(200)")
    @TableField(value = "xiangmu_uuid_number")

    private String xiangmuUuidNumber;


    /**
     * 项目类型
     */
    @ColumnInfo(comment="项目类型",type="int(11)")
    @TableField(value = "xiangmu_types")

    private Integer xiangmuTypes;


    /**
     * 项目金额
     */
    @ColumnInfo(comment="项目金额",type="decimal(10,2)")
    @TableField(value = "xiangmu_jine")

    private Double xiangmuJine;


    /**
     * 剩余金额
     */
    @ColumnInfo(comment="剩余金额",type="decimal(10,2)")
    @TableField(value = "xiangmu_shengyu_jine")

    private Double xiangmuShengyuJine;


    /**
     * 项目附件
     */
    @ColumnInfo(comment="项目附件",type="varchar(200)")
    @TableField(value = "xiangmu_file")

    private String xiangmuFile;


    /**
     * 项目介绍
     */
    @ColumnInfo(comment="项目介绍",type="longtext")
    @TableField(value = "xiangmu_content")

    private String xiangmuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：项目经理
	 */
    public Integer getXiangmujingliId() {
        return xiangmujingliId;
    }
    /**
	 * 设置：项目经理
	 */

    public void setXiangmujingliId(Integer xiangmujingliId) {
        this.xiangmujingliId = xiangmujingliId;
    }
    /**
	 * 获取：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }
    /**
	 * 设置：项目名称
	 */

    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 获取：项目编号
	 */
    public String getXiangmuUuidNumber() {
        return xiangmuUuidNumber;
    }
    /**
	 * 设置：项目编号
	 */

    public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
        this.xiangmuUuidNumber = xiangmuUuidNumber;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }
    /**
	 * 设置：项目类型
	 */

    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 获取：项目金额
	 */
    public Double getXiangmuJine() {
        return xiangmuJine;
    }
    /**
	 * 设置：项目金额
	 */

    public void setXiangmuJine(Double xiangmuJine) {
        this.xiangmuJine = xiangmuJine;
    }
    /**
	 * 获取：剩余金额
	 */
    public Double getXiangmuShengyuJine() {
        return xiangmuShengyuJine;
    }
    /**
	 * 设置：剩余金额
	 */

    public void setXiangmuShengyuJine(Double xiangmuShengyuJine) {
        this.xiangmuShengyuJine = xiangmuShengyuJine;
    }
    /**
	 * 获取：项目附件
	 */
    public String getXiangmuFile() {
        return xiangmuFile;
    }
    /**
	 * 设置：项目附件
	 */

    public void setXiangmuFile(String xiangmuFile) {
        this.xiangmuFile = xiangmuFile;
    }
    /**
	 * 获取：项目介绍
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }
    /**
	 * 设置：项目介绍
	 */

    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
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

    @Override
    public String toString() {
        return "Xiangmu{" +
            ", id=" + id +
            ", xiangmujingliId=" + xiangmujingliId +
            ", xiangmuName=" + xiangmuName +
            ", xiangmuUuidNumber=" + xiangmuUuidNumber +
            ", xiangmuTypes=" + xiangmuTypes +
            ", xiangmuJine=" + xiangmuJine +
            ", xiangmuShengyuJine=" + xiangmuShengyuJine +
            ", xiangmuFile=" + xiangmuFile +
            ", xiangmuContent=" + xiangmuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
