/*
OBJETIVO: Lee una cadena no vacia y muestra su primer y ultimo caracter.
SOLUCION: ver codigo. Se presenta con menu do-while y opcion 0 para salir.

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
        cout << "=== E04 Primera y ultima letra (resuelto) ===" << endl;
        cout << "1. Mostrar extremos" << endl;
        cout << "2. Mostrar extremos y longitud" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1" || opcion == "2") {
            cout << "Escribe una cadena: ";
            string texto;
            getline(cin, texto);

            if (texto.size() > 0) {
                cout << "Primero: " << texto[0] << endl;
                cout << "Ultimo: " << texto[texto.size() - 1] << endl;

                if (opcion == "2") {
                    cout << "Longitud: " << texto.size() << endl;
                }
            } else {
                cout << "La cadena esta vacia." << endl;
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
