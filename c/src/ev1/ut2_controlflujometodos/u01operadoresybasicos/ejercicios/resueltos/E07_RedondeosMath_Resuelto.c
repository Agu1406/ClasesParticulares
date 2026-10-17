/*
E07 - Redondeos con math.h (RESUELTO)

ENUNCIADO:
  Para el numero 7.5678 muestra floor, ceil, round y trunc, y despues el numero
  redondeado a 2 decimales (multiplica por 100, redondea y divide entre 100).

EJEMPLO DE EJECUCION:
  floor: 7
  ceil: 8
  round: 8
  trunc: 7
  2 decimales: 7.57

PISTA:
  round(x * 100) / 100 redondea a dos decimales.

SOLUCION:
  Se desplaza la coma, se redondea al entero y se vuelve a desplazar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>

int main(void) {
    double x = 7.5678;
    printf("floor: %.0f\n", floor(x));
    printf("ceil: %.0f\n", ceil(x));
    printf("round: %.0f\n", round(x));
    printf("trunc: %.0f\n", trunc(x));
    printf("2 decimales: %.2f\n", round(x * 100) / 100);
    return 0;
}
