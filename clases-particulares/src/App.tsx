// Importamos todos los componentes de react-router-dom
import { BrowserRouter, Routes, Route } from "react-router-dom";

/**
 * Las paginas que creamos (pages) son funciones invocables, desde
 * aquí debemos importarlas todas para tenerlas listas y que nuestra
 * aplicación (SPA) pueda llamarlas/invocarlas cuano sea necesario.
 */
import HomePage from "./pages/HomePage";
import JavaPage from "./pages/JavaPage";

/**
 * Componente principal de la aplicación que configura el routing.
 * 
 * Este componente es similar al método main() en Java.
 * En React, "main.tsx" es el punto de entrada (como main en Java),
 * y "App.tsx" contiene la lógica principal de la aplicación, en este caso
 * la configuración del sistema de rutas (routing).
 * 

 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * 
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */
function App () {
  return (
    // Activamos el enrutamiento (routing) de la aplicación.
    <BrowserRouter>
      {/* Dentro de BrowserRouter indicamos las rutas que existen.*/}
      <Routes>
        {/* Tenemos que definarlas una por una indicando la URL y que elemento tiene que carga la SPA si coincide con esa ruta, este primer ejemplo, si el usuario accede a la URL www.misitio.com/ entonces React carga el componente (page) llamado HomePage.tsx*/}
        <Route path="/" element={<HomePage />}></Route>
        {/* Ahora otro ejemplo, si la URL es "/java" carga el componente (page) JavaPage.tsx*/}
        <Route path="/java" element={<JavaPage />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

// Exportamos esta función para que "main.tsx" pueda utilizarla.
export default App;