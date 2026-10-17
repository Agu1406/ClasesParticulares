/*
E19 - Mayor y menor de cinco numeros (PENDIENTE)

ENUNCIADO:
  Lee cinco enteros y muestra el mayor, el menor y la diferencia entre ambos.

EJEMPLO DE EJECUCION:
  Introduce 5 numeros: 4 -2 9 0 7
  Mayor: 9
  Menor: -2
  Diferencia: 11

PISTA:
  Inicializa maximo y minimo con el primer numero leido.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Introduce 5 numeros: ");
    scanf("%d", &n);
    int mayor = n;
    int menor = n;
    // TODO: lee los 4 numeros restantes y actualiza mayor y menor
    printf("Mayor: %d\n", mayor);
    printf("Menor: %d\n", menor);
    printf("Diferencia: %d\n", mayor - menor);
    return 0;
}
