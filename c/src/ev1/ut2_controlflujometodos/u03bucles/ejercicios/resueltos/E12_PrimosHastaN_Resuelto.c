/*
E12 - Primos hasta N (RESUELTO)

ENUNCIADO:
  Pide N y muestra todos los primos entre 2 y N (en una linea) y cuantos hay.

EJEMPLO DE EJECUCION:
  N: 30
  2 3 5 7 11 13 17 19 23 29
  Total: 10

PISTA:
  Reutiliza el algoritmo de E11 dentro de un bucle exterior.

SOLUCION:
  Dos bucles anidados: el exterior recorre candidatos, el interior busca divisores.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("N: ");
    scanf("%d", &n);
    int total = 0;
    for (int c = 2; c <= n; c++) {
        int primo = 1;
        for (int d = 2; d * d <= c; d++) {
            if (c % d == 0) {
                primo = 0;
                break;
            }
        }
        if (primo) {
            printf("%d ", c);
            total++;
        }
    }
    printf("\n");
    printf("Total: %d\n", total);
    return 0;
}
