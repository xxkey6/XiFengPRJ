import Vue from 'vue'
import App from './App.vue'

// 引入router配置文件(js)
import router from './router/index'
// 引入element-ui组件 及其 CSS样式表
import ElmentUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 引入axios组件
import axios from 'axios'
// 引入Vuex store
import store from './store/index'
// 引入animate.css
import animate from 'animate.css'
// 引入wow.js
import wow from 'wowjs'
import 'wowjs/css/libs/animate.css'

axios.defaults.baseURL = '/api/'

Vue.config.productionTip = false
Vue.prototype.$axios = axios
Vue.prototype.$wow = wow
Vue.use(ElmentUi)
Vue.use(animate)


new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')
