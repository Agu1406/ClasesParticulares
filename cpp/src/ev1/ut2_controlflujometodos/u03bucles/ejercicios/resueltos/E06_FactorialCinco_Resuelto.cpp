/*
OBJETIVO: Calcula 5! (1*2*3*4*5) con un bucle for.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    int fact = 1;
    for (int i = 1; i <= 5; i++)
    {
        fact *= i;
    }
    cout << fact << endl;
    return 0;
}
