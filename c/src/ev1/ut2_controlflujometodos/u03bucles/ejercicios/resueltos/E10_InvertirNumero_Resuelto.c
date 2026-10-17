/*
E10 - Invertir un numero y capicua (RESUELTO)

ENUNCIADO:
  Pide un entero positivo, muestralo invertido y di si es capicua.

EJEMPLO DE EJECUCION:
  Numero: 12321
  Invertido: 12321
  Es capicua

PISTA:
  invertido = invertido * 10 + n % 10

SOLUCION:
  Se construye el numero invertido cifra a cifra.

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
    while (resto > 0) {
        invertido = invertido * 10 + resto % 10;
        resto /= 10;
    }
    printf("Invertido: %d\n", invertido);
    printf(invertido == n ? "Es capicua\n" : "No es capicua\n");
    return 0;
}
