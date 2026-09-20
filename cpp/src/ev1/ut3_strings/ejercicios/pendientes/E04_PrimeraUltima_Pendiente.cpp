/*
OBJETIVO: Lee una cadena no vacia y muestra su primer y ultimo caracter.
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
        cout << "=== E04 Primera y ultima letra (pendiente) ===" << endl;
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
            cout << "- Comprueba primero que la cadena no este vacia (size() > 0)." << endl;
            cout << "- Usa texto[0] para el primer caracter." << endl;
            cout << "- Usa texto[texto.size() - 1] para el ultimo." << endl;

            // TODO: muestra el primer y el ultimo caracter solo si hay texto.

            cout << "Ejercicio preparado para completar." << endl;
        } else if (opcion == "2") {
            cout << "Objetivo: acceder al primer y ultimo caracter de una cadena no vacia." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
