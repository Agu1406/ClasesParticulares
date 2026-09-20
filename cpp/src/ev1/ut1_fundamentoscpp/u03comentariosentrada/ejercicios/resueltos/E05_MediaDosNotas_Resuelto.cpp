#include <iostream>
using namespace std;

/*
OBJETIVO: Leer dos notas decimales y mostrar la media.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "Nota 1: ";
    double n1;
    cin >> n1;
    cout << "Nota 2: ";
    double n2;
    cin >> n2;
    cout << "Media: " << ((n1 + n2) / 2) << endl;
    return 0;
}
