import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'element-plus/theme-chalk/index.css';
import zhCn from 'element-plus/es/locale/lang/zh-cn';
import axios from 'axios';
import VueAxios from 'vue-axios'
import './assets/gloable.css'
createApp(App).use(store).use(router).use(VueAxios,axios).use(ElementPlus,{locale: zhCn, size:'small'}).mount('#app')
