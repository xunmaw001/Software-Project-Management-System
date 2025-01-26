package com.entity.vo;

import com.entity.JishuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 技术
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jishu")
public class JishuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 技术名称
     */

    @TableField(value = "jishu_name")
    private String jishuName;


    /**
     * 技术编号
     */

    @TableField(value = "jishu_uuid_number")
    private String jishuUuidNumber;


    /**
     * 技术照片
     */

    @TableField(value = "jishu_photo")
    private String jishuPhoto;


    /**
     * 技术附件
     */

    @TableField(value = "jishu_file")
    private String jishuFile;


    /**
     * 技术类型
     */

    @TableField(value = "jishu_types")
    private Integer jishuTypes;


    /**
     * 技术介绍
     */

    @TableField(value = "jishu_content")
    private String jishuContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "jishu_delete")
    private Integer jishuDelete;


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
	 * 设置：技术名称
	 */
    public String getJishuName() {
        return jishuName;
    }


    /**
	 * 获取：技术名称
	 */

    public void setJishuName(String jishuName) {
        this.jishuName = jishuName;
    }
    /**
	 * 设置：技术编号
	 */
    public String getJishuUuidNumber() {
        return jishuUuidNumber;
    }


    /**
	 * 获取：技术编号
	 */

    public void setJishuUuidNumber(String jishuUuidNumber) {
        this.jishuUuidNumber = jishuUuidNumber;
    }
    /**
	 * 设置：技术照片
	 */
    public String getJishuPhoto() {
        return jishuPhoto;
    }


    /**
	 * 获取：技术照片
	 */

    public void setJishuPhoto(String jishuPhoto) {
        this.jishuPhoto = jishuPhoto;
    }
    /**
	 * 设置：技术附件
	 */
    public String getJishuFile() {
        return jishuFile;
    }


    /**
	 * 获取：技术附件
	 */

    public void setJishuFile(String jishuFile) {
        this.jishuFile = jishuFile;
    }
    /**
	 * 设置：技术类型
	 */
    public Integer getJishuTypes() {
        return jishuTypes;
    }


    /**
	 * 获取：技术类型
	 */

    public void setJishuTypes(Integer jishuTypes) {
        this.jishuTypes = jishuTypes;
    }
    /**
	 * 设置：技术介绍
	 */
    public String getJishuContent() {
        return jishuContent;
    }


    /**
	 * 获取：技术介绍
	 */

    public void setJishuContent(String jishuContent) {
        this.jishuContent = jishuContent;
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
    public Integer getJishuDelete() {
        return jishuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJishuDelete(Integer jishuDelete) {
        this.jishuDelete = jishuDelete;
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
