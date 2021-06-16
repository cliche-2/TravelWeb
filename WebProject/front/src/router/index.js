import Vue from 'vue'
import VueRouter from 'vue-router'
import HelloWorld from '@/components/HelloWorld.vue'
import Login from '@/components/member/login.vue'
import SiteList from '@/components/info/sitelist.vue'
import AreaList from '@/components/info/arealist.vue'
import InfoDetail from '@/components/info/detail.vue'
import Register from '@/components/member/register.vue'
import Admin from '@/components/member/admin.vue'
import Mypage from '@/components/member/mypage.vue'


Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [{
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
      meta: {
        unauthorized: true
      }
    },
    {
      path: '/site-list',
      name: 'SiteList',
      component: SiteList,
      props: true
    },
    {
      path: '/area-list',
      name: 'AreaList',
      component: AreaList,
      props: true
    },
    {
      path: '/info-detail',
      name: 'InfoDetail',
      component: InfoDetail
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/mypage',
      name: 'Mypage',
      component: Mypage
    },
    {
      path: '/admin',
      name: 'Admin',
      component: Admin
    }
  ]
})
