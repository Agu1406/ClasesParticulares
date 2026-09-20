#include <iostream>
using namespace std;

/*
OBJETIVO: Leer base y altura; calcular area del rectangulo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

int main() {
    cout << "Base: ";
    double baseRect;
    cin >> baseRect;
    cout << "Altura: ";
    double altura;
    cin >> altura;
    cout << "Area: " << (baseRect * altura) << endl;
    return 0;
}
