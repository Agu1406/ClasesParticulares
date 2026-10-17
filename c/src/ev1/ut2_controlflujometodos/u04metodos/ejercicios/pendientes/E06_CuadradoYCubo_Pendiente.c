/*
E06 - Cuadrado y cubo (PENDIENTE)

ENUNCIADO:
  Implementa long cuadrado(int n) y long cubo(int n). Para el cubo, reutiliza cuadrado.

PISTA:
  cubo(n) = cuadrado(n) * n

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


long cuadrado(int n) {
    // TODO: devuelve n * n
    return 0;
}

long cubo(int n) {
    // TODO: devuelve n al cubo reutilizando cuadrado
    return 0;
}

int main(void) {
    PRUEBA(cuadrado(5) == 25);
    PRUEBA(cuadrado(-4) == 16);
    PRUEBA(cubo(3) == 27);
    PRUEBA(cubo(-2) == -8);
    PRUEBA(cubo(0) == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
