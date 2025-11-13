// Gracías a estás funciones podemos hacer print y scanf.
#include <stdio.h>
// Permite manejar memoria, números aleatorios (como rand en este ejercicio).
#include <stdlib.h>
// Permite manipular tiempo, usado en las funciones por ejemplo de dormir.
#include <time.h>
// Incluye funciones nativas de C como "Sleep" o "GetStdHandle" usadas en este ejercicio.
#include <windows.h>
// Libreria que permite "leer" teclas del teclado sin detener/bloquear programa.
#include <conio.h>

/*
Definimos los colores que vamos a utilizar, una breve explicación de donde
viene los colores la podemos encontrar por ejemplo en el siguiente enlace:
https://www.ionos.es/digitalguide/servidores/configuracion/linux-echo
 */
#define colorAzul "\033[34m"
#define colorRojo "\033[31m"
#define colorAmarillo "\033[33m"
#define colorReset "\033[0m"

/*
Creamos nuestra propia estructura para la pila, con un elemento "int" llamado
"tope" que sirve como indice de posiciones del array de números enteros de
elementos cuyo espacio maximo definido es, en mi caso, de 100 "platos".
*/
typedef struct
{
    int elementos[100];
    int tope;
} Pila;

/*
Función "push" que permite "empujar" (meter) platos recien lavados dentro
de la pila siempre y cuando verifique primer oque aún hay espacio para
meter los platos.
 */
void push(Pila *platos, int color)
{
    // Si "tope" es menor a "99" significa que aún quedan algunas de las 99 cajas vacías.
    if (platos->tope < 99)
    {
        // Anoto en mi papelito "tope" cuantos platos hay dentro del mueble actualmente.
        platos->tope++;

        /*
        Luego de anotarme en un papelito (tope) cuantos platos hay en el mueble,
        guardo el plato recien lavado.
        */
        platos->elementos[platos->tope] = color;
    }
}

/*
Función "pop" que "lee" el color del ultimo plato de la pila, disminuye el tope de platos
dentro de la pila y me dice el color del plato que acaba de sacar.
*/
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

/*
Si realmente queremos que el proggrama sea automatico tenemos que crear una función
que sea capaz de "dormirlo" (detenerlo) por "X" cantidad de tiempo para poder
apreciar mejor en la consola el flujo del programa y la información.
*/
void DormirPrograma(int cantidadTiempo)
{
    /*
    Duerme (sleep) la cantidad de tiempo en milisegundos que se indique como argumento.
    */
    Sleep(cantidadTiempo);
}

/*
La consola por defecto no es capaz de procesar colores, por eso, para usar los colores
ANSI no es suficiente solo con declararlos si no que tenemos que activar el modo
especial de la consola que permite entender e imprimir colores ANSI.
*/
void EncenderColores()
{
    // Creamos un "manejador" (HANDLER) para la impresión de la consola.
    HANDLE consola = GetStdHandle(STD_OUTPUT_HANDLE);
    // Guardamos el modo actual de la consola (0 por defecto).
    DWORD modoConsola = 0;
    /*
    Si "GetConsoleMode" funciona bien devuelve algo diferente a 0 (true).
    Necesitamos pasar &modoConsola (dirección de memoria) para que la función pueda modificar su valor.
    */
    if (GetConsoleMode(consola, &modoConsola))
    {
        /*
        Entonces significa que si podemos activar el procesamiento virtual.
        */
        modoConsola |= ENABLE_VIRTUAL_TERMINAL_PROCESSING;
        /*
        Y modificar el modo de la consola para ello.
        */
        SetConsoleMode(consola, modoConsola);
    }
}

/*
Esta función permite al programa detectar/leer si presionamos una tecla sin
detener/pausar el programa pero permitiendo actuar dependiendo de la tecla
presionada, es decir, "sin bloqueo".
*/
int DetectarBotonPresionado()
{
    /*
    Guardamos un "0" si se esta presionando una tecla, "1" si no.
    _kbhit() necesita los paréntesis para ser una llamada a función.
    */
    int deteccion = _kbhit();

    // Devolvemos "0" o "1" dependiendo de la detección anterior.s
    return deteccion;
}

/*
En paralelo a la función anterior necesitamos ser capaces de leer un
carácter que haya sido presionado/escrito, si no se ha presionado
ninguna tecla devuelve "0" pero si se presiona alguna tecla está
se extrae y se utiliza posteriormente.
 */
char LeerBoton()
{
    // Si se presiona activamente una tecla se ejecuta el if.
    if (_kbhit())
    {
        // Obtenemos y guardamos en una variable la tecla presionada.
        char teclaPresionada = _getch();
        // La función de vuelve esta tecla.
        return teclaPresionada;
    }

    // Por defecto devuelve "0" (false) o lo mismo que "no hay teclas escritas".
    return 0;
}

int main()
{
    // Habilitamos los colores para permitir su uso en la consola/programa.
    EncenderColores();

    // Utilizando la estructura de arriba creo una pila de platos.
    Pila pilaDePlatos;

    // Variable para controlar la "N" cantidad de platos.
    int cantidadTotalPlatos;
    // Variable que dice que cantidad de platos rojos hay.
    int cantidadPlatosRojos;
    // Variable que dice que cantidad de platos azules hay.
    int cantidadPlatosAzules;
    // Variable que dice que cantidad de platos amarillos hay.
    int cantidadPlatosAmarillos;
    // Variable que usaremo par los bucles.
    int posicion;
    // Variable que indica si el progama esta pausado ("1") o en marcha ("0").
    int estadoPrograma = 0;
    // Inicializamos la pila de platos vacia.
    pilaDePlatos.tope = -1;
    // Variable que guarda las letras que se presionen en el programa.
    char letraPresionada = 0;

    // Cantida de platos "limpios" (que se pueden servir) que tenemos.
    int platosRojos;
    int platosAzules;
    int platosAmarillos;

    // Declaramos las variables y funciones utilizadas para que el programa elija aleatoriamente.
    int accion;
    srand(time(NULL));
    int colorPlatoLavado;
    int colorPlatoServido;

    // Mensaje de bienvenida al programa
    printf("Bienvenido a la simulacion de lavado y servido de platos. \n");

    // Pedimos por pantalla y por teclado la cantidad de platos totales.
    printf("Dime que cantidad de platos rojos hay en total: ");
    scanf("%d", &cantidadPlatosRojos);

    printf("Dime que cantidad de platos azules hay en total: ");
    scanf("%d", &cantidadPlatosAzules);

    printf("Dime que cantidad de platos amarillos hay en total: ");
    scanf("%d", &cantidadPlatosAmarillos);

    // Sumamos todos los platos para saber cuantos platos hay en total en el restaurante.
    cantidadTotalPlatos = cantidadPlatosRojos + cantidadPlatosAzules + cantidadPlatosAmarillos;

    // Mensaje que muestra cuantos platos tenemos y como funciona la simulación y sus opciones.
    printf("El total de platos en el restaurante es: %d \n", cantidadTotalPlatos);
    printf("En este programa los platos se lavan y se sirven al mismo tiempo. \n");
    printf("El programa es completamente automatico, su comportamiento solo cambia\n");
    printf("con las siguientes opciones:\n");
    printf("A) Presiona la tecla 'P' (mayúscula) para pausar el programa y ver información.\n");
    printf("B) Presiona la tecla 'R' (mayúscula) para reanudar el programa otra vez.\n");
    printf("C) Presiona la tecla 'Q' (mayúscula) para que el programa termine.\n");

    // Bucle infinito que se ejecuta mientras el programa esté corriendo.
    while (1)
    {
        // Verificamos si hay una tecla presionada sin bloquear el programa.
        if (DetectarBotonPresionado())
        {
            // Leemos la tecla presionada.
            letraPresionada = LeerBoton();
        }

        /*
        Si elige la opcion "P" se ejecuta este "if".
        Nota: comparamos con 'P' (comilla simple) porque letraPresionada es un char, no un string.
        */
        if (letraPresionada == 'P' || letraPresionada == 'p')
        {
            // Cambio el valor de "estadoPrograma" a "1" (significa que lo pare).
            estadoPrograma = 1;

            // Opción 1: Pausar y mostrar el estado de la pila

            printf("\n Programa pausado, mostrando estado actual del programa y la pila \n");

            // Inicializar contadores
            platosRojos = 0;
            platosAzules = 0;
            platosAmarillos = 0;

            /*
             * Contar platos por color en la pila
             * Recorremos desde la base (0) hasta el tope de la pila
             */
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

            // Luego de escribir la "P" y ejecutar la pausa, borramos la "P" de la variable.
            letraPresionada = 0;
        }

        // Si elige la opcion "R" se ejecuta este "else if".
        else if (letraPresionada == 'R' || letraPresionada == 'r')
        {
            // Verifico que el programa realmente este en pausa, si no, no hago nada.
            if (estadoPrograma)
            {
                // Cambio el estado del programa de pausado a en marcha.
                estadoPrograma = 0;
            }

            // Luego de escribir la letra y ejecutar la pausa, borramos la "P" de la variable.
            letraPresionada = 0;
        }

        // Si elige la opcion "Q" se ejecuta este "else if".
        else if (letraPresionada == 'Q' || letraPresionada == 'q')
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


            // Luego de escribir la letra y ejecutar el final, borramos la "P" de la variable.
            letraPresionada = 0;

            // Salimos del bucle infinito y terminamos el programa.
            break;
        }

        /*
        Verifica si el programa NO está pausado
        El operador ! significa "no", así que !estadoPrograma es verdadero cuando estadoPrograma es 0
        Si no está pausado, ejecutar acciones automáticas
        */
        if (!estadoPrograma)
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
            accion = 1 + rand() % 2;

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

                /*
                Verifica dos condiciones usando el operador && (AND)
                Primera condición: tope < 99 significa que hay espacio en la pila
                Segunda condición: (tope + 1) < cantidadTotalPlatos significa que aún hay platos sucios
                Ambas condiciones deben ser verdaderas para poder lavar
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

                    /*
                    Genera un número aleatorio entre 1 y 3 para el color del plato
                    rand() % 3 genera un número entre 0 y 2 (resto de dividir entre 3)
                    Sumar 1 hace que el resultado sea entre 1 y 3
                    1 = rojo, 2 = azul, 3 = amarillo
                    */
                    colorPlatoLavado = 1 + rand() % 3;

                    /*
                    Llama a la función push para agregar el plato a la pila
                    &pilaDePlatos pasa la dirección de memoria de la pila (un puntero)
                    colorPlatoLavado es el color del plato que se va a agregar
                    Utilizamos la función que hemos creado para actualizar "tope" y "elementos"
                    */
                    push(&pilaDePlatos, colorPlatoLavado);

                    /*
                    Verifica el color del plato lavado y muestra un mensaje con el color correspondiente
                    Si el color elegigo es "1" haz esto...
                    */
                    if (colorPlatoLavado == 1)
                    {
                        // Muestra un mensaje en color rojo indicando que se lavó un plato rojo
                        printf(colorRojo "Se acaba de lavar un plato ROJO.\n" colorReset);
                    }
                    /*
                    Si no es rojo, verifica si es azul (valor 2)
                    Si no, si el color elegido es "2" haz esto...
                    */
                    else if (colorPlatoLavado == 2)
                    {
                        // Muestra un mensaje en color azul indicando que se lavó un plato azul
                        printf(colorAzul "Se acaba de lavar un plato AZUL.\n" colorReset);
                    }
                    /*
                    Si no es rojo ni azul, debe ser amarillo (valor 3)
                    Si no es ninguna de las cosas anteriores (es 3) haz esto...
                    */
                    else
                    {
                        // Muestra un mensaje en color amarillo indicando que se lavó un plato amarillo
                        printf(colorAmarillo "Se acaba de lavar un plato AMARILLO.\n" colorReset);
                    }
                }
                // Si no se cumplen las condiciones (pila llena o todos los platos ya lavados)
                else
                {
                    // Muestra un mensaje indicando que no se puede lavar más platos
                    printf("Todos los platos estan limpios, no se ha lavado ningún plato.\n");
                }
            }
            /*
            Si la acción no es 1, entonces es 2 (servir un plato)
            Sino, haz esto otro...
             */
            else
            {
                /*
                Llama a la función pop para sacar el plato del tope de la pila
                &pilaDePlatos pasa la dirección de memoria de la pila (un puntero)
                pop() devuelve el color del plato sacado, o -1 si la pila está vacía
                Saca de la pila de platos el plato que este más arriba del todo y nos dice su color
                */
                colorPlatoServido = pop(&pilaDePlatos);

                // Verifica si la pila estaba vacía (pop devolvió -1)
                if (colorPlatoServido == -1)
                {
                    // Muestra un mensaje indicando que no se pudo servir porque la pila está vacía
                    printf("La pila esta vacía, no se ha servido ningún plato.\n");
                }
                /*
                Si no está vacía, verifica el color del plato servido
                Si el color elegigo es "1" haz esto...
                */
                else if (colorPlatoServido == 1)
                {
                    // Muestra un mensaje en color rojo indicando que se sirvió un plato rojo
                    printf(colorRojo "Se acaba de servir un plato ROJO.\n" colorReset);
                }
                /*
                Si no es rojo, verifica si es azul (valor 2)
                Si no, si el color elegido es "2" haz esto...
                */
                else if (colorPlatoServido == 2)
                {
                    // Muestra un mensaje en color azul indicando que se sirvió un plato azul
                    printf(colorAzul "Se acaba de servir un plato AZUL.\n" colorReset);
                }
                /*
                Si no es rojo ni azul, debe ser amarillo (valor 3)
                Si no es ninguna de las cosas anteriores (es 3) haz esto...
                */
                else
                {
                    // Muestra un mensaje en color amarillo indicando que se sirvió un plato amarillo
                    printf(colorAmarillo "Se acaba de servir un plato AMARILLO.\n" colorReset);
                }
            }

            /*
            Espera 500 milisegundos (medio segundo) antes de la siguiente acción
            Esto hace que los mensajes sean visibles y el programa no vaya demasiado rápido
            Pequeña pausa para que sea visible
            */
            DormirPrograma(500);
        }
        // Si el programa está pausado (estadoPrograma == 1)
        else
        {
            /*
            Espera solo 100 milisegundos para no consumir demasiados recursos
            Esto permite verificar las teclas frecuentemente sin bloquear
            Si está pausado, esperar un poco antes de verificar teclas de nuevo
            */
            DormirPrograma(100);
        }
    }

    printf("Programa terminado. Gracias por usar la simulacion!\n");

    return 0;
}
