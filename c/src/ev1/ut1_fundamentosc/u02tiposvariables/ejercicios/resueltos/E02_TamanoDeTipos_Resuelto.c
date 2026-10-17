/*
E02 - Tamano de los tipos con sizeof (RESUELTO)

ENUNCIADO:
  Muestra el tamano en bytes de char, short, int, long long, float y double
  usando sizeof. Imprimelo con %lu convirtiendo antes a unsigned long.

EJEMPLO DE EJECUCION:
  char: 1
  short: 2
  int: 4
  long long: 8
  float: 4
  double: 8

PISTA:
  printf("int: %lu\n", (unsigned long)sizeof(int));

SOLUCION:
  sizeof devuelve size_t; el cast a unsigned long hace portable el %lu.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("char: %lu\n", (unsigned long)sizeof(char));
    printf("short: %lu\n", (unsigned long)sizeof(short));
    printf("int: %lu\n", (unsigned long)sizeof(int));
    printf("long long: %lu\n", (unsigned long)sizeof(long long));
    printf("float: %lu\n", (unsigned long)sizeof(float));
    printf("double: %lu\n", (unsigned long)sizeof(double));
    return 0;
}
