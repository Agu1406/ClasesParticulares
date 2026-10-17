/*
U02 - La biblioteca <string.h>: copiar, concatenar y comparar.

OBJETIVO:
  - Usar strlen, strcpy, strcat, strcmp y sus variantes con limite (n).
  - Entender por que NO se puede asignar ni comparar cadenas con = y ==.
  - Evitar desbordar el array destino (buffer overflow).
  - Construir cadenas de forma segura con snprintf.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - No se asigna ni se compara con = y ==.
      char a[20]; a = "Hola";     ERROR de compilacion (un array no se asigna).
      if (a == b)                 compara DIRECCIONES de memoria, no el texto.
      Se usan strcpy y strcmp.
    */
    printf("--- PRIMERA PARTE: = y == no sirven ---\n\n");

    char a[] = "casa";
    char b[] = "casa";
    const char *pa = a;
    const char *pb = b;
    printf("Mismo texto, pero misma direccion? %s\n", pa == pb ? "si" : "no");
    printf("strcmp(a, b) == 0 ? %s\n", strcmp(a, b) == 0 ? "si (iguales)" : "no");

    /*
    SEGUNDA PARTE - strlen y strcpy.
      strlen(s)        longitud sin contar '\0'.
      strcpy(dst, src) copia src (con su '\0') en dst. dst debe tener sitio.
      strncpy(dst, src, n) copia como mucho n; OJO: si src es mas larga que n
      NO anade '\0'. Hay que poner el terminador a mano.
    */
    printf("\n--- SEGUNDA PARTE: strlen, strcpy, strncpy ---\n\n");

    char origen[] = "Programacion";
    char destino[32];
    strcpy(destino, origen);
    printf("Copia completa: \"%s\" (len %zu)\n", destino, strlen(destino));

    char corta[6];
    strncpy(corta, origen, sizeof(corta) - 1);
    corta[sizeof(corta) - 1] = '\0';
    printf("Copia limitada a 5: \"%s\"\n", corta);

    /*
    TERCERA PARTE - Concatenar con strcat / strncat.
      strcat(dst, src) pega src al final de dst. dst debe tener sitio para
      AMBAS cadenas y el '\0'.
    */
    printf("\n--- TERCERA PARTE: strcat ---\n\n");

    char nombre[40] = "Ana";
    strcat(nombre, " ");
    strcat(nombre, "Garcia");
    printf("Nombre completo: \"%s\"\n", nombre);

    char parcial[16] = "Hola, ";
    strncat(parcial, "mundo cruel", 5);
    printf("strncat con limite 5: \"%s\"\n", parcial);

    /*
    CUARTA PARTE - Comparar con strcmp.
      Devuelve 0 si son iguales, un numero negativo si la primera es
      "menor" (orden alfabetico/ASCII) y positivo si es "mayor".
      Mayusculas y minusculas son DISTINTAS (A=65 < a=97).
    */
    printf("\n--- CUARTA PARTE: strcmp ---\n\n");

    printf("strcmp(\"abc\", \"abc\") es 0?       %s\n", strcmp("abc", "abc") == 0 ? "si" : "no");
    printf("strcmp(\"abc\", \"abd\") es < 0?     %s\n", strcmp("abc", "abd") < 0 ? "si" : "no");
    printf("strcmp(\"b\", \"a\") es > 0?         %s\n", strcmp("b", "a") > 0 ? "si" : "no");
    printf("strcmp(\"Casa\", \"casa\") es < 0?   %s (A < a)\n", strcmp("Casa", "casa") < 0 ? "si" : "no");
    printf("strncmp(\"Hola\", \"Holi\", 3) == 0? %s\n", strncmp("Hola", "Holi", 3) == 0 ? "si" : "no");

    /*
    QUINTA PARTE - snprintf: construir cadenas de forma segura.
      snprintf(destino, tamano, formato, ...) escribe como mucho tamano-1
      caracteres y siempre pone '\0'. Devuelve cuantos habria escrito.
    */
    printf("\n--- QUINTA PARTE: snprintf ---\n\n");

    char ficha[40];
    snprintf(ficha, sizeof(ficha), "%s tiene %d anios", "Luis", 17);
    printf("%s\n", ficha);

    char pequena[8];
    int necesarios = snprintf(pequena, sizeof(pequena), "%s", "Texto demasiado largo");
    printf("En 8 bytes cabe: \"%s\" (hacian falta %d)\n", pequena, necesarios);

    /*
    SEXTA PARTE - El peligro: desbordar el destino.
      char pequeno[4]; strcpy(pequeno, "Hola mundo");  -> escribe fuera del
      array: comportamiento indefinido (fallos, cierres, agujeros de seguridad).
      Regla: antes de copiar o concatenar, comprueba que cabe.
    */
    printf("\n--- SEXTA PARTE: Comprobar que cabe ---\n\n");

    char buffer[10];
    const char *texto = "Hola mundo";
    if (strlen(texto) < sizeof(buffer)) {
        strcpy(buffer, texto);
        printf("Copiado: %s\n", buffer);
    } else {
        printf("No cabe: hacen falta %zu bytes y hay %zu\n", strlen(texto) + 1, sizeof(buffer));
    }

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
