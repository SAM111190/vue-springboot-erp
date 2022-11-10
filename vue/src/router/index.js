import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/manage',
    name: 'Manage',
    component: () => import('../views/back/Manage'),
    redirect:'/manage/back_home',
    children: [
      {
        path: 'back_home',
        name: 'Home',
        component: () =>import('../views/back/Home')
      },
      {
        path: '/goods',
        name: 'Goods',
        component: () =>import('../views/back/goods')
      },
    ]
  },
  {
    path: '/',
    name:'front',
    component:() =>import('../views/frontview/front_layout'),
    redirect: '/home',
    children: [
      {
        path: '/home',
        name:'front_home',
        component:() =>import('../views/frontview/Home'),
      },
      {
        path: '/goods_details',
        name:'goods_details',
        component:() =>import('../views/frontview/goods_details'),
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
