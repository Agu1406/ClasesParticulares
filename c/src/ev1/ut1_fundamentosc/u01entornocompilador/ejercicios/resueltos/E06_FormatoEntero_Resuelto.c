/*
E06 - Mostrar un entero con %d (RESUELTO)

ENUNCIADO:
  Declara una variable entera edad con el valor 25 y muestra:
    Tengo 25 anos
  usando %d en el printf (no escribas el 25 dentro del texto).

EJEMPLO DE EJECUCION:
  Tengo 25 anos

PISTA:
  printf("Tengo %d anos\n", edad);

SOLUCION:
  %d se sustituye por el valor del siguiente argumento (edad).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int edad = 25;
    printf("Tengo %d anos\n", edad);
    return 0;
}
