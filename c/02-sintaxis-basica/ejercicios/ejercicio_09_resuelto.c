/*
 * EJERCICIO 9: Cálculo del Área de un Rectángulo (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Crea un programa que calcule el área y perímetro de un rectángulo
 * 
 * SOLUCIÓN:
 * Usamos las fórmulas matemáticas estándar para rectángulos.
 * El formato %.2f muestra dos decimales para mejor legibilidad.
 */

#include <stdio.h>

int main(void) {
    float base = 10.5f;
    float altura = 7.3f;
    
    // Calcular área y perímetro
    float area = base * altura;
    float perimetro = 2 * (base + altura);
    
    printf("=== RECTÁNGULO ===\n");
    printf("Base:     %.2f\n", base);
    printf("Altura:   %.2f\n", altura);
    printf("Área:     %.2f\n", area);
    printf("Perímetro: %.2f\n", perimetro);
    
    return 0;
}

