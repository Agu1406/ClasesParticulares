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
function Navigation() {
    return (
        <nav className="bg-evergreen text-lavender p-4 shadow-md">
            <div className="container mx-auto flex justify-between items-center">
                <a href="/" className="text-xl font-bold hover:text-fawn transition-colors">
                    Clases Particulares
                </a>
                <div className="space-x-4">
                    <a href="/" className="hover:text-fawn transition-colors">Inicio</a>
                    <a href="/java" className="hover:text-fawn transition-colors">Java</a>
                    <a href="/php" className="hover:text-fawn transition-colors">PHP</a>
                </div>
            </div>
        </nav>
    );
}

export default Navigation;