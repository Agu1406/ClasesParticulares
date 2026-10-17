/*
E14 - Maximo comun divisor y minimo comun multiplo (RESUELTO)

ENUNCIADO:
  Pide dos enteros positivos y calcula el MCD con el algoritmo de Euclides y el mcm = a*b/MCD.

EJEMPLO DE EJECUCION:
  Numeros: 84 36
  MCD = 12
  mcm = 252

PISTA:
  Mientras b != 0: resto = a % b; a = b; b = resto.

SOLUCION:
  El resto va reduciendo el problema hasta que b es 0; entonces a es el MCD.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0;
    printf("Numeros: ");
    scanf("%d %d", &a, &b);
    int x = a, y = b;
    while (y != 0) {
        int resto = x % y;
        x = y;
        y = resto;
    }
    int mcd = x;
    printf("MCD = %d\n", mcd);
    printf("mcm = %d\n", a / mcd * b);
    return 0;
}
