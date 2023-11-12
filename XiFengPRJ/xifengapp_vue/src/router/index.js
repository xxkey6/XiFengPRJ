import VueRouter from 'vue-router'
import Vue from 'vue'

Vue.use(VueRouter)

export default new VueRouter({
    routes:[
        {
            path: '/', // 项目启动默认路径
            component: () => import('@/components/Whole.vue'),
            redirect: '/home', // 跳转登录界面
            children: [
                {
                    path: '/home',
                    component: () => import('@/components/Home.vue')
                },
                {
                    path: '/user_details',
                    component: () => import('@/components/Details/UserDetails.vue')
                },
                {
                    path: '/user_orders',
                    component: () => import('@/components/Details/MyOrders.vue')
                },
                {
                    path: '/shop1',
                    component: () => import('@/pages/Shop01/index.vue'),
                    redirect: '/shop1/shop1-1', // 默认选中第一个二级菜单
                    children:[
                        {
                            path: 'shop1-1',
                            component: () => import('@/pages/Shop01/Shop1-1.vue')
                        },
                        {
                            path: 'shop1-2',
                            component: () => import('@/pages/Shop01/Shop1-2.vue')
                        },
                    ]
                },
                {
                    path: '/shop2',
                    component: () => import('@/pages/Shop02/index.vue'),
                    redirect: '/shop2/shop2-1', // 默认选中第一个二级菜单
                    children:[
                        {
                            path: 'shop2-1',
                            component: () => import('@/pages/Shop02/Shop2-1.vue')
                        },
                        {
                            path: 'shop2-2',
                            component: () => import('@/pages/Shop02/Shop2-2.vue')
                        },
                    ]
                },
                {
                    path: '/shop3',
                    component: () => import('@/pages/Shop03/index.vue'),
                    redirect: '/shop3/shop3-1', // 默认选中第一个二级菜单
                    children:[
                        {
                            path: 'shop3-1',
                            component: () => import('@/pages/Shop03/Shop3-1.vue')
                        },
                    ]
                },
                {
                    path: '/shop4',
                    component: () => import('@/pages/Shop04/index.vue'),
                    redirect: '/shop4/shop4-1', // 默认选中第一个二级菜单
                    children:[
                        {
                            path: 'shop4-1',
                            component: () => import('@/pages/Shop04/Shop4-1.vue')
                        },
                        {
                            path: 'shop4-2',
                            component: () => import('@/pages/Shop04/Shop4-2.vue')
                        },
                    ]
                },

            ]
        },
        
        {
            path: '/login',
            component: () => import("@/components/Login.vue"),
        },
    
    ]
})

