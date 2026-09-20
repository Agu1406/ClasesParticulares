/*
OBJETIVO: Quita espacios (equivalente a Trim) a una cadena leida y muestra size()
          (paridad con Python E03 StripLen). Menu do-while, 0 = salir.
SOLUCION: ver codigo.

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
        cout << "=== E03 Trim y longitud (resuelto) ===" << endl;
        cout << "1. Trim y size() de una cadena tuya" << endl;
        cout << "2. Ejemplo fijo \"  hola  \" (como Python)" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1" || opcion == "2") {
            string texto;
            if (opcion == "2") {
                texto = "  hola  ";
                cout << "Usando ejemplo: \"" << texto << "\"" << endl;
            } else {
                cout << "Escribe una cadena (puedes dejar espacios): ";
                getline(cin, texto);
            }

            string limpio;
            size_t ini = texto.find_first_not_of(" \t");
            size_t fin = texto.find_last_not_of(" \t");
            if (ini == string::npos) {
                limpio = "";
            } else {
                limpio = texto.substr(ini, fin - ini + 1);
            }

            cout << "Original: \"" << texto << "\" size=" << texto.size() << endl;
            cout << "Trim:     \"" << limpio << "\" size=" << limpio.size() << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
