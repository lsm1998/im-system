// 引入 router
import {RouteRecordRaw, createRouter, createWebHistory} from 'vue-router'
// 引入路由各页面配置

const routes: Array<RouteRecordRaw> = [
    {
        path: "/",
        redirect: "/index"
    },
    {
        path: "/index",
        component: import('../views/HomePage.vue')
    },
]
// 配置router对象
const router = createRouter({
    history: createWebHistory(),
    routes
})
export default router
