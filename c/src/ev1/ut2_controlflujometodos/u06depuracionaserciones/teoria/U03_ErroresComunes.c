/*
U03 - Catalogo de errores comunes en C (y como evitarlos).

OBJETIVO:
  - Reconocer los fallos mas frecuentes de un estudiante de C.
  - Ver la version correcta de cada uno y el motivo.
  - Activar los avisos del compilador (-Wall -Wextra) como primera defensa.

NOTA: los fallos peligrosos (acceso fuera de limites, variables sin inicializar,
punteros invalidos) NO se ejecutan aqui: se describen y se muestra la forma segura.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>
#include <limits.h>
#include <stdbool.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    ERROR 1 - Asignar (=) en vez de comparar (==).
        MAL:  if (x = 5)    -> pone x a 5 y siempre es verdadero.
        BIEN: if (x == 5)
      El compilador avisa con -Wall: "suggest parentheses around assignment".
    */
    printf("--- ERROR 1: = frente a == ---\n\n");

    int x = 3;
    if (x == 5) {
        printf("x vale 5\n");
    } else {
        printf("x no vale 5 (x = %d)\n", x);
    }

    /*
    ERROR 2 - Punto y coma despues de if/for/while.
        MAL:  if (x > 0);  { ... }   -> el if controla una sentencia vacia.
        BIEN: if (x > 0) { ... }
    */
    printf("\n--- ERROR 2: punto y coma sobrante ---\n\n");

    int n = -4;
    if (n > 0) {
        printf("n es positivo\n");
    }
    printf("(con un ; sobrante, aqui se mostraria 'n es positivo' siempre)\n");

    /*
    ERROR 3 - Division entera.
        MAL:  double m = (2 + 3) / 2;      -> 2.0
        BIEN: double m = (2 + 3) / 2.0;    -> 2.5
    */
    printf("\n--- ERROR 3: division entera ---\n\n");

    double mala = (2 + 3) / 2;
    double buena = (2 + 3) / 2.0;
    printf("mala = %.1f | buena = %.1f\n", mala, buena);

    /*
    ERROR 4 - Comparar doubles con ==.
        MAL:  if (0.1 + 0.2 == 0.3)
        BIEN: if (fabs((0.1 + 0.2) - 0.3) < 1e-9)
    */
    printf("\n--- ERROR 4: comparar doubles ---\n\n");

    double suma = 0.1 + 0.2;
    printf("0.1 + 0.2 == 0.3 ? %s\n", suma == 0.3 ? "si" : "no");
    printf("Con tolerancia    ? %s\n", fabs(suma - 0.3) < 1e-9 ? "si" : "no");

    /*
    ERROR 5 - Desbordamiento de enteros.
      int llega hasta INT_MAX (2147483647). Pasarse con signo es
      comportamiento indefinido. Usa un tipo mayor ANTES de operar.
        MAL:  long long r = a * b;               (a * b se hace en int)
        BIEN: long long r = (long long)a * b;
    */
    printf("\n--- ERROR 5: desbordamiento ---\n\n");

    int a = 2000000000;
    int b = 2;
    long long r = (long long)a * b;
    printf("%d * %d = %lld (INT_MAX = %d)\n", a, b, r, INT_MAX);

    /*
    ERROR 6 - Fuera de limites en un array (off-by-one).
        int v[5];  for (i = 0; i <= 5; i++)  -> v[5] no existe.
        BIEN: i < 5
      Los indices validos van de 0 a N-1.
    */
    printf("\n--- ERROR 6: indices de un array ---\n\n");

    int v[5] = {1, 2, 3, 4, 5};
    int total = 0;
    for (int i = 0; i < 5; i++) {
        total += v[i];
    }
    printf("Suma correcta = %d\n", total);

    /*
    ERROR 7 - Variable sin inicializar.
        MAL:  int s;  s += 5;     -> s contiene basura.
        BIEN: int s = 0;
    */
    printf("\n--- ERROR 7: sin inicializar ---\n\n");

    int s = 0;
    s += 5;
    printf("s = %d\n", s);

    /*
    ERROR 8 - switch sin break (fall-through accidental).
    */
    printf("\n--- ERROR 8: switch sin break ---\n\n");

    int dia = 2;
    switch (dia) {
        case 1: printf("Lunes\n"); break;
        case 2: printf("Martes\n"); break;
        default: printf("Otro dia\n"); break;
    }

    /*
    ERROR 9 - Formato incorrecto en scanf/printf.
        scanf("%f", &d)   con double d  -> MAL, hay que usar %lf
        printf("%d", 3.5)               -> MAL, hay que usar %f
        long long con %lld, size_t con %zu
    */
    printf("\n--- ERROR 9: formatos ---\n\n");

    long long grande = 9000000000LL;
    size_t tam = sizeof(grande);
    printf("grande = %lld, tam = %zu\n", grande, tam);

    /*
    ERROR 10 - Ignorar los avisos del compilador.
      Compila SIEMPRE con:  gcc -std=c11 -Wall -Wextra -pedantic
      Un aviso casi siempre es un fallo real. Objetivo: 0 avisos.
    */
    printf("\n--- ERROR 10: avisos ---\n\n");
    bool sin_avisos = true;
    printf("Objetivo: 0 avisos -> %s\n", sin_avisos ? "conseguido" : "pendiente");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
