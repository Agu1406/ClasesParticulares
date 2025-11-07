#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/**
 * Ejercicio 3 - Laboratorio de Datos 2
 * Simulación de lavado y servicio de platos usando Pila (Stack)
 * 
 * PASO 1: Definir qué es un plato
 * Un plato tiene un color (1=Rojo, 2=Azul, 3=Amarillo)
 */

// Definimos los colores posibles usando un enum (enumeración)
typedef enum {
    ROJO = 1,      // Color 1
    AZUL = 2,      // Color 2
    AMARILLO = 3   // Color 3
} ColorPlato;

// Estructura que representa un plato
typedef struct {
    ColorPlato color;  // El color del plato (1, 2 o 3)
} Plato;

/**
 * PASO 2: Definir la Pila (Stack)
 * La pila almacena platos. El último plato lavado está arriba.
 */

#define MAX_PLATOS 100  // N = máximo número de platos que puede tener el restaurante

// Estructura de la pila
typedef struct {
    Plato elementos[MAX_PLATOS];  // Arreglo donde guardamos los platos
    int tope;                      // Índice del último plato apilado (-1 si está vacía)
} PilaPlatos;

/**
 * PASO 3: Funciones básicas de la Pila
 */

// Función para inicializar la pila (empezar con pila vacía)
void inicializarPila(PilaPlatos* p) {
    p->tope = -1;  // -1 significa que no hay platos
}

// Función para verificar si la pila está vacía
int estaVacia(PilaPlatos* p) {
    return p->tope == -1;  // Si tope es -1, no hay platos
}

// Función para verificar si la pila está llena
int estaLlena(PilaPlatos* p) {
    return p->tope == MAX_PLATOS - 1;  // Si tope alcanza el máximo, está llena
}

// Función para lavar un plato (agregar a la pila - PUSH)
void lavarPlato(PilaPlatos* p, ColorPlato color) {
    // Verificamos si hay espacio para más platos
    if (estaLlena(p)) {
        printf("¡Error! No se pueden lavar mas platos. La pila esta llena.\n");
        return;
    }
    
    // Incrementamos el tope (ahora hay un plato más)
    p->tope++;
    
    // Guardamos el nuevo plato en la posición del tope
    p->elementos[p->tope].color = color;
    
    printf("Plato de color %d lavado y apilado.\n", color);
}

// Función para servir un plato (quitar de la pila - POP)
Plato servirPlato(PilaPlatos* p) {
    // Creamos un plato "vacío" para retornar en caso de error
    Plato platoVacio;
    platoVacio.color = 0;  // 0 significa "sin color" (error)
    
    // Verificamos si hay platos para servir
    if (estaVacia(p)) {
        printf("¡Error! No hay platos para servir. La pila esta vacia.\n");
        return platoVacio;
    }
    
    // Guardamos el plato que está en el tope (el último lavado)
    Plato platoServido = p->elementos[p->tope];
    
    // Decrementamos el tope (ahora hay un plato menos)
    p->tope--;
    
    printf("Plato de color %d servido y desapilado.\n", platoServido.color);
    
    return platoServido;
}

/**
 * PASO 4: Función para mostrar el estado actual de los platos
 * Esta función muestra cuántos platos hay y de qué color son
 */
void mostrarPlatosDisponibles(PilaPlatos* p) {
    int i;
    
    printf("\n=== Estado Actual de los Platos ===\n");
    
    // Verificamos si hay platos disponibles
    if (estaVacia(p)) {
        printf("No hay platos disponibles.\n");
    } else {
        // Mostramos la cantidad total
        printf("Cantidad de platos disponibles: %d\n", p->tope + 1);
        printf("\nPlatos en la pila (del mas reciente al mas antiguo):\n");
        
        // Recorremos la pila desde el tope hasta el fondo
        // El tope tiene el último plato lavado (el más reciente)
        for (i = p->tope; i >= 0; i--) {
            printf("  Posicion %d: Color %d", p->tope - i + 1, p->elementos[i].color);
            
            // Mostramos el nombre del color para que sea más claro
            switch (p->elementos[i].color) {
                case ROJO:
                    printf(" (Rojo)\n");
                    break;
                case AZUL:
                    printf(" (Azul)\n");
                    break;
                case AMARILLO:
                    printf(" (Amarillo)\n");
                    break;
                default:
                    printf("\n");
                    break;
            }
        }
    }
    
    printf("====================================\n\n");
}

/**
 * PASO 5: Función auxiliar para obtener el nombre del color
 */
const char* obtenerNombreColor(ColorPlato color) {
    switch (color) {
        case ROJO:
            return "Rojo";
        case AZUL:
            return "Azul";
        case AMARILLO:
            return "Amarillo";
        default:
            return "Desconocido";
    }
}

/**
 * PASO 6: Función principal - Simulación del restaurante
 */
int main() {
    // Variable para la pila de platos
    PilaPlatos pilaPlatos;
    // Variable para la opción del menú
    int opcion;
    // Variable para el color del plato a lavar
    int colorIngresado;
    // Variable para controlar el bucle
    char continuar;
    
    // Inicializamos la pila (empezamos sin platos)
    inicializarPila(&pilaPlatos);
    
    // Inicializamos el generador de números aleatorios
    // (para simular platos con colores aleatorios si el usuario lo desea)
    srand(time(NULL));
    
    printf("=== Simulacion de Lavado y Servicio de Platos ===\n");
    printf("El restaurante tiene capacidad para %d platos.\n", MAX_PLATOS);
    printf("Colores disponibles: 1=Rojo, 2=Azul, 3=Amarillo\n\n");
    
    // Bucle principal del programa
    do {
        // Mostramos el menú
        printf("--- Menu ---\n");
        printf("1. Lavar un plato (Apilar)\n");
        printf("2. Servir un plato (Desapilar)\n");
        printf("3. Mostrar platos disponibles\n");
        printf("4. Lavar varios platos aleatorios\n");
        printf("0. Salir\n");
        printf("Ingrese su opcion: ");
        scanf("%d", &opcion);
        
        // Procesamos la opción seleccionada
        switch (opcion) {
            case 1: {
                // Opción 1: Lavar un plato
                printf("\nIngrese el color del plato a lavar (1=Rojo, 2=Azul, 3=Amarillo): ");
                scanf("%d", &colorIngresado);
                
                // Validamos que el color sea válido
                if (colorIngresado >= 1 && colorIngresado <= 3) {
                    lavarPlato(&pilaPlatos, (ColorPlato)colorIngresado);
                } else {
                    printf("Error: Color no valido. Debe ser 1, 2 o 3.\n");
                }
                break;
            }
            
            case 2: {
                // Opción 2: Servir un plato
                servirPlato(&pilaPlatos);
                break;
            }
            
            case 3: {
                // Opción 3: Mostrar platos disponibles
                mostrarPlatosDisponibles(&pilaPlatos);
                break;
            }
            
            case 4: {
                // Opción 4: Lavar varios platos con colores aleatorios (para pruebas)
                int cantidad;
                int i;
                
                printf("\nCuantos platos desea lavar? ");
                scanf("%d", &cantidad);
                
                printf("Lavando %d platos con colores aleatorios...\n", cantidad);
                for (i = 0; i < cantidad; i++) {
                    // Generamos un color aleatorio (1, 2 o 3)
                    ColorPlato colorAleatorio = (rand() % 3) + 1;
                    lavarPlato(&pilaPlatos, colorAleatorio);
                }
                break;
            }
            
            case 0: {
                // Opción 0: Salir
                printf("Saliendo de la simulacion...\n");
                break;
            }
            
            default: {
                // Opción no válida
                printf("Opcion no valida. Intente de nuevo.\n");
                break;
            }
        }
        
        // Después de cada operación, mostramos el estado actual
        if (opcion != 0 && opcion != 3) {
            mostrarPlatosDisponibles(&pilaPlatos);
        }
        
        // Si no es la opción de salir, preguntamos si quiere continuar
        if (opcion != 0) {
            printf("¿Desea realizar otra operacion? (s/n): ");
            scanf(" %c", &continuar);
            
            if (continuar != 's' && continuar != 'S') {
                opcion = 0;  // Salimos del bucle
            }
        }
        
    } while (opcion != 0);
    
    // Mostramos el estado final
    printf("\n=== Estado Final ===\n");
    mostrarPlatosDisponibles(&pilaPlatos);
    
    return 0;
}

