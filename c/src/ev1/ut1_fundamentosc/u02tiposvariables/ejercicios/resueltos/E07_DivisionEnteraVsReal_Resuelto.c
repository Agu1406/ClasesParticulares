/*
E07 - Division entera frente a division real (RESUELTO)

ENUNCIADO:
  Divide 9 entre 4 de tres formas y muestralas con su etiqueta:
    1) entera (int / int)  2) real con (double) en un operando  3) real y truncada con (int).

EJEMPLO DE EJECUCION:
  Entera: 2
  Real: 2.25
  Truncada: 2

PISTA:
  Con (double)a / b el cast se aplica a 'a' ANTES de dividir.

SOLUCION:
  Basta con convertir un operando a double para que la division sea real.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 9, b = 4;
    int entera = a / b;
    double real = (double)a / b;
    int truncada = (int)real;
    printf("Entera: %d\n", entera);
    printf("Real: %.2f\n", real);
    printf("Truncada: %d\n", truncada);
    return 0;
}
