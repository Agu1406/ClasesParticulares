/*
E13 - Validar y salir con codigo de error (RESUELTO)

ENUNCIADO:
  Lee un porcentaje entero (0-100). Si no se pudo leer un numero, escribe por stderr 'Error: entrada no valida' y termina con EXIT_FAILURE.
  Si esta fuera de rango escribe por stderr 'Error: fuera de rango' y termina con EXIT_FAILURE.
  Si es valido muestra 'Porcentaje: N%'.

EJEMPLO DE EJECUCION:
  Introduce un porcentaje: 85
  Porcentaje: 85%

PISTA:
  fprintf(stderr, ...) y return EXIT_FAILURE;

SOLUCION:
  Se comprueba el retorno de scanf y luego el rango.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int p = 0;
    printf("Introduce un porcentaje: ");
    if (scanf("%d", &p) != 1) {
        fprintf(stderr, "Error: entrada no valida\n");
        return EXIT_FAILURE;
    }
    if (p < 0 || p > 100) {
        fprintf(stderr, "Error: fuera de rango\n");
        return EXIT_FAILURE;
    }
    printf("Porcentaje: %d%%\n", p);
    return EXIT_SUCCESS;
}
