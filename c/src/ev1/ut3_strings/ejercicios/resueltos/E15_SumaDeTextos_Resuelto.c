/*
E15 - Sumar dos numeros leidos como texto (RESUELTO)

ENUNCIADO:
  Lee dos lineas con fgets y conviertelas con strtol. Si alguna no es un entero valido, muestra 'Entrada no valida' (por stderr) y termina con codigo 1.
  Si ambas son validas muestra 'Suma: N'.

EJEMPLO DE EJECUCION:
  A: 12
  B: 30
  Suma: 42

PISTA:
  fin == texto o *fin no es '\0' (permite el salto de linea final) -> no valido.

SOLUCION:
  Tras strtol, el puntero fin debe quedar en el '\n' o en el '\0'.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

static bool leer_entero(const char *mensaje, long *valor) {
    char linea[40];
    printf("%s", mensaje);
    if (fgets(linea, sizeof(linea), stdin) == NULL) {
        return false;
    }
    char *fin = NULL;
    long v = strtol(linea, &fin, 10);
    if (fin == linea || (*fin != '\n' && *fin != '\0')) {
        return false;
    }
    *valor = v;
    return true;
}

int main(void) {
    long a = 0;
    long b = 0;
    if (!leer_entero("A: ", &a) || !leer_entero("B: ", &b)) {
        fprintf(stderr, "Entrada no valida\n");
        return 1;
    }
    printf("Suma: %ld\n", a + b);
    return 0;
}
