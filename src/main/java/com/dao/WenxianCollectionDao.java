package com.dao;

import com.entity.WenxianCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WenxianCollectionView;

/**
 * 文献收藏 Dao 接口
 *
 * @author 
 */
public interface WenxianCollectionDao extends BaseMapper<WenxianCollectionEntity> {

   List<WenxianCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
