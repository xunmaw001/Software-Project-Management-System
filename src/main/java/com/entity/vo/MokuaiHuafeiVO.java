package com.entity.vo;

import com.entity.MokuaiHuafeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 经费使用
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("mokuai_huafei")
public class MokuaiHuafeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 模块
     */

    @TableField(value = "mokuai_id")
    private Integer mokuaiId;


    /**
     * 花费编号
     */

    @TableField(value = "mokuai_huafei_uuid_number")
    private String mokuaiHuafeiUuidNumber;


    /**
     * 花费标题
     */

    @TableField(value = "mokuai_huafei_name")
    private String mokuaiHuafeiName;


    /**
     * 经费使用类型
     */

    @TableField(value = "mokuai_huafei_types")
    private Integer mokuaiHuafeiTypes;


    /**
     * 花费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huafei_time")
    private Date huafeiTime;


    /**
     * 使用金额
     */

    @TableField(value = "mokuai_huafei_jine")
    private Double mokuaiHuafeiJine;


    /**
     * 使用缘由
     */

    @TableField(value = "mokuai_huafei_content")
    private String mokuaiHuafeiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：模块
	 */
    public Integer getMokuaiId() {
        return mokuaiId;
    }


    /**
	 * 获取：模块
	 */

    public void setMokuaiId(Integer mokuaiId) {
        this.mokuaiId = mokuaiId;
    }
    /**
	 * 设置：花费编号
	 */
    public String getMokuaiHuafeiUuidNumber() {
        return mokuaiHuafeiUuidNumber;
    }


    /**
	 * 获取：花费编号
	 */

    public void setMokuaiHuafeiUuidNumber(String mokuaiHuafeiUuidNumber) {
        this.mokuaiHuafeiUuidNumber = mokuaiHuafeiUuidNumber;
    }
    /**
	 * 设置：花费标题
	 */
    public String getMokuaiHuafeiName() {
        return mokuaiHuafeiName;
    }


    /**
	 * 获取：花费标题
	 */

    public void setMokuaiHuafeiName(String mokuaiHuafeiName) {
        this.mokuaiHuafeiName = mokuaiHuafeiName;
    }
    /**
	 * 设置：经费使用类型
	 */
    public Integer getMokuaiHuafeiTypes() {
        return mokuaiHuafeiTypes;
    }


    /**
	 * 获取：经费使用类型
	 */

    public void setMokuaiHuafeiTypes(Integer mokuaiHuafeiTypes) {
        this.mokuaiHuafeiTypes = mokuaiHuafeiTypes;
    }
    /**
	 * 设置：花费时间
	 */
    public Date getHuafeiTime() {
        return huafeiTime;
    }


    /**
	 * 获取：花费时间
	 */

    public void setHuafeiTime(Date huafeiTime) {
        this.huafeiTime = huafeiTime;
    }
    /**
	 * 设置：使用金额
	 */
    public Double getMokuaiHuafeiJine() {
        return mokuaiHuafeiJine;
    }


    /**
	 * 获取：使用金额
	 */

    public void setMokuaiHuafeiJine(Double mokuaiHuafeiJine) {
        this.mokuaiHuafeiJine = mokuaiHuafeiJine;
    }
    /**
	 * 设置：使用缘由
	 */
    public String getMokuaiHuafeiContent() {
        return mokuaiHuafeiContent;
    }


    /**
	 * 获取：使用缘由
	 */

    public void setMokuaiHuafeiContent(String mokuaiHuafeiContent) {
        this.mokuaiHuafeiContent = mokuaiHuafeiContent;
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
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
