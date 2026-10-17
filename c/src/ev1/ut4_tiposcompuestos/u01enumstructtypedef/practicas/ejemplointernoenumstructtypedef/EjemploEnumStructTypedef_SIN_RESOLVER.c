/*
Practica ejemplo (tipos compuestos): inventario de un producto (SIN RESOLVER)

ENUNCIADO:
  Modela un producto de tienda con struct, typedef y enum. Implementa las seis funciones;
  el main trae las pruebas y debe terminar con 'Resultado: 9/9 pruebas correctas'.

PISTA:
  Las funciones que modifican reciben Producto *; las que solo leen, const Producto *.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)

typedef enum { AGOTADO, BAJO, NORMAL } Estado;

typedef struct {
    char nombre[30];
    int stock;
    double precio;
} Producto;

Producto crear_producto(const char *nombre, int stock, double precio) {
    // TODO: crear_producto: rellena un Producto con nombre, stock y precio
    (void)nombre;
    (void)stock;
    (void)precio;
    Producto vacio = {"", 0, 0.0};
    return vacio;
}

Estado estado_stock(const Producto *p) {
    // TODO: estado_stock: AGOTADO si 0, BAJO si menos de 5, NORMAL en otro caso
    (void)p;
    return NORMAL;
}

bool vender(Producto *p, int unidades) {
    // TODO: vender: descuenta unidades; false (sin cambios) si no hay suficiente stock o unidades <= 0
    (void)p;
    (void)unidades;
    return false;
}

void reponer(Producto *p, int unidades) {
    // TODO: reponer: suma unidades al stock (ignora valores <= 0)
    (void)p;
    (void)unidades;
}

double valor_inventario(const Producto *p) {
    // TODO: valor_inventario: stock * precio
    (void)p;
    return -1;
}

void describir(const Producto *p, char *salida, size_t cap) {
    // TODO: describir: escribe 'nombre (stock) - texto' con texto AGOTADO, BAJO o NORMAL
    (void)p;
    (void)cap;
    salida[0] = '\0';
}

int main(void) {
    Producto lapiz = crear_producto("Lapiz", 10, 0.5);
    PRUEBA(strcmp(lapiz.nombre, "Lapiz") == 0 && lapiz.stock == 10 && lapiz.precio == 0.5);
    PRUEBA(estado_stock(&lapiz) == NORMAL);
    PRUEBA(vender(&lapiz, 7) && lapiz.stock == 3);
    PRUEBA(estado_stock(&lapiz) == BAJO);
    PRUEBA(!vender(&lapiz, 4) && lapiz.stock == 3);
    PRUEBA(!vender(&lapiz, 0) && !vender(&lapiz, -2) && lapiz.stock == 3);
    PRUEBA(vender(&lapiz, 3) && estado_stock(&lapiz) == AGOTADO);
    reponer(&lapiz, 20);
    reponer(&lapiz, -5);
    PRUEBA(lapiz.stock == 20 && valor_inventario(&lapiz) == 10.0);
    char texto[64];
    describir(&lapiz, texto, sizeof(texto));
    PRUEBA(strcmp(texto, "Lapiz (20) - NORMAL") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
