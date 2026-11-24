/*
E04 - Contar mayores que X (RESUELTO)

ENUNCIADO:
  Array {3,8,1,8,5,10}. Pide X y cuenta cuantos son > X.

SOLUCION:
  Comparacion en bucle.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int v[6] = {3, 8, 1, 8, 5, 10};
    int x = 0, c = 0;
    printf("X: ");
    scanf("%d", &x);
    for (int i = 0; i < 6; i++) if (v[i] > x) c++;
    printf("Mayores: %d\n", c);
    return 0;
}
