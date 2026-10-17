/*
E17 - Primos gemelos hasta 50 (RESUELTO)

ENUNCIADO:
  Dos primos son gemelos si se diferencian en 2. Usa una funcion es_primo y muestra los pares (p, p+2) con ambos menores o iguales que 50.

EJEMPLO DE EJECUCION:
  3 y 5
  5 y 7
  11 y 13
  17 y 19
  29 y 31
  41 y 43

PISTA:
  Reutiliza es_primo(i) && es_primo(i + 2).

SOLUCION:
  Un for recorre los candidatos y la funcion booleana decide.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

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

int main(void) {
    for (int i = 2; i + 2 <= 50; i++) {
        if (es_primo(i) && es_primo(i + 2)) {
            printf("%d y %d\n", i, i + 2);
        }
    }
    return 0;
}
