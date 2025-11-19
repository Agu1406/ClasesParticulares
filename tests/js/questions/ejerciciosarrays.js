/**
 * Banco de preguntas sobre Arrays en Java
 * Basado en d_ejerciciosarrays
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
        question: "Si tenemos int[] array = {4, 6, 5, 7, 2}, ¿cuántas 'cajitas' tiene el array?",
        options: [
            "5 cajitas",
            "4 cajitas",
            "6 cajitas",
            "3 cajitas"
        ],
        correct: 0,
        explanation: "El array tiene 5 elementos, es decir, 5 cajitas. Cada elemento ocupa una posición en el array. Los valores son [4][6][5][7][2] y las posiciones son [0][1][2][3][4].",
        code: "int[] array = {4, 6, 5, 7, 2};\n// Valores = [4][6][5][7][2]\n// Posiciones = [0][1][2][3][4]\n// Total: 5 cajitas"
    },
    {
        id: 2,
        question: "Si queremos mostrar todos los valores de un array usando un bucle for, ¿qué condición usamos?",
        options: [
            "for (int i = 0; i < array.length; i++)",
            "for (int i = 1; i <= array.length; i++)",
            "for (int i = 0; i <= array.length; i++)",
            "for (int i = 1; i < array.length; i++)"
        ],
        correct: 0,
        explanation: "Los índices de un array empiezan en 0, así que el bucle debe empezar en 0. La condición i < array.length asegura que no accedamos a un índice fuera de rango (el último índice es array.length - 1).",
        code: "int[] array = {4, 6, 5, 7, 2};\nfor (int i = 0; i < array.length; i++) {\n    System.out.println(array[i]);\n}"
    },
    {
        id: 3,
        question: "Si tenemos una función que recibe un array como parámetro, ¿cómo lo declaramos?",
        options: [
            "public static void mostrarArray(int[] array) { }",
            "public static void mostrarArray(int array) { }",
            "public static void mostrarArray(array int[]) { }",
            "public static void mostrarArray(int array[]) { }"
        ],
        correct: 0,
        explanation: "Para recibir un array como parámetro, usamos int[] array (tipo seguido de corchetes, luego nombre). También es válido int array[] pero la forma int[] array es más común y recomendada.",
        code: "public static void mostrarArray(int[] array) {\n    for (int i = 0; i < array.length; i++) {\n        System.out.println(array[i]);\n    }\n}"
    },
    {
        id: 4,
        question: "Si queremos sumar todos los elementos de un array, ¿qué hacemos dentro del bucle?",
        options: [
            "suma += array[i];",
            "suma = array[i];",
            "suma = suma + i;",
            "suma = array.length;"
        ],
        correct: 0,
        explanation: "Usamos suma += array[i] que es equivalente a suma = suma + array[i]. Esto acumula cada elemento del array en la variable suma. La variable suma debe iniciar en 0 antes del bucle.",
        code: "int[] array = {1, 2, 3, 4, 5};\nint suma = 0;\nfor (int i = 0; i < array.length; i++) {\n    suma += array[i]; // Acumula cada elemento\n}"
    },
    {
        id: 5,
        question: "Si tenemos un array bidimensional de 3x3, ¿cuántas filas y columnas tiene?",
        options: [
            "3 filas y 3 columnas",
            "3 filas y 2 columnas",
            "2 filas y 3 columnas",
            "9 filas y 9 columnas"
        ],
        correct: 0,
        explanation: "Un array bidimensional de 3x3 tiene 3 filas y 3 columnas, formando una tabla de 3x3 = 9 elementos en total. Se accede con array[fila][columna].",
        code: "int[][] array = new int[3][3];\n//          Columnas\n//          [0][1][2]\n// Fila [0] [ ][ ][ ]\n// Fila [1] [ ][ ][ ]\n// Fila [2] [ ][ ][ ]"
    },
    {
        id: 6,
        question: "Si queremos recorrer un array bidimensional, ¿cuántos bucles for necesitamos?",
        options: [
            "Dos bucles for anidados (uno para filas, otro para columnas)",
            "Un solo bucle for",
            "Tres bucles for",
            "No necesitamos bucles"
        ],
        correct: 0,
        explanation: "Para recorrer un array bidimensional necesitamos dos bucles for anidados: el bucle externo recorre las filas y el bucle interno recorre las columnas de cada fila.",
        code: "int[][] array = new int[3][3];\nfor (int fila = 0; fila < array.length; fila++) {\n    for (int columna = 0; columna < array[fila].length; columna++) {\n        System.out.println(array[fila][columna]);\n    }\n}"
    },
    {
        id: 7,
        question: "Si queremos mostrar solo los números mayores que 5 en un array, ¿qué condición usamos dentro del bucle?",
        options: [
            "if (array[i] > 5)",
            "if (i > 5)",
            "if (array.length > 5)",
            "if (array[i] < 5)"
        ],
        correct: 0,
        explanation: "Verificamos el valor del elemento del array (array[i]) y lo comparamos con 5. Si array[i] > 5, entonces mostramos ese elemento. No confundir con la posición i.",
        code: "int[] array = {2, 6, 4, 8, 3, 9};\nfor (int i = 0; i < array.length; i++) {\n    if (array[i] > 5) { // Si el valor es mayor que 5\n        System.out.println(array[i]);\n    }\n}"
    },
    {
        id: 8,
        question: "Si queremos sumar una fila específica de un array bidimensional, ¿cómo accedemos a los elementos?",
        options: [
            "array[fila][columna] donde fila es fija y columna varía en un bucle",
            "array[columna][fila]",
            "array[fila]",
            "array[columna]"
        ],
        correct: 0,
        explanation: "Para sumar una fila, fijamos el índice de la fila y hacemos variar el índice de la columna en un bucle. Por ejemplo, para la fila 0: array[0][0], array[0][1], array[0][2], etc.",
        code: "int fila = 0;\nint suma = 0;\nfor (int columna = 0; columna < array[fila].length; columna++) {\n    suma += array[fila][columna];\n}"
    },
    {
        id: 9,
        question: "Si queremos buscar el mayor elemento en un array, ¿qué estructura usamos?",
        options: [
            "Una variable mayor que inicia con array[0], luego comparamos con if en un bucle",
            "Solo un bucle for",
            "Solo un if",
            "Un switch"
        ],
        correct: 0,
        explanation: "Iniciamos una variable 'mayor' con el primer elemento del array. Luego, en un bucle, comparamos cada elemento con 'mayor' usando if. Si encontramos uno mayor, actualizamos 'mayor'.",
        code: "int[] array = {3, 7, 2, 9, 5};\nint mayor = array[0];\nfor (int i = 1; i < array.length; i++) {\n    if (array[i] > mayor) {\n        mayor = array[i];\n    }\n}"
    },
    {
        id: 10,
        question: "Si queremos contar cuántos números pares hay en un array bidimensional, ¿qué hacemos?",
        options: [
            "Dos bucles for anidados con un if que verifica array[fila][columna] % 2 == 0",
            "Un solo bucle for",
            "Solo un if",
            "Un switch"
        ],
        correct: 0,
        explanation: "Necesitamos recorrer todas las filas y columnas con bucles anidados. Dentro, verificamos si cada elemento es par usando array[fila][columna] % 2 == 0, y si es así, incrementamos un contador.",
        code: "int contador = 0;\nfor (int fila = 0; fila < array.length; fila++) {\n    for (int columna = 0; columna < array[fila].length; columna++) {\n        if (array[fila][columna] % 2 == 0) {\n            contador++;\n        }\n    }\n}"
    },
    {
        id: 11,
        question: "¿Qué representa array.length en un array unidimensional?",
        options: [
            "El número de elementos del array",
            "El último índice del array",
            "El tamaño en bytes",
            "El primer elemento"
        ],
        correct: 0,
        explanation: "array.length devuelve el número de elementos que tiene el array. Si un array tiene 5 elementos, length es 5. El último índice es length - 1 (porque los índices empiezan en 0).",
        code: "int[] array = {1, 2, 3, 4, 5};\n// array.length = 5\n// Último índice = 4"
    },
    {
        id: 12,
        question: "Si tenemos int[] array = new int[5], ¿qué valores tienen los elementos inicialmente?",
        options: [
            "Todos valen 0",
            "Todos valen null",
            "Tienen valores aleatorios",
            "Todos valen 5"
        ],
        correct: 0,
        explanation: "Cuando creas un array de enteros con new int[5], todos los elementos se inicializan automáticamente a 0. Para otros tipos: double a 0.0, boolean a false, objetos a null.",
        code: "int[] array = new int[5];\n// array = {0, 0, 0, 0, 0}"
    },
    {
        id: 13,
        question: "Si queremos crear un array con valores iniciales, ¿qué sintaxis usamos?",
        options: [
            "int[] array = {1, 2, 3, 4, 5};",
            "int[] array = new int{1, 2, 3, 4, 5};",
            "int[] array = [1, 2, 3, 4, 5];",
            "int[] array = (1, 2, 3, 4, 5);"
        ],
        correct: 0,
        explanation: "Para crear un array con valores iniciales, usamos llaves { } con los valores separados por comas. Java determina automáticamente el tamaño del array según la cantidad de valores.",
        code: "int[] array = {1, 2, 3, 4, 5};\n// Crea un array de tamaño 5 con esos valores"
    },
    {
        id: 14,
        question: "¿Qué sucede si intentamos acceder a array[array.length]?",
        options: [
            "Error ArrayIndexOutOfBoundsException",
            "Obtiene el último elemento",
            "Obtiene el primer elemento",
            "Devuelve 0"
        ],
        correct: 0,
        explanation: "array[array.length] intenta acceder a un índice fuera del rango válido. Si length es 5, los índices válidos son 0-4, así que el índice 5 está fuera de rango y lanza una excepción.",
        code: "int[] array = new int[5];\n// array.length = 5\n// array[5] → ERROR: ArrayIndexOutOfBoundsException"
    },
    {
        id: 15,
        question: "Si tenemos array[fila][columna] en un array bidimensional, ¿qué representa cada índice?",
        options: [
            "fila es la fila (vertical), columna es la columna (horizontal)",
            "fila es la columna, columna es la fila",
            "Ambos son lo mismo",
            "No importa el orden"
        ],
        correct: 0,
        explanation: "En array[fila][columna], el primer índice [fila] representa la fila (posición vertical, de arriba a abajo) y el segundo índice [columna] representa la columna (posición horizontal, de izquierda a derecha).",
        code: "int[][] array = new int[3][3];\n// array[0][1] = fila 0, columna 1\n// array[2][0] = fila 2, columna 0"
    }
];

