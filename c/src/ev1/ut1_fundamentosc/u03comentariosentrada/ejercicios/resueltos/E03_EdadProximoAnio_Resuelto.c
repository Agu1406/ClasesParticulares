/*
E03 - Edad del proximo ano y ano de nacimiento (RESUELTO)

ENUNCIADO:
  Pide la edad y el ano actual. Muestra la edad que tendras el ano que viene y
  el ano en que naciste (aproximado: ano actual - edad).

EJEMPLO DE EJECUCION:
  Edad: 19
  Ano actual: 2026
  El ano que viene tendras 20 anos
  Naciste hacia 2007

PISTA:
  El ano de nacimiento aproximado es anio_actual - edad.

SOLUCION:
  Operaciones enteras sencillas con los datos leidos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int edad = 0, anio_actual = 0;
    printf("Edad: ");
    scanf("%d", &edad);
    printf("Ano actual: ");
    scanf("%d", &anio_actual);
    printf("El ano que viene tendras %d anos\n", edad + 1);
    printf("Naciste hacia %d\n", anio_actual - edad);
    return 0;
}
