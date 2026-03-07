/**
 * URLs base del repositorio de Java (clases-particulares/java) para enlazar
 * documentos PDF y ejercicios (código sin resolver y resueltos) desde el portal.
 *
 * Se usan en lessons.ts para pdfUrl y en exercises con fileUrl/solutionUrl.
 * Repo esperado: https://github.com/Agu1406/ClasesParticulares (rama main).
 *
 * @see java/README.md Estructura del proyecto Java
 */

const GITHUB_REPO = "https://github.com/Agu1406/ClasesParticulares";
const BRANCH = "main";
const JAVA_SRC = "java/src";

/** Base para descargar archivos (PDF, etc.) en crudo. */
export const JAVA_REPO_RAW_BASE = `${GITHUB_REPO.replace("github.com", "raw.githubusercontent.com")}/${BRANCH}/${JAVA_SRC}`;

/** Base para ver carpetas en GitHub (navegación). */
export const JAVA_REPO_TREE_BASE = `${GITHUB_REPO}/tree/${BRANCH}/${JAVA_SRC}`;

/**
 * Devuelve la URL para descargar un documento (PDF) desde general/documentos.
 */
export function javaDocUrl(filename: string): string {
    return `${JAVA_REPO_RAW_BASE}/general/documentos/${encodeURIComponent(filename)}`;
}

/**
 * Devuelve la URL para descargar un PDF desde galicia/santiagocompostela/usc (teoría USC).
 */
export function javaUscDocUrl(filename: string): string {
    return `${JAVA_REPO_RAW_BASE}/galicia/santiagocompostela/usc/${encodeURIComponent(filename)}`;
}

/**
 * Devuelve la URL de la carpeta de ejercicios en GitHub (tree).
 * folder puede ser "strings", "arrays", "strings/resueltos", etc.
 */
export function javaExercisesTreeUrl(folder: string): string {
    return `${JAVA_REPO_TREE_BASE}/general/${folder}`;
}
