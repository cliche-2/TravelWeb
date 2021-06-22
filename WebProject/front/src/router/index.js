import Vue from 'vue'
import VueRouter from 'vue-router'
import HelloWorld from '@/components/HelloWorld.vue'
import Login from '@/components/member/login.vue'
import SiteList from '@/components/info/sitelist.vue'
import AreaList from '@/components/info/arealist.vue'
import Search from '@/components/info/search.vue'
import InfoDetail from '@/components/info/detail.vue'
import Register from '@/components/member/register.vue'
import Admin from '@/components/member/admin.vue'
import Mypage from '@/components/member/mypage.vue'
import Myinfo from '@/components/member/myinfo.vue'
import Mypost from '@/components/member/mypost.vue'
import NoDetail from '@/components/notice/nodetail.vue'
import NoList from '@/components/notice/nolist.vue'
import NoWrite from '@/components/notice/nowrite.vue'


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
      path: '/search',
      name: 'Search',
      component: Search,
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
      path: '/mypost',
      name: 'Mypost',
      component: Mypost
    },
    {
      path: '/myinfo',
      name: 'Myinfo',
      component: Myinfo
    },
    {
      path: '/no-detail',
      name: 'NoDetail',
      component: NoDetail
    },
    {
      path: '/no-list',
      name: 'NoList',
      component: NoList
    },
    {
      path: '/no-write',
      name: 'NoWrite',
      component: NoWrite
    },
    {
      path: '/admin',
      name: 'Admin',
      component: Admin
    }
  ]
})
