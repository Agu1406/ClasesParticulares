/*
Practica ejemplo (cadenas): informe de una frase (RESUELTO)

ENUNCIADO:
  Lee una linea con fgets y muestra longitud, vocales, letras, digitos,
  espacios y la frase en mayusculas.

SOLUCION:
  fgets + recorte de '\n' + un solo recorrido que clasifica cada caracter.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>

static int es_vocal(int c);

int main(void) {
    char frase[128];
    char mayusculas[128];
    int vocales = 0;
    int letras = 0;
    int digitos = 0;
    int espacios = 0;
    size_t i;

    printf("Frase: ");
    if (fgets(frase, (int)sizeof(frase), stdin) == NULL) {
        return 1;
    }

    frase[strcspn(frase, "\n")] = '\0';

    for (i = 0; frase[i] != '\0'; i++) {
        unsigned char c = (unsigned char)frase[i];
        mayusculas[i] = (char)toupper(c);
        if (es_vocal(c)) {
            vocales++;
        }
        if (isalpha(c)) {
            letras++;
        } else if (isdigit(c)) {
            digitos++;
        } else if (isspace(c)) {
            espacios++;
        }
    }
    mayusculas[i] = '\0';

    printf("Longitud: %zu\n", strlen(frase));
    printf("Vocales: %d\n", vocales);
    printf("Letras: %d\n", letras);
    printf("Digitos: %d\n", digitos);
    printf("Espacios: %d\n", espacios);
    printf("Mayusculas: %s\n", mayusculas);
    return 0;
}

static int es_vocal(int c) {
    c = tolower(c);
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}
