/*
E05 - Factorial (PENDIENTE)

ENUNCIADO:
  Pide un entero n (0 a 20) y calcula n! con long long. Si n esta fuera de rango muestra un error.

EJEMPLO DE EJECUCION:
  N: 10
  10! = 3628800

PISTA:
  0! vale 1. Usa %lld para long long.

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
    if (n < 0 || n > 20) {
        printf("N debe estar entre 0 y 20\n");
        return 1;
    }
    // TODO: calcula el factorial
    long long factorial = 1;
    printf("%d! = %lld\n", n, factorial);
    return 0;
}
