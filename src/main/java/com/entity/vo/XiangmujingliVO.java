package com.entity.vo;

import com.entity.XiangmujingliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目经理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiangmujingli")
public class XiangmujingliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 项目经理姓名
     */

    @TableField(value = "xiangmujingli_name")
    private String xiangmujingliName;


    /**
     * 项目经理手机号
     */

    @TableField(value = "xiangmujingli_phone")
    private String xiangmujingliPhone;


    /**
     * 项目经理身份证号
     */

    @TableField(value = "xiangmujingli_id_number")
    private String xiangmujingliIdNumber;


    /**
     * 项目经理头像
     */

    @TableField(value = "xiangmujingli_photo")
    private String xiangmujingliPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 项目经理邮箱
     */

    @TableField(value = "xiangmujingli_email")
    private String xiangmujingliEmail;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：项目经理姓名
	 */
    public String getXiangmujingliName() {
        return xiangmujingliName;
    }


    /**
	 * 获取：项目经理姓名
	 */

    public void setXiangmujingliName(String xiangmujingliName) {
        this.xiangmujingliName = xiangmujingliName;
    }
    /**
	 * 设置：项目经理手机号
	 */
    public String getXiangmujingliPhone() {
        return xiangmujingliPhone;
    }


    /**
	 * 获取：项目经理手机号
	 */

    public void setXiangmujingliPhone(String xiangmujingliPhone) {
        this.xiangmujingliPhone = xiangmujingliPhone;
    }
    /**
	 * 设置：项目经理身份证号
	 */
    public String getXiangmujingliIdNumber() {
        return xiangmujingliIdNumber;
    }


    /**
	 * 获取：项目经理身份证号
	 */

    public void setXiangmujingliIdNumber(String xiangmujingliIdNumber) {
        this.xiangmujingliIdNumber = xiangmujingliIdNumber;
    }
    /**
	 * 设置：项目经理头像
	 */
    public String getXiangmujingliPhoto() {
        return xiangmujingliPhoto;
    }


    /**
	 * 获取：项目经理头像
	 */

    public void setXiangmujingliPhoto(String xiangmujingliPhoto) {
        this.xiangmujingliPhoto = xiangmujingliPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：项目经理邮箱
	 */
    public String getXiangmujingliEmail() {
        return xiangmujingliEmail;
    }


    /**
	 * 获取：项目经理邮箱
	 */

    public void setXiangmujingliEmail(String xiangmujingliEmail) {
        this.xiangmujingliEmail = xiangmujingliEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
