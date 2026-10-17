/*
E10 - Mostrar los argumentos del programa (RESUELTO)

ENUNCIADO:
  Usa int main(int argc, char *argv[]) para mostrar cuantos argumentos recibe el
  programa y el texto de cada uno. Ejecutalo asi: ./programa uno dos
  Si no se pasa ningun argumento extra, muestra 'Sin argumentos'.

EJEMPLO DE EJECUCION:
  Numero de argumentos: 3
  argv[0] = ./programa
  argv[1] = uno
  argv[2] = dos

PISTA:
  argc cuenta tambien el nombre del programa (argv[0]). Recorre con un for.

SOLUCION:
  argv es un array de textos; for (i = 0; i < argc; i++) los recorre todos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(int argc, char *argv[]) {
    printf("Numero de argumentos: %d\n", argc);
    for (int i = 0; i < argc; i++) {
        printf("argv[%d] = %s\n", i, argv[i]);
    }
    if (argc == 1) {
        printf("Sin argumentos\n");
    }
    return 0;
}
