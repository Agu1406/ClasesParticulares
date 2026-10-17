/*
E17 - Ecuacion de segundo grado (RESUELTO)

ENUNCIADO:
  Pide a, b y c de ax^2 + bx + c = 0. Calcula el discriminante: si es negativo muestra
  'Sin soluciones reales'; si es 0 una solucion; si es positivo las dos. Si a es 0
  muestra 'No es de segundo grado'.

EJEMPLO DE EJECUCION:
  a b c: 1 -3 2
  Dos soluciones: 2.00 y 1.00

PISTA:
  x = (-b +- sqrt(discriminante)) / (2a)

SOLUCION:
  El signo del discriminante determina el numero de soluciones reales.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>

int main(void) {
    double a = 0, b = 0, c = 0;
    printf("a b c: ");
    scanf("%lf %lf %lf", &a, &b, &c);
    if (a == 0) {
        printf("No es de segundo grado\n");
    } else {
        double d = b * b - 4 * a * c;
        if (d < 0) {
            printf("Sin soluciones reales\n");
        } else if (d == 0) {
            printf("Una solucion: %.2f\n", -b / (2 * a));
        } else {
            printf("Dos soluciones: %.2f y %.2f\n",
                   (-b + sqrt(d)) / (2 * a), (-b - sqrt(d)) / (2 * a));
        }
    }
    return 0;
}
