/*
E18 - Signo y valor absoluto (RESUELTO)

ENUNCIADO:
  Implementa int signo(int n) (-1, 0 o 1) y int absoluto(int n) usando signo.

PISTA:
  absoluto(n) = n * signo(n)

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


int signo(int n) {
    if (n > 0) {
        return 1;
    }
    if (n < 0) {
        return -1;
    }
    return 0;
}

int absoluto(int n) {
    return n * signo(n);
}

int main(void) {
    PRUEBA(signo(25) == 1);
    PRUEBA(signo(-3) == -1);
    PRUEBA(signo(0) == 0);
    PRUEBA(absoluto(-8) == 8);
    PRUEBA(absoluto(8) == 8);
    PRUEBA(absoluto(0) == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
