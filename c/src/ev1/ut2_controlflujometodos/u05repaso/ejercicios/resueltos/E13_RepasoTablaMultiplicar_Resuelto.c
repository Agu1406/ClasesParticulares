/*
E13 - Cuadro de multiplicar 5x5 (RESUELTO)

ENUNCIADO:
  Muestra el cuadro de multiplicar de 1 a 5 (filas y columnas), cada celda con ancho 3.

EJEMPLO DE EJECUCION:
    1  2  3  4  5
    2  4  6  8 10
  ...
    5 10 15 20 25

PISTA:
  Dos for anidados; salto de linea al terminar cada fila.

SOLUCION:
  La fila y la columna se multiplican en el bucle interno.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    for (int f = 1; f <= 5; f++) {
        for (int c = 1; c <= 5; c++) {
            printf("%3d", f * c);
        }
        printf("\n");
    }
    return 0;
}
