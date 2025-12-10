/**
 * @file 03_bucle_for.c
 * @brief EJERCICIO 3: Bucle for
 * 
 * TEORÍA:
 * Los bucles permiten repetir un bloque de código múltiples veces.
 * El bucle for es ideal cuando sabemos cuántas veces queremos repetir.
 * 
 * SINTAXIS:
 * for (inicialización; condición; incremento) {
 *     // código a repetir
 * }
 * 
 * FUNCIONAMIENTO:
 * 1. Se ejecuta la inicialización (solo una vez)
 * 2. Se evalúa la condición
 * 3. Si es verdadera, se ejecuta el código del bucle
 * 4. Se ejecuta el incremento
 * 5. Se vuelve al paso 2
 * 6. Si la condición es falsa, el bucle termina
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

#include <stdio.h>

int main(void) {
    // EJEMPLO 1: Contar del 1 al 10
    printf("=== EJEMPLO 1: Contar del 1 al 10 ===\n");
    for (int i = 1; i <= 10; i++) {
        printf("%d ", i);
    }
    printf("\n");
    
    // EJEMPLO 2: Contar hacia atrás
    printf("\n=== EJEMPLO 2: Contar hacia atrás ===\n");
    for (int i = 10; i >= 1; i--) {
        printf("%d ", i);
    }
    printf("\n");
    
    // EJEMPLO 3: Tabla de multiplicar
    printf("\n=== EJEMPLO 3: Tabla de multiplicar del 5 ===\n");
    int numero = 5;
    for (int i = 1; i <= 10; i++) {
        printf("%d x %d = %d\n", numero, i, numero * i);
    }
    
    // EJEMPLO 4: Sumar números del 1 al 100
    printf("\n=== EJEMPLO 4: Suma del 1 al 100 ===\n");
    int suma = 0;
    for (int i = 1; i <= 100; i++) {
        suma += i;  // suma = suma + i
    }
    printf("La suma del 1 al 100 es: %d\n", suma);
    
    // EJEMPLO 5: Incrementos diferentes
    printf("\n=== EJEMPLO 5: Contar de 2 en 2 ===\n");
    for (int i = 0; i <= 20; i += 2) {
        printf("%d ", i);
    }
    printf("\n");
    
    // EJEMPLO 6: Bucles anidados (tabla de multiplicar completa)
    printf("\n=== EJEMPLO 6: Bucles anidados ===\n");
    printf("Tablas de multiplicar del 1 al 5:\n");
    for (int i = 1; i <= 5; i++) {
        printf("Tabla del %d: ", i);
        for (int j = 1; j <= 5; j++) {
            printf("%d ", i * j);
        }
        printf("\n");
    }
    
    // EJEMPLO 7: Patrones con asteriscos
    printf("\n=== EJEMPLO 7: Patrón de asteriscos ===\n");
    int filas = 5;
    for (int i = 1; i <= filas; i++) {
        for (int j = 1; j <= i; j++) {
            printf("* ");
        }
        printf("\n");
    }
    
    // EJEMPLO 8: Factorial de un número
    printf("\n=== EJEMPLO 8: Factorial ===\n");
    int n = 5;
    int factorial = 1;
    for (int i = 1; i <= n; i++) {
        factorial *= i;  // factorial = factorial * i
    }
    printf("El factorial de %d es: %d\n", n, factorial);
    
    // EJEMPLO 9: Números pares en un rango
    printf("\n=== EJEMPLO 9: Números pares del 1 al 20 ===\n");
    for (int i = 2; i <= 20; i += 2) {
        printf("%d ", i);
    }
    printf("\n");
    
    // EJEMPLO 10: Potencia de un número
    printf("\n=== EJEMPLO 10: Potencia ===\n");
    int base = 2;
    int exponente = 8;
    int resultado = 1;
    
    for (int i = 0; i < exponente; i++) {
        resultado *= base;
    }
    printf("%d elevado a %d = %d\n", base, exponente, resultado);
    
    // EJEMPLO 11: Bucle con múltiples variables
    printf("\n=== EJEMPLO 11: Múltiples variables ===\n");
    for (int i = 0, j = 10; i < 5; i++, j--) {
        printf("i = %d, j = %d\n", i, j);
    }
    
    // EJEMPLO 12: Bucle infinito (cuidado!)
    printf("\n=== EJEMPLO 12: Bucle controlado ===\n");
    int contador = 0;
    for (;;) {  // Bucle infinito
        contador++;
        if (contador > 5) {
            break;  // Sale del bucle
        }
        printf("Iteración %d\n", contador);
    }
    
    return 0;
}

/*
 * EJERCICIOS PRÁCTICOS:
 * 
 * 1. Imprime todos los números pares del 2 al 50
 * 2. Calcula la suma de los primeros N números naturales
 * 3. Imprime un cuadrado de asteriscos de NxN
 * 4. Calcula la serie de Fibonacci hasta el término N
 * 5. Determina si un número es primo usando un bucle for
 * 6. Imprime un triángulo invertido de números
 * 7. Calcula el promedio de N números ingresados por el usuario
 */

