/*
E08 - Triangulo de asteriscos (RESUELTO)

ENUNCIADO:
  Pide un numero n y dibuja un triangulo rectangulo de n filas: la fila i tiene i asteriscos.

EJEMPLO DE EJECUCION:
  N: 4
  *
  **
  ***
  ****

PISTA:
  Un for dentro de otro for.

SOLUCION:
  El bucle externo son las filas y el interno los asteriscos de cada fila.

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
    for (int fila = 1; fila <= n; fila++) {
        for (int j = 0; j < fila; j++) {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}
