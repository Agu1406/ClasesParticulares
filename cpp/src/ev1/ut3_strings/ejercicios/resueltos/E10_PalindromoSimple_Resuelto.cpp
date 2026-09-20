/*
OBJETIVO: Lee una palabra y comprueba si es palindromo ignorando mayusculas y minusculas.
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
        cout << "=== E10 Palindromo simple (resuelto) ===" << endl;
        cout << "1. Comprobar palabra" << endl;
        cout << "2. Comprobar palabra y mostrar invertida" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1" || opcion == "2") {
            cout << "Escribe una palabra: ";
            string palabra;
            getline(cin, palabra);

            string normalizada = palabra;
            for (size_t i = 0; i < normalizada.size(); i++) {
                normalizada[i] = tolower(normalizada[i]);
            }

            bool esPalindromo = true;
            for (size_t i = 0; i < normalizada.size(); i++) {
                if (normalizada[i] != normalizada[normalizada.size() - 1 - i]) {
                    esPalindromo = false;
                    break;
                }
            }

            if (opcion == "2") {
                string invertida = "";
                for (int i = (int)normalizada.size() - 1; i >= 0; i--) {
                    invertida += normalizada[i];
                }
                cout << "Invertida: " << invertida << endl;
            }

            if (esPalindromo) {
                cout << "Es palindromo." << endl;
            } else {
                cout << "No es palindromo." << endl;
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
