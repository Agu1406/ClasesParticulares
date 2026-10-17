/*
E17 - Clasificar los caracteres de una linea (PENDIENTE)

ENUNCIADO:
  Lee una linea y muestra cuantas letras, digitos, espacios y otros caracteres contiene.

EJEMPLO DE EJECUCION:
  Linea: Ruta 66, km 12.
  Letras: 6
  Digitos: 4
  Espacios: 3
  Otros: 2

PISTA:
  Usa isalpha, isdigit e isspace.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main(void) {
    char linea[100];
    printf("Linea: ");
    if (fgets(linea, sizeof(linea), stdin) == NULL) {
        return 1;
    }
    linea[strcspn(linea, "\n")] = '\0';
    int letras = 0;
    int digitos = 0;
    int espacios = 0;
    int otros = 0;
    // TODO: recorre la linea y clasifica cada caracter
    printf("Letras: %d\n", letras);
    printf("Digitos: %d\n", digitos);
    printf("Espacios: %d\n", espacios);
    printf("Otros: %d\n", otros);
    return 0;
}
