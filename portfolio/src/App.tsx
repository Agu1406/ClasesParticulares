// Importamos todos los componentes de react-router-dom
import { BrowserRouter, Routes, Route } from "react-router-dom";

/**
 * Las paginas que creamos (pages) son funciones invocables, desde
 * aquí debemos importarlas todas para tenerlas listas y que nuestra
 * aplicación (SPA) pueda llamarlas/invocarlas cuano sea necesario.
 */
import HomePage from "./pages/HomePage";
import LessonPage from "./pages/LessonPage";
import LanguagePage from "./pages/LanguagePage";
import Header from "./components/Header";
import Footer from "./components/Footer";
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
function App() {
  return (
    // Activamos el enrutamiento (routing) de la aplicación.
    <BrowserRouter>
      {/* Aquí se carga y renderiza el Header.tsx */}
      <Header />
      {/* Usamos la etiquita HTML main para mejorar el SEO. */}
      <main className="flex-grow">
      {/* Dentro de BrowserRouter indicamos las rutas que existen.*/}
      <Routes>
        {/* Ruta raíz: página de inicio con grid de lenguajes. */}
        <Route path="/" element={<HomePage />} />
        {/* Ruta dinámica para lecciones: /lesson/java-1, /lesson/java-2, etc. */}
        <Route path="/lesson/:lessonId" element={<LessonPage />} />
        {/* Ruta dinámica por lenguaje: /java, /python, /c, etc. Una sola LanguagePage para todos. */}
        <Route path="/:languageId" element={<LanguagePage />} />
      </Routes>
      </main>
      {/* Aquí se carga y renderiza Footer.tsx */}
      <Footer />
    </BrowserRouter>
  );
}

// Exportamos esta función para que "main.tsx" pueda utilizarla.
export default App;