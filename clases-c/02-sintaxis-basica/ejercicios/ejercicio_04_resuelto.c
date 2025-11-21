/*
 * EJERCICIO 4: Operadores de Incremento y Decremento (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Dada una variable int numero = 10:
 * 1. Muestra el valor inicial
 * 2. Incrementa numero usando ++ y muestra el resultado
 * 3. Decrementa numero usando -- y muestra el resultado
 * 4. Usa numero++ y muestra el valor (post-incremento)
 * 5. Usa ++numero y muestra el valor (pre-incremento)
 * 
 * SOLUCIÓN:
 * La diferencia entre ++numero (pre-incremento) y numero++ (post-incremento)
 * es cuándo se incrementa: antes o después de usar el valor.
 */

#include <stdio.h>

int main(void) {
    int numero = 10;
    
    printf("Valor inicial: %d\n", numero);
    
    // Incremento
    numero++;
    printf("Después de numero++: %d\n", numero);
    
    // Decremento
    numero--;
    printf("Después de numero--: %d\n", numero);
    
    // Post-incremento: primero usa el valor, luego incrementa
    printf("numero++ (post): %d\n", numero++);
    printf("Valor después: %d\n", numero);
    
    // Pre-incremento: primero incrementa, luego usa el valor
    printf("++numero (pre): %d\n", ++numero);
    printf("Valor después: %d\n", numero);
    
    return 0;
}

