/*
E01 - Operaciones basicas con datos del usuario (RESUELTO)

ENUNCIADO:
  Pide dos enteros y muestra suma, resta, producto, cociente entero, resto y
  cociente real (con dos decimales). Si el segundo numero es 0 no hagas ninguna division.

EJEMPLO DE EJECUCION:
  a = 17, b = 5
  17 + 5 = 22
  17 - 5 = 12
  17 * 5 = 85
  17 / 5 = 3 (resto 2)
  17 / 5 = 3.40 (real)

PISTA:
  Para el cociente real convierte un operando: (double)a / b.

SOLUCION:
  Se comprueba b != 0 antes de dividir para evitar el error de ejecucion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0;
    printf("a = ");
    scanf("%d", &a);
    printf("b = ");
    scanf("%d", &b);
    printf("%d + %d = %d\n", a, b, a + b);
    printf("%d - %d = %d\n", a, b, a - b);
    printf("%d * %d = %d\n", a, b, a * b);
    if (b != 0) {
        printf("%d / %d = %d (resto %d)\n", a, b, a / b, a % b);
        printf("%d / %d = %.2f (real)\n", a, b, (double)a / b);
    }
    return 0;
}
