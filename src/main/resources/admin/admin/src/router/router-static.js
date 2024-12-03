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
    import address from '@/views/modules/address/list'
    import cart from '@/views/modules/cart/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jiankongjiedian from '@/views/modules/jiankongjiedian/list'
    import jiankongjiedianJilu from '@/views/modules/jiankongjiedianJilu/list'
    import nongshianpai from '@/views/modules/nongshianpai/list'
    import nongzuowu from '@/views/modules/nongzuowu/list'
    import nongzuowuCollection from '@/views/modules/nongzuowuCollection/list'
    import nongzuowuLiuyan from '@/views/modules/nongzuowuLiuyan/list'
    import qixiangshuju from '@/views/modules/qixiangshuju/list'
    import qixiangshujuCollection from '@/views/modules/qixiangshujuCollection/list'
    import qixiangshujuLiuyan from '@/views/modules/qixiangshujuLiuyan/list'
    import shangpin from '@/views/modules/shangpin/list'
    import shangpinCollection from '@/views/modules/shangpinCollection/list'
    import shangpinCommentback from '@/views/modules/shangpinCommentback/list'
    import shangpinOrder from '@/views/modules/shangpinOrder/list'
    import tudi from '@/views/modules/tudi/list'
    import tudiCollection from '@/views/modules/tudiCollection/list'
    import tudiLiuyan from '@/views/modules/tudiLiuyan/list'
    import xuanmiaoyuzhong from '@/views/modules/xuanmiaoyuzhong/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yuangong from '@/views/modules/yuangong/list'
    import config from '@/views/modules/config/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryIsdefault from '@/views/modules/dictionaryIsdefault/list'
    import dictionaryJiankongjiedian from '@/views/modules/dictionaryJiankongjiedian/list'
    import dictionaryJinyong from '@/views/modules/dictionaryJinyong/list'
    import dictionaryNongshianpai from '@/views/modules/dictionaryNongshianpai/list'
    import dictionaryNongzuowu from '@/views/modules/dictionaryNongzuowu/list'
    import dictionaryNongzuowuCollection from '@/views/modules/dictionaryNongzuowuCollection/list'
    import dictionaryQixiangshuju from '@/views/modules/dictionaryQixiangshuju/list'
    import dictionaryQixiangshujuCollection from '@/views/modules/dictionaryQixiangshujuCollection/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangpin from '@/views/modules/dictionaryShangpin/list'
    import dictionaryShangpinCollection from '@/views/modules/dictionaryShangpinCollection/list'
    import dictionaryShangpinOrder from '@/views/modules/dictionaryShangpinOrder/list'
    import dictionaryShangpinOrderPayment from '@/views/modules/dictionaryShangpinOrderPayment/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryTudi from '@/views/modules/dictionaryTudi/list'
    import dictionaryTudiCollection from '@/views/modules/dictionaryTudiCollection/list'
    import dictionaryXuanmiaoyuzhong from '@/views/modules/dictionaryXuanmiaoyuzhong/list'





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
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryIsdefault',
        name: '是否默认地址',
        component: dictionaryIsdefault
    }
    ,{
        path: '/dictionaryJiankongjiedian',
        name: '监控节点类型',
        component: dictionaryJiankongjiedian
    }
    ,{
        path: '/dictionaryJinyong',
        name: '账户状态',
        component: dictionaryJinyong
    }
    ,{
        path: '/dictionaryNongshianpai',
        name: '农事安排类型',
        component: dictionaryNongshianpai
    }
    ,{
        path: '/dictionaryNongzuowu',
        name: '农作物类型',
        component: dictionaryNongzuowu
    }
    ,{
        path: '/dictionaryNongzuowuCollection',
        name: '收藏表类型',
        component: dictionaryNongzuowuCollection
    }
    ,{
        path: '/dictionaryQixiangshuju',
        name: '气象数据类型',
        component: dictionaryQixiangshuju
    }
    ,{
        path: '/dictionaryQixiangshujuCollection',
        name: '收藏表类型',
        component: dictionaryQixiangshujuCollection
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangpin',
        name: '商品类型',
        component: dictionaryShangpin
    }
    ,{
        path: '/dictionaryShangpinCollection',
        name: '收藏表类型',
        component: dictionaryShangpinCollection
    }
    ,{
        path: '/dictionaryShangpinOrder',
        name: '订单类型',
        component: dictionaryShangpinOrder
    }
    ,{
        path: '/dictionaryShangpinOrderPayment',
        name: '订单支付类型',
        component: dictionaryShangpinOrderPayment
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryTudi',
        name: '土地类型',
        component: dictionaryTudi
    }
    ,{
        path: '/dictionaryTudiCollection',
        name: '收藏表类型',
        component: dictionaryTudiCollection
    }
    ,{
        path: '/dictionaryXuanmiaoyuzhong',
        name: '选苗育种类型',
        component: dictionaryXuanmiaoyuzhong
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/address',
        name: '收货地址',
        component: address
      }
    ,{
        path: '/cart',
        name: '购物车',
        component: cart
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告信息',
        component: gonggao
      }
    ,{
        path: '/jiankongjiedian',
        name: '监控节点',
        component: jiankongjiedian
      }
    ,{
        path: '/jiankongjiedianJilu',
        name: '监控记录',
        component: jiankongjiedianJilu
      }
    ,{
        path: '/nongshianpai',
        name: '农事安排',
        component: nongshianpai
      }
    ,{
        path: '/nongzuowu',
        name: '农作物',
        component: nongzuowu
      }
    ,{
        path: '/nongzuowuCollection',
        name: '农作物收藏',
        component: nongzuowuCollection
      }
    ,{
        path: '/nongzuowuLiuyan',
        name: '农作物留言',
        component: nongzuowuLiuyan
      }
    ,{
        path: '/qixiangshuju',
        name: '气象数据',
        component: qixiangshuju
      }
    ,{
        path: '/qixiangshujuCollection',
        name: '气象数据收藏',
        component: qixiangshujuCollection
      }
    ,{
        path: '/qixiangshujuLiuyan',
        name: '气象数据留言',
        component: qixiangshujuLiuyan
      }
    ,{
        path: '/shangpin',
        name: '商品',
        component: shangpin
      }
    ,{
        path: '/shangpinCollection',
        name: '商品收藏',
        component: shangpinCollection
      }
    ,{
        path: '/shangpinCommentback',
        name: '商品评价',
        component: shangpinCommentback
      }
    ,{
        path: '/shangpinOrder',
        name: '商品订单',
        component: shangpinOrder
      }
    ,{
        path: '/tudi',
        name: '土地规划',
        component: tudi
      }
    ,{
        path: '/tudiCollection',
        name: '土地规划收藏',
        component: tudiCollection
      }
    ,{
        path: '/tudiLiuyan',
        name: '土地留言',
        component: tudiLiuyan
      }
    ,{
        path: '/xuanmiaoyuzhong',
        name: '选苗育种',
        component: xuanmiaoyuzhong
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
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
