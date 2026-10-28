/**
 * Lecciones del portal cargadas desde content/lessons (Markdown).
 *
 * @see content/lessons/README.md
 * @see loadLessonsFromMarkdown.ts
 */

import type { Lesson } from "../types";
import { loadLessonsFromMarkdown } from "./loadLessonsFromMarkdown";

export const lessons: Lesson[] = loadLessonsFromMarkdown();

export function getLessonsByLanguage(languageId: string): Lesson[] {
    return lessons
        .filter((lesson) => lesson.languageId === languageId)
        .sort((a, b) => a.part - b.part);
}

export function getLessonById(lessonId: string): Lesson | undefined {
    return lessons.find((lesson) => lesson.id === lessonId);
}
