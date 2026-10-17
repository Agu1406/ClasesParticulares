/*
E10 - Invertir un numero y capicua (PENDIENTE)

ENUNCIADO:
  Pide un entero positivo, muestralo invertido y di si es capicua.

EJEMPLO DE EJECUCION:
  Numero: 12321
  Invertido: 12321
  Es capicua

PISTA:
  invertido = invertido * 10 + n % 10

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
    int resto = n, invertido = 0;
    // TODO: invierte el numero con un while
    printf("Invertido: %d\n", invertido);
    printf(invertido == n ? "Es capicua\n" : "No es capicua\n");
    return 0;
}
