package com.dao;

import com.entity.XiangmujingliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmujingliView;

/**
 * 项目经理 Dao 接口
 *
 * @author 
 */
public interface XiangmujingliDao extends BaseMapper<XiangmujingliEntity> {

   List<XiangmujingliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
