/*
U01 — Operadores y operaciones basicas (clase densa).

OBJETIVO:
  - Usar aritmeticos (+ - * / %), division entera vs decimal y modulo.
  - Repasar comparacion y logicos (resultado 0/1) antes de if/while.
  - Ver el ternario y que la asignacion tambien es una expresion.
  - Extras de C: sizeof y el operador coma en el for.

  Detalle de comparacion/logicos: tipos U04/U05. Aqui: demos de puente.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Aritmeticos con enteros.
      + suma  - resta  * producto  / cociente  % resto
      Si los dos son int, / descarta los decimales.
    */
    printf("--- PRIMERA PARTE: Aritmeticos (int) ---\n\n");

    int a = 17;
    int b = 5;
    printf("a = %d, b = %d\n", a, b);
    printf("Suma:     %d + %d = %d\n", a, b, a + b);
    printf("Resta:    %d - %d = %d\n", a, b, a - b);
    printf("Producto: %d * %d = %d\n", a, b, a * b);
    printf("Division: %d / %d = %d  (entera)\n", a, b, a / b);
    printf("Modulo:   %d %% %d = %d  (resto)\n", a, b, a % b);

    /*
    SEGUNDA PARTE - Division entera frente a decimal.
      Basta con que un operando sea double para conservar decimales.
    */
    printf("\n--- SEGUNDA PARTE: Entera frente a decimal ---\n\n");

    int total = 10;
    int personas = 3;
    printf("Repartir %d galletas entre %d personas:\n", total, personas);
    printf("  Entera:  %d galletas por persona\n", total / personas);
    printf("  Decimal: %.4f galletas por persona\n", total / (double)personas);

    double precio = 7.50;
    int unidades = 4;
    printf("Precio %.2f x %d = %.2f euros\n", precio, unidades, precio * unidades);

    /*
    TERCERA PARTE - Modulo en situaciones reales.
      En C99 el resto de negativos va hacia cero: -7 % 4 == -3.
    */
    printf("\n--- TERCERA PARTE: Modulo ---\n\n");

    int minutos = 127;
    printf("%d minutos = %d h y %d min\n", minutos, minutos / 60, minutos % 60);

    int numero = 14;
    printf("%d es par? %d\n", numero, numero % 2 == 0);
    numero = 7;
    printf("%d es par? %d\n", numero, numero % 2 == 0);
    printf("-7 %% 4 = %d  (resto con el signo del dividendo, hacia 0)\n", -7 % 4);

    /*
    CUARTA PARTE - Comparacion (repaso).
      == != < > <= >= producen 0 o 1. Detalle: tipos U04.
    */
    printf("\n--- CUARTA PARTE: Comparacion ---\n\n");

    int nota = 7;
    printf("nota >= 5  -> %d\n", nota >= 5);
    printf("nota == 10 -> %d\n", nota == 10);
    printf("nota != 0  -> %d\n", nota != 0);
    printf("3 > 2      -> %d\n", 3 > 2);

    /*
    QUINTA PARTE - Logicos y cortocircuito (repaso).
      && || !  Detalle: tipos U05.
      Si la izquierda de && es falsa, no se evalua la derecha (evita / 0).
    */
    printf("\n--- QUINTA PARTE: Logicos y cortocircuito ---\n\n");

    bool mayor_de_edad = true;
    bool tiene_entrada = false;
    printf("entra al concierto? %d\n", mayor_de_edad && tiene_entrada);
    printf("puede pasar alguien? %d\n", mayor_de_edad || tiene_entrada);
    printf("sin entrada? %d\n", !tiene_entrada);

    int numerador = 10;
    int denominador = 0;
    if (denominador != 0 && numerador / denominador > 1) {
        printf("division hecha\n");
    } else {
        printf("cortocircuito: denominador==0, no se divide\n");
    }
    denominador = 2;
    if (denominador != 0 && numerador / denominador > 1) {
        printf("con denominador=%d el cociente %d > 1\n",
               denominador, numerador / denominador);
    }

    /*
    SEXTA PARTE - Ternario: if-else que elige entre dos VALORES.
    */
    printf("\n--- SEXTA PARTE: Ternario ---\n\n");

    printf("Nota %d: %s\n", nota, nota >= 5 ? "Aprobado" : "Suspenso");
    int x = 12, y = 20;
    int mayor = x > y ? x : y;
    int menor = x < y ? x : y;
    printf("Entre %d y %d el mayor es %d y el menor es %d\n", x, y, mayor, menor);

    /*
    SEPTIMA PARTE - La asignacion es una expresion.
      a = b = 7 guarda 7 en b y ese mismo 7 en a.
    */
    printf("\n--- SEPTIMA PARTE: Expresiones ---\n\n");

    int p, q;
    p = q = 7;
    printf("p = %d, q = %d\n", p, q);
    printf("(p = 10) vale %d\n", (p = 10));
    printf("(3 > 2) vale %d\n", 3 > 2);

    /*
    OCTAVA PARTE - sizeof (solo C; no es una funcion).
      Se calcula en compilacion. Devuelve el tamano en bytes.
    */
    printf("\n--- OCTAVA PARTE: sizeof ---\n\n");

    double oferta = 9.99;
    printf("sizeof(double) = %lu, sizeof(oferta) = %lu, sizeof(int) = %lu\n",
           (unsigned long)sizeof(double),
           (unsigned long)sizeof(oferta),
           (unsigned long)sizeof(int));

    /*
    NOVENA PARTE - Operador coma (casi solo en el for).
      Evalua de izquierda a derecha y deja el valor de la ultima expresion.
    */
    printf("\n--- NOVENA PARTE: Coma en el for ---\n\n");

    for (int i = 0, j = 10; i < j; i += 3, j -= 3) {
        printf("i = %2d, j = %2d\n", i, j);
    }

    printf("\nSiguiente: asignacion e incremento (U02), precedencia (U03).\n");
    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
