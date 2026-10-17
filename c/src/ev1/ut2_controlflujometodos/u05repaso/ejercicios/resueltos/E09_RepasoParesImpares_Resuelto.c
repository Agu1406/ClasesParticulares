/*
E09 - Contar pares e impares con centinela (RESUELTO)

ENUNCIADO:
  Lee enteros hasta que se introduzca 0 (el 0 no cuenta). Muestra cuantos pares y cuantos impares se han introducido.

EJEMPLO DE EJECUCION:
  Numeros (0 para terminar): 3 8 5 2 0
  Pares: 2
  Impares: 2

PISTA:
  El centinela es el valor 0.

SOLUCION:
  Lectura anticipada + while (n != 0) + lectura al final del cuerpo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int pares = 0;
    int impares = 0;
    int n = 0;
    printf("Numeros (0 para terminar): ");
    scanf("%d", &n);
    while (n != 0) {
        if (n % 2 == 0) {
            pares++;
        } else {
            impares++;
        }
        scanf("%d", &n);
    }
    printf("Pares: %d\n", pares);
    printf("Impares: %d\n", impares);
    return 0;
}
