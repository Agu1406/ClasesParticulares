/*
E14 - Intercambio sin variable auxiliar (RESUELTO)

ENUNCIADO:
  Intercambia a = 6 y b = 11 SIN usar una tercera variable. Hazlo de dos maneras:
  con suma y resta y, a continuacion, volviendo al original con el operador XOR (^).

EJEMPLO DE EJECUCION:
  Con suma/resta: a=11 b=6
  Con XOR (vuelve al original): a=6 b=11

PISTA:
  a = a + b; b = a - b; a = a - b;   y   a ^= b; b ^= a; a ^= b;

SOLUCION:
  Ambas tecnicas funcionan, pero con una variable auxiliar el codigo se lee mejor.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 6, b = 11;
    a = a + b;
    b = a - b;
    a = a - b;
    printf("Con suma/resta: a=%d b=%d\n", a, b);
    a ^= b;
    b ^= a;
    a ^= b;
    printf("Con XOR (vuelve al original): a=%d b=%d\n", a, b);
    return 0;
}
