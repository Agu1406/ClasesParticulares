/*
U05 — Errores de compilacion que salen en la primera semana.

OBJETIVO:
  - Reconocer los avisos y errores mas habituales de gcc en clase.
  - Distinguir error de compilacion, warning, error de enlazado y error logico.
  - Saber leer "error: ... " : el fichero, la linea y el motivo.
  - Compilar SIEMPRE con -Wall -Wextra: un warning casi siempre es un fallo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - Como se lee un error de gcc.
      gcc escribe algo parecido a:
        U01_HolaMundo.c:35:5: error: expected ';' before 'printf'
      Se lee asi:
        fichero : linea : columna : tipo : mensaje
      El numero de linea es el sitio donde gcc se dio cuenta, no siempre
      el sitio exacto del fallo (a veces el ; falta en la linea de encima).
    */
    printf("--- PRIMERA PARTE: Como leer un error ---\n\n");
    printf("fichero.c:LINEA:COLUMNA: error: mensaje\n");
    printf("Ejemplo: U01_HolaMundo.c:35:5: error: expected ';' before 'printf'\n");

    /*
    SEGUNDA PARTE - Los cinco errores de la primera semana.
      1) Falta el punto y coma.
         error: expected ';' before ...
      2) Te olvidas de #include <stdio.h>
         warning: implicit declaration of function 'printf'
      3) Escribes Printf o PRINTF (C distingue mayusculas).
         error: implicit declaration of function 'Printf'
      4) Te come una comilla o un parentesis.
         error: missing terminating " character
         error: expected ')' before ...
      5) Formato y dato no coinciden (solo avisa con -Wall).
         warning: format '%d' expects argument of type 'int'
    */
    printf("\n--- SEGUNDA PARTE: Los cinco de la primera semana ---\n\n");
    printf("1) Falta ;\n");
    printf("2) Falta #include <stdio.h>\n");
    printf("3) Printf en vez de printf\n");
    printf("4) Comilla o parentesis sin cerrar\n");
    printf("5) %%d con un decimal (warning con -Wall)\n");

    /*
    TERCERA PARTE - Warning no es "opcional".
      Un warning deja generar el .exe, pero casi siempre el programa
      hara algo raro. En este curso un warning se trata como un error:
      se arregla antes de entregar.
    */
    printf("\n--- TERCERA PARTE: Warnings ---\n\n");
    printf("Compila con: gcc -std=c11 -Wall -Wextra -pedantic fichero.c -o prog\n");
    printf("Si gcc se queja, no sigas: arregla el aviso.\n");

    /*
    CUARTA PARTE - Otros tipos de fallo (para no confundirlos).
      Compilacion: gcc se niega a crear el .exe (falta ;, tipo mal).
      Enlazado:    "undefined reference to ..." (falta una funcion o -lm).
      Ejecucion:   el .exe se crea, pero se cuelga o se cierra.
      Logico:      funciona, pero el resultado es incorrecto.
    */
    printf("\n--- CUARTA PARTE: No todos los fallos son del compilador ---\n\n");
    printf("Compilacion -> no hay ejecutable\n");
    printf("Enlazado    -> undefined reference to `funcion'\n");
    printf("Ejecucion   -> el programa se cierra o se cuelga\n");
    printf("Logico      -> 2 + 2 = 5 (compila, pero esta mal)\n");

    /*
    QUINTA PARTE - Ritual de clase cuando "no me compila".
      1. Mira la PRIMERA linea de error (las de abajo suelen ser eco).
      2. Abre esa linea en el editor.
      3. Comprueba ;  comillas  parentesis  include  mayusculas.
      4. Vuelve a compilar. No cambies tres cosas a la vez.
    */
    printf("\n--- QUINTA PARTE: Ritual cuando no compila ---\n\n");
    printf("Lee el primer error, toca UNA cosa, vuelve a compilar.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
