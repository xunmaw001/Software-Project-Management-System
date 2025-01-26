package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WenxianCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 文献收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wenxian_collection")
public class WenxianCollectionView extends WenxianCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String wenxianCollectionValue;

	//级联表 文献
		/**
		* 文献名称
		*/

		@ColumnInfo(comment="文献名称",type="varchar(200)")
		private String wenxianName;
		/**
		* 文献编号
		*/

		@ColumnInfo(comment="文献编号",type="varchar(200)")
		private String wenxianUuidNumber;
		/**
		* 文献照片
		*/

		@ColumnInfo(comment="文献照片",type="varchar(200)")
		private String wenxianPhoto;
		/**
		* 文献附件
		*/

		@ColumnInfo(comment="文献附件",type="varchar(200)")
		private String wenxianFile;
		/**
		* 文献类型
		*/
		@ColumnInfo(comment="文献类型",type="int(11)")
		private Integer wenxianTypes;
			/**
			* 文献类型的值
			*/
			@ColumnInfo(comment="文献类型的字典表值",type="varchar(200)")
			private String wenxianValue;
		/**
		* 文献介绍
		*/

		@ColumnInfo(comment="文献介绍",type="longtext")
		private String wenxianContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer wenxianDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public WenxianCollectionView() {

	}

	public WenxianCollectionView(WenxianCollectionEntity wenxianCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, wenxianCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getWenxianCollectionValue() {
		return wenxianCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setWenxianCollectionValue(String wenxianCollectionValue) {
		this.wenxianCollectionValue = wenxianCollectionValue;
	}


	//级联表的get和set 文献

		/**
		* 获取： 文献名称
		*/
		public String getWenxianName() {
			return wenxianName;
		}
		/**
		* 设置： 文献名称
		*/
		public void setWenxianName(String wenxianName) {
			this.wenxianName = wenxianName;
		}

		/**
		* 获取： 文献编号
		*/
		public String getWenxianUuidNumber() {
			return wenxianUuidNumber;
		}
		/**
		* 设置： 文献编号
		*/
		public void setWenxianUuidNumber(String wenxianUuidNumber) {
			this.wenxianUuidNumber = wenxianUuidNumber;
		}

		/**
		* 获取： 文献照片
		*/
		public String getWenxianPhoto() {
			return wenxianPhoto;
		}
		/**
		* 设置： 文献照片
		*/
		public void setWenxianPhoto(String wenxianPhoto) {
			this.wenxianPhoto = wenxianPhoto;
		}

		/**
		* 获取： 文献附件
		*/
		public String getWenxianFile() {
			return wenxianFile;
		}
		/**
		* 设置： 文献附件
		*/
		public void setWenxianFile(String wenxianFile) {
			this.wenxianFile = wenxianFile;
		}
		/**
		* 获取： 文献类型
		*/
		public Integer getWenxianTypes() {
			return wenxianTypes;
		}
		/**
		* 设置： 文献类型
		*/
		public void setWenxianTypes(Integer wenxianTypes) {
			this.wenxianTypes = wenxianTypes;
		}


			/**
			* 获取： 文献类型的值
			*/
			public String getWenxianValue() {
				return wenxianValue;
			}
			/**
			* 设置： 文献类型的值
			*/
			public void setWenxianValue(String wenxianValue) {
				this.wenxianValue = wenxianValue;
			}

		/**
		* 获取： 文献介绍
		*/
		public String getWenxianContent() {
			return wenxianContent;
		}
		/**
		* 设置： 文献介绍
		*/
		public void setWenxianContent(String wenxianContent) {
			this.wenxianContent = wenxianContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getWenxianDelete() {
			return wenxianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setWenxianDelete(Integer wenxianDelete) {
			this.wenxianDelete = wenxianDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "WenxianCollectionView{" +
			", wenxianCollectionValue=" + wenxianCollectionValue +
			", wenxianName=" + wenxianName +
			", wenxianUuidNumber=" + wenxianUuidNumber +
			", wenxianPhoto=" + wenxianPhoto +
			", wenxianFile=" + wenxianFile +
			", wenxianContent=" + wenxianContent +
			", wenxianDelete=" + wenxianDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
