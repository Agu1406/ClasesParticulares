/*
OBJETIVO: Lee una cadena y reemplaza todos los espacios por guiones bajos.
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
        cout << "=== E06 Reemplazar espacios (resuelto) ===" << endl;
        cout << "1. Reemplazar por guiones bajos" << endl;
        cout << "2. Reemplazar y mostrar original" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1" || opcion == "2") {
            cout << "Escribe una cadena: ";
            string texto;
            getline(cin, texto);

            string resultado = texto;
            for (size_t i = 0; i < resultado.size(); i++) {
                if (resultado[i] == ' ') {
                    resultado[i] = '_';
                }
            }

            if (opcion == "2") {
                cout << "Original: " << texto << endl;
            }

            cout << "Resultado: " << resultado << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
