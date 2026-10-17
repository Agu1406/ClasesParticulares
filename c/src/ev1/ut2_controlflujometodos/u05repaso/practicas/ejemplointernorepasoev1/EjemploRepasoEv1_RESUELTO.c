/*
Practica ejemplo (repaso EV1): caja registradora con menu (RESUELTO)

ENUNCIADO:
  Crea una caja registradora con un menu: anadir producto, ver total, aplicar descuento del 10 %,
  vaciar la caja y salir. Usa funciones y lee siempre con fgets + strtod.

PISTA:
  Usa variables static a nivel de fichero para el estado de la caja.

SOLUCION:
  El switch delega en una funcion por opcion; los datos viven en variables de fichero.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

static double total = 0.0;
static int articulos = 0;

static bool leer_numero(const char *mensaje, double *valor) {
    char linea[64];
    printf("%s", mensaje);
    if (fgets(linea, sizeof(linea), stdin) == NULL) {
        return false;
    }
    char *fin = NULL;
    double v = strtod(linea, &fin);
    if (fin == linea) {
        return false;
    }
    *valor = v;
    return true;
}

static void mostrar_menu(void) {
    printf("\n1. Anadir producto\n2. Ver total\n3. Aplicar descuento del 10%%\n4. Vaciar caja\n0. Salir\n");
}

static void anadir_producto(void) {
    double precio = 0.0;
    if (!leer_numero("Precio: ", &precio) || precio <= 0.0) {
        printf("Precio no valido\n");
        return;
    }
    total += precio;
    articulos++;
}

static void ver_total(void) {
    printf("Articulos: %d\n", articulos);
    printf("Total: %.2f\n", total);
}

static void aplicar_descuento(void) {
    total *= 0.9;
    printf("Descuento aplicado\n");
}

static void vaciar_caja(void) {
    total = 0.0;
    articulos = 0;
    printf("Caja vaciada\n");
}

int main(void) {
    double opcion = -1;
    do {
        mostrar_menu();
        if (!leer_numero("Opcion: ", &opcion)) {
            printf("Opcion no valida\n");
            opcion = -1;
            continue;
        }
        switch ((int)opcion) {
            case 1: anadir_producto(); break;
            case 2: ver_total(); break;
            case 3: aplicar_descuento(); break;
            case 4: vaciar_caja(); break;
            case 0: printf("Hasta luego.\n"); break;
            default: printf("Opcion no valida\n"); break;
        }
    } while ((int)opcion != 0);
    return 0;
}
