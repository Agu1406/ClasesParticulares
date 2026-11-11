/*
E15 - Sumar dos numeros (RESUELTO)

ENUNCIADO:
  Pide dos enteros a y b. Muestra su suma.

EJEMPLO DE EJECUCION:
  a = 7
  b = 5
  7 + 5 = 12

SOLUCION:
  Suma con el operador +.

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
    printf("%d + %d = %d\n", a, b, a + b);
    return 0;
}
