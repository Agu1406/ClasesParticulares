/*
OBJETIVO: Lee una cadena y un caracter; cuenta cuantas veces aparece esa letra.
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
        cout << "=== E07 Contar letra (resuelto) ===" << endl;
        cout << "1. Contar coincidencias exactas" << endl;
        cout << "2. Contar ignorando mayusculas" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1" || opcion == "2") {
            cout << "Escribe una cadena: ";
            string texto;
            getline(cin, texto);
            cout << "Letra a contar: ";
            string entrada;
            getline(cin, entrada);

            if (entrada.size() == 0) {
                cout << "Debes escribir al menos un caracter." << endl;
            } else {
                char letra = entrada[0];
                if (opcion == "2") {
                    letra = tolower(letra);
                }
                int contador = 0;

                for (size_t i = 0; i < texto.size(); i++) {
                    char actual = texto[i];
                    if (opcion == "2") {
                        actual = tolower(actual);
                    }

                    if (actual == letra) {
                        contador++;
                    }
                }

                cout << "Aparece " << contador << " veces." << endl;
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
