/*
E20 - Menu con do-while (RESUELTO)

ENUNCIADO:
  Muestra un menu (1 sumar, 2 restar, 3 multiplicar, 0 salir). Mientras la opcion no sea 0:
  pide dos numeros enteros y muestra el resultado. Opcion invalida: avisa y repite.

EJEMPLO DE EJECUCION:
  1. Sumar ... 0. Salir
  Opcion: 1
  Numeros: 6 4
  Resultado: 10

PISTA:
  do { ... } while (opcion != 0);

SOLUCION:
  El do-while garantiza que el menu se muestra al menos una vez.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int opcion = 0;
    do {
        printf("\n1. Sumar\n2. Restar\n3. Multiplicar\n0. Salir\nOpcion: ");
        if (scanf("%d", &opcion) != 1) {
            break;
        }
        if (opcion >= 1 && opcion <= 3) {
            int a = 0, b = 0;
            printf("Numeros: ");
            scanf("%d %d", &a, &b);
            int r = opcion == 1 ? a + b : (opcion == 2 ? a - b : a * b);
            printf("Resultado: %d\n", r);
        } else if (opcion != 0) {
            printf("Opcion no valida\n");
        }
    } while (opcion != 0);
    printf("Adios\n");
    return 0;
}
