/*
E18 - Dividir dos numeros (RESUELTO)

ENUNCIADO:
  Pide dos enteros a y b. Si b != 0 muestra cociente entero y resto; si b == 0 muestra "No se puede dividir".

EJEMPLO DE EJECUCION:
  a = 17, b = 5
  17 / 5 = 3 resto 2

SOLUCION:
  Guarda el caso b == 0.

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
    if (b != 0) {
        printf("%d / %d = %d resto %d\n", a, b, a / b, a % b);
    } else {
        printf("No se puede dividir\n");
    }
    return 0;
}
