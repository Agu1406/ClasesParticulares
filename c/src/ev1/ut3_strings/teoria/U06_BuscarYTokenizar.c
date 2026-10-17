/*
U06 - Buscar, extraer y dividir cadenas.

OBJETIVO:
  - Buscar un caracter (strchr, strrchr) o una subcadena (strstr).
  - Calcular posiciones restando punteros.
  - Extraer partes con memcpy / strncpy.
  - Dividir una cadena en trozos con strtok.
  - Reemplazar y contar apariciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>
#include <string.h>

static int contar_subcadena(const char *texto, const char *buscada);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - strchr y strrchr.
      strchr(s, c)   puntero a la PRIMERA aparicion de c (o NULL).
      strrchr(s, c)  puntero a la ULTIMA aparicion (o NULL).
      La posicion (indice) es: resultado - s.
    */
    printf("--- PRIMERA PARTE: strchr / strrchr ---\n\n");

    const char *ruta = "documentos/clase/notas.txt";
    const char *primera = strchr(ruta, '/');
    const char *ultima = strrchr(ruta, '/');
    if (primera != NULL) {
        printf("Primera '/' en la posicion %td\n", primera - ruta);
    }
    if (ultima != NULL) {
        printf("Ultima '/' en la posicion %td -> fichero: %s\n", ultima - ruta, ultima + 1);
    }
    printf("strchr(ruta, 'z') es NULL? %s\n", strchr(ruta, 'z') == NULL ? "si" : "no");

    /*
    SEGUNDA PARTE - strstr: buscar una subcadena.
    */
    printf("\n--- SEGUNDA PARTE: strstr ---\n\n");

    const char *frase = "el gato negro y el gato blanco";
    const char *pos = strstr(frase, "gato");
    if (pos != NULL) {
        printf("\"gato\" aparece en la posicion %td\n", pos - frase);
        printf("Desde ahi: \"%s\"\n", pos);
    }
    printf("Apariciones de \"gato\": %d\n", contar_subcadena(frase, "gato"));
    printf("Apariciones de \"el\": %d\n", contar_subcadena(frase, "el"));

    /*
    TERCERA PARTE - Extraer una parte (subcadena).
      No hay substring: se copian n caracteres y se pone el '\0'.
    */
    printf("\n--- TERCERA PARTE: Extraer ---\n\n");

    const char *fecha = "13/10/2026";
    char dia[3];
    char mes[3];
    char anio[5];
    memcpy(dia, fecha, 2);
    dia[2] = '\0';
    memcpy(mes, fecha + 3, 2);
    mes[2] = '\0';
    memcpy(anio, fecha + 6, 4);
    anio[4] = '\0';
    printf("Dia=%s Mes=%s Anio=%s\n", dia, mes, anio);

    /*
    CUARTA PARTE - strtok: dividir por separadores.
      strtok MODIFICA la cadena (pone '\0' en los separadores), asi que
      se aplica sobre una COPIA en un array. La primera llamada recibe la
      cadena; las siguientes, NULL.
    */
    printf("\n--- CUARTA PARTE: strtok ---\n\n");

    char lista[] = "manzana,pera;uva naranja";
    int n = 0;
    for (char *trozo = strtok(lista, ",; "); trozo != NULL; trozo = strtok(NULL, ",; ")) {
        n++;
        printf("  trozo %d: \"%s\"\n", n, trozo);
    }
    printf("Total de trozos: %d\n", n);

    /*
    QUINTA PARTE - Reemplazar un caracter por otro (en el sitio).
    */
    printf("\n--- QUINTA PARTE: Reemplazar ---\n\n");

    char texto[] = "uno dos tres cuatro";
    for (char *p = strchr(texto, ' '); p != NULL; p = strchr(p + 1, ' ')) {
        *p = '_';
    }
    printf("Con guiones bajos: %s\n", texto);

    /*
    SEXTA PARTE - Quitar espacios de los extremos (trim).
    */
    printf("\n--- SEXTA PARTE: Trim ---\n\n");

    char sucio[] = "   hola mundo   ";
    char *inicio = sucio;
    while (*inicio == ' ') {
        inicio++;
    }
    size_t largo = strlen(inicio);
    while (largo > 0 && inicio[largo - 1] == ' ') {
        largo--;
    }
    inicio[largo] = '\0';
    printf("Tras trim: \"%s\"\n", inicio);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

static int contar_subcadena(const char *texto, const char *buscada) {
    int veces = 0;
    size_t largo = strlen(buscada);
    if (largo == 0) {
        return 0;
    }
    for (const char *p = strstr(texto, buscada); p != NULL; p = strstr(p + largo, buscada)) {
        veces++;
    }
    return veces;
}
