/*
E06 - Persona con fecha de nacimiento (RESUELTO)

ENUNCIADO:
  Con los structs Fecha y Persona, implementa int edad(const Persona *p, Fecha hoy) y bool es_mayor_de_edad(const Persona *p, Fecha hoy).

PISTA:
  Resta los anios y descuenta 1 si aun no ha cumplido este ano

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
    int dia;
    int mes;
    int anio;
} Fecha;

typedef struct {
    char nombre[30];
    Fecha nacimiento;
} Persona;

int edad(const Persona *p, Fecha hoy) {
    int e = hoy.anio - p->nacimiento.anio;
    if (hoy.mes < p->nacimiento.mes ||
        (hoy.mes == p->nacimiento.mes && hoy.dia < p->nacimiento.dia)) {
        e--;
    }
    return e;
}

bool es_mayor_de_edad(const Persona *p, Fecha hoy) {
    return edad(p, hoy) >= 18;
}

int main(void) {
    Persona ana = {"Ana", {14, 3, 2008}};
    Fecha hoy = {13, 10, 2026};
    PRUEBA(edad(&ana, hoy) == 18);
    PRUEBA(es_mayor_de_edad(&ana, hoy));
    Fecha antes = {13, 3, 2026};
    PRUEBA(edad(&ana, antes) == 17);
    PRUEBA(!es_mayor_de_edad(&ana, antes));
    Fecha mismo_dia = {14, 3, 2026};
    PRUEBA(edad(&ana, mismo_dia) == 18);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
