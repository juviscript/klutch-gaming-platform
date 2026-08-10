/** @type {import('tailwindcss').Config} */
export default {
  content: ['./src/**/*.{html,ts}'],
  theme: {
    extend: {
      colors: {
        brand: {
          purple: '#7C3AED',
          'purple-dark': '#5B21B6',
          blue: '#3B82F6',
        },
      },
    },
  },
  plugins: [],
}
