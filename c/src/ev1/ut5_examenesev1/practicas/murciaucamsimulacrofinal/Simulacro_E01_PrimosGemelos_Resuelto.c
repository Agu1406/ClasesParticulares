/*
Simulacro E01 - Primos gemelos (RESUELTO)
UCAM. PDF: SimulacroFinal_Soluciones.pdf (pregunta 1)

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n, k, d;
    int esPrimo;
    int anterior = 0;
    int parejas = 0;
    int salto;
    int mayorSalto = 0;
    int desde = 0, hasta = 0;

    printf("Introduce N (de 3 a 10000): ");
    scanf("%d", &n);
    while (n < 3 || n > 10000) {
        printf("N tiene que estar entre 3 y 10000\n");
        printf("Introduce N (de 3 a 10000): ");
        scanf("%d", &n);
    }

    printf("Parejas de primos gemelos:");
    for (k = 2; k <= n; k++) {
        esPrimo = 1;
        for (d = 2; d < k; d++) {
            if (k % d == 0) {
                esPrimo = 0;
                break;
            }
        }
        if (esPrimo == 1) {
            if (anterior > 0) {
                salto = k - anterior;
                if (salto == 2) {
                    printf(" (%d,%d)", anterior, k);
                    parejas++;
                }
                if (salto > mayorSalto) {
                    mayorSalto = salto;
                    desde = anterior;
                    hasta = k;
                }
            }
            anterior = k;
        }
    }

    if (parejas == 0)
        printf(" ninguna");
    printf("\n");
    printf("Total de parejas: %d\n", parejas);
    printf("Mayor salto entre primos seguidos: %d (de %d a %d)\n",
           mayorSalto, desde, hasta);
    return 0;
}
