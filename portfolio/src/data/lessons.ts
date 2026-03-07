/**
 * Datos de todas las lecciones disponibles por lenguaje.
 *
 * Cada lección pertenece a un lenguaje (languageId) y contiene secciones de teoría,
 * ejemplos de código, ejercicios y opcionalmente un enlace a PDF.
 *
 * Se usan IDs en formato string (ej: "java-1") para URLs legibles y evitar colisiones.
 * Las funciones getLessonsByLanguage y getLessonById permiten filtrar y buscar lecciones.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see https://agu1406.github.io/ClasesParticulares GitHub Pages
 */

import type { Lesson } from "../types";

/** Listado de todas las lecciones de la plataforma (todos los lenguajes). */
export const lessons: Lesson[] = [
    {
        id: "java-1",
        languageId: "java",
        title: "Introducción a Java",
        description:
            "Java es un lenguaje de programación orientado a objetos, multiplataforma. En esta lección verás tu primer programa y los tipos de datos básicos.",
        part: 1,
        totalParts: 12,
        content: {
            sections: [
                {
                    title: "Tu primer programa",
                    icon: "terminal",
                    content:
                        "Todo programa en Java comienza con una clase y un método main. Aquí tienes el clásico «Hola mundo».",
                    code: `public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}`,
                    codeLanguage: "java",
                },
                {
                    title: "Variables y tipos",
                    icon: "data_object",
                    content:
                        "Java es estáticamente tipado: debes declarar el tipo de cada variable antes de usarla.",
                    code: `int age = 25;
double price = 19.99;
String name = "Agustin";
boolean isStudent = true;`,
                    codeLanguage: "java",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Crea una clase llamada 'Profile' e imprime tu nombre.",
                    completed: true,
                },
                {
                    id: "ex2",
                    title: "Declara tres variables de tipos distintos e imprímelas.",
                    completed: false,
                },
            ],
            pdfUrl: "/exercises/java-1.pdf",
        },
    },
    {
        id: "java-2",
        languageId: "java",
        title: "Variables y tipos de datos",
        description:
            "Profundizamos en los tipos primitivos, Strings y convenciones de nombres. Es la base para el resto del curso.",
        part: 2,
        totalParts: 12,
        content: {
            sections: [
                {
                    title: "Tipos primitivos",
                    content:
                        "Los tipos primitivos en Java son: byte, short, int, long, float, double, char y boolean. Cada uno tiene un rango de valores definido.",
                    code: `int count = 100;
long bigNumber = 1_000_000L;
double pi = 3.14159;
char grade = 'A';`,
                    codeLanguage: "java",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Declara variables de cada tipo primitivo y asígnales un valor.",
                    completed: false,
                },
            ],
        },
    },
    {
        id: "java-3",
        languageId: "java",
        title: "Condicionales: if y switch",
        description:
            "Aprende a tomar decisiones en tu programa con if, else y switch. Esencial para cualquier flujo de control.",
        part: 3,
        totalParts: 12,
        content: {
            sections: [
                {
                    title: "if y else",
                    icon: "code",
                    content:
                        "La sentencia if evalúa una condición booleana. Si es true, se ejecuta el bloque; si no, se puede usar else.",
                    code: `int edad = 18;
if (edad >= 18) {
    System.out.println("Mayor de edad");
} else {
    System.out.println("Menor de edad");
}`,
                    codeLanguage: "java",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Escribe un programa que indique si un número es par o impar.",
                    completed: false,
                },
            ],
        },
    },
    {
        id: "java-4",
        languageId: "java",
        title: "Bucles: for y while",
        description:
            "Repetir acciones sin copiar código: for, while y do-while. La base de la iteración en Java.",
        part: 4,
        totalParts: 12,
        content: {
            sections: [
                {
                    title: "Bucle for",
                    content:
                        "El bucle for se usa cuando sabes cuántas veces quieres repetir. Tiene inicialización, condición e incremento.",
                    code: `for (int i = 0; i < 5; i++) {
    System.out.println("Iteración: " + i);
}`,
                    codeLanguage: "java",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Imprime los primeros 10 números pares usando un for.",
                    completed: false,
                },
            ],
        },
    },
];

/**
 * Obtiene todas las lecciones de un lenguaje dado.
 * Útil para las páginas índice (JavaPage, PythonPage, etc.) que muestran un grid de lecciones.
 *
 * @param languageId - ID del lenguaje (ej: "java", "python").
 * @returns Array de lecciones de ese lenguaje, ordenadas por part.
 */
export function getLessonsByLanguage(languageId: string): Lesson[] {
    return lessons
        .filter((lesson) => lesson.languageId === languageId)
        .sort((a, b) => a.part - b.part);
}

/**
 * Obtiene una lección por su ID.
 * Se usa en LessonPage para mostrar el contenido de una lección concreta (ruta /lesson/:lessonId).
 *
 * @param lessonId - ID único de la lección (ej: "java-1").
 * @returns La lección encontrada o undefined si no existe.
 */
export function getLessonById(lessonId: string): Lesson | undefined {
    return lessons.find((lesson) => lesson.id === lessonId);
}
