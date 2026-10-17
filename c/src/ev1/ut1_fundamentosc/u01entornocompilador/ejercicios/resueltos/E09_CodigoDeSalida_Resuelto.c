/*
E09 - Codigo de salida de main (RESUELTO)

ENUNCIADO:
  Escribe un programa que muestre 'Todo correcto' y termine devolviendo
  EXIT_SUCCESS (de <stdlib.h>) en lugar de escribir el numero 0.
  Despues de ejecutarlo comprueba el codigo con echo $LASTEXITCODE (PowerShell)
  o echo $? (Linux/macOS).

EJEMPLO DE EJECUCION:
  Todo correcto

PISTA:
  Incluye <stdlib.h> y escribe return EXIT_SUCCESS;

SOLUCION:
  EXIT_SUCCESS es la forma portable y legible de indicar que todo fue bien.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    printf("Todo correcto\n");
    return EXIT_SUCCESS;
}
