/*
E06 - Distancia entre dos puntos (PENDIENTE)

ENUNCIADO:
  Pide las coordenadas (x1, y1) y (x2, y2) y muestra la distancia entre ambos puntos
  con dos decimales.

EJEMPLO DE EJECUCION:
  x1 y1: 1 2
  x2 y2: 4 6
  Distancia: 5.00

PISTA:
  d = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2))

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>

int main(void) {
    double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    printf("x1 y1: ");
    scanf("%lf %lf", &x1, &y1);
    printf("x2 y2: ");
    scanf("%lf %lf", &x2, &y2);
    // TODO: calcula la distancia
    double distancia = 0;
    printf("Distancia: %.2f\n", distancia);
    return 0;
}
