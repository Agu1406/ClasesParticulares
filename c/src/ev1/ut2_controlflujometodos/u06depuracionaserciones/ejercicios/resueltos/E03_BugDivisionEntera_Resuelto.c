/*
E03 - Encuentra el error: division entera (RESUELTO)

ENUNCIADO:
  Calcula la media de 2 y 3 y debe mostrar 'Media: 2.50'. Ahora muestra 2.00.
  Corrige el calculo.

EJEMPLO DE EJECUCION:
  Media: 2.50

PISTA:
  Un entero entre un entero da un entero.

SOLUCION:
  Se divide entre 2.0 (o se castea uno de los operandos a double).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 2;
    int b = 3;
    double media = (a + b) / 2.0;
    printf("Media: %.2f\n", media);
    return 0;
}
