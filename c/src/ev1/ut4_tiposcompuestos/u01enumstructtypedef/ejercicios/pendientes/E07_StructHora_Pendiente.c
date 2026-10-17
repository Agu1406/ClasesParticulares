/*
E07 - Horas, minutos y segundos (PENDIENTE)

ENUNCIADO:
  Con el struct Hora, implementa long a_segundos(Hora h) y Hora desde_segundos(long s) (s entre 0 y 86399).

PISTA:
  h * 3600 + m * 60 + s; la inversa con / y %

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
    int horas;
    int minutos;
    int segundos;
} Hora;

long a_segundos(Hora h) {
    // TODO: convierte la hora a segundos
    (void)h;
    return -1;
}

Hora desde_segundos(long s) {
    // TODO: convierte segundos a horas, minutos y segundos
    (void)s;
    Hora vacia = {0, 0, 0};
    return vacia;
}

int main(void) {
    Hora a = {1, 2, 3};
    PRUEBA(a_segundos(a) == 3723);
    Hora b = desde_segundos(3723);
    PRUEBA(b.horas == 1 && b.minutos == 2 && b.segundos == 3);
    Hora c = desde_segundos(0);
    PRUEBA(c.horas == 0 && c.minutos == 0 && c.segundos == 0);
    Hora d = desde_segundos(86399);
    PRUEBA(d.horas == 23 && d.minutos == 59 && d.segundos == 59);
    Hora x = {0, 59, 59};
    Hora y = desde_segundos(a_segundos(x) + 1);
    PRUEBA(y.horas == 1 && y.minutos == 0 && y.segundos == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
