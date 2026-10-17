/*
E10 - Factorial recursivo (RESUELTO)

ENUNCIADO:
  Implementa long long factorial(int n) de forma recursiva (0! = 1, valido hasta n = 20).

PISTA:
  caso base: n <= 1

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


long long factorial(int n) {
    if (n <= 1) {
        return 1;
    }
    return n * factorial(n - 1);
}

int main(void) {
    PRUEBA(factorial(0) == 1);
    PRUEBA(factorial(1) == 1);
    PRUEBA(factorial(5) == 120);
    PRUEBA(factorial(10) == 3628800LL);
    PRUEBA(factorial(20) == 2432902008176640000LL);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
