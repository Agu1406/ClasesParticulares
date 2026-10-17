/*
E05 - Tabla de cuadrados y cubos (RESUELTO)

ENUNCIADO:
  Muestra una tabla con n, n al cuadrado y n al cubo para n de 1 a 5, con las columnas alineadas a la derecha (ancho 4).

EJEMPLO DE EJECUCION:
     n  n^2  n^3
     1    1    1
     5   25  125

PISTA:
  Usa %4d para alinear.

SOLUCION:
  Una cabecera y un for con tres columnas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("%4s %4s %4s\n", "n", "n^2", "n^3");
    for (int n = 1; n <= 5; n++) {
        printf("%4d %4d %4d\n", n, n * n, n * n * n);
    }
    return 0;
}
