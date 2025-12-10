/*
 * EJERCICIO 1: Declaración de Variables (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Declara variables de los siguientes tipos y asígnales valores:
 * - Una variable int llamada "edad" con valor 20
 * - Una variable float llamada "altura" con valor 1.75
 * - Una variable char llamada "inicial" con valor 'J'
 * - Una variable double llamada "pi" con valor 3.141592653589793
 * 
 * SOLUCIÓN:
 * Declaramos cada variable con su tipo correspondiente y le asignamos
 * el valor. Luego usamos printf con los especificadores de formato
 * correctos para mostrar cada valor.
 */

#include <stdio.h>

int main(void) {
    // Declaración e inicialización de variables
    int edad = 20;
    float altura = 1.75f;
    char inicial = 'J';
    double pi = 3.141592653589793;
    
    // Mostrar los valores
    printf("Edad: %d años\n", edad);
    printf("Altura: %.2f metros\n", altura);
    printf("Inicial: %c\n", inicial);
    printf("Pi: %.15lf\n", pi);
    
    return 0;
}

