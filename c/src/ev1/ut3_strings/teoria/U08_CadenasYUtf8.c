/*
U08 — Por que este curso usa ASCII (aviso, no mini-curso Unicode).

OBJETIVO:
  - Recordar que char es un BYTE y strlen cuenta bytes, no "letras".
  - Ver que una e con tilde en UTF-8 ocupa 2 bytes.
  - Entender la politica del repo: codigo fuente en ASCII.
  - No implementar quita-tildes ni parsers UTF-8 en EV1.

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
    PRIMERA PARTE - Bytes frente a letras.
      En UTF-8, "cafe" con e acentuada son 5 bytes: c a f + 2 bytes de la e.
      strlen cuenta esos bytes. En ejercicios de EV1 trabajamos en ASCII.
    */
    printf("--- PRIMERA PARTE: Bytes frente a letras ---\n\n");

    const char *cafe = "caf\xC3\xA9";
    printf("strlen(\"cafe\" con tilde) = %zu bytes (no 4 letras)\n", strlen(cafe));
    printf("Bytes:");
    for (size_t i = 0; cafe[i] != '\0'; i++) {
        printf(" %02X", (unsigned char)cafe[i]);
    }
    printf("\n");

    /*
    SEGUNDA PARTE - Politica del repositorio.
      Un .c con tildes puede verse mal segun editor y consola.
      En clase: nombres y mensajes sin tildes (o con escapes si hace falta).
      Windows (opcional): chcp 65001 pone la consola en UTF-8.
    */
    printf("\n--- SEGUNDA PARTE: ASCII en clase ---\n\n");
    printf("Codigo y enunciados en ASCII. UTF-8 completo = fuera de EV1.\n");

    /*
    TERCERA PARTE - Que hacer en los ejercicios.
      Usa letras a-z, A-Z, digitos y signos. Si el enunciado pide "nino",
      escribelo sin tilde. strcmp y ctype trabajan byte a byte.
    */
    printf("\n--- TERCERA PARTE: En los ejercicios ---\n\n");
    printf("Trabaja con ASCII. No hace falta contar letras UTF-8.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
