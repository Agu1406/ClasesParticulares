/*
OBJETIVO: Edad=65; si >=60 muestra Descuento, si no Precio normal.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    int edad = 65;
    if (edad >= 60)
    {
        cout << "Descuento" << endl;
    }
    else
    {
        cout << "Precio normal" << endl;
    }
    return 0;
}
