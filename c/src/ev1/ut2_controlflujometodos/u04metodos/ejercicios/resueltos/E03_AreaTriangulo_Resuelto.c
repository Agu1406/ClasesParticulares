/*
E03 - Area de un triangulo (RESUELTO)

ENUNCIADO:
  Implementa double area_triangulo(double base, double altura).

PISTA:
  area = base * altura / 2

SOLUCION:
  Todas las pruebas deben mostrar OK.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


double area_triangulo(double base, double altura) {
    return base * altura / 2;
}

int main(void) {
    PRUEBA(area_triangulo(10, 4) == 20.0);
    PRUEBA(area_triangulo(3, 3) == 4.5);
    PRUEBA(area_triangulo(0, 5) == 0.0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
