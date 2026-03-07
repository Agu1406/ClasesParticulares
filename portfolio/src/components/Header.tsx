import { useState } from "react";
import { Link } from "react-router-dom";

/**
 * Barra de navegación de la SPA. En escritorio muestra enlaces en horizontal;
 * en móvil muestra un menú hamburguesa que abre/cierra un panel con los enlaces.
 * Usa React Router DOM (Link) para navegar sin recargar. El menú móvil se cierra
 * al hacer clic en un enlace o en el botón de cerrar.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */
function Header() {
    const [isMenuOpen, setIsMenuOpen] = useState(false);

    const closeMenu = () => setIsMenuOpen(false);

    return (
        <header>
            <nav className="bg-evergreen text-lavender shadow-md relative">
                <div className="container mx-auto flex justify-between items-center px-4 py-3">
                    {/* Logo: siempre visible */}
                    <Link
                        to="/"
                        className="text-lg md:text-xl font-bold hover:text-fawn transition-colors"
                        onClick={closeMenu}
                    >
                        Clases Particulares
                    </Link>

                    {/* Enlaces para escritorio: ocultos en móvil */}
                    <div className="hidden md:flex md:items-center md:space-x-4">
                        <Link to="/" className="hover:text-fawn transition-colors">
                            Inicio
                        </Link>
                        <Link to="/java" className="hover:text-fawn transition-colors">
                            Java
                        </Link>
                        <Link to="/php" className="hover:text-fawn transition-colors">
                            PHP
                        </Link>
                    </div>

                    {/* Botón hamburguesa: solo en móvil */}
                    <button
                        type="button"
                        onClick={() => setIsMenuOpen((prev) => !prev)}
                        className="md:hidden p-2 rounded-lg hover:bg-evergreen-light focus:outline-none focus:ring-2 focus:ring-fawn"
                        aria-expanded={isMenuOpen}
                        aria-label={isMenuOpen ? "Cerrar menú" : "Abrir menú"}
                    >
                        <span className="material-icons text-2xl">
                            {isMenuOpen ? "close" : "menu"}
                        </span>
                    </button>
                </div>

                {/* Panel del menú móvil: se despliega debajo de la barra */}
                <div
                    className={`md:hidden absolute top-full left-0 right-0 bg-evergreen border-t border-lavender/20 shadow-lg ${
                        isMenuOpen ? "block" : "hidden"
                    }`}
                >
                    <div className="container mx-auto px-4 py-4 flex flex-col gap-1">
                        <Link
                            to="/"
                            className="py-3 px-4 rounded-lg hover:bg-evergreen-light hover:text-fawn transition-colors"
                            onClick={closeMenu}
                        >
                            Inicio
                        </Link>
                        <Link
                            to="/java"
                            className="py-3 px-4 rounded-lg hover:bg-evergreen-light hover:text-fawn transition-colors"
                            onClick={closeMenu}
                        >
                            Java
                        </Link>
                        <Link
                            to="/php"
                            className="py-3 px-4 rounded-lg hover:bg-evergreen-light hover:text-fawn transition-colors"
                            onClick={closeMenu}
                        >
                            PHP
                        </Link>
                    </div>
                </div>
            </nav>
        </header>
    );
}

export default Header;
