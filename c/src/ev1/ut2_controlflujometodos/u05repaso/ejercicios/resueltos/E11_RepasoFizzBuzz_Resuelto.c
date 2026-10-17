/*
E11 - FizzBuzz del 1 al 15 (RESUELTO)

ENUNCIADO:
  Muestra del 1 al 15, uno por linea: 'FizzBuzz' si es multiplo de 3 y 5, 'Fizz' si lo es de 3, 'Buzz' si lo es de 5, y el numero en otro caso.

EJEMPLO DE EJECUCION:
  1
  2
  Fizz
  4
  Buzz
  ...
  FizzBuzz

PISTA:
  Comprueba primero el multiplo de 15.

SOLUCION:
  El orden de las condiciones es lo importante.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    for (int i = 1; i <= 15; i++) {
        if (i % 15 == 0) {
            printf("FizzBuzz\n");
        } else if (i % 3 == 0) {
            printf("Fizz\n");
        } else if (i % 5 == 0) {
            printf("Buzz\n");
        } else {
            printf("%d\n", i);
        }
    }
    return 0;
}
