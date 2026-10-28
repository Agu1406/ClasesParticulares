import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'
import path from 'node:path'
import { fileURLToPath } from 'node:url'

const rootDir = path.dirname(fileURLToPath(import.meta.url))

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  // El banco de preguntas vive en /tests, fuera de esta carpeta.
  server: {
    fs: {
      allow: [path.resolve(rootDir, '..')],
    },
  },
  // Base/ruta principal del proyecto con React.
  base: process.env.NODE_ENV === 'production' ? '/clases-particulares' : '/',
})
