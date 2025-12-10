/*
 * EJERCICIO 3: Variables y Constantes (RESUELTO)
 * 
 * INSTRUCCIONES:
 * 1. Crea una constante llamada PI con valor 3.14159 usando #define
 * 2. Crea una constante llamada GRAVEDAD con valor 9.81 usando const
 * 3. Crea una variable int llamada radio con valor 5
 * 4. Calcula y muestra el área de un círculo (área = PI * radio²)
 * 5. Calcula y muestra la circunferencia (2 * PI * radio)
 * 
 * SOLUCIÓN:
 * Usamos #define para constantes que se reemplazan antes de compilar
 * y const para constantes que tienen tipo. Para calcular el área,
 * necesitamos convertir el radio a float para obtener decimales.
 */

#include <stdio.h>

// Constante usando #define
#define PI 3.14159

int main(void) {
    // Constante usando const
    const float GRAVEDAD = 9.81f;
    
    // Variable
    int radio = 5;
    
    // Calcular área (convertimos radio a float para obtener decimales)
    float area = PI * radio * radio;
    float circunferencia = 2 * PI * radio;
    
    printf("Radio: %d\n", radio);
    printf("Área del círculo: %.2f\n", area);
    printf("Circunferencia: %.2f\n", circunferencia);
    printf("Gravedad: %.2f m/s²\n", GRAVEDAD);
    
    return 0;
}

