package com.entity.vo;

import com.entity.WenxianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 文献
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wenxian")
public class WenxianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 文献名称
     */

    @TableField(value = "wenxian_name")
    private String wenxianName;


    /**
     * 文献编号
     */

    @TableField(value = "wenxian_uuid_number")
    private String wenxianUuidNumber;


    /**
     * 文献照片
     */

    @TableField(value = "wenxian_photo")
    private String wenxianPhoto;


    /**
     * 文献附件
     */

    @TableField(value = "wenxian_file")
    private String wenxianFile;


    /**
     * 文献类型
     */

    @TableField(value = "wenxian_types")
    private Integer wenxianTypes;


    /**
     * 文献介绍
     */

    @TableField(value = "wenxian_content")
    private String wenxianContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "wenxian_delete")
    private Integer wenxianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：文献名称
	 */
    public String getWenxianName() {
        return wenxianName;
    }


    /**
	 * 获取：文献名称
	 */

    public void setWenxianName(String wenxianName) {
        this.wenxianName = wenxianName;
    }
    /**
	 * 设置：文献编号
	 */
    public String getWenxianUuidNumber() {
        return wenxianUuidNumber;
    }


    /**
	 * 获取：文献编号
	 */

    public void setWenxianUuidNumber(String wenxianUuidNumber) {
        this.wenxianUuidNumber = wenxianUuidNumber;
    }
    /**
	 * 设置：文献照片
	 */
    public String getWenxianPhoto() {
        return wenxianPhoto;
    }


    /**
	 * 获取：文献照片
	 */

    public void setWenxianPhoto(String wenxianPhoto) {
        this.wenxianPhoto = wenxianPhoto;
    }
    /**
	 * 设置：文献附件
	 */
    public String getWenxianFile() {
        return wenxianFile;
    }


    /**
	 * 获取：文献附件
	 */

    public void setWenxianFile(String wenxianFile) {
        this.wenxianFile = wenxianFile;
    }
    /**
	 * 设置：文献类型
	 */
    public Integer getWenxianTypes() {
        return wenxianTypes;
    }


    /**
	 * 获取：文献类型
	 */

    public void setWenxianTypes(Integer wenxianTypes) {
        this.wenxianTypes = wenxianTypes;
    }
    /**
	 * 设置：文献介绍
	 */
    public String getWenxianContent() {
        return wenxianContent;
    }


    /**
	 * 获取：文献介绍
	 */

    public void setWenxianContent(String wenxianContent) {
        this.wenxianContent = wenxianContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWenxianDelete() {
        return wenxianDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWenxianDelete(Integer wenxianDelete) {
        this.wenxianDelete = wenxianDelete;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
