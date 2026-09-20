/*
OBJETIVO: Intercambia dos enteros con variable auxiliar y muestralos.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    int a = 7, b = 3;
    int temp = a;
    a = b;
    b = temp;
    cout << a << " " << b << endl;
    return 0;
}
