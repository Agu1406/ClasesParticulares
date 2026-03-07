/**
 * Tarjeta que muestra una lección dentro del grid de lecciones (LessonsGrid).
 *
 * Es un enlace (Link) a la página de la lección (/lesson/:lessonId). Muestra el número
 * de parte (part/totalParts), título y descripción. Reutilizable para cualquier lenguaje
 * que use LessonsGrid (Java, Python, etc.).
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */

import { Link } from "react-router-dom";
import type { Lesson } from "../types";

/** Props del componente: recibe una única lección para renderizar. */
interface LessonCardProps {
    lesson: Lesson;
}

function LessonCard({ lesson }: LessonCardProps) {
    return (
        <Link
            to={`/lesson/${lesson.id}`}
            className="block bg-white rounded-lg shadow-md p-6 hover:shadow-xl transition-all duration-300 border border-gray-200 hover:border-evergreen group"
        >
            {/* Número de lección y título */}
            <div className="flex items-center gap-4 mb-4">
                <div className="w-12 h-12 bg-evergreen/10 rounded-lg flex items-center justify-center text-2xl font-bold text-evergreen">
                    {lesson.part}
                </div>
                <div>
                    <span className="text-xs font-bold uppercase tracking-wider text-scarlet">
                        Part {lesson.part} of {lesson.totalParts}
                    </span>
                    <h3 className="text-xl font-bold text-evergreen mt-1">
                        {lesson.title}
                    </h3>
                </div>
            </div>
            {/* Descripción corta de la lección */}
            <p className="text-slate-grey text-sm">{lesson.description}</p>
        </Link>
    );
}

export default LessonCard;
