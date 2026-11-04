/**
 * Test C EV1 — opciones A–D barajadas en cada intento.
 * Temario: c/src/ev1 (UT1 + UT2 u01–u03 bucles).
 * Plantilla: linux/ra3/tests/test_ra3_opciones_aleatorias.js
 */

const LETTERS = ["A", "B", "C", "D"];

/** @typedef {{ text: string, correct: boolean }} Option */
/** @typedef {{ q: string, options: Option[], sources: string[] }} Question */
/** @type {Question[]} */
const QUESTIONS = [
  {
    "q": "La estructura mínima de un programa C incluye:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "#include, int main(void) y return",
        "correct": true
      },
      {
        "text": "Solo namespace y cout",
        "correct": false
      },
      {
        "text": "public static void main sin include",
        "correct": false
      },
      {
        "text": "import java.io.*",
        "correct": false
      }
    ]
  },
  {
    "q": "Para usar printf en C debes incluir:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "<stdio.h>",
        "correct": true
      },
      {
        "text": "<iostream>",
        "correct": false
      },
      {
        "text": "<printf.h>",
        "correct": false
      },
      {
        "text": "<stdlib.h> siempre",
        "correct": false
      }
    ]
  },
  {
    "q": "El punto de entrada estándar de un programa C es:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "int main(void) o int main(int argc, char *argv[])",
        "correct": true
      },
      {
        "text": "void Main()",
        "correct": false
      },
      {
        "text": "public static void main",
        "correct": false
      },
      {
        "text": "start()",
        "correct": false
      }
    ]
  },
  {
    "q": "C es case-sensitive. ¿Cuál compila?",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "printf(...)",
        "correct": true
      },
      {
        "text": "Printf(...)",
        "correct": false
      },
      {
        "text": "PRINT(...)",
        "correct": false
      },
      {
        "text": "System.out.println",
        "correct": false
      }
    ]
  },
  {
    "q": "Cada instrucción ejecutable en C termina con:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "punto y coma (;)",
        "correct": true
      },
      {
        "text": "dos puntos (:)",
        "correct": false
      },
      {
        "text": "solo una llave",
        "correct": false
      },
      {
        "text": "nada obligatorio",
        "correct": false
      }
    ]
  },
  {
    "q": "El salto de línea en printf se escribe con:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "la secuencia \\n",
        "correct": true
      },
      {
        "text": "endl",
        "correct": false
      },
      {
        "text": "Enter automático de printf",
        "correct": false
      },
      {
        "text": "<br>",
        "correct": false
      }
    ]
  },
  {
    "q": "Compilar con gcc C11 y avisos recomendados:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog",
        "correct": true
      },
      {
        "text": "java fichero.c",
        "correct": false
      },
      {
        "text": "gcc sin flags siempre",
        "correct": false
      },
      {
        "text": "python fichero.c",
        "correct": false
      }
    ]
  },
  {
    "q": "return 0; al final de main indica:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "salida exitosa al sistema operativo",
        "correct": true
      },
      {
        "text": "error fatal",
        "correct": false
      },
      {
        "text": "fin del bucle for",
        "correct": false
      },
      {
        "text": "que no hay printf",
        "correct": false
      }
    ]
  },
  {
    "q": "Los comentarios de línea en C usan:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "//",
        "correct": true
      },
      {
        "text": "#",
        "correct": false
      },
      {
        "text": "solo /*",
        "correct": false
      },
      {
        "text": "--",
        "correct": false
      }
    ]
  },
  {
    "q": "Los comentarios de bloque van entre:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "/* y */",
        "correct": true
      },
      {
        "text": "<!-- -->",
        "correct": false
      },
      {
        "text": "{* *}",
        "correct": false
      },
      {
        "text": "[[ ]]",
        "correct": false
      }
    ]
  },
  {
    "q": "En C, el tipo para enteros habituales es:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "int",
        "correct": true
      },
      {
        "text": "string",
        "correct": false
      },
      {
        "text": "Integer",
        "correct": false
      },
      {
        "text": "number",
        "correct": false
      }
    ]
  },
  {
    "q": "Para valores con decimales suele usarse:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "double (o float)",
        "correct": true
      },
      {
        "text": "decimal",
        "correct": false
      },
      {
        "text": "real sin tipo",
        "correct": false
      },
      {
        "text": "number",
        "correct": false
      }
    ]
  },
  {
    "q": "El tipo bool en C requiere:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "#include <stdbool.h>",
        "correct": true
      },
      {
        "text": "import java.lang",
        "correct": false
      },
      {
        "text": "nada en C89",
        "correct": false
      },
      {
        "text": "#include <bool.h>",
        "correct": false
      }
    ]
  },
  {
    "q": "Un carácter literal se escribe:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "entre comillas simples, p. ej. 'A'",
        "correct": true
      },
      {
        "text": "siempre comillas dobles",
        "correct": false
      },
      {
        "text": "char()",
        "correct": false
      },
      {
        "text": "solo Java",
        "correct": false
      }
    ]
  },
  {
    "q": "const en una variable significa:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "no debe modificarse tras inicializarse",
        "correct": true
      },
      {
        "text": "vive en heap",
        "correct": false
      },
      {
        "text": "es global",
        "correct": false
      },
      {
        "text": "es puntero",
        "correct": false
      }
    ]
  },
  {
    "q": "#define MAX 100 crea:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "macro en preprocesado",
        "correct": true
      },
      {
        "text": "variable const int",
        "correct": false
      },
      {
        "text": "enum",
        "correct": false
      },
      {
        "text": "typedef",
        "correct": false
      }
    ]
  },
  {
    "q": "En C el texto se guarda como:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "array de char con '\\0' final",
        "correct": true
      },
      {
        "text": "clase String",
        "correct": false
      },
      {
        "text": "vector",
        "correct": false
      },
      {
        "text": "solo malloc",
        "correct": false
      }
    ]
  },
  {
    "q": "sizeof devuelve:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "tamaño en bytes del tipo o expresión",
        "correct": true
      },
      {
        "text": "longitud UTF-8",
        "correct": false
      },
      {
        "text": "valor máximo int",
        "correct": false
      },
      {
        "text": "siempre 4",
        "correct": false
      }
    ]
  },
  {
    "q": "(double)a / b con a,b enteros:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "fuerza división real",
        "correct": true
      },
      {
        "text": "igual que a/b entera",
        "correct": false
      },
      {
        "text": "error compile",
        "correct": false
      },
      {
        "text": "solo C++",
        "correct": false
      }
    ]
  },
  {
    "q": "Casteo (int)x:",
    "sources": [
      "Tipos"
    ],
    "options": [
      {
        "text": "convierte x a int en esa expresión",
        "correct": true
      },
      {
        "text": "declara x",
        "correct": false
      },
      {
        "text": "malloc",
        "correct": false
      },
      {
        "text": "scanf",
        "correct": false
      }
    ]
  },
  {
    "q": "scanf(\"%d\", &n) usa & porque:",
    "sources": [
      "Entrada"
    ],
    "options": [
      {
        "text": "scanf escribe en la variable del llamador",
        "correct": true
      },
      {
        "text": "decorativo",
        "correct": false
      },
      {
        "text": "solo strings",
        "correct": false
      },
      {
        "text": "printf lo exige",
        "correct": false
      }
    ]
  },
  {
    "q": "Leer entero con scanf:",
    "sources": [
      "Entrada"
    ],
    "options": [
      {
        "text": "%d",
        "correct": true
      },
      {
        "text": "%s",
        "correct": false
      },
      {
        "text": "%c obligatorio",
        "correct": false
      },
      {
        "text": "%f",
        "correct": false
      }
    ]
  },
  {
    "q": "Tras scanf mal usado el buffer puede:",
    "sources": [
      "Entrada"
    ],
    "options": [
      {
        "text": "quedar con '\\n' sin consumir",
        "correct": true
      },
      {
        "text": "cerrarse",
        "correct": false
      },
      {
        "text": "vacío siempre",
        "correct": false
      },
      {
        "text": "ir a stderr",
        "correct": false
      }
    ]
  },
  {
    "q": "fgets sirve para:",
    "sources": [
      "Entrada"
    ],
    "options": [
      {
        "text": "leer línea de texto con espacios (con límite)",
        "correct": true
      },
      {
        "text": "solo un char",
        "correct": false
      },
      {
        "text": "sin buffer",
        "correct": false
      },
      {
        "text": "solo ficheros binarios",
        "correct": false
      }
    ]
  },
  {
    "q": "Ventaja fgets vs scanf %s:",
    "sources": [
      "Entrada"
    ],
    "options": [
      {
        "text": "lee frases con espacios",
        "correct": true
      },
      {
        "text": "más rápido siempre",
        "correct": false
      },
      {
        "text": "no usa array",
        "correct": false
      },
      {
        "text": "devuelve int solo",
        "correct": false
      }
    ]
  },
  {
    "q": "Los comentarios:",
    "sources": [
      "Entrada"
    ],
    "options": [
      {
        "text": "documentan; el compilador los ignora",
        "correct": true
      },
      {
        "text": "aceleran CPU",
        "correct": false
      },
      {
        "text": "cifran",
        "correct": false
      },
      {
        "text": "quitan warnings siempre",
        "correct": false
      }
    ]
  },
  {
    "q": "Leer double con scanf:",
    "sources": [
      "Entrada"
    ],
    "options": [
      {
        "text": "%lf",
        "correct": true
      },
      {
        "text": "%d",
        "correct": false
      },
      {
        "text": "%s",
        "correct": false
      },
      {
        "text": "%c",
        "correct": false
      }
    ]
  },
  {
    "q": "Validar edad > 0 tras leer:",
    "sources": [
      "Entrada"
    ],
    "options": [
      {
        "text": "evita lógica absurda e bucles malos",
        "correct": true
      },
      {
        "text": "C valida solo",
        "correct": false
      },
      {
        "text": "solo Java",
        "correct": false
      },
      {
        "text": "scanf valida",
        "correct": false
      }
    ]
  },
  {
    "q": "% con enteros:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "resto de división entera",
        "correct": true
      },
      {
        "text": "porcentaje float",
        "correct": false
      },
      {
        "text": "potencia",
        "correct": false
      },
      {
        "text": "concatena",
        "correct": false
      }
    ]
  },
  {
    "q": "i++ vs ++i:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "post usa valor antes; pre incrementa antes",
        "correct": true
      },
      {
        "text": "idénticos",
        "correct": false
      },
      {
        "text": "solo for",
        "correct": false
      },
      {
        "text": "no compila",
        "correct": false
      }
    ]
  },
  {
    "q": "&& es:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "AND lógico cortocircuito",
        "correct": true
      },
      {
        "text": "OR",
        "correct": false
      },
      {
        "text": "XOR solo",
        "correct": false
      },
      {
        "text": "concatena",
        "correct": false
      }
    ]
  },
  {
    "q": "|| es:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "OR lógico",
        "correct": true
      },
      {
        "text": "AND",
        "correct": false
      },
      {
        "text": "NOT",
        "correct": false
      },
      {
        "text": "asignación",
        "correct": false
      }
    ]
  },
  {
    "q": "!x:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "negación lógica",
        "correct": true
      },
      {
        "text": "resta 1",
        "correct": false
      },
      {
        "text": "NOT bit siempre",
        "correct": false
      },
      {
        "text": "NULL solo",
        "correct": false
      }
    ]
  },
  {
    "q": "Multiplicación vs suma:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "multiplicación antes",
        "correct": true
      },
      {
        "text": "suma antes",
        "correct": false
      },
      {
        "text": "izquierda igual",
        "correct": false
      },
      {
        "text": "random",
        "correct": false
      }
    ]
  },
  {
    "q": "a += 3:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "a = a + 3",
        "correct": true
      },
      {
        "text": "a=3",
        "correct": false
      },
      {
        "text": "sin asignar",
        "correct": false
      },
      {
        "text": "solo bucles",
        "correct": false
      }
    ]
  },
  {
    "q": "Comparar doubles:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "tolerancia con fabs",
        "correct": true
      },
      {
        "text": "== siempre",
        "correct": false
      },
      {
        "text": "if =",
        "correct": false
      },
      {
        "text": "no comparar",
        "correct": false
      }
    ]
  },
  {
    "q": "sqrt en math.h en Linux:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "enlazar -lm a veces",
        "correct": true
      },
      {
        "text": "-ljava",
        "correct": false
      },
      {
        "text": "nunca flags",
        "correct": false
      },
      {
        "text": "solo Windows",
        "correct": false
      }
    ]
  },
  {
    "q": "& | ^ bit:",
    "sources": [
      "Operadores"
    ],
    "options": [
      {
        "text": "operan enteros; no confundir con && ||",
        "correct": true
      },
      {
        "text": "floats",
        "correct": false
      },
      {
        "text": "strings",
        "correct": false
      },
      {
        "text": "switch",
        "correct": false
      }
    ]
  },
  {
    "q": "Condición del if:",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "entre paréntesis",
        "correct": true
      },
      {
        "text": "solo llaves",
        "correct": false
      },
      {
        "text": "sin paréntesis",
        "correct": false
      },
      {
        "text": "tras else",
        "correct": false
      }
    ]
  },
  {
    "q": "if (x = 5) error:",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "asigna; debía ser ==",
        "correct": true
      },
      {
        "text": "correcto",
        "correct": false
      },
      {
        "text": "no compila",
        "correct": false
      },
      {
        "text": "solo switch",
        "correct": false
      }
    ]
  },
  {
    "q": "; tras if (cond):",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "puede vaciar el if (error clásico)",
        "correct": true
      },
      {
        "text": "obligatorio",
        "correct": false
      },
      {
        "text": "más rápido",
        "correct": false
      },
      {
        "text": "solo C++",
        "correct": false
      }
    ]
  },
  {
    "q": "else empareja con:",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "if más cercano sin else",
        "correct": true
      },
      {
        "text": "primer if",
        "correct": false
      },
      {
        "text": "switch",
        "correct": false
      },
      {
        "text": "while",
        "correct": false
      }
    ]
  },
  {
    "q": "switch compara:",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "igualdad con constantes enteras/char",
        "correct": true
      },
      {
        "text": "float ranges",
        "correct": false
      },
      {
        "text": "strings nativos",
        "correct": false
      },
      {
        "text": "bool solo",
        "correct": false
      }
    ]
  },
  {
    "q": "case suele llevar:",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "break para no caer al siguiente",
        "correct": true
      },
      {
        "text": "return siempre",
        "correct": false
      },
      {
        "text": "continue siempre",
        "correct": false
      },
      {
        "text": "goto",
        "correct": false
      }
    ]
  },
  {
    "q": "default:",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "si ningún case coincide",
        "correct": true
      },
      {
        "text": "solo error",
        "correct": false
      },
      {
        "text": "antes case",
        "correct": false
      },
      {
        "text": "obligatorio",
        "correct": false
      }
    ]
  },
  {
    "q": "Valor distinto de 0 en if:",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "verdadero",
        "correct": true
      },
      {
        "text": "falso",
        "correct": false
      },
      {
        "text": "error",
        "correct": false
      },
      {
        "text": "solo 1",
        "correct": false
      }
    ]
  },
  {
    "q": "else if sirve para:",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "varias ramas excluyentes",
        "correct": true
      },
      {
        "text": "bucles",
        "correct": false
      },
      {
        "text": "headers",
        "correct": false
      },
      {
        "text": "typedef",
        "correct": false
      }
    ]
  },
  {
    "q": "if anidado:",
    "sources": [
      "Condicionales"
    ],
    "options": [
      {
        "text": "if dentro de otro if",
        "correct": true
      },
      {
        "text": "dos main",
        "correct": false
      },
      {
        "text": "printf switch",
        "correct": false
      },
      {
        "text": "solo else",
        "correct": false
      }
    ]
  },
  {
    "q": "for: init se ejecuta:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "una vez al entrar",
        "correct": true
      },
      {
        "text": "cada vuelta final",
        "correct": false
      },
      {
        "text": "nunca",
        "correct": false
      },
      {
        "text": "si cond falsa",
        "correct": false
      }
    ]
  },
  {
    "q": "i++ en cabecera for:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "incrementa tras cada iteración",
        "correct": true
      },
      {
        "text": "decrementa",
        "correct": false
      },
      {
        "text": "una vez",
        "correct": false
      },
      {
        "text": "sustituye cuerpo",
        "correct": false
      }
    ]
  },
  {
    "q": "while evalúa cond:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "antes de cada vuelta",
        "correct": true
      },
      {
        "text": "después siempre",
        "correct": false
      },
      {
        "text": "una vez",
        "correct": false
      },
      {
        "text": "solo contador",
        "correct": false
      }
    ]
  },
  {
    "q": "do-while:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "cuerpo al menos una vez",
        "correct": true
      },
      {
        "text": "cero siempre",
        "correct": false
      },
      {
        "text": "solo arrays",
        "correct": false
      },
      {
        "text": "no con scanf",
        "correct": false
      }
    ]
  },
  {
    "q": "break:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "sale del bucle interno",
        "correct": true
      },
      {
        "text": "exit programa",
        "correct": false
      },
      {
        "text": "siguiente iteración",
        "correct": false
      },
      {
        "text": "solo switch",
        "correct": false
      }
    ]
  },
  {
    "q": "continue:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "salta al final de iteración actual",
        "correct": true
      },
      {
        "text": "exit",
        "correct": false
      },
      {
        "text": "break switch",
        "correct": false
      },
      {
        "text": "fclose",
        "correct": false
      }
    ]
  },
  {
    "q": "for anidado:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "tablas y patrones 2D",
        "correct": true
      },
      {
        "text": "error",
        "correct": false
      },
      {
        "text": "stdio",
        "correct": false
      },
      {
        "text": "dos main",
        "correct": false
      }
    ]
  },
  {
    "q": "Acumulador:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "suma valores en cada vuelta",
        "correct": true
      },
      {
        "text": "solo main",
        "correct": false
      },
      {
        "text": "igual contador",
        "correct": false
      },
      {
        "text": "prohibido while",
        "correct": false
      }
    ]
  },
  {
    "q": "for (int i=0; ...) C99:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "i solo en el bucle",
        "correct": true
      },
      {
        "text": "global",
        "correct": false
      },
      {
        "text": "no C11",
        "correct": false
      },
      {
        "text": "otro .c",
        "correct": false
      }
    ]
  },
  {
    "q": "for (i=10; i>=1; i--):",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "cuenta atrás 10..1",
        "correct": true
      },
      {
        "text": "solo 10",
        "correct": false
      },
      {
        "text": "infinito",
        "correct": false
      },
      {
        "text": "1..10",
        "correct": false
      }
    ]
  },
  {
    "q": "(double)a/b vs a/b enteros evita:",
    "sources": [
      "Tipos",
      "Operadores"
    ],
    "options": [
      {
        "text": "truncar la división",
        "correct": true
      },
      {
        "text": "overflow siempre",
        "correct": false
      },
      {
        "text": "error compile",
        "correct": false
      },
      {
        "text": "usar string",
        "correct": false
      }
    ]
  },
  {
    "q": "Leer y validar antes de switch:",
    "sources": [
      "Entrada",
      "Condicionales"
    ],
    "options": [
      {
        "text": "menu coherente con opciones válidas",
        "correct": true
      },
      {
        "text": "scanf basta",
        "correct": false
      },
      {
        "text": "no hace falta",
        "correct": false
      },
      {
        "text": "solo while",
        "correct": false
      }
    ]
  },
  {
    "q": "Contador en bucle:",
    "sources": [
      "Bucles"
    ],
    "options": [
      {
        "text": "cuenta vueltas o elementos",
        "correct": true
      },
      {
        "text": "solo acumulador",
        "correct": false
      },
      {
        "text": "main",
        "correct": false
      },
      {
        "text": "typedef",
        "correct": false
      }
    ]
  },
  {
    "q": "#include <stdio.h> falla si:",
    "sources": [
      "Entorno"
    ],
    "options": [
      {
        "text": "está mal escrito o falta",
        "correct": true
      },
      {
        "text": "hay comentarios",
        "correct": false
      },
      {
        "text": "usas for",
        "correct": false
      },
      {
        "text": "return 0",
        "correct": false
      }
    ]
  }
];

function shuffle(arr) {
  const a = arr.slice();
  for (let i = a.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [a[i], a[j]] = [a[j], a[i]];
  }
  return a;
}

const TOPICS = [
  { id: "Entorno", label: "Entorno y compilación", shortLabel: "Entorno" },
  { id: "Tipos", label: "Tipos y variables", shortLabel: "Tipos" },
  { id: "Entrada", label: "Entrada y comentarios", shortLabel: "Entrada" },
  { id: "Operadores", label: "Operadores", shortLabel: "Operadores" },
  { id: "Condicionales", label: "Condicionales", shortLabel: "If/Switch" },
  { id: "Bucles", label: "Bucles", shortLabel: "Bucles" },
];

let state = [];
let currentTopicId = TOPICS[0].id;

function getQuestionsForTopic(topicId) {
  return QUESTIONS.map((item, originalIndex) => ({ item, originalIndex })).filter(({ item }) =>
    (item.sources || []).includes(topicId)
  );
}

function escapeHtml(s) {
  return String(s)
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/"/g, "&quot;");
}

function getCorrectOptionText(item) {
  const o = item.options.find((x) => x.correct);
  return o ? o.text : "";
}

function buildInstantExplanation(item, isCorrect, chosenText) {
  const refs = (item.sources || []).join(", ");
  const correctText = getCorrectOptionText(item);
  const refHtml = refs
    ? `Según el temario <span class="font-medium text-emerald-300">${escapeHtml(refs)}</span> (c/src/ev1).`
    : "";
  if (isCorrect) {
    return (
      '<p class="font-semibold text-emerald-300">Correcto</p>' +
      (refHtml ? `<p class="mt-1.5 text-slate-300">${refHtml}</p>` : "") +
      '<p class="mt-2 border-t border-slate-700/80 pt-2 text-xs leading-relaxed text-slate-400 sm:text-sm"><span class="font-medium text-slate-400">Por qué:</span> «' +
      escapeHtml(correctText) +
      "».</p>"
    );
  }
  return (
    '<p class="font-semibold text-rose-300">Incorrecto</p>' +
    '<p class="mt-1.5 text-slate-300">Has elegido: «' +
    escapeHtml(chosenText) +
    "».</p>" +
    (refHtml
      ? `<p class="mt-2 text-slate-300">${refHtml} La respuesta correcta es:</p>`
      : '<p class="mt-2 text-slate-300">La respuesta correcta según el banco es:</p>') +
    '<p class="mt-1 rounded-lg bg-slate-950/60 px-2 py-1.5 text-sm text-slate-200">«' +
    escapeHtml(correctText) +
    "»</p>" +
    '<p class="mt-2 text-xs text-slate-500">Revisa el .c de teoría del subtema y vuelve a intentarlo.</p>'
  );
}

function renderCoverageSummary() {
  const el = document.getElementById("coverage");
  if (!el) return;
  const labels = TOPICS.map((t) => t.id);
  const counts = Object.fromEntries(labels.map((k) => [k, 0]));
  QUESTIONS.forEach((item) => {
    (item.sources || []).forEach((s) => {
      if (counts[s] !== undefined) counts[s] += 1;
    });
  });
  const parts = TOPICS.map(
    (t) => `<span class="font-semibold text-slate-300">${t.label}</span>: ${counts[t.id]}`
  );
  el.innerHTML =
    '<span class="font-semibold text-slate-200">Preguntas en el banco</span> (total ' +
    QUESTIONS.length +
    "): " +
    parts.join(" · ") +
    ". Cada tema muestra solo su subconjunto.";
}

function updateTopicHint() {
  const hint = document.getElementById("topicActiveHint");
  if (!hint) return;
  const topic = TOPICS.find((t) => t.id === currentTopicId);
  const n = getQuestionsForTopic(currentTopicId).length;
  hint.textContent = `Tema activo: ${topic ? topic.label : currentTopicId} — ${n} preguntas en este test.`;
}

function renderTopicBar() {
  const bar = document.getElementById("topicBar");
  if (!bar) return;
  bar.innerHTML = TOPICS.map((t) => {
    const n = getQuestionsForTopic(t.id).length;
    const shown = t.shortLabel || t.label;
    const aria = `${t.label}, ${n} preguntas`;
    return `<button type="button" role="tab" aria-selected="false" aria-label="${escapeHtml(aria)}" data-topic="${escapeHtml(t.id)}" class="topic-tab flex min-h-[4.25rem] w-full min-w-0 flex-col items-stretch justify-center rounded-xl border border-slate-700 bg-slate-900/70 px-2 py-2 text-left text-xs font-medium leading-snug text-slate-200 touch-manipulation transition hover:border-slate-500 hover:bg-slate-800 sm:min-h-0 sm:px-3 sm:py-2.5 sm:text-sm md:min-h-[3.5rem] md:min-w-[9.25rem] md:flex-1 md:px-3 lg:min-w-[10.5rem] active:scale-[0.98]"><span class="block break-words hyphens-auto">${escapeHtml(shown)}</span><span class="mt-1 block text-[10px] font-normal leading-tight text-slate-500 sm:text-xs">${n} preg.</span></button>`;
  }).join("");
  bar.querySelectorAll("[data-topic]").forEach((btn) => {
    btn.addEventListener("click", () => {
      const id = btn.getAttribute("data-topic");
      if (!id || id === currentTopicId) return;
      currentTopicId = id;
      syncTopicTabAria();
      updateTopicHint();
      buildQuiz();
    });
  });
  syncTopicTabAria();
}

function syncTopicTabAria() {
  const bar = document.getElementById("topicBar");
  if (!bar) return;
  bar.querySelectorAll("[data-topic]").forEach((btn) => {
    const id = btn.getAttribute("data-topic");
    const active = id === currentTopicId;
    btn.setAttribute("aria-selected", active ? "true" : "false");
    btn.classList.toggle("border-emerald-500", active);
    btn.classList.toggle("bg-emerald-950/50", active);
    btn.classList.toggle("ring-1", active);
    btn.classList.toggle("ring-emerald-500/40", active);
    btn.classList.toggle("text-emerald-100", active);
    btn.classList.toggle("border-slate-700", !active);
    btn.classList.toggle("bg-slate-900/70", !active);
    btn.classList.toggle("text-slate-200", !active);
  });
}

function clearCardResultStyles(card) {
  card.querySelectorAll("label.opt-row").forEach((lab) => {
    lab.classList.remove(
      "!border-emerald-500/70",
      "!bg-emerald-950/30",
      "!ring-1",
      "!ring-emerald-500/40",
      "!border-rose-500/70",
      "!bg-rose-950/30",
      "!ring-rose-500/40"
    );
    lab.classList.add("border-slate-700/80", "bg-slate-950/50");
  });
}

function applyCardResultStyles(card, selectedLabel, isCorrect) {
  clearCardResultStyles(card);
  selectedLabel.classList.remove("border-slate-700/80", "bg-slate-950/50");
  if (isCorrect) {
    selectedLabel.classList.add(
      "!border-emerald-500/70",
      "!bg-emerald-950/30",
      "!ring-1",
      "!ring-emerald-500/40"
    );
  } else {
    selectedLabel.classList.add(
      "!border-rose-500/70",
      "!bg-rose-950/30",
      "!ring-1",
      "!ring-rose-500/40"
    );
  }
}

function buildQuiz() {
  const form = document.getElementById("quiz");
  const fb = document.getElementById("feedback");
  if (!form || !fb) return;
  form.innerHTML = "";
  fb.classList.add("hidden");
  fb.className =
    "mt-4 hidden rounded-2xl border border-transparent p-4 text-sm leading-relaxed sm:p-5 sm:text-base";
  fb.textContent = "";
  const rows = getQuestionsForTopic(currentTopicId);
  state = rows.map(({ item, originalIndex }) => ({
    item,
    originalIndex,
    shuffled: shuffle(item.options),
  }));
  const total = state.length;
  state.forEach((row, slot) => {
    const { item, shuffled } = row;
    const card = document.createElement("div");
    card.className =
      "rounded-2xl border border-slate-800/90 bg-slate-900/40 p-3.5 shadow-sm sm:p-4";
    card.dataset.slot = String(slot);
    const num = document.createElement("div");
    num.className = "mb-1.5 text-[11px] font-medium uppercase tracking-wide text-slate-500 sm:text-xs";
    num.textContent = `Pregunta ${slot + 1} de ${total}`;
    const qt = document.createElement("div");
    qt.className =
      "mb-3 text-[15px] font-semibold leading-snug text-slate-100 sm:text-base sm:leading-snug";
    qt.textContent = item.q;
    const opts = document.createElement("div");
    opts.className = "flex flex-col gap-2";
    const name = `q_slot_${slot}`;
    shuffled.forEach((opt, oi) => {
      const id = `${name}_${oi}`;
      const label = document.createElement("label");
      label.className =
        "opt-row flex min-h-[3rem] cursor-pointer touch-manipulation items-start gap-3 rounded-xl border border-slate-700/80 bg-slate-950/50 p-3 transition has-[input:checked]:border-emerald-500/70 has-[input:checked]:bg-emerald-950/40 has-[input:checked]:ring-1 has-[input:checked]:ring-emerald-500/40 active:bg-slate-800/80 sm:min-h-0 sm:p-3.5";
      label.htmlFor = id;
      const radio = document.createElement("input");
      radio.type = "radio";
      radio.name = name;
      radio.id = id;
      radio.value = String(oi);
      radio.dataset.correct = opt.correct ? "1" : "0";
      radio.className =
        "mt-0.5 size-[1.125rem] shrink-0 accent-emerald-500 sm:mt-1 sm:size-4";
      const span = document.createElement("span");
      span.className = "flex-1 text-sm leading-snug text-slate-200 sm:text-[15px]";
      span.textContent = `${LETTERS[oi]}) ${opt.text}`;
      label.appendChild(radio);
      label.appendChild(span);
      opts.appendChild(label);
    });
    const instant = document.createElement("div");
    instant.className =
      "instant-feedback mt-3 hidden rounded-xl border border-slate-700/70 bg-slate-950/70 px-3 py-2.5 text-sm leading-relaxed sm:px-4 sm:py-3";
    instant.setAttribute("role", "status");
    card.appendChild(num);
    card.appendChild(qt);
    card.appendChild(opts);
    card.appendChild(instant);
    form.appendChild(card);
  });
  const stats = document.getElementById("stats");
  if (stats) stats.textContent = "";
}

function onQuizChange(ev) {
  const t = ev.target;
  if (!(t instanceof HTMLInputElement) || t.type !== "radio") return;
  const m = t.name.match(/^q_slot_(\d+)$/);
  if (!m) return;
  const slot = parseInt(m[1], 10);
  const row = state[slot];
  if (!row) return;
  const card = t.closest("[data-slot]");
  if (!card || !(card instanceof HTMLElement)) return;
  const oi = parseInt(t.value, 10);
  const chosen = row.shuffled[oi];
  if (!chosen) return;
  const isCorrect = chosen.correct === true;
  const labelEl = t.closest("label.opt-row");
  if (labelEl instanceof HTMLElement) applyCardResultStyles(card, labelEl, isCorrect);
  const box = card.querySelector(".instant-feedback");
  if (box) {
    box.classList.remove("hidden");
    box.innerHTML = buildInstantExplanation(row.item, isCorrect, chosen.text);
  }
}

function corregir() {
  const fb = document.getElementById("feedback");
  const form = document.getElementById("quiz");
  if (!fb || !form) return;
  let good = 0;
  const wrong = [];
  state.forEach((_, slot) => {
    const name = `q_slot_${slot}`;
    const picked = form.querySelector(`input[name="${name}"]:checked`);
    if (!picked) {
      wrong.push(slot + 1);
      return;
    }
    const isCorrect = picked.dataset.correct === "1";
    if (isCorrect) good++;
    else wrong.push(slot + 1);
  });
  const total = state.length;
  if (total === 0) {
    fb.classList.remove("hidden");
    fb.className =
      "mt-4 rounded-2xl border border-amber-500/45 bg-amber-950/30 p-4 text-sm text-amber-50";
    fb.textContent = "No hay preguntas en este tema.";
    return;
  }
  const pct = Math.round((good / total) * 100);
  fb.classList.remove("hidden");
  const ok = good === total;
  fb.className =
    "mt-4 rounded-2xl border p-4 text-sm leading-relaxed sm:p-5 sm:text-base " +
    (ok
      ? "border-emerald-500/45 bg-emerald-950/35 text-emerald-50"
      : "border-amber-500/45 bg-amber-950/30 text-amber-50");
  fb.innerHTML =
    '<strong class="font-semibold">' +
    "Resultado (tema actual):</strong> " +
    good +
    " / " +
    total +
    " acertadas (" +
    pct +
    "%).<br/>" +
    (wrong.length
      ? '<span class="mt-2 block text-sm text-slate-300/90">Sin responder o mal: números ' +
        wrong.join(", ") +
        ".</span>"
      : '<span class="mt-2 block text-sm text-emerald-200/90">Todas correctas en este tema.</span>");
  const stats = document.getElementById("stats");
  if (stats) {
    stats.textContent =
      good === total
        ? "Tema completado. Prueba otro tema o «Nuevo intento»."
        : "Revisa las tarjetas con feedback o «Nuevo intento» para barajar opciones.";
  }
}

function init() {
  renderCoverageSummary();
  renderTopicBar();
  updateTopicHint();
  buildQuiz();
  const form = document.getElementById("quiz");
  form?.addEventListener("change", onQuizChange);
  document.getElementById("btnCorregir")?.addEventListener("click", (e) => {
    e.preventDefault();
    corregir();
  });
  document.getElementById("btnNuevo")?.addEventListener("click", (e) => {
    e.preventDefault();
    buildQuiz();
  });
}

if (document.readyState === "loading") {
  document.addEventListener("DOMContentLoaded", init);
} else {
  init();
}
