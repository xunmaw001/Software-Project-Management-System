package com.dao;

import com.entity.WenxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WenxianView;

/**
 * 文献 Dao 接口
 *
 * @author 
 */
public interface WenxianDao extends BaseMapper<WenxianEntity> {

   List<WenxianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
