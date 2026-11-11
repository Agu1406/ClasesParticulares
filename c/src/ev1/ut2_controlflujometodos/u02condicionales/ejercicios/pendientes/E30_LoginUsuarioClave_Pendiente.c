/*
E30 - Login usuario y clave (PENDIENTE)

ENUNCIADO:
  Usuario correcto: alumna  Clave: 2026. Pide ambos (scanf %s, sin espacios). Si los dos coinciden (strcmp): Acceso concedido; si el usuario falla: Usuario incorrecto; si el usuario vale pero la clave no: Clave incorrecta.

EJEMPLO DE EJECUCION:
  Usuario: alumna
  Clave: 2026
  Acceso concedido

PISTA:
  strcmp == 0. Comprueba primero el usuario.

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
    // TODO: login
    return 0;
}
