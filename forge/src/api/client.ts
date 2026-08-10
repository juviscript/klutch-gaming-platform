import axios from 'axios'
import { useAuthStore } from '@/stores/auth'
import router from '@/router'

const client = axios.create({
  baseURL: import.meta.env.VITE_API_URL ?? 'http://localhost:8000',
})

// Attach access token to every request
client.interceptors.request.use((config) => {
  const auth = useAuthStore()
  if (auth.accessToken) {
    config.headers.Authorization = `Bearer ${auth.accessToken}`
  }
  return config
})

// On 401 — try to refresh, then retry the original request
client.interceptors.response.use(
  (response) => response,
  async (error) => {
    const original = error.config
    if (error.response?.status === 401 && !original._retry) {
      original._retry = true
      const auth = useAuthStore()
      const refreshed = await auth.refresh()
      if (refreshed) {
        original.headers.Authorization = `Bearer ${auth.accessToken}`
        return client(original)
      }
      router.push('/login')
    }
    return Promise.reject(error)
  },
)

export default client
