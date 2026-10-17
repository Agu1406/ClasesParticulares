/*
E07 - Division entera frente a division real (PENDIENTE)

ENUNCIADO:
  Divide 9 entre 4 de tres formas y muestralas con su etiqueta:
    1) entera (int / int)  2) real con (double) en un operando  3) real y truncada con (int).

EJEMPLO DE EJECUCION:
  Entera: 2
  Real: 2.25
  Truncada: 2

PISTA:
  Con (double)a / b el cast se aplica a 'a' ANTES de dividir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 9, b = 4;
    // TODO: division entera
    int entera = 0;
    // TODO: division real con cast
    double real = 0;
    // TODO: division real convertida otra vez a int
    int truncada = 0;
    printf("Entera: %d\n", entera);
    printf("Real: %.2f\n", real);
    printf("Truncada: %d\n", truncada);
    return 0;
}
