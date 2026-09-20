#include <iostream>
#include <string>
using namespace std;

/*
OBJETIVO: Leer un nombre (cin ignora espacios extra) y saludar.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "Nombre: ";
    string nombre;
    cin >> nombre; // cin ya descarta espacios al inicio y lee una palabra
    cout << "Hola, " << nombre << "!" << endl;
    return 0;
}
