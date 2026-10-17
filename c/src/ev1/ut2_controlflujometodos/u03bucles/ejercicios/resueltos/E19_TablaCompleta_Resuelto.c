/*
E19 - Tabla de multiplicar completa (RESUELTO)

ENUNCIADO:
  Pide n y muestra la tabla de multiplicar de 1 a n en formato cuadro, con %4d.

EJEMPLO DE EJECUCION:
  N: 4
     1   2   3   4
     2   4   6   8
     3   6   9  12
     4   8  12  16

PISTA:
  Dos for anidados y un salto de linea por fila.

SOLUCION:
  El producto fila * columna se imprime con anchura fija.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("N: ");
    scanf("%d", &n);
    for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
            printf("%4d", a * b);
        }
        printf("\n");
    }
    return 0;
}
