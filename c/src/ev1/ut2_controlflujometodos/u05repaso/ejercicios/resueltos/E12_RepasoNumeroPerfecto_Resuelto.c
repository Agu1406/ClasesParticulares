/*
E12 - Numero perfecto (RESUELTO)

ENUNCIADO:
  Un numero es perfecto si es igual a la suma de sus divisores propios (sin contarse). Implementa int suma_divisores(int n) y bool es_perfecto(int n).

PISTA:
  Divisores propios de 6: 1, 2, 3

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


int suma_divisores(int n) {
    int suma = 0;
    for (int d = 1; d < n; d++) {
        if (n % d == 0) {
            suma += d;
        }
    }
    return suma;
}

bool es_perfecto(int n) {
    return n > 0 && suma_divisores(n) == n;
}

int main(void) {
    PRUEBA(suma_divisores(6) == 6);
    PRUEBA(suma_divisores(12) == 16);
    PRUEBA(suma_divisores(1) == 0);
    PRUEBA(es_perfecto(6));
    PRUEBA(es_perfecto(28));
    PRUEBA(es_perfecto(496));
    PRUEBA(!es_perfecto(12));
    PRUEBA(!es_perfecto(0));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
