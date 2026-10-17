/*
U02 - Repaso: for combinado con condicionales.

OBJETIVO:
  - Recorrer rangos y decidir en cada vuelta con if / else if / switch.
  - Contar y acumular solo los elementos que cumplen una condicion.
  - Reconocer los patrones FizzBuzz, filtrar multiplos y clasificar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

static bool es_primo(int n);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Filtrar dentro de un for.
      El for genera los candidatos y el if se queda con los que valen.
    */
    printf("--- PRIMERA PARTE: Filtrar multiplos ---\n\n");

    printf("Multiplos de 3 hasta 30: ");
    for (int i = 1; i <= 30; i++) {
        if (i % 3 == 0) {
            printf("%d ", i);
        }
    }
    printf("\n");

    /*
    SEGUNDA PARTE - Contar y acumular con condicion.
    */
    printf("\n--- SEGUNDA PARTE: Contar y acumular ---\n\n");

    int pares = 0;
    int suma_impares = 0;
    for (int i = 1; i <= 20; i++) {
        if (i % 2 == 0) {
            pares++;
        } else {
            suma_impares += i;
        }
    }
    printf("Pares entre 1 y 20       = %d\n", pares);
    printf("Suma de impares de 1..20 = %d\n", suma_impares);

    /*
    TERCERA PARTE - FizzBuzz.
      El orden de las condiciones importa: el caso mas especifico (15) va primero.
    */
    printf("\n--- TERCERA PARTE: FizzBuzz ---\n\n");

    for (int i = 1; i <= 15; i++) {
        if (i % 15 == 0) {
            printf("FizzBuzz ");
        } else if (i % 3 == 0) {
            printf("Fizz ");
        } else if (i % 5 == 0) {
            printf("Buzz ");
        } else {
            printf("%d ", i);
        }
    }
    printf("\n");

    /*
    CUARTA PARTE - Clasificar con varios contadores.
    */
    printf("\n--- CUARTA PARTE: Clasificar notas ---\n\n");

    int notas[] = {3, 8, 5, 10, 4, 7, 9, 2};
    int total = (int)(sizeof(notas) / sizeof(notas[0]));
    int suspensos = 0;
    int aprobados = 0;
    int sobresalientes = 0;
    for (int i = 0; i < total; i++) {
        if (notas[i] < 5) {
            suspensos++;
        } else if (notas[i] < 9) {
            aprobados++;
        } else {
            sobresalientes++;
        }
    }
    printf("Suspensos: %d | Aprobados: %d | Sobresalientes: %d\n", suspensos, aprobados, sobresalientes);

    /*
    QUINTA PARTE - Un for que usa una funcion booleana.
    */
    printf("\n--- QUINTA PARTE: Primos hasta 30 ---\n\n");

    for (int i = 1; i <= 30; i++) {
        if (es_primo(i)) {
            printf("%d ", i);
        }
    }
    printf("\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static bool es_primo(int n) {
    if (n < 2) {
        return false;
    }
    for (int d = 2; d * d <= n; d++) {
        if (n % d == 0) {
            return false;
        }
    }
    return true;
}
