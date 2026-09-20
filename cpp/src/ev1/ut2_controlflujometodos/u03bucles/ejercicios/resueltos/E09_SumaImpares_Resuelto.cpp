/*
OBJETIVO: Suma los impares del 1 al 19 con for.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    int suma = 0;
    for (int i = 1; i <= 19; i += 2)
    {
        suma += i;
    }
    cout << suma << endl;
    return 0;
}
