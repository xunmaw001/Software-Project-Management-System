package com.entity.vo;

import com.entity.MokuaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 模块
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("mokuai")
public class MokuaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 项目
     */

    @TableField(value = "xiangmu_id")
    private Integer xiangmuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 模块编号
     */

    @TableField(value = "mokuai_uuid_number")
    private String mokuaiUuidNumber;


    /**
     * 模块名称
     */

    @TableField(value = "mokuai_name")
    private String mokuaiName;


    /**
     * 模块类型
     */

    @TableField(value = "mokuai_types")
    private Integer mokuaiTypes;


    /**
     * 模块经费
     */

    @TableField(value = "mokuai_jine")
    private Double mokuaiJine;


    /**
     * 分配时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 模块要求
     */

    @TableField(value = "mokuai_content")
    private String mokuaiContent;


    /**
     * 模块状态
     */

    @TableField(value = "mokuai_zhuangtai_types")
    private Integer mokuaiZhuangtaiTypes;


    /**
     * 模块成果
     */

    @TableField(value = "mokuai_file")
    private String mokuaiFile;


    /**
     * 成果备注
     */

    @TableField(value = "mokuai_chengguo_content")
    private String mokuaiChengguoContent;


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
	 * 设置：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 获取：项目
	 */

    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：模块编号
	 */
    public String getMokuaiUuidNumber() {
        return mokuaiUuidNumber;
    }


    /**
	 * 获取：模块编号
	 */

    public void setMokuaiUuidNumber(String mokuaiUuidNumber) {
        this.mokuaiUuidNumber = mokuaiUuidNumber;
    }
    /**
	 * 设置：模块名称
	 */
    public String getMokuaiName() {
        return mokuaiName;
    }


    /**
	 * 获取：模块名称
	 */

    public void setMokuaiName(String mokuaiName) {
        this.mokuaiName = mokuaiName;
    }
    /**
	 * 设置：模块类型
	 */
    public Integer getMokuaiTypes() {
        return mokuaiTypes;
    }


    /**
	 * 获取：模块类型
	 */

    public void setMokuaiTypes(Integer mokuaiTypes) {
        this.mokuaiTypes = mokuaiTypes;
    }
    /**
	 * 设置：模块经费
	 */
    public Double getMokuaiJine() {
        return mokuaiJine;
    }


    /**
	 * 获取：模块经费
	 */

    public void setMokuaiJine(Double mokuaiJine) {
        this.mokuaiJine = mokuaiJine;
    }
    /**
	 * 设置：分配时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：分配时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：模块要求
	 */
    public String getMokuaiContent() {
        return mokuaiContent;
    }


    /**
	 * 获取：模块要求
	 */

    public void setMokuaiContent(String mokuaiContent) {
        this.mokuaiContent = mokuaiContent;
    }
    /**
	 * 设置：模块状态
	 */
    public Integer getMokuaiZhuangtaiTypes() {
        return mokuaiZhuangtaiTypes;
    }


    /**
	 * 获取：模块状态
	 */

    public void setMokuaiZhuangtaiTypes(Integer mokuaiZhuangtaiTypes) {
        this.mokuaiZhuangtaiTypes = mokuaiZhuangtaiTypes;
    }
    /**
	 * 设置：模块成果
	 */
    public String getMokuaiFile() {
        return mokuaiFile;
    }


    /**
	 * 获取：模块成果
	 */

    public void setMokuaiFile(String mokuaiFile) {
        this.mokuaiFile = mokuaiFile;
    }
    /**
	 * 设置：成果备注
	 */
    public String getMokuaiChengguoContent() {
        return mokuaiChengguoContent;
    }


    /**
	 * 获取：成果备注
	 */

    public void setMokuaiChengguoContent(String mokuaiChengguoContent) {
        this.mokuaiChengguoContent = mokuaiChengguoContent;
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
