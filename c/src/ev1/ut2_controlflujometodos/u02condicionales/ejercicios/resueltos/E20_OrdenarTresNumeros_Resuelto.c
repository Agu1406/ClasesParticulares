/*
E20 - Ordenar tres numeros (RESUELTO)

ENUNCIADO:
  Pide tres enteros y muestralos ordenados de menor a mayor (solo con if y variables auxiliares).

EJEMPLO DE EJECUCION:
  Numeros: 9 2 5
  2 5 9

PISTA:
  Intercambia pares con una variable auxiliar: a-b, a-c, b-c.

SOLUCION:
  Tres comparaciones con intercambio dejan los valores ordenados (ordenacion burbuja a mano).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0, c = 0;
    printf("Numeros: ");
    scanf("%d %d %d", &a, &b, &c);
    int aux;
    if (a > b) { aux = a; a = b; b = aux; }
    if (a > c) { aux = a; a = c; c = aux; }
    if (b > c) { aux = b; b = c; c = aux; }
    printf("%d %d %d\n", a, b, c);
    return 0;
}
