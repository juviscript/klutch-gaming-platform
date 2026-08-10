import { createRouter, createWebHistory } from 'vue-router'
import { useAuthStore } from '@/stores/auth'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/login',
      component: () => import('@/views/LoginView.vue'),
    },
    {
      path: '/',
      component: () => import('@/layouts/ForgeLayout.vue'),
      meta: { requiresAdmin: true },
      children: [
        { path: '', component: () => import('@/views/DashboardView.vue') },
        { path: 'orders', component: () => import('@/views/OrdersView.vue') },
        { path: 'orders/:id', component: () => import('@/views/OrderDetailView.vue') },
        { path: 'inventory', component: () => import('@/views/InventoryView.vue') },
        { path: 'inventory/bom', component: () => import('@/views/BomView.vue') },
        { path: 'products', component: () => import('@/views/ProductsView.vue') },
        { path: 'settings', component: () => import('@/views/SettingsView.vue') },
      ],
    },
  ],
})

router.beforeEach((to) => {
  const auth = useAuthStore()
  if (to.meta.requiresAdmin) {
    if (!auth.isAuthenticated) return '/login'
    if (auth.role !== 'ADMIN' && auth.role !== 'SUPER_ADMIN') return '/login'
  }
})

export default router
