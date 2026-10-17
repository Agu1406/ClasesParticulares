/*
E15 - Intercambiar con punteros (PENDIENTE)

ENUNCIADO:
  Implementa void intercambiar(int *a, int *b) y void ordenar2(int *menor, int *mayor) que deje menor <= mayor.

PISTA:
  aux = *a; *a = *b; *b = aux;

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


void intercambiar(int *a, int *b) {
    // TODO: intercambia los valores apuntados
    (void)a;
    (void)b;
}

void ordenar2(int *menor, int *mayor) {
    // TODO: si *menor > *mayor los intercambia
    (void)menor;
    (void)mayor;
}

int main(void) {
    int a = 3, b = 8;
    intercambiar(&a, &b);
    PRUEBA(a == 8 && b == 3);
    int x = 9, y = 2;
    ordenar2(&x, &y);
    PRUEBA(x == 2 && y == 9);
    int p = 1, q = 5;
    ordenar2(&p, &q);
    PRUEBA(p == 1 && q == 5);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
