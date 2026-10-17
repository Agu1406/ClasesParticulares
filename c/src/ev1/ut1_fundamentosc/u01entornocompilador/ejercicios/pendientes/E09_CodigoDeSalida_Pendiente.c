/*
E09 - Codigo de salida de main (PENDIENTE)

ENUNCIADO:
  Escribe un programa que muestre 'Todo correcto' y termine devolviendo
  EXIT_SUCCESS (de <stdlib.h>) en lugar de escribir el numero 0.
  Despues de ejecutarlo comprueba el codigo con echo $LASTEXITCODE (PowerShell)
  o echo $? (Linux/macOS).

EJEMPLO DE EJECUCION:
  Todo correcto

PISTA:
  Incluye <stdlib.h> y escribe return EXIT_SUCCESS;

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    printf("Todo correcto\n");
    // TODO: devuelve EXIT_SUCCESS
    return 0;
}
