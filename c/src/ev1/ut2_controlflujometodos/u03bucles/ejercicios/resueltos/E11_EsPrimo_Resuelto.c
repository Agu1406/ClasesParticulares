/*
E11 - Es primo? (RESUELTO)

ENUNCIADO:
  Pide un entero y di si es primo. Prueba divisores hasta la raiz cuadrada y sal con break al encontrar uno.

EJEMPLO DE EJECUCION:
  Numero: 97
  97 es primo

PISTA:
  Los numeros menores que 2 no son primos.

SOLUCION:
  Se prueba cada divisor posible; con uno que divida ya no es primo.

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
    int es_primo = n >= 2;
    for (int d = 2; d * d <= n; d++) {
        if (n % d == 0) {
            es_primo = 0;
            break;
        }
    }
    printf("%d %s primo\n", n, es_primo ? "es" : "no es");
    return 0;
}
