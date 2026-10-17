/*
U05 - Convertir entre cadenas y numeros.

OBJETIVO:
  - Convertir texto a numero con strtol y strtod (y por que atoi no es fiable).
  - Detectar entradas incorrectas ("12abc", "", desbordamiento).
  - Convertir numeros a texto con snprintf.
  - Convertir un digito char a int y al reves.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <limits.h>
#include <stdbool.h>

static bool texto_a_int(const char *texto, int *resultado);
static bool texto_a_double(const char *texto, double *resultado);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - atoi: sencillo pero sin control de errores.
      atoi("123") = 123 | atoi("abc") = 0 (igual que atoi("0"): no se distingue!)
      No hay forma de saber si hubo error. Solo para ejemplos rapidos.
    */
    printf("--- PRIMERA PARTE: atoi ---\n\n");

    printf("atoi(\"123\") = %d\n", atoi("123"));
    printf("atoi(\"abc\") = %d (error silencioso)\n", atoi("abc"));
    printf("atoi(\"12abc\") = %d (ignora lo que sobra)\n", atoi("12abc"));

    /*
    SEGUNDA PARTE - strtol / strtod: con control de errores.
      long strtol(const char *s, char **fin, int base)
      Si 'fin' apunta al inicio de la cadena, no se leyo nada.
      Si *fin no es '\0', sobraron caracteres.
      errno == ERANGE indica que el numero no cabe.
    */
    printf("\n--- SEGUNDA PARTE: strtol ---\n\n");

    const char *pruebas[] = {"42", "-17", "  8", "12abc", "abc", "", "99999999999"};
    for (int i = 0; i < 7; i++) {
        int valor = 0;
        if (texto_a_int(pruebas[i], &valor)) {
            printf("\"%s\" -> %d\n", pruebas[i], valor);
        } else {
            printf("\"%s\" -> NO valido\n", pruebas[i]);
        }
    }

    /*
    TERCERA PARTE - Decimales con strtod.
      strtod usa el punto decimal (locale "C" por defecto).
    */
    printf("\n--- TERCERA PARTE: strtod ---\n\n");

    const char *reales[] = {"3.14", "-0.5", "2e3", "1,5"};
    for (int i = 0; i < 4; i++) {
        double d = 0.0;
        if (texto_a_double(reales[i], &d)) {
            printf("\"%s\" -> %.3f\n", reales[i], d);
        } else {
            printf("\"%s\" -> NO valido\n", reales[i]);
        }
    }

    /*
    CUARTA PARTE - Otras bases con strtol.
      Base 2, 8, 16 o 0 (detecta 0x... y 0...).
    */
    printf("\n--- CUARTA PARTE: Bases ---\n\n");

    printf("binario \"1011\" = %ld\n", strtol("1011", NULL, 2));
    printf("hexadecimal \"ff\" = %ld\n", strtol("ff", NULL, 16));
    printf("base 0 \"0x1A\" = %ld\n", strtol("0x1A", NULL, 0));

    /*
    QUINTA PARTE - Numero a texto con snprintf.
    */
    printf("\n--- QUINTA PARTE: Numero a cadena ---\n\n");

    char buffer[32];
    snprintf(buffer, sizeof(buffer), "%d", 2026);
    printf("Entero a texto: \"%s\" (longitud %zu)\n", buffer, strlen(buffer));
    snprintf(buffer, sizeof(buffer), "%.2f", 3.14159);
    printf("Decimal a texto: \"%s\"\n", buffer);
    snprintf(buffer, sizeof(buffer), "%05d", 42);
    printf("Con ceros: \"%s\"\n", buffer);

    /*
    SEXTA PARTE - Digito y caracter.
      '7' - '0' = 7      (los digitos son consecutivos en ASCII)
      '0' + 7   = '7'
    */
    printf("\n--- SEXTA PARTE: Digito <-> caracter ---\n\n");

    char dc = '7';
    int digito = dc - '0';
    char de_vuelta = (char)('0' + digito + 1);
    printf("'%c' -> %d -> sumando 1 -> '%c'\n", dc, digito, de_vuelta);

    int suma = 0;
    for (const char *p = "12345"; *p != '\0'; p++) {
        suma += *p - '0';
    }
    printf("Suma de las cifras de \"12345\" = %d\n", suma);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static bool texto_a_int(const char *texto, int *resultado) {
    char *fin = NULL;
    errno = 0;
    long v = strtol(texto, &fin, 10);
    if (fin == texto || *fin != '\0') {
        return false;                    // nada leido o caracteres sobrantes
    }
    if (errno == ERANGE || v < INT_MIN || v > INT_MAX) {
        return false;                    // fuera de rango
    }
    *resultado = (int)v;
    return true;
}

static bool texto_a_double(const char *texto, double *resultado) {
    char *fin = NULL;
    errno = 0;
    double v = strtod(texto, &fin);
    if (fin == texto || *fin != '\0' || errno == ERANGE) {
        return false;
    }
    *resultado = v;
    return true;
}
