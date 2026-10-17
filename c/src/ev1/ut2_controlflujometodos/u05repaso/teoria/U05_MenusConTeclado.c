/*
U05 - Repaso: menus por teclado robustos.

OBJETIVO:
  - Construir un menu con do-while y switch.
  - Leer opciones con fgets + strtol para no quedar atascado con scanf.
  - Validar rangos y repetir mientras la entrada sea invalida.
  - Estructurar el menu con funciones pequenas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

static bool leer_entero(const char *mensaje, long *valor);
static void mostrar_menu(void);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Esquema del menu.
      do { mostrar menu; leer opcion; switch(opcion) } while (opcion != 0);
      Cada case llama a una funcion o hace una accion corta.
    */
    printf("--- PRIMERA PARTE: Menu de contador ---\n\n");

    long opcion = -1;
    long contador = 0;
    do {
        mostrar_menu();
        if (!leer_entero("Opcion: ", &opcion)) {
            printf("Entrada no valida (se esperaba un numero)\n\n");
            opcion = -1;
            continue;
        }
        switch (opcion) {
            case 1:
                contador++;
                printf("Contador = %ld\n", contador);
                break;
            case 2:
                contador--;
                printf("Contador = %ld\n", contador);
                break;
            case 3:
                contador = 0;
                printf("Contador reiniciado\n");
                break;
            case 0:
                printf("Hasta luego.\n");
                break;
            default:
                printf("Opcion no valida: %ld\n", opcion);
                break;
        }
        printf("\n");
    } while (opcion != 0);

    /*
    SEGUNDA PARTE - Resumen de buenas practicas.
      - Lee SIEMPRE con fgets y convierte con strtol: no se rompe con letras.
      - Usa default en el switch para opciones inesperadas.
      - Cada opcion en una funcion si hace mas de 3-4 lineas.
      - Un solo punto de salida (opcion 0).
      - 'continue' dentro de do-while salta a evaluar la condicion.
    */
    printf("--- SEGUNDA PARTE: Buenas practicas ---\n\n");
    printf("Valor final del contador: %ld\n", contador);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static void mostrar_menu(void) {
    printf("=== MENU ===\n");
    printf("1. Sumar 1\n");
    printf("2. Restar 1\n");
    printf("3. Reiniciar\n");
    printf("0. Salir\n");
}

static bool leer_entero(const char *mensaje, long *valor) {
    char linea[64];
    printf("%s", mensaje);
    if (fgets(linea, sizeof(linea), stdin) == NULL) {
        return false;
    }
    char *fin = NULL;
    long v = strtol(linea, &fin, 10);
    if (fin == linea) {
        return false;                 // no se leyo ningun digito
    }
    *valor = v;
    return true;
}
