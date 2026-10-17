/*
E14 - Resultados de comparaciones (RESUELTO)

ENUNCIADO:
  Con x = 12 e y = 20 muestra el valor (0 o 1) de: x == y, x != y, x < y, x >= y.

EJEMPLO DE EJECUCION:
  x == y: 0
  x != y: 1
  x < y: 1
  x >= y: 0

PISTA:
  Las comparaciones devuelven un int que puedes imprimir con %d.

SOLUCION:
  En C una comparacion es una expresion entera que vale 1 (cierta) o 0 (falsa).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int x = 12, y = 20;
    printf("x == y: %d\n", x == y);
    printf("x != y: %d\n", x != y);
    printf("x < y: %d\n", x < y);
    printf("x >= y: %d\n", x >= y);
    return 0;
}
