/**
 * Datos de todas las lecciones disponibles por lenguaje.
 *
 * Las lecciones de Java están definidas aquí de forma estática para garantizar
 * que la página funcione en todos los entornos. El contenido detallado está
 * también en content/lessons/java/*.md para edición en Markdown.
 *
 * @see content/lessons/java/*.md Contenido en .md
 * @see java/src/README.md Guía de Java del proyecto
 */

import type { Lesson } from "../types";
import {
    javaDocUrl,
    javaUscDocUrl,
    javaExercisesTreeUrl,
} from "./javaRepo";

/** Listado estático de lecciones (Java). */
export const lessons: Lesson[] = [
    {
        id: "java-1",
        languageId: "java",
        title: "Conceptos básicos y ciclo de vida del programa",
        description:
            "Java como lenguaje de alto nivel, orientado a objetos. Quién lee y ejecuta el código: JVM, JDK, JRE. Las etapas: edición, compilación, carga, verificación, ejecución.",
        part: 1,
        totalParts: 11,
        roadmapPhase: "fundamentos",
        content: {
            sections: [
                {
                    title: "Conceptos básicos",
                    icon: "menu_book",
                    content:
                        "Los lenguajes de programación se pueden comparar a los lenguajes humanos. Java es un lenguaje de alto nivel, más cercano al humano que al de las máquinas. Es orientado a objetos y ejecutable en casi cualquier sistema con Java instalado.",
                },
                {
                    title: "¿Quién lee y ejecuta el código?",
                    content:
                        "**JVM** (Java Virtual Machine): traduce el código Java para que el ordenador lo ejecute. **JDK** (Java Development Kit): lo instalan quienes desarrollan; incluye compilador y librerías. **JRE** (Java Runtime Environment): JVM más bibliotecas para ejecutar un programa.",
                },
                {
                    title: "Etapas del ciclo de vida",
                    content:
                        "1) **Edición**: escribimos código en archivos .java. 2) **Compilación**: el JDK convierte el código para la JVM. 3) **Carga**: la JVM carga los archivos compilados. 4) **Verificación**: la JVM revisa seguridad y coherencia. 5) **Ejecución**: el programa arranca. Puedes ver el ciclo en src/ev1/ut0/ciclovida.",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Abre y ejecuta Ejemplo.java en src/ev1/ut0/ciclovida y observa el .class generado.",
                    completed: false,
                },
            ],
        },
    },
    {
        id: "java-2",
        languageId: "java",
        title: "Sintaxis básica",
        description:
            "Las 4 líneas mínimas para un programa ejecutable. El primer «Hola mundo» y System.out.println. El nombre de la clase debe coincidir con el del archivo .java.",
        part: 2,
        totalParts: 11,
        roadmapPhase: "fundamentos",
        content: {
            sections: [
                {
                    title: "Nuestro primer programa en Java",
                    icon: "terminal",
                    content:
                        "Aprendemos de memoria las 4 líneas mínimas. Donde dice NombreDelPrograma tiene que ir exactamente el mismo nombre del archivo .java. Puedes abrir Programa1.java en src/ev1/ut0/sintaxisbasica.\n\n```java\npublic class NombreDelPrograma { // Línea 1\n    public static void main (String [] args) { // Línea 2\n    } // Línea 3\n} // Línea 4\n```",
                },
                {
                    title: "Nuestro primer «Hola mundo»",
                    content:
                        "Con **System.out.println()** imprimimos mensajes. El texto va entre paréntesis y comillas dobles. Las instrucciones terminan con punto y coma (;).\n\n```java\npublic class Programa2 {\n    public static void main (String [] args) {\n        System.out.println(\"¡Hola mundo!\");\n        System.out.println(\"¡Mi nombre es Agustín!\");\n    }\n}\n```",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Crea una clase con tu nombre e imprime «Hola mundo» y tu nombre en líneas distintas.",
                    completed: false,
                },
            ],
        },
    },
    {
        id: "java-3",
        languageId: "java",
        title: "Comentarios en Java",
        description:
            "Comentarios de una línea (//), multilínea (/* */) y JavaDoc (/** */). Sirven para explicar el código.",
        part: 3,
        totalParts: 11,
        roadmapPhase: "fundamentos",
        content: {
            sections: [
                {
                    title: "Comentarios de una línea",
                    icon: "comment",
                    content:
                        "Se escriben con doble barra (**//**). Pueden ir en su propia línea o detrás de una instrucción.",
                },
                {
                    title: "Comentarios multilínea",
                    content: "Empiezan con **/*** y terminan con ***/**. Permiten varias líneas de explicación.",
                },
                {
                    title: "Comentarios JavaDoc",
                    content:
                        "Empiezan con **/** *** y terminan con ***/**. Cada línea lleva un asterisco. Permiten generar documentación (PDF). Suelen incluir @Since, @Author, @Version.",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Abre y modifica Comentarios.java en src/ev1/ut0/comentarios y practica los tres tipos.",
                    completed: false,
                },
            ],
        },
    },
    {
        id: "java-4",
        languageId: "java",
        title: "Tipos de datos",
        description:
            "Java es un lenguaje tipado: cada dato tiene su contenedor. Datos primitivos (int, double, char, boolean...) y datos avanzados (Integer, String...).",
        part: 4,
        totalParts: 11,
        roadmapPhase: "fundamentos",
        content: {
            sections: [
                {
                    title: "Sintaxis: tipo nombre = valor",
                    content:
                        "Cada tipo de dato se guarda en una variable de ese tipo. No se puede guardar un entero en un char ni una letra en un int.",
                },
                {
                    title: "Datos primitivos",
                    icon: "data_object",
                    content:
                        "Enteros (byte, short, int, long), decimales (float, double), carácter (char), lógico (boolean). Para aprender rápido: **int** para enteros y **double** para decimales.",
                },
                {
                    title: "Datos avanzados",
                    content:
                        "Primera letra en mayúscula (Integer, Double, String...). **String** es el tipo para cadenas de texto.",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Declara variables de tipos primitivos y asígnales valor; prueba en DatosPrimitivos.java.",
                    completed: false,
                },
            ],
            pdfUrl: javaUscDocUrl("2ClasesTiposDatos.pdf"),
        },
    },
    {
        id: "java-5",
        languageId: "java",
        title: "Casteo de tipos",
        description:
            "Convertir una variable de un tipo a otro: por ejemplo, double a int (perdiendo decimales) o int a double. La sintaxis es (tipo) variable.",
        part: 5,
        totalParts: 11,
        roadmapPhase: "fundamentos",
        content: {
            sections: [
                {
                    title: "Conversión de tipos primitivos",
                    icon: "swap_horiz",
                    content:
                        "Necesitamos una variable del tipo destino. Entre paréntesis indicamos el tipo al que queremos convertir. El valor original no se pierde; se crea una copia en el nuevo formato.",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Convierte un double a int y un int a double; imprime ambos valores.",
                    completed: false,
                },
            ],
        },
    },
    {
        id: "java-6",
        languageId: "java",
        title: "Bucles",
        description:
            "Repetir acciones sin copiar código: for, while y do-while. La base de la iteración en Java.",
        part: 6,
        totalParts: 11,
        roadmapPhase: "estructuras",
        content: {
            sections: [
                {
                    title: "Bucle for",
                    icon: "loop",
                    content:
                        "Se usa cuando sabes cuántas veces quieres repetir. Tiene inicialización, condición e incremento.",
                },
                {
                    title: "while y do-while",
                    content:
                        "**while** evalúa la condición antes de ejecutar; **do-while** ejecuta al menos una vez y luego evalúa.",
                },
            ],
            exercises: [
                { id: "ex1", title: "Imprime los primeros 10 números pares usando un for.", completed: false },
                {
                    id: "ex2",
                    title: "Ejercicios de bucles y condicionales en el repositorio (código para practicar).",
                    completed: false,
                    fileUrl: javaExercisesTreeUrl("buclesycondicionales"),
                },
            ],
            pdfUrl: javaDocUrl("Ejercicios con funciones.pdf"),
        },
    },
    {
        id: "java-7",
        languageId: "java",
        title: "Condicionales",
        description:
            "Tomar decisiones en el programa con if, else y switch. Esencial para cualquier flujo de control.",
        part: 7,
        totalParts: 11,
        roadmapPhase: "estructuras",
        content: {
            sections: [
                {
                    title: "if y else",
                    icon: "code",
                    content:
                        "La sentencia **if** evalúa una condición booleana. Si es true, se ejecuta el bloque; si no, se puede usar **else**.",
                },
                {
                    title: "switch",
                    content:
                        "**switch** permite elegir entre varias opciones según el valor de una variable (entero, String o enum).",
                },
            ],
            exercises: [
                { id: "ex1", title: "Escribe un programa que indique si un número es par o impar.", completed: false },
                {
                    id: "ex2",
                    title: "Más ejercicios de bucles y condicionales en el repositorio.",
                    completed: false,
                    fileUrl: javaExercisesTreeUrl("buclesycondicionales"),
                },
            ],
            pdfUrl: javaDocUrl("Ejercicios con funciones.pdf"),
        },
    },
    {
        id: "java-8",
        languageId: "java",
        title: "Strings y funciones",
        description:
            "Trabajar con cadenas de texto (String) y definir métodos: parámetros, retorno y reutilización de código.",
        part: 8,
        totalParts: 11,
        roadmapPhase: "estructuras",
        content: {
            sections: [
                {
                    title: "String: longitud, concatenación, comparación",
                    icon: "text_fields",
                    content:
                        "String tiene **length()**, **concat()** o el operador **+**. Para comparar contenido usa **equals()**; **==** compara referencias.",
                },
                {
                    title: "Métodos: declaración y uso",
                    content:
                        "Un método tiene nombre, parámetros (opcionales) y tipo de retorno. **void** indica que no devuelve nada.",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Crea un método que reciba un String y devuelva su longitud; prueba con varios textos.",
                    completed: false,
                },
                {
                    id: "ex2",
                    title: "Ejercicios de strings (código para practicar).",
                    completed: false,
                    fileUrl: javaExercisesTreeUrl("strings"),
                },
                {
                    id: "ex3",
                    title: "Soluciones resueltas de ejercicios de strings.",
                    completed: false,
                    solutionUrl: javaExercisesTreeUrl("strings/resueltos"),
                },
            ],
            pdfUrl: javaDocUrl("String referencia breve.pdf"),
        },
    },
    {
        id: "java-9",
        languageId: "java",
        title: "Operaciones matemáticas",
        description:
            "Operadores aritméticos (+, -, *, /, %) y la clase Math para potencias, raíz, redondeo y números aleatorios.",
        part: 9,
        totalParts: 11,
        roadmapPhase: "estructuras",
        content: {
            sections: [
                {
                    title: "Operadores y clase Math",
                    icon: "calculate",
                    content:
                        "Además de +, -, *, / y **%** (resto), la clase **Math** ofrece Math.pow(), Math.sqrt(), Math.round(), Math.random(), etc.",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Escribe un método que reciba dos números y devuelva el mayor; luego prueba con Math.max().",
                    completed: false,
                },
                {
                    id: "ex2",
                    title: "Ejercicios de funciones en el repositorio.",
                    completed: false,
                    fileUrl: javaExercisesTreeUrl("funciones"),
                },
            ],
            pdfUrl: javaDocUrl("Ejercicios con funciones.pdf"),
        },
    },
    {
        id: "java-10",
        languageId: "java",
        title: "Arrays",
        description:
            "Colecciones de elementos del mismo tipo: declaración, índice desde 0, longitud y recorrido.",
        part: 10,
        totalParts: 11,
        roadmapPhase: "estructuras",
        content: {
            sections: [
                {
                    title: "Declaración y uso de arrays",
                    icon: "list",
                    content:
                        "Se declaran con **tipo[] nombre**; se crean con **new tipo[tamaño]**. El índice va de 0 a length - 1. Puedes usar **for** o **for-each** para recorrerlos.",
                },
            ],
            exercises: [
                { id: "ex1", title: "Crea un array de 5 números, asígnales valor y calcula su suma.", completed: false },
                {
                    id: "ex2",
                    title: "Ejercicios de arrays (código para practicar).",
                    completed: false,
                    fileUrl: javaExercisesTreeUrl("arrays"),
                },
                {
                    id: "ex3",
                    title: "Soluciones resueltas de ejercicios de arrays.",
                    completed: false,
                    solutionUrl: javaExercisesTreeUrl("arrays/resueltos"),
                },
            ],
            pdfUrl: javaDocUrl("Ejercicios Arrays 1.pdf"),
        },
    },
    {
        id: "java-11",
        languageId: "java",
        title: "Conceptos básicos de la POO",
        description:
            "Clases como plantillas, objetos como instancias. Atributos y métodos. Constructores y encapsulación.",
        part: 11,
        totalParts: 11,
        roadmapPhase: "poo",
        content: {
            sections: [
                {
                    title: "Clase y objeto",
                    icon: "data_object",
                    content:
                        "Una clase agrupa atributos (datos) y métodos (comportamiento). Con **new** creas instancias (objetos).",
                },
                {
                    title: "Constructor y encapsulación",
                    content:
                        "El constructor tiene el mismo nombre que la clase. Los atributos **private** se acceden mediante getters y setters.",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Define una clase Coche con marca y año; crea dos coches e imprime sus datos.",
                    completed: false,
                },
                {
                    id: "ex2",
                    title: "Ejercicios de POO básico (clases, objetos, constructores).",
                    completed: false,
                    fileUrl: javaExercisesTreeUrl("poo_basico"),
                },
                {
                    id: "ex3",
                    title: "Soluciones resueltas de POO básico.",
                    completed: false,
                    solutionUrl: javaExercisesTreeUrl("poo_basico/resueltos"),
                },
            ],
            pdfUrl: javaDocUrl("L02-Clases y Objetos.pdf"),
        },
    },
];

/**
 * Obtiene todas las lecciones de un lenguaje dado.
 */
export function getLessonsByLanguage(languageId: string): Lesson[] {
    return lessons
        .filter((lesson) => lesson.languageId === languageId)
        .sort((a, b) => a.part - b.part);
}

/**
 * Obtiene una lección por su ID.
 */
export function getLessonById(lessonId: string): Lesson | undefined {
    return lessons.find((lesson) => lesson.id === lessonId);
}
