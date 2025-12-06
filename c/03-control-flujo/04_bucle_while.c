/**
 * @file 04_bucle_while.c
 * @brief EJERCICIO 4: Bucle while
 * 
 * TEORÍA:
 * El bucle while repite un bloque de código mientras una condición
 * sea verdadera. Es útil cuando no sabemos cuántas veces se repetirá.
 * 
 * SINTAXIS:
 * while (condicion) {
 *     // código a repetir
 *     // IMPORTANTE: debe haber algo que cambie la condición
 * }
 * 
 * DIFERENCIAS CON for:
 * - while: se usa cuando no sabemos cuántas iteraciones habrá
 * - for: se usa cuando sabemos cuántas veces se repetirá
 * 
 * PELIGRO: Bucle infinito
 * Si la condición nunca se vuelve falsa, el bucle nunca termina.
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
    int i = 1;
    while (i <= 10) {
        printf("%d ", i);
        i++;  // IMPORTANTE: incrementar para evitar bucle infinito
    }
    printf("\n");
    
    // EJEMPLO 2: Suma hasta que el usuario ingrese 0
    printf("\n=== EJEMPLO 2: Suma hasta ingresar 0 ===\n");
    int numero = 1;  // Inicializamos con un valor distinto de 0
    int suma = 0;
    
    // Simulamos entrada del usuario
    printf("Ingresa números (0 para terminar):\n");
    // En un programa real usaríamos scanf aquí
    // while (numero != 0) {
    //     scanf("%d", &numero);
    //     suma += numero;
    // }
    
    // Para este ejemplo, simulamos valores
    int valores[] = {5, 10, 15, 0};  // 0 para terminar
    int indice = 0;
    numero = valores[indice];
    
    while (numero != 0) {
        suma += numero;
        indice++;
        numero = valores[indice];
    }
    printf("La suma es: %d\n", suma);
    
    // EJEMPLO 3: Validación de entrada
    printf("\n=== EJEMPLO 3: Validación de entrada ===\n");
    int edad = -1;  // Valor inválido inicial
    
    // Simulamos que el usuario debe ingresar una edad válida
    // while (edad < 0 || edad > 120) {
    //     printf("Ingresa tu edad (0-120): ");
    //     scanf("%d", &edad);
    // }
    
    // Para el ejemplo, usamos valores simulados
    int edades[] = {-5, 150, 25};  // Primero inválidas, luego válida
    indice = 0;
    edad = edades[indice];
    
    while (edad < 0 || edad > 120) {
        printf("Edad inválida: %d. Debe estar entre 0 y 120\n", edad);
        indice++;
        edad = edades[indice];
    }
    printf("Edad válida: %d\n", edad);
    
    // EJEMPLO 4: División repetida
    printf("\n=== EJEMPLO 4: División repetida ===\n");
    int numero_div = 100;
    int divisiones = 0;
    
    while (numero_div > 1) {
        numero_div = numero_div / 2;
        divisiones++;
        printf("División %d: %d\n", divisiones, numero_div);
    }
    
    // EJEMPLO 5: Potencia de 2
    printf("\n=== EJEMPLO 5: Potencias de 2 ===\n");
    int potencia = 1;
    int exponente = 0;
    
    while (potencia < 1000) {
        printf("2^%d = %d\n", exponente, potencia);
        potencia *= 2;
        exponente++;
    }
    
    // EJEMPLO 6: Contador con límite
    printf("\n=== EJEMPLO 6: Contador con límite ===\n");
    int contador = 0;
    int limite = 5;
    
    while (contador < limite) {
        printf("Contador: %d\n", contador);
        contador++;
    }
    
    // EJEMPLO 7: Búsqueda en un array (simulado)
    printf("\n=== EJEMPLO 7: Búsqueda ===\n");
    int numeros[] = {3, 7, 2, 9, 5};
    int buscar = 9;
    int encontrado = 0;
    int posicion = 0;
    
    while (posicion < 5 && !encontrado) {
        if (numeros[posicion] == buscar) {
            encontrado = 1;
            printf("Número %d encontrado en posición %d\n", buscar, posicion);
        }
        posicion++;
    }
    
    if (!encontrado) {
        printf("Número %d no encontrado\n", buscar);
    }
    
    // EJEMPLO 8: Menú repetitivo
    printf("\n=== EJEMPLO 8: Menú repetitivo ===\n");
    int opcion = 1;  // 0 para salir
    
    while (opcion != 0) {
        printf("\nMenú:\n");
        printf("1. Opción 1\n");
        printf("2. Opción 2\n");
        printf("0. Salir\n");
        printf("Opción actual: %d\n", opcion);
        
        // Simulamos cambio de opción
        if (opcion == 1) {
            printf("Ejecutando opción 1...\n");
            opcion = 2;  // Cambiamos a opción 2
        } else if (opcion == 2) {
            printf("Ejecutando opción 2...\n");
            opcion = 0;  // Salimos
        }
    }
    printf("Saliendo del menú...\n");
    
    return 0;
}

/*
 * EJERCICIOS PRÁCTICOS:
 * 
 * 1. Pide números al usuario hasta que ingrese un número negativo
 * 2. Calcula el factorial de un número usando while
 * 3. Adivina un número: el programa genera un número y el usuario intenta adivinarlo
 * 4. Lee caracteres hasta encontrar un punto (.)
 * 5. Calcula cuántas veces se puede dividir un número entre 2 antes de llegar a 1
 * 6. Valida que un número esté en un rango específico
 * 
 * IMPORTANTE: Siempre asegúrate de que la condición del while
 * pueda volverse falsa, o tendrás un bucle infinito.
 */

