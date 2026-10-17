/*
E04 - Media y aprobado de un alumno (PENDIENTE)

ENUNCIADO:
  Con el struct Alumno (tres notas), implementa double media(const Alumno *a) y bool aprobado(const Alumno *a) (media >= 5).

PISTA:
  Suma las tres notas y divide entre 3.0

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
    char nombre[30];
    double notas[3];
} Alumno;

double media(const Alumno *a) {
    // TODO: media de las tres notas
    (void)a;
    return -1;
}

bool aprobado(const Alumno *a) {
    // TODO: true si la media es >= 5
    (void)a;
    return false;
}

int main(void) {
    Alumno ana = {"Ana", {8, 6, 7}};
    Alumno luis = {"Luis", {3, 4, 5}};
    PRUEBA(media(&ana) == 7.0);
    PRUEBA(media(&luis) == 4.0);
    PRUEBA(aprobado(&ana));
    PRUEBA(!aprobado(&luis));

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
