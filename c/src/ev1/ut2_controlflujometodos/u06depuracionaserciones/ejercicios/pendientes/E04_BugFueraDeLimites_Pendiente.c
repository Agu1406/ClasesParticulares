/*
E04 - Encuentra el error: un indice de mas (PENDIENTE)

ENUNCIADO:
  Suma los 5 elementos del array (1+2+3+4+5 = 15). El bucle lee una posicion de mas.
  Corrigelo.

EJEMPLO DE EJECUCION:
  Suma: 15

PISTA:
  Un array de 5 elementos tiene indices de 0 a 4.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int v[5] = {1, 2, 3, 4, 5};
    int suma = 0;
    // TODO: corrige la condicion del bucle
    for (int i = 0; i <= 5; i++) {
        suma += v[i];
    }
    printf("Suma: %d\n", suma);
    return 0;
}
