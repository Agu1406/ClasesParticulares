/*
E05 - Comillas y barra invertida (RESUELTO)

ENUNCIADO:
  Muestra exactamente estas dos lineas (con las comillas y las barras):
    Dijo: "Hola" y se fue
    Ruta: C:\datos\notas.txt

EJEMPLO DE EJECUCION:
  Dijo: "Hola" y se fue
  Ruta: C:\datos\notas.txt

PISTA:
  Dentro de una cadena, la comilla se escribe \" y la barra invertida \\.

SOLUCION:
  \" produce una comilla y \\ produce una barra invertida.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("Dijo: \"Hola\" y se fue\n");
    printf("Ruta: C:\\datos\\notas.txt\n");
    return 0;
}
