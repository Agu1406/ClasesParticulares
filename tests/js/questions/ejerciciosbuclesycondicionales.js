/**
 * Banco de preguntas sobre Bucles y Condicionales en Java
 * Basado en b_ejerciciosbuclesycondicionales
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
        question: "¿Cuál es la sintaxis correcta de un bucle for que muestra los números del 1 al 10?",
        options: [
            "for (int i = 1; i <= 10; i++)",
            "for (int i = 1; i < 10; i++)",
            "for (int i = 0; i <= 10; i++)",
            "for (int i = 1; i == 10; i++)"
        ],
        correct: 0,
        explanation: "El bucle for correcto inicia en 1 (int i = 1), continúa mientras i sea menor o igual a 10 (i <= 10), e incrementa i en cada iteración (i++). Esto muestra los números del 1 al 10 inclusive.",
        code: "for (int i = 1; i <= 10; i++) {\n    System.out.println(i);\n}"
    },
    {
        id: 2,
        question: "¿Cuál es la diferencia principal entre un bucle for y un bucle while?",
        options: [
            "for se usa cuando sabemos cuántas veces iterar, while cuando no lo sabemos",
            "while es más rápido que for",
            "for solo funciona con números, while con cualquier tipo",
            "No hay diferencia"
        ],
        correct: 0,
        explanation: "El bucle for es ideal cuando sabemos de antemano cuántas veces queremos repetir algo (como contar del 1 al 10). El bucle while es mejor cuando la condición de parada depende de algo que puede cambiar durante la ejecución.",
        code: "// for: sabemos que queremos 10 iteraciones\nfor (int i = 0; i < 10; i++) { }\n\n// while: la condición puede cambiar\nwhile (condicion) { }"
    },
    {
        id: 3,
        question: "¿Cuántas veces se ejecuta el código dentro de un bucle do-while al menos?",
        options: [
            "Una vez",
            "Cero veces",
            "Dos veces",
            "Depende de la condición"
        ],
        correct: 0,
        explanation: "El bucle do-while siempre ejecuta el código al menos una vez, porque primero ejecuta el código y luego verifica la condición. A diferencia del while, que puede no ejecutarse nunca si la condición es falsa desde el inicio.",
        code: "do {\n    System.out.println(\"Se ejecuta al menos una vez\");\n} while (false); // Aunque la condición sea falsa, se ejecuta una vez"
    },
    {
        id: 4,
        question: "Si tenemos int numero = 7; y usamos if (numero > 10), ¿se ejecuta el código dentro del if?",
        options: [
            "No, porque 7 no es mayor que 10",
            "Sí, porque 7 es mayor que 10",
            "Sí, porque cualquier número es mayor que 10",
            "Depende del compilador"
        ],
        correct: 0,
        explanation: "La condición numero > 10 evalúa si 7 es mayor que 10, lo cual es falso. Por lo tanto, el código dentro del if no se ejecuta. Solo se ejecuta cuando la condición es verdadera.",
        code: "int numero = 7;\nif (numero > 10) {\n    // Este código NO se ejecuta\n    System.out.println(\"Mayor que 10\");\n}"
    },
    {
        id: 5,
        question: "Si queremos verificar si un número es par o impar, ¿qué condición usamos en un if-else?",
        options: [
            "if (numero % 2 == 0) { par } else { impar }",
            "if (numero / 2 == 0) { par } else { impar }",
            "if (numero * 2 == 0) { par } else { impar }",
            "if (numero - 2 == 0) { par } else { impar }"
        ],
        correct: 0,
        explanation: "Para verificar si un número es par, usamos el operador módulo (%). Si numero % 2 == 0, el número es par (el resto de dividir entre 2 es 0). Si no, es impar.",
        code: "int numero = 8;\nif (numero % 2 == 0) {\n    System.out.println(\"Par\");\n} else {\n    System.out.println(\"Impar\");\n}"
    },
    {
        id: 6,
        question: "Si tenemos int opcion = 3; y un switch con case 1, case 2, case 3, ¿qué case se ejecuta?",
        options: [
            "case 3",
            "case 1",
            "Todos los cases",
            "Ninguno"
        ],
        correct: 0,
        explanation: "El switch compara el valor de 'opcion' con cada case. Como opcion = 3, se ejecuta el case 3. El switch busca el case que coincida exactamente con el valor de la variable.",
        code: "int opcion = 3;\nswitch (opcion) {\n    case 1: System.out.println(\"Uno\"); break;\n    case 2: System.out.println(\"Dos\"); break;\n    case 3: System.out.println(\"Tres\"); break; // Este se ejecuta\n}"
    },
    {
        id: 7,
        question: "Si tenemos un bucle for que muestra solo los números pares del 1 al 20, ¿qué condición usamos dentro del bucle?",
        options: [
            "if (i % 2 == 0)",
            "if (i % 2 != 0)",
            "if (i > 10)",
            "if (i < 20)"
        ],
        correct: 0,
        explanation: "Para mostrar solo los números pares, verificamos si i % 2 == 0. Si el resto de dividir i entre 2 es 0, entonces i es par y lo mostramos.",
        code: "for (int i = 1; i <= 20; i++) {\n    if (i % 2 == 0) { // Si es par\n        System.out.println(i);\n    }\n}"
    },
    {
        id: 8,
        question: "Si tenemos un bucle while que cuenta del 1 al 15 y queremos mostrar 'par' o 'impar' según el número, ¿qué estructura usamos?",
        options: [
            "while con if-else dentro",
            "while con dos while dentro",
            "while con switch dentro",
            "Solo while sin condicionales"
        ],
        correct: 0,
        explanation: "Usamos un bucle while para contar, y dentro del bucle un if-else para verificar si el número es par o impar y mostrar el mensaje correspondiente.",
        code: "int i = 1;\nwhile (i <= 15) {\n    if (i % 2 == 0) {\n        System.out.println(\"par\");\n    } else {\n        System.out.println(\"impar\");\n    }\n    i++;\n}"
    },
    {
        id: 9,
        question: "Si tenemos un bucle for del 1 al 10 y dentro un switch, ¿cuántas veces se ejecuta el switch?",
        options: [
            "10 veces (una por cada iteración del for)",
            "1 vez",
            "2 veces",
            "Depende del case"
        ],
        correct: 0,
        explanation: "El switch se ejecuta en cada iteración del bucle for. Como el for itera 10 veces (del 1 al 10), el switch se ejecuta 10 veces, una vez por cada valor de i.",
        code: "for (int i = 1; i <= 10; i++) {\n    switch (i) {\n        case 1: System.out.println(\"Uno\"); break;\n        // ... se ejecuta 10 veces\n    }\n}"
    },
    {
        id: 10,
        question: "Si tenemos un bucle do-while que suma números del 1 al 10 pero solo los mayores que 5, ¿qué condición usamos?",
        options: [
            "do { if (i > 5) suma += i; i++; } while (i <= 10);",
            "do { suma += i; i++; } while (i > 5 && i <= 10);",
            "do { suma += i; } while (i <= 10);",
            "do { if (i < 5) suma += i; } while (i <= 10);"
        ],
        correct: 0,
        explanation: "Dentro del do-while, verificamos con un if si i > 5. Solo si es verdadero, sumamos i a la variable suma. Luego incrementamos i y verificamos si i <= 10 para continuar.",
        code: "int i = 1;\nint suma = 0;\ndo {\n    if (i > 5) { // Solo números mayores que 5\n        suma += i;\n    }\n    i++;\n} while (i <= 10);"
    },
    {
        id: 11,
        question: "¿Qué hace el operador ++ en un bucle?",
        options: [
            "Incrementa la variable en 1",
            "Decrementa la variable en 1",
            "Multiplica la variable por 2",
            "Divide la variable entre 2"
        ],
        correct: 0,
        explanation: "El operador ++ incrementa el valor de la variable en 1. Es equivalente a escribir variable = variable + 1. Es muy común en bucles para avanzar al siguiente valor.",
        code: "int i = 0;\ni++; // i ahora vale 1\ni++; // i ahora vale 2"
    },
    {
        id: 12,
        question: "Si tenemos int numero = 15; y usamos if-else para verificar si es mayor, igual o menor que 10, ¿cuántos if necesitamos?",
        options: [
            "if-else if-else (tres condiciones)",
            "Solo un if",
            "Dos if",
            "Cuatro if"
        ],
        correct: 0,
        explanation: "Para verificar tres casos (mayor, igual, menor), usamos if-else if-else. Primero verificamos si es mayor, luego si es igual, y finalmente el else cubre el caso de menor.",
        code: "int numero = 15;\nif (numero > 10) {\n    System.out.println(\"Mayor\");\n} else if (numero == 10) {\n    System.out.println(\"Igual\");\n} else {\n    System.out.println(\"Menor\");\n}"
    },
    {
        id: 13,
        question: "¿Qué sucede si olvidamos poner break; en un case de un switch?",
        options: [
            "Se ejecutan los cases siguientes hasta encontrar un break",
            "El switch no funciona",
            "Solo se ejecuta ese case",
            "Error de compilación"
        ],
        correct: 0,
        explanation: "Sin break, el switch continúa ejecutando los cases siguientes (fall-through). Esto puede ser útil en algunos casos, pero generalmente queremos poner break para que solo se ejecute el case correspondiente.",
        code: "switch (opcion) {\n    case 1: System.out.println(\"Uno\"); // Sin break\n    case 2: System.out.println(\"Dos\"); break; // Se ejecuta también case 1\n}"
    },
    {
        id: 14,
        question: "Si queremos que un bucle while se ejecute mientras una condición sea verdadera, ¿qué estructura usamos?",
        options: [
            "while (condicion) { código }",
            "while { condicion } (código)",
            "while (código) { condicion }",
            "while condicion código"
        ],
        correct: 0,
        explanation: "La sintaxis correcta es while (condicion) seguido del bloque de código entre llaves. El bucle se ejecuta mientras la condición sea verdadera.",
        code: "int i = 0;\nwhile (i < 10) { // Mientras i sea menor que 10\n    System.out.println(i);\n    i++;\n}"
    },
    {
        id: 15,
        question: "¿Cuál es la diferencia entre i++ y ++i?",
        options: [
            "i++ usa el valor y luego incrementa, ++i incrementa y luego usa el valor",
            "No hay diferencia",
            "i++ solo funciona en bucles",
            "++i es más rápido"
        ],
        correct: 0,
        explanation: "i++ (post-incremento) primero usa el valor actual de i y luego lo incrementa. ++i (pre-incremento) primero incrementa i y luego usa el nuevo valor. En bucles simples, ambos funcionan igual.",
        code: "int i = 5;\nint a = i++; // a = 5, i = 6\nint b = ++i; // b = 7, i = 7"
    },
    {
        id: 16,
        question: "Si tenemos un bucle for que va del 0 al 9, ¿cuántas veces se ejecuta?",
        options: [
            "10 veces",
            "9 veces",
            "8 veces",
            "11 veces"
        ],
        correct: 0,
        explanation: "Un bucle for (int i = 0; i < 10; i++) se ejecuta 10 veces: cuando i vale 0, 1, 2, 3, 4, 5, 6, 7, 8, 9. El bucle termina cuando i alcanza 10.",
        code: "for (int i = 0; i < 10; i++) {\n    // Se ejecuta 10 veces (i = 0 a 9)\n}"
    },
    {
        id: 17,
        question: "Si tenemos int numero = 0; while (numero < 5) { numero++; }, ¿cuántas veces se ejecuta el bucle?",
        options: [
            "5 veces",
            "4 veces",
            "6 veces",
            "Infinitas veces"
        ],
        correct: 0,
        explanation: "El bucle se ejecuta mientras numero < 5. Empieza en 0, y en cada iteración incrementa numero. Se ejecuta cuando numero vale 0, 1, 2, 3, 4 (5 veces en total).",
        code: "int numero = 0;\nwhile (numero < 5) {\n    numero++; // Se ejecuta 5 veces\n}"
    },
    {
        id: 18,
        question: "Si tenemos un switch con case 1, case 2, case 3 y default, y la variable vale 5, ¿qué case se ejecuta?",
        options: [
            "default",
            "case 1",
            "case 2",
            "Ninguno"
        ],
        correct: 0,
        explanation: "Si ningún case coincide con el valor (5), se ejecuta el case default. El default es opcional pero muy útil para manejar valores inesperados.",
        code: "int opcion = 5;\nswitch (opcion) {\n    case 1: System.out.println(\"Uno\"); break;\n    case 2: System.out.println(\"Dos\"); break;\n    case 3: System.out.println(\"Tres\"); break;\n    default: System.out.println(\"Otro\"); // Este se ejecuta\n}"
    },
    {
        id: 19,
        question: "Si queremos que un bucle for muestre los números del 10 al 1 (en orden descendente), ¿qué condición usamos?",
        options: [
            "for (int i = 10; i >= 1; i--)",
            "for (int i = 10; i <= 1; i++)",
            "for (int i = 1; i >= 10; i--)",
            "for (int i = 1; i <= 10; i++)"
        ],
        correct: 0,
        explanation: "Para contar hacia atrás, empezamos en 10, la condición es i >= 1 (mientras i sea mayor o igual a 1), y usamos i-- para decrementar en cada iteración.",
        code: "for (int i = 10; i >= 1; i--) {\n    System.out.println(i); // Muestra 10, 9, 8, ..., 1\n}"
    },
    {
        id: 20,
        question: "Si tenemos un bucle while que debe ejecutarse mientras una condición sea verdadera, ¿qué palabra clave usamos para salir del bucle antes de tiempo?",
        options: [
            "break",
            "continue",
            "return",
            "exit"
        ],
        correct: 0,
        explanation: "La palabra clave break termina el bucle inmediatamente, incluso si la condición del while sigue siendo verdadera. Es útil para salir del bucle cuando se cumple una condición especial.",
        code: "while (condicion) {\n    if (condicionEspecial) {\n        break; // Sale del bucle inmediatamente\n    }\n}"
    },
    {
        id: 21,
        question: "Si tenemos un bucle for del 1 al 100 y queremos mostrar solo los múltiplos de 5, ¿qué condición usamos?",
        options: [
            "if (i % 5 == 0)",
            "if (i % 5 != 0)",
            "if (i / 5 == 0)",
            "if (i * 5 == 0)"
        ],
        correct: 0,
        explanation: "Un número es múltiplo de 5 si al dividirlo entre 5 el resto es 0. Usamos i % 5 == 0 para verificar si i es múltiplo de 5.",
        code: "for (int i = 1; i <= 100; i++) {\n    if (i % 5 == 0) { // Si es múltiplo de 5\n        System.out.println(i);\n    }\n}"
    },
    {
        id: 22,
        question: "Si tenemos un if-else if-else anidado, ¿cuántos bloques de código pueden ejecutarse?",
        options: [
            "Solo uno (el primero cuya condición sea verdadera)",
            "Todos",
            "Dos",
            "Ninguno"
        ],
        correct: 0,
        explanation: "En una estructura if-else if-else, solo se ejecuta el primer bloque cuya condición sea verdadera. Una vez que se ejecuta uno, se salta el resto.",
        code: "if (condicion1) {\n    // Solo este se ejecuta si condicion1 es verdadera\n} else if (condicion2) {\n    // Solo este se ejecuta si condicion1 es falsa y condicion2 es verdadera\n} else {\n    // Solo este se ejecuta si ambas son falsas\n}"
    },
    {
        id: 23,
        question: "Si tenemos un bucle do-while que verifica si numero < 0, y numero inicia en 5, ¿cuántas veces se ejecuta?",
        options: [
            "Una vez (porque do-while siempre se ejecuta al menos una vez)",
            "Cero veces",
            "Infinitas veces",
            "Dos veces"
        ],
        correct: 0,
        explanation: "El do-while siempre ejecuta el código al menos una vez, incluso si la condición es falsa desde el inicio. Luego verifica la condición y si es falsa, termina.",
        code: "int numero = 5;\ndo {\n    System.out.println(numero); // Se ejecuta una vez\n    numero++;\n} while (numero < 0); // La condición es falsa, pero ya se ejecutó una vez"
    },
    {
        id: 24,
        question: "Si tenemos un bucle for que suma números del 1 al 10, ¿qué variable usamos para acumular la suma?",
        options: [
            "Una variable int suma que inicia en 0",
            "Una variable int suma que inicia en 1",
            "Una variable String suma",
            "No necesitamos variable"
        ],
        correct: 0,
        explanation: "Creamos una variable int suma = 0 antes del bucle. Dentro del bucle, acumulamos cada número con suma += i. Al final, suma contiene la suma total.",
        code: "int suma = 0;\nfor (int i = 1; i <= 10; i++) {\n    suma += i; // Acumula cada número\n}"
    },
    {
        id: 25,
        question: "Si queremos que un switch maneje múltiples valores con el mismo código, ¿cómo lo hacemos?",
        options: [
            "Poniendo varios case seguidos sin break entre ellos",
            "Usando varios switch",
            "Usando if-else",
            "No se puede hacer"
        ],
        correct: 0,
        explanation: "Podemos poner varios case seguidos sin break para que todos ejecuten el mismo código. Esto se llama 'fall-through' y es útil cuando varios valores necesitan la misma acción.",
        code: "switch (opcion) {\n    case 1:\n    case 2:\n    case 3:\n        System.out.println(\"Pequeño\"); // Se ejecuta para 1, 2 o 3\n        break;\n    default:\n        System.out.println(\"Otro\");\n}"
    }
];

