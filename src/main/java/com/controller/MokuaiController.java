
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
 * 模块
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/mokuai")
public class MokuaiController {
    private static final Logger logger = LoggerFactory.getLogger(MokuaiController.class);

    private static final String TABLE_NAME = "mokuai";

    @Autowired
    private MokuaiService mokuaiService;


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
        CommonUtil.checkMap(params);
        PageUtils page = mokuaiService.queryPage(params);

        //字典表数据转换
        List<MokuaiView> list =(List<MokuaiView>)page.getList();
        for(MokuaiView c:list){
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
        MokuaiEntity mokuai = mokuaiService.selectById(id);
        if(mokuai !=null){
            //entity转view
            MokuaiView view = new MokuaiView();
            BeanUtils.copyProperties( mokuai , view );//把实体数据重构到view中
            //级联表 项目
            //级联表
            XiangmuEntity xiangmu = xiangmuService.selectById(mokuai.getXiangmuId());
            if(xiangmu != null){
            BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXiangmuId(xiangmu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(mokuai.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody MokuaiEntity mokuai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,mokuai:{}",this.getClass().getName(),mokuai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            mokuai.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<MokuaiEntity> queryWrapper = new EntityWrapper<MokuaiEntity>()
            .eq("xiangmu_id", mokuai.getXiangmuId())
            .eq("yonghu_id", mokuai.getYonghuId())
            .eq("mokuai_name", mokuai.getMokuaiName())
            .eq("mokuai_types", mokuai.getMokuaiTypes())
            .eq("mokuai_zhuangtai_types", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MokuaiEntity mokuaiEntity = mokuaiService.selectOne(queryWrapper);
        if(mokuaiEntity==null){

            XiangmuEntity xiangmuEntity = xiangmuService.selectById(mokuai.getXiangmuId());
            if(xiangmuEntity==null){
                return R.error("查不到项目");
            }
            double balance = xiangmuEntity.getXiangmuShengyuJine() - mokuai.getMokuaiJine();
            if(balance<0)
                return R.error("项目剩余金额不足以支付此次模块花费");

            xiangmuEntity.setXiangmuShengyuJine(balance);
            xiangmuService.updateById(xiangmuEntity);


            mokuai.setMokuaiZhuangtaiTypes(1);
            mokuai.setInsertTime(new Date());
            mokuai.setCreateTime(new Date());
            mokuaiService.insert(mokuai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MokuaiEntity mokuai, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,mokuai:{}",this.getClass().getName(),mokuai.toString());
        MokuaiEntity oldMokuaiEntity = mokuaiService.selectById(mokuai.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            mokuai.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(mokuai.getMokuaiFile()) || "null".equals(mokuai.getMokuaiFile())){
                mokuai.setMokuaiFile(null);
        }

            mokuaiService.updateById(mokuai);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MokuaiEntity> oldMokuaiList =mokuaiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        mokuaiService.deleteBatchIds(Arrays.asList(ids));

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
            List<MokuaiEntity> mokuaiList = new ArrayList<>();//上传的东西
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
                            MokuaiEntity mokuaiEntity = new MokuaiEntity();
//                            mokuaiEntity.setXiangmuId(Integer.valueOf(data.get(0)));   //项目 要改的
//                            mokuaiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            mokuaiEntity.setMokuaiUuidNumber(data.get(0));                    //模块编号 要改的
//                            mokuaiEntity.setMokuaiName(data.get(0));                    //模块名称 要改的
//                            mokuaiEntity.setMokuaiTypes(Integer.valueOf(data.get(0)));   //模块类型 要改的
//                            mokuaiEntity.setMokuaiJine(data.get(0));                    //模块经费 要改的
//                            mokuaiEntity.setInsertTime(date);//时间
//                            mokuaiEntity.setMokuaiContent("");//详情和图片
//                            mokuaiEntity.setMokuaiZhuangtaiTypes(Integer.valueOf(data.get(0)));   //模块状态 要改的
//                            mokuaiEntity.setMokuaiFile(data.get(0));                    //模块成果 要改的
//                            mokuaiEntity.setMokuaiChengguoContent("");//详情和图片
//                            mokuaiEntity.setCreateTime(date);//时间
                            mokuaiList.add(mokuaiEntity);


                            //把要查询是否重复的字段放入map中
                                //模块编号
                                if(seachFields.containsKey("mokuaiUuidNumber")){
                                    List<String> mokuaiUuidNumber = seachFields.get("mokuaiUuidNumber");
                                    mokuaiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> mokuaiUuidNumber = new ArrayList<>();
                                    mokuaiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("mokuaiUuidNumber",mokuaiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //模块编号
                        List<MokuaiEntity> mokuaiEntities_mokuaiUuidNumber = mokuaiService.selectList(new EntityWrapper<MokuaiEntity>().in("mokuai_uuid_number", seachFields.get("mokuaiUuidNumber")));
                        if(mokuaiEntities_mokuaiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MokuaiEntity s:mokuaiEntities_mokuaiUuidNumber){
                                repeatFields.add(s.getMokuaiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [模块编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        mokuaiService.insertBatch(mokuaiList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = mokuaiService.queryPage(params);

        //字典表数据转换
        List<MokuaiView> list =(List<MokuaiView>)page.getList();
        for(MokuaiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MokuaiEntity mokuai = mokuaiService.selectById(id);
            if(mokuai !=null){


                //entity转view
                MokuaiView view = new MokuaiView();
                BeanUtils.copyProperties( mokuai , view );//把实体数据重构到view中

                //级联表
                    XiangmuEntity xiangmu = xiangmuService.selectById(mokuai.getXiangmuId());
                if(xiangmu != null){
                    BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiangmuId(xiangmu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(mokuai.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody MokuaiEntity mokuai, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,mokuai:{}",this.getClass().getName(),mokuai.toString());
        Wrapper<MokuaiEntity> queryWrapper = new EntityWrapper<MokuaiEntity>()
            .eq("xiangmu_id", mokuai.getXiangmuId())
            .eq("yonghu_id", mokuai.getYonghuId())
            .eq("mokuai_uuid_number", mokuai.getMokuaiUuidNumber())
            .eq("mokuai_name", mokuai.getMokuaiName())
            .eq("mokuai_types", mokuai.getMokuaiTypes())
            .eq("mokuai_zhuangtai_types", mokuai.getMokuaiZhuangtaiTypes())
//            .notIn("mokuai_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MokuaiEntity mokuaiEntity = mokuaiService.selectOne(queryWrapper);
        if(mokuaiEntity==null){
            mokuai.setInsertTime(new Date());
            mokuai.setCreateTime(new Date());
        mokuaiService.insert(mokuai);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

