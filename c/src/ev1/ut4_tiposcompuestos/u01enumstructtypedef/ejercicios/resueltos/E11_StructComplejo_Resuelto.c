/*
E11 - Numeros complejos (RESUELTO)

ENUNCIADO:
  Con el struct Complejo, implementa Complejo sumar(Complejo a, Complejo b), Complejo multiplicar(Complejo a, Complejo b) y double modulo(Complejo c).

PISTA:
  (a+bi)(c+di) = (ac - bd) + (ad + bc)i

SOLUCION:
  Todas las pruebas deben mostrar OK.

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
    double re;
    double im;
} Complejo;

Complejo sumar(Complejo a, Complejo b) {
    Complejo r = {a.re + b.re, a.im + b.im};
    return r;
}

Complejo multiplicar(Complejo a, Complejo b) {
    Complejo r = {a.re * b.re - a.im * b.im, a.re * b.im + a.im * b.re};
    return r;
}

double modulo(Complejo c) {
    return sqrt(c.re * c.re + c.im * c.im);
}

int main(void) {
    Complejo a = {1, 2};
    Complejo b = {3, -1};
    Complejo s = sumar(a, b);
    PRUEBA(s.re == 4.0 && s.im == 1.0);
    Complejo p = multiplicar(a, b);
    PRUEBA(p.re == 5.0 && p.im == 5.0);
    Complejo i = {0, 1};
    Complejo ii = multiplicar(i, i);
    PRUEBA(ii.re == -1.0 && ii.im == 0.0);
    PRUEBA(modulo((Complejo){3, 4}) == 5.0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
