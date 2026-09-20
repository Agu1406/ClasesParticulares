/*
OBJETIVO: Entero opcion 1-3 con cadena if-else if; muestra la opcion elegida.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

int main() {
    int opcion = 2;
    if (opcion == 1)
    {
        cout << "Nuevo" << endl;
    }
    else if (opcion == 2)
    {
        cout << "Abrir" << endl;
    }
    else if (opcion == 3)
    {
        cout << "Salir" << endl;
    }
    else
    {
        cout << "Invalida" << endl;
    }
    return 0;
}
