/*
OBJETIVO: Lee una cadena e imprime la misma cadena invertida con un bucle.
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
        cout << "=== E09 Invertir cadena (pendiente) ===" << endl;
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
            cout << "- Recorre la cadena desde el final hasta el principio." << endl;
            cout << "- Ve concatenando cada caracter en otra variable con +=." << endl;
            cout << "- En EV1 evita arrays y punteros." << endl;

            string invertida = "";

            // TODO: construye la cadena invertida con un for descendente.

            cout << "Invertida: " << invertida << endl;
        } else if (opcion == "2") {
            cout << "Objetivo: invertir una cadena usando un bucle simple y sin arrays." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
