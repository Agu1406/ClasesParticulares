#include <stdio.h>
#include <stdlib.h>

#define CAPACIDAD_MAXIMA 8

// Estructura según el enunciado: typedef cola = array [n] of integer;
// Adaptado a C: un arreglo de enteros que representa la cola
typedef int cola[CAPACIDAD_MAXIMA];

// Función para verificar si la cola está vacía
int estaVacia(int inicio, int fin) {
    // La cola está vacía cuando inicio es igual a fin
    return inicio == fin;
}

// Función para verificar si la cola está llena
int estaLlena(int inicio, int fin, int tamanio) {
    // Variable para calcular el siguiente índice después de fin
    int siguienteFin;
    
    // Calculamos la siguiente posición después de fin (con arreglo circular)
    siguienteFin = (fin + 1) % tamanio;
    
    // La cola está llena si la siguiente posición de fin es igual a inicio
    return siguienteFin == inicio;
}

// Función para agregar una persona a la cola (simular llegada a la taquilla)
int agregarACola(cola c, int* inicio, int* fin, int numeroPersona) {
    // Variable para calcular el siguiente índice después de fin
    int siguienteFin;
    
    // Condición if para verificar si la cola está llena
    if (estaLlena(*inicio, *fin, CAPACIDAD_MAXIMA)) {
        printf("Colision: La cola esta llena. Persona %d no puede entrar.\n", numeroPersona);
        return 0; // Retornamos 0 para indicar que no se pudo agregar
    }
    
    // Calculamos la siguiente posición donde agregar la persona
    siguienteFin = (*fin + 1) % CAPACIDAD_MAXIMA;
    
    // Guardamos el número de persona en la posición fin
    c[*fin] = numeroPersona;
    
    // Actualizamos fin a la siguiente posición
    *fin = siguienteFin;
    
    printf("Persona %d llega a la cola. Posicion actual: %d\n", numeroPersona, *fin);
    
    return 1; // Retornamos 1 para indicar que se agregó correctamente
}

// Función para atender a una persona de la cola (sacar de la cola)
int atenderCola(cola c, int* inicio, int* fin) {
    // Variable para almacenar el número de persona que se va a atender
    int personaAtendida;
    
    // Condición if para verificar si la cola está vacía
    if (estaVacia(*inicio, *fin)) {
        printf("No hay personas en la cola para atender.\n");
        return -1; // Retornamos -1 para indicar que no hay nadie
    }
    
    // Guardamos el número de persona que está en la posición inicio
    personaAtendida = c[*inicio];
    
    // Avanzamos inicio a la siguiente posición (con arreglo circular)
    *inicio = (*inicio + 1) % CAPACIDAD_MAXIMA;
    
    printf("Atendiendo a persona %d. Siguiente en cola: posicion %d\n", personaAtendida, *inicio);
    
    return personaAtendida;
}

// Función para mostrar el estado actual de la cola
void mostrarCola(cola c, int inicio, int fin) {
    // Variable para recorrer la cola
    int i;
    // Variable para contar cuántas personas hay en la cola
    int contador;
    
    printf("\n=== Estado de la cola ===\n");
    
    // Condición if para verificar si la cola está vacía
    if (estaVacia(inicio, fin)) {
        printf("La cola esta vacia.\n");
        return;
    }
    
    printf("Inicio: %d, Fin: %d\n", inicio, fin);
    printf("Personas en la cola: ");
    
    // Inicializamos el contador
    contador = 0;
    
    // Bucle while que recorre la cola desde inicio hasta fin
    i = inicio;
    while (i != fin) {
        printf("%d ", c[i]);
        // Avanzamos al siguiente elemento (con arreglo circular)
        i = (i + 1) % CAPACIDAD_MAXIMA;
        // Incrementamos el contador
        contador++;
    }
    
    printf("\nTotal de personas: %d\n", contador);
}

int main() {
    // Arreglo según la estructura definida en el enunciado
    cola c;
    // Variables según el enunciado: integer fin, inicio;
    int fin;
    int inicio;
    // Variable para almacenar la opción del menú
    int opcion;
    // Variable para llevar cuenta del número de persona que llega
    int numeroPersona;
    // Variable para almacenar el resultado de las operaciones
    int resultado;
    // Variable para inicializar el arreglo
    int i;
    
    // Inicializamos inicio y fin según el enunciado
    inicio = 0;
    fin = 0;
    
    // Inicializamos el contador de personas
    numeroPersona = 1;
    
    // Bucle for para inicializar el arreglo con valores por defecto
    for (i = 0; i < CAPACIDAD_MAXIMA; i++) {
        c[i] = 0;
    }
    
    printf("=== Ejercicio 2: Cola Bancaria ===\n");
    printf("Capacidad maxima: %d personas\n", CAPACIDAD_MAXIMA);
    printf("Control: fin == inicio significa cola vacia\n\n");
    
    // Bucle do-while que muestra el menú hasta que el usuario elija salir
    do {
        printf("\n=== Menu ===\n");
        printf("1. Llegada de persona a la cola\n");
        printf("2. Atender persona\n");
        printf("3. Mostrar estado de la cola\n");
        printf("4. Salir\n");
        printf("Opcion: ");
        scanf("%d", &opcion);
        
        // Switch para manejar las diferentes opciones del menú
        switch (opcion) {
            case 1:
                // Opción 1: Agregar una persona a la cola
                resultado = agregarACola(c, &inicio, &fin, numeroPersona);
                // Condición if para verificar si se agregó correctamente
                if (resultado == 1) {
                    // Si se agregó, incrementamos el número de persona para la siguiente
                    numeroPersona++;
                }
                break;
                
            case 2:
                // Opción 2: Atender a una persona
                resultado = atenderCola(c, &inicio, &fin);
                // Condición if para verificar si se atendió a alguien
                if (resultado == -1) {
                    printf("No se pudo atender porque la cola esta vacia.\n");
                }
                break;
                
            case 3:
                // Opción 3: Mostrar el estado actual de la cola
                mostrarCola(c, inicio, fin);
                break;
                
            case 4:
                // Opción 4: Salir del programa
                printf("Saliendo del programa...\n");
                break;
                
            default:
                // Opción inválida: mostrar mensaje de error
                printf("Opcion invalida. Por favor elija una opcion del 1 al 4.\n");
                break;
        }
        
    } while (opcion != 4);
    
    return 0;
}

