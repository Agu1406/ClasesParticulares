/*
U04 - Validar la entrada: valor devuelto por scanf y limpieza del buffer.

OBJETIVO:
  - Comprobar el valor que devuelve scanf (cuantos datos ha leido).
  - Entender por que una entrada incorrecta puede bloquear un programa.
  - Limpiar el buffer de entrada con getchar.
  - Repetir la lectura hasta que el dato sea valido (patron do-while).
  - Validar rangos (edad, nota, opcion de menu).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <stdio.h>

/*
Descarta todo lo que quede en el buffer hasta el salto de linea (o fin de
fichero). Se usa tras una lectura fallida o despues de scanf para limpiar
el \n que deja la tecla Enter.
*/
static void limpiar_buffer(void) {
    int c;
    while ((c = getchar()) != '\n' && c != EOF) {
        // no hacemos nada: solo consumimos caracteres
    }
}

/*
Pide un entero hasta que el usuario escriba uno valido dentro del rango.
Devuelve el valor, o -1 si se acaba la entrada (EOF).
*/
static int pedir_entero_en_rango(const char *mensaje, int minimo, int maximo) {
    int valor = 0;
    int leidos;
    do {
        printf("%s (%d-%d): ", mensaje, minimo, maximo);
        leidos = scanf("%d", &valor);
        if (leidos == EOF) {
            return -1;                 // no hay mas entrada
        }
        if (leidos != 1) {
            printf("  Eso no es un numero entero.\n");
            limpiar_buffer();          // quita la basura para no repetir el error
            continue;
        }
        limpiar_buffer();              // quita el \n que dejo Enter
        if (valor < minimo || valor > maximo) {
            printf("  Fuera de rango.\n");
        }
    } while (leidos != 1 || valor < minimo || valor > maximo);
    return valor;
}

int main(void) {
    printf("\n¡INICIO DEL PROGRAMA!\n\n");

    /*
    PRIMERA PARTE - El valor devuelto por scanf.
      scanf devuelve el numero de datos que ha conseguido leer:
        1  -> leyo el entero correctamente
        0  -> habia texto y no un numero (el dato NO se guardo)
        EOF (-1) -> no quedan mas datos de entrada
      Si ignoras ese valor, la variable conserva su valor anterior (o basura).
    */
    printf("--- PRIMERA PARTE: Valor de retorno ---\n\n");

    int numero = 0;
    printf("Escribe un entero: ");
    int resultado = scanf("%d", &numero);
    if (resultado == 1) {
        printf("Leido correctamente: %d\n", numero);
    } else if (resultado == 0) {
        printf("No era un numero. La variable sigue valiendo %d\n", numero);
    } else {
        printf("No hay mas entrada.\n");
    }

    /*
    SEGUNDA PARTE - El buffer de entrada.
      Lo que escribes va primero a un buffer y scanf lo consume por partes.
      Si escribes "abc" y scanf espera un numero, falla Y "abc" SIGUE en el
      buffer: la siguiente lectura fallara otra vez, en bucle infinito.
      Por eso tras un fallo hay que limpiar el buffer.
    */
    printf("\n--- SEGUNDA PARTE: Limpiar el buffer ---\n\n");

    limpiar_buffer();   // quita lo que pudiera quedar de la lectura anterior

    /*
    TERCERA PARTE - Repetir hasta que sea valido.
      La funcion pedir_entero_en_rango (arriba) usa do-while: pide, comprueba
      y repite mientras el dato no sea correcto.
    */
    printf("\n--- TERCERA PARTE: Pedir con validacion ---\n\n");

    int edad = pedir_entero_en_rango("Edad", 0, 120);
    if (edad >= 0) {
        printf("Edad aceptada: %d\n", edad);
    }

    /*
    CUARTA PARTE - Validar la opcion de un menu.
    */
    printf("\n--- CUARTA PARTE: Opcion de menu ---\n\n");

    printf("1. Nuevo\n2. Abrir\n3. Salir\n");
    int opcion = pedir_entero_en_rango("Opcion", 1, 3);
    printf("Elegiste la opcion %d\n", opcion);

    /*
    QUINTA PARTE - Resumen del patron seguro.
      1) Inicializa la variable.
      2) Llama a scanf y GUARDA su resultado.
      3) Si no es el numero esperado de datos: mensaje + limpiar buffer.
      4) Si el dato es correcto pero fuera de rango: mensaje y repite.
      Veras otra opcion mas robusta en U05: leer la linea entera con fgets.
    */
    printf("\n--- QUINTA PARTE: Resumen ---\n\n");
    printf("Comprobar retorno de scanf + limpiar buffer + validar rango.\n");

    printf("\n¡FIN DEL PROGRAMA!\n\n");
    return 0;
}
