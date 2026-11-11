/*
E30 - Login usuario y clave (RESUELTO)

ENUNCIADO:
  Usuario correcto: alumna  Clave: 2026. Pide ambos (scanf %s, sin espacios). Si los dos coinciden (strcmp): Acceso concedido; si el usuario falla: Usuario incorrecto; si el usuario vale pero la clave no: Clave incorrecta.

EJEMPLO DE EJECUCION:
  Usuario: alumna
  Clave: 2026
  Acceso concedido

SOLUCION:
  strcmp, no == entre arrays.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

int main(void) {
    char usuario[32];
    char clave[32];
    printf("Usuario: ");
    scanf("%31s", usuario);
    printf("Clave: ");
    scanf("%31s", clave);
    if (strcmp(usuario, "alumna") != 0) {
        printf("Usuario incorrecto\n");
    } else if (strcmp(clave, "2026") != 0) {
        printf("Clave incorrecta\n");
    } else {
        printf("Acceso concedido\n");
    }
    return 0;
}
