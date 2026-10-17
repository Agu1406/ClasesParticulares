/*
E10 - Notas de varios alumnos (PENDIENTE)

ENUNCIADO:
  Pide cuantos alumnos hay y despues la nota de cada uno (double).
  Muestra la media, la nota maxima y cuantos han aprobado (>= 5).
  Si el numero de alumnos no es positivo, muestra 'Sin alumnos'.

EJEMPLO DE EJECUCION:
  Alumnos: 4
  Nota 1: 8
  Nota 2: 3
  Nota 3: 6
  Nota 4: 10
  Media: 6.75
  Maxima: 10.00
  Aprobados: 3

PISTA:
  Declara maximo fuera del bucle (empieza en la primera nota o en 0).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int alumnos = 0;
    printf("Alumnos: ");
    scanf("%d", &alumnos);
    if (alumnos <= 0) {
        printf("Sin alumnos\n");
        return 0;
    }
    double suma = 0.0;
    double maxima = 0.0;
    int aprobados = 0;
    // TODO: lee las notas y acumula suma, maxima y aprobados
    printf("Media: %.2f\n", suma / alumnos);
    printf("Maxima: %.2f\n", maxima);
    printf("Aprobados: %d\n", aprobados);
    return 0;
}
