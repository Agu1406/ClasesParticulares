#include <stdio.h>
#include <stdlib.h>

#define MAX_NUMEROS 100
#define DIVISORES_POR_NUMERO 5
#define TAMANIO_ARREGLO (MAX_NUMEROS * (1 + DIVISORES_POR_NUMERO))
/**
 * Un array es como un "armario" Sergio, en el puedes guardar
 * muchas cosas de un tipo, ahora por ejemplo creamos un Array
 * (estructura de datos) que puedde guardar números enteros.
 * 
 * En la declaración hay 4 cosas
 * - typedef: Significa que estás declarando algo.
 * - int: Tipo de dato que almacena números enteros.
 * - divisor: El nombre que quieres darle al Array.
 * - [TAMANIO_ARREGLO]: El tamaño del "armario", es decir cuanto espacio tiene para guardar algo.
 */
typedef int divisor[TAMANIO_ARREGLO];

// Función para encontrar los 5 primeros divisores de un número
void encontrarDivisores(int numero, int* divisores) {
    // Variable contador para saber cuántos divisores hemos encontrado
    int contador;
    // Variable para recorrer posibles divisores
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

// Función para mostrar el contenido del arreglo divisor
void mostrarArreglo(divisor arreglo, int cantidadNumeros) {
    // Variable para recorrer el arreglo
    int i;
    // Variable para saber en qué posición estamos dentro de cada número
    int j;
    // Variable para saber qué número estamos mostrando
    int numeroActual;
    
    printf("\n=== Contenido del arreglo ===\n");
    
    // Bucle for que recorre cada número almacenado
    for (numeroActual = 0; numeroActual < cantidadNumeros; numeroActual++) {
        // Calculamos la posición donde empieza este número en el arreglo
        // Cada número ocupa 6 posiciones: 1 para el número + 5 para sus divisores
        i = numeroActual * (1 + DIVISORES_POR_NUMERO);
        
        printf("Numero %d: %d\n", numeroActual + 1, arreglo[i]);
        printf("  Divisores: ");
        
        // Bucle for que muestra los 5 divisores de este número
        for (j = 1; j <= DIVISORES_POR_NUMERO; j++) {
            printf("%d ", arreglo[i + j]);
        }
        printf("\n");
    }
}

int main() {
    // Arreglo según la estructura definida en el enunciado
    divisor arreglo;
    // Variable para almacenar el número ingresado por el usuario
    int numero;
    // Variable para contar cuántos números hemos almacenado
    int cantidadNumeros;
    // Variable para saber en qué posición del arreglo estamos
    int posicion;
    // Variable para almacenar temporalmente los divisores antes de guardarlos
    int divisoresTemp[DIVISORES_POR_NUMERO];
    // Variable para recorrer el arreglo de divisores temporales
    int i;
    // Variable para controlar si el usuario quiere continuar
    char continuar;
    
    // Inicializamos el contador de números almacenados
    cantidadNumeros = 0;
    
    printf("=== Ejercicio 1: Numeros y sus 5 primeros divisores ===\n");
    printf("Capacidad maxima: %d numeros\n\n", MAX_NUMEROS);
    
    // Bucle do-while que permite ingresar números hasta que el usuario decida parar
    do {
        // Condición if para verificar si aún hay espacio en el arreglo
        if (cantidadNumeros >= MAX_NUMEROS) {
            printf("Arreglo lleno, no se pueden agregar mas numeros.\n");
            break;
        }
        
        printf("Ingrese un numero (o -1 para terminar): ");
        scanf("%d", &numero);
        
        // Condición if para verificar si el usuario quiere terminar
        if (numero == -1) {
            break;
        }
        
        // Condición if para verificar si el número es válido (positivo)
        if (numero <= 0) {
            printf("Por favor ingrese un numero positivo.\n");
            continue;
        }
        
        // Calculamos la posición donde vamos a guardar este número y sus divisores
        posicion = cantidadNumeros * (1 + DIVISORES_POR_NUMERO);
        
        // Guardamos el número en la primera posición de su bloque
        arreglo[posicion] = numero;
        
        // Encontramos los 5 primeros divisores del número
        encontrarDivisores(numero, divisoresTemp);
        
        // Bucle for que copia los divisores al arreglo principal
        for (i = 0; i < DIVISORES_POR_NUMERO; i++) {
            arreglo[posicion + 1 + i] = divisoresTemp[i];
        }
        
        // Incrementamos el contador de números almacenados
        cantidadNumeros++;
        
        printf("Numero %d y sus divisores almacenados correctamente.\n", numero);
        printf("¿Desea ingresar otro numero? (s/n): ");
        scanf(" %c", &continuar);
        
    } while (continuar == 's' || continuar == 'S');
    
    // Condición if para verificar si se almacenaron números
    if (cantidadNumeros > 0) {
        // Mostramos el contenido del arreglo
        mostrarArreglo(arreglo, cantidadNumeros);
    } else {
        printf("No se almacenaron numeros.\n");
    }
    
    return 0;
}

