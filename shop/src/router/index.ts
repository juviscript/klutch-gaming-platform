import { createRouter, createWebHistory } from 'vue-router'
import { useAuthStore } from '@/stores/auth'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: () => import('@/views/HomeView.vue') },
    { path: '/products', component: () => import('@/views/ProductsView.vue') },
    { path: '/products/:id', component: () => import('@/views/ProductDetailView.vue') },
    { path: '/cart', component: () => import('@/views/CartView.vue') },
    { path: '/login', component: () => import('@/views/LoginView.vue') },
    { path: '/register', component: () => import('@/views/RegisterView.vue') },
    {
      path: '/account',
      component: () => import('@/views/AccountView.vue'),
      meta: { requiresAuth: true },
    },
    {
      path: '/orders',
      component: () => import('@/views/OrdersView.vue'),
      meta: { requiresAuth: true },
    },
  ],
})

router.beforeEach((to) => {
  const auth = useAuthStore()
  if (to.meta.requiresAuth && !auth.isAuthenticated) return '/login'
})

export default router
