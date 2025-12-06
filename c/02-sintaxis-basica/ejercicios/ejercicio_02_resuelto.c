/*
 * EJERCICIO 2: Operaciones Aritméticas Básicas (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Dadas dos variables:
 * - int a = 15
 * - int b = 4
 * 
 * Calcula y muestra:
 * 1. La suma de a y b
 * 2. La resta de a y b
 * 3. La multiplicación de a y b
 * 4. La división de a entre b
 * 
 * SOLUCIÓN:
 * Usamos los operadores aritméticos básicos. Nota que la división
 * entre enteros da un resultado entero (15/4 = 3, no 3.75).
 */

#include <stdio.h>

int main(void) {
    int a = 15;
    int b = 4;
    
    printf("a = %d, b = %d\n\n", a, b);
    printf("Suma: %d + %d = %d\n", a, b, a + b);
    printf("Resta: %d - %d = %d\n", a, b, a - b);
    printf("Multiplicación: %d * %d = %d\n", a, b, a * b);
    printf("División: %d / %d = %d\n", a, b, a / b);
    
    return 0;
}

