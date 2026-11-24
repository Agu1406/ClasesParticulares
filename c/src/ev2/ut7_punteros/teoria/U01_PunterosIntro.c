/*
U01 — Introduccion a punteros (esqueleto EV2).

OBJETIVO:
  - Ver que un puntero guarda una direccion (&).
  - Leer/escribir el valor apuntado (*).
  - Recordar NULL. El detalle vive en las siguientes lecciones de UT6.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int x = 10;
    int *p = &x;

    printf("x = %d\n", x);
    printf("direccion de x: %p\n", (void *)p);
    printf("*p = %d\n", *p);
    *p = 20;
    printf("tras *p = 20, x = %d\n", x);
    return 0;
}
