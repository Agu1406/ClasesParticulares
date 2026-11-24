/*
U01 — Introduccion a ficheros (esqueleto EV2).

OBJETIVO:
  - Abrir un fichero de texto, escribir una linea y leerla.
  - Cerrar con fclose. UT8 amplia modos, binario y errores.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    FILE *f = fopen("hola_ev2.txt", "w");
    if (f == NULL) {
        printf("No se pudo crear el fichero\n");
        return 1;
    }
    fprintf(f, "Hola EV2 ficheros\n");
    fclose(f);

    f = fopen("hola_ev2.txt", "r");
    if (f == NULL) {
        printf("No se pudo abrir el fichero\n");
        return 1;
    }
    char linea[64];
    if (fgets(linea, (int)sizeof(linea), f) != NULL) {
        printf("Leido: %s", linea);
    }
    fclose(f);
    return 0;
}
