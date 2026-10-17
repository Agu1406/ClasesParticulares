/*
E07 - Encuentra el error: switch sin break (RESUELTO)

ENUNCIADO:
  Con dia = 2 el programa debe mostrar solo 'Martes'. Ahora muestra mas lineas.
  Corrigelo.

EJEMPLO DE EJECUCION:
  Martes

PISTA:
  Cada case debe terminar con break.

SOLUCION:
  Sin break el programa 'cae' en el siguiente case.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int dia = 2;
    switch (dia) {
        case 1:
            printf("Lunes\n");
            break;
        case 2:
            printf("Martes\n");
            break;
        case 3:
            printf("Miercoles\n");
            break;
        default:
            printf("Otro dia\n");
            break;
    }
    return 0;
}
