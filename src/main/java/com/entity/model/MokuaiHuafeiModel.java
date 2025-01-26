package com.entity.model;

import com.entity.MokuaiHuafeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 经费使用
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MokuaiHuafeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 模块
     */
    private Integer mokuaiId;


    /**
     * 花费编号
     */
    private String mokuaiHuafeiUuidNumber;


    /**
     * 花费标题
     */
    private String mokuaiHuafeiName;


    /**
     * 经费使用类型
     */
    private Integer mokuaiHuafeiTypes;


    /**
     * 花费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huafeiTime;


    /**
     * 使用金额
     */
    private Double mokuaiHuafeiJine;


    /**
     * 使用缘由
     */
    private String mokuaiHuafeiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
