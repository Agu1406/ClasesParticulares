/*
E17 - Cuadrado hueco (RESUELTO)

ENUNCIADO:
  Pide el lado (>= 2) y dibuja un cuadrado hueco: solo el borde con asteriscos.

EJEMPLO DE EJECUCION:
  Lado: 4
  ****
  *  *
  *  *
  ****

PISTA:
  Un asterisco va si es primera/ultima fila o primera/ultima columna.

SOLUCION:
  Una condicion dentro del doble bucle decide entre '*' y espacio.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int lado = 0;
    printf("Lado: ");
    scanf("%d", &lado);
    for (int f = 0; f < lado; f++) {
        for (int c = 0; c < lado; c++) {
            if (f == 0 || f == lado - 1 || c == 0 || c == lado - 1) {
                printf("*");
            } else {
                printf(" ");
            }
        }
        printf("\n");
    }
    return 0;
}
