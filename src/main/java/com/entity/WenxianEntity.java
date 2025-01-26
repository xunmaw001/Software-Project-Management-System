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
 * 文献
 *
 * @author 
 * @email
 */
@TableName("wenxian")
public class WenxianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WenxianEntity() {

	}

	public WenxianEntity(T t) {
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
     * 文献名称
     */
    @ColumnInfo(comment="文献名称",type="varchar(200)")
    @TableField(value = "wenxian_name")

    private String wenxianName;


    /**
     * 文献编号
     */
    @ColumnInfo(comment="文献编号",type="varchar(200)")
    @TableField(value = "wenxian_uuid_number")

    private String wenxianUuidNumber;


    /**
     * 文献照片
     */
    @ColumnInfo(comment="文献照片",type="varchar(200)")
    @TableField(value = "wenxian_photo")

    private String wenxianPhoto;


    /**
     * 文献附件
     */
    @ColumnInfo(comment="文献附件",type="varchar(200)")
    @TableField(value = "wenxian_file")

    private String wenxianFile;


    /**
     * 文献类型
     */
    @ColumnInfo(comment="文献类型",type="int(11)")
    @TableField(value = "wenxian_types")

    private Integer wenxianTypes;


    /**
     * 文献介绍
     */
    @ColumnInfo(comment="文献介绍",type="longtext")
    @TableField(value = "wenxian_content")

    private String wenxianContent;


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
    @TableField(value = "wenxian_delete")

    private Integer wenxianDelete;


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
	 * 获取：文献名称
	 */
    public String getWenxianName() {
        return wenxianName;
    }
    /**
	 * 设置：文献名称
	 */

    public void setWenxianName(String wenxianName) {
        this.wenxianName = wenxianName;
    }
    /**
	 * 获取：文献编号
	 */
    public String getWenxianUuidNumber() {
        return wenxianUuidNumber;
    }
    /**
	 * 设置：文献编号
	 */

    public void setWenxianUuidNumber(String wenxianUuidNumber) {
        this.wenxianUuidNumber = wenxianUuidNumber;
    }
    /**
	 * 获取：文献照片
	 */
    public String getWenxianPhoto() {
        return wenxianPhoto;
    }
    /**
	 * 设置：文献照片
	 */

    public void setWenxianPhoto(String wenxianPhoto) {
        this.wenxianPhoto = wenxianPhoto;
    }
    /**
	 * 获取：文献附件
	 */
    public String getWenxianFile() {
        return wenxianFile;
    }
    /**
	 * 设置：文献附件
	 */

    public void setWenxianFile(String wenxianFile) {
        this.wenxianFile = wenxianFile;
    }
    /**
	 * 获取：文献类型
	 */
    public Integer getWenxianTypes() {
        return wenxianTypes;
    }
    /**
	 * 设置：文献类型
	 */

    public void setWenxianTypes(Integer wenxianTypes) {
        this.wenxianTypes = wenxianTypes;
    }
    /**
	 * 获取：文献介绍
	 */
    public String getWenxianContent() {
        return wenxianContent;
    }
    /**
	 * 设置：文献介绍
	 */

    public void setWenxianContent(String wenxianContent) {
        this.wenxianContent = wenxianContent;
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
    public Integer getWenxianDelete() {
        return wenxianDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setWenxianDelete(Integer wenxianDelete) {
        this.wenxianDelete = wenxianDelete;
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
        return "Wenxian{" +
            ", id=" + id +
            ", wenxianName=" + wenxianName +
            ", wenxianUuidNumber=" + wenxianUuidNumber +
            ", wenxianPhoto=" + wenxianPhoto +
            ", wenxianFile=" + wenxianFile +
            ", wenxianTypes=" + wenxianTypes +
            ", wenxianContent=" + wenxianContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", wenxianDelete=" + wenxianDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
