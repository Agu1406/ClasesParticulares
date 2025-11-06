#include <stdio.h>
#include <stdlib.h>

#define MAX_NUMEROS 100
#define DIVISORES_POR_NUMERO 5

/**
 * Ejercicio 5: Usando Matrices
 * Elaborar un programa que:
 * - Ingrese N números mayores que un número dado
 * - Calcule y almacene sus 5 primeros divisores
 * 
 * Estructura de la matriz:
 * - Filas: cada número ingresado
 * - Columna 0: el número ingresado
 * - Columnas 1-5: los 5 primeros divisores
 */

// Función para encontrar los 5 primeros divisores de un número
void encontrarDivisores(int numero, int divisores[]) {
    int contador;
    int i;
    
    // Inicializamos el contador de divisores
    contador = 0;
    
    // Bucle for que recorre desde 1 hasta el número buscando divisores
    for (i = 1; i <= numero && contador < DIVISORES_POR_NUMERO; i++) {
        // Condición if para verificar si i es divisor del número
        if (numero % i == 0) {
            // Si es divisor, lo guardamos en el arreglo
            divisores[contador] = i;
            // Incrementamos el contador de divisores encontrados
            contador++;
        }
    }
    
    // Mientras no hayamos encontrado 5 divisores, completamos con ceros
    while (contador < DIVISORES_POR_NUMERO) {
        divisores[contador] = 0;
        contador++;
    }
}

// Función para mostrar la matriz completa
void mostrarMatriz(int matriz[][DIVISORES_POR_NUMERO + 1], int cantidadNumeros) {
    int i;
    int j;
    
    printf("\n=== Contenido de la Matriz ===\n");
    printf("%-10s", "Numero");
    for (j = 1; j <= DIVISORES_POR_NUMERO; j++) {
        printf("Divisor %-3d", j);
    }
    printf("\n");
    printf("------------------------------------------------------------\n");
    
    // Bucle for que recorre cada fila (cada número)
    for (i = 0; i < cantidadNumeros; i++) {
        printf("%-10d", matriz[i][0]);
        
        // Bucle for que muestra los 5 divisores
        for (j = 1; j <= DIVISORES_POR_NUMERO; j++) {
            printf("%-10d", matriz[i][j]);
        }
        printf("\n");
    }
}

int main() {
    // Matriz: filas = números, columnas = número + 5 divisores
    int matriz[MAX_NUMEROS][DIVISORES_POR_NUMERO + 1];
    // Variable para almacenar el número límite dado por el usuario
    int numeroLimite;
    // Variable para almacenar el número ingresado
    int numero;
    // Variable para contar cuántos números hemos almacenado
    int cantidadNumeros;
    // Variable para almacenar temporalmente los divisores antes de guardarlos
    int divisoresTemp[DIVISORES_POR_NUMERO];
    // Variable para recorrer el arreglo de divisores temporales
    int i;
    // Variable para controlar si el usuario quiere continuar
    char continuar;
    
    // Inicializamos el contador de números almacenados
    cantidadNumeros = 0;
    
    printf("=== Ejercicio 5: Numeros y Divisores usando Matrices ===\n");
    printf("Capacidad maxima: %d numeros\n\n", MAX_NUMEROS);
    
    // Solicitamos el número límite
    printf("Ingrese el numero limite (los numeros deben ser mayores que este): ");
    scanf("%d", &numeroLimite);
    
    // Bucle do-while que permite ingresar números hasta que el usuario decida parar
    do {
        // Condición if para verificar si aún hay espacio en la matriz
        if (cantidadNumeros >= MAX_NUMEROS) {
            printf("Matriz llena, no se pueden agregar mas numeros.\n");
            break;
        }
        
        printf("\nIngrese un numero mayor que %d (o -1 para terminar): ", numeroLimite);
        scanf("%d", &numero);
        
        // Condición if para verificar si el usuario quiere terminar
        if (numero == -1) {
            break;
        }
        
        // Condición if para verificar si el número es mayor que el límite
        if (numero <= numeroLimite) {
            printf("Error: El numero debe ser mayor que %d.\n", numeroLimite);
            continue;
        }
        
        // Guardamos el número en la columna 0 de la fila actual
        matriz[cantidadNumeros][0] = numero;
        
        // Encontramos los 5 primeros divisores del número
        encontrarDivisores(numero, divisoresTemp);
        
        // Bucle for que copia los divisores a la matriz (columnas 1-5)
        for (i = 0; i < DIVISORES_POR_NUMERO; i++) {
            matriz[cantidadNumeros][i + 1] = divisoresTemp[i];
        }
        
        // Incrementamos el contador de números almacenados
        cantidadNumeros++;
        
        printf("Numero %d y sus divisores almacenados correctamente.\n", numero);
        printf("¿Desea ingresar otro numero? (s/n): ");
        scanf(" %c", &continuar);
        
    } while (continuar == 's' || continuar == 'S');
    
    // Condición if para verificar si se almacenaron números
    if (cantidadNumeros > 0) {
        // Mostramos el contenido de la matriz
        mostrarMatriz(matriz, cantidadNumeros);
        
        printf("\n=== Resumen ===\n");
        printf("Total de numeros almacenados: %d\n", cantidadNumeros);
        printf("Numero limite utilizado: %d\n", numeroLimite);
    } else {
        printf("\nNo se almacenaron numeros.\n");
    }
    
    return 0;
}

