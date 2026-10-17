/*
E16 - Piramide centrada (RESUELTO)

ENUNCIADO:
  Pide la altura y dibuja una piramide centrada de asteriscos.

EJEMPLO DE EJECUCION:
  Altura: 3
    *
   ***
  *****

PISTA:
  Fila f: (altura - f) espacios y (2*f - 1) asteriscos.

SOLUCION:
  Tres bucles: filas, espacios previos y asteriscos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int altura = 0;
    printf("Altura: ");
    scanf("%d", &altura);
    for (int fila = 1; fila <= altura; fila++) {
        for (int e = 0; e < altura - fila; e++) {
            printf(" ");
        }
        for (int s = 0; s < 2 * fila - 1; s++) {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}
