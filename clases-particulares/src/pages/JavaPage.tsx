/**
 * Componente de la página dedicada a Java.
 * Renderiza la página específica para el contenido de Java,
 * incluyendo ejercicios, proyectos y material educativo relacionado.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * 
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */
function JavaPage() {
    // La función invocada devuelve código cargable/leible.
    return (
        <div className="min-h-screen p-8">
            <h1 className="text-4xl font-bold text-center m-8">
                Clases particulares de Java y contenido
            </h1>
            <p className="text-center m-8">
                ¡Has elegido mi lenguaje favorito! Ahora, sientete libre de explorar el contenido disponible.
            </p>
        </div>
    );
}

export default JavaPage;