import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'

const BASE_URL = import.meta.env.VITE_API_URL ?? 'http://localhost:8000'

export const useAuthStore = defineStore('auth', () => {
  const accessToken = ref<string | null>(localStorage.getItem('accessToken'))
  const refreshToken = ref<string | null>(localStorage.getItem('refreshToken'))
  const email = ref<string | null>(localStorage.getItem('email'))
  const role = ref<string | null>(localStorage.getItem('role'))

  const isAuthenticated = ref(!!accessToken.value)

  function setTokens(data: { accessToken: string; refreshToken: string; email: string; role: string }) {
    accessToken.value = data.accessToken
    refreshToken.value = data.refreshToken
    email.value = data.email
    role.value = data.role
    isAuthenticated.value = true
    localStorage.setItem('accessToken', data.accessToken)
    localStorage.setItem('refreshToken', data.refreshToken)
    localStorage.setItem('email', data.email)
    localStorage.setItem('role', data.role)
  }

  function clearTokens() {
    accessToken.value = null
    refreshToken.value = null
    email.value = null
    role.value = null
    isAuthenticated.value = false
    localStorage.removeItem('accessToken')
    localStorage.removeItem('refreshToken')
    localStorage.removeItem('email')
    localStorage.removeItem('role')
  }

  async function login(emailInput: string, password: string) {
    const { data } = await axios.post(`${BASE_URL}/api/auth/login`, { email: emailInput, password })
    setTokens(data)
  }

  async function refresh(): Promise<boolean> {
    if (!refreshToken.value) return false
    try {
      const { data } = await axios.post(`${BASE_URL}/api/auth/refresh`, { refreshToken: refreshToken.value })
      setTokens(data)
      return true
    } catch {
      clearTokens()
      return false
    }
  }

  async function logout() {
    if (refreshToken.value) {
      await axios.post(`${BASE_URL}/api/auth/logout`, { refreshToken: refreshToken.value }).catch(() => {})
    }
    clearTokens()
  }

  return { accessToken, refreshToken, email, role, isAuthenticated, login, refresh, logout }
})
