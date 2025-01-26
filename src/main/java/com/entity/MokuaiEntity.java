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
 * 模块
 *
 * @author 
 * @email
 */
@TableName("mokuai")
public class MokuaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MokuaiEntity() {

	}

	public MokuaiEntity(T t) {
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
     * 项目
     */
    @ColumnInfo(comment="项目",type="int(11)")
    @TableField(value = "xiangmu_id")

    private Integer xiangmuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 模块编号
     */
    @ColumnInfo(comment="模块编号",type="varchar(200)")
    @TableField(value = "mokuai_uuid_number")

    private String mokuaiUuidNumber;


    /**
     * 模块名称
     */
    @ColumnInfo(comment="模块名称",type="varchar(200)")
    @TableField(value = "mokuai_name")

    private String mokuaiName;


    /**
     * 模块类型
     */
    @ColumnInfo(comment="模块类型",type="int(11)")
    @TableField(value = "mokuai_types")

    private Integer mokuaiTypes;


    /**
     * 模块经费
     */
    @ColumnInfo(comment="模块经费",type="decimal(10,2)")
    @TableField(value = "mokuai_jine")

    private Double mokuaiJine;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="分配时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 模块要求
     */
    @ColumnInfo(comment="模块要求",type="longtext")
    @TableField(value = "mokuai_content")

    private String mokuaiContent;


    /**
     * 模块状态
     */
    @ColumnInfo(comment="模块状态",type="int(11)")
    @TableField(value = "mokuai_zhuangtai_types")

    private Integer mokuaiZhuangtaiTypes;


    /**
     * 模块成果
     */
    @ColumnInfo(comment="模块成果",type="varchar(200)")
    @TableField(value = "mokuai_file")

    private String mokuaiFile;


    /**
     * 成果备注
     */
    @ColumnInfo(comment="成果备注",type="longtext")
    @TableField(value = "mokuai_chengguo_content")

    private String mokuaiChengguoContent;


    /**
     * 创建时间  listShow
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
	 * 获取：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }
    /**
	 * 设置：项目
	 */

    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：模块编号
	 */
    public String getMokuaiUuidNumber() {
        return mokuaiUuidNumber;
    }
    /**
	 * 设置：模块编号
	 */

    public void setMokuaiUuidNumber(String mokuaiUuidNumber) {
        this.mokuaiUuidNumber = mokuaiUuidNumber;
    }
    /**
	 * 获取：模块名称
	 */
    public String getMokuaiName() {
        return mokuaiName;
    }
    /**
	 * 设置：模块名称
	 */

    public void setMokuaiName(String mokuaiName) {
        this.mokuaiName = mokuaiName;
    }
    /**
	 * 获取：模块类型
	 */
    public Integer getMokuaiTypes() {
        return mokuaiTypes;
    }
    /**
	 * 设置：模块类型
	 */

    public void setMokuaiTypes(Integer mokuaiTypes) {
        this.mokuaiTypes = mokuaiTypes;
    }
    /**
	 * 获取：模块经费
	 */
    public Double getMokuaiJine() {
        return mokuaiJine;
    }
    /**
	 * 设置：模块经费
	 */

    public void setMokuaiJine(Double mokuaiJine) {
        this.mokuaiJine = mokuaiJine;
    }
    /**
	 * 获取：分配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：分配时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：模块要求
	 */
    public String getMokuaiContent() {
        return mokuaiContent;
    }
    /**
	 * 设置：模块要求
	 */

    public void setMokuaiContent(String mokuaiContent) {
        this.mokuaiContent = mokuaiContent;
    }
    /**
	 * 获取：模块状态
	 */
    public Integer getMokuaiZhuangtaiTypes() {
        return mokuaiZhuangtaiTypes;
    }
    /**
	 * 设置：模块状态
	 */

    public void setMokuaiZhuangtaiTypes(Integer mokuaiZhuangtaiTypes) {
        this.mokuaiZhuangtaiTypes = mokuaiZhuangtaiTypes;
    }
    /**
	 * 获取：模块成果
	 */
    public String getMokuaiFile() {
        return mokuaiFile;
    }
    /**
	 * 设置：模块成果
	 */

    public void setMokuaiFile(String mokuaiFile) {
        this.mokuaiFile = mokuaiFile;
    }
    /**
	 * 获取：成果备注
	 */
    public String getMokuaiChengguoContent() {
        return mokuaiChengguoContent;
    }
    /**
	 * 设置：成果备注
	 */

    public void setMokuaiChengguoContent(String mokuaiChengguoContent) {
        this.mokuaiChengguoContent = mokuaiChengguoContent;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Mokuai{" +
            ", id=" + id +
            ", xiangmuId=" + xiangmuId +
            ", yonghuId=" + yonghuId +
            ", mokuaiUuidNumber=" + mokuaiUuidNumber +
            ", mokuaiName=" + mokuaiName +
            ", mokuaiTypes=" + mokuaiTypes +
            ", mokuaiJine=" + mokuaiJine +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", mokuaiContent=" + mokuaiContent +
            ", mokuaiZhuangtaiTypes=" + mokuaiZhuangtaiTypes +
            ", mokuaiFile=" + mokuaiFile +
            ", mokuaiChengguoContent=" + mokuaiChengguoContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
