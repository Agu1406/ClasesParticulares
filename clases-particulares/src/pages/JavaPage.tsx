/**
 * Cuando esta función es invocada crea y muestra el código necesario para cargar la pagina principal (home) de esté proyecto SPA.
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