/*
OBJETIVO: Nota 8; if >=5 y anidado >=9 -> SB, >=7 -> NT, else AP; si <5 SS.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    int nota = 8;
    if (nota >= 5)
    {
        if (nota >= 9)
        {
            cout << "SB" << endl;
        }
        else if (nota >= 7)
        {
            cout << "NT" << endl;
        }
        else
        {
            cout << "AP" << endl;
        }
    }
    else
    {
        cout << "SS" << endl;
    }
    return 0;
}
