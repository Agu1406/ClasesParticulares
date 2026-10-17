/*
E20 - Cuadrado hueco (RESUELTO)

ENUNCIADO:
  Pide el lado n (>= 2) y dibuja un cuadrado hueco de asteriscos: solo el borde, con espacios dentro.

EJEMPLO DE EJECUCION:
  Lado: 5
  *****
  *   *
  *   *
  *   *
  *****

PISTA:
  Un asterisco si estas en la primera/ultima fila o columna; si no, un espacio.

SOLUCION:
  Dos bucles anidados con una condicion sobre fila y columna.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Lado: ");
    scanf("%d", &n);
    for (int f = 0; f < n; f++) {
        for (int c = 0; c < n; c++) {
            if (f == 0 || f == n - 1 || c == 0 || c == n - 1) {
                printf("*");
            } else {
                printf(" ");
            }
        }
        printf("\n");
    }
    return 0;
}
