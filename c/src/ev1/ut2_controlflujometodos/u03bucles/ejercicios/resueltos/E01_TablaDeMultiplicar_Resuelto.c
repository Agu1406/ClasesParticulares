/*
E01 - Tabla de multiplicar (RESUELTO)

ENUNCIADO:
  Pide un numero y muestra su tabla de multiplicar del 1 al 10 con un bucle for.

EJEMPLO DE EJECUCION:
  Numero: 6
  6 x 1 = 6
  ...
  6 x 10 = 60

PISTA:
  Usa %2d para alinear los resultados.

SOLUCION:
  El for recorre el multiplicador del 1 al 10.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Numero: ");
    scanf("%d", &n);
    for (int i = 1; i <= 10; i++) {
        printf("%d x %2d = %2d\n", n, i, n * i);
    }
    return 0;
}
