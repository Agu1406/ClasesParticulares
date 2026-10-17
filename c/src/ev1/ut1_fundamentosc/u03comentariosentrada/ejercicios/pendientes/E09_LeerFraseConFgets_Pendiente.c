/*
E09 - Leer una frase con fgets (PENDIENTE)

ENUNCIADO:
  Lee una frase completa (con espacios) usando fgets, quita el salto de linea y
  muestra la frase entre comillas y su longitud (strlen).

EJEMPLO DE EJECUCION:
  Frase: Hola que tal
  Has escrito: "Hola que tal" (12 caracteres)

PISTA:
  frase[strcspn(frase, "\n")] = '\0'; elimina el \n que guarda fgets.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

int main(void) {
    char frase[80] = "";
    printf("Frase: ");
    // TODO: lee la linea con fgets
    // TODO: quita el salto de linea final
    printf("Has escrito: \"%s\" (%d caracteres)\n", frase, (int)strlen(frase));
    return 0;
}
