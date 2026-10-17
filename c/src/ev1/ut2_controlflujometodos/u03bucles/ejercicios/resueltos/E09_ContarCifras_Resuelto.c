/*
E09 - Cuantas cifras tiene (RESUELTO)

ENUNCIADO:
  Pide un entero (puede ser negativo o 0) y di cuantas cifras tiene SIN usar math.h.

EJEMPLO DE EJECUCION:
  Numero: -7305
  Tiene 4 cifras

PISTA:
  El 0 tiene 1 cifra. Trabaja con el valor absoluto.

SOLUCION:
  Se cuentan las divisiones entre 10 necesarias para llegar a 0.

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
    if (n < 0) {
        n = -n;
    }
    int cifras = 0;
    do {
        cifras++;
        n /= 10;
    } while (n > 0);
    printf("Tiene %d cifras\n", cifras);
    return 0;
}
