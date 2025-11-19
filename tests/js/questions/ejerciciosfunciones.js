/**
 * Banco de preguntas sobre Funciones en Java
 * Basado en c_ejerciciosfunciones
 * Cada pregunta tiene:
 * - id: identificador unico
 * - question: texto de la pregunta
 * - options: array con las 4 opciones de respuesta
 * - correct: indice de la respuesta correcta (0-3)
 * - explanation: explicacion de por que esa es la respuesta correcta
 * - code: (opcional) codigo de ejemplo si la pregunta lo requiere
 */
const questions = [
    {
        id: 1,
        question: "¿Cuál es la sintaxis correcta para crear una función que no retorna nada (void) en Java?",
        options: [
            "public static void nombreFuncion() { }",
            "public void static nombreFuncion() { }",
            "void public static nombreFuncion() { }",
            "static void public nombreFuncion() { }"
        ],
        correct: 0,
        explanation: "La sintaxis correcta es: modificador de acceso (public), static, tipo de retorno (void), nombre de la función, y paréntesis. El orden es importante en Java.",
        code: "public static void mostrarMensaje() {\n    System.out.println(\"Hola\");\n}"
    },
    {
        id: 2,
        question: "Si queremos crear una función que reciba un número entero como parámetro, ¿cómo lo declaramos?",
        options: [
            "public static void funcion(int numero) { }",
            "public static void funcion(int numero;) { }",
            "public static void funcion(numero int) { }",
            "public static void funcion() { int numero }"
        ],
        correct: 0,
        explanation: "Los parámetros se declaran dentro de los paréntesis con el tipo primero, luego el nombre. No lleva punto y coma dentro de los paréntesis.",
        code: "public static void mostrarNumero(int numero) {\n    System.out.println(numero);\n}"
    },
    {
        id: 3,
        question: "Si tenemos una función que retorna int, ¿qué palabra clave usamos para devolver un valor?",
        options: [
            "return",
            "retorno",
            "devolver",
            "resultado"
        ],
        correct: 0,
        explanation: "La palabra clave return se usa para devolver un valor desde una función. Después de return, el valor se devuelve y la función termina.",
        code: "public static int sumar(int a, int b) {\n    return a + b;\n}"
    },
    {
        id: 4,
        question: "Si tenemos una función que retorna double, ¿qué tipo de valor debemos devolver?",
        options: [
            "Un número decimal (double o int)",
            "Solo un String",
            "Solo un boolean",
            "Solo un int"
        ],
        correct: 0,
        explanation: "Una función que retorna double puede devolver un valor double o un int (que se convierte automáticamente a double). No puede devolver otros tipos como String o boolean.",
        code: "public static double calcularPromedio(double a, double b) {\n    return (a + b) / 2.0; // Retorna un double\n}"
    },
    {
        id: 5,
        question: "Si queremos crear una función que retorne un String con un saludo, ¿cuál es la sintaxis correcta?",
        options: [
            "public static String crearSaludo(String nombre) { return \"Hola, \" + nombre; }",
            "public static void crearSaludo(String nombre) { return \"Hola\"; }",
            "public static String crearSaludo() { return nombre; }",
            "public String static crearSaludo(String nombre) { }"
        ],
        correct: 0,
        explanation: "La función debe tener tipo de retorno String, recibir el parámetro nombre, y usar return para devolver el String concatenado. El orden de los modificadores es: public static String.",
        code: "public static String crearSaludo(String nombre) {\n    return \"Hola, \" + nombre;\n}"
    },
    {
        id: 6,
        question: "Si tenemos una función que retorna boolean para verificar si un número es par, ¿qué retornamos?",
        options: [
            "return (numero % 2 == 0);",
            "return numero;",
            "return \"par\";",
            "return true; siempre"
        ],
        correct: 0,
        explanation: "La función debe retornar true si el número es par (numero % 2 == 0 es verdadero) o false si es impar. La expresión (numero % 2 == 0) ya es un boolean, así que podemos retornarla directamente.",
        code: "public static boolean esPar(int numero) {\n    return (numero % 2 == 0);\n}"
    },
    {
        id: 7,
        question: "Si tenemos una función que usa if-else para retornar \"Aprobado\" o \"Suspenso\" según la nota, ¿qué estructura usamos?",
        options: [
            "if (nota >= 5) { return \"Aprobado\"; } else { return \"Suspenso\"; }",
            "if (nota >= 5) { return \"Suspenso\"; } else { return \"Aprobado\"; }",
            "if (nota < 5) { return \"Aprobado\"; }",
            "return nota;"
        ],
        correct: 0,
        explanation: "Si la nota es mayor o igual a 5, retornamos \"Aprobado\". En caso contrario (else), retornamos \"Suspenso\". Cada return termina la función inmediatamente.",
        code: "public static String evaluarNota(int nota) {\n    if (nota >= 5) {\n        return \"Aprobado\";\n    } else {\n        return \"Suspenso\";\n    }\n}"
    },
    {
        id: 8,
        question: "Si tenemos una función que usa un bucle for para sumar números del 1 al n, ¿qué retornamos?",
        options: [
            "return suma; (donde suma se acumula en el bucle)",
            "return n;",
            "return for;",
            "return 0; siempre"
        ],
        correct: 0,
        explanation: "Creamos una variable suma que inicia en 0, la usamos en el bucle para acumular los valores, y al final retornamos suma con el resultado total.",
        code: "public static int sumarNumeros(int n) {\n    int suma = 0;\n    for (int i = 1; i <= n; i++) {\n        suma += i;\n    }\n    return suma;\n}"
    },
    {
        id: 9,
        question: "Si tenemos una función con switch que retorna el nombre del día según un número, ¿qué estructura usamos?",
        options: [
            "switch (numero) { case 1: return \"Lunes\"; case 2: return \"Martes\"; ... }",
            "switch (numero) { case 1: \"Lunes\"; case 2: \"Martes\"; }",
            "switch { return \"Lunes\"; }",
            "switch (numero) { return \"Día\"; }"
        ],
        correct: 0,
        explanation: "En cada case del switch, usamos return para devolver el String correspondiente. Cada return termina la función, así que no necesitamos break después de return.",
        code: "public static String obtenerDiaSemana(int numero) {\n    switch (numero) {\n        case 1: return \"Lunes\";\n        case 2: return \"Martes\";\n        case 3: return \"Miércoles\";\n        default: return \"Día inválido\";\n    }\n}"
    },
    {
        id: 10,
        question: "Si tenemos una función que combina un bucle for y un if para contar números pares, ¿qué retornamos?",
        options: [
            "return contador; (donde contador se incrementa en el if)",
            "return for;",
            "return if;",
            "return true;"
        ],
        correct: 0,
        explanation: "Creamos un contador que inicia en 0. En el bucle, si el número es par (verificado con if), incrementamos el contador. Al final retornamos el contador con el total de números pares.",
        code: "public static int contarPares(int n) {\n    int contador = 0;\n    for (int i = 1; i <= n; i++) {\n        if (i % 2 == 0) {\n            contador++;\n        }\n    }\n    return contador;\n}"
    },
    {
        id: 11,
        question: "¿Cómo llamamos a una función desde el método main?",
        options: [
            "nombreFuncion(); o nombreFuncion(parametros);",
            "call nombreFuncion();",
            "execute nombreFuncion();",
            "run nombreFuncion();"
        ],
        correct: 0,
        explanation: "Para llamar a una función, simplemente escribimos su nombre seguido de paréntesis. Si tiene parámetros, los pasamos dentro de los paréntesis separados por comas.",
        code: "public static void main(String[] args) {\n    mostrarMensaje(); // Llamada sin parámetros\n    mostrarNumero(5); // Llamada con parámetro\n}"
    },
    {
        id: 12,
        question: "Si una función retorna un valor, ¿cómo lo guardamos en una variable?",
        options: [
            "int resultado = nombreFuncion();",
            "int resultado = call nombreFuncion();",
            "nombreFuncion() = resultado;",
            "resultado = nombreFuncion;"
        ],
        correct: 0,
        explanation: "Para guardar el valor retornado por una función, usamos una variable del mismo tipo y asignamos el resultado de la llamada a la función. El valor retornado se asigna a la variable.",
        code: "int resultado = sumar(5, 3); // resultado = 8\nString saludo = crearSaludo(\"Juan\"); // saludo = \"Hola, Juan\""
    },
    {
        id: 13,
        question: "¿Qué significa la palabra static en una función?",
        options: [
            "Que la función pertenece a la clase y se puede llamar sin crear un objeto",
            "Que la función no se puede modificar",
            "Que la función siempre retorna el mismo valor",
            "Que la función es más rápida"
        ],
        correct: 0,
        explanation: "static significa que la función pertenece a la clase, no a una instancia específica. Por eso podemos llamarla directamente desde main sin crear un objeto de la clase.",
        code: "public class MiClase {\n    public static void miFuncion() { } // static: se llama sin objeto\n    public void otraFuncion() { } // no static: necesita objeto\n}"
    },
    {
        id: 14,
        question: "Si tenemos una función que recibe dos parámetros del mismo tipo, ¿cómo los declaramos?",
        options: [
            "public static void funcion(int a, int b) { }",
            "public static void funcion(int a, b) { }",
            "public static void funcion(int a; int b) { }",
            "public static void funcion(a int, b int) { }"
        ],
        correct: 0,
        explanation: "Cada parámetro debe tener su propio tipo declarado. Los parámetros se separan por comas, y cada uno tiene su tipo y nombre: int a, int b.",
        code: "public static int sumar(int a, int b) {\n    return a + b;\n}"
    },
    {
        id: 15,
        question: "¿Puede una función tener múltiples return?",
        options: [
            "Sí, pero solo se ejecuta uno (el primero que se alcanza)",
            "No, solo puede tener un return",
            "Sí, se ejecutan todos",
            "Solo si son del mismo tipo"
        ],
        correct: 0,
        explanation: "Una función puede tener múltiples return, pero solo se ejecuta el primero que se alcanza. Después de un return, la función termina inmediatamente. Esto es útil en funciones con if-else o switch.",
        code: "public static String evaluar(int numero) {\n    if (numero > 10) {\n        return \"Grande\"; // Si se ejecuta, la función termina aquí\n    }\n    return \"Pequeño\"; // Solo se ejecuta si el if es falso\n}"
    }
];

