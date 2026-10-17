/*
E20 - Frecuencia de letras (RESUELTO)

ENUNCIADO:
  Lee una linea y muestra, en orden alfabetico, cuantas veces aparece cada letra (sin distinguir mayusculas). Solo las que aparecen al menos una vez.

EJEMPLO DE EJECUCION:
  Linea: Hola mundo
  a: 1
  d: 1
  h: 1
  l: 1
  m: 1
  n: 1
  o: 2
  u: 1

PISTA:
  Un array int frecuencia[26]; indice = letra - 'a'.

SOLUCION:
  Se cuenta en un array y luego se recorren las 26 posiciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <ctype.h>

int main(void) {
    char linea[100];
    printf("Linea: ");
    if (fgets(linea, sizeof(linea), stdin) == NULL) {
        return 1;
    }
    int frecuencia[26] = {0};
    for (int i = 0; linea[i] != '\0'; i++) {
        if (isalpha((unsigned char)linea[i])) {
            frecuencia[tolower((unsigned char)linea[i]) - 'a']++;
        }
    }
    for (int k = 0; k < 26; k++) {
        if (frecuencia[k] > 0) {
            printf("%c: %d\n", 'a' + k, frecuencia[k]);
        }
    }
    return 0;
}
