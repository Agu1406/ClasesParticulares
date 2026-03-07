/**
 * Muestra la ruta de aprendizaje por fases (alineada con roadmap.sh).
 * Agrupa las lecciones por roadmapPhase y las muestra en el orden definido
 * en data/roadmapPhases. Solo se renderiza si el lenguaje tiene fases y
 * hay al menos una lección con roadmapPhase.
 *
 * Incluye un enlace a roadmap.sh para que el usuario pueda consultar el
 * roadmap completo del lenguaje.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://roadmap.sh
 */

import { Link } from "react-router-dom";
import type { Lesson } from "../types";
import { getOrderedPhasesForLanguage } from "../data/roadmapPhases";

const ROADMAP_SH_URL: Record<string, string> = {
    java: "https://roadmap.sh/java",
    python: "https://roadmap.sh/python",
    javascript: "https://roadmap.sh/javascript",
    "react-native": "https://roadmap.sh/react-native",
    typescript: "https://roadmap.sh/typescript",
    php: "https://roadmap.sh/php",
    cpp: "https://roadmap.sh/cpp",
    kotlin: "https://roadmap.sh/kotlin",
    sql: "https://roadmap.sh/sql",
};

interface RoadmapSectionProps {
    languageId: string;
    lessons: Lesson[];
}

function RoadmapSection({ languageId, lessons }: RoadmapSectionProps) {
    const phases = getOrderedPhasesForLanguage(languageId);
    const lessonsWithPhase = lessons.filter((l) => l.roadmapPhase);

    if (phases.length === 0 || lessonsWithPhase.length === 0) {
        return null;
    }

    const lessonsByPhase = phases.map((phase) => ({
        phase,
        lessons: lessonsWithPhase
            .filter((l) => l.roadmapPhase === phase.id)
            .sort((a, b) => a.part - b.part),
    }));

    const roadmapUrl = ROADMAP_SH_URL[languageId];

    return (
        <section className="mb-10">
            <div className="bg-evergreen/5 border border-evergreen/10 rounded-2xl p-6">
                <h2 className="text-xl font-bold text-evergreen mb-2">
                    Ruta de aprendizaje
                </h2>
                <p className="text-slate-grey text-sm mb-4">
                    El orden de las lecciones sigue una estructura inspirada en{" "}
                    <a
                        href="https://roadmap.sh"
                        target="_blank"
                        rel="noopener noreferrer"
                        className="text-evergreen underline hover:text-fawn"
                    >
                        roadmap.sh
                    </a>
                    , de cero hasta nivel sólido. Sigue las fases en orden.
                </p>
                {roadmapUrl && (
                    <a
                        href={roadmapUrl}
                        target="_blank"
                        rel="noopener noreferrer"
                        className="inline-flex items-center gap-1 text-sm text-evergreen font-medium hover:text-fawn mb-6"
                    >
                        Ver roadmap completo en roadmap.sh
                        <span className="material-icons text-base">open_in_new</span>
                    </a>
                )}
                <div className="space-y-6">
                    {lessonsByPhase.map(
                        ({ phase, lessons: phaseLessons }) =>
                            phaseLessons.length > 0 && (
                                <div key={phase.id}>
                                    <h3 className="text-sm font-bold uppercase tracking-wider text-scarlet mb-2">
                                        {phase.label}
                                    </h3>
                                    <ul className="space-y-1">
                                        {phaseLessons.map((lesson) => (
                                            <li key={lesson.id}>
                                                <Link
                                                    to={`/lesson/${lesson.id}`}
                                                    className="text-evergreen hover:text-fawn hover:underline"
                                                >
                                                    Part {lesson.part}: {lesson.title}
                                                </Link>
                                            </li>
                                        ))}
                                    </ul>
                                </div>
                            )
                    )}
                </div>
            </div>
        </section>
    );
}

export default RoadmapSection;
