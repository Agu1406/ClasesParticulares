/*
E19 - Login con usuario y contrasena (PENDIENTE)

ENUNCIADO:
  Pide usuario y contrasena (una palabra cada uno) y compara con 'admin' y '1234'
  usando strcmp. Mensajes: 'Acceso concedido', 'Contrasena incorrecta' o 'Usuario desconocido'.

EJEMPLO DE EJECUCION:
  Usuario y clave: admin 0000
  Contrasena incorrecta

PISTA:
  strcmp devuelve 0 cuando los textos son iguales.

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
    // TODO: comprueba usuario y clave con strcmp
    return 0;
}
