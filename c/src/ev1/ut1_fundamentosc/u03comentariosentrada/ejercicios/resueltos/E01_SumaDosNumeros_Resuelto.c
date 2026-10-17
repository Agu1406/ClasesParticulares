/*
E01 - Suma de dos numeros (RESUELTO)

ENUNCIADO:
  Pide dos numeros enteros por teclado y muestra su suma, resta y producto.

EJEMPLO DE EJECUCION:
  Primer numero: 12
  Segundo numero: 5
  Suma: 17
  Resta: 7
  Producto: 60

PISTA:
  scanf("%d", &a); recuerda el & delante de la variable.

SOLUCION:
  Cada scanf guarda el dato en su variable; despues se calcula y se muestra.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int a = 0, b = 0;
    printf("Primer numero: ");
    scanf("%d", &a);
    printf("Segundo numero: ");
    scanf("%d", &b);
    printf("Suma: %d\n", a + b);
    printf("Resta: %d\n", a - b);
    printf("Producto: %d\n", a * b);
    return 0;
}
