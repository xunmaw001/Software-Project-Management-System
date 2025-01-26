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
 * 技术
 *
 * @author 
 * @email
 */
@TableName("jishu")
public class JishuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JishuEntity() {

	}

	public JishuEntity(T t) {
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
     * 技术名称
     */
    @ColumnInfo(comment="技术名称",type="varchar(200)")
    @TableField(value = "jishu_name")

    private String jishuName;


    /**
     * 技术编号
     */
    @ColumnInfo(comment="技术编号",type="varchar(200)")
    @TableField(value = "jishu_uuid_number")

    private String jishuUuidNumber;


    /**
     * 技术照片
     */
    @ColumnInfo(comment="技术照片",type="varchar(200)")
    @TableField(value = "jishu_photo")

    private String jishuPhoto;


    /**
     * 技术附件
     */
    @ColumnInfo(comment="技术附件",type="varchar(200)")
    @TableField(value = "jishu_file")

    private String jishuFile;


    /**
     * 技术类型
     */
    @ColumnInfo(comment="技术类型",type="int(11)")
    @TableField(value = "jishu_types")

    private Integer jishuTypes;


    /**
     * 技术介绍
     */
    @ColumnInfo(comment="技术介绍",type="longtext")
    @TableField(value = "jishu_content")

    private String jishuContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jishu_delete")

    private Integer jishuDelete;


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
	 * 获取：技术名称
	 */
    public String getJishuName() {
        return jishuName;
    }
    /**
	 * 设置：技术名称
	 */

    public void setJishuName(String jishuName) {
        this.jishuName = jishuName;
    }
    /**
	 * 获取：技术编号
	 */
    public String getJishuUuidNumber() {
        return jishuUuidNumber;
    }
    /**
	 * 设置：技术编号
	 */

    public void setJishuUuidNumber(String jishuUuidNumber) {
        this.jishuUuidNumber = jishuUuidNumber;
    }
    /**
	 * 获取：技术照片
	 */
    public String getJishuPhoto() {
        return jishuPhoto;
    }
    /**
	 * 设置：技术照片
	 */

    public void setJishuPhoto(String jishuPhoto) {
        this.jishuPhoto = jishuPhoto;
    }
    /**
	 * 获取：技术附件
	 */
    public String getJishuFile() {
        return jishuFile;
    }
    /**
	 * 设置：技术附件
	 */

    public void setJishuFile(String jishuFile) {
        this.jishuFile = jishuFile;
    }
    /**
	 * 获取：技术类型
	 */
    public Integer getJishuTypes() {
        return jishuTypes;
    }
    /**
	 * 设置：技术类型
	 */

    public void setJishuTypes(Integer jishuTypes) {
        this.jishuTypes = jishuTypes;
    }
    /**
	 * 获取：技术介绍
	 */
    public String getJishuContent() {
        return jishuContent;
    }
    /**
	 * 设置：技术介绍
	 */

    public void setJishuContent(String jishuContent) {
        this.jishuContent = jishuContent;
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
	 * 获取：逻辑删除
	 */
    public Integer getJishuDelete() {
        return jishuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJishuDelete(Integer jishuDelete) {
        this.jishuDelete = jishuDelete;
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
        return "Jishu{" +
            ", id=" + id +
            ", jishuName=" + jishuName +
            ", jishuUuidNumber=" + jishuUuidNumber +
            ", jishuPhoto=" + jishuPhoto +
            ", jishuFile=" + jishuFile +
            ", jishuTypes=" + jishuTypes +
            ", jishuContent=" + jishuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", jishuDelete=" + jishuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
