/*
E05 - Modificar un struct por puntero (PENDIENTE)

ENUNCIADO:
  Implementa void mover(Punto *p, double dx, double dy) y void reflejar_x(Punto *p) (cambia el signo de y).

PISTA:
  p->x += dx;

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
    double x;
    double y;
} Punto;

void mover(Punto *p, double dx, double dy) {
    // TODO: suma dx y dy al punto
    (void)p;
    (void)dx;
    (void)dy;
}

void reflejar_x(Punto *p) {
    // TODO: cambia el signo de la coordenada y
    (void)p;
}

int main(void) {
    Punto p = {1, 2};
    mover(&p, 3, -5);
    PRUEBA(p.x == 4.0 && p.y == -3.0);
    reflejar_x(&p);
    PRUEBA(p.x == 4.0 && p.y == 3.0);
    mover(&p, 0, 0);
    PRUEBA(p.x == 4.0 && p.y == 3.0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
