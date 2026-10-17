/*
U03 - Repaso: while, acumuladores y centinelas.

OBJETIVO:
  - Usar while cuando no se sabe cuantas vueltas habra.
  - Acumular sumas, productos, maximos y minimos.
  - Calcular una media y detectar el caso "sin datos".
  - Aplicar el patron de bucle con centinela sobre datos de ejemplo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <limits.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - while dependiente de una condicion.
      Dividir entre 2 hasta llegar a 1: no sabemos de antemano cuantas veces.
    */
    printf("--- PRIMERA PARTE: while con condicion ---\n\n");

    int n = 100;
    int pasos = 0;
    while (n > 1) {
        n /= 2;
        pasos++;
    }
    printf("100 se reduce a 1 en %d divisiones\n", pasos);

    /*
    SEGUNDA PARTE - Acumuladores.
      Suma -> empieza en 0. Producto -> empieza en 1.
      Maximo -> empieza en INT_MIN. Minimo -> empieza en INT_MAX.
    */
    printf("\n--- SEGUNDA PARTE: Acumuladores ---\n\n");

    int datos[] = {12, -4, 30, 7, 0, 25};
    int cantidad = (int)(sizeof(datos) / sizeof(datos[0]));
    int suma = 0;
    int maximo = INT_MIN;
    int minimo = INT_MAX;
    int i = 0;
    while (i < cantidad) {
        suma += datos[i];
        if (datos[i] > maximo) {
            maximo = datos[i];
        }
        if (datos[i] < minimo) {
            minimo = datos[i];
        }
        i++;
    }
    printf("Suma = %d | Maximo = %d | Minimo = %d\n", suma, maximo, minimo);
    printf("Media = %.2f\n", (double)suma / cantidad);

    /*
    TERCERA PARTE - Centinela sobre una lista terminada en 0.
      El 0 marca el final de los datos y NO se cuenta.
    */
    printf("\n--- TERCERA PARTE: Centinela ---\n\n");

    int lista[] = {5, 9, 14, 0, 99, 99};
    int k = 0;
    int total = 0;
    int contados = 0;
    while (lista[k] != 0) {
        total += lista[k];
        contados++;
        k++;
    }
    printf("Leidos %d valores, suma %d\n", contados, total);

    /*
    CUARTA PARTE - Media segura: evitar dividir entre cero.
    */
    printf("\n--- CUARTA PARTE: Media sin datos ---\n\n");

    int vacios = 0;
    if (vacios == 0) {
        printf("No hay datos: no se puede calcular la media\n");
    } else {
        printf("Media = %.2f\n", (double)total / vacios);
    }

    /*
    QUINTA PARTE - Producto acumulado (factorial).
    */
    printf("\n--- QUINTA PARTE: Producto ---\n\n");

    long long factorial = 1;
    int j = 1;
    while (j <= 10) {
        factorial *= j;
        j++;
    }
    printf("10! = %lld\n", factorial);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
