/*
E11 - Es primo? (PENDIENTE)

ENUNCIADO:
  Pide un entero y di si es primo. Prueba divisores hasta la raiz cuadrada y sal con break al encontrar uno.

EJEMPLO DE EJECUCION:
  Numero: 97
  97 es primo

PISTA:
  Los numeros menores que 2 no son primos.

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
    // TODO: determina si es primo
    int es_primo = 0;
    printf("%d %s primo\n", n, es_primo ? "es" : "no es");
    return 0;
}
