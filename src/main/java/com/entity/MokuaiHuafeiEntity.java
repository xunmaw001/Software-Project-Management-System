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
 * 经费使用
 *
 * @author 
 * @email
 */
@TableName("mokuai_huafei")
public class MokuaiHuafeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MokuaiHuafeiEntity() {

	}

	public MokuaiHuafeiEntity(T t) {
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
     * 模块
     */
    @ColumnInfo(comment="模块",type="int(11)")
    @TableField(value = "mokuai_id")

    private Integer mokuaiId;


    /**
     * 花费编号
     */
    @ColumnInfo(comment="花费编号",type="varchar(200)")
    @TableField(value = "mokuai_huafei_uuid_number")

    private String mokuaiHuafeiUuidNumber;


    /**
     * 花费标题
     */
    @ColumnInfo(comment="花费标题",type="varchar(200)")
    @TableField(value = "mokuai_huafei_name")

    private String mokuaiHuafeiName;


    /**
     * 经费使用类型
     */
    @ColumnInfo(comment="经费使用类型",type="int(11)")
    @TableField(value = "mokuai_huafei_types")

    private Integer mokuaiHuafeiTypes;


    /**
     * 花费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="花费时间",type="timestamp")
    @TableField(value = "huafei_time")

    private Date huafeiTime;


    /**
     * 使用金额
     */
    @ColumnInfo(comment="使用金额",type="decimal(10,2)")
    @TableField(value = "mokuai_huafei_jine")

    private Double mokuaiHuafeiJine;


    /**
     * 使用缘由
     */
    @ColumnInfo(comment="使用缘由",type="longtext")
    @TableField(value = "mokuai_huafei_content")

    private String mokuaiHuafeiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：模块
	 */
    public Integer getMokuaiId() {
        return mokuaiId;
    }
    /**
	 * 设置：模块
	 */

    public void setMokuaiId(Integer mokuaiId) {
        this.mokuaiId = mokuaiId;
    }
    /**
	 * 获取：花费编号
	 */
    public String getMokuaiHuafeiUuidNumber() {
        return mokuaiHuafeiUuidNumber;
    }
    /**
	 * 设置：花费编号
	 */

    public void setMokuaiHuafeiUuidNumber(String mokuaiHuafeiUuidNumber) {
        this.mokuaiHuafeiUuidNumber = mokuaiHuafeiUuidNumber;
    }
    /**
	 * 获取：花费标题
	 */
    public String getMokuaiHuafeiName() {
        return mokuaiHuafeiName;
    }
    /**
	 * 设置：花费标题
	 */

    public void setMokuaiHuafeiName(String mokuaiHuafeiName) {
        this.mokuaiHuafeiName = mokuaiHuafeiName;
    }
    /**
	 * 获取：经费使用类型
	 */
    public Integer getMokuaiHuafeiTypes() {
        return mokuaiHuafeiTypes;
    }
    /**
	 * 设置：经费使用类型
	 */

    public void setMokuaiHuafeiTypes(Integer mokuaiHuafeiTypes) {
        this.mokuaiHuafeiTypes = mokuaiHuafeiTypes;
    }
    /**
	 * 获取：花费时间
	 */
    public Date getHuafeiTime() {
        return huafeiTime;
    }
    /**
	 * 设置：花费时间
	 */

    public void setHuafeiTime(Date huafeiTime) {
        this.huafeiTime = huafeiTime;
    }
    /**
	 * 获取：使用金额
	 */
    public Double getMokuaiHuafeiJine() {
        return mokuaiHuafeiJine;
    }
    /**
	 * 设置：使用金额
	 */

    public void setMokuaiHuafeiJine(Double mokuaiHuafeiJine) {
        this.mokuaiHuafeiJine = mokuaiHuafeiJine;
    }
    /**
	 * 获取：使用缘由
	 */
    public String getMokuaiHuafeiContent() {
        return mokuaiHuafeiContent;
    }
    /**
	 * 设置：使用缘由
	 */

    public void setMokuaiHuafeiContent(String mokuaiHuafeiContent) {
        this.mokuaiHuafeiContent = mokuaiHuafeiContent;
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
        return "MokuaiHuafei{" +
            ", id=" + id +
            ", mokuaiId=" + mokuaiId +
            ", mokuaiHuafeiUuidNumber=" + mokuaiHuafeiUuidNumber +
            ", mokuaiHuafeiName=" + mokuaiHuafeiName +
            ", mokuaiHuafeiTypes=" + mokuaiHuafeiTypes +
            ", huafeiTime=" + DateUtil.convertString(huafeiTime,"yyyy-MM-dd") +
            ", mokuaiHuafeiJine=" + mokuaiHuafeiJine +
            ", mokuaiHuafeiContent=" + mokuaiHuafeiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
