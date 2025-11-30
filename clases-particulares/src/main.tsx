import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'

/**
 * Punto de entrada principal de la aplicación React.
 * Este archivo es equivalente al método main() en Java.
 * Crea la raíz de React y renderiza la aplicación dentro de un elemento
 * del DOM con id "root". StrictMode ayuda a detectar problemas durante el desarrollo.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * 
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */
createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
