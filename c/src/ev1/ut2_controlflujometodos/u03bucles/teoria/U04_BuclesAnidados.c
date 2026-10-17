/*
U04 — Bucles anidados.

OBJETIVO:
  - Colocar un bucle dentro de otro y entender cuantas veces se ejecuta el interior.
  - Dibujar figuras con asteriscos (rectangulos, triangulos, piramides).
  - Generar tablas de multiplicar completas.
  - Buscar combinaciones (pares, ternas) con bucles anidados.
  - Estimar el coste: dos bucles de n vueltas = n x n ejecuciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Idea basica.
      Por cada vuelta del bucle EXTERIOR, el bucle INTERIOR se ejecuta COMPLETO.
      Si el exterior da 3 vueltas y el interior 4, el cuerpo interior se
      ejecuta 3 x 4 = 12 veces.
    */
    printf("--- PRIMERA PARTE: Ejecuciones ---\n\n");

    int ejecuciones = 0;
    for (int fila = 1; fila <= 3; fila++) {
        for (int col = 1; col <= 4; col++) {
            printf("(%d,%d) ", fila, col);
            ejecuciones++;
        }
        printf("\n");   // salto de linea al terminar cada fila
    }
    printf("El cuerpo interior se ejecuto %d veces\n", ejecuciones);

    /*
    SEGUNDA PARTE - Rectangulo de asteriscos.
      Exterior: filas. Interior: columnas de cada fila.
    */
    printf("\n--- SEGUNDA PARTE: Rectangulo 4x8 ---\n\n");

    for (int fila = 0; fila < 4; fila++) {
        for (int col = 0; col < 8; col++) {
            printf("*");
        }
        printf("\n");
    }

    /*
    TERCERA PARTE - Triangulo.
      El interior depende de la variable del exterior: fila 1 -> 1 estrella,
      fila 2 -> 2 estrellas...
    */
    printf("\n--- TERCERA PARTE: Triangulo ---\n\n");

    for (int fila = 1; fila <= 5; fila++) {
        for (int col = 1; col <= fila; col++) {
            printf("*");
        }
        printf("\n");
    }

    /*
    CUARTA PARTE - Piramide centrada.
      En cada fila: primero espacios (altura - fila) y luego 2*fila - 1 estrellas.
    */
    printf("\n--- CUARTA PARTE: Piramide ---\n\n");

    int altura = 5;
    for (int fila = 1; fila <= altura; fila++) {
        for (int e = 0; e < altura - fila; e++) {
            printf(" ");
        }
        for (int s = 0; s < 2 * fila - 1; s++) {
            printf("*");
        }
        printf("\n");
    }

    /*
    QUINTA PARTE - Tabla de multiplicar completa.
    */
    printf("\n--- QUINTA PARTE: Tabla 1..6 ---\n\n");

    for (int a = 1; a <= 6; a++) {
        for (int b = 1; b <= 6; b++) {
            printf("%4d", a * b);
        }
        printf("\n");
    }

    /*
    SEXTA PARTE - Buscar combinaciones: ternas pitagoricas hasta 20.
      a^2 + b^2 = c^2. Tres bucles anidados prueban todas las combinaciones.
    */
    printf("\n--- SEXTA PARTE: Ternas pitagoricas ---\n\n");

    for (int a = 1; a <= 20; a++) {
        for (int b = a; b <= 20; b++) {
            for (int c = b; c <= 20; c++) {
                if (a * a + b * b == c * c) {
                    printf("(%d, %d, %d)\n", a, b, c);
                }
            }
        }
    }

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
