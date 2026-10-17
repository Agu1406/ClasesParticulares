/*
E02 - Distancia entre dos puntos (PENDIENTE)

ENUNCIADO:
  Dado el struct Punto, implementa double distancia(Punto a, Punto b) y Punto punto_medio(Punto a, Punto b).

PISTA:
  distancia = sqrt(dx*dx + dy*dy)

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <math.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


typedef struct {
    double x;
    double y;
} Punto;

double distancia(Punto a, Punto b) {
    // TODO: distancia euclidea
    (void)a;
    (void)b;
    return -1;
}

Punto punto_medio(Punto a, Punto b) {
    // TODO: punto medio
    (void)a;
    (void)b;
    Punto vacio = {0, 0};
    return vacio;
}

int main(void) {
    Punto o = {0, 0};
    Punto p = {3, 4};
    PRUEBA(distancia(o, p) == 5.0);
    PRUEBA(distancia(p, p) == 0.0);
    Punto m = punto_medio(o, p);
    PRUEBA(m.x == 1.5 && m.y == 2.0);
    Punto n = punto_medio((Punto){-2, 2}, (Punto){2, -2});
    PRUEBA(n.x == 0.0 && n.y == 0.0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
