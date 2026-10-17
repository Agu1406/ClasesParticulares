/*
E26 - Media con centinela (RESUELTO)

ENUNCIADO:
  Lee numeros reales hasta que se escriba -1 (el centinela no cuenta). Muestra cuantos
  se han leido, la suma y la media. Si no se leyo ninguno muestra 'Sin datos'.

EJEMPLO DE EJECUCION:
  Numero: 4
  Numero: 7
  Numero: -1
  Cantidad: 2
  Suma: 11.00
  Media: 5.50

PISTA:
  Esquema: leer; while (dato != -1) { procesar; leer; }

SOLUCION:
  La lectura anticipada evita procesar el centinela.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    double dato = 0, suma = 0;
    int cantidad = 0;
    printf("Numero: ");
    if (scanf("%lf", &dato) != 1) {
        dato = -1;
    }
    while (dato != -1) {
        suma += dato;
        cantidad++;
        printf("Numero: ");
        if (scanf("%lf", &dato) != 1) {
            dato = -1;
        }
    }
    if (cantidad == 0) {
        printf("Sin datos\n");
    } else {
        printf("Cantidad: %d\n", cantidad);
        printf("Suma: %.2f\n", suma);
        printf("Media: %.2f\n", suma / cantidad);
    }
    return 0;
}
