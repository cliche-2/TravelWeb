import Vue from 'vue'
import VueRouter from 'vue-router'
import InfoList from '@/components/info/infolist.vue'
import InfoList2 from '@/components/info/infolist2.vue'
import Login from '@/components/member/login.vue'
import Register from '@/components/member/register.vue'
import HelloWorld from '@/components/HelloWorld.vue'

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
      component: Login
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
      path: '/register',
      name: 'Register',
      component: Register
    }
  ]
  })
