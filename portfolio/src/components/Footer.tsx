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
        <footer className="bg-evergreen text-lavender mt-auto py-6">
            <div className="container mx-auto px-4">
                <div className="flex flex-col md:flex-row justify-between items-center">
                    {/* Información de copyright */}
                    <div className="mb-4 md:mb-0">
                        <p className="text-sm">
                            © 2025 Portal de Clases Particulares de Agustín
                        </p>
                        <p className="text-xs text-lavender/80 mt-1">
                            Material educativo y ejercicios de programación
                        </p>
                    </div>
                    
                    {/* Enlaces externos */}
                    <div className="flex flex-col md:flex-row space-y-2 md:space-y-0 md:space-x-6 items-center">
                        <a 
                            href="https://github.com/Agu1406/ClasesParticulares" 
                            target="_blank" 
                            rel="noopener noreferrer"
                            className="text-sm hover:text-fawn transition-colors"
                        >
                            GitHub
                        </a>
                        <a 
                            href="https://agu1406.github.io/ClasesParticulares" 
                            target="_blank" 
                            rel="noopener noreferrer"
                            className="text-sm hover:text-fawn transition-colors"
                        >
                            GitHub Pages
                        </a>
                    </div>
                </div>
                
                {/* Créditos técnicos (opcional) */}
                <div className="mt-4 pt-4 border-t border-lavender/20 text-center">
                    <p className="text-xs text-lavender/70">
                        Desarrollado con React, TypeScript y Tailwind CSS
                    </p>
                </div>
            </div>
        </footer>
    );
}
// Exportamos la función para que pueda ser importada y usada.
export default Footer;