/*
E22 - Cuadrante de un punto (RESUELTO)

ENUNCIADO:
  Pide las coordenadas (x, y) y di en que cuadrante esta (1 a 4), o si esta sobre un
  eje o en el origen.

EJEMPLO DE EJECUCION:
  Punto: -3 5
  Cuadrante 2

PISTA:
  Compara los signos de x e y.

SOLUCION:
  Cuatro combinaciones de signos, mas los casos especiales de los ejes.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double x = 0, y = 0;
    printf("Punto: ");
    scanf("%lf %lf", &x, &y);
    if (x == 0 && y == 0) {
        printf("Origen\n");
    } else if (x == 0) {
        printf("Sobre el eje Y\n");
    } else if (y == 0) {
        printf("Sobre el eje X\n");
    } else if (x > 0 && y > 0) {
        printf("Cuadrante 1\n");
    } else if (x < 0 && y > 0) {
        printf("Cuadrante 2\n");
    } else if (x < 0 && y < 0) {
        printf("Cuadrante 3\n");
    } else {
        printf("Cuadrante 4\n");
    }
    return 0;
}
