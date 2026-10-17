/*
U03 - scanf con distintos tipos: char, texto, long, hexadecimal...

OBJETIVO:
  - Elegir el especificador de scanf correcto para cada tipo.
  - Leer un caracter sin que el salto de linea anterior lo estropee.
  - Leer una palabra (%s) limitando el tamano para evitar desbordes.
  - Leer una linea completa con espacios (%[^\n]).
  - Conocer las diferencias entre los formatos de printf y de scanf.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Tabla de formatos.
      Tipo            scanf           printf
      int             %d              %d
      unsigned int    %u              %u
      long            %ld             %ld
      long long       %lld            %lld
      float           %f              %f   (printf promociona float a double)
      double          %lf             %f   (en printf tambien vale %lf)
      char            %c              %c
      cadena          %s              %s
      hexadecimal     %x              %x
      Fijate en la diferencia: DOUBLE se lee con %lf pero se escribe con %f.
    */
    printf("--- PRIMERA PARTE: Enteros largos ---\n\n");

    long poblacion = 0;
    long long distancia = 0;
    printf("Poblacion de tu ciudad: ");
    scanf("%ld", &poblacion);
    printf("Distancia a la Luna en metros: ");
    scanf("%lld", &distancia);
    printf("Poblacion: %ld | Distancia: %lld m\n", poblacion, distancia);

    /*
    SEGUNDA PARTE - Leer un caracter.
      %c lee el SIGUIENTE caracter, sea cual sea... incluido el salto de
      linea que dejo el scanf anterior (cuando pulsaste Enter).
      Solucion: poner un ESPACIO delante:  scanf(" %c", &letra);
      El espacio le dice a scanf que ignore los blancos antes del caracter.
    */
    printf("\n--- SEGUNDA PARTE: Leer un caracter ---\n\n");

    char letra = ' ';
    printf("Escribe una letra: ");
    scanf(" %c", &letra);
    printf("Has escrito '%c' (codigo ASCII %d)\n", letra, letra);

    /*
    TERCERA PARTE - Leer una palabra.
      %s lee texto hasta el primer espacio. Necesita un array de char
      (se estudia en la unidad de cadenas). NO lleva &, porque el nombre
      de un array ya es su direccion.
      IMPORTANTE: limita siempre el numero de caracteres con %9s, %19s...
      (uno menos que el tamano del array, por el '\0' final) o un nombre
      largo escribiria fuera del array.
    */
    printf("\n--- TERCERA PARTE: Leer una palabra ---\n\n");

    char nombre[20];
    printf("Tu nombre (una palabra): ");
    scanf("%19s", nombre);
    printf("Hola, %s\n", nombre);

    /*
    CUARTA PARTE - Leer una linea con espacios.
      %[^\n] significa "lee todo menos el salto de linea".
      Hay que saltar antes el \n pendiente, por eso va un espacio delante:
          scanf(" %49[^\n]", frase);
      (Mas adelante veremos fgets, que es la forma recomendada.)
    */
    printf("\n--- CUARTA PARTE: Leer una linea ---\n\n");

    char frase[50];
    printf("Escribe una frase: ");
    scanf(" %49[^\n]", frase);
    printf("Has escrito: \"%s\"\n", frase);

    /*
    QUINTA PARTE - Hexadecimal y mezcla de formatos.
      Se pueden mezclar tipos y separadores literales en el formato:
        scanf("%d/%d/%d", &dia, &mes, &anio);   -> el usuario escribe 25/12/2024
    */
    printf("\n--- QUINTA PARTE: Formatos mezclados ---\n\n");

    int dia = 0, mes = 0, anio = 0;
    printf("Fecha con formato dd/mm/aaaa: ");
    scanf("%d/%d/%d", &dia, &mes, &anio);
    printf("Dia %d del mes %d del ano %d\n", dia, mes, anio);

    unsigned int color = 0;
    printf("Color en hexadecimal (ej. FF8800): ");
    scanf("%x", &color);
    printf("Rojo=%u Verde=%u Azul=%u\n", (color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF);

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
