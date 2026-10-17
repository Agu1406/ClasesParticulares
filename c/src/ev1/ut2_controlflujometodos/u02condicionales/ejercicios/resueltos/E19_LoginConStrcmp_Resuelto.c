/*
E19 - Login con usuario y contrasena (RESUELTO)

ENUNCIADO:
  Pide usuario y contrasena (una palabra cada uno) y compara con 'admin' y '1234'
  usando strcmp. Mensajes: 'Acceso concedido', 'Contrasena incorrecta' o 'Usuario desconocido'.

EJEMPLO DE EJECUCION:
  Usuario y clave: admin 0000
  Contrasena incorrecta

PISTA:
  strcmp devuelve 0 cuando los textos son iguales.

SOLUCION:
  Nunca se comparan cadenas con ==; strcmp compara su contenido.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

int main(void) {
    char usuario[20] = "", clave[20] = "";
    printf("Usuario y clave: ");
    scanf("%19s %19s", usuario, clave);
    if (strcmp(usuario, "admin") != 0) {
        printf("Usuario desconocido\n");
    } else if (strcmp(clave, "1234") != 0) {
        printf("Contrasena incorrecta\n");
    } else {
        printf("Acceso concedido\n");
    }
    return 0;
}
