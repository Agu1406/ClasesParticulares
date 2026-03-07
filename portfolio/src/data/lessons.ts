/**
 * Datos de todas las lecciones disponibles por lenguaje.
 *
 * Las lecciones de Java siguen la guía "Notas y matices" (java/src/README.md):
 * EV1 UT0 — Conceptos básicos, ciclo de vida, sintaxis, comentarios, tipos, casteo,
 * bucles, condicionales, strings y funciones, operaciones matemáticas, arrays, POO.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 1.0.0
 * @see https://github.com/Agu1406/ClasesParticulares Repositorio GitHub
 * @see java/src/README.md Guía de Java del proyecto
 */

import type { Lesson } from "../types";
import {
    javaDocUrl,
    javaUscDocUrl,
    javaExercisesTreeUrl,
} from "./javaRepo";

/** Listado de todas las lecciones de la plataforma (todos los lenguajes). */
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
                        "Los lenguajes de programación se pueden comparar a los lenguajes humanos. Java es un lenguaje de alto nivel, más cercano al humano que al de las máquinas. Es orientado a objetos y ejecutable en casi cualquier sistema con Java instalado. No es el más simple para la primera línea de código, pero sí uno de los más sólidos para construir aplicaciones reales.",
                },
                {
                    title: "¿Quién lee y ejecuta el código?",
                    content:
                        "JVM (Java Virtual Machine): traduce el código Java para que el ordenador lo ejecute; la mayoría de usuarios la tienen instalada. JDK (Java Development Kit): lo instalan quienes desarrollan en Java; incluye el compilador, depuradores y librerías. JRE (Java Runtime Environment): JVM más las bibliotecas necesarias para ejecutar un programa concreto.",
                },
                {
                    title: "Etapas del ciclo de vida",
                    content:
                        "1) Edición: escribimos código en archivos .java. 2) Compilación: el JDK (desde el IDE) convierte el código en algo que la JVM pueda ejecutar. 3) Carga: la JVM carga los archivos compilados. 4) Verificación: la JVM revisa seguridad y coherencia. 5) Ejecución: la JVM traduce a bits y el programa arranca. En el proyecto puedes ver el ciclo en acción en src/ev1/ut0/ciclovida (Ejemplo.java y Ejemplo.class).",
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
                        "Por ahora aprendemos de memoria las 4 líneas mínimas necesarias para que nuestros programas sean ejecutables. Donde dice NombreDelPrograma tiene que ir exactamente el mismo nombre (con mayúsculas y minúsculas) del archivo .java. Puedes abrir Programa1.java en src/ev1/ut0/sintaxisbasica.",
                    code: `public class NombreDelPrograma { // Línea 1
    public static void main (String [] args) { // Línea 2
    } // Línea 3
} // Línea 4`,
                    codeLanguage: "java",
                },
                {
                    title: "Nuestro primer «Hola mundo»",
                    content:
                        "Con System.out.println() imprimimos mensajes. El texto va entre paréntesis y entre comillas dobles o simples. Las instrucciones en Java siempre terminan con punto y coma (;). Modifica Programa1.java y Programa2.java en src/ev1/ut0/sintaxisbasica para practicar.",
                    code: `public class Programa2 {
    public static void main (String [] args) {
        System.out.println("¡Hola mundo!");
        System.out.println("¡Mi nombre es Agustín!");
    }
}`,
                    codeLanguage: "java",
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
            "Comentarios de una línea (//), multilínea (/* */) y JavaDoc (/** */). Sirven para explicar el código a nosotros y a quien lo lea.",
        part: 3,
        totalParts: 11,
        roadmapPhase: "fundamentos",
        content: {
            sections: [
                {
                    title: "Comentarios de una línea",
                    icon: "comment",
                    content:
                        "Se escriben con doble barra seguida del comentario. Sirven para explicar algo puntual en una sola línea. Pueden ir en su propia línea o detrás de una instrucción.",
                    code: `// Este es un comentario de Java.
public class Ejemplo {
    public static void main (String [] args) {
        System.out.println("¡Hola!"); // También detrás de la instrucción.
    }
}`,
                    codeLanguage: "java",
                },
                {
                    title: "Comentarios multilínea",
                    content:
                        "Empiezan con /* y terminan con */. Permiten escribir varias líneas de explicación. Útiles para notas largas o recordatorios.",
                    code: `/* AQUÍ EMPIEZA EL COMENTARIO.
   Puedo escribir todo lo que quiera hasta
   indicar el fin con --> */
System.out.println("¡Hola por tercera vez!");`,
                    codeLanguage: "java",
                },
                {
                    title: "Comentarios JavaDoc",
                    content:
                        "Empiezan con /** y terminan con */. Cada línea lleva un asterisco al inicio. Son los más profesionales: permiten generar documentación (PDF) del proyecto. Suelen incluir @Since, @Author, @Version. Lo veremos con más detalle más adelante.",
                    code: `/**
 * Clase Ejemplo para explicar los tipos de comentarios.
 * @Since 14/06/2025
 * @Author Agustín Antonio Márquez Piña
 * @Version 1.0
 */
public class Ejemplo { }`,
                    codeLanguage: "java",
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
                        "Cada tipo de dato se guarda en una variable de ese tipo. No se puede guardar un entero en un char ni una letra en un int. Cada cosa tiene su lugar.",
                    code: `int miNumeroFavorito = 14;
char miLetraFavorita = 'A';`,
                    codeLanguage: "java",
                },
                {
                    title: "Datos primitivos",
                    icon: "data_object",
                    content:
                        "Las formas más básicas: enteros (byte, short, int, long), decimales (float, double), carácter (char), lógico (boolean). Para aprender rápido se recomienda usar int para enteros y double para decimales. Puedes probar en DatosPrimitivos.java (src/ev1/ut0/tipodatos).",
                    code: `byte unByte = 42;
int unInt = 123456;
long unLong = 123456789L;
float unFloat = 3.14f;
double unDouble = 3.1415926535;
char unChar = 'A';
boolean unBoolean = true;`,
                    codeLanguage: "java",
                },
                {
                    title: "Datos avanzados",
                    content:
                        "Tienen la primera letra en mayúscula (Integer, Double, String...). Ocupan más memoria y ofrecen características avanzadas. String es el tipo para cadenas de texto. Los veremos en ejercicios más adelante.",
                    code: `Integer myInt = 123_456;
String myString = "Hola, soy un texto";`,
                    codeLanguage: "java",
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
            "Convertir una variable de un tipo a otro: por ejemplo, un double a int (perdiendo decimales) o un int a double. La sintaxis es (tipo) variable.",
        part: 5,
        totalParts: 11,
        roadmapPhase: "fundamentos",
        content: {
            sections: [
                {
                    title: "Conversión de tipos primitivos",
                    icon: "swap_horiz",
                    content:
                        "Necesitamos una variable «recipiente» del tipo destino. Entre paréntesis indicamos el tipo al que queremos convertir. El valor original no se pierde; se crea una copia en el nuevo formato. Ejemplos en CasteoTiposPrimitivos.java (src/ev1/ut0/casteotipos).",
                    code: `int valorOriginal = 14;
double valorConvertido = (double) valorOriginal;

double valorPIOriginal = 3.1416;
int valorPIConvertido = (int) valorPIOriginal;
System.out.println(valorPIConvertido); // 3`,
                    codeLanguage: "java",
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
            "Repetir acciones sin copiar código: for, while y do-while. La base de la iteración en Java (según guía java/src/README.md).",
        part: 6,
        totalParts: 11,
        roadmapPhase: "estructuras",
        content: {
            sections: [
                {
                    title: "Bucle for",
                    icon: "loop",
                    content:
                        "El bucle for se usa cuando sabes cuántas veces quieres repetir. Tiene inicialización, condición e incremento.",
                    code: `for (int i = 0; i < 5; i++) {
    System.out.println("Iteración: " + i);
}`,
                    codeLanguage: "java",
                },
                {
                    title: "while y do-while",
                    content:
                        "while evalúa la condición antes de ejecutar; do-while ejecuta al menos una vez y luego evalúa.",
                    code: `int j = 0;
while (j < 3) {
    System.out.println("j = " + j);
    j++;
}

int k = 0;
do {
    System.out.println("k = " + k);
    k++;
} while (k < 3);`,
                    codeLanguage: "java",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Imprime los primeros 10 números pares usando un for.",
                    completed: false,
                },
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
            "Tomar decisiones en el programa con if, else y switch. Esencial para cualquier flujo de control (guía java/src/README.md).",
        part: 7,
        totalParts: 11,
        roadmapPhase: "estructuras",
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
                {
                    title: "switch",
                    content:
                        "switch permite elegir entre varias opciones según el valor de una variable (entero, String o enum).",
                    code: `int opcion = 2;
switch (opcion) {
    case 1: System.out.println("Uno"); break;
    case 2: System.out.println("Dos"); break;
    default: System.out.println("Otro");
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
            "Trabajar con cadenas de texto (String) y definir métodos: parámetros, retorno y reutilización de código (guía java/src/README.md).",
        part: 8,
        totalParts: 11,
        roadmapPhase: "estructuras",
        content: {
            sections: [
                {
                    title: "String: longitud, concatenación, comparación",
                    icon: "text_fields",
                    content:
                        "String tiene length(), concat() o el operador +. Para comparar contenido usa equals(); == compara referencias.",
                    code: `String a = "Hola";
String b = " mundo";
System.out.println(a + b);
System.out.println(a.length());
System.out.println(a.equals("Hola"));`,
                    codeLanguage: "java",
                },
                {
                    title: "Métodos: declaración y uso",
                    content:
                        "Un método tiene nombre, parámetros (opcionales) y tipo de retorno. void indica que no devuelve nada.",
                    code: `public static void saludar() {
    System.out.println("Hola");
}
public static int sumar(int a, int b) {
    return a + b;
}`,
                    codeLanguage: "java",
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
            "Operadores aritméticos (+, -, *, /, %) y la clase Math para potencias, raíz, redondeo y números aleatorios (guía java/src/README.md).",
        part: 9,
        totalParts: 11,
        roadmapPhase: "estructuras",
        content: {
            sections: [
                {
                    title: "Operadores y clase Math",
                    icon: "calculate",
                    content:
                        "Además de +, -, *, / y % (resto), la clase Math ofrece Math.pow(), Math.sqrt(), Math.round(), Math.random(), etc.",
                    code: `int a = 10, b = 3;
System.out.println(a / b);
System.out.println(a % b);
System.out.println(Math.pow(2, 3));
System.out.println(Math.sqrt(9));
System.out.println(Math.round(3.7));`,
                    codeLanguage: "java",
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
            "Colecciones de elementos del mismo tipo: declaración, índice desde 0, longitud y recorrido (guía java/src/README.md).",
        part: 10,
        totalParts: 11,
        roadmapPhase: "estructuras",
        content: {
            sections: [
                {
                    title: "Declaración y uso de arrays",
                    icon: "list",
                    content:
                        "Se declaran con tipo[] nombre; se crean con new tipo[tamaño]. El índice va de 0 a length - 1. Puedes usar for o for-each para recorrerlos.",
                    code: `int[] numeros = new int[] { 10, 20, 30 };
System.out.println(numeros.length);
System.out.println(numeros[1]);

for (int i = 0; i < numeros.length; i++) {
    System.out.println(numeros[i]);
}
for (int n : numeros) {
    System.out.println(n);
}`,
                    codeLanguage: "java",
                },
            ],
            exercises: [
                {
                    id: "ex1",
                    title: "Crea un array de 5 números, asígnales valor y calcula su suma.",
                    completed: false,
                },
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
            "Clases como plantillas, objetos como instancias. Atributos y métodos. Constructores y encapsulación (guía java/src/README.md).",
        part: 11,
        totalParts: 11,
        roadmapPhase: "poo",
        content: {
            sections: [
                {
                    title: "Clase y objeto",
                    icon: "data_object",
                    content:
                        "Una clase agrupa atributos (datos) y métodos (comportamiento). Con new creas instancias (objetos).",
                    code: `public class Persona {
    String nombre;
    int edad;

    public void presentarse() {
        System.out.println("Soy " + nombre + ", tengo " + edad + " años.");
    }
}

Persona p = new Persona();
p.nombre = "Ana";
p.edad = 25;
p.presentarse();`,
                    codeLanguage: "java",
                },
                {
                    title: "Constructor y encapsulación",
                    content:
                        "El constructor tiene el mismo nombre que la clase. Los atributos private se acceden mediante getters y setters.",
                    code: `public class Cuenta {
    private double saldo;

    public Cuenta(double saldoInicial) {
        saldo = saldoInicial;
    }

    public double getSaldo() { return saldo; }
    public void depositar(double cantidad) {
        if (cantidad > 0) saldo += cantidad;
    }
}`,
                    codeLanguage: "java",
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
