/**
 * Carga lecciones desde archivos .md en content/lessons.
 * Parsea frontmatter (YAML) y cuerpo en Markdown; resuelve PDF y URLs de ejercicios.
 *
 * @see content/lessons/ Estructura de archivos por lenguaje
 */

import matter from "gray-matter";
import type { Lesson } from "../types";
import type { LessonFrontmatter, LessonExerciseFrontmatter } from "./lessonFrontmatter";
import {
    javaDocUrl,
    javaUscDocUrl,
    javaExercisesTreeUrl,
} from "./javaRepo";

/** En Vite, glob con ?raw y eager devuelve Record<path, string>. */
const mdModules = import.meta.glob<string>(
    "../content/lessons/**/*.md",
    { query: "?raw", eager: true, import: "default" }
);

function parseSections(body: string, sectionIcons?: string[]): Lesson["content"]["sections"] {
    const trimmed = body.trim();
    if (!trimmed) return [];

    const parts = trimmed.split(/\n## /);
    return parts
        .filter((block) => block.trim().length > 0)
        .map((block, i) => {
            const firstNewLine = block.indexOf("\n");
            const title = firstNewLine >= 0
                ? block.slice(0, firstNewLine).trim()
                : block.trim();
            const content = firstNewLine >= 0
                ? block.slice(firstNewLine + 1).trim()
                : "";
            return {
                title,
                content,
                icon: sectionIcons?.[i],
            };
        });
}

function resolveExercises(
    exercises: LessonExerciseFrontmatter[]
): Lesson["content"]["exercises"] {
    return exercises.map((ex) => ({
        id: ex.id,
        title: ex.title,
        completed: ex.completed ?? false,
        fileUrl: ex.fileFolder ? javaExercisesTreeUrl(ex.fileFolder) : undefined,
        solutionUrl: ex.solutionFolder ? javaExercisesTreeUrl(ex.solutionFolder) : undefined,
    }));
}

function mdToLesson(_path: string, raw: string): Lesson {
    const { data, content } = matter(raw);
    const fm = data as LessonFrontmatter;

    const sections = parseSections(content, fm.sectionIcons).map((s) => ({
        title: s.title,
        icon: s.icon,
        content: s.content,
    }));

    let pdfUrl: string | undefined;
    if (fm.pdfFile) {
        pdfUrl = fm.pdfSource === "usc"
            ? javaUscDocUrl(fm.pdfFile)
            : javaDocUrl(fm.pdfFile);
    }

    return {
        id: fm.id,
        languageId: fm.languageId,
        title: fm.title,
        description: fm.description,
        part: fm.part,
        totalParts: fm.totalParts,
        roadmapPhase: fm.roadmapPhase,
        content: {
            sections,
            exercises: resolveExercises(fm.exercises),
            pdfUrl,
        },
    };
}

/**
 * Carga todas las lecciones desde los .md encontrados por el glob.
 * Ordenadas por part para que el orden sea estable.
 */
export function loadLessonsFromMarkdown(): Lesson[] {
    const lessons: Lesson[] = [];

    for (const [filePath, raw] of Object.entries(mdModules)) {
        if (typeof raw !== "string") continue;
        try {
            const lesson = mdToLesson(filePath, raw);
            lessons.push(lesson);
        } catch (err) {
            console.warn(`[loadLessonsFromMarkdown] Error parsing ${filePath}:`, err);
        }
    }

    return lessons.sort((a, b) => a.part - b.part);
}
