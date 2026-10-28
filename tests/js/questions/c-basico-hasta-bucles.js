/**
 * Banco del examen sorpresa de C: de cero hasta bucles.
 * Temario: c/src/ev1 UT1 (entorno, tipos, entrada) y UT2 hasta u03bucles.
 * No entra u04metodos (funciones), ni cadenas, ni struct.
 *
 * Cada pregunta:
 * - id: identificador unico
 * - question: enunciado
 * - options: cuatro opciones
 * - correct: indice de la correcta (0-3)
 * - explanation: por que esa es la respuesta, en el lenguaje de clase
 * - code: (opcional) fragmento que hay que leer
 */
const questions = [
    {
        id: 1,
        question: "¿Qué línea hace falta para que el compilador conozca printf?",
        options: [
            "#include <stdio.h>",
            "#include <string.h>",
            "import stdio;",
            "using namespace std;"
        ],
        correct: 0,
        explanation: "printf vive en la biblioteca de entrada y salida estándar. Su declaración está en <stdio.h> (STanDard Input Output). Sin ese include, en C11 gcc no sabe qué es printf. string.h es para cadenas, y las otras dos sintaxis son de Java y de C++.",
        code: "#include <stdio.h>\n\nint main(void) {\n    printf(\"Hola\\n\");\n    return 0;\n}"
    },
    {
        id: 2,
        question: "¿Qué escribe este programa en la pantalla?",
        options: [
            "HolaC",
            "Hola y luego C en la línea de abajo",
            "Hola C (con un espacio en medio)",
            "No compila, porque printf exige un \\n"
        ],
        correct: 0,
        explanation: "printf no añade el salto de línea solo. Si no escribes \\n, el siguiente printf se pega al anterior. Aquí no hay espacio ni salto, así que sale HolaC. Es el despiste más típico de la primera clase.",
        code: "printf(\"Hola\");\nprintf(\"C\");"
    },
    {
        id: 3,
        question: "¿Cuál de estas llamadas compila? C distingue mayúsculas de minúsculas.",
        options: [
            "printf(\"Hola\\n\");",
            "Printf(\"Hola\\n\");",
            "PRINTF(\"Hola\\n\");",
            "print(\"Hola\\n\");"
        ],
        correct: 0,
        explanation: "El nombre de la función es printf, todo en minúsculas. Printf, PRINTF o print son otros identificadores: el compilador no los conoce. Memoriza la palabra exacta, igual que main y return.",
        code: "printf(\"Hola\\n\"); /* solo esta forma */"
    },
    {
        id: 4,
        question: "¿Qué pasa si olvidas el punto y coma al final de una instrucción?",
        options: [
            "gcc se detiene: es un error de compilación",
            "El programa ignora esa línea y sigue",
            "C inserta el ; él solo",
            "Compila, y el fallo aparece al ejecutar"
        ],
        correct: 0,
        explanation: "En C el ; forma parte de la sintaxis: marca el fin de la instrucción. Si falta, gcc no genera el ejecutable. No es un aviso que puedas saltarte, ni un error que espere a la ejecución.",
        code: "printf(\"Hola\\n\") /* falta el ; */"
    },
    {
        id: 5,
        question: "En los programas de clase, ¿qué significa return 0; al final de main?",
        options: [
            "El programa terminó y avisa de que todo fue bien",
            "Imprime el número 0 en la pantalla",
            "Vuelve a empezar main desde la primera línea",
            "Borra las variables antes de salir"
        ],
        correct: 0,
        explanation: "main devuelve un código de salida al sistema operativo. 0 es el convenio de «terminé bien». No pinta nada: para pintar se usa printf. Otro valor (por ejemplo return 1;) se usa cuando hubo un error.",
        code: "int main(void) {\n    printf(\"Fin\\n\");\n    return 0;\n}"
    },
    {
        id: 6,
        question: "¿Cuál es el comando de clase para compilar un .c con avisos puestos?",
        options: [
            "gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm",
            "javac fichero.c",
            "python fichero.c",
            "gcc fichero.c --ejecutar"
        ],
        correct: 0,
        explanation: "Compilamos en C11 y con los avisos encendidos (-Wall -Wextra -pedantic) para cazar despistes antes del examen. -o prog pone nombre al ejecutable y -lm enlaza la biblioteca matemática por si usas math.h. javac y python son otros lenguajes.",
        code: "gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm\n./prog"
    },
    {
        id: 7,
        question: "¿Qué imprime este printf?",
        options: [
            "3",
            "3.5",
            "4",
            "3.50"
        ],
        correct: 0,
        explanation: "Los dos operandos son int, así que / hace división entera y se queda con la parte de abajo: 7/2 es 3, no 3.5. El %d encaja con un entero. Para ver el decimal hay que convertir al menos un operando: (double)a / b, e imprimir con %f.",
        code: "int a = 7;\nint b = 2;\nprintf(\"%d\", a / b);"
    },
    {
        id: 8,
        question: "¿Cómo se guarda una sola letra en un char?",
        options: [
            "char letra = 'A';",
            "char letra = \"A\";",
            "char letra = A;",
            "string letra = 'A';"
        ],
        correct: 0,
        explanation: "Un char es un carácter y va entre comillas simples: 'A'. Las comillas dobles son una cadena (varios char terminados en \\0), y no caben en un char. C no tiene un tipo string como Java. Sin comillas, A sería un nombre de variable.",
        code: "char letra = 'A';\nprintf(\"%c %d\\n\", letra, letra); /* A y su código ASCII */"
    },
    {
        id: 9,
        question: "Quieres imprimir la variable int edad. ¿Qué especificador va dentro de printf?",
        options: [
            "%d",
            "%s",
            "%f",
            "%lf"
        ],
        correct: 0,
        explanation: "%d (decimal) es para enteros int. %s es una cadena, %f un double o float, y %lf se usa sobre todo en scanf para un double. Si mezclas el especificador y el tipo, el valor que sale no es fiable.",
        code: "int edad = 26;\nprintf(\"Edad: %d\\n\", edad);"
    },
    {
        id: 10,
        question: "En el temario, ¿cómo se usa un valor verdadero o falso con nombre bool?",
        options: [
            "Se incluye <stdbool.h> y se usan true y false",
            "bool es una palabra de C y no hace falta ningún include",
            "Se escribe Boolean, con mayúscula, como en Java",
            "C no puede representar verdadero y falso"
        ],
        correct: 0,
        explanation: "En C el tipo bool no aparece solo: llega con <stdbool.h>. true vale 1 y false vale 0. En un if, cualquier número distinto de 0 cuenta como verdadero y el 0 como falso, aunque no uses bool.",
        code: "#include <stdbool.h>\n\nbool mayor = true;\nif (mayor) {\n    printf(\"si\\n\");\n}"
    },
    {
        id: 11,
        question: "¿Qué hace #define IVA 0.21 antes de main?",
        options: [
            "El preprocesador sustituye cada IVA por 0.21 antes de compilar",
            "Crea una variable double que luego puedes cambiar",
            "Obliga a que IVA sea un int",
            "Solo existe dentro de main"
        ],
        correct: 0,
        explanation: "#define no es una variable: el preprocesador copia el texto 0.21 allí donde escribiste IVA, y eso ocurre antes de que gcc compile. No tiene tipo. Si quieres un valor con tipo que no se pueda reasignar, en el temario se usa const.",
        code: "#define IVA 0.21\n\ndouble total = 100 * (1 + IVA);"
    },
    {
        id: 12,
        question: "Hay un int x = 0; y después esta condición. ¿Qué ocurre?",
        options: [
            "Asigna 5 a x y entra en el if, porque 5 es distinto de 0",
            "Compara x con 5 y no entra, porque x valía 0",
            "No compila: dentro de un if está prohibido usar =",
            "Entra solo si x ya valía 5 antes de esa línea"
        ],
        correct: 0,
        explanation: "Un solo = es asignación, no comparación. x = 5 guarda 5 en x y el if mira ese 5. Como no es 0, entra. La comparación es ==. Con -Wall gcc avisa, pero el programa compila y el fallo es de lógica: en el examen hay que leer el operador con calma.",
        code: "int x = 0;\nif (x = 5) {\n    printf(\"entro\\n\");\n}"
    },
    {
        id: 13,
        question: "¿Cuánto vale la expresión 10 % 3?",
        options: [
            "1",
            "3",
            "0",
            "3.33"
        ],
        correct: 0,
        explanation: "% es el resto de la división entera, no un porcentaje. 10 dividido entre 3 da 3 y sobra 1. Sirve para pares e impares (n % 2) y para la última cifra (n % 10).",
        code: "int resto = 10 % 3; /* 1 */"
    },
    {
        id: 14,
        question: "¿Cuánto vale r?",
        options: [
            "14",
            "20",
            "24",
            "9"
        ],
        correct: 0,
        explanation: "La multiplicación se hace antes que la suma. Primero 3 * 4 = 12 y después 2 + 12 = 14. No es (2 + 3) * 4. Si quieres otro orden, pon paréntesis: ellos ganan a * y a +.",
        code: "int r = 2 + 3 * 4;"
    },
    {
        id: 15,
        question: "¿Cuál es la forma correcta de leer un int con scanf?",
        options: [
            "scanf(\"%d\", &edad);",
            "scanf(\"%d\", edad);",
            "scanf(\"%s\", &edad);",
            "scanf(edad);"
        ],
        correct: 0,
        explanation: "scanf necesita la dirección de la variable para poder escribir dentro. Esa dirección se pide con &. Si pasas edad sin &, le das el valor, no el sitio donde guardarlo. %d tiene que coincidir con un int; %s sería una cadena.",
        code: "int edad;\nscanf(\"%d\", &edad);"
    },
    {
        id: 16,
        question: "¿Qué comentarios ignora el compilador de C?",
        options: [
            "// hasta el final de la línea, y /* ... */ en varias líneas",
            "# esto es un comentario",
            "<!-- comentario -->",
            "-- comentario al estilo SQL"
        ],
        correct: 0,
        explanation: "// comenta una línea y /* */ puede ocupar varias. El compilador los tira y no generan código. La almohadilla # empieza directivas del preprocesador (#include, #define), no comentarios. HTML y SQL usan otras marcas.",
        code: "// una línea\n/* varias\n   líneas */\nprintf(\"esto si se ejecuta\\n\");"
    },
    {
        id: 17,
        question: "¿Qué diferencia hay, en el temario, entre fgets y scanf con %s al leer texto?",
        options: [
            "fgets puede leer una frase con espacios; scanf %s se para en el primer espacio",
            "Hacen exactamente lo mismo",
            "scanf %s lee siempre la línea entera, espacios incluidos",
            "fgets solo sirve para números"
        ],
        correct: 0,
        explanation: "%s lee una palabra y se detiene en el espacio, el tabulador o el salto de línea. fgets lee una línea (con tope de caracteres) y por eso sirve para un nombre y apellidos. Ojo: fgets también se guarda el \\n del Enter.",
        code: "char frase[80];\nfgets(frase, 80, stdin);\n\nchar palabra[40];\nscanf(\"%s\", palabra);"
    },
    {
        id: 18,
        question: "¿Qué imprime este programa?",
        options: [
            "N",
            "P",
            "Z",
            "PN"
        ],
        correct: 0,
        explanation: "n vale -2. No es mayor que 0, así que se salta el primer printf. Tampoco es 0, así que se salta el else if. Cae en el else y escribe N. Solo se ejecuta una rama de una cadena if / else if / else.",
        code: "int n = -2;\nif (n > 0) printf(\"P\");\nelse if (n == 0) printf(\"Z\");\nelse printf(\"N\");"
    },
    {
        id: 19,
        question: "¿Qué imprime este switch?",
        options: [
            "bc",
            "b",
            "c",
            "d"
        ],
        correct: 0,
        explanation: "El switch salta al case 2 y, si no hay break, sigue hacia abajo: imprime b y también c, y el break de case 3 corta antes del default. A ese «seguir cayendo» se le llama fall-through. En el examen, el break que falta es la trampa clásica.",
        code: "int d = 2;\nswitch (d) {\n    case 1: printf(\"a\");\n    case 2: printf(\"b\");\n    case 3: printf(\"c\"); break;\n    default: printf(\"d\");\n}"
    },
    {
        id: 20,
        question: "En un if de C, ¿cuál de estos valores es falso?",
        options: [
            "0",
            "1",
            "-1",
            "2"
        ],
        correct: 0,
        explanation: "Solo el 0 es falso. Cualquier otro número, también el -1 y el 2, es verdadero. Por eso if (x = 5) entra: cinco no es cero. No hace falta comparar con true.",
        code: "if (0) printf(\"no\");\nelse printf(\"el cero es falso\\n\");"
    },
    {
        id: 21,
        question: "¿En qué orden trabaja un for?",
        options: [
            "Inicialización una vez; después condición, cuerpo y actualización, y se repite",
            "Primero la actualización, luego el cuerpo y al final la condición",
            "La condición se mira una sola vez, antes de entrar",
            "El cuerpo se ejecuta siempre una vez antes de mirar la condición"
        ],
        correct: 0,
        explanation: "La inicialización ocurre una sola vez. Luego, en cada vuelta: se mira la condición (si es falsa se acaba), se ejecuta el cuerpo y después la actualización, y se vuelve a la condición. Quien ejecuta el cuerpo antes de mirar nada es do-while, no for.",
        code: "for (int i = 1; i <= 5; i++) {\n    printf(\"%d\\n\", i);\n}"
    },
    {
        id: 22,
        question: "¿Cuánto vale s al salir del bucle?",
        options: [
            "10",
            "4",
            "6",
            "9"
        ],
        correct: 0,
        explanation: "s es un acumulador: empieza en 0 y en cada vuelta le suma i. i vale 1, 2, 3 y 4. 0+1+2+3+4 = 10. Cuando i pasa a 5 la condición i <= 4 ya es falsa y no se suma el 5.",
        code: "int s = 0;\nfor (int i = 1; i <= 4; i++) {\n    s += i;\n}"
    },
    {
        id: 23,
        question: "¿Qué imprime este bucle?",
        options: [
            "5",
            "No imprime nada",
            "56",
            "No compila"
        ],
        correct: 0,
        explanation: "do-while ejecuta el cuerpo y después mira la condición. Entra aunque i < 5 sea falso: imprime 5, i pasa a 6 y ahí sí se detiene. Un while con la misma condición no habría impreso nada, porque mira antes de entrar.",
        code: "int i = 5;\ndo {\n    printf(\"%d\", i);\n    i++;\n} while (i < 5);"
    },
    {
        id: 24,
        question: "¿Qué imprime este for?",
        options: [
            "013",
            "0123",
            "01",
            "23"
        ],
        correct: 0,
        explanation: "continue salta el resto del cuerpo de esa vuelta y pasa a la actualización. Cuando i es 2 no se ejecuta el printf, pero el bucle sigue: i pasa a 3 y ese sí se imprime. break, en cambio, habría cortado el bucle entero.",
        code: "for (int i = 0; i < 4; i++) {\n    if (i == 2) continue;\n    printf(\"%d\", i);\n}"
    }
];
