/*
E18 - Signo y valor absoluto (PENDIENTE)

ENUNCIADO:
  Implementa int signo(int n) (-1, 0 o 1) y int absoluto(int n) usando signo.

PISTA:
  absoluto(n) = n * signo(n)

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
    // TODO: devuelve -1, 0 o 1
    return 2;
}

int absoluto(int n) {
    // TODO: devuelve el valor absoluto usando signo
    return -1;
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
