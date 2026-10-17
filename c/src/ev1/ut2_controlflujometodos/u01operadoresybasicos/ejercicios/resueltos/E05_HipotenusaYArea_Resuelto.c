/*
E05 - Hipotenusa y area de un triangulo rectangulo (RESUELTO)

ENUNCIADO:
  Pide los dos catetos de un triangulo rectangulo y calcula la hipotenusa (sqrt) y
  el area. Muestra ambos con dos decimales.

EJEMPLO DE EJECUCION:
  Cateto 1: 3
  Cateto 2: 4
  Hipotenusa: 5.00
  Area: 6.00

PISTA:
  hipotenusa = sqrt(c1*c1 + c2*c2)  (necesita <math.h>)

SOLUCION:
  sqrt calcula la raiz cuadrada; hypot(c1, c2) haria lo mismo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>

int main(void) {
    double c1 = 0, c2 = 0;
    printf("Cateto 1: ");
    scanf("%lf", &c1);
    printf("Cateto 2: ");
    scanf("%lf", &c2);
    double hipotenusa = sqrt(c1 * c1 + c2 * c2);
    double area = c1 * c2 / 2;
    printf("Hipotenusa: %.2f\n", hipotenusa);
    printf("Area: %.2f\n", area);
    return 0;
}
