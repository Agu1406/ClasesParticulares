/*
Practica ejemplo (repaso EV1): caja registradora con menu (SIN RESOLVER)

ENUNCIADO:
  Crea una caja registradora con un menu: anadir producto, ver total, aplicar descuento del 10 %,
  vaciar la caja y salir. Usa funciones y lee siempre con fgets + strtod.

PISTA:
  Usa variables static a nivel de fichero para el estado de la caja.

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
    // TODO: pide el precio, valida y actualiza total y articulos
    (void)precio;
}

static void ver_total(void) {
    printf("Articulos: %d\n", articulos);
    printf("Total: %.2f\n", total);
}

static void aplicar_descuento(void) {
    // TODO: reduce el total un 10 por ciento
}

static void vaciar_caja(void) {
    // TODO: pone total y articulos a cero
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
            // TODO: un case por cada opcion del menu
        }
    } while ((int)opcion != 0);
    return 0;
}
