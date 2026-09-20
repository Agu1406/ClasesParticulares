/*
OBJETIVO: Lee una cadena y muestrala en mayusculas y en minusculas.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main() {
    string opcion;

    do {
        cout << "=== E02 Mayusculas y minusculas (pendiente) ===" << endl;
        cout << "1. Intentar ejercicio" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1") {
            cout << "Escribe una cadena: ";
            string texto;
            getline(cin, texto);

            cout << "Instrucciones:" << endl;
            cout << "- Copia el texto a otras dos cadenas." << endl;
            cout << "- Recorre con for y usa toupper() para mayusculas." << endl;
            cout << "- Recorre con for y usa tolower() para minusculas." << endl;
            cout << "- No hay ToUpper()/ToLower() en C++17; no uses arrays extra." << endl;

            string mayusculas = "";
            string minusculas = "";

            // TODO: asigna a las variables el texto convertido con bucles.

            cout << "Mayusculas: " << mayusculas << endl;
            cout << "Minusculas: " << minusculas << endl;
        } else if (opcion == "2") {
            cout << "Objetivo: practicar toupper() y tolower() con una cadena leida por teclado." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
