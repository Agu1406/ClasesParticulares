/*
E06 - Encuentra el error: comparar doubles (RESUELTO)

ENUNCIADO:
  0.1 + 0.2 y 0.3 deben considerarse iguales. El programa dice que no lo son.
  Compara con una tolerancia.

EJEMPLO DE EJECUCION:
  Son iguales

PISTA:
  Usa fabs() de math.h y una tolerancia pequena (1e-9).

SOLUCION:
  Los doubles acumulan errores de redondeo: se comparan por diferencia.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>

int main(void) {
    double a = 0.1 + 0.2;
    double b = 0.3;
    if (fabs(a - b) < 1e-9) {
        printf("Son iguales\n");
    } else {
        printf("Son distintos\n");
    }
    return 0;
}
