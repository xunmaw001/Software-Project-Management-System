import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jishu from '@/views/modules/jishu/list'
    import jishuCollection from '@/views/modules/jishuCollection/list'
    import mokuai from '@/views/modules/mokuai/list'
    import mokuaiHuafei from '@/views/modules/mokuaiHuafei/list'
    import sixin from '@/views/modules/sixin/list'
    import wenxian from '@/views/modules/wenxian/list'
    import wenxianCollection from '@/views/modules/wenxianCollection/list'
    import xiangmu from '@/views/modules/xiangmu/list'
    import xiangmujingli from '@/views/modules/xiangmujingli/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryForum from '@/views/modules/dictionaryForum/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryJishu from '@/views/modules/dictionaryJishu/list'
    import dictionaryJishuCollection from '@/views/modules/dictionaryJishuCollection/list'
    import dictionaryMokuai from '@/views/modules/dictionaryMokuai/list'
    import dictionaryMokuaiHuafei from '@/views/modules/dictionaryMokuaiHuafei/list'
    import dictionaryMokuaiZhuangtai from '@/views/modules/dictionaryMokuaiZhuangtai/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryWenxian from '@/views/modules/dictionaryWenxian/list'
    import dictionaryWenxianCollection from '@/views/modules/dictionaryWenxianCollection/list'
    import dictionaryXiangmu from '@/views/modules/dictionaryXiangmu/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryForum',
        name: '帖子类型',
        component: dictionaryForum
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryJishu',
        name: '技术类型',
        component: dictionaryJishu
    }
    ,{
        path: '/dictionaryJishuCollection',
        name: '收藏表类型',
        component: dictionaryJishuCollection
    }
    ,{
        path: '/dictionaryMokuai',
        name: '模块类型',
        component: dictionaryMokuai
    }
    ,{
        path: '/dictionaryMokuaiHuafei',
        name: '经费使用类型',
        component: dictionaryMokuaiHuafei
    }
    ,{
        path: '/dictionaryMokuaiZhuangtai',
        name: '模块状态',
        component: dictionaryMokuaiZhuangtai
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryWenxian',
        name: '文献类型',
        component: dictionaryWenxian
    }
    ,{
        path: '/dictionaryWenxianCollection',
        name: '收藏表类型',
        component: dictionaryWenxianCollection
    }
    ,{
        path: '/dictionaryXiangmu',
        name: '项目类型',
        component: dictionaryXiangmu
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/jishu',
        name: '技术',
        component: jishu
      }
    ,{
        path: '/jishuCollection',
        name: '技术收藏',
        component: jishuCollection
      }
    ,{
        path: '/mokuai',
        name: '模块',
        component: mokuai
      }
    ,{
        path: '/mokuaiHuafei',
        name: '经费使用',
        component: mokuaiHuafei
      }
    ,{
        path: '/sixin',
        name: '管理员私信',
        component: sixin
      }
    ,{
        path: '/wenxian',
        name: '文献',
        component: wenxian
      }
    ,{
        path: '/wenxianCollection',
        name: '文献收藏',
        component: wenxianCollection
      }
    ,{
        path: '/xiangmu',
        name: '项目',
        component: xiangmu
      }
    ,{
        path: '/xiangmujingli',
        name: '项目经理',
        component: xiangmujingli
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
