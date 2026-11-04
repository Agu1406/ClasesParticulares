/**
 * URLs del módulo C en GitHub para enlazar teoría y ejercicios desde el portal.
 *
 * @see c/README.md
 * @see c/src/ev1/README.md
 */

const GITHUB_REPO = "https://github.com/Agu1406/ClasesParticulares";
const BRANCH = "main";
const C_ROOT = "c";
const C_SRC = "c/src";

export const C_REPO_RAW_BASE = `${GITHUB_REPO.replace("github.com", "raw.githubusercontent.com")}/${BRANCH}/${C_SRC}`;
export const C_REPO_TREE_BASE = `${GITHUB_REPO}/tree/${BRANCH}/${C_SRC}`;

/** Carpeta de teoría o ejercicios bajo ev1 (ruta relativa a c/src/ev1). */
export function cEv1TreeUrl(relativePath: string): string {
    const clean = relativePath.replace(/^\/+/, "");
    return `${C_REPO_TREE_BASE}/ev1/${clean}`;
}

/** Test interactivo HTML en el repo (abrir en GitHub o clonar). */
export function cTestHtmlUrl(filename: string): string {
    return `${GITHUB_REPO}/blob/${BRANCH}/${C_ROOT}/tests/${encodeURIComponent(filename)}`;
}

/** Copia publicada en GitHub Pages (vite base /clases-particulares). */
export function cTestPublicUrl(): string {
    return "/clases-particulares/tests/c-ev1/test_ev1_hasta_bucles.html";
}
