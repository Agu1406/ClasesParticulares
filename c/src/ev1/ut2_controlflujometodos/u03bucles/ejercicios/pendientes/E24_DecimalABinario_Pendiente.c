/*
E24 - Decimal a binario (PENDIENTE)

ENUNCIADO:
  Pide un entero positivo y muestralo en binario (dividiendo entre 2 y guardando los restos).

EJEMPLO DE EJECUCION:
  Numero: 37
  Binario: 100101

PISTA:
  Construye el resultado como numero decimal: binario += resto * posicion.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int n = 0;
    printf("Numero: ");
    scanf("%d", &n);
    long long binario = 0, posicion = 1;
    // TODO: convierte a binario con un while
    printf("Binario: %lld\n", binario);
    return 0;
}
