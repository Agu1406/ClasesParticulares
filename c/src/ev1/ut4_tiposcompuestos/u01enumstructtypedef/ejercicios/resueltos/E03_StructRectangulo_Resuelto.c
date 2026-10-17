/*
E03 - Area y perimetro de un rectangulo (RESUELTO)

ENUNCIADO:
  Con el struct Rectangulo, implementa area, perimetro y bool es_cuadrado (usa const Rectangulo *).

PISTA:
  r->ancho * r->alto

SOLUCION:
  Todas las pruebas deben mostrar OK.

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


typedef struct {
    double ancho;
    double alto;
} Rectangulo;

double area(const Rectangulo *r) {
    return r->ancho * r->alto;
}

double perimetro(const Rectangulo *r) {
    return 2.0 * (r->ancho + r->alto);
}

bool es_cuadrado(const Rectangulo *r) {
    return r->ancho == r->alto;
}

int main(void) {
    Rectangulo a = {4.0, 2.5};
    Rectangulo b = {3.0, 3.0};
    PRUEBA(area(&a) == 10.0);
    PRUEBA(perimetro(&a) == 13.0);
    PRUEBA(!es_cuadrado(&a));
    PRUEBA(es_cuadrado(&b));
    PRUEBA(area(&b) == 9.0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
