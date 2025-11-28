/**
 * Cuando esta función es invocada crea y muestra el código
 * necesario para cargar la pagina principal (home) de esté
 * proyecto SPA.
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