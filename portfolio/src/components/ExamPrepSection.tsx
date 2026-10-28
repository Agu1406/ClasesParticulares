/**
 * Bloque «Prepara el examen» (inspirado en apuntesdam.com) para lenguajes con test HTML.
 */

import { cTestPublicUrl, cTestHtmlUrl } from "../data/cRepo";

interface ExamPrepSectionProps {
    languageId: string;
}

function ExamPrepSection({ languageId }: ExamPrepSectionProps) {
    if (languageId !== "c") {
        return null;
    }

    const publicTest = cTestPublicUrl();
    const repoTest = cTestHtmlUrl("test_ev1_hasta_bucles.html");

    return (
        <section
            className="mb-10 md:mb-12 rounded-3xl border border-evergreen/15 bg-white/80 p-5 sm:p-6 shadow-sm"
            aria-labelledby="exam-prep-c-heading"
        >
            <p className="text-xs font-bold uppercase tracking-wider text-scarlet mb-2">
                Prepara el examen
            </p>
            <h2
                id="exam-prep-c-heading"
                className="text-xl sm:text-2xl font-bold text-evergreen mb-3"
            >
                Test EV1 — de Hola Mundo a bucles
            </h2>
            <p className="text-slate-grey text-sm sm:text-base leading-relaxed mb-5 max-w-2xl mx-auto text-center">
                Más de 60 preguntas tipo test alineadas con{" "}
                <code className="text-xs bg-lavender px-1.5 py-0.5 rounded">c/src/ev1</code>.
                Elige tema, corrige al instante y baraja opciones con «Nuevo intento».
            </p>
            <div className="flex flex-col sm:flex-row gap-3 justify-center items-stretch sm:items-center">
                <a
                    href={publicTest}
                    className="inline-flex justify-center items-center gap-2 rounded-2xl bg-evergreen text-lavender px-6 py-3.5 font-semibold shadow-md hover:bg-evergreen-dark transition-colors"
                >
                    <span className="material-icons text-lg">quiz</span>
                    Abrir test en el portal
                </a>
                <a
                    href={repoTest}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="inline-flex justify-center items-center gap-2 rounded-2xl border border-evergreen/30 text-evergreen px-6 py-3.5 font-semibold hover:bg-evergreen/5 transition-colors"
                >
                    <span className="material-icons text-lg">folder_open</span>
                    Ver en GitHub
                </a>
            </div>
        </section>
    );
}

export default ExamPrepSection;
