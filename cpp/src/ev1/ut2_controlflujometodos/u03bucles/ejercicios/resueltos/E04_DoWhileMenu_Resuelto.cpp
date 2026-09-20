/*
OBJETIVO: Do-while: menu numerico; repite hasta que el usuario elija 0.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    int op;
    do
    {
        cout << "Menu (0=salir): ";
        cin >> op;
        if (op != 0)
        {
            cout << "Opcion " << op << endl;
        }
    } while (op != 0);
    return 0;
}
