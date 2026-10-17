/*
E07 - Menor de tres numeros (RESUELTO)

ENUNCIADO:
  Pide tres enteros y muestra el menor (sin usar ternario).

EJEMPLO DE EJECUCION:
  Numeros: 9 4 7
  El menor es 4

PISTA:
  Parte de menor = a y actualizalo si b o c son menores.

SOLUCION:
  Patron 'candidato': se asume el primero y se corrige con cada comparacion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0, c = 0;
    printf("Numeros: ");
    scanf("%d %d %d", &a, &b, &c);
    int menor = a;
    if (b < menor) {
        menor = b;
    }
    if (c < menor) {
        menor = c;
    }
    printf("El menor es %d\n", menor);
    return 0;
}
