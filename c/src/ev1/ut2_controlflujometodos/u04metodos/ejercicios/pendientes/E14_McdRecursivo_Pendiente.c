/*
E14 - MCD recursivo (Euclides) (PENDIENTE)

ENUNCIADO:
  Implementa int mcd(int a, int b) de forma recursiva y int mcm(int a, int b) usando mcd.

PISTA:
  mcd(a, b) = mcd(b, a % b); base: b == 0

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


int mcd(int a, int b) {
    // TODO: MCD recursivo
    return 0;
}

int mcm(int a, int b) {
    // TODO: minimo comun multiplo con mcd
    return 0;
}

int main(void) {
    PRUEBA(mcd(84, 36) == 12);
    PRUEBA(mcd(17, 5) == 1);
    PRUEBA(mcd(0, 9) == 9);
    PRUEBA(mcm(4, 6) == 12);
    PRUEBA(mcm(21, 6) == 42);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
