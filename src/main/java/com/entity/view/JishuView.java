package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JishuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 技术
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jishu")
public class JishuView extends JishuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 技术类型的值
	*/
	@ColumnInfo(comment="技术类型的字典表值",type="varchar(200)")
	private String jishuValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;




	public JishuView() {

	}

	public JishuView(JishuEntity jishuEntity) {
		try {
			BeanUtils.copyProperties(this, jishuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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
	//当前表的
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




	@Override
	public String toString() {
		return "JishuView{" +
			", jishuValue=" + jishuValue +
			", shangxiaValue=" + shangxiaValue +
			"} " + super.toString();
	}
}
