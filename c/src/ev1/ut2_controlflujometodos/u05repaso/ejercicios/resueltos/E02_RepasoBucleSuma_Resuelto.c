/*
E02 - Suma de 1 a N (RESUELTO)

ENUNCIADO:
  Pide N y muestra la suma de los enteros de 1 a N usando un for.

EJEMPLO DE EJECUCION:
  N: 10
  Suma = 55

PISTA:
  Un acumulador que empieza en 0.

SOLUCION:
  El for recorre 1..N y suma cada valor.

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
    int suma = 0;
    for (int i = 1; i <= n; i++) {
        suma += i;
    }
    printf("Suma = %d\n", suma);
    return 0;
}
