import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  // Base/ruta principal del proyecto con React.
  base: process.env.NODE_ENV === 'production' ? '/clases-particulares' : '/'})
