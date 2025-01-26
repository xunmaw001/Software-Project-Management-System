package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.WenxianCollectionDao;
import com.entity.WenxianCollectionEntity;
import com.service.WenxianCollectionService;
import com.entity.view.WenxianCollectionView;

/**
 * 文献收藏 服务实现类
 */
@Service("wenxianCollectionService")
@Transactional
public class WenxianCollectionServiceImpl extends ServiceImpl<WenxianCollectionDao, WenxianCollectionEntity> implements WenxianCollectionService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<WenxianCollectionView> page =new Query<WenxianCollectionView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
