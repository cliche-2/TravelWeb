import Vue from 'vue'
import VueRouter from 'vue-router'
// import 순서도 중요한듯 
import HelloWorld from '@/components/HelloWorld.vue'
import Login from '@/components/member/login.vue'
import InfoList from '@/components/info/infolist.vue'
import InfoList2 from '@/components/info/infolist2.vue'
import InfoDetail from '@/components/info/detail.vue'
import Register from '@/components/member/register.vue'
import Admin from '@/components/member/admin.vue'
import Mypage from '@/components/member/mypage.vue'



Vue.use(VueRouter)


export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
      meta:{unauthorized:true}
    },
    {
      path: '/info-list',
      name: 'InfoList',
      component: InfoList,
      props: true
    },
    {
      path: '/info-list2',
      name: 'InfoList2',
      component: InfoList2
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
