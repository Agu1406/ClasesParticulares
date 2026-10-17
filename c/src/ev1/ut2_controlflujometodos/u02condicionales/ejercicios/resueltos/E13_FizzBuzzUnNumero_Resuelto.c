/*
E13 - FizzBuzz para un numero (RESUELTO)

ENUNCIADO:
  Pide un numero: si es multiplo de 3 y de 5 muestra FizzBuzz; solo de 3, Fizz;
  solo de 5, Buzz; en otro caso el propio numero.

EJEMPLO DE EJECUCION:
  Numero: 30
  FizzBuzz

PISTA:
  Comprueba primero el caso 'multiplo de ambos'.

SOLUCION:
  El caso mas especifico (3 y 5) debe ir el primero de la cadena.

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
    if (n % 3 == 0 && n % 5 == 0) {
        printf("FizzBuzz\n");
    } else if (n % 3 == 0) {
        printf("Fizz\n");
    } else if (n % 5 == 0) {
        printf("Buzz\n");
    } else {
        printf("%d\n", n);
    }
    return 0;
}
