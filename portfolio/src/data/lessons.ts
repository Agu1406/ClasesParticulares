/**
 * Datos de todas las lecciones disponibles por lenguaje.
 *
 * Las lecciones se cargan desde archivos Markdown en content/lessons/ (frontmatter + cuerpo).
 * Ver loadLessonsFromMarkdown.ts y content/lessons/java/*.md.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see java/src/README.md Guía de Java del proyecto
 */

import type { Lesson } from "../types";
import { loadLessonsFromMarkdown } from "./loadLessonsFromMarkdown";

/** Listado de todas las lecciones (cargadas desde .md en content/lessons). */
export const lessons: Lesson[] = loadLessonsFromMarkdown();

/**
 * Obtiene todas las lecciones de un lenguaje dado.
 */
export function getLessonsByLanguage(languageId: string): Lesson[] {
    return lessons
        .filter((lesson) => lesson.languageId === languageId)
        .sort((a, b) => a.part - b.part);
}

/**
 * Obtiene una lección por su ID.
 */
export function getLessonById(lessonId: string): Lesson | undefined {
    return lessons.find((lesson) => lesson.id === lessonId);
}
