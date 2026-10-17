/*
E15 - Triangulo de asteriscos (RESUELTO)

ENUNCIADO:
  Pide la altura y dibuja un triangulo rectangulo: 1 asterisco en la primera fila, 2 en la segunda...

EJEMPLO DE EJECUCION:
  Altura: 4
  *
  **
  ***
  ****

PISTA:
  Dos bucles anidados: filas y columnas.

SOLUCION:
  El numero de asteriscos de cada fila coincide con el numero de fila.

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
        for (int col = 1; col <= fila; col++) {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}
