/*
E17 - Invertir numero y capicua (RESUELTO)

ENUNCIADO:
  Implementa int invertir(int n) (n >= 0) y bool es_capicua(int n).

PISTA:
  es_capicua(n) compara n con invertir(n)

SOLUCION:
  Todas las pruebas deben mostrar OK.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


int invertir(int n) {
    int resultado = 0;
    while (n > 0) {
        resultado = resultado * 10 + n % 10;
        n /= 10;
    }
    return resultado;
}

bool es_capicua(int n) {
    return n == invertir(n);
}

int main(void) {
    PRUEBA(invertir(123) == 321);
    PRUEBA(invertir(1200) == 21);
    PRUEBA(invertir(0) == 0);
    PRUEBA(es_capicua(12321));
    PRUEBA(!es_capicua(1231));
    PRUEBA(es_capicua(7));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
