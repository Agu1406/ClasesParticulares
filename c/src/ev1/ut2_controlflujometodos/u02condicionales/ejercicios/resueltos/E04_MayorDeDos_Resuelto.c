/*
E04 - Mayor de dos numeros (RESUELTO)

ENUNCIADO:
  Pide dos enteros y muestra cual es el mayor, o 'Son iguales'.

EJEMPLO DE EJECUCION:
  Numeros: 12 30
  El mayor es 30

PISTA:
  Tres casos: a > b, b > a o iguales.

SOLUCION:
  if / else if / else cubre los tres casos posibles.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0;
    printf("Numeros: ");
    scanf("%d %d", &a, &b);
    if (a > b) {
        printf("El mayor es %d\n", a);
    } else if (b > a) {
        printf("El mayor es %d\n", b);
    } else {
        printf("Son iguales\n");
    }
    return 0;
}
