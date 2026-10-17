/*
U01 — Primer programa en C.

OBJETIVO:
  - Conocer la estructura minima de un programa C: #include, int main y return.
  - Usar printf para mostrar texto en la consola.
  - Entender que cada instruccion termina con punto y coma (;).
  - Diferenciar instrucciones ejecutables de comentarios explicativos.
  - Saber que C distingue mayusculas de minusculas (printf != Printf).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - El clasico "Hola Mundo".
      Todo programa C empieza a ejecutarse en la funcion int main(void).
      printf pertenece a la biblioteca estandar y se declara en <stdio.h>
      (STanDard Input Output). Sin el #include el compilador no conoce printf.

      A diferencia de C++, NO existe cout ni endl: el salto de linea hay que
      escribirlo a mano con la secuencia de escape \n.

      Recuerda, hay que memorizar como escribir las primeras lineas
      (include, main, printf, return) aunque no las entendamos del todo.
    */
    printf("--- PRIMERA PARTE: Hola Mundo ---\n\n");

    printf("Hola Mundo\n");

    // Cada instruccion termina con punto y coma. Sin el ; el compilador da error.
    printf("Bienvenido a C\n");

    /*
    SEGUNDA PARTE - Varias instrucciones en secuencia.
      El programa se ejecuta de arriba a abajo, linea a linea.
      Cada printf es una instruccion independiente.
    */
    printf("\n--- SEGUNDA PARTE: Varias lineas de salida ---\n\n");

    printf("Linea 1: Aprendiendo C\n");
    printf("Linea 2: Paso a paso\n");
    printf("Linea 3: Con ejemplos claros\n");

    /*
    TERCERA PARTE - Sin \n todo sale en la misma linea.
      printf NO anade el salto de linea por si solo. Si te olvidas del \n,
      el siguiente mensaje se pega al anterior. Es el error tipico en clase.
    */
    printf("\n--- TERCERA PARTE: Sin salto de linea ---\n\n");

    printf("Esto ");
    printf("sale ");
    printf("en ");
    printf("una sola linea");
    printf("\n");  // ahora si saltamos de linea

    /*
    CUARTA PARTE - Comillas, barra invertida y mayusculas.
      Las cadenas van entre comillas dobles.
      Para mostrar comillas dentro del texto se escapan con barra invertida: \"
      Para mostrar la propia barra invertida se escribe doble: \\
      C es case-sensitive: Printf, PRINTF o PrintF NO compilian. Solo vale printf.
    */
    printf("\n--- CUARTA PARTE: Comillas, rutas y mayusculas ---\n\n");

    printf("El lenguaje se llama \"C\" (una sola letra).\n");
    printf("FP = Formacion Profesional\n");
    printf("Una ruta de Windows: C:\\Users\\alumno\\clases\n");
    printf("¡Este mensaje lleva signos de exclamacion!\n");

    /*
    QUINTA PARTE - Comentarios: el compilador los ignora.
      Los comentarios de una linea empiezan con //   (valido desde C99).
      Los comentarios de bloque van entre barra-asterisco y asterisco-barra.
      Sirven para explicar el codigo a otras personas (o a ti dentro de un mes).
    */
    printf("\n--- QUINTA PARTE: Comentarios vs codigo ejecutable ---\n\n");

    // Este comentario NO se ejecuta; solo documenta la siguiente linea.
    printf("Solo las instrucciones sin // se ejecutan.\n");

    /*
       Este bloque multilinea tampoco se ejecuta.
       Puede ocupar varias lineas sin problema.
    */
    printf("Los comentarios no cambian el comportamiento del programa.\n");

    /*
    SEXTA PARTE - Estructura minima de un programa didactico.
      Patron habitual en este repositorio:
        1) Cabecera con objetivos al inicio del archivo.
        2) #include <stdio.h> e int main(void).
        3) Mensaje de inicio.
        4) Demos organizadas por partes.
        5) Mensaje de fin y return 0.
    */
    printf("\n--- SEXTA PARTE: Resumen de estructura ---\n\n");

    printf("Un programa C minimo necesita:\n");
    printf("  - #include <stdio.h> para poder usar printf\n");
    printf("  - Una funcion int main(void) { ... return 0; }\n");
    printf("  - Instrucciones terminadas en punto y coma\n");
    printf("  - Comentarios opcionales para explicar el codigo\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
