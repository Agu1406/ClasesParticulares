/*
OBJETIVO: Lee una cadena y un caracter; cuenta cuantas veces aparece esa letra.
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
        cout << "=== E07 Contar letra (pendiente) ===" << endl;
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
            cout << "Letra a contar: ";
            string entrada;
            getline(cin, entrada);

            cout << "Instrucciones:" << endl;
            cout << "- Toma la primera posicion de la entrada si existe (entrada[0])." << endl;
            cout << "- Recorre el texto letra a letra con for y size()." << endl;
            cout << "- Suma 1 cada vez que coincidan." << endl;

            char letra = ' ';
            int contador = 0;

            // TODO: inicializa la letra y cuenta cuantas veces aparece.

            cout << "Aparece " << contador << " veces." << endl;
        } else if (opcion == "2") {
            cout << "Objetivo: contar cuantas veces aparece una letra en un texto." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
