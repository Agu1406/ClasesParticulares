/*
E30 - Cuadrados del 1 al 10 (RESUELTO)

ENUNCIADO:
  Para i de 1 a 10, muestra i y i*i en la forma: 3^2 = 9

EJEMPLO DE EJECUCION:
  1^2 = 1
  2^2 = 4
  ...

SOLUCION:
  Un printf por vuelta.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    for (int i = 1; i <= 10; i++) {
        printf("%d^2 = %d\n", i, i * i);
    }
    return 0;
}
