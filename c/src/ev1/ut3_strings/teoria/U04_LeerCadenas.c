/*
U04 - Leer cadenas del teclado de forma segura.

OBJETIVO:
  - Ver por que scanf("%s") es limitado (para en el primer espacio) y peligroso.
  - Usar fgets para leer una linea completa con limite.
  - Quitar el salto de linea final con strcspn.
  - Detectar lineas demasiado largas y vaciar el resto del buffer.
  - Leer una cadena y luego un numero sin que se "salte" la lectura.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

static bool leer_linea(const char *mensaje, char *destino, size_t capacidad);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - scanf("%s") con limite.
      %s lee hasta el primer espacio. Sin limite puede desbordar el array.
      Con "%19s" lee como mucho 19 caracteres y deja sitio al '\0'.
      Lee: una palabra.
    */
    printf("--- PRIMERA PARTE: scanf %%s con limite ---\n\n");

    char palabra[20];
    printf("Escribe una palabra: ");
    if (scanf("%19s", palabra) == 1) {
        printf("Has escrito: \"%s\"\n", palabra);
    }

    /*
    SEGUNDA PARTE - El salto de linea que queda en el buffer.
      Tras el scanf anterior queda un '\n' sin leer. Si ahora usamos fgets,
      leeria una linea VACIA. Hay que consumir el resto de la linea.
    */
    printf("\n--- SEGUNDA PARTE: Vaciar el buffer ---\n\n");

    int ch;
    while ((ch = getchar()) != '\n' && ch != EOF) {
        // descarta lo que quede de la linea
    }

    /*
    TERCERA PARTE - fgets: una linea completa.
      fgets(destino, tamano, stdin) lee hasta tamano-1 caracteres o hasta
      el salto de linea (que SE GUARDA). Hay que quitarlo.
    */
    printf("\n--- TERCERA PARTE: fgets ---\n\n");

    char frase[40];
    printf("Escribe una frase: ");
    if (fgets(frase, sizeof(frase), stdin) != NULL) {
        frase[strcspn(frase, "\n")] = '\0';     // quita el '\n' si existe
        printf("Frase: \"%s\" (%zu caracteres)\n", frase, strlen(frase));
    }

    /*
    CUARTA PARTE - Funcion reutilizable leer_linea.
      Devuelve false si hubo fin de entrada. Si la linea es mas larga que el
      buffer, descarta el sobrante para que no contamine la siguiente lectura.
    */
    printf("\n--- CUARTA PARTE: leer_linea ---\n\n");

    char nombre[8];
    if (leer_linea("Nombre (maximo 7 letras): ", nombre, sizeof(nombre))) {
        printf("Nombre guardado: \"%s\"\n", nombre);
    }

    /*
    QUINTA PARTE - Cadena y despues numero.
      Mejor leer SIEMPRE con fgets y convertir con sscanf: no deja basura.
    */
    printf("\n--- QUINTA PARTE: fgets + sscanf ---\n\n");

    char linea[32];
    int edad = 0;
    if (leer_linea("Edad: ", linea, sizeof(linea)) && sscanf(linea, "%d", &edad) == 1) {
        printf("Edad leida: %d\n", edad);
    } else {
        printf("La edad no era un numero\n");
    }

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static bool leer_linea(const char *mensaje, char *destino, size_t capacidad) {
    printf("%s", mensaje);
    if (fgets(destino, (int)capacidad, stdin) == NULL) {
        return false;
    }
    size_t pos = strcspn(destino, "\n");
    if (destino[pos] == '\n') {
        destino[pos] = '\0';                    // linea completa
    } else {
        int ch;                                 // linea demasiado larga: descarta el resto
        while ((ch = getchar()) != '\n' && ch != EOF) {
        }
    }
    return true;
}
