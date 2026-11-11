/*
E19 - Area de un rectangulo (RESUELTO)

ENUNCIADO:
  Pide base y altura (double). Muestra el area con 2 decimales.

EJEMPLO DE EJECUCION:
  base = 4.5 altura = 2.0
  Area: 9.00

SOLUCION:
  Producto de doubles.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double base = 0.0, altura = 0.0;
    printf("base = ");
    scanf("%lf", &base);
    printf("altura = ");
    scanf("%lf", &altura);
    printf("Area: %.2f\n", base * altura);
    return 0;
}
