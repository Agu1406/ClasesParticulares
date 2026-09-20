/*
OBJETIVO: Lee una cadena y muestrala en mayusculas y en minusculas.
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

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
        cout << "=== E02 Mayusculas y minusculas (resuelto) ===" << endl;
        cout << "1. Convertir texto" << endl;
        cout << "2. Convertir y mostrar longitud" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1" || opcion == "2") {
            cout << "Escribe una cadena: ";
            string texto;
            getline(cin, texto);

            string mayusculas = texto;
            string minusculas = texto;
            for (size_t i = 0; i < mayusculas.size(); i++) {
                mayusculas[i] = toupper(mayusculas[i]);
            }
            for (size_t i = 0; i < minusculas.size(); i++) {
                minusculas[i] = tolower(minusculas[i]);
            }

            cout << "Mayusculas: " << mayusculas << endl;
            cout << "Minusculas: " << minusculas << endl;

            if (opcion == "2") {
                cout << "Longitud: " << texto.size() << endl;
            }
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
