/*
E02 - Asignacion compuesta paso a paso (RESUELTO)

ENUNCIADO:
  Partiendo de valor = 100 aplica en este orden y muestra el valor tras cada paso:
    += 20, -= 30, *= 3, /= 4, %= 7

EJEMPLO DE EJECUCION:
  Inicial: 100
  += 20 -> 120
  -= 30 -> 90
  *= 3 -> 270
  /= 4 -> 67
  %= 7 -> 4

PISTA:
  valor += 20 equivale a valor = valor + 20.

SOLUCION:
  Cada operador compuesto actualiza la variable; recuerda que / entre enteros trunca.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int valor = 100;
    printf("Inicial: %d\n", valor);
    valor += 20;
    printf("+= 20 -> %d\n", valor);
    valor -= 30;
    printf("-= 30 -> %d\n", valor);
    valor *= 3;
    printf("*= 3 -> %d\n", valor);
    valor /= 4;
    printf("/= 4 -> %d\n", valor);
    valor %= 7;
    printf("%%= 7 -> %d\n", valor);
    return 0;
}
