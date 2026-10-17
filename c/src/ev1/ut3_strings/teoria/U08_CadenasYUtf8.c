/*
U08 - Caracteres especiales, tildes y UTF-8 en C.

OBJETIVO:
  - Entender que un char es un BYTE y que 'e' con tilde ocupa 2 bytes en UTF-8.
  - Saber por que strlen cuenta bytes, no letras.
  - Escribir tildes con secuencias de escape (\xC3\xA9) y evitar la trampa
    del escape hexadecimal que "se come" letras.
  - Contar caracteres UTF-8 reales y quitar tildes de forma manual.
  - Entender por que en este repositorio el codigo fuente es solo ASCII.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

static size_t contar_caracteres_utf8(const char *s);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - char es un byte.
      ASCII: 128 simbolos, 1 byte cada uno (A-Z, a-z, 0-9, signos).
      UTF-8: codificacion de texto de la mayoria de sistemas modernos.
        a, b, c...      -> 1 byte
        e con tilde     -> 2 bytes (0xC3 0xA9)
        euro, emoji...  -> 3 o 4 bytes
      Por eso strlen("e con tilde") devuelve 2, no 1.
    */
    printf("--- PRIMERA PARTE: Bytes frente a letras ---\n\n");

    const char *cafe = "caf\xC3\xA9";        // "cafe" con e acentuada en UTF-8
    printf("Bytes de la cadena (strlen): %zu\n", strlen(cafe));
    printf("Letras reales            : %zu\n", contar_caracteres_utf8(cafe));
    printf("Bytes en hexadecimal      :");
    for (const char *p = cafe; *p != '\0'; p++) {
        printf(" %02X", (unsigned char)*p);
    }
    printf("\n");

    /*
    SEGUNDA PARTE - Escribir tildes con escapes.
      Para que el fichero siga siendo ASCII se escriben los bytes:
        a \xC3\xA1   e \xC3\xA9   i \xC3\xAD   o \xC3\xB3   u \xC3\xBA
        n con tilde  \xC3\xB1
      TRAMPA: \x consume TODOS los digitos hexadecimales que le siguen.
        "Mar\xC3\xADa"  se interpreta como \xADA  (error o valor raro).
      SOLUCION: cortar el literal en dos y dejar que el compilador los una:
        "Mar\xC3\xAD" "a"
    */
    printf("\n--- SEGUNDA PARTE: Escapes hexadecimales ---\n\n");

    const char *maria = "Mar\xC3\xAD" "a";
    printf("Bytes de \"Maria\" con tilde: %zu | letras: %zu\n", strlen(maria), contar_caracteres_utf8(maria));

    /*
    TERCERA PARTE - Contar letras UTF-8.
      Un byte de continuacion tiene la forma 10xxxxxx (0x80..0xBF).
      Cada caracter empieza en un byte que NO es de continuacion.
    */
    printf("\n--- TERCERA PARTE: Contar letras ---\n\n");

    const char *ejemplos[] = {"hola", "ni\xC3\xB1" "o", "a\xC3\xA1" "e\xC3\xA9"};
    for (int i = 0; i < 3; i++) {
        printf("%zu bytes, %zu letras\n", strlen(ejemplos[i]), contar_caracteres_utf8(ejemplos[i]));
    }

    /*
    CUARTA PARTE - Quitar tildes (solo vocales con tilde en UTF-8).
      Se detecta el byte 0xC3 seguido de otro byte y se sustituye el par
      por la vocal sin tilde. Esta tabla cubre las minusculas.
    */
    printf("\n--- CUARTA PARTE: Quitar tildes ---\n\n");

    const unsigned char con_tilde[] = {0xA1, 0xA9, 0xAD, 0xB3, 0xBA};   // a e i o u
    const char sin_tilde[] = "aeiou";
    const char *entrada = "Jos\xC3\xA9 est\xC3\xA1 aqu\xC3\xAD";
    char salida[64];
    size_t j = 0;
    for (size_t i = 0; entrada[i] != '\0' && j + 1 < sizeof(salida); i++) {
        unsigned char c = (unsigned char)entrada[i];
        if (c == 0xC3 && entrada[i + 1] != '\0') {
            unsigned char sig = (unsigned char)entrada[i + 1];
            int encontrada = 0;
            for (size_t k = 0; k < sizeof(con_tilde); k++) {
                if (sig == con_tilde[k]) {
                    salida[j++] = sin_tilde[k];
                    encontrada = 1;
                    break;
                }
            }
            if (!encontrada) {
                salida[j++] = (char)c;      // otro caracter: se deja tal cual
                salida[j++] = (char)sig;
            }
            i++;                            // el segundo byte ya esta tratado
        } else {
            salida[j++] = (char)c;
        }
    }
    salida[j] = '\0';
    printf("Resultado en ASCII puro: \"%s\"\n", salida);

    /*
    QUINTA PARTE - Por que este repositorio usa solo ASCII.
      Un .c con tildes puede mostrarse mal segun el editor y la consola
      (en Windows la consola clasica usa otra codificacion). Con ASCII y
      escapes, el programa se ve igual en cualquier maquina.
      Truco en Windows (opcional): chcp 65001 cambia la consola a UTF-8.
    */
    printf("\n--- QUINTA PARTE: ASCII en el repositorio ---\n\n");
    printf("Texto sin tildes y escapes para lo especial: portable.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static size_t contar_caracteres_utf8(const char *s) {
    size_t n = 0;
    for (size_t i = 0; s[i] != '\0'; i++) {
        unsigned char b = (unsigned char)s[i];
        if ((b & 0xC0) != 0x80) {     // no es byte de continuacion
            n++;
        }
    }
    return n;
}
