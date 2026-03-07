/**
 * Página reutilizable que muestra el contenido de una lección concreta.
 *
 * La ruta es /lesson/:lessonId (ej: /lesson/java-1). Obtiene la lección con getLessonById.
 * Si no existe, muestra mensaje "Lección no encontrada" y enlace para volver. Si existe,
 * muestra: cabecera (parte/total, título, descripción), barra de progreso, secciones
 * de teoría con CodeBlock cuando haya código, lista de ejercicios y enlace al PDF si existe.
 * Incluye navegación "Volver" al índice del lenguaje y "Siguiente lección" cuando aplique.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */

import { useParams, Link } from "react-router-dom";
import { getLessonById, getLessonsByLanguage } from "../data/lessons";
import CodeBlock from "../components/CodeBlock";

function LessonPage() {
    const { lessonId } = useParams<{ lessonId: string }>();
    const lesson = lessonId ? getLessonById(lessonId) : null;

    if (!lesson) {
        const backLanguageId = lessonId?.includes("-") ? lessonId.split("-")[0] : "java";
        return (
            <div className="bg-lavender p-4 sm:p-6 md:p-8">
                <div className="container mx-auto text-center">
                    <h1 className="text-2xl font-bold text-evergreen mb-4">
                        Lección no encontrada
                    </h1>
                    <Link to={`/${backLanguageId}`} className="text-fawn hover:underline">
                        Volver a las lecciones
                    </Link>
                </div>
            </div>
        );
    }

    const languageLessons = getLessonsByLanguage(lesson.languageId);
    const nextLesson = languageLessons.find((l) => l.part === lesson.part + 1);

    return (
        <div className="bg-lavender p-4 sm:p-6 md:p-8">
            <div className="container mx-auto max-w-3xl">
                {/* Cabecera: parte/total, título, descripción */}
                <div className="mb-6 md:mb-8">
                    <span className="text-xs font-bold uppercase tracking-wider text-scarlet">
                        Part {lesson.part} of {lesson.totalParts}
                    </span>
                    <h1 className="text-2xl sm:text-3xl font-bold text-evergreen mt-2">
                        {lesson.title}
                    </h1>
                    <p className="text-slate-grey mt-4 leading-relaxed">
                        {lesson.description}
                    </p>
                </div>

                {/* Barra de progreso (segmentos por cada parte) */}
                <div className="flex gap-2 mb-8">
                    {Array.from({ length: lesson.totalParts }).map((_, i) => (
                        <div
                            key={i}
                            className={`h-1.5 flex-1 rounded-full ${
                                i < lesson.part ? "bg-evergreen" : "bg-slate-200"
                            }`}
                        />
                    ))}
                </div>

                {/* Secciones de teoría y código */}
                <div className="space-y-8">
                    {lesson.content.sections.map((section, index) => (
                        <section key={index} className="space-y-4">
                            <h2 className="text-xl font-bold flex items-center gap-2 text-evergreen">
                                {section.icon && (
                                    <span className="material-icons text-scarlet">
                                        {section.icon}
                                    </span>
                                )}
                                {section.title}
                            </h2>
                            <p className="text-slate-grey text-sm">
                                {section.content}
                            </p>
                            {section.code && (
                                <CodeBlock
                                    code={section.code}
                                    language={section.codeLanguage ?? "java"}
                                />
                            )}
                        </section>
                    ))}
                </div>

                {/* Bloque de ejercicios y PDF */}
                <section className="bg-evergreen/5 p-4 sm:p-6 rounded-3xl border border-evergreen/10 mt-6 md:mt-8">
                    <h2 className="text-xl font-bold mb-4">
                        Ejercicios de la lección
                    </h2>
                    <div className="space-y-3">
                        {lesson.content.exercises.map((exercise) => (
                            <div
                                key={exercise.id}
                                className="flex flex-col gap-2 bg-white/50 p-3 rounded-xl"
                            >
                                <div className="flex items-start gap-3">
                                    <span
                                        className={`material-icons text-sm mt-1 shrink-0 ${
                                            exercise.completed
                                                ? "text-green-500"
                                                : "text-slate-300"
                                        }`}
                                    >
                                        {exercise.completed
                                            ? "check_circle"
                                            : "radio_button_unchecked"}
                                    </span>
                                    <p className="text-sm">{exercise.title}</p>
                                </div>
                                {(exercise.fileUrl || exercise.solutionUrl) && (
                                    <div className="flex flex-wrap gap-2 pl-8">
                                        {exercise.fileUrl && (
                                            <a
                                                href={exercise.fileUrl}
                                                target="_blank"
                                                rel="noopener noreferrer"
                                                className="inline-flex items-center gap-1 text-xs font-medium text-evergreen hover:text-fawn hover:underline"
                                            >
                                                <span className="material-icons text-sm">
                                                    code
                                                </span>
                                                Ver código en el repositorio
                                            </a>
                                        )}
                                        {exercise.solutionUrl && (
                                            <a
                                                href={exercise.solutionUrl}
                                                target="_blank"
                                                rel="noopener noreferrer"
                                                className="inline-flex items-center gap-1 text-xs font-medium text-evergreen hover:text-fawn hover:underline"
                                            >
                                                <span className="material-icons text-sm">
                                                    check_circle
                                                </span>
                                                Ver solución resuelta
                                            </a>
                                        )}
                                    </div>
                                )}
                            </div>
                        ))}
                    </div>
                    {lesson.content.pdfUrl && (
                        <a
                            href={lesson.content.pdfUrl}
                            target="_blank"
                            rel="noopener noreferrer"
                            className="flex items-center justify-between w-full bg-evergreen text-lavender py-4 px-6 rounded-2xl font-semibold shadow-lg hover:bg-evergreen-dark transition-colors mt-4"
                        >
                            <div className="flex items-center gap-3">
                                <span className="material-icons">
                                    picture_as_pdf
                                </span>
                                <span>Descargar ejercicios en PDF</span>
                            </div>
                            <span className="material-icons">download</span>
                        </a>
                    )}
                </section>

                {/* Navegación: Volver al índice y Siguiente lección */}
                <footer className="pt-10 pb-4">
                    <div className="flex justify-between items-center bg-white p-2 rounded-2xl shadow-lg">
                        <Link
                            to={`/${lesson.languageId}`}
                            className="flex-1 py-3 px-4 rounded-xl text-slate-500 font-medium text-center"
                        >
                            Volver
                        </Link>
                        <div className="w-[1px] h-6 bg-slate-200" />
                        {nextLesson ? (
                            <Link
                                to={`/lesson/${nextLesson.id}`}
                                className="flex-1 py-3 px-4 rounded-xl bg-evergreen text-lavender font-bold text-center"
                            >
                                Siguiente lección
                            </Link>
                        ) : (
                            <span className="flex-1 py-3 px-4 rounded-xl text-slate-400 text-center text-sm">
                                Última lección
                            </span>
                        )}
                    </div>
                </footer>
            </div>
        </div>
    );
}

export default LessonPage;
