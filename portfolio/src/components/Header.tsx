import { Link } from "react-router-dom";

/**
 * Componente de navegación que proporciona una barra de navegación
 * para la aplicación SPA. Este componente utiliza React Router DOM para crear
 * enlaces de navegación que cambian la URL sin recargar la página completa.
 * Es similar a una barra de navegación tradicional pero optimizada para SPAs.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * 
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 * 
 * Podras notar que algunas clases que usado aquí no existen en tailwind, ejemplo:
 * - bg-evergreen
 * - text-lavender
 * - text-fawn
 * 
 * Como tal, las clases existen, pero los colores ("evergreen", "lavender", "fawn")
 * son los colores personalizados que he definido en "tailwind.config.js"
 */
function Header() {
    return (
        <header>
            <nav className="bg-evergreen text-lavender p-4 shadow-md">
                <div className="container mx-auto flex justify-between items-center">
                    <Link to="/" className="text-xl font-bold hover:text-fawn transition-colors">
                        Clases Particulares
                    </Link>
                    <div className="space-x-4">
                        <Link to="/" className="hover:text-fawn transition-colors">Inicio</Link>
                        <Link to="/java" className="hover:text-fawn transition-colors">Java</Link>
                        <Link to="/php" className="hover:text-fawn transition-colors">PHP</Link>
                    </div>
                </div>
            </nav>
        </header>
    );
}

// Exportamos la función para que pueda ser importada y usada.
export default Header;