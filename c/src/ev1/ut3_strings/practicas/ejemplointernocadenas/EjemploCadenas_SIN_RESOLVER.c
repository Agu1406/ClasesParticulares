/*
Practica ejemplo (cadenas): informe de una frase (SIN RESOLVER)

ENUNCIADO:
  Lee una linea con fgets y muestra longitud, vocales, letras, digitos,
  espacios y la frase en mayusculas.

PISTA:
  Recorre la cadena con un for hasta '\0'. Usa isalpha, isdigit, isspace
  y toupper de <ctype.h>. Quita el '\n' que deja fgets.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main(void) {
    char frase[128];

    printf("Frase: ");
    // TODO: lee la linea con fgets, quita el '\n' y calcula el informe
    (void)frase;
    return 0;
}
