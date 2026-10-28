/**
 * Carga lecciones desde archivos .md en content/lessons.
 * Parsea frontmatter (YAML) y cuerpo en Markdown; resuelve PDF y URLs de ejercicios.
 *
 * @see content/lessons/ Estructura de archivos por lenguaje
 */

import { Buffer } from "buffer";
import matter from "gray-matter";

const scope = globalThis as unknown as { Buffer?: typeof Buffer };
if (typeof scope.Buffer === "undefined") {
    scope.Buffer = Buffer;
}
import type { Lesson } from "../types";
import type { LessonFrontmatter, LessonExerciseFrontmatter } from "./lessonFrontmatter";
import {
    javaDocUrl,
    javaUscDocUrl,
    javaExercisesTreeUrl,
} from "./javaRepo";

// Imports explícitos para que Vite incluya el contenido (el glob puede fallar en algunos entornos).
import java1 from "../content/lessons/java/java-1-conceptos-basicos.md?raw";
import java2 from "../content/lessons/java/java-2-sintaxis-basica.md?raw";
import java3 from "../content/lessons/java/java-3-comentarios.md?raw";
import java4 from "../content/lessons/java/java-4-tipos-datos.md?raw";
import java5 from "../content/lessons/java/java-5-casteo-tipos.md?raw";
import java6 from "../content/lessons/java/java-6-bucles.md?raw";
import java7 from "../content/lessons/java/java-7-condicionales.md?raw";
import java8 from "../content/lessons/java/java-8-strings-funciones.md?raw";
import java9 from "../content/lessons/java/java-9-operaciones-matematicas.md?raw";
import java10 from "../content/lessons/java/java-10-arrays.md?raw";
import java11 from "../content/lessons/java/java-11-poo-basica.md?raw";
import c1 from "../content/lessons/c/c-1-estructura-hola-mundo.md?raw";
import c2 from "../content/lessons/c/c-2-printf-compilacion.md?raw";
import c3 from "../content/lessons/c/c-3-tipos-variables.md?raw";
import c4 from "../content/lessons/c/c-4-operadores.md?raw";
import c5 from "../content/lessons/c/c-5-comentarios-entrada.md?raw";
import c6 from "../content/lessons/c/c-6-condicionales.md?raw";
import c7 from "../content/lessons/c/c-7-bucles.md?raw";

/** Cada import ?raw puede ser string o { default: string } según el entorno. */
function asRawString(value: unknown): string {
    if (typeof value === "string") return value;
    const mod = value as { default?: string };
    if (typeof mod?.default === "string") return mod.default;
    return "";
}

function parseSections(body: string, sectionIcons?: string[]): Lesson["content"]["sections"] {
    let trimmed = body.trim();
    if (!trimmed) return [];
    if (trimmed.startsWith("## ")) {
        trimmed = trimmed.slice(3);
    }

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
        fileUrl: ex.fileUrl ?? (ex.fileFolder ? javaExercisesTreeUrl(ex.fileFolder) : undefined),
        solutionUrl: ex.solutionUrl ?? (ex.solutionFolder ? javaExercisesTreeUrl(ex.solutionFolder) : undefined),
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
        level: fm.level,
        examNote: fm.examNote,
        sourcePath: fm.sourcePath,
        content: {
            sections,
            exercises: resolveExercises(fm.exercises),
            pdfUrl,
        },
    };
}

/** Lección 1 embebida por si los imports ?raw no devuelven contenido (fallback). */
const FALLBACK_JAVA_1 = `---
id: java-1
languageId: java
title: Conceptos básicos y ciclo de vida del programa
description: Java como lenguaje de alto nivel, orientado a objetos. JVM, JDK, JRE. Etapas del ciclo de vida.
part: 1
totalParts: 11
roadmapPhase: fundamentos
sectionIcons:
  - menu_book
exercises:
  - id: ex1
    title: Abre y ejecuta Ejemplo.java en src/ev1/ut0/ciclovida.
    completed: false
---

## Conceptos básicos

Java es un lenguaje de alto nivel, orientado a objetos.

## ¿Quién lee y ejecuta el código?

JVM, JDK, JRE.

## Etapas del ciclo de vida

Edición, compilación, carga, verificación, ejecución.`;

/**
 * Carga todas las lecciones desde los .md (imports ?raw).
 * Si ningún import devuelve contenido, usa una lección de respaldo.
 */
export function loadLessonsFromMarkdown(): Lesson[] {
    const lessons: Lesson[] = [];
    const sources = [
        java1, java2, java3, java4, java5, java6, java7, java8, java9, java10, java11,
        c1, c2, c3, c4, c5, c6, c7,
    ];

    for (let i = 0; i < sources.length; i++) {
        const raw = asRawString(sources[i]);
        if (!raw.trim()) continue;
        try {
            const lesson = mdToLesson("", raw);
            lessons.push(lesson);
        } catch (err) {
            console.warn(`[loadLessonsFromMarkdown] Error parsing lesson ${i + 1}:`, err);
        }
    }

    if (lessons.length === 0) {
        try {
            lessons.push(mdToLesson("", FALLBACK_JAVA_1));
        } catch {
            // ignore
        }
    }

    return lessons.sort((a, b) => a.languageId.localeCompare(b.languageId) || a.part - b.part);
}
