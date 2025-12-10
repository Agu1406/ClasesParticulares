/*
 * EJERCICIO 6: Operadores Relacionales (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Dadas dos variables:
 * - int a = 10
 * - int b = 5
 * 
 * Compara a y b usando todos los operadores relacionales y muestra
 * el resultado (1 para verdadero, 0 para falso)
 * 
 * SOLUCIÓN:
 * Los operadores relacionales comparan dos valores y retornan
 * un resultado booleano (1 = verdadero, 0 = falso).
 */

#include <stdio.h>

int main(void) {
    int a = 10;
    int b = 5;
    
    printf("a = %d, b = %d\n\n", a, b);
    printf("%d == %d: %d\n", a, b, a == b);
    printf("%d != %d: %d\n", a, b, a != b);
    printf("%d < %d: %d\n", a, b, a < b);
    printf("%d > %d: %d\n", a, b, a > b);
    printf("%d <= %d: %d\n", a, b, a <= b);
    printf("%d >= %d: %d\n", a, b, a >= b);
    
    return 0;
}

