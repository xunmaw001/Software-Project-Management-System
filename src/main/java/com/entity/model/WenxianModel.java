package com.entity.model;

import com.entity.WenxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 文献
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WenxianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 文献名称
     */
    private String wenxianName;


    /**
     * 文献编号
     */
    private String wenxianUuidNumber;


    /**
     * 文献照片
     */
    private String wenxianPhoto;


    /**
     * 文献附件
     */
    private String wenxianFile;


    /**
     * 文献类型
     */
    private Integer wenxianTypes;


    /**
     * 文献介绍
     */
    private String wenxianContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer wenxianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
