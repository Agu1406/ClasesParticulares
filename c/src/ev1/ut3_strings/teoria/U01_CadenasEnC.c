/*
U01 - Cadenas en C: arrays de char terminados en '\0'.

OBJETIVO:
  - Entender que en C NO existe el tipo String: una cadena es un array de char
    que termina en el caracter nulo '\0'.
  - Diferenciar arreglo modificable (char s[]) y literal (const char *).
  - Distinguir sizeof (tamano del array) y strlen (caracteres hasta '\0').
  - Imprimir cadenas con %s y recorrerlas caracter a caracter.

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
    PRIMERA PARTE - Una cadena es un array de char con '\0' al final.
      "Hola" ocupa 5 bytes: 'H' 'o' 'l' 'a' '\0'.
      El '\0' (valor 0) marca donde acaba la cadena. Sin el, las funciones
      seguirian leyendo memoria ajena.
    */
    printf("--- PRIMERA PARTE: El caracter nulo ---\n\n");

    char saludo[] = "Hola";
    printf("saludo           = %s\n", saludo);
    printf("sizeof(saludo)   = %zu (incluye el '\\0')\n", sizeof(saludo));
    printf("strlen(saludo)   = %zu (sin el '\\0')\n", strlen(saludo));

    for (size_t i = 0; i < sizeof(saludo); i++) {
        printf("saludo[%zu] = %3d '%c'\n", i, saludo[i], saludo[i] == '\0' ? '?' : saludo[i]);
    }

    /*
    SEGUNDA PARTE - Formas de declarar una cadena.
      char a[] = "Hola";            array del tamano justo (5), MODIFICABLE
      char b[20] = "Hola";          array con espacio de sobra, modificable
      char c[] = {'H','o','l','a','\0'};  igual que a, escrito caracter a caracter
      const char *d = "Hola";       puntero a literal: SOLO LECTURA
    */
    printf("\n--- SEGUNDA PARTE: Formas de declarar ---\n\n");

    char a[] = "Hola";
    char b[20] = "Hola";
    char c[] = {'H', 'o', 'l', 'a', '\0'};
    const char *d = "Hola";
    printf("a: %zu bytes | b: %zu bytes | c: %zu bytes | d es un puntero de %zu bytes\n",
           sizeof(a), sizeof(b), sizeof(c), sizeof(d));
    printf("strlen de las cuatro: %zu %zu %zu %zu\n", strlen(a), strlen(b), strlen(c), strlen(d));

    /*
    TERCERA PARTE - Modificar caracteres.
      En un array se puede cambiar cualquier posicion. Cambiar un literal
      (const char *) es comportamiento indefinido (suele cerrar el programa).
      Acortar una cadena: basta con poner un '\0' antes.
    */
    printf("\n--- TERCERA PARTE: Modificar ---\n\n");

    a[0] = 'J';
    printf("Cambiando la inicial: %s\n", a);

    char frase[] = "Hola mundo";
    frase[4] = '\0';
    printf("Cortada en la posicion 4: \"%s\"\n", frase);
    printf("Pero el array sigue ocupando %zu bytes\n", sizeof(frase));

    /*
    CUARTA PARTE - Recorrer una cadena.
      Se avanza hasta encontrar '\0'. Dos estilos equivalentes.
    */
    printf("\n--- CUARTA PARTE: Recorrer ---\n\n");

    const char *texto = "Programar";
    int cuenta = 0;
    for (int i = 0; texto[i] != '\0'; i++) {
        cuenta++;
    }
    printf("Con indice: \"%s\" tiene %d caracteres\n", texto, cuenta);

    cuenta = 0;
    for (const char *p = texto; *p != '\0'; p++) {
        cuenta++;
    }
    printf("Con puntero: \"%s\" tiene %d caracteres\n", texto, cuenta);

    /*
    QUINTA PARTE - Caracter frente a cadena.
      'A'  es un char (1 byte, un numero: 65).
      "A"  es una cadena de 2 bytes: 'A' y '\0'.
      Se comparan con == (char) o con strcmp (cadenas), nunca mezclados.
    */
    printf("\n--- QUINTA PARTE: 'A' frente a \"A\" ---\n\n");

    printf("sizeof('A') en C = %zu (es un int)\n", sizeof('A'));
    printf("sizeof(\"A\")    = %zu\n", sizeof("A"));
    printf("'A' vale %d en ASCII\n", 'A');

    /*
    SEXTA PARTE - Cadena vacia y NULL.
      "" es una cadena valida de longitud 0 (solo el '\0').
      NULL es "no hay cadena": usarla con %s o strlen es un error.
    */
    printf("\n--- SEXTA PARTE: Cadena vacia ---\n\n");

    char vacia[] = "";
    printf("strlen(\"\") = %zu | sizeof = %zu\n", strlen(vacia), sizeof(vacia));

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
