/**
 * Lee un banco de preguntas escrito para el HTML de tests/
 * (`const questions = [...]`) y lo deja usable en el portal.
 * Un solo fichero: el simulacro y el test clásico no se desincronizan.
 */

import raw from "../../../../tests/js/questions/c-basico-hasta-bucles.js?raw";

export interface QuizQuestion {
    id: number;
    question: string;
    options: string[];
    correct: number;
    explanation: string;
    code?: string;
}

export interface QuizDefinition {
    id: string;
    languageId: string;
    title: string;
    description: string;
    questions: QuizQuestion[];
}

function asRawString(value: unknown): string {
    if (typeof value === "string") return value;
    const mod = value as { default?: string };
    if (typeof mod?.default === "string") return mod.default;
    return "";
}

function readBank(source: string): QuizQuestion[] {
    const bank = new Function(`${source}\nreturn questions;`)() as QuizQuestion[];
    if (!Array.isArray(bank) || bank.length === 0) {
        throw new Error("El banco de preguntas está vacío");
    }
    return bank;
}

export const quizzes: QuizDefinition[] = [
    {
        id: "c-basico-bucles",
        languageId: "c",
        title: "C de cero a bucles",
        description:
            "24 preguntas del temario de clase, hasta bucles. Se barajan en cada intento.",
        questions: readBank(asRawString(raw)),
    },
];

export function getQuizById(id: string): QuizDefinition | undefined {
    return quizzes.find((quiz) => quiz.id === id);
}
