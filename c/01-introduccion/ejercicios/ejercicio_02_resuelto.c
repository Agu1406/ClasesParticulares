/*
 * EJERCICIO 2: Múltiples Líneas (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Escribe un programa que muestre tres líneas diferentes:
 * Línea 1: "Bienvenido a la programación en C"
 * Línea 2: "Estoy aprendiendo los fundamentos"
 * Línea 3: "Este lenguaje es muy poderoso"
 * 
 * SOLUCIÓN:
 * Podemos usar múltiples printf o un solo printf con \n
 * para crear saltos de línea. \n es el carácter de nueva línea.
 */

#include <stdio.h>

int main(void) {
    // Opción 1: Múltiples printf
    printf("Bienvenido a la programación en C\n");
    printf("Estoy aprendiendo los fundamentos\n");
    printf("Este lenguaje es muy poderoso\n");
    
    // Opción 2: Un solo printf con múltiples \n
    // printf("Bienvenido a la programación en C\nEstoy aprendiendo los fundamentos\nEste lenguaje es muy poderoso\n");
    
    return 0;
}

