/**
 * Simulacro dentro del portal. Usa el mismo banco que el HTML de tests/:
 * modo estudio (corrección al momento) y modo examen (corrección al enviar).
 */

import { useEffect, useState } from "react";
import { Link, useParams, useSearchParams } from "react-router-dom";
import { getQuizById, type QuizQuestion } from "../data/quizzes/loadClassicBank";

type Mode = "examen" | "estudio";

function shuffle(items: QuizQuestion[]): QuizQuestion[] {
    const copy = [...items];
    for (let i = copy.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        const current = copy[i];
        const swap = copy[j];
        if (current !== undefined && swap !== undefined) {
            copy[i] = swap;
            copy[j] = current;
        }
    }
    return copy;
}

function QuizPage() {
    const { quizId } = useParams<{ quizId: string }>();
    const [params, setParams] = useSearchParams();
    const quiz = quizId ? getQuizById(quizId) : undefined;
    const mode: Mode = params.get("modo") === "examen" ? "examen" : "estudio";

    if (!quiz) {
        return (
            <div className="bg-lavender p-8 text-center">
                <h1 className="text-2xl font-bold text-evergreen">Test no encontrado</h1>
                <Link to="/" className="text-fawn hover:underline mt-4 inline-block">
                    Volver al inicio
                </Link>
            </div>
        );
    }

    return (
        <QuizSession
            key={mode}
            quizTitle={quiz.title}
            quizDescription={quiz.description}
            languageId={quiz.languageId}
            mode={mode}
            bank={quiz.questions}
            onMode={(next) => {
                const updated = new URLSearchParams(params);
                updated.set("modo", next);
                setParams(updated);
            }}
        />
    );
}

function QuizSession({
    quizTitle,
    quizDescription,
    languageId,
    mode,
    bank,
    onMode,
}: {
    quizTitle: string;
    quizDescription: string;
    languageId: string;
    mode: Mode;
    bank: QuizQuestion[];
    onMode: (mode: Mode) => void;
}) {
    const [questions] = useState(() => shuffle(bank));
    const [index, setIndex] = useState(0);
    const [answers, setAnswers] = useState<Record<number, number>>({});
    const [submitted, setSubmitted] = useState(false);
    const [confirming, setConfirming] = useState(false);

    const goTo = (next: number) => {
        setConfirming(false);
        setIndex(next);
    };

    useEffect(() => {
        const onKey = (event: KeyboardEvent) => {
            if (submitted) return;
            if (event.key === "ArrowRight") goTo(Math.min(index + 1, questions.length - 1));
            if (event.key === "ArrowLeft") goTo(Math.max(index - 1, 0));
            if (["1", "2", "3", "4"].includes(event.key)) {
                const choice = Number(event.key) - 1;
                const question = questions[index];
                if (!question || choice >= question.options.length) return;
                if (mode === "estudio" && answers[index] !== undefined) return;
                setAnswers((current) => ({ ...current, [index]: choice }));
            }
        };
        window.addEventListener("keydown", onKey);
        return () => window.removeEventListener("keydown", onKey);
    }, [answers, index, mode, questions, submitted]);

    const question = questions[index];
    const answeredCount = Object.keys(answers).length;
    const progress = questions.length === 0 ? 0 : Math.round((answeredCount / questions.length) * 100);

    const choose = (option: number) => {
        if (mode === "estudio" && answers[index] !== undefined) return;
        setAnswers((current) => ({ ...current, [index]: option }));
        setConfirming(false);
    };

    const correctCount = questions.filter((item, i) => answers[i] === item.correct).length;

    if (submitted) {
        const nota = questions.length === 0 ? 0 : (correctCount / questions.length) * 10;
        return (
            <div className="bg-lavender p-4 sm:p-6 md:p-8">
                <div className="container mx-auto max-w-3xl">
                    <h1 className="text-2xl font-bold text-evergreen">{quizTitle}</h1>
                    <p className="mt-2 text-slate-grey">
                        {correctCount} de {questions.length} · {Math.round((nota / 10) * 100)}% · nota {nota.toFixed(1)} / 10
                    </p>
                    <div className="mt-6 space-y-4">
                        {questions.map((item, i) => {
                            const picked = answers[i];
                            const ok = picked === item.correct;
                            return (
                                <article key={item.id} className="bg-white rounded-2xl p-4 border border-evergreen/10">
                                    <p className="font-semibold text-evergreen">
                                        {i + 1}. {item.question}
                                    </p>
                                    {item.code && (
                                        <pre className="mt-2 bg-slate-800 text-lavender text-xs rounded-xl p-3 overflow-x-auto whitespace-pre-wrap">
                                            {item.code}
                                        </pre>
                                    )}
                                    <p className={`text-sm mt-2 ${ok ? "text-evergreen" : "text-scarlet"}`}>
                                        {picked === undefined
                                            ? "Sin respuesta."
                                            : ok
                                              ? "Correcta."
                                              : `Marcaste: ${item.options[picked] ?? ""}.`}
                                    </p>
                                    <p className="text-sm text-slate-grey mt-1">
                                        Respuesta: {item.options[item.correct]}
                                    </p>
                                    <p className="text-sm mt-2">{item.explanation}</p>
                                </article>
                            );
                        })}
                    </div>
                    <div className="flex gap-3 mt-6">
                        <button
                            type="button"
                            className="bg-evergreen text-lavender font-semibold px-4 py-3 rounded-2xl"
                            onClick={() => window.location.reload()}
                        >
                            Repetir (otro orden)
                        </button>
                        <Link to={`/${languageId}`} className="px-4 py-3 rounded-2xl border border-evergreen/20">
                            Volver al temario
                        </Link>
                    </div>
                </div>
            </div>
        );
    }

    if (!question) {
        return null;
    }

    const picked = answers[index];
    const locked = mode === "estudio" && picked !== undefined;

    return (
        <div className="bg-lavender p-4 sm:p-6 md:p-8">
            <div className="container mx-auto max-w-3xl">
                <div className="flex flex-wrap items-center justify-between gap-3">
                    <h1 className="text-2xl font-bold text-evergreen">{quizTitle}</h1>
                    <div className="flex gap-2">
                        <button
                            type="button"
                            onClick={() => onMode("estudio")}
                            className={`px-3 py-2 rounded-xl text-sm font-semibold ${mode === "estudio" ? "bg-evergreen text-lavender" : "bg-white text-evergreen"}`}
                        >
                            Estudio
                        </button>
                        <button
                            type="button"
                            onClick={() => onMode("examen")}
                            className={`px-3 py-2 rounded-xl text-sm font-semibold ${mode === "examen" ? "bg-scarlet text-white" : "bg-white text-evergreen"}`}
                        >
                            Examen
                        </button>
                    </div>
                </div>
                <p className="text-sm text-slate-grey mt-2">{quizDescription}</p>
                <div className="mt-4 h-2 bg-white rounded-full overflow-hidden" aria-hidden>
                    <div className="h-full bg-evergreen" style={{ width: `${progress}%` }} />
                </div>
                <p className="text-xs text-slate-grey mt-1">
                    {answeredCount} de {questions.length} respondidas
                    {mode === "examen" ? " · la corrección llega al enviar" : " · corrección al marcar"}
                </p>

                <article className="bg-white rounded-2xl p-4 sm:p-6 mt-4 border border-evergreen/10">
                    <p className="text-xs font-bold uppercase tracking-wider text-scarlet">
                        Pregunta {index + 1} de {questions.length}
                    </p>
                    <h2 className="text-lg font-bold text-evergreen mt-2">{question.question}</h2>
                    {question.code && (
                        <pre className="mt-3 bg-slate-800 text-lavender text-sm rounded-xl p-3 overflow-x-auto whitespace-pre-wrap">
                            {question.code}
                        </pre>
                    )}
                    <ul className="mt-4 space-y-2" role="radiogroup" aria-label="Opciones">
                        {question.options.map((option, optionIndex) => {
                            const selected = picked === optionIndex;
                            const showCorrect = locked && optionIndex === question.correct;
                            const showWrong = locked && selected && optionIndex !== question.correct;
                            return (
                                <li key={option}>
                                    <button
                                        type="button"
                                        role="radio"
                                        aria-checked={selected}
                                        disabled={locked}
                                        onClick={() => choose(optionIndex)}
                                        className={`w-full text-left rounded-xl px-4 py-3 border text-sm ${
                                            showCorrect
                                                ? "border-evergreen bg-evergreen/10"
                                                : showWrong
                                                  ? "border-scarlet bg-scarlet/10"
                                                  : selected
                                                    ? "border-fawn bg-fawn/20"
                                                    : "border-slate-200 bg-white"
                                        }`}
                                    >
                                        {optionIndex + 1}. {option}
                                    </button>
                                </li>
                            );
                        })}
                    </ul>
                    {locked && (
                        <p className="mt-4 text-sm text-slate-grey">{question.explanation}</p>
                    )}
                </article>

                <div className="flex flex-wrap justify-between gap-3 mt-4">
                    <button
                        type="button"
                        className="px-4 py-3 rounded-xl bg-white border border-evergreen/10 disabled:opacity-40"
                        disabled={index === 0}
                        onClick={() => goTo(index - 1)}
                    >
                        Anterior
                    </button>
                    {index < questions.length - 1 ? (
                        <button
                            type="button"
                            className="px-4 py-3 rounded-xl bg-evergreen text-lavender font-semibold"
                            onClick={() => goTo(index + 1)}
                        >
                            Siguiente
                        </button>
                    ) : (
                        <button
                            type="button"
                            className="px-4 py-3 rounded-xl bg-scarlet text-white font-semibold"
                            onClick={() => {
                                if (answeredCount < questions.length && !confirming) {
                                    setConfirming(true);
                                    return;
                                }
                                setSubmitted(true);
                            }}
                        >
                            {mode === "examen" ? "Enviar examen" : "Ver resumen"}
                        </button>
                    )}
                </div>
                {confirming && (
                    <p className="text-sm text-scarlet mt-3">
                        Te faltan {questions.length - answeredCount}. Pulsa otra vez para enviarlas en blanco.
                    </p>
                )}
                <p className="text-xs text-slate-grey mt-4">
                    Flechas para moverte y números 1-4 para responder. El mismo banco, en la página HTML de siempre, está en tests/tests/c/.
                </p>
                <Link to={`/${languageId}`} className="inline-block mt-3 text-sm text-evergreen underline">
                    Volver al temario
                </Link>
            </div>
        </div>
    );
}

export default QuizPage;
