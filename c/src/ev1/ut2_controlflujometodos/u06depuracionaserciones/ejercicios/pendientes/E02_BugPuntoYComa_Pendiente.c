/*
E02 - Encuentra el error: punto y coma sobrante (PENDIENTE)

ENUNCIADO:
  Con n = -4 el programa NO debe mostrar 'n es positivo'. Solo debe mostrar 'Fin'.
  Hay un punto y coma que cambia el significado del if. Corrigelo.

EJEMPLO DE EJECUCION:
  Fin

PISTA:
  Mira el final de la linea del if.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = -4;
    // TODO: corrige el if
    if (n > 0);
    {
        printf("n es positivo\n");
    }
    printf("Fin\n");
    return 0;
}
