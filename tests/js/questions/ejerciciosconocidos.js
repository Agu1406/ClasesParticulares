/**
 * Banco de preguntas sobre Ejercicios Conocidos en Java
 * Basado en f_ejerciciosConocidos (arrays, juegos, prácticas)
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
        question: "En el juego de Piedra, Papel o Tijera, si el usuario elige Piedra (1) y la máquina elige Tijera (3), ¿quién gana?",
        options: [
            "Gana el usuario (Piedra gana a Tijera)",
            "Gana la máquina",
            "Empate",
            "Error"
        ],
        correct: 0,
        explanation: "Las reglas son: Piedra gana a Tijera, Papel gana a Piedra, Tijera gana a Papel. Como el usuario tiene Piedra y la máquina Tijera, gana el usuario.",
        code: "// Usuario: 1 (Piedra), Máquina: 3 (Tijera)\n// Piedra gana a Tijera → Gana usuario"
    },
    {
        id: 2,
        question: "En el juego del Ahorcado, si la palabra oculta es \"CASA\" y el usuario introduce la letra 'A', ¿qué sucede?",
        options: [
            "Se reemplazan los guiones en las posiciones donde está la 'A'",
            "Se cuenta como un fallo",
            "No sucede nada",
            "El juego termina"
        ],
        correct: 0,
        explanation: "Si la letra 'A' está en la palabra, se reemplazan los guiones (_) por 'A' en todas las posiciones donde aparece. En \"CASA\", la 'A' está en las posiciones 1 y 3.",
        code: "String palabra = \"CASA\";\nString oculta = \"_ _ _ _\";\n// Usuario introduce 'A'\n// Resultado: \"_ A _ A\""
    },
    {
        id: 3,
        question: "Si queremos dibujar un rectángulo hueco de base 5 y altura 3, ¿cuántos asteriscos hay en la primera fila?",
        options: [
            "5 asteriscos (todos los asteriscos)",
            "2 asteriscos (solo los extremos)",
            "3 asteriscos",
            "1 asterisco"
        ],
        correct: 0,
        explanation: "En un rectángulo hueco, la primera fila (y la última) tienen todos los asteriscos porque son los bordes. Las filas del medio solo tienen asteriscos en los extremos. Base 5 = 5 asteriscos en la primera fila.",
        code: "// Base 5, Altura 3\n*****  // Primera fila: 5 asteriscos\n*   *  // Fila media: 2 asteriscos (extremos)\n*****  // Última fila: 5 asteriscos"
    },
    {
        id: 4,
        question: "Si queremos dibujar un triángulo hueco, ¿qué condición debe cumplir la base?",
        options: [
            "Debe ser un número impar positivo",
            "Debe ser un número par",
            "Puede ser cualquier número",
            "Debe ser mayor que 10"
        ],
        correct: 0,
        explanation: "Para dibujar un triángulo hueco simétrico, la base debe ser impar. Esto permite tener un vértice central en la parte superior y mantener la simetría del triángulo.",
        code: "// Base válida: 5, 7, 9, 11... (impares)\n// Base inválida: 4, 6, 8... (pares)"
    },
    {
        id: 5,
        question: "Si tenemos dos arrays {1, 3, 5, 7, 8} y {1, 2, 3, 4, 5} y los sumamos posición a posición, ¿cuál es el resultado en la posición 2?",
        options: [
            "8 (5 + 3)",
            "5",
            "3",
            "10"
        ],
        correct: 0,
        explanation: "En la posición 2 (índice 2), el primer array tiene 5 y el segundo tiene 3. Sumamos: 5 + 3 = 8. Recordemos que los índices empiezan en 0, así que posición 2 = índice 2.",
        code: "int[] array1 = {1, 3, 5, 7, 8};\nint[] array2 = {1, 2, 3, 4, 5};\n// Posición 0: 1+1=2\n// Posición 1: 3+2=5\n// Posición 2: 5+3=8 ✓"
    },
    {
        id: 6,
        question: "Si queremos sumar solo las posiciones impares de un array, ¿qué condición usamos?",
        options: [
            "if (i % 2 != 0)",
            "if (i % 2 == 0)",
            "if (i > 0)",
            "if (i < array.length)"
        ],
        correct: 0,
        explanation: "Para identificar posiciones impares (índices 1, 3, 5...), usamos i % 2 != 0. Cuando dividimos un índice impar entre 2, el resto es 1 (diferente de 0).",
        code: "for (int i = 0; i < array.length; i++) {\n    if (i % 2 != 0) { // Posición impar\n        suma += array[i];\n    }\n}"
    },
    {
        id: 7,
        question: "Si tenemos el array {1, 4, 6, 10, -3, 4, 6, -5}, ¿cuál es la suma de todos sus elementos?",
        options: [
            "23",
            "25",
            "27",
            "29"
        ],
        correct: 0,
        explanation: "Sumamos todos los elementos: 1 + 4 + 6 + 10 + (-3) + 4 + 6 + (-5) = 23. Recuerda que los números negativos se restan en la suma.",
        code: "int[] array = {1, 4, 6, 10, -3, 4, 6, -5};\n// 1+4+6+10-3+4+6-5 = 23"
    },
    {
        id: 8,
        question: "Si queremos intercalar ceros entre los elementos de un array de 7 elementos, ¿qué tamaño debe tener el nuevo array?",
        options: [
            "13 (array.length * 2 - 1)",
            "14 (array.length * 2)",
            "8 (array.length + 1)",
            "7 (array.length)"
        ],
        correct: 0,
        explanation: "Si intercalamos un cero entre cada elemento (pero no al final), el tamaño será array.length * 2 - 1. Para 7 elementos: 7 números + 6 ceros intercalados = 13 elementos totales.",
        code: "int[] array = {2, 3, 4, 7, 8, 10, 11}; // 7 elementos\n// resultado = {2, 0, 3, 0, 4, 0, 7, 0, 8, 0, 10, 0, 11} // 13 elementos"
    },
    {
        id: 9,
        question: "Si queremos convertir un array de caracteres {'P', 'a', 'l', 'a', 'b', 'r', 'a'} en un String, ¿qué método usamos?",
        options: [
            "new String(array)",
            "String.valueOf(array)",
            "array.toString()",
            "Arrays.toString(array)"
        ],
        correct: 0,
        explanation: "new String(array) es el constructor de String que acepta un array de caracteres y crea un String directamente. Es la forma más simple y directa de convertir un char[] a String.",
        code: "char[] array = {'P', 'a', 'l', 'a', 'b', 'r', 'a'};\nString palabra = new String(array);\n// palabra = \"Palabra\""
    },
    {
        id: 10,
        question: "En el juego del Ahorcado, si el usuario tiene 5 fallos permitidos y ya ha fallado 3 veces, ¿cuántos fallos le quedan?",
        options: [
            "2 fallos restantes",
            "3 fallos restantes",
            "5 fallos restantes",
            "0 fallos restantes"
        ],
        correct: 0,
        explanation: "Si tiene 5 fallos permitidos y ya ha fallado 3 veces, le quedan 5 - 3 = 2 fallos restantes. El juego termina cuando se quedan sin fallos o cuando adivinan la palabra.",
        code: "int fallosPermitidos = 5;\nint fallosActuales = 3;\nint fallosRestantes = fallosPermitidos - fallosActuales; // 2"
    },
    {
        id: 11,
        question: "Si queremos multiplicar cada elemento de un array por potencias de 10 (primera posición por 10, segunda por 100...), ¿qué función usamos?",
        options: [
            "Math.pow(10, i + 1)",
            "Math.random()",
            "Math.sqrt(i)",
            "Math.abs(i)"
        ],
        correct: 0,
        explanation: "Math.pow(10, i + 1) calcula 10 elevado a (i+1). Para i=0 → 10^1=10, para i=1 → 10^2=100, para i=2 → 10^3=1000, etc. Es la forma de calcular potencias en Java.",
        code: "for (int i = 0; i < array.length; i++) {\n    int multiplicador = (int) Math.pow(10, i + 1);\n    resultado[i] = array[i] * multiplicador;\n}"
    },
    {
        id: 12,
        question: "Si multiplicamos dos arrays posición a posición {1, 3, 5} y {6, 4, 2}, y luego dividimos cada resultado entre 10, ¿cuál es el resultado en la primera posición?",
        options: [
            "0 (división entera: 6/10 = 0)",
            "1",
            "6",
            "60"
        ],
        correct: 0,
        explanation: "Primera posición: 1 * 6 = 6, luego 6 / 10 = 0 (división entera en Java trunca el resultado). En Java, cuando divides dos enteros, el resultado es un entero, no un decimal.",
        code: "int[] array1 = {1, 3, 5};\nint[] array2 = {6, 4, 2};\n// resultado[0] = (1 * 6) / 10 = 6 / 10 = 0 (división entera)"
    },
    {
        id: 13,
        question: "En el juego de Piedra, Papel o Tijera, si ambos eligen la misma opción, ¿qué sucede?",
        options: [
            "Empate",
            "Gana el usuario",
            "Gana la máquina",
            "Error"
        ],
        correct: 0,
        explanation: "Si ambos eligen la misma opción (por ejemplo, ambos eligen Piedra), es un empate. No hay ganador en esa ronda.",
        code: "// Usuario: 1 (Piedra), Máquina: 1 (Piedra)\n// Resultado: Empate"
    },
    {
        id: 14,
        question: "Si queremos filtrar un array y crear dos nuevos (pares e impares), ¿qué debemos hacer primero?",
        options: [
            "Contar cuántos elementos pares e impares hay",
            "Crear los arrays directamente",
            "Ordenar el array original",
            "Invertir el array original"
        ],
        correct: 0,
        explanation: "Primero debemos contar cuántos elementos pares e impares hay para saber el tamaño de los nuevos arrays. Luego creamos los arrays con ese tamaño y finalmente los llenamos.",
        code: "// Paso 1: Contar\nint pares = 0, impares = 0;\nfor (int i = 0; i < array.length; i++) {\n    if (array[i] % 2 == 0) pares++;\n    else impares++;\n}\n// Paso 2: Crear arrays con el tamaño correcto"
    },
    {
        id: 15,
        question: "En el juego del Ahorcado, ¿cuándo gana el usuario?",
        options: [
            "Cuando adivina todas las letras de la palabra (no quedan guiones)",
            "Cuando introduce 5 letras",
            "Cuando se queda sin fallos",
            "Nunca gana"
        ],
        correct: 0,
        explanation: "El usuario gana cuando adivina la palabra completa, es decir, cuando no quedan guiones (_) en la palabra oculta. Si se queda sin fallos antes de adivinar, pierde.",
        code: "String palabraOculta = \"_ A _ A\";\n// Usuario adivina todas las letras\n// palabraOculta = \"C A S A\"\n// No quedan guiones → Usuario gana"
    }
];

