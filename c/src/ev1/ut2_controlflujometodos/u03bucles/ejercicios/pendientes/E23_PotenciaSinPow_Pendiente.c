/*
E23 - Potencia sin pow (PENDIENTE)

ENUNCIADO:
  Pide base entera y exponente entero >= 0 y calcula base^exponente con un bucle (long long).

EJEMPLO DE EJECUCION:
  Base y exponente: 3 5
  3^5 = 243

PISTA:
  Multiplica 'exponente' veces; cualquier numero elevado a 0 es 1.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    int base = 0, exp = 0;
    printf("Base y exponente: ");
    scanf("%d %d", &base, &exp);
    // TODO: calcula la potencia
    long long potencia = 1;
    printf("%d^%d = %lld\n", base, exp, potencia);
    return 0;
}
