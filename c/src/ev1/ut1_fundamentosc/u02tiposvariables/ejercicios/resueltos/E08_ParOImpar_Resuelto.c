/*
E08 - Par o impar con modulo (RESUELTO)

ENUNCIADO:
  Para n = 17 muestra el resto de dividir entre 2 y, mediante una expresion que
  valga 1 o 0 (n % 2 == 0), si el numero es par.

EJEMPLO DE EJECUCION:
  Resto: 1
  Es par (1 si / 0 no): 0

PISTA:
  El resultado de una comparacion es un int: 1 si es cierta y 0 si es falsa.

SOLUCION:
  n % 2 == 0 vale 1 cuando n es par y 0 cuando es impar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 17;
    int resto = n % 2;
    int es_par = (n % 2 == 0);
    printf("Resto: %d\n", resto);
    printf("Es par (1 si / 0 no): %d\n", es_par);
    return 0;
}
