package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JishuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 技术收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jishu_collection")
public class JishuCollectionView extends JishuCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jishuCollectionValue;

	//级联表 技术
		/**
		* 技术名称
		*/

		@ColumnInfo(comment="技术名称",type="varchar(200)")
		private String jishuName;
		/**
		* 技术编号
		*/

		@ColumnInfo(comment="技术编号",type="varchar(200)")
		private String jishuUuidNumber;
		/**
		* 技术照片
		*/

		@ColumnInfo(comment="技术照片",type="varchar(200)")
		private String jishuPhoto;
		/**
		* 技术附件
		*/

		@ColumnInfo(comment="技术附件",type="varchar(200)")
		private String jishuFile;
		/**
		* 技术类型
		*/
		@ColumnInfo(comment="技术类型",type="int(11)")
		private Integer jishuTypes;
			/**
			* 技术类型的值
			*/
			@ColumnInfo(comment="技术类型的字典表值",type="varchar(200)")
			private String jishuValue;
		/**
		* 技术介绍
		*/

		@ColumnInfo(comment="技术介绍",type="longtext")
		private String jishuContent;
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
		private Integer jishuDelete;
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



	public JishuCollectionView() {

	}

	public JishuCollectionView(JishuCollectionEntity jishuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jishuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJishuCollectionValue() {
		return jishuCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJishuCollectionValue(String jishuCollectionValue) {
		this.jishuCollectionValue = jishuCollectionValue;
	}


	//级联表的get和set 技术

		/**
		* 获取： 技术名称
		*/
		public String getJishuName() {
			return jishuName;
		}
		/**
		* 设置： 技术名称
		*/
		public void setJishuName(String jishuName) {
			this.jishuName = jishuName;
		}

		/**
		* 获取： 技术编号
		*/
		public String getJishuUuidNumber() {
			return jishuUuidNumber;
		}
		/**
		* 设置： 技术编号
		*/
		public void setJishuUuidNumber(String jishuUuidNumber) {
			this.jishuUuidNumber = jishuUuidNumber;
		}

		/**
		* 获取： 技术照片
		*/
		public String getJishuPhoto() {
			return jishuPhoto;
		}
		/**
		* 设置： 技术照片
		*/
		public void setJishuPhoto(String jishuPhoto) {
			this.jishuPhoto = jishuPhoto;
		}

		/**
		* 获取： 技术附件
		*/
		public String getJishuFile() {
			return jishuFile;
		}
		/**
		* 设置： 技术附件
		*/
		public void setJishuFile(String jishuFile) {
			this.jishuFile = jishuFile;
		}
		/**
		* 获取： 技术类型
		*/
		public Integer getJishuTypes() {
			return jishuTypes;
		}
		/**
		* 设置： 技术类型
		*/
		public void setJishuTypes(Integer jishuTypes) {
			this.jishuTypes = jishuTypes;
		}


			/**
			* 获取： 技术类型的值
			*/
			public String getJishuValue() {
				return jishuValue;
			}
			/**
			* 设置： 技术类型的值
			*/
			public void setJishuValue(String jishuValue) {
				this.jishuValue = jishuValue;
			}

		/**
		* 获取： 技术介绍
		*/
		public String getJishuContent() {
			return jishuContent;
		}
		/**
		* 设置： 技术介绍
		*/
		public void setJishuContent(String jishuContent) {
			this.jishuContent = jishuContent;
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
		public Integer getJishuDelete() {
			return jishuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJishuDelete(Integer jishuDelete) {
			this.jishuDelete = jishuDelete;
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
		return "JishuCollectionView{" +
			", jishuCollectionValue=" + jishuCollectionValue +
			", jishuName=" + jishuName +
			", jishuUuidNumber=" + jishuUuidNumber +
			", jishuPhoto=" + jishuPhoto +
			", jishuFile=" + jishuFile +
			", jishuContent=" + jishuContent +
			", jishuDelete=" + jishuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
