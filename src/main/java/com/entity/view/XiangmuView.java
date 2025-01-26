package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 项目
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xiangmu")
public class XiangmuView extends XiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 项目类型的值
	*/
	@ColumnInfo(comment="项目类型的字典表值",type="varchar(200)")
	private String xiangmuValue;

	//级联表 项目经理
		/**
		* 项目经理姓名
		*/

		@ColumnInfo(comment="项目经理姓名",type="varchar(200)")
		private String xiangmujingliName;
		/**
		* 项目经理手机号
		*/

		@ColumnInfo(comment="项目经理手机号",type="varchar(200)")
		private String xiangmujingliPhone;
		/**
		* 项目经理身份证号
		*/

		@ColumnInfo(comment="项目经理身份证号",type="varchar(200)")
		private String xiangmujingliIdNumber;
		/**
		* 项目经理头像
		*/

		@ColumnInfo(comment="项目经理头像",type="varchar(200)")
		private String xiangmujingliPhoto;
		/**
		* 项目经理邮箱
		*/

		@ColumnInfo(comment="项目经理邮箱",type="varchar(200)")
		private String xiangmujingliEmail;



	public XiangmuView() {

	}

	public XiangmuView(XiangmuEntity xiangmuEntity) {
		try {
			BeanUtils.copyProperties(this, xiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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


	//级联表的get和set 项目经理

		/**
		* 获取： 项目经理姓名
		*/
		public String getXiangmujingliName() {
			return xiangmujingliName;
		}
		/**
		* 设置： 项目经理姓名
		*/
		public void setXiangmujingliName(String xiangmujingliName) {
			this.xiangmujingliName = xiangmujingliName;
		}

		/**
		* 获取： 项目经理手机号
		*/
		public String getXiangmujingliPhone() {
			return xiangmujingliPhone;
		}
		/**
		* 设置： 项目经理手机号
		*/
		public void setXiangmujingliPhone(String xiangmujingliPhone) {
			this.xiangmujingliPhone = xiangmujingliPhone;
		}

		/**
		* 获取： 项目经理身份证号
		*/
		public String getXiangmujingliIdNumber() {
			return xiangmujingliIdNumber;
		}
		/**
		* 设置： 项目经理身份证号
		*/
		public void setXiangmujingliIdNumber(String xiangmujingliIdNumber) {
			this.xiangmujingliIdNumber = xiangmujingliIdNumber;
		}

		/**
		* 获取： 项目经理头像
		*/
		public String getXiangmujingliPhoto() {
			return xiangmujingliPhoto;
		}
		/**
		* 设置： 项目经理头像
		*/
		public void setXiangmujingliPhoto(String xiangmujingliPhoto) {
			this.xiangmujingliPhoto = xiangmujingliPhoto;
		}

		/**
		* 获取： 项目经理邮箱
		*/
		public String getXiangmujingliEmail() {
			return xiangmujingliEmail;
		}
		/**
		* 设置： 项目经理邮箱
		*/
		public void setXiangmujingliEmail(String xiangmujingliEmail) {
			this.xiangmujingliEmail = xiangmujingliEmail;
		}


	@Override
	public String toString() {
		return "XiangmuView{" +
			", xiangmuValue=" + xiangmuValue +
			", xiangmujingliName=" + xiangmujingliName +
			", xiangmujingliPhone=" + xiangmujingliPhone +
			", xiangmujingliIdNumber=" + xiangmujingliIdNumber +
			", xiangmujingliPhoto=" + xiangmujingliPhoto +
			", xiangmujingliEmail=" + xiangmujingliEmail +
			"} " + super.toString();
	}
}
