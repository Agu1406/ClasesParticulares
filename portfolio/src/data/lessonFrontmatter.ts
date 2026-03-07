/**
 * Tipos para el frontmatter de las lecciones en Markdown.
 * Los archivos .md usan YAML al inicio; aquí definimos la forma que espera el loader.
 */

export interface LessonExerciseFrontmatter {
    id: string;
    title: string;
    completed?: boolean;
    /** Carpeta en general/ para enlazar código (ej. "strings", "buclesycondicionales"). */
    fileFolder?: string;
    /** Subcarpeta para soluciones (ej. "strings/resueltos"). */
    solutionFolder?: string;
}

export interface LessonFrontmatter {
    id: string;
    languageId: string;
    title: string;
    description: string;
    part: number;
    totalParts: number;
    roadmapPhase?: string;
    /** Nombre del PDF en general/documentos (se resuelve a URL en el loader). */
    pdfFile?: string;
    /** Si "usc", el PDF se busca en galicia/santiagocompostela/usc. */
    pdfSource?: "general" | "usc";
    /** Iconos por sección, por orden (opcional). */
    sectionIcons?: string[];
    exercises: LessonExerciseFrontmatter[];
}
