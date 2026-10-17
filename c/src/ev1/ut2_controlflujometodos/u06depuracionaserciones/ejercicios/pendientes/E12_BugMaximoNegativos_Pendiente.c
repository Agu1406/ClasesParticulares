/*
E12 - Encuentra el error en el maximo (PENDIENTE)

ENUNCIADO:
  La funcion maximo(v, n) falla con arrays de numeros negativos. Encuentra por que y corrigela.

PISTA:
  Con que valor empieza la variable que guarda el maximo?

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


int maximo(const int *v, int n) {
    // TODO: inicializa bien el maximo
    int max = 0;
    for (int i = 1; i < n; i++) {
        if (v[i] > max) {
            max = v[i];
        }
    }
    return max;
}

int main(void) {
    int positivos[] = {3, 9, 4};
    int negativos[] = {-8, -3, -20};
    int mixto[] = {-1, 0, 5, -7};
    PRUEBA(maximo(positivos, 3) == 9);
    PRUEBA(maximo(negativos, 3) == -3);
    PRUEBA(maximo(mixto, 4) == 5);
    PRUEBA(maximo(negativos, 1) == -8);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
