/*
OBJETIVO: Lee una cadena por teclado y cuenta cuantas vocales (a, e, i, o, u) contiene.
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
        cout << "=== E01 Contar vocales (resuelto) ===" << endl;
        cout << "1. Contar vocales" << endl;
        cout << "2. Contar vocales ignorando espacios" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1" || opcion == "2") {
            cout << "Escribe una cadena: ";
            string texto;
            getline(cin, texto);
            int contador = 0;

            for (size_t i = 0; i < texto.size(); i++) {
                char letra = tolower(texto[i]);

                if (opcion == "2" && letra == ' ') {
                    continue;
                }

                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    contador++;
                }
            }

            cout << "Vocales encontradas: " << contador << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
