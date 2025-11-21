/**
 * @file 01_condicional_if.c
 * @brief EJERCICIO 1: Estructura Condicional if
 * 
 * TEORÍA:
 * Las estructuras condicionales permiten que el programa tome decisiones
 * basadas en condiciones. La estructura if ejecuta un bloque de código
 * solo si una condición es verdadera.
 * 
 * SINTAXIS:
 * if (condicion) {
 *     // código a ejecutar si la condición es verdadera
 * }
 * 
 * if (condicion) {
 *     // código si es verdadero
 * } else {
 *     // código si es falso
 * }
 * 
 * if (condicion1) {
 *     // código si condición1 es verdadera
 * } else if (condicion2) {
 *     // código si condición2 es verdadera
 * } else {
 *     // código si ninguna es verdadera
 * }
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

#include <stdio.h>

int main(void) {
    // EJEMPLO 1: if simple
    printf("=== EJEMPLO 1: if simple ===\n");
    int edad = 18;
    
    if (edad >= 18) {
        printf("Eres mayor de edad\n");
    }
    
    // EJEMPLO 2: if-else
    printf("\n=== EJEMPLO 2: if-else ===\n");
    int numero = -5;
    
    if (numero > 0) {
        printf("El número es positivo\n");
    } else {
        printf("El número no es positivo\n");
    }
    
    // EJEMPLO 3: if-else if-else (múltiples condiciones)
    printf("\n=== EJEMPLO 3: if-else if-else ===\n");
    int calificacion = 85;
    
    if (calificacion >= 90) {
        printf("Calificación: A (Excelente)\n");
    } else if (calificacion >= 80) {
        printf("Calificación: B (Muy bien)\n");
    } else if (calificacion >= 70) {
        printf("Calificación: C (Bien)\n");
    } else if (calificacion >= 60) {
        printf("Calificación: D (Suficiente)\n");
    } else {
        printf("Calificación: F (Reprobado)\n");
    }
    
    // EJEMPLO 4: Condiciones anidadas
    printf("\n=== EJEMPLO 4: if anidados ===\n");
    int temperatura = 25;
    bool llueve = 0;  // 0 = false, 1 = true
    
    if (temperatura > 20) {
        printf("Hace calor\n");
        if (llueve) {
            printf("Pero está lloviendo, mejor quédate en casa\n");
        } else {
            printf("Es un buen día para salir\n");
        }
    } else {
        printf("Hace frío\n");
    }
    
    // EJEMPLO 5: Operadores lógicos en condiciones
    printf("\n=== EJEMPLO 5: Operadores lógicos ===\n");
    int edad_usuario = 25;
    bool tiene_licencia = 1;
    
    // AND (&&): ambas condiciones deben ser verdaderas
    if (edad_usuario >= 18 && tiene_licencia) {
        printf("Puedes conducir\n");
    } else {
        printf("No puedes conducir\n");
    }
    
    // OR (||): al menos una condición debe ser verdadera
    int dia = 6;  // 6 = sábado
    if (dia == 6 || dia == 7) {
        printf("Es fin de semana\n");
    }
    
    // NOT (!): invierte la condición
    bool es_lunes = 0;
    if (!es_lunes) {
        printf("No es lunes\n");
    }
    
    // EJEMPLO 6: Comparación de números
    printf("\n=== EJEMPLO 6: Comparaciones ===\n");
    int a = 10, b = 20;
    
    if (a < b) {
        printf("%d es menor que %d\n", a, b);
    }
    
    if (a != b) {
        printf("%d es diferente de %d\n", a, b);
    }
    
    // EJEMPLO 7: Determinar si un número es par o impar
    printf("\n=== EJEMPLO 7: Número par o impar ===\n");
    int num = 7;
    
    if (num % 2 == 0) {
        printf("%d es par\n", num);
    } else {
        printf("%d es impar\n", num);
    }
    
    return 0;
}

/*
 * EJERCICIOS PRÁCTICOS:
 * 
 * 1. Pide al usuario su edad y determina si es mayor de edad
 * 2. Lee un número y determina si es positivo, negativo o cero
 * 3. Pide 3 números y encuentra el mayor de ellos
 * 4. Determina si un año es bisiesto (divisible por 4 pero no por 100, 
 *    o divisible por 400)
 * 5. Calcula el descuento de un producto:
 *    - Si el precio es mayor a 1000, descuento del 20%
 *    - Si es mayor a 500, descuento del 10%
 *    - Si no, sin descuento
 */

