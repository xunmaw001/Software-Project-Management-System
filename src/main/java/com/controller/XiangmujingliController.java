
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
 * 项目经理
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiangmujingli")
public class XiangmujingliController {
    private static final Logger logger = LoggerFactory.getLogger(XiangmujingliController.class);

    private static final String TABLE_NAME = "xiangmujingli";

    @Autowired
    private XiangmujingliService xiangmujingliService;


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
    private WenxianService wenxianService;//文献
    @Autowired
    private WenxianCollectionService wenxianCollectionService;//文献收藏
    @Autowired
    private XiangmuService xiangmuService;//项目
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
        PageUtils page = xiangmujingliService.queryPage(params);

        //字典表数据转换
        List<XiangmujingliView> list =(List<XiangmujingliView>)page.getList();
        for(XiangmujingliView c:list){
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
        XiangmujingliEntity xiangmujingli = xiangmujingliService.selectById(id);
        if(xiangmujingli !=null){
            //entity转view
            XiangmujingliView view = new XiangmujingliView();
            BeanUtils.copyProperties( xiangmujingli , view );//把实体数据重构到view中
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
    public R save(@RequestBody XiangmujingliEntity xiangmujingli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangmujingli:{}",this.getClass().getName(),xiangmujingli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XiangmujingliEntity> queryWrapper = new EntityWrapper<XiangmujingliEntity>()
            .eq("username", xiangmujingli.getUsername())
            .or()
            .eq("xiangmujingli_phone", xiangmujingli.getXiangmujingliPhone())
            .or()
            .eq("xiangmujingli_id_number", xiangmujingli.getXiangmujingliIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmujingliEntity xiangmujingliEntity = xiangmujingliService.selectOne(queryWrapper);
        if(xiangmujingliEntity==null){
            xiangmujingli.setCreateTime(new Date());
            xiangmujingli.setPassword("123456");
            xiangmujingliService.insert(xiangmujingli);
            return R.ok();
        }else {
            return R.error(511,"账户或者项目经理手机号或者项目经理身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangmujingliEntity xiangmujingli, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xiangmujingli:{}",this.getClass().getName(),xiangmujingli.toString());
        XiangmujingliEntity oldXiangmujingliEntity = xiangmujingliService.selectById(xiangmujingli.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xiangmujingli.getXiangmujingliPhoto()) || "null".equals(xiangmujingli.getXiangmujingliPhoto())){
                xiangmujingli.setXiangmujingliPhoto(null);
        }

            xiangmujingliService.updateById(xiangmujingli);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XiangmujingliEntity> oldXiangmujingliList =xiangmujingliService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xiangmujingliService.deleteBatchIds(Arrays.asList(ids));

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
            List<XiangmujingliEntity> xiangmujingliList = new ArrayList<>();//上传的东西
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
                            XiangmujingliEntity xiangmujingliEntity = new XiangmujingliEntity();
//                            xiangmujingliEntity.setUsername(data.get(0));                    //账户 要改的
//                            //xiangmujingliEntity.setPassword("123456");//密码
//                            xiangmujingliEntity.setXiangmujingliName(data.get(0));                    //项目经理姓名 要改的
//                            xiangmujingliEntity.setXiangmujingliPhone(data.get(0));                    //项目经理手机号 要改的
//                            xiangmujingliEntity.setXiangmujingliIdNumber(data.get(0));                    //项目经理身份证号 要改的
//                            xiangmujingliEntity.setXiangmujingliPhoto("");//详情和图片
//                            xiangmujingliEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xiangmujingliEntity.setXiangmujingliEmail(data.get(0));                    //项目经理邮箱 要改的
//                            xiangmujingliEntity.setCreateTime(date);//时间
                            xiangmujingliList.add(xiangmujingliEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //项目经理手机号
                                if(seachFields.containsKey("xiangmujingliPhone")){
                                    List<String> xiangmujingliPhone = seachFields.get("xiangmujingliPhone");
                                    xiangmujingliPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xiangmujingliPhone = new ArrayList<>();
                                    xiangmujingliPhone.add(data.get(0));//要改的
                                    seachFields.put("xiangmujingliPhone",xiangmujingliPhone);
                                }
                                //项目经理身份证号
                                if(seachFields.containsKey("xiangmujingliIdNumber")){
                                    List<String> xiangmujingliIdNumber = seachFields.get("xiangmujingliIdNumber");
                                    xiangmujingliIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiangmujingliIdNumber = new ArrayList<>();
                                    xiangmujingliIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xiangmujingliIdNumber",xiangmujingliIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XiangmujingliEntity> xiangmujingliEntities_username = xiangmujingliService.selectList(new EntityWrapper<XiangmujingliEntity>().in("username", seachFields.get("username")));
                        if(xiangmujingliEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiangmujingliEntity s:xiangmujingliEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //项目经理手机号
                        List<XiangmujingliEntity> xiangmujingliEntities_xiangmujingliPhone = xiangmujingliService.selectList(new EntityWrapper<XiangmujingliEntity>().in("xiangmujingli_phone", seachFields.get("xiangmujingliPhone")));
                        if(xiangmujingliEntities_xiangmujingliPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiangmujingliEntity s:xiangmujingliEntities_xiangmujingliPhone){
                                repeatFields.add(s.getXiangmujingliPhone());
                            }
                            return R.error(511,"数据库的该表中的 [项目经理手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //项目经理身份证号
                        List<XiangmujingliEntity> xiangmujingliEntities_xiangmujingliIdNumber = xiangmujingliService.selectList(new EntityWrapper<XiangmujingliEntity>().in("xiangmujingli_id_number", seachFields.get("xiangmujingliIdNumber")));
                        if(xiangmujingliEntities_xiangmujingliIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiangmujingliEntity s:xiangmujingliEntities_xiangmujingliIdNumber){
                                repeatFields.add(s.getXiangmujingliIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [项目经理身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiangmujingliService.insertBatch(xiangmujingliList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XiangmujingliEntity xiangmujingli = xiangmujingliService.selectOne(new EntityWrapper<XiangmujingliEntity>().eq("username", username));
        if(xiangmujingli==null || !xiangmujingli.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(xiangmujingli.getId(),username, "xiangmujingli", "项目经理");
        R r = R.ok();
        r.put("token", token);
        r.put("role","项目经理");
        r.put("username",xiangmujingli.getXiangmujingliName());
        r.put("tableName","xiangmujingli");
        r.put("userId",xiangmujingli.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XiangmujingliEntity xiangmujingli, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XiangmujingliEntity> queryWrapper = new EntityWrapper<XiangmujingliEntity>()
            .eq("username", xiangmujingli.getUsername())
            .or()
            .eq("xiangmujingli_phone", xiangmujingli.getXiangmujingliPhone())
            .or()
            .eq("xiangmujingli_id_number", xiangmujingli.getXiangmujingliIdNumber())
            ;
        XiangmujingliEntity xiangmujingliEntity = xiangmujingliService.selectOne(queryWrapper);
        if(xiangmujingliEntity != null)
            return R.error("账户或者项目经理手机号或者项目经理身份证号已经被使用");
        xiangmujingli.setCreateTime(new Date());
        xiangmujingliService.insert(xiangmujingli);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        XiangmujingliEntity xiangmujingli = xiangmujingliService.selectById(id);
        xiangmujingli.setPassword("123456");
        xiangmujingliService.updateById(xiangmujingli);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        XiangmujingliEntity xiangmujingli = xiangmujingliService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(xiangmujingli.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(xiangmujingli.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        xiangmujingli.setPassword(newPassword);
		xiangmujingliService.updateById(xiangmujingli);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XiangmujingliEntity xiangmujingli = xiangmujingliService.selectOne(new EntityWrapper<XiangmujingliEntity>().eq("username", username));
        if(xiangmujingli!=null){
            xiangmujingli.setPassword("123456");
            xiangmujingliService.updateById(xiangmujingli);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXiangmujingli(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XiangmujingliEntity xiangmujingli = xiangmujingliService.selectById(id);
        if(xiangmujingli !=null){
            //entity转view
            XiangmujingliView view = new XiangmujingliView();
            BeanUtils.copyProperties( xiangmujingli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xiangmujingliService.queryPage(params);

        //字典表数据转换
        List<XiangmujingliView> list =(List<XiangmujingliView>)page.getList();
        for(XiangmujingliView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiangmujingliEntity xiangmujingli = xiangmujingliService.selectById(id);
            if(xiangmujingli !=null){


                //entity转view
                XiangmujingliView view = new XiangmujingliView();
                BeanUtils.copyProperties( xiangmujingli , view );//把实体数据重构到view中

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
    public R add(@RequestBody XiangmujingliEntity xiangmujingli, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xiangmujingli:{}",this.getClass().getName(),xiangmujingli.toString());
        Wrapper<XiangmujingliEntity> queryWrapper = new EntityWrapper<XiangmujingliEntity>()
            .eq("username", xiangmujingli.getUsername())
            .or()
            .eq("xiangmujingli_phone", xiangmujingli.getXiangmujingliPhone())
            .or()
            .eq("xiangmujingli_id_number", xiangmujingli.getXiangmujingliIdNumber())
//            .notIn("xiangmujingli_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmujingliEntity xiangmujingliEntity = xiangmujingliService.selectOne(queryWrapper);
        if(xiangmujingliEntity==null){
            xiangmujingli.setCreateTime(new Date());
            xiangmujingli.setPassword("123456");
        xiangmujingliService.insert(xiangmujingli);

            return R.ok();
        }else {
            return R.error(511,"账户或者项目经理手机号或者项目经理身份证号已经被使用");
        }
    }

}

