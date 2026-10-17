/*
E12 - Leer y mostrar un contacto (RESUELTO)

ENUNCIADO:
  Define el struct Contacto (nombre, telefono, edad). Lee los tres datos del teclado (nombre y telefono con fgets) y muestra la ficha con el formato del ejemplo.
  Si la edad no es un numero, muestra 'Edad no valida' y termina.

EJEMPLO DE EJECUCION:
  Nombre: Ana Lopez
  Telefono: 600123456
  Edad: 31
  --- FICHA ---
  Ana Lopez (31 anios) - Tel. 600123456

PISTA:
  Lee todo con fgets y quita el '\n' con strcspn; la edad con sscanf.

SOLUCION:
  Primero se rellena el struct campo a campo y despues se imprime.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

typedef struct {
    char nombre[40];
    char telefono[16];
    int edad;
} Contacto;

static void leer_texto(const char *mensaje, char *destino, size_t cap) {
    printf("%s", mensaje);
    if (fgets(destino, (int)cap, stdin) == NULL) {
        destino[0] = '\0';
        return;
    }
    destino[strcspn(destino, "\n")] = '\0';
}

int main(void) {
    Contacto c = {"", "", 0};
    char linea[16];
    leer_texto("Nombre: ", c.nombre, sizeof(c.nombre));
    leer_texto("Telefono: ", c.telefono, sizeof(c.telefono));
    leer_texto("Edad: ", linea, sizeof(linea));
    if (sscanf(linea, "%d", &c.edad) != 1) {
        printf("Edad no valida\n");
        return 1;
    }
    printf("--- FICHA ---\n");
    printf("%s (%d anios) - Tel. %s\n", c.nombre, c.edad, c.telefono);
    return 0;
}
