/*
E13 - Codigo ASCII y siguiente letra (PENDIENTE)

ENUNCIADO:
  Dado el caracter 'F', muestra la letra, su codigo ASCII, la letra siguiente y la
  misma letra en minuscula (sumando 32).

EJEMPLO DE EJECUCION:
  Letra: F
  ASCII: 70
  Siguiente: G
  Minuscula: f

PISTA:
  char es un entero: 'F' + 1 es 'G' y 'F' + 32 es 'f'.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    char letra = 'F';
    // TODO: calcula siguiente y minuscula
    char siguiente = ' ';
    char minuscula = ' ';
    printf("Letra: %c\n", letra);
    printf("ASCII: %d\n", letra);
    printf("Siguiente: %c\n", siguiente);
    printf("Minuscula: %c\n", minuscula);
    return 0;
}
