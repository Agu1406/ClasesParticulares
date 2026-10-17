/*
Practica ejemplo (bucles): estadisticas de temperaturas (SIN RESOLVER)

ENUNCIADO:
  Lee temperaturas diarias hasta que se introduzca -999 (centinela) y muestra estadisticas.

PISTA:
  Lectura anticipada: lee antes del while y otra vez al final del cuerpo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <limits.h>

int main(void) {
    int dias = 0;
    int suma = 0;
    int maxima = INT_MIN;
    int minima = INT_MAX;
    int heladas = 0;
    int t = 0;
    // TODO: lee temperaturas hasta -999 y acumula estadisticas
    if (dias == 0) {
        printf("Sin datos\n");
        return 0;
    }
    printf("Dias: %d\n", dias);
    printf("Media: %.2f\n", (double)suma / dias);
    printf("Maxima: %d\n", maxima);
    printf("Minima: %d\n", minima);
    printf("Dias de helada: %d\n", heladas);
    return 0;
}
