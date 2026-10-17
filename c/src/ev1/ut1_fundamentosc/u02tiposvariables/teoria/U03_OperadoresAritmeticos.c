/*
U03 — Operadores aritmeticos.

OBJETIVO:
  - Usar los cinco operadores aritmeticos: + - * / %
  - Distinguir division entera (int/int) de division decimal (con double).
  - Entender el modulo (resto), incluso con negativos (C99: hacia cero).
  - Aplicar la precedencia y los parentesis.
  - Recordar que % NO existe para double (se usa fmod de <math.h>).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>   // fmod (en Linux: -lm)

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Los cinco operadores.
        +  suma      -  resta      *  multiplicacion
        /  division  %  modulo (resto de la division entera)
    */
    printf("--- PRIMERA PARTE: Operadores basicos ---\n\n");

    int a = 17, b = 5;
    printf("%d + %d = %d\n", a, b, a + b);
    printf("%d - %d = %d\n", a, b, a - b);
    printf("%d * %d = %d\n", a, b, a * b);
    printf("%d / %d = %d  (division entera)\n", a, b, a / b);
    printf("%d %% %d = %d  (resto)\n", a, b, a % b);

    /*
    SEGUNDA PARTE - Division entera y resto.
      La division entera NO redondea: se queda con la parte entera.
      Se cumple:  (a / b) * b + (a % b) == a
    */
    printf("\n--- SEGUNDA PARTE: Division entera y resto ---\n\n");

    printf("17 / 5 = %d y 17 %% 5 = %d -> 3*5 + 2 = 17\n", 17 / 5, 17 % 5);
    printf("Comprobacion: (a / b) * b + (a %% b) = %d\n", (a / b) * b + (a % b));

    /*
    TERCERA PARTE - Negativos (C99: trunca hacia cero; resto con signo del dividendo).
    */
    printf("\n--- TERCERA PARTE: Negativos ---\n\n");

    printf(" 7 /  2 = %d      7 %%  2 = %d\n", 7 / 2, 7 % 2);
    printf("-7 /  2 = %d     -7 %%  2 = %d\n", -7 / 2, -7 % 2);
    printf(" 7 / -2 = %d      7 %% -2 = %d\n", 7 / -2, 7 % -2);

    /*
    CUARTA PARTE - Usos tipicos del modulo.
      n % 2 == 0  -> par     n % 10 -> ultima cifra     (x+1)%7 -> ciclo
    */
    printf("\n--- CUARTA PARTE: Usos del modulo ---\n\n");

    int n = 4827;
    printf("%d es %s\n", n, n % 2 == 0 ? "par" : "impar");
    printf("Ultima cifra de %d: %d\n", n, n % 10);
    printf("%d sin la ultima cifra: %d\n", n, n / 10);

    int dia = 6;
    printf("Despues del dia %d viene el %d\n", dia, (dia + 1) % 7);

    int segundos = 3725;
    printf("%d segundos = %d h %d min %d s\n", segundos,
           segundos / 3600, (segundos % 3600) / 60, segundos % 60);

    /*
    QUINTA PARTE - Precedencia: ( ) -> * / % -> + -
      Ante la duda, usa parentesis.
    */
    printf("\n--- QUINTA PARTE: Precedencia ---\n\n");

    printf("2 + 3 * 4       = %d\n", 2 + 3 * 4);
    printf("(2 + 3) * 4     = %d\n", (2 + 3) * 4);
    printf("20 - 10 - 5     = %d (izquierda a derecha)\n", 20 - 10 - 5);
    printf("100 / 10 * 2    = %d\n", 100 / 10 * 2);
    printf("100 / (10 * 2)  = %d\n", 100 / (10 * 2));

    /*
    SEXTA PARTE - Reales: % no vale; usa fmod. Division decimal con un operando real.
    */
    printf("\n--- SEXTA PARTE: Reales ---\n\n");

    double x = 7.5, y = 2.0;
    printf("%.1f / %.1f = %.2f\n", x, y, x / y);
    printf("fmod(%.1f, %.1f) = %.2f\n", x, y, fmod(x, y));

    double precio = 19.99;
    int unidades = 3;
    printf("%d x %.2f = %.2f\n", unidades, precio, precio * unidades);

    /*
    SEPTIMA PARTE - Porcentajes: (3/4)*100 da 0 con enteros.
    */
    printf("\n--- SEPTIMA PARTE: Porcentajes ---\n\n");

    printf("(3 / 4) * 100   = %d (mal)\n", (3 / 4) * 100);
    printf("3 * 100 / 4     = %d (bien)\n", 3 * 100 / 4);
    printf("3 / 4.0 * 100   = %.1f (bien)\n", 3 / 4.0 * 100);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
