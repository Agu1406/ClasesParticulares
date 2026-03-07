// Importamos todos los tipos (objetos) de lenguajes que hay.
import { languages } from "../data/languages";
// Importamos el componente que pinta los lenguajes dentro del grid.
import LanguageCard from "../components/LanguageCard";
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
        // Contenedor principal que devuelve la función.
        <div className="min-h-screen bg-lavender p-4 sm:p-6 md:p-8">
            {/* Contenedor con mensaje y descripción de bienvenida. */}
            <div className="container mx-auto">
                <h1 className="text-2xl sm:text-3xl md:text-4xl font-bold text-center m-6 md:m-8 text-evergreen">
                    Portal de clases particulares de Agustín
                </h1>
                <p className="text-center m-4 md:m-8 text-slate-grey text-base md:text-lg">
                    ¡Bienvenido! Elige el tema en el que estás interesado.
                </p>
                {/* Contenedor con grid layout para renderizar las tarjetas de lenguajes. */}
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-4 md:gap-6">
                    {
                        /**
                         * Recordemos que en languages lo que exportamos e importamos en este código es un Array con todos los lenguajes, por lo tanto, se puede recorrer con "map()" o con "foreach()"
                         * 
                         * Usamos el "id" unico de cada lenguaje como atributo/propiedad nativo de React "key" para que pueda identificar cada elemento de LanguageCard de foma unica, lo que realmente enviamos a LanguageCard (función) es el objeto de tipo "language" en el segundo argumento de la etiqueta.
                         */
                        languages.map((language) => (
                            <LanguageCard key={language.id} language={language} />
                        ))}
                </div>
            </div>
        </div>
    );
}

// Exporta la función para que sea importable/usable en otros sitios.
export default HomePage;