/**
 * Página índice de Java. Muestra todas las lecciones disponibles de Java
 * en un grid reutilizable (LessonsGrid). Cada tarjeta (LessonCard) enlaza
 * a la página de la lección (/lesson/java-1, etc.). Los datos vienen de
 * getLessonsByLanguage("java") en data/lessons.ts.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */

import { getLessonsByLanguage } from "../data/lessons";
import LessonsGrid from "../components/LessonsGrid";

function JavaPage() {
    const javaLessons = getLessonsByLanguage("java");

    return (
        <div className="bg-lavender p-8">
            <div className="container mx-auto">
                <h1 className="text-4xl font-bold text-center m-8 text-evergreen">
                    Clases particulares de Java
                </h1>
                <p className="text-center m-8 text-slate-grey text-lg mb-12">
                    ¡Has elegido mi lenguaje favorito! Elige una lección para comenzar.
                </p>
                {/* Grid de lecciones: componente reutilizable para no duplicar código en otras páginas de lenguajes. */}
                <LessonsGrid lessons={javaLessons} />
            </div>
        </div>
    );
}

export default JavaPage;