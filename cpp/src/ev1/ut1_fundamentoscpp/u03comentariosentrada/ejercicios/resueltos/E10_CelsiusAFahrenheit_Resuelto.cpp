#include <iostream>
using namespace std;

/*
OBJETIVO: Leer grados Celsius y convertir a Fahrenheit (F = C * 9/5 + 32).
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "Grados Celsius: ";
    double c;
    cin >> c;
    double f = c * 9 / 5 + 32;
    cout << "Fahrenheit: " << f << endl;
    return 0;
}
