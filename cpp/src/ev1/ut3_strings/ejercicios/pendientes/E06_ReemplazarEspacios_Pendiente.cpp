/*
OBJETIVO: Lee una cadena y reemplaza todos los espacios por guiones bajos.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

int main() {
    string opcion;

    do {
        cout << "=== E06 Reemplazar espacios (pendiente) ===" << endl;
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
            cout << "- Recorre el string y cambia cada ' ' por '_'." << endl;
            cout << "- (No hay Replace de C#; el string en C++ se modifica in-place)." << endl;
            cout << "- Guarda el resultado en otra variable si quieres conservar el original." << endl;

            string resultado = "";

            // TODO: reemplaza los espacios del texto por guiones bajos.

            cout << "Resultado: " << resultado << endl;
        } else if (opcion == "2") {
            cout << "Objetivo: sustituir espacios por guiones bajos recorriendo el string." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
