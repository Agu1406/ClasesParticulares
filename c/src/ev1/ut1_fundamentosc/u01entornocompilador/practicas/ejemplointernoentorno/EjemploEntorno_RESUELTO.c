/*
Practica ejemplo (entorno y compilador): ficha del programador (RESUELTO)

ENUNCIADO:
  Escribe un programa que muestre la ficha de abajo usando SOLO printf.
  Usa los caracteres de escape necesarios (\n, \t, \\ y \").

PISTA:
  El signo % se escribe %% dentro de printf.

SOLUCION:
  Cada linea es un printf; las barras y comillas se escapan con \.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("==============================\n");
    printf("    FICHA DEL PROGRAMADOR\n");
    printf("==============================\n");
    printf("Nombre:\tAgustin\n");
    printf("Lenguaje:\tC11\n");
    printf("Carpeta:\tC:\\clases\\c\n");
    printf("\"Un programa, un paso\"\n");
    printf("Progreso: 100%%\n");
    printf("==============================\n");
    return 0;
}
