package com.entity.model;

import com.entity.MokuaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 模块
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MokuaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目
     */
    private Integer xiangmuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 模块编号
     */
    private String mokuaiUuidNumber;


    /**
     * 模块名称
     */
    private String mokuaiName;


    /**
     * 模块类型
     */
    private Integer mokuaiTypes;


    /**
     * 模块经费
     */
    private Double mokuaiJine;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 模块要求
     */
    private String mokuaiContent;


    /**
     * 模块状态
     */
    private Integer mokuaiZhuangtaiTypes;


    /**
     * 模块成果
     */
    private String mokuaiFile;


    /**
     * 成果备注
     */
    private String mokuaiChengguoContent;


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
