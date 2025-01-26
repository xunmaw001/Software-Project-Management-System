
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
 * 技术
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jishu")
public class JishuController {
    private static final Logger logger = LoggerFactory.getLogger(JishuController.class);

    private static final String TABLE_NAME = "jishu";

    @Autowired
    private JishuService jishuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JishuCollectionService jishuCollectionService;//技术收藏
    @Autowired
    private MokuaiService mokuaiService;//模块
    @Autowired
    private MokuaiHuafeiService mokuaiHuafeiService;//经费使用
    @Autowired
    private SixinService sixinService;//管理员私信
    @Autowired
    private WenxianService wenxianService;//文献
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
        params.put("jishuDeleteStart",1);params.put("jishuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jishuService.queryPage(params);

        //字典表数据转换
        List<JishuView> list =(List<JishuView>)page.getList();
        for(JishuView c:list){
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
        JishuEntity jishu = jishuService.selectById(id);
        if(jishu !=null){
            //entity转view
            JishuView view = new JishuView();
            BeanUtils.copyProperties( jishu , view );//把实体数据重构到view中
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
    public R save(@RequestBody JishuEntity jishu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jishu:{}",this.getClass().getName(),jishu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JishuEntity> queryWrapper = new EntityWrapper<JishuEntity>()
            .eq("jishu_name", jishu.getJishuName())
            .eq("jishu_types", jishu.getJishuTypes())
            .eq("shangxia_types", jishu.getShangxiaTypes())
            .eq("jishu_delete", jishu.getJishuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JishuEntity jishuEntity = jishuService.selectOne(queryWrapper);
        if(jishuEntity==null){
            jishu.setShangxiaTypes(1);
            jishu.setJishuDelete(1);
            jishu.setInsertTime(new Date());
            jishu.setCreateTime(new Date());
            jishuService.insert(jishu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JishuEntity jishu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jishu:{}",this.getClass().getName(),jishu.toString());
        JishuEntity oldJishuEntity = jishuService.selectById(jishu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jishu.getJishuPhoto()) || "null".equals(jishu.getJishuPhoto())){
                jishu.setJishuPhoto(null);
        }
        if("".equals(jishu.getJishuFile()) || "null".equals(jishu.getJishuFile())){
                jishu.setJishuFile(null);
        }

            jishuService.updateById(jishu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JishuEntity> oldJishuList =jishuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JishuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JishuEntity jishuEntity = new JishuEntity();
            jishuEntity.setId(id);
            jishuEntity.setJishuDelete(2);
            list.add(jishuEntity);
        }
        if(list != null && list.size() >0){
            jishuService.updateBatchById(list);
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
            List<JishuEntity> jishuList = new ArrayList<>();//上传的东西
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
                            JishuEntity jishuEntity = new JishuEntity();
//                            jishuEntity.setJishuName(data.get(0));                    //技术名称 要改的
//                            jishuEntity.setJishuUuidNumber(data.get(0));                    //技术编号 要改的
//                            jishuEntity.setJishuPhoto("");//详情和图片
//                            jishuEntity.setJishuFile(data.get(0));                    //技术附件 要改的
//                            jishuEntity.setJishuTypes(Integer.valueOf(data.get(0)));   //技术类型 要改的
//                            jishuEntity.setJishuContent("");//详情和图片
//                            jishuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            jishuEntity.setJishuDelete(1);//逻辑删除字段
//                            jishuEntity.setInsertTime(date);//时间
//                            jishuEntity.setCreateTime(date);//时间
                            jishuList.add(jishuEntity);


                            //把要查询是否重复的字段放入map中
                                //技术编号
                                if(seachFields.containsKey("jishuUuidNumber")){
                                    List<String> jishuUuidNumber = seachFields.get("jishuUuidNumber");
                                    jishuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jishuUuidNumber = new ArrayList<>();
                                    jishuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jishuUuidNumber",jishuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //技术编号
                        List<JishuEntity> jishuEntities_jishuUuidNumber = jishuService.selectList(new EntityWrapper<JishuEntity>().in("jishu_uuid_number", seachFields.get("jishuUuidNumber")).eq("jishu_delete", 1));
                        if(jishuEntities_jishuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JishuEntity s:jishuEntities_jishuUuidNumber){
                                repeatFields.add(s.getJishuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [技术编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jishuService.insertBatch(jishuList);
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
        List<JishuView> returnJishuViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = jishuCollectionService.queryPage(params1);
        List<JishuCollectionView> collectionViewsList =(List<JishuCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(JishuCollectionView collectionView:collectionViewsList){
            Integer jishuTypes = collectionView.getJishuTypes();
            if(typeMap.containsKey(jishuTypes)){
                typeMap.put(jishuTypes,typeMap.get(jishuTypes)+1);
            }else{
                typeMap.put(jishuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("jishuTypes",type);
            PageUtils pageUtils1 = jishuService.queryPage(params2);
            List<JishuView> jishuViewList =(List<JishuView>)pageUtils1.getList();
            returnJishuViewList.addAll(jishuViewList);
            if(returnJishuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = jishuService.queryPage(params);
        if(returnJishuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnJishuViewList.size();//要添加的数量
            List<JishuView> jishuViewList =(List<JishuView>)page.getList();
            for(JishuView jishuView:jishuViewList){
                Boolean addFlag = true;
                for(JishuView returnJishuView:returnJishuViewList){
                    if(returnJishuView.getId().intValue() ==jishuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnJishuViewList.add(jishuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnJishuViewList = returnJishuViewList.subList(0, limit);
        }

        for(JishuView c:returnJishuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnJishuViewList);
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
        PageUtils page = jishuService.queryPage(params);

        //字典表数据转换
        List<JishuView> list =(List<JishuView>)page.getList();
        for(JishuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JishuEntity jishu = jishuService.selectById(id);
            if(jishu !=null){


                //entity转view
                JishuView view = new JishuView();
                BeanUtils.copyProperties( jishu , view );//把实体数据重构到view中

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
    public R add(@RequestBody JishuEntity jishu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jishu:{}",this.getClass().getName(),jishu.toString());
        Wrapper<JishuEntity> queryWrapper = new EntityWrapper<JishuEntity>()
            .eq("jishu_name", jishu.getJishuName())
            .eq("jishu_uuid_number", jishu.getJishuUuidNumber())
            .eq("jishu_types", jishu.getJishuTypes())
            .eq("shangxia_types", jishu.getShangxiaTypes())
            .eq("jishu_delete", jishu.getJishuDelete())
//            .notIn("jishu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JishuEntity jishuEntity = jishuService.selectOne(queryWrapper);
        if(jishuEntity==null){
            jishu.setJishuDelete(1);
            jishu.setInsertTime(new Date());
            jishu.setCreateTime(new Date());
        jishuService.insert(jishu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

