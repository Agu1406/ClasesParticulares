/*
E09 - Potencia con bucle y recursiva (PENDIENTE)

ENUNCIADO:
  Implementa long long potencia(int base, int exp) con un bucle y long long potencia_rec(int base, int exp) con recursion (exp >= 0).

PISTA:
  potencia_rec: caso base exp == 0

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
    // TODO: calcula con un for
    return 0;
}

long long potencia_rec(int base, int exp) {
    // TODO: calcula de forma recursiva
    return 0;
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
