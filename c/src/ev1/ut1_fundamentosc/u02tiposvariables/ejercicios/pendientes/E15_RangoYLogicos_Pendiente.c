/*
E15 - Rango de edad con operadores logicos (PENDIENTE)

ENUNCIADO:
  Con edad = 16 calcula con bool: es_menor (edad < 18), en_rango_escolar (6 a 16
  ambos incluidos) y necesita_permiso (menor y fuera del rango escolar). Muestra los tres.

EJEMPLO DE EJECUCION:
  es_menor: 1
  en_rango_escolar: 1
  necesita_permiso: 0

PISTA:
  Un rango se escribe con &&: edad >= 6 && edad <= 16.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdbool.h>

int main(void) {
    int edad = 16;
    // TODO: calcula los tres booleanos
    bool es_menor = false;
    bool en_rango_escolar = false;
    bool necesita_permiso = false;
    printf("es_menor: %d\n", es_menor);
    printf("en_rango_escolar: %d\n", en_rango_escolar);
    printf("necesita_permiso: %d\n", necesita_permiso);
    return 0;
}
