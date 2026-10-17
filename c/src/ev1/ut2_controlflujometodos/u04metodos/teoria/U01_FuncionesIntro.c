/*
U01 - Funciones: que son, como se declaran y como se llaman.

OBJETIVO:
  - Entender por que dividimos un programa en funciones (reutilizar y ordenar).
  - Escribir funciones sin parametros ni valor devuelto (void).
  - Conocer la diferencia entre DECLARAR (prototipo), DEFINIR y LLAMAR a una funcion.
  - Saber que main es solo la primera funcion que se ejecuta.
  - Recordar que en C se usa el termino "funcion" (no "metodo"): la carpeta se
    llama u04metodos por paridad con Java/C#/C++.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

/*
PROTOTIPOS (declaraciones): le dicen al compilador que existe una funcion
con ese nombre, que recibe y que devuelve. Se escriben ANTES de usarla.
Permiten colocar main al principio y las funciones debajo.
*/
void imprimir_cabecera(void);
void imprimir_linea(void);
void saludar(void);

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Llamar a una funcion.
      Para ejecutar una funcion basta escribir su nombre seguido de ( ) y ;
      Cuando termina, el programa vuelve a la linea siguiente a la llamada.
    */
    printf("--- PRIMERA PARTE: Llamar funciones ---\n\n");

    saludar();
    saludar();      // se puede llamar tantas veces como se quiera

    /*
    SEGUNDA PARTE - Reutilizar codigo.
      Sin funciones habria que copiar y pegar el mismo bloque. Con una
      funcion, si hay que cambiarlo se cambia en UN solo sitio.
    */
    printf("\n--- SEGUNDA PARTE: Reutilizar ---\n\n");

    imprimir_cabecera();
    printf("Contenido del apartado 1\n");
    imprimir_linea();
    printf("Contenido del apartado 2\n");
    imprimir_linea();

    /*
    TERCERA PARTE - Orden de ejecucion.
      El programa SIEMPRE empieza en main. Las funciones solo se ejecutan
      cuando alguien las llama, no por estar escritas mas arriba o abajo.
    */
    printf("\n--- TERCERA PARTE: Orden de ejecucion ---\n\n");
    printf("1) main empieza\n");
    saludar();
    printf("3) main sigue despues de la llamada\n");

    /*
    CUARTA PARTE - Anatomia de una funcion.
        void  saludar  (void)  {  ...  }
        ^     ^        ^          ^
        |     |        |          cuerpo (las instrucciones)
        |     |        parametros: (void) = no recibe nada
        |     nombre (verbo en snake_case)
        tipo que devuelve: void = no devuelve nada
    */
    printf("\n--- CUARTA PARTE: Anatomia ---\n\n");
    printf("tipo_devuelto nombre(parametros) { cuerpo }\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}

/* DEFINICIONES: aqui esta el codigo real de cada funcion. */

void imprimir_cabecera(void) {
    printf("========================\n");
    printf("   INFORME DE EJEMPLO\n");
    printf("========================\n");
}

void imprimir_linea(void) {
    printf("------------------------\n");
}

void saludar(void) {
    printf("2) Hola desde la funcion saludar()\n");
}
