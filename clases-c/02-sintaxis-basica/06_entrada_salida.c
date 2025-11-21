/**
 * @file 06_entrada_salida.c
 * @brief EJERCICIO 5: Entrada y Salida de Datos
 * 
 * OBJETIVO: Aprender a leer datos del usuario y mostrarlos
 * 
 * FUNCIONES DE SALIDA:
 * - printf: Imprime texto formateado
 * 
 * FUNCIONES DE ENTRADA:
 * - scanf: Lee datos del teclado
 * - getchar: Lee un solo carácter
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

#include <stdio.h>

int main(void) {
    // SALIDA CON printf
    printf("=== FUNCIONES DE SALIDA ===\n");
    
    // Imprimir texto simple
    printf("Hola, este es un mensaje simple\n");
    
    // Imprimir variables con formato
    int numero = 42;
    float decimal = 3.14f;
    char letra = 'A';
    
    printf("Número entero: %d\n", numero);
    printf("Número decimal: %.2f\n", decimal);
    printf("Carácter: %c\n", letra);
    
    // Múltiples variables en un printf
    printf("Número: %d, Decimal: %.2f, Letra: %c\n", numero, decimal, letra);
    
    // ESPECIFICADORES DE FORMATO:
    // %d o %i: entero
    // %f: float/double
    // %c: carácter
    // %s: cadena de caracteres (veremos más adelante)
    // %x: hexadecimal
    // %o: octal
    
    // ENTRADA CON scanf
    printf("\n=== FUNCIONES DE ENTRADA ===\n");
    
    int edad;
    float altura;
    char inicial;
    
    printf("Ingresa tu edad: ");
    scanf("%d", &edad);  // & es necesario (lo veremos en punteros)
    printf("Tienes %d años\n", edad);
    
    printf("Ingresa tu altura (en metros): ");
    scanf("%f", &altura);
    printf("Mides %.2f metros\n", altura);
    
    printf("Ingresa la inicial de tu nombre: ");
    scanf(" %c", &inicial);  // El espacio antes de %c consume el salto de línea
    printf("Tu inicial es: %c\n", inicial);
    
    // Leer múltiples valores a la vez
    int a, b;
    printf("Ingresa dos números separados por espacio: ");
    scanf("%d %d", &a, &b);
    printf("Suma: %d + %d = %d\n", a, b, a + b);
    
    // EJEMPLO PRÁCTICO: Calculadora simple
    printf("\n=== CALCULADORA SIMPLE ===\n");
    float num1, num2, resultado;
    
    printf("Ingresa el primer número: ");
    scanf("%f", &num1);
    
    printf("Ingresa el segundo número: ");
    scanf("%f", &num2);
    
    resultado = num1 + num2;
    printf("%.2f + %.2f = %.2f\n", num1, num2, resultado);
    
    resultado = num1 - num2;
    printf("%.2f - %.2f = %.2f\n", num1, num2, resultado);
    
    resultado = num1 * num2;
    printf("%.2f * %.2f = %.2f\n", num1, num2, resultado);
    
    if (num2 != 0) {
        resultado = num1 / num2;
        printf("%.2f / %.2f = %.2f\n", num1, num2, resultado);
    } else {
        printf("No se puede dividir por cero\n");
    }
    
    return 0;
}

/*
 * EJERCICIOS:
 * 1. Pide al usuario su nombre, edad y ciudad, y muéstralos
 * 2. Crea un programa que calcule el área de un rectángulo (pide base y altura)
 * 3. Pide 3 números y calcula su promedio
 * 4. Convierte grados Celsius a Fahrenheit (pide Celsius al usuario)
 * 
 * NOTA: Para leer cadenas de texto completas, usaremos fgets (lo veremos más adelante)
 */

