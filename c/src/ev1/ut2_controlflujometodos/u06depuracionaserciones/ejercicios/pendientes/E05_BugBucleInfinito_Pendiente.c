/*
E05 - Encuentra el error: bucle infinito (PENDIENTE)

ENUNCIADO:
  El programa debe mostrar 0 1 2 3 4. Si lo ejecutas se queda en un bucle infinito.
  Corrigelo.

EJEMPLO DE EJECUCION:
  0 1 2 3 4

PISTA:
  Mira que variable controla el bucle y si cambia.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int i = 0;
    while (i < 5) {
        printf("%d ", i);
        // TODO: falta una linea para que el bucle termine
        /* aqui falta algo */
    }
    printf("\n");
    return 0;
}
