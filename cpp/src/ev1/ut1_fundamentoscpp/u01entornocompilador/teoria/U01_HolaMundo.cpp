#include <iostream>
using namespace std;

/*
U01 — Primer programa en C++.

OBJETIVO:
  - Conocer la estructura minima de un programa con int main.
  - Usar cout para mostrar texto en la consola.
  - Entender que cada instruccion termina con punto y coma (;).
  - Diferenciar instrucciones ejecutables de comentarios explicativos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - El clasico "Hola Mundo".
      En C++ el programa empieza en la funcion int main().
      Hay que incluir <iostream> y, en este curso, usamos using namespace std;
      para escribir cout en lugar de std::cout.
    */
    cout << "--- PRIMERA PARTE: Hola Mundo ---\n" << endl;

    // cout << ... << endl: escribe el texto y salta a la siguiente linea.
    cout << "Hola Mundo" << endl;

    // Cada instruccion termina con punto y coma. Sin el ; el compilador da error.
    cout << "Bienvenido a C++" << endl;

    /*
    SEGUNDA PARTE - Varias instrucciones en secuencia.
      El programa se ejecuta de arriba a abajo, linea a linea.
      Cada cout es una instruccion independiente.
    */
    cout << "\n--- SEGUNDA PARTE: Varias lineas de salida ---\n" << endl;

    cout << "Linea 1: Aprendiendo C++" << endl;
    cout << "Linea 2: Paso a paso" << endl;
    cout << "Linea 3: Con ejemplos claros" << endl;

    /*
    TERCERA PARTE - Texto entre comillas y caracteres especiales.
      Las cadenas van entre comillas dobles " ".
      Para mostrar comillas dentro del texto, se escapan con backslash \".
    */
    cout << "\n--- TERCERA PARTE: Comillas y mensajes variados ---\n" << endl;

    cout << "El lenguaje se llama \"C++\" (con dos signos mas)." << endl;
    cout << "FP = Formacion Profesional" << endl;
    cout << "¡Este mensaje lleva signos de exclamacion!" << endl;

    /*
    CUARTA PARTE - Comentarios: el compilador los ignora.
      Los comentarios de una linea empiezan con //
      Los comentarios de bloque van entre /* y * / (sin espacio entre * y /).
      Sirven para explicar el codigo a otros programadores (o a ti mismo).
    */
    cout << "\n--- CUARTA PARTE: Comentarios vs codigo ejecutable ---\n" << endl;

    // Este comentario NO se ejecuta; solo documenta la siguiente linea.
    cout << "Solo las instrucciones sin // se ejecutan." << endl;

    /*
       Este bloque multilinea tampoco se ejecuta.
       Puede ocupar varias lineas sin problema.
    */
    cout << "Los comentarios no cambian el comportamiento del programa." << endl;

    /*
    QUINTA PARTE - Estructura minima de un programa didactico.
      Patron habitual en este repositorio:
        1) Cabecera con objetivos (bloque /* al inicio del archivo).
        2) #include <iostream>, using namespace std; e int main().
        3) Mensaje de inicio.
        4) Demos organizadas por partes.
        5) Mensaje de fin y return 0;
    */
    cout << "\n--- QUINTA PARTE: Resumen de estructura ---\n" << endl;

    cout << "Un programa C++ minimo necesita:" << endl;
    cout << "  - #include <iostream> y using namespace std;" << endl;
    cout << "  - Una funcion int main() { ... return 0; }" << endl;
    cout << "  - Instrucciones que hagan algo (cout, etc.)." << endl;
    cout << "  - Punto y coma al final de cada instruccion." << endl;
    cout << "  - Comentarios opcionales para explicar el codigo." << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
