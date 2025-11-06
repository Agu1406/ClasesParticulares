#include <stdio.h>
#include <stdlib.h>

#define MAX_NUMEROS 100
#define DIVISORES_POR_NUMERO 5

/**
 * Ejercicio 6: Usando Arreglo y Registro
 * Elaborar un programa que:
 * - Ingrese N números mayores que un número dado
 * - Calcule y almacene sus 5 primeros divisores
 * 
 * Estructura:
 * - Registro: contiene el número y sus 5 divisores
 * - Arreglo: contiene N registros
 */

// Registro (estructura) que almacena un número y sus 5 divisores
typedef struct {
    int numero;
    int divisores[DIVISORES_POR_NUMERO];
} RegistroNumero;

// Arreglo de registros
typedef RegistroNumero ArregloRegistros[MAX_NUMEROS];

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

// Función para mostrar el contenido del arreglo de registros
void mostrarArregloRegistros(ArregloRegistros arreglo, int cantidadNumeros) {
    int i;
    int j;
    
    printf("\n=== Contenido del Arreglo de Registros ===\n");
    printf("%-10s", "Numero");
    for (j = 0; j < DIVISORES_POR_NUMERO; j++) {
        printf("Divisor %-3d", j + 1);
    }
    printf("\n");
    printf("------------------------------------------------------------\n");
    
    // Bucle for que recorre cada registro del arreglo
    for (i = 0; i < cantidadNumeros; i++) {
        printf("%-10d", arreglo[i].numero);
        
        // Bucle for que muestra los 5 divisores del registro
        for (j = 0; j < DIVISORES_POR_NUMERO; j++) {
            printf("%-10d", arreglo[i].divisores[j]);
        }
        printf("\n");
    }
}

int main() {
    // Arreglo de registros según la estructura definida
    ArregloRegistros arreglo;
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
    
    printf("=== Ejercicio 6: Numeros y Divisores usando Arreglo y Registro ===\n");
    printf("Capacidad maxima: %d numeros\n\n", MAX_NUMEROS);
    
    // Solicitamos el número límite
    printf("Ingrese el numero limite (los numeros deben ser mayores que este): ");
    scanf("%d", &numeroLimite);
    
    // Bucle do-while que permite ingresar números hasta que el usuario decida parar
    do {
        // Condición if para verificar si aún hay espacio en el arreglo
        if (cantidadNumeros >= MAX_NUMEROS) {
            printf("Arreglo lleno, no se pueden agregar mas numeros.\n");
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
        
        // Guardamos el número en el registro actual
        arreglo[cantidadNumeros].numero = numero;
        
        // Encontramos los 5 primeros divisores del número
        encontrarDivisores(numero, divisoresTemp);
        
        // Bucle for que copia los divisores al registro (campo divisores del registro)
        for (i = 0; i < DIVISORES_POR_NUMERO; i++) {
            arreglo[cantidadNumeros].divisores[i] = divisoresTemp[i];
        }
        
        // Incrementamos el contador de números almacenados
        cantidadNumeros++;
        
        printf("Numero %d y sus divisores almacenados correctamente.\n", numero);
        printf("¿Desea ingresar otro numero? (s/n): ");
        scanf(" %c", &continuar);
        
    } while (continuar == 's' || continuar == 'S');
    
    // Condición if para verificar si se almacenaron números
    if (cantidadNumeros > 0) {
        // Mostramos el contenido del arreglo de registros
        mostrarArregloRegistros(arreglo, cantidadNumeros);
        
        printf("\n=== Resumen ===\n");
        printf("Total de numeros almacenados: %d\n", cantidadNumeros);
        printf("Numero limite utilizado: %d\n", numeroLimite);
        
        // Ejemplo de acceso a un registro específico
        printf("\n=== Ejemplo de acceso a registros ===\n");
        if (cantidadNumeros > 0) {
            printf("Primer registro:\n");
            printf("  Numero: %d\n", arreglo[0].numero);
            printf("  Primer divisor: %d\n", arreglo[0].divisores[0]);
            printf("  Segundo divisor: %d\n", arreglo[0].divisores[1]);
        }
    } else {
        printf("\nNo se almacenaron numeros.\n");
    }
    
    return 0;
}

