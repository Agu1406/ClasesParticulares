/*
U05 - Leer lineas con fgets y convertirlas (sscanf, strtol, strtod).

OBJETIVO:
  - Leer una linea completa de forma SEGURA con fgets.
  - Quitar el salto de linea final que fgets conserva.
  - Convertir el texto leido a numero con sscanf, strtol y strtod.
  - Detectar errores de conversion (no es un numero / sobran caracteres).
  - Conocer por que este patron es mas robusto que scanf directo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <stdlib.h>   // strtol, strtod
#include <string.h>   // strcspn

#define TAM_LINEA 64

/*
Lee una linea de teclado en 'destino' (maximo 'tam' - 1 caracteres) y quita
el '\n' final. Devuelve 1 si ha leido algo y 0 si se acabo la entrada.
*/
static int leer_linea(char *destino, int tam) {
    if (fgets(destino, tam, stdin) == NULL) {
        return 0;
    }
    destino[strcspn(destino, "\n")] = '\0';   // sustituye el \n por el fin de cadena
    return 1;
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - fgets: leer una linea.
      fgets(destino, tamano, stdin) lee como mucho tamano - 1 caracteres, para
      en el salto de linea (y LO GUARDA) y siempre termina con '\0'.
      Ventajas frente a scanf("%s"): admite espacios y nunca desborda.
    */
    printf("--- PRIMERA PARTE: fgets ---\n\n");

    char nombre[TAM_LINEA];
    printf("Nombre completo: ");
    if (leer_linea(nombre, TAM_LINEA)) {
        printf("Hola, %s! (tu nombre tiene %d caracteres)\n", nombre, (int)strlen(nombre));
    }

    /*
    SEGUNDA PARTE - Quitar el '\n': strcspn.
      strcspn(texto, "\n") devuelve la posicion del primer '\n' (o la longitud
      si no hay). Poniendo '\0' en esa posicion, el salto desaparece.
      Esta linea:  destino[strcspn(destino, "\n")] = '\0';
      es el modismo estandar y esta en leer_linea.
    */

    /*
    TERCERA PARTE - sscanf: leer datos de un texto.
      sscanf funciona como scanf pero sobre una cadena que YA tenemos.
      Devuelve cuantos datos leyo, igual que scanf.
    */
    printf("\n--- TERCERA PARTE: sscanf ---\n\n");

    char linea[TAM_LINEA];
    int edad = 0;
    printf("Edad: ");
    if (leer_linea(linea, TAM_LINEA)) {
        if (sscanf(linea, "%d", &edad) == 1) {
            printf("Edad leida: %d\n", edad);
        } else {
            printf("'%s' no es una edad valida\n", linea);
        }
    }

    /*
    CUARTA PARTE - strtol: la conversion mas fiable.
      long strtol(const char *texto, char **fin, int base)
        - 'fin' apunta al primer caracter que NO se pudo convertir.
        - Si *fin == texto, no se leyo nada.
        - Si **fin no es '\0', sobraron caracteres ("12abc").
      atoi() hace lo mismo sin avisar de errores: evitalo.
    */
    printf("\n--- CUARTA PARTE: strtol ---\n\n");

    printf("Un numero entero: ");
    if (leer_linea(linea, TAM_LINEA)) {
        char *fin;
        long valor = strtol(linea, &fin, 10);
        if (fin == linea) {
            printf("No has escrito ningun numero.\n");
        } else if (*fin != '\0') {
            printf("Leido %ld pero sobran caracteres: \"%s\"\n", valor, fin);
        } else {
            printf("Numero correcto: %ld (el doble es %ld)\n", valor, valor * 2);
        }
    }

    /*
    QUINTA PARTE - strtod: lo mismo para reales.
    */
    printf("\n--- QUINTA PARTE: strtod ---\n\n");

    printf("Un precio (ej. 12.5): ");
    if (leer_linea(linea, TAM_LINEA)) {
        char *fin;
        double precio = strtod(linea, &fin);
        if (fin == linea || *fin != '\0') {
            printf("'%s' no es un precio valido.\n", linea);
        } else {
            printf("Precio con IVA: %.2f\n", precio * 1.21);
        }
    }

    /*
    SEXTA PARTE - Conversion de un numero a texto: sprintf / snprintf.
      Es el camino inverso: escribe en una cadena en vez de en pantalla.
      snprintf limita el tamano y es la version segura.
    */
    printf("\n--- SEXTA PARTE: snprintf ---\n\n");

    char texto[32];
    snprintf(texto, sizeof(texto), "Edad: %d, precio: %.2f", 20, 9.5);
    printf("Cadena construida: \"%s\"\n", texto);

    /*
    SEPTIMA PARTE - Por que usar fgets + conversion.
      scanf deja basura en el buffer si falla y mezcla mal con %c y %s.
      fgets lee SIEMPRE una linea completa: cada pregunta consume su linea y
      no se arrastran errores a la siguiente.
    */
    printf("\n--- SEPTIMA PARTE: Resumen ---\n\n");
    printf("fgets lee la linea | strtol/strtod convierten y avisan de errores\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
