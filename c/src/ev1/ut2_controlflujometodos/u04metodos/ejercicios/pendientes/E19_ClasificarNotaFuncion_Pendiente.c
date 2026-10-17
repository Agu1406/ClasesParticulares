/*
E19 - Clasificar una nota (PENDIENTE)

ENUNCIADO:
  Implementa const char *clasificar(double nota) que devuelva 'Sobresaliente' (>=9), 'Notable' (>=7), 'Aprobado' (>=5), 'Suspenso' o 'Nota no valida' (fuera de 0-10).

PISTA:
  Comparar cadenas con strcmp en las pruebas

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

static int pruebas = 0;
static int aciertos = 0;
#define PRUEBA(cond) do { pruebas++; if (cond) { aciertos++; printf("  [ OK  ] %s\n", #cond); } \
                          else { printf("  [FALLO] %s\n", #cond); } } while (0)


const char *clasificar(double nota) {
    // TODO: devuelve el texto segun la nota
    return "";
}

int main(void) {
    PRUEBA(strcmp(clasificar(9.5), "Sobresaliente") == 0);
    PRUEBA(strcmp(clasificar(7), "Notable") == 0);
    PRUEBA(strcmp(clasificar(5), "Aprobado") == 0);
    PRUEBA(strcmp(clasificar(4.99), "Suspenso") == 0);
    PRUEBA(strcmp(clasificar(11), "Nota no valida") == 0);
    PRUEBA(strcmp(clasificar(-1), "Nota no valida") == 0);

    printf("Resultado: %d/%d pruebas correctas\n", aciertos, pruebas);
    return aciertos == pruebas ? 0 : 1;
}
