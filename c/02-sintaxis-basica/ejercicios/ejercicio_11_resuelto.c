/*
 * EJERCICIO 11: Casting y Conversión de Tipos (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Dadas las siguientes variables:
 * - int a = 15
 * - int b = 4
 * 
 * Realiza las siguientes operaciones usando casting
 * 
 * SOLUCIÓN:
 * El casting permite convertir explícitamente entre tipos.
 * Es esencial para obtener resultados decimales en divisiones
 * de enteros y para controlar cómo se manejan los tipos.
 */

#include <stdio.h>

int main(void) {
    int a = 15;
    int b = 4;
    
    // 1. División como float usando casting
    float division = (float)a / (float)b;
    printf("%d / %d = %.2f (con casting)\n", a, b, division);
    printf("%d / %d = %d (sin casting)\n", a, b, a / b);
    
    // 2. Convertir resultado a int (truncamiento)
    int division_entera = (int)division;
    printf("División truncada: %d\n", division_entera);
    
    // 3. Convertir float a int
    float precio = 19.99f;
    int precio_entero = (int)precio;
    printf("Precio: %.2f → Precio entero: %d\n", precio, precio_entero);
    
    // 4. Char a int (código ASCII)
    char letra = 'B';
    int codigo = (int)letra;
    printf("Letra '%c' tiene código ASCII: %d\n", letra, codigo);
    
    // 5. Calcular porcentaje usando casting
    int cantidad = 80;
    float porcentaje = (float)cantidad * 0.25f;
    printf("25%% de %d = %.0f\n", cantidad, porcentaje);
    
    return 0;
}

