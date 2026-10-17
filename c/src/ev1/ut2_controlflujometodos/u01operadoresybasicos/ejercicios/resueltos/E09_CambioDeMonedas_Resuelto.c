/*
E09 - Cambio en billetes y monedas (RESUELTO)

ENUNCIADO:
  Pide una cantidad entera de euros y desglosala con el menor numero de billetes de
  50, 20, 10, 5 y monedas de 2 y 1 euro (usa / y % encadenados).

EJEMPLO DE EJECUCION:
  Euros: 188
  50 euros: 3
  20 euros: 1
  10 euros: 1
  5 euros: 1
  2 euros: 1
  1 euro: 1

PISTA:
  Tras calcular cada tipo, actualiza la cantidad restante con %.

SOLUCION:
  Algoritmo voraz: se coge el maximo de la denominacion mayor y se sigue con el resto.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int euros = 0;
    printf("Euros: ");
    scanf("%d", &euros);
    printf("50 euros: %d\n", euros / 50);
    euros %= 50;
    printf("20 euros: %d\n", euros / 20);
    euros %= 20;
    printf("10 euros: %d\n", euros / 10);
    euros %= 10;
    printf("5 euros: %d\n", euros / 5);
    euros %= 5;
    printf("2 euros: %d\n", euros / 2);
    euros %= 2;
    printf("1 euro: %d\n", euros);
    return 0;
}
