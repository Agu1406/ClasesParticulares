#include <iostream>
using namespace std;

/*
OBJETIVO: Convertir un double a int mediante static_cast.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    double valor = 9.75;
    int entero = static_cast<int>(valor);
    cout << "Double: " << valor << endl;
    cout << "Entero: " << entero << endl;
    return 0;
}
