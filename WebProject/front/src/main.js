import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import vuecookies from 'vue-cookies'

Vue.config.productionTip = false
Vue.prototype.$cookies = vuecookies
Vue.prototype.$axios = axios  //Vue객체에 전역변수 추가

new Vue({
  router,
  render: h => h(App),
}).$mount('#app') // index.html <div id="app"><div>에 컴포넌트가 마운팅된다
