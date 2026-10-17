/*
U01 - Comentarios: para que sirven y como escribirlos bien.

OBJETIVO:
  - Usar comentarios de linea (//) y de bloque (barra-asterisco ... asterisco-barra).
  - Escribir cabeceras y comentarios de documentacion al estilo Doxygen.
  - Explicar el POR QUE del codigo y no repetir lo que ya dice el codigo.
  - Desactivar codigo temporalmente (comentarios y #if 0).
  - Usar las marcas TODO y FIXME y conocer los errores tipicos con comentarios.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

/**
 * @brief Calcula el area de un triangulo.
 *
 * Este tipo de comentario (empieza por barra y DOS asteriscos) lo entienden
 * herramientas como Doxygen y los editores, que lo muestran al pasar el
 * raton sobre la funcion.
 *
 * @param base    Base del triangulo (mayor que 0).
 * @param altura  Altura del triangulo (mayor que 0).
 * @return        Area del triangulo en las mismas unidades al cuadrado.
 */
double area_triangulo(double base, double altura) {
    return base * altura / 2;
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Comentario de una linea //
      Empieza en // y llega hasta el final de la linea.
      Es valido desde C99 (en C89 solo existian los de bloque).
    */
    printf("--- PRIMERA PARTE: Comentario de linea ---\n\n");

    int edad = 20;   // tambien puede ir al final de una instruccion
    // Esta linea completa es un comentario
    printf("edad = %d\n", edad);

    /*
    SEGUNDA PARTE - Comentario de bloque (barra-asterisco ... asterisco-barra)
      Puede ocupar varias lineas.
      ERROR TIPICO: los comentarios de bloque NO se anidan. El primer
      asterisco-barra cierra el comentario, aunque hayas abierto otro dentro.
    */
    printf("\n--- SEGUNDA PARTE: Comentario de bloque ---\n\n");

    /* Este comentario ocupa
       varias lineas
       y el compilador lo ignora. */
    printf("Los comentarios de bloque no se pueden anidar.\n");

    /*
    TERCERA PARTE - Comentar el POR QUE y no el QUE.
      MAL:  i++;  // incrementa i
      BIEN: // saltamos la cabecera del fichero (primera linea)
      Un comentario que repite el codigo solo estorba y se queda
      desactualizado. Un buen comentario explica la INTENCION, la regla de
      negocio o la razon de un truco.
    */
    printf("\n--- TERCERA PARTE: Comentarios utiles ---\n\n");

    double precio = 100.0;
    // El IVA reducido (10%) se aplica a alimentacion segun la normativa vigente.
    double iva_reducido = 0.10;
    printf("Precio con IVA reducido: %.2f\n", precio * (1 + iva_reducido));

    /*
    CUARTA PARTE - Documentar funciones.
      Cada funcion publica deberia explicar: que hace, que recibe y que
      devuelve. Arriba tienes area_triangulo documentada con @brief, @param
      y @return.
    */
    printf("\n--- CUARTA PARTE: Funcion documentada ---\n\n");

    printf("area_triangulo(10, 4) = %.1f\n", area_triangulo(10, 4));

    /*
    QUINTA PARTE - Desactivar codigo.
      Para anular codigo de forma temporal:
        - Con // delante de cada linea (la mayoria de editores: Ctrl + K, Ctrl + C
          o Ctrl + / ).
        - Con #if 0 ... #endif: desactiva un bloque que YA contiene comentarios
          de bloque (cosa que los comentarios de bloque no permiten al no
          poder anidarse).
    */
    printf("\n--- QUINTA PARTE: Desactivar codigo ---\n\n");

    // printf("Esta linea esta comentada y no sale\n");

#if 0
    /* Todo este bloque se ignora, incluso con comentarios dentro. */
    printf("Este tampoco sale\n");
    printf("Ni este\n");
#endif

    printf("Solo se ve esta linea.\n");

    /*
    SEXTA PARTE - Marcas TODO y FIXME.
      Convencion que reconocen VS Code, CLion y otros editores:
        TODO:  algo pendiente de hacer
        FIXME: algo que esta roto y hay que arreglar
        NOTE:  aclaracion importante
    */
    printf("\n--- SEXTA PARTE: TODO y FIXME ---\n\n");

    // TODO: pedir el precio por teclado (se ve en la siguiente unidad)
    // FIXME: no se valida que el precio sea positivo
    printf("Busca TODO y FIXME en este fichero con Ctrl + Shift + F.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
