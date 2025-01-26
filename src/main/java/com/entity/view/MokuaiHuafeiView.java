package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MokuaiHuafeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 经费使用
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("mokuai_huafei")
public class MokuaiHuafeiView extends MokuaiHuafeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 经费使用类型的值
	*/
	@ColumnInfo(comment="经费使用类型的字典表值",type="varchar(200)")
	private String mokuaiHuafeiValue;

	//级联表 模块
										 
		/**
		* 模块 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer mokuaiYonghuId;
		/**
		* 模块编号
		*/

		@ColumnInfo(comment="模块编号",type="varchar(200)")
		private String mokuaiUuidNumber;
		/**
		* 模块名称
		*/

		@ColumnInfo(comment="模块名称",type="varchar(200)")
		private String mokuaiName;
		/**
		* 模块类型
		*/
		@ColumnInfo(comment="模块类型",type="int(11)")
		private Integer mokuaiTypes;
			/**
			* 模块类型的值
			*/
			@ColumnInfo(comment="模块类型的字典表值",type="varchar(200)")
			private String mokuaiValue;
		/**
		* 模块经费
		*/
		@ColumnInfo(comment="模块经费",type="decimal(10,2)")
		private Double mokuaiJine;
		/**
		* 模块要求
		*/

		@ColumnInfo(comment="模块要求",type="longtext")
		private String mokuaiContent;
		/**
		* 模块状态
		*/
		@ColumnInfo(comment="模块状态",type="int(11)")
		private Integer mokuaiZhuangtaiTypes;
			/**
			* 模块状态的值
			*/
			@ColumnInfo(comment="模块状态的字典表值",type="varchar(200)")
			private String mokuaiZhuangtaiValue;
		/**
		* 模块成果
		*/

		@ColumnInfo(comment="模块成果",type="varchar(200)")
		private String mokuaiFile;
		/**
		* 成果备注
		*/

		@ColumnInfo(comment="成果备注",type="longtext")
		private String mokuaiChengguoContent;



	public MokuaiHuafeiView() {

	}

	public MokuaiHuafeiView(MokuaiHuafeiEntity mokuaiHuafeiEntity) {
		try {
			BeanUtils.copyProperties(this, mokuaiHuafeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 经费使用类型的值
	*/
	public String getMokuaiHuafeiValue() {
		return mokuaiHuafeiValue;
	}
	/**
	* 设置： 经费使用类型的值
	*/
	public void setMokuaiHuafeiValue(String mokuaiHuafeiValue) {
		this.mokuaiHuafeiValue = mokuaiHuafeiValue;
	}


	//级联表的get和set 模块
		/**
		* 获取：模块 的 用户
		*/
		public Integer getMokuaiYonghuId() {
			return mokuaiYonghuId;
		}
		/**
		* 设置：模块 的 用户
		*/
		public void setMokuaiYonghuId(Integer mokuaiYonghuId) {
			this.mokuaiYonghuId = mokuaiYonghuId;
		}

		/**
		* 获取： 模块编号
		*/
		public String getMokuaiUuidNumber() {
			return mokuaiUuidNumber;
		}
		/**
		* 设置： 模块编号
		*/
		public void setMokuaiUuidNumber(String mokuaiUuidNumber) {
			this.mokuaiUuidNumber = mokuaiUuidNumber;
		}

		/**
		* 获取： 模块名称
		*/
		public String getMokuaiName() {
			return mokuaiName;
		}
		/**
		* 设置： 模块名称
		*/
		public void setMokuaiName(String mokuaiName) {
			this.mokuaiName = mokuaiName;
		}
		/**
		* 获取： 模块类型
		*/
		public Integer getMokuaiTypes() {
			return mokuaiTypes;
		}
		/**
		* 设置： 模块类型
		*/
		public void setMokuaiTypes(Integer mokuaiTypes) {
			this.mokuaiTypes = mokuaiTypes;
		}


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

		/**
		* 获取： 模块经费
		*/
		public Double getMokuaiJine() {
			return mokuaiJine;
		}
		/**
		* 设置： 模块经费
		*/
		public void setMokuaiJine(Double mokuaiJine) {
			this.mokuaiJine = mokuaiJine;
		}

		/**
		* 获取： 模块要求
		*/
		public String getMokuaiContent() {
			return mokuaiContent;
		}
		/**
		* 设置： 模块要求
		*/
		public void setMokuaiContent(String mokuaiContent) {
			this.mokuaiContent = mokuaiContent;
		}
		/**
		* 获取： 模块状态
		*/
		public Integer getMokuaiZhuangtaiTypes() {
			return mokuaiZhuangtaiTypes;
		}
		/**
		* 设置： 模块状态
		*/
		public void setMokuaiZhuangtaiTypes(Integer mokuaiZhuangtaiTypes) {
			this.mokuaiZhuangtaiTypes = mokuaiZhuangtaiTypes;
		}


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

		/**
		* 获取： 模块成果
		*/
		public String getMokuaiFile() {
			return mokuaiFile;
		}
		/**
		* 设置： 模块成果
		*/
		public void setMokuaiFile(String mokuaiFile) {
			this.mokuaiFile = mokuaiFile;
		}

		/**
		* 获取： 成果备注
		*/
		public String getMokuaiChengguoContent() {
			return mokuaiChengguoContent;
		}
		/**
		* 设置： 成果备注
		*/
		public void setMokuaiChengguoContent(String mokuaiChengguoContent) {
			this.mokuaiChengguoContent = mokuaiChengguoContent;
		}


	@Override
	public String toString() {
		return "MokuaiHuafeiView{" +
			", mokuaiHuafeiValue=" + mokuaiHuafeiValue +
			", mokuaiUuidNumber=" + mokuaiUuidNumber +
			", mokuaiName=" + mokuaiName +
			", mokuaiJine=" + mokuaiJine +
			", mokuaiContent=" + mokuaiContent +
			", mokuaiFile=" + mokuaiFile +
			", mokuaiChengguoContent=" + mokuaiChengguoContent +
			"} " + super.toString();
	}
}
