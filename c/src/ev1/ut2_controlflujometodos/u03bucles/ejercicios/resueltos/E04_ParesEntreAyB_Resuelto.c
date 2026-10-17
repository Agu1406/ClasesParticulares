/*
E04 - Pares entre dos numeros (RESUELTO)

ENUNCIADO:
  Pide dos enteros a y b (a <= b) y muestra los numeros pares entre ambos (incluidos) y cuantos hay.

EJEMPLO DE EJECUCION:
  a y b: 3 12
  4 6 8 10 12
  Cantidad: 5

PISTA:
  Un contador cuenta cuantos pares has mostrado.

SOLUCION:
  Se combina un for con un if y un contador.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0;
    printf("a y b: ");
    scanf("%d %d", &a, &b);
    int cantidad = 0;
    for (int i = a; i <= b; i++) {
        if (i % 2 == 0) {
            printf("%d ", i);
            cantidad++;
        }
    }
    printf("\n");
    printf("Cantidad: %d\n", cantidad);
    return 0;
}
