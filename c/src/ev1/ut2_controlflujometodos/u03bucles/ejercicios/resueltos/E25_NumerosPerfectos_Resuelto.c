/*
E25 - Numeros perfectos (RESUELTO)

ENUNCIADO:
  Muestra los numeros perfectos menores que 10000 (los que igualan la suma de sus divisores propios).

EJEMPLO DE EJECUCION:
  6 28 496 8128

PISTA:
  Para cada n suma los divisores de 1 a n/2.

SOLUCION:
  Dos bucles anidados: candidatos y divisores.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    for (int n = 2; n < 10000; n++) {
        int suma = 0;
        for (int d = 1; d <= n / 2; d++) {
            if (n % d == 0) {
                suma += d;
            }
        }
        if (suma == n) {
            printf("%d ", n);
        }
    }
    printf("\n");
    return 0;
}
