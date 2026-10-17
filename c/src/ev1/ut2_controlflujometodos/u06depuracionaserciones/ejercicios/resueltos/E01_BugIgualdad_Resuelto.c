/*
E01 - Encuentra el error: = en vez de == (RESUELTO)

ENUNCIADO:
  El programa debe decir si x vale 5. Con x = 3 deberia mostrar 'x no vale 5'.
  Ahora mismo hay un error en la condicion. Encuentralo y corrigelo.

EJEMPLO DE EJECUCION:
  x no vale 5

PISTA:
  Compila con -Wall: el compilador avisa de este error.

SOLUCION:
  if (x = 5) asigna 5 a x y siempre es verdadero. Hay que comparar con ==.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int x = 3;
    if (x == 5) {
        printf("x vale 5\n");
    } else {
        printf("x no vale 5\n");
    }
    return 0;
}
