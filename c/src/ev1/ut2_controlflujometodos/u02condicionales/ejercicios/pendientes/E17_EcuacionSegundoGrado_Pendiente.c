/*
E17 - Ecuacion de segundo grado (PENDIENTE)

ENUNCIADO:
  Pide a, b y c de ax^2 + bx + c = 0. Calcula el discriminante: si es negativo muestra
  'Sin soluciones reales'; si es 0 una solucion; si es positivo las dos. Si a es 0
  muestra 'No es de segundo grado'.

EJEMPLO DE EJECUCION:
  a b c: 1 -3 2
  Dos soluciones: 2.00 y 1.00

PISTA:
  x = (-b +- sqrt(discriminante)) / (2a)

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
    // TODO: resuelve la ecuacion segun el discriminante
    return 0;
}
