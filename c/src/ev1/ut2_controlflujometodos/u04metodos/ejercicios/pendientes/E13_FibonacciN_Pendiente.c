/*
E13 - Termino n de Fibonacci (PENDIENTE)

ENUNCIADO:
  Implementa long long fibonacci(int n) con un bucle (fib(0) = 0, fib(1) = 1).

PISTA:
  Guarda los dos ultimos terminos

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


long long fibonacci(int n) {
    // TODO: calcula el termino n con un bucle
    return 0;
}

int main(void) {
    PRUEBA(fibonacci(0) == 0);
    PRUEBA(fibonacci(1) == 1);
    PRUEBA(fibonacci(2) == 1);
    PRUEBA(fibonacci(10) == 55);
    PRUEBA(fibonacci(50) == 12586269025LL);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
