/*
E16 - Conversion de temperaturas (PENDIENTE)

ENUNCIADO:
  Implementa double celsius_a_fahrenheit(double c) y double fahrenheit_a_celsius(double f).

PISTA:
  F = C * 9 / 5 + 32

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


double celsius_a_fahrenheit(double c) {
    // TODO: convierte de C a F
    (void)c;
    return 0;
}

double fahrenheit_a_celsius(double f) {
    // TODO: convierte de F a C
    (void)f;
    return 0;
}

int main(void) {
    PRUEBA(celsius_a_fahrenheit(0) == 32.0);
    PRUEBA(celsius_a_fahrenheit(100) == 212.0);
    PRUEBA(celsius_a_fahrenheit(-40) == -40.0);
    PRUEBA(fahrenheit_a_celsius(32) == 0.0);
    PRUEBA(fahrenheit_a_celsius(212) == 100.0);
    PRUEBA(fahrenheit_a_celsius(-40) == -40.0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
