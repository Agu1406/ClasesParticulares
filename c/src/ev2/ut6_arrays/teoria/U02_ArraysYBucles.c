/*
U02 — Arrays y bucles.

OBJETIVO:
  - Recorrer un array con for (llenar, sumar, buscar max/min).
  - Leer N datos con scanf en un array.
  - Contar cuantos cumplen una condicion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    const int N = 5;
    int v[5];
    int suma = 0;

    printf("--- PRIMERA PARTE: Llenar y mostrar ---\n\n");
    for (int i = 0; i < N; i++) {
        v[i] = (i + 1) * 3;
        printf("v[%d] = %d\n", i, v[i]);
        suma += v[i];
    }
    printf("Suma = %d, media = %.2f\n", suma, suma / (double)N);

    printf("\n--- SEGUNDA PARTE: Maximo y minimo ---\n\n");
    int max = v[0], min = v[0];
    for (int i = 1; i < N; i++) {
        if (v[i] > max)
            max = v[i];
        if (v[i] < min)
            min = v[i];
    }
    printf("max=%d min=%d\n", max, min);

    printf("\n--- TERCERA PARTE: Contar pares ---\n\n");
    int pares = 0;
    for (int i = 0; i < N; i++) {
        if (v[i] % 2 == 0)
            pares++;
    }
    printf("Pares: %d\n", pares);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
