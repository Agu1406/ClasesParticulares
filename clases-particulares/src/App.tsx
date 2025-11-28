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
 * En java normalmente declaramos la clase y luego el main, ejemplo:
 * 
 * public class Ejemplo {
 *    public static void main (String[] args) {
 *        ... código ...
 *    }
 * }
 * 
 * En React pasa algo similar, hay un archivo llamado "main.tsx" donde todo converge y es el punto de entrada principal de la aplicación, "App.tsx" es utilizado por "main.tsx" para configurar/ejecutar código, en este caso, para activar y usar el redireccionamiento de forma activa.
 * 
 * La logica la maneja "App.tsx" y "main.tsx" le utiliza para mostrar el contenido al usuario final basandose en esa logica.
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