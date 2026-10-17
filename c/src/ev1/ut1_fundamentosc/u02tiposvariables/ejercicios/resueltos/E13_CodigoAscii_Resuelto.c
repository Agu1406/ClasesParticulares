/*
E13 - Codigo ASCII y siguiente letra (RESUELTO)

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

SOLUCION:
  Como char es un numero, se puede sumar. Al imprimir se usa %c o %d.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    char letra = 'F';
    char siguiente = (char)(letra + 1);
    char minuscula = (char)(letra + 32);
    printf("Letra: %c\n", letra);
    printf("ASCII: %d\n", letra);
    printf("Siguiente: %c\n", siguiente);
    printf("Minuscula: %c\n", minuscula);
    return 0;
}
