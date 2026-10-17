/*
E16 - Cociente y resto con parametros de salida (RESUELTO)

ENUNCIADO:
  Implementa int dividir(int a, int b, int *cociente, int *resto): devuelve 0 si todo va bien y -1 si b es 0 (sin tocar los punteros).

PISTA:
  Devuelve un codigo de estado

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


int dividir(int a, int b, int *cociente, int *resto) {
    if (b == 0) {
        return -1;
    }
    *cociente = a / b;
    *resto = a % b;
    return 0;
}

int main(void) {
    int c = -1, r = -1;
    PRUEBA(dividir(47, 6, &c, &r) == 0 && c == 7 && r == 5);
    PRUEBA(dividir(9, 3, &c, &r) == 0 && c == 3 && r == 0);
    c = 100; r = 100;
    PRUEBA(dividir(5, 0, &c, &r) == -1 && c == 100 && r == 100);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
