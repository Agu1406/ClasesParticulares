/*
E07 - Conversor de moneda (RESUELTO)

ENUNCIADO:
  Implementa double euros_a_dolares(double euros, double cambio) con comprobacion: si los euros son negativos devuelve -1.

PISTA:
  Valida antes de calcular

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


double euros_a_dolares(double euros, double cambio) {
    if (euros < 0) {
        return -1;
    }
    return euros * cambio;
}

int main(void) {
    PRUEBA(euros_a_dolares(100, 1.10) > 109.99 && euros_a_dolares(100, 1.10) < 110.01);
    PRUEBA(euros_a_dolares(0, 1.10) == 0.0);
    PRUEBA(euros_a_dolares(-5, 1.10) == -1.0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
