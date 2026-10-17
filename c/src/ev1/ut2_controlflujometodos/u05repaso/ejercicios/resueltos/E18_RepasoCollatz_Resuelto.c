/*
E18 - Secuencia de Collatz (RESUELTO)

ENUNCIADO:
  Pide un entero positivo n y aplica: si es par, n = n / 2; si es impar, n = 3n + 1; hasta llegar a 1.
  Muestra los valores de la secuencia separados por espacios y el numero de pasos.

EJEMPLO DE EJECUCION:
  N: 6
  6 3 10 5 16 8 4 2 1
  Pasos: 8

PISTA:
  Un while (n != 1) con un contador de pasos.

SOLUCION:
  Se muestra cada valor antes de transformarlo, y 1 al final.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("N: ");
    scanf("%d", &n);
    int pasos = 0;
    while (n != 1) {
        printf("%d ", n);
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
        pasos++;
    }
    printf("1\n");
    printf("Pasos: %d\n", pasos);
    return 0;
}
