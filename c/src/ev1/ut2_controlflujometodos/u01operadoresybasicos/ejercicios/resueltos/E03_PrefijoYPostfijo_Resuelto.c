/*
E03 - Prefijo frente a postfijo (RESUELTO)

ENUNCIADO:
  Con x = 10 ejecuta y muestra (x e y) tras cada sentencia:
    1) y = x++;   2) y = ++x;   3) y = x--;   4) y = --x;

EJEMPLO DE EJECUCION:
  y = x++ -> x=11 y=10
  y = ++x -> x=12 y=12
  y = x-- -> x=11 y=12
  y = --x -> x=10 y=10

PISTA:
  x++ devuelve el valor ANTES de sumar; ++x lo devuelve DESPUES.

SOLUCION:
  El postfijo entrega el valor antiguo; el prefijo, el nuevo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int x = 10, y = 0;
    y = x++;
    printf("y = x++ -> x=%d y=%d\n", x, y);
    y = ++x;
    printf("y = ++x -> x=%d y=%d\n", x, y);
    y = x--;
    printf("y = x-- -> x=%d y=%d\n", x, y);
    y = --x;
    printf("y = --x -> x=%d y=%d\n", x, y);
    return 0;
}
