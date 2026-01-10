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
 */
function Footer() {
    return (
        <footer className="bg-evergreen text-lavender p-4">
            <div className="container mx-auto text-center font-bold">
                 {/* Diseño pensado primero en movil y a partir de tamaños medianos ("md") en escritorio. */}
                <div className="flex flex-col md:flex-row justify-between items-center">
                    <p>© 2025 - Portal de clases particulares</p>
                    <div className="flex space-x-6">
                        <a href="https://github.com/Agu1406/ClasesParticulares" target="_blank">GitHub</a>
                        <a href="https://agu1406.github.io/ClasesParticulares" target="_blank">GitHub Pages</a>
                        <a href="https://www.linkedin.com/in/agustin6041/" target="_blank">LinkedIn</a>
                    </div>
                </div>
            </div>
        </footer>
    );
}

// Exportamos la función para que pueda ser importada y usada.
export default Footer;