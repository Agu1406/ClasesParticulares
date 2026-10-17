/*
E04 - Precedencia de operadores (RESUELTO)

ENUNCIADO:
  Calcula a mano y luego escribe el programa que imprime el valor de cada expresion:
    a) 8 + 4 * 3    b) (8 + 4) * 3    c) 20 / 3 * 3    d) 20 % 7 + 2 * 5
    e) 2 + 3 > 4 && 10 / 2 == 5

EJEMPLO DE EJECUCION:
  a) 20
  b) 36
  c) 18
  d) 16
  e) 1

PISTA:
  Primero * / %, despues + -, despues comparaciones y por ultimo &&.

SOLUCION:
  El resultado de c) es 18 y no 20 porque la division es entera (20 / 3 = 6).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("a) %d\n", 8 + 4 * 3);
    printf("b) %d\n", (8 + 4) * 3);
    printf("c) %d\n", 20 / 3 * 3);
    printf("d) %d\n", 20 % 7 + 2 * 5);
    printf("e) %d\n", 2 + 3 > 4 && 10 / 2 == 5);
    return 0;
}
