/**
 * Página índice reutilizable para cualquier lenguaje. Se usa para /java, /python, /c, etc.
 *
 * Lee el ID del lenguaje desde la URL (useParams: languageId). Busca el lenguaje en
 * data/languages con getLanguageById y las lecciones con getLessonsByLanguage. Si el
 * lenguaje no existe, muestra "Lenguaje no encontrado" y enlace a inicio. Si existe,
 * muestra título "Clases particulares de {nombre}", descripción y LessonsGrid (que
 * mostrará "No hay lecciones disponibles" si aún no hay lecciones para ese lenguaje).
 *
 * Así no hace falta una página distinta por cada lenguaje (JavaPage, PythonPage, etc.).
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */

import { useParams, Link } from "react-router-dom";
import { getLanguageById } from "../data/languages";
import { getLessonsByLanguage } from "../data/lessons";
import LessonsGrid from "../components/LessonsGrid";
import RoadmapSection from "../components/RoadmapSection";

function LanguagePage() {
    const { languageId } = useParams<{ languageId: string }>();
    const language = languageId ? getLanguageById(languageId) : null;
    const lessons = languageId ? getLessonsByLanguage(languageId) : [];

    if (!language) {
        return (
            <div className="bg-lavender p-4 sm:p-6 md:p-8">
                <div className="container mx-auto text-center">
                    <h1 className="text-2xl font-bold text-evergreen mb-4">
                        Lenguaje no encontrado
                    </h1>
                    <Link to="/" className="text-fawn hover:underline">
                        Volver al inicio
                    </Link>
                </div>
            </div>
        );
    }

    return (
        <div className="bg-lavender p-4 sm:p-6 md:p-8">
            <div className="container mx-auto">
                <h1 className="text-2xl sm:text-3xl md:text-4xl font-bold text-center m-4 md:m-8 text-evergreen">
                    Clases particulares de {language.name}
                </h1>
                <p className="text-center m-4 md:m-8 text-slate-grey text-base md:text-lg mb-2">
                    {language.description}
                </p>
                {lessons.length > 0 && (
                    <p className="text-center text-slate-grey text-sm mb-8 md:mb-12">
                        {lessons.length} lección{lessons.length !== 1 ? "es" : ""} · de cero a nivel sólido
                    </p>
                )}
                {lessons.length === 0 && <div className="mb-8 md:mb-12" />}
                {/* Ruta de aprendizaje por fases (alineada con roadmap.sh) cuando exista. */}
                <RoadmapSection languageId={language.id} lessons={lessons} />
                <LessonsGrid lessons={lessons} />
            </div>
        </div>
    );
}

export default LanguagePage;
