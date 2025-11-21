/**
 * @file 01_tipos_datos.c
 * @brief EJERCICIO 1: Tipos de Datos Primitivos
 * 
 * OBJETIVO: Conocer los tipos de datos básicos en C
 * 
 * TIPOS DE DATOS EN C:
 * - char: Caracteres (1 byte)
 * - int: Números enteros (4 bytes típicamente)
 * - float: Números decimales de precisión simple (4 bytes)
 * - double: Números decimales de precisión doble (8 bytes)
 * - void: Sin tipo (usado para funciones sin retorno)
 * 
 * @author Agustín. A. Marquez. Piña
 * @date 2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */

#include <stdio.h>

int main(void) {
    // TIPO CHAR: Almacena un solo carácter
    char letra = 'A';
    char numero_char = '5';  // No es el número 5, es el carácter '5'
    printf("Char: %c\n", letra);
    printf("Char como número: %d\n", letra);  // Muestra el código ASCII
    
    // TIPO INT: Números enteros
    int edad = 25;
    int temperatura = -10;
    int cantidad = 1000;
    printf("Edad: %d\n", edad);
    printf("Temperatura: %d\n", temperatura);
    printf("Cantidad: %d\n", cantidad);
    
    // TIPO FLOAT: Números decimales (precisión simple)
    float precio = 19.99f;  // La 'f' indica que es float
    float altura = 1.75f;
    printf("Precio: %.2f\n", precio);  // .2 muestra 2 decimales
    printf("Altura: %.2f metros\n", altura);
    
    // TIPO DOUBLE: Números decimales (precisión doble)
    double pi = 3.141592653589793;
    double distancia = 123456.789;
    printf("Pi: %.15f\n", pi);
    printf("Distancia: %.3f\n", distancia);
    
    // MODIFICADORES DE TIPO
    short int numero_corto = 32767;      // Números pequeños
    long int numero_largo = 2147483647L; // Números grandes
    unsigned int positivo = 100;         // Solo números positivos
    
    printf("Número corto: %hd\n", numero_corto);
    printf("Número largo: %ld\n", numero_largo);
    printf("Número sin signo: %u\n", positivo);
    
    return 0;
}

/*
 * EJERCICIOS:
 * 1. Declara variables de cada tipo y asígnales valores
 * 2. ¿Qué pasa si intentas guardar un número muy grande en un int?
 * 3. Experimenta con printf usando diferentes formatos (%d, %f, %c)
 */

