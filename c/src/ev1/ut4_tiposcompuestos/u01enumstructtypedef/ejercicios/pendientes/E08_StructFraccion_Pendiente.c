/*
E08 - Suma y simplificacion de fracciones (PENDIENTE)

ENUNCIADO:
  Con el struct Fraccion, implementa Fraccion sumar(Fraccion a, Fraccion b) y Fraccion simplificar(Fraccion f) (con mcd). El denominador resultante es siempre positivo.

PISTA:
  a/b + c/d = (a*d + c*b) / (b*d)

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
    int num;
    int den;
} Fraccion;

static int mcd(int a, int b) {
    if (a < 0) {
        a = -a;
    }
    if (b < 0) {
        b = -b;
    }
    while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}

Fraccion simplificar(Fraccion f) {
    // TODO: divide numerador y denominador entre su mcd
    (void)f;
    Fraccion vacia = {0, 1};
    return vacia;
}

Fraccion sumar(Fraccion a, Fraccion b) {
    // TODO: suma y simplifica
    (void)a;
    (void)b;
    Fraccion vacia = {0, 1};
    return vacia;
}

int main(void) {
    Fraccion a = {1, 2};
    Fraccion b = {1, 3};
    Fraccion s = sumar(a, b);
    PRUEBA(s.num == 5 && s.den == 6);
    Fraccion c = simplificar((Fraccion){6, 8});
    PRUEBA(c.num == 3 && c.den == 4);
    Fraccion d = sumar((Fraccion){1, 4}, (Fraccion){1, 4});
    PRUEBA(d.num == 1 && d.den == 2);
    Fraccion e = simplificar((Fraccion){3, -6});
    PRUEBA(e.num == -1 && e.den == 2);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
