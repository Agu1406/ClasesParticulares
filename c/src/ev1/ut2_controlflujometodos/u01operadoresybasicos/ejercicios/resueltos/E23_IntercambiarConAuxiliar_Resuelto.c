/*
E23 - Intercambiar con auxiliar (RESUELTO)

ENUNCIADO:
  Con a = 3 y b = 9 (o leidos), intercambia sus valores usando una variable auxiliar e imprimelos.

EJEMPLO DE EJECUCION:
  Antes: a=3 b=9
  Despues: a=9 b=3

SOLUCION:
  Tres asignaciones con aux.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 3, b = 9;
    int aux;
    printf("Antes: a=%d b=%d\n", a, b);
    aux = a;
    a = b;
    b = aux;
    printf("Despues: a=%d b=%d\n", a, b);
    return 0;
}
