/*
E05 - Maximo de tres numeros (PENDIENTE)

ENUNCIADO:
  Implementa int maximo3(int a, int b, int c) que devuelva el mayor de los tres.

PISTA:
  Reutiliza una funcion auxiliar maximo2

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


static int maximo2(int a, int b) {
    return a > b ? a : b;
}

int maximo3(int a, int b, int c) {
    // TODO: devuelve el mayor de a, b y c
    return 0;
}

int main(void) {
    PRUEBA(maximo3(1, 2, 3) == 3);
    PRUEBA(maximo3(9, 2, 3) == 9);
    PRUEBA(maximo3(4, 8, 3) == 8);
    PRUEBA(maximo3(-5, -2, -9) == -2);
    PRUEBA(maximo3(7, 7, 7) == 7);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
