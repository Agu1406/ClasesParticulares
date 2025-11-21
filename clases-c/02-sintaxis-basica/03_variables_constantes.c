/**
 * @file 03_variables_constantes.c
 * @brief EJERCICIO 2: Variables y Constantes
 * 
 * OBJETIVO: Entender la diferencia entre variables y constantes
 * 
 * VARIABLES: Pueden cambiar su valor durante la ejecución
 * CONSTANTES: No pueden cambiar su valor (usar const o #define)
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

#include <stdio.h>

// Constante usando #define (directiva del preprocesador)
#define PI 3.14159
#define MAX_ESTUDIANTES 30

int main(void) {
    // VARIABLES: Pueden cambiar
    int contador = 0;
    printf("Contador inicial: %d\n", contador);
    
    contador = 10;  // Cambiamos el valor
    printf("Contador después: %d\n", contador);
    
    contador = contador + 5;  // Incrementamos
    printf("Contador incrementado: %d\n", contador);
    
    // CONSTANTES usando const
    const int DIAS_SEMANA = 7;
    const float GRAVEDAD = 9.81f;
    
    printf("Días en la semana: %d\n", DIAS_SEMANA);
    printf("Gravedad: %.2f m/s²\n", GRAVEDAD);
    
    // Intentar cambiar una constante dará error (descomenta para probar):
    // DIAS_SEMANA = 8;  // ERROR: no se puede modificar
    
    // Usando constantes definidas con #define
    printf("Valor de PI: %.5f\n", PI);
    printf("Máximo de estudiantes: %d\n", MAX_ESTUDIANTES);
    
    // REGLAS DE NOMBRES DE VARIABLES:
    // - Deben empezar con letra o guión bajo
    // - Pueden contener letras, números y guiones bajos
    // - Son sensibles a mayúsculas/minúsculas
    // - No pueden ser palabras reservadas (int, if, for, etc.)
    
    int mi_variable = 42;
    int Mi_Variable = 100;  // Diferente a mi_variable
    int _variable_privada = 200;
    int variable123 = 300;
    
    printf("mi_variable: %d\n", mi_variable);
    printf("Mi_Variable: %d\n", Mi_Variable);
    
    return 0;
}

/*
 * EJERCICIOS:
 * 1. Crea variables con nombres descriptivos para almacenar:
 *    - Tu nombre (como string, veremos esto más adelante)
 *    - Tu edad
 *    - Tu altura
 * 2. Crea constantes para valores que no cambian (ej: velocidad de la luz)
 * 3. Experimenta con nombres inválidos y observa los errores
 */

