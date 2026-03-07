/**
 * Grid reutilizable de lecciones. Muestra las tarjetas (LessonCard) de todas las
 * lecciones de un lenguaje en un layout responsive (1 col móvil, 2 tablet, 3 desktop).
 *
 * Se usa en las páginas índice de cada lenguaje (JavaPage, y en el futuro PythonPage, etc.)
 * para no repetir el mismo código. Si no hay lecciones, muestra un mensaje amigable.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */

import type { Lesson } from "../types";
import LessonCard from "./LessonCard";

/** Props: array de lecciones a mostrar en el grid. */
interface LessonsGridProps {
    lessons: Lesson[];
}

function LessonsGrid({ lessons }: LessonsGridProps) {
    if (lessons.length === 0) {
        return (
            <div className="text-center py-12">
                <p className="text-slate-grey">
                    No hay lecciones disponibles aún.
                </p>
            </div>
        );
    }

    return (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            {lessons.map((lesson) => (
                <LessonCard key={lesson.id} lesson={lesson} />
            ))}
        </div>
    );
}

export default LessonsGrid;
