/*
E02 - Cuenta atras (RESUELTO)

ENUNCIADO:
  Pide un numero n y muestra la cuenta atras desde n hasta 1 y despues 'Despegue!'.

EJEMPLO DE EJECUCION:
  N: 5
  5 4 3 2 1 Despegue!

PISTA:
  El for puede decrementar: i--.

SOLUCION:
  Se recorre de n hasta 1 con la condicion i >= 1.

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
    for (int i = n; i >= 1; i--) {
        printf("%d ", i);
    }
    printf("Despegue!\n");
    return 0;
}
