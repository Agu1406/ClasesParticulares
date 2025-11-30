/**
 * Componente de la página principal (Home) de la aplicación.
 * Renderiza la página de inicio donde los usuarios pueden
 * seleccionar el lenguaje o framework del cual quieren ver ejercicios
 * y material educativo.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * 
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */
function HomePage() {
    // La función invocada devuelve código cargable/leible.
    return (
        <div className="min-h-screen p-8">
            <h1 className="text-4xl font-bold text-center m-8">
                Portal de clases particulares de Agustín
            </h1>
            <p className="text-center m-8">
                ¡Bienvenido! Elige el tema en el que estás interesado.
            </p>
        </div>
    );
}

export default HomePage;