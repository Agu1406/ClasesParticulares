/*
E14 - Comparar dos palabras (PENDIENTE)

ENUNCIADO:
  Lee dos palabras (lineas) y muestra 'Iguales' si coinciden, 'La primera va antes' o 'La segunda va antes' segun el orden alfabetico (strcmp).

EJEMPLO DE EJECUCION:
  Primera: manzana
  Segunda: pera
  La primera va antes

PISTA:
  strcmp devuelve 0, negativo o positivo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

int main(void) {
    char a[50];
    char b[50];
    printf("Primera: ");
    fgets(a, sizeof(a), stdin);
    a[strcspn(a, "\n")] = '\0';
    printf("Segunda: ");
    fgets(b, sizeof(b), stdin);
    b[strcspn(b, "\n")] = '\0';
    // TODO: compara con strcmp y muestra el resultado
    return 0;
}
