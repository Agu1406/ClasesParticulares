/*
E07 - Mayor y menor de N numeros (RESUELTO)

ENUNCIADO:
  Pide n y despues n enteros. Muestra el mayor, el menor y en que posicion (1..n) estaba el mayor.

EJEMPLO DE EJECUCION:
  Cuantos: 5
  Numeros: 4 9 -2 9 1
  Mayor: 9 (posicion 2)
  Menor: -2

PISTA:
  Inicializa mayor y menor con el PRIMER dato.

SOLUCION:
  Se compara cada dato con el maximo y minimo provisionales.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Cuantos: ");
    scanf("%d", &n);
    printf("Numeros: ");
    int mayor = 0, menor = 0, posicion = 0;
    for (int i = 1; i <= n; i++) {
        int x = 0;
        scanf("%d", &x);
        if (i == 1 || x > mayor) {
            mayor = x;
            posicion = i;
        }
        if (i == 1 || x < menor) {
            menor = x;
        }
    }
    printf("Mayor: %d (posicion %d)\n", mayor, posicion);
    printf("Menor: %d\n", menor);
    return 0;
}
