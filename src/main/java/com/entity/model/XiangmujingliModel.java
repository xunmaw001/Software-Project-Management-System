package com.entity.model;

import com.entity.XiangmujingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目经理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmujingliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 项目经理姓名
     */
    private String xiangmujingliName;


    /**
     * 项目经理手机号
     */
    private String xiangmujingliPhone;


    /**
     * 项目经理身份证号
     */
    private String xiangmujingliIdNumber;


    /**
     * 项目经理头像
     */
    private String xiangmujingliPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 项目经理邮箱
     */
    private String xiangmujingliEmail;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：项目经理姓名
	 */
    public String getXiangmujingliName() {
        return xiangmujingliName;
    }


    /**
	 * 设置：项目经理姓名
	 */
    public void setXiangmujingliName(String xiangmujingliName) {
        this.xiangmujingliName = xiangmujingliName;
    }
    /**
	 * 获取：项目经理手机号
	 */
    public String getXiangmujingliPhone() {
        return xiangmujingliPhone;
    }


    /**
	 * 设置：项目经理手机号
	 */
    public void setXiangmujingliPhone(String xiangmujingliPhone) {
        this.xiangmujingliPhone = xiangmujingliPhone;
    }
    /**
	 * 获取：项目经理身份证号
	 */
    public String getXiangmujingliIdNumber() {
        return xiangmujingliIdNumber;
    }


    /**
	 * 设置：项目经理身份证号
	 */
    public void setXiangmujingliIdNumber(String xiangmujingliIdNumber) {
        this.xiangmujingliIdNumber = xiangmujingliIdNumber;
    }
    /**
	 * 获取：项目经理头像
	 */
    public String getXiangmujingliPhoto() {
        return xiangmujingliPhoto;
    }


    /**
	 * 设置：项目经理头像
	 */
    public void setXiangmujingliPhoto(String xiangmujingliPhoto) {
        this.xiangmujingliPhoto = xiangmujingliPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：项目经理邮箱
	 */
    public String getXiangmujingliEmail() {
        return xiangmujingliEmail;
    }


    /**
	 * 设置：项目经理邮箱
	 */
    public void setXiangmujingliEmail(String xiangmujingliEmail) {
        this.xiangmujingliEmail = xiangmujingliEmail;
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
