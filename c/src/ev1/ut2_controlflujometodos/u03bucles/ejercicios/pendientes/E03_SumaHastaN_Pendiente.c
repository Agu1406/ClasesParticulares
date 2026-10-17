/*
E03 - Suma de 1 a N (PENDIENTE)

ENUNCIADO:
  Pide N y calcula 1 + 2 + ... + N con un bucle (acumulador). Comprueba con la formula N*(N+1)/2.

EJEMPLO DE EJECUCION:
  N: 100
  Suma con bucle: 5050
  Suma con formula: 5050

PISTA:
  Declara el acumulador FUERA del bucle e inicializalo a 0.

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
    // TODO: acumula la suma
    int suma = 0;
    printf("Suma con bucle: %d\n", suma);
    printf("Suma con formula: %d\n", n * (n + 1) / 2);
    return 0;
}
