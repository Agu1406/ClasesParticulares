/**
 * Fases de los roadmaps por lenguaje. Sirve para agrupar lecciones en una
 * ruta de aprendizaje.
 *
 * Java sigue la guía java/src/README.md (EV1 UT0): fundamentos → estructuras
 * (bucles, condicionales, strings, arrays) → conceptos básicos POO.
 *
 * @see java/src/README.md Guía "Notas y matices" del proyecto
 * @see https://roadmap.sh/java
 */

export interface RoadmapPhase {
    id: string;
    label: string;
    order: number;
}

/** Fases definidas para Java (siguen la guía java/src/README.md — EV1 UT0). */
const JAVA_PHASES: RoadmapPhase[] = [
    { id: "fundamentos", label: "EV1 UT0: Conceptos, sintaxis y tipos", order: 1 },
    { id: "estructuras", label: "EV1 UT0: Bucles, condicionales, strings y arrays", order: 2 },
    { id: "poo", label: "EV1: Conceptos básicos de la POO", order: 3 },
];

/** C, EV1, hasta bucles: el tramo del examen sorpresa. */
const C_PHASES: RoadmapPhase[] = [
    { id: "fundamentos", label: "UT1: programa, tipos y entrada", order: 1 },
    { id: "control", label: "UT2: operadores, condicionales y bucles", order: 2 },
];

const PHASES_BY_LANGUAGE: Record<string, RoadmapPhase[]> = {
    java: JAVA_PHASES,
    c: C_PHASES,
};

/**
 * Devuelve las fases del roadmap para un lenguaje, en orden.
 * Si el lenguaje no tiene fases definidas, devuelve [].
 */
export function getOrderedPhasesForLanguage(languageId: string): RoadmapPhase[] {
    return PHASES_BY_LANGUAGE[languageId] ?? [];
}

/**
 * Devuelve la etiqueta de una fase por su id y lenguaje (opcional).
 */
export function getPhaseLabel(phaseId: string, languageId?: string): string {
    const phases = languageId ? getOrderedPhasesForLanguage(languageId) : JAVA_PHASES;
    const phase = phases.find((p) => p.id === phaseId);
    return phase?.label ?? phaseId;
}
