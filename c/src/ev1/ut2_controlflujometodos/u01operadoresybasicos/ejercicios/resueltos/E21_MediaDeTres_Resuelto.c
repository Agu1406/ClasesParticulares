/*
E21 - Media de tres numeros (RESUELTO)

ENUNCIADO:
  Pide tres enteros. Muestra su media real con 2 decimales.

EJEMPLO DE EJECUCION:
  4  8  6
  Media: 6.00

SOLUCION:
  (a+b+c) / 3.0.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0, c = 0;
    printf("a b c: ");
    scanf("%d %d %d", &a, &b, &c);
    printf("Media: %.2f\n", (a + b + c) / 3.0);
    return 0;
}
