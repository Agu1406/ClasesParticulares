/*
OBJETIVO: Entero n; muestra Positivo, Negativo o Cero.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    int n = -3;
    if (n > 0)
    {
        cout << "Positivo" << endl;
    }
    else if (n < 0)
    {
        cout << "Negativo" << endl;
    }
    else
    {
        cout << "Cero" << endl;
    }
    return 0;
}
