/**
 * Página de asignatura al estilo de una línea de temario:
 * estaciones numeradas, simulacro, chuleta y cómo estudiar.
 * Se usa cuando el lenguaje tiene ficha en data/subjects.ts.
 */

import { Link } from "react-router-dom";
import ReactMarkdown from "react-markdown";
import remarkGfm from "remark-gfm";
import type { Language, Lesson } from "../types";
import type { SubjectProfile } from "../data/subjects";

interface SubjectOverviewProps {
    language: Language;
    lessons: Lesson[];
    subject: SubjectProfile;
}

function SubjectOverview({ language, lessons, subject }: SubjectOverviewProps) {
    const ordered = [...lessons].sort((a, b) => a.part - b.part);
    const first = ordered[0];

    return (
        <div className="bg-lavender p-4 sm:p-6 md:p-8">
            <div className="container mx-auto max-w-3xl">
                <p className="text-xs font-bold uppercase tracking-wider text-scarlet text-center">
                    {subject.eyebrow}
                </p>
                <h1 className="text-2xl sm:text-3xl md:text-4xl font-bold text-center mt-2 text-evergreen">
                    {subject.headline}
                </h1>
                <p className="text-center mt-4 text-slate-grey text-base md:text-lg">
                    {subject.pitch}
                </p>
                <p className="text-center text-sm text-slate-grey mt-3">
                    {ordered.length} estaciones · {subject.level} · {language.name}
                </p>

                <div className="flex flex-col sm:flex-row flex-wrap justify-center gap-3 mt-6">
                    {first && (
                        <Link
                            to={`/lesson/${first.id}`}
                            className="bg-evergreen text-lavender font-semibold px-5 py-3 rounded-2xl text-center hover:bg-evergreen-dark"
                        >
                            Empezar el temario
                        </Link>
                    )}
                    <Link
                        to={`${subject.quizPath}?modo=estudio`}
                        className="bg-white text-evergreen font-semibold px-5 py-3 rounded-2xl text-center border border-evergreen/20 hover:border-fawn"
                    >
                        Simulacro (estudio)
                    </Link>
                    <Link
                        to={`${subject.quizPath}?modo=examen`}
                        className="bg-scarlet text-white font-semibold px-5 py-3 rounded-2xl text-center hover:bg-scarlet-dark"
                    >
                        Modo examen
                    </Link>
                    <a
                        href="#chuleta"
                        className="bg-white text-evergreen font-semibold px-5 py-3 rounded-2xl text-center border border-evergreen/20 hover:border-fawn"
                    >
                        Chuleta
                    </a>
                </div>

                <ol className="mt-10 space-y-4">
                    {ordered.map((lesson) => (
                        <li key={lesson.id}>
                            <Link
                                to={`/lesson/${lesson.id}`}
                                className="flex gap-4 bg-white rounded-2xl p-4 sm:p-5 border border-evergreen/10 hover:border-fawn shadow-sm"
                            >
                                <span className="w-12 h-12 shrink-0 rounded-full bg-evergreen text-lavender font-bold flex items-center justify-center">
                                    {String(lesson.part).padStart(2, "0")}
                                </span>
                                <span>
                                    <span className="text-xs font-bold uppercase tracking-wider text-scarlet">
                                        {lesson.level ?? subject.level}
                                    </span>
                                    <span className="block text-lg font-bold text-evergreen mt-1">
                                        {lesson.title}
                                    </span>
                                    <span className="block text-sm text-slate-grey mt-1">
                                        {lesson.description}
                                    </span>
                                </span>
                            </Link>
                        </li>
                    ))}
                </ol>

                <section className="mt-10">
                    <h2 className="text-xl font-bold text-evergreen">Qué aprendes</h2>
                    <ul className="mt-3 space-y-2 text-slate-grey text-sm list-disc pl-5">
                        {subject.learn.map((item) => (
                            <li key={item}>{item}</li>
                        ))}
                    </ul>
                </section>

                <section className="mt-8 bg-white rounded-2xl p-5 border border-evergreen/10">
                    <h2 className="text-xl font-bold text-evergreen">Cómo es el examen</h2>
                    <h3 className="mt-4 font-semibold text-evergreen">Parte de traza</h3>
                    <p className="text-sm text-slate-grey mt-1">{subject.examTheory}</p>
                    <h3 className="mt-4 font-semibold text-evergreen">Parte de escribir</h3>
                    <p className="text-sm text-slate-grey mt-1">{subject.examPractice}</p>
                </section>

                <section className="mt-8">
                    <h2 className="text-xl font-bold text-evergreen">Cómo estudiar</h2>
                    <ol className="mt-3 space-y-2 text-slate-grey text-sm list-decimal pl-5">
                        {subject.study.map((item) => (
                            <li key={item}>{item}</li>
                        ))}
                    </ol>
                </section>

                <section className="mt-8 space-y-4">
                    <h2 className="text-xl font-bold text-evergreen">Preguntas frecuentes</h2>
                    {subject.faq.map((item) => (
                        <div key={item.q} className="bg-white rounded-2xl p-4 border border-evergreen/10">
                            <h3 className="font-semibold text-evergreen">{item.q}</h3>
                            <p className="text-sm text-slate-grey mt-1">{item.a}</p>
                        </div>
                    ))}
                </section>

                <section id="chuleta" className="mt-10 bg-evergreen text-lavender rounded-2xl p-5 sm:p-6">
                    <h2 className="text-xl font-bold">Chuleta para el examen</h2>
                    <p className="text-sm text-lavender/80 mt-1">
                        Una hoja con lo que se mira al estudiar. El detalle está en cada estación.
                    </p>
                    <div className="mt-4 text-sm leading-relaxed space-y-3 [&_h2]:text-fawn [&_h2]:font-bold [&_h2]:mt-4 [&_pre]:bg-black/30 [&_pre]:rounded-xl [&_pre]:p-3 [&_pre]:overflow-x-auto [&_code]:font-mono [&_p]:text-lavender/90">
                        <ReactMarkdown remarkPlugins={[remarkGfm]}>{subject.cheatSheet}</ReactMarkdown>
                    </div>
                </section>
            </div>
        </div>
    );
}

export default SubjectOverview;
