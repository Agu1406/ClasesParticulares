#include <stdio.h>
#include <stdlib.h>
#include <time.h>
/*

int => significa "números enteros".
*/

typedef struct
{
    int elementos[100];
    int tope;
} Pila;

/**
 * Función "push" que permite "empujar" (meter) platos recien lavados dentro
 * de la pila siempre y cuando verifique primer oque aún hay espacio para
 * meter los platos.
 * */
void push(Pila *platos, int color)
{
    // Si "tope" es menor a "99" significa que aún quedan algunas de las 99 cajas vacías.
    if (platos->tope < 99)
    {

        // Anoto en mi papelito "tope" cuantos platos hay dentro del mueble actualmente.
        platos->tope++;

        // Luego de anotarme en un papelito (tope) cuantos platos hay en el mueble, guardo el plato recien lavado.
        platos->elementos[platos->tope] = color;
    }
}
/**
 * Función "pop" que "lee" el color del ultimo plato de la pila, disminuye el tope de platos
 * dentro de la pila y me dice el color del plato que acaba de sacar.
 * */
int pop(Pila *platos)
{
    // Si "tope" es mayor o igual a "0" significa que como minimo hay al menos un plato que puedo sacar.
    if (platos->tope >= 0)
    {

        // Necesito guardar el "color" del plato que este sacando del mueble.
        int color = platos->elementos[platos->tope];

        // Actualizo en mi "papelito" la cantidad de platos que hay actualemnte dentro del mueble.
        platos->tope--;

        // Me dice el color del plato que acabo de sacar.
        return color;
    }

    // Si no se cumple el "if" significa que no hay platos para sacar, devuelve "-1" (error).
    return -1;
}

int main()
{
    // Utilizando la estructura de arriba creo una pila de platos.
    Pila pilaDePlatos;

    // Variable para controlar la "N" cantidad de platos.
    int cantidadTotalPlatos;
    // Variable que dice que cantidad de platos rojos hay.
    int cantidadPlatosRojos;
    // Variable que dice que cantidad de platos azules hay.
    int cantidadPlatosAzules;
    // Variable que dice que cantidad de platos amarillos hay.
    int cantidadPlatosAmarillos; // 300
    // Variable que usaremo par los bucles.
    int posicion;
    // Variable que controla la opción del menú.
    int opcionMenu;
    // Inicializamos la pila de platos vacia.
    pilaDePlatos.tope = -1;

    // Cantida de platos "limpios" (que se pueden servir) que tenemos.
    int platosRojos;
    int platosAzules;
    int platosAmarillos;

    // Declaramos las variables y funciones utilizadas para que el programa elija aleatoriamente.
    int accion;
    srand(time(NULL));
    int colorPlatoLavado;
    int colorPlatoServido;

    // Mensaje de bienvenida al programa.
    printf("Bienvenido a la simulacion de lavado y servido de platos. \n");

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

    // Mensaje que muestra cuantos platos tenemos y como funciona la simulación y sus opciones.
    printf("El total de platos en el restaurante es: %d \n", cantidadTotalPlatos);
    printf("En este programa los platos se lavan y se sirven al mismo tiempo. \n");
    printf("En cualquier momento puedes pulsar las siguientes opciones en el programa: \n");
    printf("Opcion 1: Pausa el programa y muestra información de la pila de platos. \n");
    printf("Opcion 2: Hace que el programa continua otra vez lavando y sirviendo platos. \n");
    printf("Opcion 3: Termina el programa acabando con todo. \n");

    // Mientras la opción del menú no sea (!=) el número 3 es infinito.
    while (opcionMenu != 3)
    {

        // Mostramos con print las opciones del programa.
        printf("\n--- MENU ---\n");
        printf("1. Pausar y mostrar estado de la pila\n");
        printf("2. Continuar lavando y sirviendo platos\n");
        printf("3. Salir del programa\n");
        printf("Elige una opcion: ");

        // "Escaneamos" la opción que se elija desde el teclado.
        scanf("%d", &opcionMenu);

        // Si elige la opcion "1" se ejecuta este "if".
        if (opcionMenu == 1)
        {
            // Opción 1: Pausar y mostrar el estado de la pila
            printf("\n Estado actual del programa y la pila \n");

            // Inicializar contadores
            platosRojos = 0;
            platosAzules = 0;
            platosAmarillos = 0;

            // Contar platos por color en la pila
            // Recorremos desde la base (0) hasta el tope de la pila
            for (posicion = 0; posicion <= pilaDePlatos.tope; posicion++)
            {
                if (pilaDePlatos.elementos[posicion] == 1)
                {
                    platosRojos++;
                }
                else if (pilaDePlatos.elementos[posicion] == 2)
                {
                    platosAzules++;
                }
                else if (pilaDePlatos.elementos[posicion] == 3)
                {
                    platosAmarillos++;
                }
            }

            // Mostrar el estado actual
            printf("Total de platos en la pila: %d\n", pilaDePlatos.tope + 1);
            printf("Platos rojos disponibles: %d\n", platosRojos);
            printf("Platos azules disponibles: %d\n", platosAzules);
            printf("Platos amarillos disponibles: %d\n", platosAmarillos);
            printf("Platos disponibles para lavar: %d\n", cantidadTotalPlatos - (pilaDePlatos.tope + 1));
        }

        // Si elige la opcion "2" se ejecuta este "else if".
        else if (opcionMenu == 2)
        {

            // Ejecutar 10 acciones de lavado y servido
            printf("\nEjecutando simulacion de lavado y servido...\n");
            for (posicion = 0; posicion < 10; posicion++)
            {
                /*
                "rand()" genera números aleatorios entre "0" y "32767".

                Todos los números pares son divisibles entre "2", ejemplos.

                500 / 2 => 250.0 (no sobra nada, no hay decimales).
                200 / 2 => 100.0 (no sobra nada, no hay decimales).
                30 / 2 => 15.0 (no sobra nada, no hay decimales).

                Ningún número impar es divisible entre "2", siempre sobra algo, ejemplos:

                33 / 2 => 16.5 (tiene restos, decimales).
                15 / 2 => 7.5 (tiene restos, decimales).
                32767 / 2 => 16383.5 (tiene restos, decimales).

                Ese "resto" se puede obtener en "C" usando el "%", por ejemplo, si yo
                quiero dividir "15" entre "2" el resultaod sería "7.5", ¿Como lo obtengo?

                int resultado = 15 / 2 => 7;
                int restos = 15 % 2 = 0.5;

                Imagina que "rand()" genera el número más grande que puede generar, el
                "32767" y lo divide entre "2" usando el "%", el resultado es "0.5"

                Lo que hay entender aquí que es todos los pares pares tiene un resto "0" y
                todos los números impares tienen un resto "0.5".
                */
                accion = 1 + rand() % 2; // 1 <=> 2

                // Si "accion" es igual a "1" haz esto...
                if (accion == 1)
                {

                    /*
                    Antes de ponerme a lavar platos, necesito revisar dos cosas:

                    Primero: Tengo espacio suficiente para guardar los platos después de lavarlos.

                    Segundo: Podrían estar limpios todos los platos, si están todos limpios no
                    hago nada.

                    El "tope" de la pila es lo que me dice cuantos platos limpios tengo en la pila
                    porque la "pila" guarda platos limpios, no sucios, el "tope" funciona con
                    posiciones, si la posicion "99" tiene un plato, signific que la pila esta
                    llena de platos limpios.

                    Si esta llena no puedo seguir lavando platos.

                    Si tengo "100" platos en total en el restaurante y en la pila hay 100 platos
                    limpios singifica que todos los platos estan limpios, no puedo seguir lavando
                    platos sucios porque no los tengo, estan todos limpios.
                    */
                    if (pilaDePlatos.tope < 99 && (pilaDePlatos.tope + 1) < cantidadTotalPlatos)
                    {

                        /*

                        Explicación de como funciona al dividir los números, usar los restos y
                        "desplazarlos" sumandoles "1".

                        15 / 3 = 5.0 => 0 + 1 = 1
                        16 / 3 = 5.1 => 1 + 1 = 2
                        17 / 3 = 5.2 => 2 + 1 = 3
                        18 / 3 = 6.0 => 0 + 1 = 1
                        19 / 3 = 6.1 => 1 + 1 = 2
                        20 / 3 = 6.2 => 2 + 1 = 3

                        */
                        colorPlatoLavado = 1 + rand() % 3;

                        // Utilizamos la función que hemos creado para actualizar "tope" y "elementos".
                        push(&pilaDePlatos, colorPlatoLavado);

                        // Si el color elegigo es "1" haz esto...
                        if (colorPlatoLavado == 1)
                        {
                            printf("Se acaba de lavar un plato ROJO. \n");
                        }
                        // Si no, si el color elegido es "2" haz esto...
                        else if (colorPlatoLavado == 2)
                        {
                            printf("Se acaba de lavar un plato AZUL. \n");
                        }
                        // Si no es ninguna de las cosas anteriores (es 3) haz esto...
                        else
                        {
                            printf("Se acaba de lavar un plato AMARILLO. \n");
                        }
                    }
                    else
                    {
                        printf("Todos los platos estan limpios, no se ha lavado ningún plato.\n");
                    }
                }
                // Sino, haz esto otro...
                else
                {

                    // Saca de la pila de platos el plato que este más arriba del todo y nos dice su color.
                    colorPlatoServido = pop(&pilaDePlatos);

                    if (colorPlatoServido == -1)
                    {
                        printf("La pila esta vacía, no se ha servido ningún plato.\n");
                    }
                    // Si el color elegigo es "1" haz esto...
                    else if (colorPlatoServido == 1)
                    {
                        printf("Se acaba de servir un plato ROJO. \n");
                    }
                    // Si no, si el color elegido es "2" haz esto...
                    else if (colorPlatoServido == 2)
                    {
                        printf("Se acaba de servir un plato AZUL. \n");
                    }
                    // Si no es ninguna de las cosas anteriores (es 3) haz esto...
                    else
                    {
                        printf("Se acaba de servir un plato AMARILLO. \n");
                    }
                }
            }
            printf("\nSimulacion completada. Vuelve al menu.\n");
        }

        // Si elige la opcion "3" se ejecuta este "else if".
        else if (opcionMenu == 3)
        {
            // Opción 3: Salir del programa
            printf("\nSaliendo del programa...\n");

            // Mostrar estado final
            platosRojos = 0;
            platosAzules = 0;
            platosAmarillos = 0;

            // Contar platos por color en la pila
            for (posicion = 0; posicion <= pilaDePlatos.tope; posicion++)
            {
                if (pilaDePlatos.elementos[posicion] == 1)
                {
                    platosRojos++;
                }
                else if (pilaDePlatos.elementos[posicion] == 2)
                {
                    platosAzules++;
                }
                else if (pilaDePlatos.elementos[posicion] == 3)
                {
                    platosAmarillos++;
                }
            }

            printf("\n Resumen final del programa \n");
            printf("Total de platos en la pila: %d\n", pilaDePlatos.tope + 1);
            printf("Platos rojos disponibles: %d\n", platosRojos);
            printf("Platos azules disponibles: %d\n", platosAzules);
            printf("Platos amarillos disponibles: %d\n", platosAmarillos);
        }
        else
        {
            // Opción inválida
            printf("Opcion no valida. Por favor elige 1, 2 o 3.\n");
        }
    }
    
    printf("Programa terminado. Gracias por usar la simulacion!\n");
    
    return 0;
}