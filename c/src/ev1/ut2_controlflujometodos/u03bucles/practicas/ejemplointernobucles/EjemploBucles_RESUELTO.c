/*
Practica ejemplo (bucles): estadisticas de temperaturas (RESUELTO)

ENUNCIADO:
  Lee temperaturas diarias hasta que se introduzca -999 (centinela) y muestra estadisticas.

PISTA:
  Lectura anticipada: lee antes del while y otra vez al final del cuerpo.

SOLUCION:
  El maximo empieza en INT_MIN y el minimo en INT_MAX.

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
    printf("Temperatura (-999 para terminar): ");
    scanf("%d", &t);
    while (t != -999) {
        dias++;
        suma += t;
        if (t > maxima) {
            maxima = t;
        }
        if (t < minima) {
            minima = t;
        }
        if (t < 0) {
            heladas++;
        }
        printf("Temperatura (-999 para terminar): ");
        scanf("%d", &t);
    }
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
