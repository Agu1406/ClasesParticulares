/*
 * EJERCICIO 7: Mensaje Multilínea (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Escribe un programa que muestre el siguiente texto usando
 * un solo printf:
 * 
 * Primera línea
 * Segunda línea
 * Tercera línea
 * 
 * SOLUCIÓN:
 * Usamos \n dentro de un solo printf para crear múltiples líneas.
 * \n es el carácter de escape para nueva línea.
 */

#include <stdio.h>

int main(void) {
    printf("Primera línea\nSegunda línea\nTercera línea\n");
    
    return 0;
}

