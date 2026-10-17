/*
E10 - Intercambiar dos variables (RESUELTO)

ENUNCIADO:
  Dadas a = 3 y b = 8, intercambia sus valores usando una tercera variable auxiliar
  y muestra el antes y el despues.

EJEMPLO DE EJECUCION:
  Antes:   a = 3, b = 8
  Despues: a = 8, b = 3

PISTA:
  Guarda a en aux, pasa b a a y devuelve aux a b. Sin aux perderias un valor.

SOLUCION:
  Con tres asignaciones (aux = a; a = b; b = aux) se intercambian sin perder datos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 3, b = 8;
    printf("Antes:   a = %d, b = %d\n", a, b);
    int aux = a;
    a = b;
    b = aux;
    printf("Despues: a = %d, b = %d\n", a, b);
    return 0;
}
