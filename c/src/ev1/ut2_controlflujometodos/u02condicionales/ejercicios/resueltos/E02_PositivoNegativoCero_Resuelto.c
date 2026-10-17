/*
E02 - Positivo, negativo o cero (RESUELTO)

ENUNCIADO:
  Pide un numero real y muestra si es positivo, negativo o cero.

EJEMPLO DE EJECUCION:
  Numero: -4.5
  Negativo

PISTA:
  Usa if / else if / else (tres caminos).

SOLUCION:
  Se comprueban primero > 0 y < 0; lo que queda solo puede ser 0.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double n = 0;
    printf("Numero: ");
    scanf("%lf", &n);
    if (n > 0) {
        printf("Positivo\n");
    } else if (n < 0) {
        printf("Negativo\n");
    } else {
        printf("Cero\n");
    }
    return 0;
}
