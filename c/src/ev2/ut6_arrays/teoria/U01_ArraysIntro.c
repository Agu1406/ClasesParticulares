/*
U01 — Introduccion a arrays.

OBJETIVO:
  - Declarar un array de tamano fijo: int nums[5].
  - Indices desde 0. Inicializar con = { } o lista.
  - Asignar y leer por indice. Ver basura si no inicializas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    printf("--- PRIMERA PARTE: Declaracion ---\n\n");
    int nums[5] = {0};
    printf("nums[0]=%d nums[4]=%d (inicializado a 0)\n", nums[0], nums[4]);

    printf("\n--- SEGUNDA PARTE: Asignacion ---\n\n");
    nums[0] = 10;
    nums[1] = 20;
    nums[2] = 30;
    nums[3] = 40;
    nums[4] = 50;
    printf("nums[0]=%d nums[2]=%d nums[4]=%d\n", nums[0], nums[2], nums[4]);

    printf("\n--- TERCERA PARTE: Lista de inicializacion ---\n\n");
    int notas[] = {7, 5, 9, 6};
    int n = (int)(sizeof(notas) / sizeof(notas[0]));
    printf("notas tiene %d elementos; el ultimo es %d\n", n, notas[n - 1]);

    printf("\n--- CUARTA PARTE: Trampa ---\n\n");
    printf("Acceder a nums[5] es fuera de rango (comportamiento indefinido).\n");
    printf("C no comprueba limites en tiempo de ejecucion.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
