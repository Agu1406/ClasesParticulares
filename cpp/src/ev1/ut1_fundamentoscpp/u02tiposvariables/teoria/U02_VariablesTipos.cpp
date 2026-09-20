#include <iostream>
#include <string>
using namespace std;

/*
U02 — Tipos de variables en C++.

En la clase previa vimos que distintas variables guardan distinta informacion:
  - int (enteros)
  - double (decimales)
  - string (texto)
  - bool (verdadero / falso)
  - char (un solo caracter)

En C++ el tipo se decide en compilacion: no hay GetType() de C#.
Se declara el tipo (o se usa auto) y ese tipo NO cambia.

OBJETIVO:
  - Recordar los tipos basicos.
  - Mostrar el tipo de cada variable (en este curso, escrito a proposito).
  - Entender que en C++ el tipo de una variable NO cambia
    (a diferencia de Python, donde dato = 26 y luego dato = "texto" es valido).
  - Ver auto (inferencia) frente a tipo explicito.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;
    cout << boolalpha;

    /*
    PRIMERA PARTE - Mostrar valores y sus tipos.
    */
    cout << "¡IMPRIMIENDO DATOS DE EJEMPLO Y SUS TIPOS!\n" << endl;

    int edad = 26;
    double altura = 1.76;
    bool soyHumano = true;
    string nombre = "Agustín";
    char letra = 'A';

    cout << "Edad: " << edad << " - Tipo: int" << endl;
    cout << "Altura: " << altura << " - Tipo: double" << endl;
    cout << "¿Soy humano?: " << soyHumano << " - Tipo: bool" << endl;
    cout << "Nombre: " << nombre << " - Tipo: string" << endl;
    cout << "Letra: " << letra << " - Tipo: char" << endl;

    /*
    SEGUNDA PARTE - Tipo declarado frente a valor.
      El compilador g++ comprueba el tipo al compilar.
      Si escribes edad = "texto"; el programa ni siquiera llega a ejecutarse.
    */
    cout << "\n¡EL TIPO SE COMPRUEBA AL COMPILAR!\n" << endl;
    cout << "edad esta declarada como int. El compilador lo sabe sin ejecutar." << endl;
    cout << "¿edad es int? true (lo dice la declaracion: int edad = 26;)" << endl;

    /*
    TERCERA PARTE - Inferencia con auto (el compilador deduce el tipo).
      Una vez inferido, el tipo sigue siendo fijo.
      CUIDADO: auto ciudad = "Sevilla"; NO deduce string, deduce un literal de texto.
      Para string usa tipo explicito o auto ciudad = string("Sevilla");
    */
    cout << "\n¡INFERENCIA CON auto!\n" << endl;
    auto ciudad = string("Sevilla"); // string
    auto habitantes = 700000;        // int
    auto temperatura = 28.5;         // double
    cout << ciudad << " -> string" << endl;
    cout << habitantes << " -> int" << endl;
    cout << temperatura << " -> double" << endl;

    /*
    CUARTA PARTE - En C++ no puedes cambiar el tipo de una variable ya declarada.
      Esto NO compila:
        int dato = 26;
        dato = "Agustín";  // error: no se puede convertir string a int
      Si necesitas otro tipo, declara otra variable o convierte (static_cast / stoi).
    */
    cout << "\n¡TIPO FIJO (a diferencia de Python)!\n" << endl;
    int dato = 26;
    cout << "Valor: " << dato << ", tipo: int" << endl;
    // dato = "Agustín"; // <- descomentar para ver el error del compilador
    string mismoConceptoComoTexto = "Agustín";
    cout << "Otra variable string: " << mismoConceptoComoTexto << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
