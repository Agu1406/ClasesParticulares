/*
E06 - Numero dentro de un rango (RESUELTO)

ENUNCIADO:
  Pide un entero y di si esta entre 10 y 20 (ambos incluidos).

EJEMPLO DE EJECUCION:
  Numero: 15
  15 esta en el rango [10, 20]

PISTA:
  Un rango se escribe con &&: n >= 10 && n <= 20.

SOLUCION:
  Dos comparaciones unidas con && forman el rango cerrado.

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
    if (n >= 10 && n <= 20) {
        printf("%d esta en el rango [10, 20]\n", n);
    } else {
        printf("%d esta fuera del rango [10, 20]\n", n);
    }
    return 0;
}
