<script setup lang="ts">
import { useAuthStore } from '@/stores/auth'
import { useRouter } from 'vue-router'

const auth = useAuthStore()
const router = useRouter()

async function handleLogout() {
  await auth.logout()
  router.push('/login')
}

const navItems = [
  { label: 'Dashboard', path: '/' },
  { label: 'Orders', path: '/orders' },
  { label: 'Inventory', path: '/inventory' },
  { label: 'BOM', path: '/inventory/bom' },
  { label: 'Products', path: '/products' },
  { label: 'Settings', path: '/settings' },
]
</script>

<template>
  <div class="flex h-screen bg-gray-100">
    <!-- Sidebar -->
    <aside class="w-64 bg-gray-900 text-white flex flex-col">
      <div class="px-6 py-5 text-xl font-bold tracking-wide border-b border-gray-700">
        Forge
      </div>
      <nav class="flex-1 px-4 py-4 space-y-1">
        <RouterLink
          v-for="item in navItems"
          :key="item.path"
          :to="item.path"
          class="block px-4 py-2 rounded-lg text-gray-300 hover:bg-gray-700 hover:text-white transition-colors"
          active-class="bg-gray-700 text-white"
          :exact="item.path === '/'"
        >
          {{ item.label }}
        </RouterLink>
      </nav>
      <div class="px-4 py-4 border-t border-gray-700">
        <p class="text-xs text-gray-400 mb-2">{{ auth.email }}</p>
        <button
          @click="handleLogout"
          class="w-full text-left px-4 py-2 text-sm text-gray-300 hover:text-white hover:bg-gray-700 rounded-lg transition-colors"
        >
          Log out
        </button>
      </div>
    </aside>

    <!-- Main content -->
    <div class="flex-1 flex flex-col overflow-hidden">
      <main class="flex-1 overflow-y-auto p-6">
        <RouterView />
      </main>
    </div>
  </div>
</template>
