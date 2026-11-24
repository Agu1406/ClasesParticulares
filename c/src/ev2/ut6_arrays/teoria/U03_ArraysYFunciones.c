/*
U03 — Arrays y funciones.

OBJETIVO:
  - Pasar un array a una funcion (se pasa la direccion; los cambios se ven fuera).
  - Pasar tambien el tamano (C no sabe la longitud sola).
  - Usar const int * cuando la funcion solo lee.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

static void mostrar(const int *a, int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");
}

static int suma(const int *a, int n) {
    int s = 0;
    for (int i = 0; i < n; i++) {
        s += a[i];
    }
    return s;
}

static void duplicar(int *a, int n) {
    for (int i = 0; i < n; i++) {
        a[i] *= 2;
    }
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    int datos[4] = {1, 2, 3, 4};
    printf("Original: ");
    mostrar(datos, 4);
    printf("Suma = %d\n", suma(datos, 4));

    duplicar(datos, 4);
    printf("Tras duplicar: ");
    mostrar(datos, 4);

    printf("\nEn C, datos y &datos[0] son la misma direccion al pasar a una funcion.\n");
    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
