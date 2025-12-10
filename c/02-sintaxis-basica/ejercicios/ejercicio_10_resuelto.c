/*
 * EJERCICIO 10: Programa Integrador (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Crea un programa completo que calcule el precio final de un producto
 * aplicando descuento e IVA
 * 
 * SOLUCIÓN:
 * Este ejercicio integra todos los conceptos aprendidos:
 * constantes, variables, operadores aritméticos y formato de salida.
 */

#include <stdio.h>

// Constantes usando #define
#define IVA 21.0
#define DESCUENTO 10.0

int main(void) {
    float precio_base = 100.0f;
    
    // Calcular descuento
    float descuento_aplicado = precio_base * (DESCUENTO / 100.0f);
    float precio_con_descuento = precio_base - descuento_aplicado;
    
    // Calcular IVA
    float iva_aplicado = precio_con_descuento * (IVA / 100.0f);
    float precio_final = precio_con_descuento + iva_aplicado;
    
    printf("=== CÁLCULO DE PRECIO FINAL ===\n");
    printf("Precio base:        %.2f €\n", precio_base);
    printf("Descuento (%.0f%%):   -%.2f €\n", DESCUENTO, descuento_aplicado);
    printf("Precio con desc.:   %.2f €\n", precio_con_descuento);
    printf("IVA (%.0f%%):         +%.2f €\n", IVA, iva_aplicado);
    printf("----------------------------\n");
    printf("PRECIO FINAL:       %.2f €\n", precio_final);
    
    return 0;
}

