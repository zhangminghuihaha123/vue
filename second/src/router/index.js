import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../components/HelloWorld')
  },
  {
    path: '/people',
    name: 'ceshi',
    component: () => import('../view/People')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../view/Login')
  },
  {
    path: '/resport',
    name: 'Resport',
    component: ()=> import('../view/Resport')
  },
  {
    path: '/front',
    name: 'front',
    redirect: '/front/carousel/a',
    component: ()=> import('../view/Front/Front'),
    children: [
      {
        path: 'carousel',
        name: 'Carousel',
        component: ()=> import('../view/Front/Carousel'),
        redirect: '/front/carousel/a',
        children:[
          {
            path: 'a',name: 'a',component: ()=> import('../view/Front/a')
          },
          {
            path: 'b',name: 'b',component: ()=> import('../view/Front/b')
          }
        ]
      },
      {
        path: 'people',name: '个人管理',component: ()=> import('../view/People')
      }
    ]
  },
  {
    path: '/',
    name: 'home',
    redirect: '/home',
    component: ()=> import('../view/Manger'),
    children:[
      {
        path: 'home',name: '首页',component: ()=> import('../view/Home')
      },
      {
        path: 'user',name: '用户管理',component: ()=> import('../view/User')
      },
      {
        path: 'file',name: '文件管理',component: ()=> import('../view/File')
      },
      {
        path: 'people',name: '个人管理',component: ()=> import('../view/People')
      },
      {
        path: 'role',name: '角色管理',component: ()=> import('../view/Role')
      },
      {
        path: 'editor',name: '物品录入管理',component: ()=> import('../view/editor')
      },
      {
        path: '/im', name: 'im', component: () => import('../view/im')
      },
      {
        path: '/time', name: 'time', component: () => import('../view/Time')
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
