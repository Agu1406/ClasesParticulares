/**
 * @file 04_operadores_aritmeticos.c
 * @brief EJERCICIO 3: Operadores Aritméticos
 * 
 * OBJETIVO: Aprender a realizar operaciones matemáticas en C
 * 
 * OPERADORES ARITMÉTICOS:
 * + : Suma
 * - : Resta
 * * : Multiplicación
 * / : División
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

#include <stdio.h>

int main(void) {
    int a = 10;
    int b = 3;
    
    // SUMA
    int suma = a + b;
    printf("%d + %d = %d\n", a, b, suma);
    
    // RESTA
    int resta = a - b;
    printf("%d - %d = %d\n", a, b, resta);
    
    // MULTIPLICACIÓN
    int multiplicacion = a * b;
    printf("%d * %d = %d\n", a, b, multiplicacion);
    
    // DIVISIÓN (cuidado: división entera)
    int division = a / b;
    printf("%d / %d = %d\n", a, b, division);  // Resultado: 3 (no 3.33)
    // NOTA: Para obtener decimales, usa casting: (float)a / (float)b
    
    // DIVISIÓN CON DECIMALES
    float x = 10.0f;
    float y = 3.0f;
    float division_decimal = x / y;
    printf("%.2f / %.2f = %.2f\n", x, y, division_decimal);
    
    // OPERADORES DE ASIGNACIÓN COMPUESTA
    int numero = 5;
    printf("Número inicial: %d\n", numero);
    
    numero += 3;  // Equivale a: numero = numero + 3
    printf("Después de += 3: %d\n", numero);
    
    numero -= 2;  // Equivale a: numero = numero - 2
    printf("Después de -= 2: %d\n", numero);
    
    numero *= 2;  // Equivale a: numero = numero * 2
    printf("Después de *= 2: %d\n", numero);
    
    numero /= 3;  // Equivale a: numero = numero / 3
    printf("Después de /= 3: %d\n", numero);
    
    // OPERADORES DE INCREMENTO Y DECREMENTO
    int contador = 5;
    printf("Contador: %d\n", contador);
    
    contador++;  // Incrementa en 1 (post-incremento)
    printf("Después de contador++: %d\n", contador);
    
    ++contador;  // Incrementa en 1 (pre-incremento)
    printf("Después de ++contador: %d\n", contador);
    
    contador--;  // Decrementa en 1
    printf("Después de contador--: %d\n", contador);
    
    // DIFERENCIA ENTRE ++i e i++
    int i = 5;
    int j = ++i;  // i se incrementa primero, luego se asigna a j
    printf("i = %d, j = %d\n", i, j);  // i=6, j=6
    
    int k = 5;
    int l = k++;  // k se asigna a l primero, luego se incrementa
    printf("k = %d, l = %d\n", k, l);  // k=6, l=5
    
    return 0;
}

/*
 * EJERCICIOS:
 * 1. Calcula el área de un círculo (área = π * r²)
 * 2. Convierte grados Celsius a Fahrenheit (F = C * 9/5 + 32)
 * 3. Calcula el promedio de 3 números
 */

