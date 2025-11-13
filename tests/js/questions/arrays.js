/**
 * Banco de preguntas sobre Arrays en Java
 * Basado en EjerciciosArrays1.java
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
        question: "Dados los arrays {1, 3, 5, 7, 8} y {1, 2, 3, 4, 5}, ¿cuál será el resultado de sumar ambos arrays posición a posición?",
        options: [
            "[2, 5, 8, 11, 13]",
            "[1, 5, 8, 11, 13]",
            "[2, 5, 8, 10, 13]",
            "[1, 3, 5, 7, 8, 1, 2, 3, 4, 5]"
        ],
        correct: 0,
        explanation: "Para sumar arrays posición a posición, se suman los elementos que están en la misma posición: 1+1=2, 3+2=5, 5+3=8, 7+4=11, 8+5=13. Es como sumar dos columnas de números, elemento por elemento.",
        code: "int[] array1 = {1, 3, 5, 7, 8};\nint[] array2 = {1, 2, 3, 4, 5};\n// resultado = {2, 5, 8, 11, 13}"
    },
    {
        id: 2,
        question: "Si queremos sumar solo las posiciones impares (índices 1, 3, 5...) de dos arrays, ¿qué condición debemos usar?",
        options: [
            "if (i % 2 == 0)",
            "if (i % 2 != 0)",
            "if (i > 0)",
            "if (i < array.length)"
        ],
        correct: 1,
        explanation: "Para identificar posiciones impares, usamos i % 2 != 0. Esto es porque cuando dividimos un número impar entre 2, el resto es 1 (diferente de 0). Por ejemplo, el índice 1, 3, 5 son impares.",
        code: "for (int i = 0; i < array.length; i++) {\n    if (i % 2 != 0) { // Posición impar\n        resultado[i] = array1[i] + array2[i];\n    }\n}"
    },
    {
        id: 3,
        question: "¿Cuál es la suma de todos los elementos del array {1, 4, 6, 10, -3, 4, 6, -5}?",
        options: [
            "23",
            "25",
            "27",
            "29"
        ],
        correct: 0,
        explanation: "Sumamos todos los elementos: 1 + 4 + 6 + 10 + (-3) + 4 + 6 + (-5) = 23. Recuerda que los números negativos se restan en la suma.",
        code: "int[] array = {1, 4, 6, 10, -3, 4, 6, -5};\nint suma = 0;\nfor (int i = 0; i < array.length; i++) {\n    suma += array[i];\n}"
    },
    {
        id: 4,
        question: "Para determinar si un número es par o impar en un array, ¿qué operación usamos?",
        options: [
            "array[i] / 2 == 0",
            "array[i] % 2 == 0",
            "array[i] * 2 == 0",
            "array[i] - 2 == 0"
        ],
        correct: 1,
        explanation: "Usamos el operador módulo (%). Si array[i] % 2 == 0, el número es par (el resto de dividir entre 2 es 0). Si el resto es 1, el número es impar. Es como verificar si al dividir entre 2 'sobra' algo.",
        code: "if (array[i] % 2 == 0) {\n    System.out.println(array[i] + \" es PAR\");\n} else {\n    System.out.println(array[i] + \" es IMPAR\");\n}"
    },
    {
        id: 5,
        question: "Si tenemos el array {2, 3, 4, 7, 8, 10, 11} y queremos crear dos arrays nuevos (uno con elementos menores de 6 y otro con mayores de 6), ¿cuántos elementos tendrá cada array?",
        options: [
            "Menores: 3, Mayores: 4",
            "Menores: 4, Mayores: 3",
            "Menores: 2, Mayores: 5",
            "Menores: 5, Mayores: 2"
        ],
        correct: 0,
        explanation: "Elementos menores de 6: 2, 3, 4 (3 elementos). Elementos mayores de 6: 7, 8, 10, 11 (4 elementos). El 6 no se incluye porque la condición es < 6 y > 6, no <= 6 ni >= 6.",
        code: "int[] array = {2, 3, 4, 7, 8, 10, 11};\n// menoresDe6 = {2, 3, 4} (3 elementos)\n// mayoresDe6 = {7, 8, 10, 11} (4 elementos)"
    },
    {
        id: 6,
        question: "Para filtrar un array y crear dos nuevos (pares e impares), ¿qué debemos hacer primero?",
        options: [
            "Crear los arrays directamente",
            "Contar cuántos elementos pares e impares hay",
            "Ordenar el array original",
            "Invertir el array original"
        ],
        correct: 1,
        explanation: "Primero debemos contar cuántos elementos pares e impares hay para saber el tamaño de los nuevos arrays. Luego creamos los arrays con ese tamaño y finalmente los llenamos. Es como saber cuántas cajas necesitas antes de comprarlas.",
        code: "// Paso 1: Contar\nint pares = 0, impares = 0;\nfor (int i = 0; i < array.length; i++) {\n    if (array[i] % 2 == 0) pares++;\n    else impares++;\n}\n// Paso 2: Crear arrays\nint[] arrayPares = new int[pares];\nint[] arrayImpares = new int[impares];"
    },
    {
        id: 7,
        question: "Si queremos intercalar ceros entre los elementos de un array {2, 3, 4, 7, 8, 10, 11}, ¿qué tamaño debe tener el nuevo array?",
        options: [
            "array.length",
            "array.length * 2",
            "array.length * 2 - 1",
            "array.length + 1"
        ],
        correct: 2,
        explanation: "Si intercalamos un cero entre cada elemento (pero no al final), el tamaño será array.length * 2 - 1. Por ejemplo, 7 elementos originales → 13 elementos (7 números + 6 ceros intercalados).",
        code: "int[] array = {2, 3, 4, 7, 8, 10, 11}; // 7 elementos\n// resultado = {2, 0, 3, 0, 4, 0, 7, 0, 8, 0, 10, 0, 11} // 13 elementos\nint[] resultado = new int[array.length * 2 - 1];"
    },
    {
        id: 8,
        question: "Si queremos multiplicar cada elemento de un array por potencias de 10 (primera posición por 10, segunda por 100, tercera por 1000...), ¿qué función usamos?",
        options: [
            "Math.random()",
            "Math.pow(10, i + 1)",
            "Math.sqrt(i)",
            "Math.abs(i)"
        ],
        correct: 1,
        explanation: "Math.pow(10, i + 1) calcula 10 elevado a (i+1). Para i=0 → 10^1=10, para i=1 → 10^2=100, para i=2 → 10^3=1000, etc. Es la forma de calcular potencias en Java.",
        code: "for (int i = 0; i < array.length; i++) {\n    int multiplicador = (int) Math.pow(10, i + 1);\n    resultado[i] = array[i] * multiplicador;\n}"
    },
    {
        id: 9,
        question: "Si multiplicamos dos arrays posición a posición {1, 3, 5, 7, 9} y {6, 4, 2, 1, 3}, y luego dividimos cada resultado entre 10, ¿cuál será el resultado en la primera posición?",
        options: [
            "0",
            "1",
            "6",
            "60"
        ],
        correct: 0,
        explanation: "Primera posición: 1 * 6 = 6, luego 6 / 10 = 0 (división entera en Java trunca el resultado). En Java, cuando divides dos enteros, el resultado es un entero, no un decimal.",
        code: "int[] array1 = {1, 3, 5, 7, 9};\nint[] array2 = {6, 4, 2, 1, 3};\n// resultado[0] = (1 * 6) / 10 = 6 / 10 = 0 (división entera)"
    },
    {
        id: 10,
        question: "¿Cuál es la forma más directa de convertir un array de caracteres {'P', 'a', 'l', 'a', 'b', 'r', 'a'} en un String?",
        options: [
            "String.valueOf(array)",
            "new String(array)",
            "array.toString()",
            "Arrays.toString(array)"
        ],
        correct: 1,
        explanation: "new String(array) es el constructor de String que acepta un array de caracteres y crea un String directamente. Es la forma más simple y directa de convertir un char[] a String.",
        code: "char[] array = {'P', 'a', 'l', 'a', 'b', 'r', 'a'};\nString palabra = new String(array);\n// palabra = \"Palabra\""
    },
    {
        id: 11,
        question: "¿Qué representa array.length en Java?",
        options: [
            "El último índice del array",
            "El número de elementos del array",
            "El tamaño en bytes del array",
            "El primer elemento del array"
        ],
        correct: 1,
        explanation: "array.length devuelve el número de elementos que contiene el array, no el último índice. Si un array tiene 5 elementos, length es 5, pero el último índice es 4 (porque los índices empiezan en 0).",
        code: "int[] array = {1, 2, 3, 4, 5};\n// array.length = 5\n// Último índice = 4"
    },
    {
        id: 12,
        question: "Si tenemos un array de tamaño 5, ¿cuál es el rango válido de índices?",
        options: [
            "0 a 5",
            "1 a 5",
            "0 a 4",
            "1 a 4"
        ],
        correct: 2,
        explanation: "En Java, los índices de un array siempre empiezan en 0. Si el array tiene tamaño 5, los índices válidos son 0, 1, 2, 3, 4. Intentar acceder al índice 5 daría un error ArrayIndexOutOfBoundsException.",
        code: "int[] array = new int[5];\n// Índices válidos: 0, 1, 2, 3, 4\n// array[0] ✓, array[4] ✓, array[5] ✗ (error)"
    },
    {
        id: 13,
        question: "¿Qué sucede si intentamos acceder a array[array.length]?",
        options: [
            "Obtiene el último elemento",
            "Obtiene el primer elemento",
            "Lanza una excepción ArrayIndexOutOfBoundsException",
            "Devuelve 0"
        ],
        correct: 2,
        explanation: "array[array.length] intenta acceder a un índice fuera del rango válido. Si length es 5, los índices válidos son 0-4, así que el índice 5 está fuera de rango y lanza ArrayIndexOutOfBoundsException.",
        code: "int[] array = new int[5];\n// array.length = 5\n// array[5] → ERROR: ArrayIndexOutOfBoundsException"
    },
    {
        id: 14,
        question: "Para crear un nuevo array con un tamaño específico, ¿qué sintaxis usamos?",
        options: [
            "int[] array = {tamaño};",
            "int[] array = new int[tamaño];",
            "int[] array = new int(tamaño);",
            "int[] array = tamaño;"
        ],
        correct: 1,
        explanation: "new int[tamaño] crea un nuevo array de enteros con el tamaño especificado. Todos los elementos se inicializan a 0 (para int). Es la forma estándar de crear arrays cuando no conocemos los valores iniciales.",
        code: "int[] array = new int[10];\n// Crea un array de 10 elementos, todos inicializados a 0"
    },
    {
        id: 15,
        question: "Si queremos copiar elementos de un array a otro usando un índice auxiliar, ¿qué debemos hacer después de copiar cada elemento?",
        options: [
            "Decrementar el índice",
            "Incrementar el índice",
            "Reiniciar el índice a 0",
            "No hacer nada"
        ],
        correct: 1,
        explanation: "Después de copiar un elemento a la posición actual del nuevo array, debemos incrementar el índice auxiliar para que apunte a la siguiente posición libre. Es como avanzar en una fila para ocupar el siguiente lugar.",
        code: "int indice = 0;\nfor (int i = 0; i < array.length; i++) {\n    if (condicion) {\n        nuevoArray[indice] = array[i];\n        indice++; // Avanzar al siguiente lugar\n    }\n}"
    },
    {
        id: 16,
        question: "¿Cuál es la diferencia entre array.length y array.length()?",
        options: [
            "No hay diferencia, ambos son iguales",
            "array.length es una propiedad, array.length() es un método",
            "array.length() no existe en Java",
            "array.length devuelve bytes, array.length() devuelve elementos"
        ],
        correct: 2,
        explanation: "array.length es una propiedad (no un método) que devuelve el tamaño del array. array.length() no existe en Java para arrays. length() es un método que existe para Strings, pero no para arrays.",
        code: "int[] array = {1, 2, 3};\nint tamaño = array.length; // ✓ Correcto\n// int tamaño = array.length(); // ✗ Error: no existe"
    },
    {
        id: 17,
        question: "Si tenemos dos arrays de diferente tamaño, ¿podemos sumarlos posición a posición?",
        options: [
            "Sí, siempre funciona",
            "Solo si el primer array es más grande",
            "Solo si tienen el mismo tamaño",
            "Solo si el segundo array es más grande"
        ],
        correct: 2,
        explanation: "Para sumar arrays posición a posición, ambos deben tener el mismo tamaño. Si tienen tamaños diferentes, necesitaríamos verificar el tamaño mínimo o manejar el caso especial. De lo contrario, obtendríamos un error al intentar acceder a índices que no existen.",
        code: "int[] array1 = {1, 2, 3}; // tamaño 3\nint[] array2 = {4, 5}; // tamaño 2\n// No se pueden sumar directamente sin verificar tamaños"
    },
    {
        id: 18,
        question: "¿Qué hace el operador += en el contexto de arrays?",
        options: [
            "Suma dos arrays",
            "Suma un valor a una variable y asigna el resultado",
            "Compara dos arrays",
            "Multiplica dos arrays"
        ],
        correct: 1,
        explanation: "El operador += es una forma abreviada. suma += array[i] es equivalente a suma = suma + array[i]. Suma el valor de array[i] a la variable suma y guarda el resultado en suma. Es muy útil para acumular valores.",
        code: "int suma = 0;\nfor (int i = 0; i < array.length; i++) {\n    suma += array[i]; // suma = suma + array[i]\n}"
    },
    {
        id: 19,
        question: "Si queremos crear un array con valores iniciales {2, 3, 4, 7, 8}, ¿qué sintaxis usamos?",
        options: [
            "int[] array = new int[]{2, 3, 4, 7, 8};",
            "int[] array = {2, 3, 4, 7, 8};",
            "Ambas opciones son válidas",
            "Ninguna de las anteriores"
        ],
        correct: 2,
        explanation: "Ambas sintaxis son válidas en Java. La forma corta {2, 3, 4, 7, 8} es más común y legible. La forma con new int[]{...} es más explícita y puede ser útil en ciertos contextos, pero ambas crean el mismo array.",
        code: "// Forma 1 (más común)\nint[] array = {2, 3, 4, 7, 8};\n// Forma 2 (también válida)\nint[] array = new int[]{2, 3, 4, 7, 8};"
    },
    {
        id: 20,
        question: "¿Qué tipo de dato devuelve array[i] % 2 cuando array[i] es un número par?",
        options: [
            "true",
            "false",
            "0",
            "1"
        ],
        correct: 2,
        explanation: "El operador % (módulo) devuelve el resto de la división. Cuando dividimos un número par entre 2, el resto es siempre 0. Por ejemplo: 4 % 2 = 0, 6 % 2 = 0, 8 % 2 = 0.",
        code: "int numero = 4;\nint resto = numero % 2; // resto = 0 (par)\nint numero2 = 5;\nint resto2 = numero2 % 2; // resto2 = 1 (impar)"
    }
];

