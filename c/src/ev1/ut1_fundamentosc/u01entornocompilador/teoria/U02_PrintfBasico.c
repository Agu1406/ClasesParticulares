/*
U02 — printf: secuencias de escape y especificadores de formato.

OBJETIVO:
  - Usar las secuencias de escape mas habituales: \n \t \" \\ \a \r.
  - Mostrar valores con especificadores de formato: %d %f %c %s %%.
  - Controlar anchura y decimales: %5d, %-8s, %.2f, %08.3f.
  - Saber que printf devuelve el numero de caracteres escritos.
  - Entender que el compilador NO comprueba (del todo) que formato y dato coincidan.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Secuencias de escape.
      Empiezan por \ y representan caracteres especiales:
        \n  salto de linea          \t  tabulador
        \"  comilla doble           \\  barra invertida
        \r  retorno de carro        \a  pitido (puede no sonar en tu terminal)
    */
    printf("--- PRIMERA PARTE: Secuencias de escape ---\n\n");

    printf("Nombre:\tAgustin\n");
    printf("Curso:\tPrimero de DAM\n");
    printf("Frase: \"Aprender C cuesta, pero compensa\"\n");
    printf("Ruta: C:\\clases\\c\n");

    /*
    SEGUNDA PARTE - Especificadores de formato.
      El primer argumento de printf es la CADENA DE FORMATO. Cada %x se
      sustituye por el siguiente argumento, en orden:
        %d  entero con signo (int)         %f  decimal (double)
        %c  un caracter                    %s  una cadena de texto
        %%  el simbolo % literal
    */
    printf("\n--- SEGUNDA PARTE: %%d %%f %%c %%s ---\n\n");

    int edad = 19;
    double nota = 8.75;
    char inicial = 'A';

    printf("Edad: %d anos\n", edad);
    printf("Nota media: %f\n", nota);
    printf("Inicial: %c\n", inicial);
    printf("Modulo: %s\n", "Programacion");
    printf("Aprobado con un %d%% de aciertos\n", 85);

    /*
    TERCERA PARTE - Varios valores en un mismo printf.
      Importante: el numero de %x debe coincidir con el numero de argumentos
      y el tipo de cada %x con el tipo del argumento.
    */
    printf("\n--- TERCERA PARTE: Varios valores ---\n\n");

    printf("%s tiene %d anos y una nota de %.1f\n", "Lucia", 18, 9.5);
    printf("Letra: %c | Codigo ASCII: %d\n", 'a', 'a');  // un char es un numero

    /*
    CUARTA PARTE - Anchura y decimales.
      %5d     entero alineado a la derecha en 5 columnas
      %-8s    texto alineado a la izquierda en 8 columnas
      %.2f    dos decimales (redondea)
      %08.3f  anchura 8, rellena con ceros, 3 decimales
    */
    printf("\n--- CUARTA PARTE: Anchura y decimales ---\n\n");

    printf("[%5d]\n", 42);
    printf("[%-5d]\n", 42);
    printf("[%05d]\n", 42);
    printf("[%-8s]\n", "C");
    printf("[%8s]\n", "C");
    printf("%.2f\n", 3.14159);
    printf("%08.3f\n", 3.14159);

    // Una tabla alineada sin esfuerzo:
    printf("\n%-10s %6s\n", "Producto", "Precio");
    printf("%-10s %6.2f\n", "Cafe", 1.5);
    printf("%-10s %6.2f\n", "Tostada", 2.25);
    printf("%-10s %6.2f\n", "Zumo", 3.0);

    /*
    QUINTA PARTE - Otros formatos utiles.
      %x  hexadecimal    %o  octal    %e  notacion cientifica    %p  direccion
      %u  entero sin signo    %ld  long    %lf es lo mismo que %f en printf
    */
    printf("\n--- QUINTA PARTE: Hexadecimal, octal y cientifica ---\n\n");

    printf("255 en decimal: %d\n", 255);
    printf("255 en hexadecimal: %x\n", 255);
    printf("255 en hexadecimal (mayusculas): %X\n", 255);
    printf("255 en octal: %o\n", 255);
    printf("123456.789 en cientifica: %e\n", 123456.789);

    /*
    SEXTA PARTE - printf devuelve cuantos caracteres ha escrito.
      Casi nunca se usa, pero demuestra que printf es una funcion mas.
    */
    printf("\n--- SEXTA PARTE: Valor devuelto por printf ---\n\n");

    int escritos = printf("Hola");
    printf("\nprintf escribio %d caracteres\n", escritos);

    /*
    SEPTIMA PARTE - Peligro: formato y dato deben coincidir.
      printf("%d", 3.5) es un error logico: el resultado es basura.
      Los compiladores avisan con -Wall (warning: format '%d' expects 'int').
      Regla: entero -> %d, decimal -> %f, caracter -> %c, texto -> %s.
    */
    printf("\n--- SEPTIMA PARTE: Formato correcto ---\n\n");

    printf("Correcto : %f\n", 3.5);
    printf("Correcto : %d\n", 3);
    printf("(Prueba a escribir %%d con 3.5 y compila con -Wall para ver el aviso)\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
