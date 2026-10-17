/*
E02 - Funcion que suma dos enteros (PENDIENTE)

ENUNCIADO:
  Implementa int sumar(int a, int b) que devuelva a + b.

PISTA:
  return a + b;

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


int sumar(int a, int b) {
    // TODO: devuelve la suma
    return 0;
}

int main(void) {
    PRUEBA(sumar(2, 3) == 5);
    PRUEBA(sumar(-4, 4) == 0);
    PRUEBA(sumar(0, 0) == 0);
    PRUEBA(sumar(100, -1) == 99);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
