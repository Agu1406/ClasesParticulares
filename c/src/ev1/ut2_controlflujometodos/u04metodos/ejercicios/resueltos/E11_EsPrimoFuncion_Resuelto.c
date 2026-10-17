/*
E11 - Funcion es_primo (RESUELTO)

ENUNCIADO:
  Implementa bool es_primo(int n) probando divisores hasta la raiz cuadrada.

PISTA:
  Los menores que 2 no son primos

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


bool es_primo(int n) {
    if (n < 2) {
        return false;
    }
    for (int d = 2; d * d <= n; d++) {
        if (n % d == 0) {
            return false;
        }
    }
    return true;
}

int main(void) {
    PRUEBA(!es_primo(0));
    PRUEBA(!es_primo(1));
    PRUEBA(es_primo(2));
    PRUEBA(es_primo(3));
    PRUEBA(!es_primo(9));
    PRUEBA(es_primo(97));
    PRUEBA(!es_primo(91));
    PRUEBA(es_primo(7919));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
