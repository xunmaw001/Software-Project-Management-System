package com.entity.model;

import com.entity.XiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目经理
     */
    private Integer xiangmujingliId;


    /**
     * 项目名称
     */
    private String xiangmuName;


    /**
     * 项目编号
     */
    private String xiangmuUuidNumber;


    /**
     * 项目类型
     */
    private Integer xiangmuTypes;


    /**
     * 项目金额
     */
    private Double xiangmuJine;


    /**
     * 剩余金额
     */
    private Double xiangmuShengyuJine;


    /**
     * 项目附件
     */
    private String xiangmuFile;


    /**
     * 项目介绍
     */
    private String xiangmuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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

    }
