// Primera fase de aprendizaje, "inicio rapido" del sitio oficial de REACT.
import MyApp from "./components/inicio-rapido/10-inicio-rapido-completo/MyApp"
// Segunda fase de aprendizaje, "tres en linea" del sitio oficial de REACT.
import Square from "./components/tres-en-linea/Square"

// Estilos globales de la app.
import "./App.css"

// Importar el fondo de Vanta.
import VantaBackground from "./components/VantaBackground"

/**
 * Punto de entrada visual: inicio rápido completo (lección 10: textos + componentes 01–09).
 */
export default function App() {
  return (
    <div className="app">
      <VantaBackground />
      <main className="main">
        <h1 className='lesson'>Aprendiendo REACT</h1>
        <h2 className='lesson'>Inicio rapido</h2>
        <MyApp />
        <h2 className='lesson'>Tres en linea</h2>
        <Square />
      </main>
    </div>
  )
}
