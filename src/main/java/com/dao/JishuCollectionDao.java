package com.dao;

import com.entity.JishuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JishuCollectionView;

/**
 * 技术收藏 Dao 接口
 *
 * @author 
 */
public interface JishuCollectionDao extends BaseMapper<JishuCollectionEntity> {

   List<JishuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
