/*
E09 - Encuentra el error: desbordamiento (PENDIENTE)

ENUNCIADO:
  Multiplica 2000000000 por 3 y guardalo en un long long. Debe mostrar 6000000000.
  El resultado sale mal. Corrigelo.

EJEMPLO DE EJECUCION:
  Resultado: 6000000000

PISTA:
  La multiplicacion se hace con el tipo de los operandos, no con el de la variable destino.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 2000000000;
    int b = 3;
    // TODO: corrige el calculo
    long long resultado = a * b;
    printf("Resultado: %lld\n", resultado);
    return 0;
}
