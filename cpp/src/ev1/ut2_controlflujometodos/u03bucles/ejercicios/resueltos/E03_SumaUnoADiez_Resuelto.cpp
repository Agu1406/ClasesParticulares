/*
OBJETIVO: For: suma los enteros del 1 al 10 y muestra el total.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    int total = 0;
    for (int i = 1; i <= 10; i++)
    {
        total += i;
    }
    cout << total << endl;
    return 0;
}
