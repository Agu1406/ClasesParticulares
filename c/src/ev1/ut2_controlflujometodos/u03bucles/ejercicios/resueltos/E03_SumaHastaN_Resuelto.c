/*
E03 - Suma de 1 a N (RESUELTO)

ENUNCIADO:
  Pide N y calcula 1 + 2 + ... + N con un bucle (acumulador). Comprueba con la formula N*(N+1)/2.

EJEMPLO DE EJECUCION:
  N: 100
  Suma con bucle: 5050
  Suma con formula: 5050

PISTA:
  Declara el acumulador FUERA del bucle e inicializalo a 0.

SOLUCION:
  El acumulador va sumando cada valor del contador.

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
    printf("Suma con bucle: %d\n", suma);
    printf("Suma con formula: %d\n", n * (n + 1) / 2);
    return 0;
}
