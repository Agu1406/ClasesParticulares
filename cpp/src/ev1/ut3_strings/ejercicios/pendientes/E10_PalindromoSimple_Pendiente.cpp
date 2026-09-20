/*
OBJETIVO: Lee una palabra y comprueba si es palindromo ignorando mayusculas y minusculas.
Este ejercicio ahora se ejecuta desde un menu do-while con opcion 0 para salir.

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
        cout << "=== E10 Palindromo simple (pendiente) ===" << endl;
        cout << "1. Intentar ejercicio" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
        cout << "Elige una opcion: ";
        getline(cin, opcion);
        cout << endl;

        if (opcion == "1") {
            cout << "Escribe una palabra: ";
            string palabra;
            getline(cin, palabra);

            cout << "Instrucciones:" << endl;
            cout << "- Convierte la palabra a minusculas con un bucle y tolower." << endl;
            cout << "- Compara indices (inicio y final) o invierte con un bucle." << endl;
            cout << "- No uses arrays auxiliares." << endl;

            string normalizada = palabra;
            bool esPalindromo = false;

            // TODO: pasa a minusculas y compara indices (o una invertida hecha con bucle).

            cout << boolalpha;
            cout << "Es palindromo: " << esPalindromo << endl;
        } else if (opcion == "2") {
            cout << "Objetivo: comprobar si una palabra se lee igual al derecho y al reves." << endl;
        } else if (opcion == "0") {
            cout << "Saliendo del ejercicio." << endl;
        } else {
            cout << "Opcion no valida." << endl;
        }

        cout << endl;
    } while (opcion != "0");

    return 0;
}
