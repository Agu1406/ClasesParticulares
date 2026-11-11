/*
E27 - Numeros del 1 al 10 (RESUELTO)

ENUNCIADO:
  Muestra los numeros del 1 al 10 en una linea, separados por espacio, con un for.

EJEMPLO DE EJECUCION:
  1 2 3 4 5 6 7 8 9 10

SOLUCION:
  Bucle for clasico de calentamiento.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    for (int i = 1; i <= 10; i++) {
        printf("%d", i);
        if (i < 10) {
            printf(" ");
        }
    }
    printf("\n");
    return 0;
}
