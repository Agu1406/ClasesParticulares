/*
E17 - Multiplicar dos numeros (RESUELTO)

ENUNCIADO:
  Pide dos enteros a y b. Muestra su producto.

EJEMPLO DE EJECUCION:
  a = 6
  b = 4
  6 * 4 = 24

SOLUCION:
  Producto con *.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0;
    printf("a = ");
    scanf("%d", &a);
    printf("b = ");
    scanf("%d", &b);
    printf("%d * %d = %d\n", a, b, a * b);
    return 0;
}
