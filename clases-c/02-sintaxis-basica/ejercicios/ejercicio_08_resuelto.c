/*
 * EJERCICIO 8: Conversión de Temperatura (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Crea un programa que convierta grados Celsius a Fahrenheit y Kelvin
 * 
 * SOLUCIÓN:
 * Usamos variables float para manejar decimales correctamente.
 * Las fórmulas de conversión son estándar en física.
 */

#include <stdio.h>

int main(void) {
    float celsius = 25.0f;
    
    // Conversión a Fahrenheit: F = C * 9/5 + 32
    float fahrenheit = celsius * 9.0f / 5.0f + 32.0f;
    
    // Conversión a Kelvin: K = C + 273.15
    float kelvin = celsius + 273.15f;
    
    printf("=== CONVERSIÓN DE TEMPERATURA ===\n");
    printf("Celsius:    %.2f°C\n", celsius);
    printf("Fahrenheit: %.2f°F\n", fahrenheit);
    printf("Kelvin:     %.2f K\n", kelvin);
    
    return 0;
}

