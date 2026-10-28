/**
 * Ficha de una asignatura en el portal.
 * La página del lenguaje la pinta como una línea de estaciones
 * (temario, simulacro, chuleta, examen y forma de estudiar).
 */

export interface SubjectProfile {
    languageId: string;
    eyebrow: string;
    headline: string;
    pitch: string;
    level: string;
    learn: string[];
    examTheory: string;
    examPractice: string;
    study: string[];
    faq: Array<{ q: string; a: string }>;
    /** Markdown de la chuleta de una hoja. */
    cheatSheet: string;
    /** Ruta interna del simulacro (/examen/...). */
    quizPath: string;
}

const C_SUBJECT: SubjectProfile = {
    languageId: "c",
    eyebrow: "C11 · EV1 · hasta bucles",
    headline: "C, desde la primera línea hasta los bucles",
    pitch:
        "Siete estaciones con el mismo orden que el temario de clase: programa, printf, tipos, operadores, entrada, condicionales y bucles. Cada una trae el código que se proyecta, los ejercicios del repo y lo que suele caer en el examen.",
    level: "Principiante",
    learn: [
        "Escribir y compilar un programa C11 con gcc, printf y return.",
        "Elegir int, double, char y bool, y no caer en la división entera.",
        "Leer con scanf y fgets, y distinguir = de ==.",
        "Trazar if, switch, for, while y do-while, incluidos break y continue.",
    ],
    examTheory:
        "Preguntas cortas y de «qué imprime este código»: especificadores, el 0 como único falso, = frente a ==, un switch sin break y un bucle con acumulador.",
    examPractice:
        "Escribir un programa corto: leer datos, decidir con if o switch y repetir con for o while. En este tramo no entran funciones, cadenas ni struct.",
    study: [
        "Haz una estación y, el mismo día, dos ejercicios pendientes de esa carpeta. El resuelto se abre después.",
        "En los «qué imprime», escribe el valor de cada variable vuelta a vuelta, en papel.",
        "Compila con -Wall. El aviso de un = dentro de un if es justo lo que el examen quiere que veas.",
        "Cuando termines las siete, haz el simulacro en modo estudio y después en modo examen.",
    ],
    faq: [
        {
            q: "¿Hasta dónde entra el examen sorpresa?",
            a: "Hasta bucles: UT1 completo y UT2 hasta u03bucles. Las funciones (u04metodos), las cadenas y los struct quedan fuera.",
        },
        {
            q: "¿Por qué el mismo test está en HTML y en esta página?",
            a: "Es el mismo banco de 24 preguntas. El HTML de tests/ es el sistema de siempre (examen y estudio). Aquí se hace sin salir del temario.",
        },
        {
            q: "¿Qué miro si no compila?",
            a: "El primer error de gcc, el ;, las mayúsculas de printf y el include de stdio.h. El ritual está en la estación 2.",
        },
    ],
    cheatSheet: `## Esqueleto

\`\`\`c
#include <stdio.h>

int main(void) {
    printf("Hola\\n");
    return 0;
}
\`\`\`

gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog -lm

## printf

%d int · %f real · %c char · %s cadena · %% un porcentaje · \\n salto · \\t tab

## Tipos

int edad = 26; · double altura = 1.76; · char letra = 'A';

7 / 2 vale 3. (double)7 / 2 vale 3.5. 'A' no es "A".

#include <stdbool.h> para bool. Solo 0 es falso.

const tiene tipo. #define sustituye texto.

## Operadores

% resto · == compara · = asigna · * / % antes que + -

## Entrada

scanf("%d", &edad); · scanf("%lf", &altura);

scanf %s lee una palabra. fgets(frase, 80, stdin) lee una línea.

## Condiciones

if / else if / else: una sola rama. if (x = 5) asigna.

switch sigue hacia abajo hasta un break.

## Bucles

for (inicio; condicion; actualizacion) mira antes de entrar.

while mira antes. do-while entra al menos una vez.

continue salta la vuelta. break sale del bucle más interno.
`,
    quizPath: "/examen/c-basico-bucles",
};

const SUBJECTS: SubjectProfile[] = [C_SUBJECT];

export function getSubjectByLanguage(languageId: string): SubjectProfile | undefined {
    return SUBJECTS.find((subject) => subject.languageId === languageId);
}
