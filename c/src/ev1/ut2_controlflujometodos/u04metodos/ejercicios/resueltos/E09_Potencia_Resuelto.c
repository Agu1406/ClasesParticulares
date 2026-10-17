/*
E09 - Potencia con bucle y recursiva (RESUELTO)

ENUNCIADO:
  Implementa long long potencia(int base, int exp) con un bucle y long long potencia_rec(int base, int exp) con recursion (exp >= 0).

PISTA:
  potencia_rec: caso base exp == 0

SOLUCION:
  Todas las pruebas deben mostrar OK.

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


long long potencia(int base, int exp) {
    long long r = 1;
    for (int i = 0; i < exp; i++) {
        r *= base;
    }
    return r;
}

long long potencia_rec(int base, int exp) {
    if (exp == 0) {
        return 1;
    }
    return base * potencia_rec(base, exp - 1);
}

int main(void) {
    PRUEBA(potencia(2, 10) == 1024);
    PRUEBA(potencia(5, 0) == 1);
    PRUEBA(potencia(-3, 3) == -27);
    PRUEBA(potencia_rec(2, 10) == 1024);
    PRUEBA(potencia_rec(7, 0) == 1);
    PRUEBA(potencia_rec(10, 9) == 1000000000LL);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
