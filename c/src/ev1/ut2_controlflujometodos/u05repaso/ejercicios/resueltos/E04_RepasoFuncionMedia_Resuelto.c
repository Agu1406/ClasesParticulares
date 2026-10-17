/*
E04 - Funcion media (RESUELTO)

ENUNCIADO:
  Implementa double media3(double a, double b, double c) y double media_ponderada(double nota1, double nota2) con pesos 40% y 60%.

PISTA:
  Cuidado al dividir: usa 3.0

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


double media3(double a, double b, double c) {
    return (a + b + c) / 3.0;
}

double media_ponderada(double nota1, double nota2) {
    return nota1 * 0.4 + nota2 * 0.6;
}

int main(void) {
    PRUEBA(media3(3, 6, 9) == 6.0);
    PRUEBA(media3(0, 0, 0) == 0.0);
    PRUEBA(media3(10, 10, 7) > 8.99 && media3(10, 10, 7) < 9.01);
    PRUEBA(media_ponderada(5, 10) > 7.99 && media_ponderada(5, 10) < 8.01);
    PRUEBA(media_ponderada(10, 0) > 3.99 && media_ponderada(10, 0) < 4.01);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
