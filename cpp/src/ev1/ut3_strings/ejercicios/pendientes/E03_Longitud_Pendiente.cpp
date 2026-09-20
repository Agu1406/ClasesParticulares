/*
OBJETIVO: Quita espacios (equivalente a Trim) a una cadena leida y muestra size()
          (paridad con Python E03 StripLen). Menu do-while, 0 = salir.

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
        cout << "=== E03 Trim y longitud (pendiente) ===" << endl;
        cout << "1. Intentar ejercicio" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1") {
            cout << "Escribe una cadena (puedes dejar espacios): ";
            string texto;
            getline(cin, texto);

            cout << "Instrucciones:" << endl;
            cout << "- Muestra size() del texto original." << endl;
            cout << "- Quita espacios con find_first_not_of / find_last_not_of y substr." << endl;
            cout << "- (No hay Trim() en C++17). Muestra size() del resultado." << endl;

            int longitudOriginal = 0;
            string limpio = "";
            int longitudLimpio = 0;

            // TODO: asigna longitudOriginal, limpio (sin espacios extremos) y longitudLimpio.

            cout << "Original: \"" << texto << "\" size=" << longitudOriginal << endl;
            cout << "Trim:     \"" << limpio << "\" size=" << longitudLimpio << endl;
        } else if (opcion == "2") {
            cout << "Objetivo: recortar espacios y usar size(), como strip() y len() en Python." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
