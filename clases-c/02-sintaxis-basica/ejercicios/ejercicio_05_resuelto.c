/*
 * EJERCICIO 5: Operadores de Asignación Compuesta (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Dada una variable int valor = 20:
 * 1. Usa += para sumarle 5 y muestra el resultado
 * 2. Usa -= para restarle 3 y muestra el resultado
 * 3. Usa *= para multiplicarlo por 2 y muestra el resultado
 * 4. Usa /= para dividirlo entre 4 y muestra el resultado
 * 
 * SOLUCIÓN:
 * Los operadores de asignación compuesta son una forma abreviada
 * de escribir operaciones comunes. Son más eficientes y legibles.
 */

#include <stdio.h>

int main(void) {
    int valor = 20;
    
    printf("Valor inicial: %d\n", valor);
    
    valor += 5;  // Equivale a: valor = valor + 5
    printf("Después de += 5: %d\n", valor);
    
    valor -= 3;  // Equivale a: valor = valor - 3
    printf("Después de -= 3: %d\n", valor);
    
    valor *= 2;  // Equivale a: valor = valor * 2
    printf("Después de *= 2: %d\n", valor);
    
    valor /= 4;  // Equivale a: valor = valor / 4
    printf("Después de /= 4: %d\n", valor);
    
    return 0;
}

