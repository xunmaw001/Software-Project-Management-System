
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 文献
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wenxian")
public class WenxianController {
    private static final Logger logger = LoggerFactory.getLogger(WenxianController.class);

    private static final String TABLE_NAME = "wenxian";

    @Autowired
    private WenxianService wenxianService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JishuService jishuService;//技术
    @Autowired
    private JishuCollectionService jishuCollectionService;//技术收藏
    @Autowired
    private MokuaiService mokuaiService;//模块
    @Autowired
    private MokuaiHuafeiService mokuaiHuafeiService;//经费使用
    @Autowired
    private SixinService sixinService;//管理员私信
    @Autowired
    private WenxianCollectionService wenxianCollectionService;//文献收藏
    @Autowired
    private XiangmuService xiangmuService;//项目
    @Autowired
    private XiangmujingliService xiangmujingliService;//项目经理
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("项目经理".equals(role))
            params.put("xiangmujingliId",request.getSession().getAttribute("userId"));
        params.put("wenxianDeleteStart",1);params.put("wenxianDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wenxianService.queryPage(params);

        //字典表数据转换
        List<WenxianView> list =(List<WenxianView>)page.getList();
        for(WenxianView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WenxianEntity wenxian = wenxianService.selectById(id);
        if(wenxian !=null){
            //entity转view
            WenxianView view = new WenxianView();
            BeanUtils.copyProperties( wenxian , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WenxianEntity wenxian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wenxian:{}",this.getClass().getName(),wenxian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WenxianEntity> queryWrapper = new EntityWrapper<WenxianEntity>()
            .eq("wenxian_name", wenxian.getWenxianName())
            .eq("wenxian_types", wenxian.getWenxianTypes())
            .eq("shangxia_types", wenxian.getShangxiaTypes())
            .eq("wenxian_delete", wenxian.getWenxianDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenxianEntity wenxianEntity = wenxianService.selectOne(queryWrapper);
        if(wenxianEntity==null){
            wenxian.setShangxiaTypes(1);
            wenxian.setWenxianDelete(1);
            wenxian.setInsertTime(new Date());
            wenxian.setCreateTime(new Date());
            wenxianService.insert(wenxian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WenxianEntity wenxian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wenxian:{}",this.getClass().getName(),wenxian.toString());
        WenxianEntity oldWenxianEntity = wenxianService.selectById(wenxian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(wenxian.getWenxianPhoto()) || "null".equals(wenxian.getWenxianPhoto())){
                wenxian.setWenxianPhoto(null);
        }
        if("".equals(wenxian.getWenxianFile()) || "null".equals(wenxian.getWenxianFile())){
                wenxian.setWenxianFile(null);
        }

            wenxianService.updateById(wenxian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WenxianEntity> oldWenxianList =wenxianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<WenxianEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WenxianEntity wenxianEntity = new WenxianEntity();
            wenxianEntity.setId(id);
            wenxianEntity.setWenxianDelete(2);
            list.add(wenxianEntity);
        }
        if(list != null && list.size() >0){
            wenxianService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<WenxianEntity> wenxianList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WenxianEntity wenxianEntity = new WenxianEntity();
//                            wenxianEntity.setWenxianName(data.get(0));                    //文献名称 要改的
//                            wenxianEntity.setWenxianUuidNumber(data.get(0));                    //文献编号 要改的
//                            wenxianEntity.setWenxianPhoto("");//详情和图片
//                            wenxianEntity.setWenxianFile(data.get(0));                    //文献附件 要改的
//                            wenxianEntity.setWenxianTypes(Integer.valueOf(data.get(0)));   //文献类型 要改的
//                            wenxianEntity.setWenxianContent("");//详情和图片
//                            wenxianEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            wenxianEntity.setWenxianDelete(1);//逻辑删除字段
//                            wenxianEntity.setInsertTime(date);//时间
//                            wenxianEntity.setCreateTime(date);//时间
                            wenxianList.add(wenxianEntity);


                            //把要查询是否重复的字段放入map中
                                //文献编号
                                if(seachFields.containsKey("wenxianUuidNumber")){
                                    List<String> wenxianUuidNumber = seachFields.get("wenxianUuidNumber");
                                    wenxianUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wenxianUuidNumber = new ArrayList<>();
                                    wenxianUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wenxianUuidNumber",wenxianUuidNumber);
                                }
                        }

                        //查询是否重复
                         //文献编号
                        List<WenxianEntity> wenxianEntities_wenxianUuidNumber = wenxianService.selectList(new EntityWrapper<WenxianEntity>().in("wenxian_uuid_number", seachFields.get("wenxianUuidNumber")).eq("wenxian_delete", 1));
                        if(wenxianEntities_wenxianUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WenxianEntity s:wenxianEntities_wenxianUuidNumber){
                                repeatFields.add(s.getWenxianUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [文献编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wenxianService.insertBatch(wenxianList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<WenxianView> returnWenxianViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = wenxianCollectionService.queryPage(params1);
        List<WenxianCollectionView> collectionViewsList =(List<WenxianCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(WenxianCollectionView collectionView:collectionViewsList){
            Integer wenxianTypes = collectionView.getWenxianTypes();
            if(typeMap.containsKey(wenxianTypes)){
                typeMap.put(wenxianTypes,typeMap.get(wenxianTypes)+1);
            }else{
                typeMap.put(wenxianTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("wenxianTypes",type);
            PageUtils pageUtils1 = wenxianService.queryPage(params2);
            List<WenxianView> wenxianViewList =(List<WenxianView>)pageUtils1.getList();
            returnWenxianViewList.addAll(wenxianViewList);
            if(returnWenxianViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = wenxianService.queryPage(params);
        if(returnWenxianViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnWenxianViewList.size();//要添加的数量
            List<WenxianView> wenxianViewList =(List<WenxianView>)page.getList();
            for(WenxianView wenxianView:wenxianViewList){
                Boolean addFlag = true;
                for(WenxianView returnWenxianView:returnWenxianViewList){
                    if(returnWenxianView.getId().intValue() ==wenxianView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnWenxianViewList.add(wenxianView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnWenxianViewList = returnWenxianViewList.subList(0, limit);
        }

        for(WenxianView c:returnWenxianViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnWenxianViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wenxianService.queryPage(params);

        //字典表数据转换
        List<WenxianView> list =(List<WenxianView>)page.getList();
        for(WenxianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WenxianEntity wenxian = wenxianService.selectById(id);
            if(wenxian !=null){


                //entity转view
                WenxianView view = new WenxianView();
                BeanUtils.copyProperties( wenxian , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WenxianEntity wenxian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wenxian:{}",this.getClass().getName(),wenxian.toString());
        Wrapper<WenxianEntity> queryWrapper = new EntityWrapper<WenxianEntity>()
            .eq("wenxian_name", wenxian.getWenxianName())
            .eq("wenxian_uuid_number", wenxian.getWenxianUuidNumber())
            .eq("wenxian_types", wenxian.getWenxianTypes())
            .eq("shangxia_types", wenxian.getShangxiaTypes())
            .eq("wenxian_delete", wenxian.getWenxianDelete())
//            .notIn("wenxian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenxianEntity wenxianEntity = wenxianService.selectOne(queryWrapper);
        if(wenxianEntity==null){
            wenxian.setWenxianDelete(1);
            wenxian.setInsertTime(new Date());
            wenxian.setCreateTime(new Date());
        wenxianService.insert(wenxian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

