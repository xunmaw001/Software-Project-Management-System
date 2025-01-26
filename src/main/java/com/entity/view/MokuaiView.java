package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MokuaiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 模块
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("mokuai")
public class MokuaiView extends MokuaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 模块类型的值
	*/
	@ColumnInfo(comment="模块类型的字典表值",type="varchar(200)")
	private String mokuaiValue;
	/**
	* 模块状态的值
	*/
	@ColumnInfo(comment="模块状态的字典表值",type="varchar(200)")
	private String mokuaiZhuangtaiValue;

	//级联表 项目
					 
		/**
		* 项目 的 项目经理
		*/
		@ColumnInfo(comment="项目经理",type="int(11)")
		private Integer xiangmuXiangmujingliId;
		/**
		* 项目名称
		*/

		@ColumnInfo(comment="项目名称",type="varchar(200)")
		private String xiangmuName;
		/**
		* 项目编号
		*/

		@ColumnInfo(comment="项目编号",type="varchar(200)")
		private String xiangmuUuidNumber;
		/**
		* 项目类型
		*/
		@ColumnInfo(comment="项目类型",type="int(11)")
		private Integer xiangmuTypes;
			/**
			* 项目类型的值
			*/
			@ColumnInfo(comment="项目类型的字典表值",type="varchar(200)")
			private String xiangmuValue;
		/**
		* 项目金额
		*/
		@ColumnInfo(comment="项目金额",type="decimal(10,2)")
		private Double xiangmuJine;
		/**
		* 剩余金额
		*/
		@ColumnInfo(comment="剩余金额",type="decimal(10,2)")
		private Double xiangmuShengyuJine;
		/**
		* 项目附件
		*/

		@ColumnInfo(comment="项目附件",type="varchar(200)")
		private String xiangmuFile;
		/**
		* 项目介绍
		*/

		@ColumnInfo(comment="项目介绍",type="longtext")
		private String xiangmuContent;
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



	public MokuaiView() {

	}

	public MokuaiView(MokuaiEntity mokuaiEntity) {
		try {
			BeanUtils.copyProperties(this, mokuaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 模块类型的值
	*/
	public String getMokuaiValue() {
		return mokuaiValue;
	}
	/**
	* 设置： 模块类型的值
	*/
	public void setMokuaiValue(String mokuaiValue) {
		this.mokuaiValue = mokuaiValue;
	}
	//当前表的
	/**
	* 获取： 模块状态的值
	*/
	public String getMokuaiZhuangtaiValue() {
		return mokuaiZhuangtaiValue;
	}
	/**
	* 设置： 模块状态的值
	*/
	public void setMokuaiZhuangtaiValue(String mokuaiZhuangtaiValue) {
		this.mokuaiZhuangtaiValue = mokuaiZhuangtaiValue;
	}


	//级联表的get和set 项目
		/**
		* 获取：项目 的 项目经理
		*/
		public Integer getXiangmuXiangmujingliId() {
			return xiangmuXiangmujingliId;
		}
		/**
		* 设置：项目 的 项目经理
		*/
		public void setXiangmuXiangmujingliId(Integer xiangmuXiangmujingliId) {
			this.xiangmuXiangmujingliId = xiangmuXiangmujingliId;
		}

		/**
		* 获取： 项目名称
		*/
		public String getXiangmuName() {
			return xiangmuName;
		}
		/**
		* 设置： 项目名称
		*/
		public void setXiangmuName(String xiangmuName) {
			this.xiangmuName = xiangmuName;
		}

		/**
		* 获取： 项目编号
		*/
		public String getXiangmuUuidNumber() {
			return xiangmuUuidNumber;
		}
		/**
		* 设置： 项目编号
		*/
		public void setXiangmuUuidNumber(String xiangmuUuidNumber) {
			this.xiangmuUuidNumber = xiangmuUuidNumber;
		}
		/**
		* 获取： 项目类型
		*/
		public Integer getXiangmuTypes() {
			return xiangmuTypes;
		}
		/**
		* 设置： 项目类型
		*/
		public void setXiangmuTypes(Integer xiangmuTypes) {
			this.xiangmuTypes = xiangmuTypes;
		}


			/**
			* 获取： 项目类型的值
			*/
			public String getXiangmuValue() {
				return xiangmuValue;
			}
			/**
			* 设置： 项目类型的值
			*/
			public void setXiangmuValue(String xiangmuValue) {
				this.xiangmuValue = xiangmuValue;
			}

		/**
		* 获取： 项目金额
		*/
		public Double getXiangmuJine() {
			return xiangmuJine;
		}
		/**
		* 设置： 项目金额
		*/
		public void setXiangmuJine(Double xiangmuJine) {
			this.xiangmuJine = xiangmuJine;
		}

		/**
		* 获取： 剩余金额
		*/
		public Double getXiangmuShengyuJine() {
			return xiangmuShengyuJine;
		}
		/**
		* 设置： 剩余金额
		*/
		public void setXiangmuShengyuJine(Double xiangmuShengyuJine) {
			this.xiangmuShengyuJine = xiangmuShengyuJine;
		}

		/**
		* 获取： 项目附件
		*/
		public String getXiangmuFile() {
			return xiangmuFile;
		}
		/**
		* 设置： 项目附件
		*/
		public void setXiangmuFile(String xiangmuFile) {
			this.xiangmuFile = xiangmuFile;
		}

		/**
		* 获取： 项目介绍
		*/
		public String getXiangmuContent() {
			return xiangmuContent;
		}
		/**
		* 设置： 项目介绍
		*/
		public void setXiangmuContent(String xiangmuContent) {
			this.xiangmuContent = xiangmuContent;
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
		return "MokuaiView{" +
			", mokuaiValue=" + mokuaiValue +
			", mokuaiZhuangtaiValue=" + mokuaiZhuangtaiValue +
			", xiangmuName=" + xiangmuName +
			", xiangmuUuidNumber=" + xiangmuUuidNumber +
			", xiangmuJine=" + xiangmuJine +
			", xiangmuShengyuJine=" + xiangmuShengyuJine +
			", xiangmuFile=" + xiangmuFile +
			", xiangmuContent=" + xiangmuContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
