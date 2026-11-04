/*
E02 - Comparaciones (RESUELTO)

ENUNCIADO:
  Con a = 8 y b = 5, muestra el resultado (0 o 1) de las seis comparaciones.
  Con nota = 5, muestra un bool aprobado (nota >= 5).

SOLUCION:
  printf con %d sobre la expresion; bool aprobado = nota >= 5.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

int main(void) {
    int a = 8;
    int b = 5;
    int nota = 5;
    bool aprobado = nota >= 5;

    printf("%d == %d -> %d\n", a, b, a == b);
    printf("%d != %d -> %d\n", a, b, a != b);
    printf("%d < %d -> %d\n", a, b, a < b);
    printf("%d > %d -> %d\n", a, b, a > b);
    printf("%d <= %d -> %d\n", a, b, a <= b);
    printf("%d >= %d -> %d\n", a, b, a >= b);
    printf("aprobado: %d\n", aprobado);
    return 0;
}
