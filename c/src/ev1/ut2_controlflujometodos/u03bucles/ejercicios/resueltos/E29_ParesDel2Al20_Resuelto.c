/*
E29 - Pares del 2 al 20 (RESUELTO)

ENUNCIADO:
  Muestra los pares del 2 al 20 (inclusive) con un for que salte de 2 en 2.

EJEMPLO DE EJECUCION:
  2 4 6 8 10 12 14 16 18 20

SOLUCION:
  Incremento i += 2.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    for (int i = 2; i <= 20; i += 2) {
        printf("%d", i);
        if (i < 20) {
            printf(" ");
        }
    }
    printf("\n");
    return 0;
}
