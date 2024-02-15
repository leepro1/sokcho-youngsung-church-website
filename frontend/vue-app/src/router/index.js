import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/member',
    name: 'ListView',
    component: () => import(/* webpackChunkName: "member" */ '../views/ListView.vue')
  },
  {
    path: '/member/detail',
    name: 'SelectView',
    component: () => import(/* webpackChunkName: "member" */ '../views/SelectView.vue')
  },
  {
    path: '/member/editById',
    name: 'UpdateView',
    component: () => import(/* webpackChunkName: "member" */ '../views/UpdateView.vue')
  },
  {
    path: '/member/save',
    name: 'CreateView',
    component: () => import(/* webpackChunkName: "member" */ '../views/CreateView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
