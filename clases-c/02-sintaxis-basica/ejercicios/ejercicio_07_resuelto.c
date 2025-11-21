/*
 * EJERCICIO 7: Operadores Lógicos (RESUELTO)
 * 
 * INSTRUCCIONES:
 * Dadas tres variables:
 * - int edad = 25
 * - bool tiene_licencia = 1 (true)
 * - int temperatura = 30
 * 
 * Evalúa y muestra el resultado de varias expresiones lógicas
 * 
 * SOLUCIÓN:
 * Los operadores lógicos combinan condiciones booleanas.
 * && requiere que ambas sean verdaderas, || requiere al menos una,
 * y ! invierte el valor.
 */

#include <stdio.h>
#include <stdbool.h>

int main(void) {
    int edad = 25;
    bool tiene_licencia = 1;  // true
    int temperatura = 30;
    
    printf("Edad: %d\n", edad);
    printf("Tiene licencia: %d\n", tiene_licencia);
    printf("Temperatura: %d°C\n\n", temperatura);
    
    // AND: ambas condiciones deben ser verdaderas
    int puede_conducir = (edad >= 18) && tiene_licencia;
    printf("Puede conducir (edad >= 18 && tiene_licencia): %d\n", puede_conducir);
    
    // OR: al menos una condición debe ser verdadera
    int clima_extremo = (temperatura < 0) || (temperatura > 35);
    printf("Clima extremo (temp < 0 || temp > 35): %d\n", clima_extremo);
    
    // NOT: invierte el valor
    int no_tiene_licencia = !tiene_licencia;
    printf("No tiene licencia (!tiene_licencia): %d\n", no_tiene_licencia);
    
    // Combinación de condiciones
    int edad_laboral = (edad >= 18) && (edad <= 65);
    printf("Edad laboral (18-65): %d\n", edad_laboral);
    
    return 0;
}

