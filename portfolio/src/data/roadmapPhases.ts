/**
 * Fases de los roadmaps por lenguaje. Sirve para agrupar lecciones en una
 * ruta de aprendizaje alineada con roadmap.sh (https://roadmap.sh).
 *
 * Orden típico Java (roadmap.sh): Fundamentos → POO → Core Java (collections,
 * excepciones, I/O, concurrencia) → temas avanzados.
 *
 * @see https://roadmap.sh/java
 * @see https://roadmap.sh
 */

export interface RoadmapPhase {
    id: string;
    label: string;
    order: number;
}

/** Fases definidas para Java (alineadas con roadmap.sh). */
const JAVA_PHASES: RoadmapPhase[] = [
    { id: "fundamentos", label: "Fase 1: Fundamentos", order: 1 },
    { id: "poo", label: "Fase 2: Programación orientada a objetos", order: 2 },
    { id: "core", label: "Fase 3: Core Java", order: 3 },
];

const PHASES_BY_LANGUAGE: Record<string, RoadmapPhase[]> = {
    java: JAVA_PHASES,
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
export function getPhaseLabel(phaseId: string, _languageId?: string): string {
    const phase = JAVA_PHASES.find((p) => p.id === phaseId);
    return phase?.label ?? phaseId;
}
