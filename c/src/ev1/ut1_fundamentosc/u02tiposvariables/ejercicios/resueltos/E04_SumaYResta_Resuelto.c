/*
E04 - Suma, resta, producto y division (RESUELTO)

ENUNCIADO:
  Con a = 20 y b = 6 muestra la suma, resta, producto, division entera y resto.
  Cada resultado en su linea con la operacion escrita.

EJEMPLO DE EJECUCION:
  20 + 6 = 26
  20 - 6 = 14
  20 * 6 = 120
  20 / 6 = 3
  20 % 6 = 2

PISTA:
  Para escribir el simbolo % dentro de printf usa %%.

SOLUCION:
  Las cinco operaciones basicas; la division entera descarta el decimal.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 20, b = 6;
    printf("%d + %d = %d\n", a, b, a + b);
    printf("%d - %d = %d\n", a, b, a - b);
    printf("%d * %d = %d\n", a, b, a * b);
    printf("%d / %d = %d\n", a, b, a / b);
    printf("%d %% %d = %d\n", a, b, a % b);
    return 0;
}
