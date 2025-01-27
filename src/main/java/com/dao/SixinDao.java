package com.dao;

import com.entity.SixinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SixinView;

/**
 * 管理员私信 Dao 接口
 *
 * @author 
 */
public interface SixinDao extends BaseMapper<SixinEntity> {

   List<SixinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
