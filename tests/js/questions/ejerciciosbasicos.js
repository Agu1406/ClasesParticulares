/**
 * Banco de preguntas sobre Ejercicios Básicos en Java
 * Basado en a_ejerciciosbasicos
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
        question: "Si tenemos dos variables: int a = 5; int b = 3; ¿cuál es el resultado de a + b?",
        options: [
            "8",
            "15",
            "2",
            "53"
        ],
        correct: 0,
        explanation: "La suma de 5 + 3 es 8. En Java, cuando sumas dos números enteros, obtienes su suma aritmética.",
        code: "int a = 5;\nint b = 3;\nint resultado = a + b; // resultado = 8"
    },
    {
        id: 2,
        question: "Si tenemos int a = 10; int b = 4; ¿cuál es el resultado de a - b?",
        options: [
            "6",
            "14",
            "40",
            "2.5"
        ],
        correct: 0,
        explanation: "La resta de 10 - 4 es 6. El operador - realiza la sustracción entre dos números.",
        code: "int a = 10;\nint b = 4;\nint resultado = a - b; // resultado = 6"
    },
    {
        id: 3,
        question: "Si tenemos int a = 6; int b = 7; ¿cuál es el resultado de a * b?",
        options: [
            "42",
            "13",
            "1",
            "67"
        ],
        correct: 0,
        explanation: "La multiplicación de 6 * 7 es 42. El operador * multiplica dos números.",
        code: "int a = 6;\nint b = 7;\nint resultado = a * b; // resultado = 42"
    },
    {
        id: 4,
        question: "Si tenemos int a = 15; int b = 3; ¿cuál es el resultado de a / b?",
        options: [
            "5",
            "12",
            "18",
            "45"
        ],
        correct: 0,
        explanation: "La división de 15 / 3 es 5. En Java, cuando divides dos enteros, el resultado es un entero (se trunca la parte decimal).",
        code: "int a = 15;\nint b = 3;\nint resultado = a / b; // resultado = 5"
    },
    {
        id: 5,
        question: "¿Cuál es la forma correcta de declarar una variable de tipo String en Java?",
        options: [
            "String nombre = \"Juan\";",
            "string nombre = \"Juan\";",
            "String nombre = 'Juan';",
            "String nombre = Juan;"
        ],
        correct: 0,
        explanation: "En Java, String se escribe con mayúscula inicial y los valores de texto van entre comillas dobles. Las comillas simples se usan solo para caracteres individuales (char).",
        code: "String nombre = \"Juan\";\nString apellido = \"Pérez\";"
    },
    {
        id: 6,
        question: "Si tenemos int a = 4; int b = 5; int c = 2; ¿cuál es el resultado de (a + b) * c?",
        options: [
            "18",
            "14",
            "13",
            "20"
        ],
        correct: 0,
        explanation: "Primero se resuelve el paréntesis: (4 + 5) = 9, luego se multiplica: 9 * 2 = 18. Los paréntesis tienen prioridad sobre la multiplicación.",
        code: "int a = 4;\nint b = 5;\nint c = 2;\nint resultado = (a + b) * c; // (4+5)*2 = 9*2 = 18"
    },
    {
        id: 7,
        question: "Si queremos calcular el área de un rectángulo con base = 5 y altura = 8, ¿cuál es la fórmula correcta?",
        options: [
            "int area = base * altura;",
            "int area = base + altura;",
            "int area = base / altura;",
            "int area = base - altura;"
        ],
        correct: 0,
        explanation: "El área de un rectángulo se calcula multiplicando la base por la altura. Es como contar cuántos cuadrados de 1x1 caben en el rectángulo.",
        code: "int base = 5;\nint altura = 8;\nint area = base * altura; // area = 40"
    },
    {
        id: 8,
        question: "Si queremos calcular el perímetro de un cuadrado con lado = 6, ¿cuál es la fórmula correcta?",
        options: [
            "int perimetro = lado * 4;",
            "int perimetro = lado + 4;",
            "int perimetro = lado * lado;",
            "int perimetro = lado / 4;"
        ],
        correct: 0,
        explanation: "El perímetro de un cuadrado es la suma de sus cuatro lados. Como todos los lados son iguales, multiplicamos el lado por 4.",
        code: "int lado = 6;\nint perimetro = lado * 4; // perimetro = 24"
    },
    {
        id: 9,
        question: "Si tenemos int a = 10; int b = 20; y queremos intercambiar sus valores usando una variable auxiliar, ¿cuál es el código correcto?",
        options: [
            "int aux = a; a = b; b = aux;",
            "a = b; b = a;",
            "int aux = b; b = a; a = aux;",
            "a = b;"
        ],
        correct: 0,
        explanation: "Para intercambiar valores necesitamos una variable auxiliar que guarde temporalmente uno de los valores. Primero guardamos 'a' en 'aux', luego asignamos 'b' a 'a', y finalmente 'aux' a 'b'.",
        code: "int a = 10;\nint b = 20;\nint aux = a; // aux = 10\na = b;        // a = 20\nb = aux;      // b = 10"
    },
    {
        id: 10,
        question: "¿Cuál es la diferencia entre int y double en Java?",
        options: [
            "int almacena números enteros, double almacena números decimales",
            "int almacena números decimales, double almacena números enteros",
            "Ambos almacenan lo mismo",
            "int es más grande que double"
        ],
        correct: 0,
        explanation: "int es para números enteros (sin decimales) como 5, 10, -3. double es para números decimales (con punto decimal) como 5.5, 10.25, -3.14.",
        code: "int numeroEntero = 5;\ndouble numeroDecimal = 5.5;"
    },
    {
        id: 11,
        question: "Si tenemos boolean esVerdadero = true; ¿qué valor tiene la variable?",
        options: [
            "true",
            "false",
            "1",
            "0"
        ],
        correct: 0,
        explanation: "Las variables boolean solo pueden tener dos valores: true (verdadero) o false (falso). No son números, son valores lógicos.",
        code: "boolean esVerdadero = true;\nboolean esFalso = false;"
    },
    {
        id: 12,
        question: "Si tenemos int resultado = 10 / 3; ¿cuál es el valor de resultado?",
        options: [
            "3",
            "3.33",
            "4",
            "Error"
        ],
        correct: 0,
        explanation: "En Java, cuando divides dos enteros, el resultado es un entero. 10 / 3 = 3 (se trunca la parte decimal, no se redondea). Si quisieras 3.33, necesitarías usar double.",
        code: "int resultado = 10 / 3; // resultado = 3 (división entera)\ndouble resultadoDecimal = 10.0 / 3.0; // resultadoDecimal = 3.33..."
    },
    {
        id: 13,
        question: "¿Cuál es el operador correcto para obtener el resto de una división?",
        options: [
            "%",
            "/",
            "*",
            "+"
        ],
        correct: 0,
        explanation: "El operador % (módulo) devuelve el resto de la división. Por ejemplo, 10 % 3 = 1 (porque 10 dividido entre 3 es 3 con resto 1).",
        code: "int resto = 10 % 3; // resto = 1\nint resto2 = 15 % 4; // resto2 = 3"
    },
    {
        id: 14,
        question: "Si tenemos String nombre = \"María\"; ¿cuál es el tipo de dato de la variable nombre?",
        options: [
            "String",
            "int",
            "char",
            "boolean"
        ],
        correct: 0,
        explanation: "String es el tipo de dato para almacenar texto (cadenas de caracteres). Se escribe con mayúscula inicial y puede contener múltiples caracteres.",
        code: "String nombre = \"María\";\nString apellido = \"García\";"
    },
    {
        id: 15,
        question: "¿Qué sucede si intentamos hacer int numero = 5.7; en Java?",
        options: [
            "Error de compilación: no se puede asignar un double a un int",
            "Se asigna 5.7 correctamente",
            "Se asigna 6 (redondeado)",
            "Se asigna 5 (truncado)"
        ],
        correct: 0,
        explanation: "Java no permite asignar un valor decimal (double) directamente a una variable int sin hacer un casting explícito. Esto genera un error de compilación para evitar pérdida de datos.",
        code: "// int numero = 5.7; // ERROR de compilación\nint numero = (int) 5.7; // Correcto: casting explícito, numero = 5"
    },
    {
        id: 16,
        question: "Si tenemos int a = 8; int b = 2; ¿cuál es el resultado de a / b?",
        options: [
            "4",
            "6",
            "10",
            "16"
        ],
        correct: 0,
        explanation: "La división de 8 / 2 es 4. Cuando divides dos enteros, obtienes un entero como resultado.",
        code: "int a = 8;\nint b = 2;\nint resultado = a / b; // resultado = 4"
    },
    {
        id: 17,
        question: "Si tenemos int a = 3; int b = 4; int c = 5; ¿cuál es el resultado de a + b * c?",
        options: [
            "23",
            "35",
            "60",
            "12"
        ],
        correct: 0,
        explanation: "La multiplicación tiene prioridad sobre la suma. Primero: b * c = 4 * 5 = 20, luego: a + 20 = 3 + 20 = 23.",
        code: "int a = 3;\nint b = 4;\nint c = 5;\nint resultado = a + b * c; // 3 + (4*5) = 3 + 20 = 23"
    },
    {
        id: 18,
        question: "¿Cuál es el resultado de 7 % 3?",
        options: [
            "1",
            "2",
            "3",
            "4"
        ],
        correct: 0,
        explanation: "El operador % devuelve el resto de la división. 7 dividido entre 3 es 2 con resto 1, así que 7 % 3 = 1.",
        code: "int resto = 7 % 3; // resto = 1"
    },
    {
        id: 19,
        question: "Si tenemos double precio = 19.99; ¿qué tipo de variable es precio?",
        options: [
            "double",
            "int",
            "String",
            "boolean"
        ],
        correct: 0,
        explanation: "double es el tipo de dato para números decimales. Puede almacenar valores como 19.99, 3.14, etc.",
        code: "double precio = 19.99;\ndouble pi = 3.14159;"
    },
    {
        id: 20,
        question: "Si queremos calcular el área de un rectángulo y guardarla en una variable, ¿qué tipo de variable debemos usar?",
        options: [
            "int o double (depende si queremos decimales)",
            "Solo String",
            "Solo boolean",
            "Solo char"
        ],
        correct: 0,
        explanation: "El área puede ser un número entero (int) si trabajamos con valores enteros, o decimal (double) si necesitamos precisión decimal. No puede ser String, boolean o char.",
        code: "int base = 5;\nint altura = 8;\nint area = base * altura; // area = 40 (int)\n// o\ndouble areaDecimal = 5.5 * 8.2; // areaDecimal = 45.1 (double)"
    },
    {
        id: 21,
        question: "Si tenemos char letra = 'A'; ¿qué tipo de dato es letra?",
        options: [
            "char",
            "String",
            "int",
            "boolean"
        ],
        correct: 0,
        explanation: "char es el tipo de dato para un solo carácter. Se escribe con comillas simples 'A', a diferencia de String que usa comillas dobles \"A\".",
        code: "char letra = 'A';\nchar numero = '5';"
    },
    {
        id: 22,
        question: "Si tenemos int a = 5; int b = 3; ¿cuál es el resultado de a * b + 2?",
        options: [
            "17",
            "16",
            "25",
            "10"
        ],
        correct: 0,
        explanation: "Primero se hace la multiplicación: a * b = 5 * 3 = 15, luego se suma: 15 + 2 = 17. La multiplicación tiene prioridad sobre la suma.",
        code: "int a = 5;\nint b = 3;\nint resultado = a * b + 2; // (5*3) + 2 = 15 + 2 = 17"
    },
    {
        id: 23,
        question: "Si tenemos int numero = 25; ¿cuál es el resultado de numero / 5?",
        options: [
            "5",
            "20",
            "30",
            "125"
        ],
        correct: 0,
        explanation: "La división de 25 / 5 es 5. Cuando divides dos enteros, obtienes un entero como resultado.",
        code: "int numero = 25;\nint resultado = numero / 5; // resultado = 5"
    },
    {
        id: 24,
        question: "¿Cuál es la diferencia entre 'A' y \"A\" en Java?",
        options: [
            "'A' es un char, \"A\" es un String",
            "No hay diferencia",
            "'A' es un String, \"A\" es un char",
            "Ambos son int"
        ],
        correct: 0,
        explanation: "Las comillas simples 'A' se usan para char (un solo carácter). Las comillas dobles \"A\" se usan para String (cadena de caracteres).",
        code: "char letra = 'A'; // char\nString texto = \"A\"; // String"
    },
    {
        id: 25,
        question: "Si tenemos int resultado = (10 + 5) * 2; ¿cuál es el valor de resultado?",
        options: [
            "30",
            "20",
            "25",
            "15"
        ],
        correct: 0,
        explanation: "Primero se resuelve el paréntesis: (10 + 5) = 15, luego se multiplica: 15 * 2 = 30. Los paréntesis tienen la máxima prioridad.",
        code: "int resultado = (10 + 5) * 2; // (15) * 2 = 30"
    }
];

