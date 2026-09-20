/*
OBJETIVO: Lee una cadena e imprime la misma cadena invertida con un bucle.
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
        cout << "=== E09 Invertir cadena (resuelto) ===" << endl;
        cout << "1. Invertir cadena" << endl;
        cout << "2. Invertir y comparar con original" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1" || opcion == "2") {
            cout << "Escribe una cadena: ";
            string texto;
            getline(cin, texto);
            string invertida = "";

            for (int i = (int)texto.size() - 1; i >= 0; i--) {
                invertida += texto[i];
            }

            cout << "Invertida: " << invertida << endl;

            if (opcion == "2") {
                if (texto == invertida) {
                    cout << "Coincide con la original." << endl;
                } else {
                    cout << "No coincide con la original." << endl;
                }
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
