/*
E11 - Encuentra el error en es_primo (RESUELTO)

ENUNCIADO:
  La funcion es_primo tiene un fallo y las pruebas no pasan. Usa printf o el depurador para encontrarlo.

PISTA:
  Piensa que pasa con n % d cuando d llega a valer n.

SOLUCION:
  Con d <= n siempre se llega a d == n, y n % n == 0, asi que ningun numero seria primo. Hay que parar antes (d * d <= n).

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
    PRUEBA(!es_primo(1));
    PRUEBA(es_primo(2));
    PRUEBA(es_primo(3));
    PRUEBA(!es_primo(4));
    PRUEBA(es_primo(13));
    PRUEBA(!es_primo(15));
    PRUEBA(es_primo(97));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
