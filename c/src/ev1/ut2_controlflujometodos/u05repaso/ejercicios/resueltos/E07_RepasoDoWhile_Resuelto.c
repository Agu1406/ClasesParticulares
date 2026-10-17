/*
E07 - Contar cifras (RESUELTO)

ENUNCIADO:
  Pide un entero positivo y cuenta cuantas cifras tiene dividiendo entre 10 con un do-while.

EJEMPLO DE EJECUCION:
  Numero: 4821
  Tiene 4 cifras

PISTA:
  Un do-while hace que el 0 cuente como 1 cifra.

SOLUCION:
  Cada division entre 10 quita una cifra.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Numero: ");
    scanf("%d", &n);
    int cifras = 0;
    do {
        cifras++;
        n /= 10;
    } while (n != 0);
    printf("Tiene %d cifras\n", cifras);
    return 0;
}
