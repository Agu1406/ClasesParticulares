/*
U03 - Clasificar y transformar caracteres con <ctype.h>.

OBJETIVO:
  - Usar isalpha, isdigit, isalnum, isspace, isupper, islower, ispunct.
  - Convertir con toupper y tolower.
  - Recorrer una cadena y transformarla "en el sitio".
  - Contar vocales, palabras y tipos de caracter.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

static void a_mayusculas(char *s);
static void a_minusculas(char *s);
static int contar_vocales(const char *s);
static int contar_palabras(const char *s);
static void invertir(char *s);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Clasificar caracteres.
      Estas funciones reciben un char (como int) y devuelven != 0 si cumple.
      Para evitar problemas con caracteres con signo, se castea a unsigned char.
    */
    printf("--- PRIMERA PARTE: Clasificar ---\n\n");

    const char *muestra = "Aa1 !";
    for (int i = 0; muestra[i] != '\0'; i++) {
        unsigned char c = (unsigned char)muestra[i];
        printf("'%c': alpha=%d digit=%d space=%d upper=%d lower=%d punct=%d\n", c,
               isalpha(c) != 0, isdigit(c) != 0, isspace(c) != 0,
               isupper(c) != 0, islower(c) != 0, ispunct(c) != 0);
    }

    /*
    SEGUNDA PARTE - toupper y tolower.
      Devuelven el caracter convertido (o el mismo si no es letra).
      NO modifican la variable: hay que guardar el resultado.
    */
    printf("\n--- SEGUNDA PARTE: toupper / tolower ---\n\n");

    char c = 'g';
    printf("toupper('g') = %c | tolower('Q') = %c | toupper('7') = %c\n", toupper(c), tolower('Q'), toupper('7'));

    char texto[] = "Hola Mundo 2026";
    a_mayusculas(texto);
    printf("Mayusculas: %s\n", texto);
    a_minusculas(texto);
    printf("Minusculas: %s\n", texto);

    /*
    TERCERA PARTE - Contar.
    */
    printf("\n--- TERCERA PARTE: Contar ---\n\n");

    const char *frase = "  El rapido zorro marron salta  ";
    printf("Vocales : %d\n", contar_vocales(frase));
    printf("Palabras: %d\n", contar_palabras(frase));

    int letras = 0;
    int digitos = 0;
    int espacios = 0;
    int otros = 0;
    const char *mixto = "Ruta 66, km 12.";
    for (const char *p = mixto; *p != '\0'; p++) {
        if (isalpha((unsigned char)*p)) {
            letras++;
        } else if (isdigit((unsigned char)*p)) {
            digitos++;
        } else if (isspace((unsigned char)*p)) {
            espacios++;
        } else {
            otros++;
        }
    }
    printf("\"%s\" -> letras=%d digitos=%d espacios=%d otros=%d\n", mixto, letras, digitos, espacios, otros);

    /*
    CUARTA PARTE - Transformar en el sitio: invertir.
      Se intercambian los extremos y se avanza hacia el centro.
    */
    printf("\n--- CUARTA PARTE: Invertir ---\n\n");

    char palabra[] = "programa";
    invertir(palabra);
    printf("Invertida: %s\n", palabra);

    /*
    QUINTA PARTE - Palindromo ignorando mayusculas y no letras.
      Se usan dos indices, uno por cada extremo, saltando lo que no es letra.
    */
    printf("\n--- QUINTA PARTE: Palindromo ---\n\n");

    const char *candidatas[] = {"Anita lava la tina", "Reconocer", "Programar"};
    for (int k = 0; k < 3; k++) {
        const char *s = candidatas[k];
        int i = 0;
        int j = (int)strlen(s) - 1;
        bool es = true;
        while (i < j) {
            if (!isalpha((unsigned char)s[i])) {
                i++;
            } else if (!isalpha((unsigned char)s[j])) {
                j--;
            } else {
                if (tolower((unsigned char)s[i]) != tolower((unsigned char)s[j])) {
                    es = false;
                    break;
                }
                i++;
                j--;
            }
        }
        printf("\"%s\" %s palindromo\n", s, es ? "es" : "no es");
    }

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static void a_mayusculas(char *s) {
    for (int i = 0; s[i] != '\0'; i++) {
        s[i] = (char)toupper((unsigned char)s[i]);
    }
}

static void a_minusculas(char *s) {
    for (int i = 0; s[i] != '\0'; i++) {
        s[i] = (char)tolower((unsigned char)s[i]);
    }
}

static int contar_vocales(const char *s) {
    int n = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        switch (tolower((unsigned char)s[i])) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                n++;
                break;
            default:
                break;
        }
    }
    return n;
}

static int contar_palabras(const char *s) {
    int palabras = 0;
    bool dentro = false;
    for (int i = 0; s[i] != '\0'; i++) {
        if (isspace((unsigned char)s[i])) {
            dentro = false;
        } else if (!dentro) {
            dentro = true;
            palabras++;
        }
    }
    return palabras;
}

static void invertir(char *s) {
    int i = 0;
    int j = (int)strlen(s) - 1;
    while (i < j) {
        char aux = s[i];
        s[i] = s[j];
        s[j] = aux;
        i++;
        j--;
    }
}
