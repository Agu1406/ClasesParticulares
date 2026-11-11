/*
E20 - Perimetro de un cuadrado (RESUELTO)

ENUNCIADO:
  Pide el lado (double). Muestra el perimetro (4 * lado) con 2 decimales.

EJEMPLO DE EJECUCION:
  lado = 3.5
  Perimetro: 14.00

SOLUCION:
  4 * lado.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double lado = 0.0;
    printf("lado = ");
    scanf("%lf", &lado);
    printf("Perimetro: %.2f\n", 4.0 * lado);
    return 0;
}
