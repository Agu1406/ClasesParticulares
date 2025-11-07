#include <stdio.h>
#include <stdlib.h>
#include <time.h>
/*
int => significa "números enteros".
*/

typedef struct {
    int elementos[100];
    int tope;
} Pila;

int main() {
    // Utilizando la estructura de arriba creo una pila de platos.
    Pila pilaDePlatos;
    
    // Inicializar la pila: cuando está vacía, el tope es -1
    pilaDePlatos.tope = -1;

    // Variable para controlar la "N" cantidad de platos.
    int cantidadTotalPlatos;
    // Variable que dice que cantidad de platos rojos hay.
    int cantidadPlatosRojos;
    // Variable que dice que cantidad de platos azules hay.
    int cantidadPlatosAzules;
    // Variable que dice que cantidad de platos amarillos hay.
    int cantidadPlatosAmarillos;
    
    // Variables para la simulación
    int accion;  // 1 = lavar, 2 = servir
    int colorPlato;  // 1 = rojo, 2 = azul, 3 = amarillo
    int platoServido;
    
    // Variables para contar platos por color cuando mostramos el estado
    int platosRojos;
    int platosAzules;
    int platosAmarillos;
    int i;  // Variable para los bucles
    
    // Variable para controlar si el programa continúa
    int continuar = 1;
    int opcion;  // Variable para leer la opción del usuario (1, 2 o 3)

    // Inicializar el generador de números aleatorios
    srand(time(NULL));

    // Mensaje de bienvenida al programa.
    printf("Bienvenido a la simulacion de lavado y servido de platos.\n\n");

    // Pedimos por pantalla y por teclado la cantidad de platos totales.
    printf("Dime que cantidad de platos rojos hay en total: ");
    scanf("%d", &cantidadPlatosRojos);

    // Pedimos por pantalla y por teclado la cantidad de platos totales.
    printf("Dime que cantidad de platos azules hay en total: ");
    scanf("%d", &cantidadPlatosAzules);

    // Pedimos por pantalla y por teclado la cantidad de platos totales.
    printf("Dime que cantidad de platos amarillos hay en total: ");
    scanf("%d", &cantidadPlatosAmarillos);

    // Sumamos todos los platos para saber cuantos platos hay en total en el restaurante.
    cantidadTotalPlatos = cantidadPlatosRojos + cantidadPlatosAzules + cantidadPlatosAmarillos;
    
    printf("\nTotal de platos en el restaurante: %d\n", cantidadTotalPlatos);
    printf("La simulacion comenzara. Los platos se lavan y sirven simultaneamente.\n");
    printf("Despues de cada accion podras elegir:\n");
    printf("  1 - Ver el estado de la pila\n");
    printf("  2 - Continuar con la simulacion\n");
    printf("  3 - Salir del programa\n\n");

    /*
    Bucle principal de simulación:
    - En cada iteración, aleatoriamente se decide si lavar (apilar) o servir (desapilar)
    - Los platos se lavan y sirven al mismo tiempo
    - Después de cada acción, el usuario puede elegir ver el estado, continuar o salir
    */
    while (continuar) {
        // Generar aleatoriamente si se lava (1) o se sirve (2) un plato
        accion = 1 + rand() % 2;
        
        if (accion == 1) {
            // LAVAR un plato (apilar)
            // Verificar que la pila no esté llena (tope < 99) y que no hayamos lavado todos los platos
            if (pilaDePlatos.tope < 99 && (pilaDePlatos.tope + 1) < cantidadTotalPlatos) {
                // Generar aleatoriamente el color del plato (1, 2 o 3)
                colorPlato = 1 + rand() % 3;
                
                // Apilar el plato: aumentar el tope y guardar el color
                pilaDePlatos.tope++;
                pilaDePlatos.elementos[pilaDePlatos.tope] = colorPlato;
                
                // Mostrar qué plato se lavó
                if (colorPlato == 1) {
                    printf("Se lavo un plato ROJO\n");
                } else if (colorPlato == 2) {
                    printf("Se lavo un plato AZUL\n");
                } else if (colorPlato == 3) {
                    printf("Se lavo un plato AMARILLO\n");
                }
            } else {
                printf("Todos los platos ya estan lavados\n");
            }
        } else {
            // SERVIR un plato (desapilar)
            // Verificar que la pila no esté vacía (tope >= 0)
            if (pilaDePlatos.tope >= 0) {
                // Guardar el color del plato que está en el tope
                platoServido = pilaDePlatos.elementos[pilaDePlatos.tope];
                
                // Desapilar: disminuir el tope
                pilaDePlatos.tope--;
                
                // Mostrar qué plato se sirvió
                printf("Se sirvio un plato ");
                if (platoServido == 1) {
                    printf("ROJO\n");
                } else if (platoServido == 2) {
                    printf("AZUL\n");
                } else if (platoServido == 3) {
                    printf("AMARILLO\n");
                }
            } else {
                printf("No hay platos disponibles para servir\n");
            }
        }
        
        // Después de cada acción, preguntar al usuario qué quiere hacer
        printf("\n¿Que deseas hacer?\n");
        printf("  1 - Ver el estado de la pila\n");
        printf("  2 - Continuar con la simulacion\n");
        printf("  3 - Salir del programa\n");
        printf("Ingresa tu opcion (1, 2 o 3): ");
        scanf("%d", &opcion);
        
        if (opcion == 1) {
            // Mostrar el estado de la pila
            // Inicializar contadores
            platosRojos = 0;
            platosAzules = 0;
            platosAmarillos = 0;
            
            // Contar platos por color en la pila
            // Recorremos desde la base (0) hasta el tope de la pila
            for (i = 0; i <= pilaDePlatos.tope; i++) {
                if (pilaDePlatos.elementos[i] == 1) {
                    platosRojos++;
                } else if (pilaDePlatos.elementos[i] == 2) {
                    platosAzules++;
                } else if (pilaDePlatos.elementos[i] == 3) {
                    platosAmarillos++;
                }
            }
            
            // Mostrar el estado actual
            printf("\n=== ESTADO ACTUAL DE LA PILA ===\n");
            printf("Total de platos en la pila: %d\n", pilaDePlatos.tope + 1);
            printf("Platos rojos disponibles: %d\n", platosRojos);
            printf("Platos azules disponibles: %d\n", platosAzules);
            printf("Platos amarillos disponibles: %d\n", platosAmarillos);
            printf("Platos disponibles para lavar: %d\n", cantidadTotalPlatos - (pilaDePlatos.tope + 1));
            printf("================================\n");
            
            // Después de mostrar el estado, preguntar si quiere continuar o salir
            printf("\n¿Que deseas hacer ahora?\n");
            printf("  2 - Continuar con la simulacion\n");
            printf("  3 - Salir del programa\n");
            printf("Ingresa tu opcion (2 o 3): ");
            scanf("%d", &opcion);
            
            if (opcion == 3) {
                // Salir del programa
                continuar = 0;
                printf("\nSaliendo del programa...\n");
            } else {
                // Continuar
                printf("\nContinuando la simulacion...\n\n");
            }
        } else if (opcion == 2) {
            // Continuar con la simulación
            printf("\nContinuando...\n\n");
        } else if (opcion == 3) {
            // Salir del programa
            continuar = 0;
            printf("\nSaliendo del programa...\n");
        } else {
            // Opción inválida
            printf("\nOpcion invalida. Continuando con la simulacion...\n\n");
        }
    }

    // Mostrar estado final
    // Inicializar contadores
    platosRojos = 0;
    platosAzules = 0;
    platosAmarillos = 0;
    
    // Contar platos por color en la pila
    for (i = 0; i <= pilaDePlatos.tope; i++) {
        if (pilaDePlatos.elementos[i] == 1) {
            platosRojos++;
        } else if (pilaDePlatos.elementos[i] == 2) {
            platosAzules++;
        } else if (pilaDePlatos.elementos[i] == 3) {
            platosAmarillos++;
        }
    }
    
    printf("\n=== ESTADO FINAL ===\n");
    printf("Total de platos en la pila: %d\n", pilaDePlatos.tope + 1);
    printf("Platos rojos disponibles: %d\n", platosRojos);
    printf("Platos azules disponibles: %d\n", platosAzules);
    printf("Platos amarillos disponibles: %d\n", platosAmarillos);
    printf("Platos disponibles para lavar: %d\n", cantidadTotalPlatos - (pilaDePlatos.tope + 1));
    printf("===================\n");
    
    return 0;
}
