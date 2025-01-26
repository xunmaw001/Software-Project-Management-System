package com.entity.model;

import com.entity.JishuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 技术
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JishuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 技术名称
     */
    private String jishuName;


    /**
     * 技术编号
     */
    private String jishuUuidNumber;


    /**
     * 技术照片
     */
    private String jishuPhoto;


    /**
     * 技术附件
     */
    private String jishuFile;


    /**
     * 技术类型
     */
    private Integer jishuTypes;


    /**
     * 技术介绍
     */
    private String jishuContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer jishuDelete;


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
