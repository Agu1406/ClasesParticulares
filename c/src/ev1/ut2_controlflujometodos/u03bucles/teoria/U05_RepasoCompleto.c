/*
U05 — Repaso de bucles: for, while, do-while y anidados.

OBJETIVO:
  - Comparar for / while / do-while en un solo programa.
  - Repasar acumuladores y un dibujo sencillo con anidados.
  - Dejar claro el puente a break / continue / centinela (u05repaso).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - for: cuantas vueltas sabes de antemano.
    */
    printf("--- PRIMERA PARTE: for ---\n\n");

    int suma = 0;
    for (int i = 1; i <= 5; i++) {
        suma += i;
        printf("%d ", i);
    }
    printf("-> suma 1..5 = %d\n", suma);

    /*
    SEGUNDA PARTE - while: repites mientras la condicion sea cierta.
    */
    printf("\n--- SEGUNDA PARTE: while ---\n\n");

    int n = 16;
    int pasos = 0;
    printf("Dividir %d entre 2 hasta llegar a 1: ", n);
    while (n > 1) {
        n /= 2;
        pasos++;
        printf("%d ", n);
    }
    printf("(%d pasos)\n", pasos);

    /*
    TERCERA PARTE - do-while: el cuerpo se ejecuta al menos una vez.
      Tipico en menus (detalle de menus grandes: u05repaso / u04metodos).
    */
    printf("\n--- TERCERA PARTE: do-while ---\n\n");

    int opcion;
    do {
        opcion = 0; /* en clase pediras con scanf; aqui fijamos 0 para no bloquear */
        printf("Menu demo: opcion=%d (0 = salir)\n", opcion);
    } while (opcion != 0);

    /*
    CUARTA PARTE - Anidados: tabla 1..3.
    */
    printf("\n--- CUARTA PARTE: anidados ---\n\n");

    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            printf("%d*%d=%2d  ", i, j, i * j);
        }
        printf("\n");
    }

    /*
    QUINTA PARTE - Que queda para u05repaso.
      break, continue, centinela (-1 / -999), acumuladores con lectura
      repetida y menus con teclado.
    */
    printf("\n--- QUINTA PARTE: Siguiente paso ---\n\n");
    printf("break / continue / centinela / menus: ver u05repaso.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
