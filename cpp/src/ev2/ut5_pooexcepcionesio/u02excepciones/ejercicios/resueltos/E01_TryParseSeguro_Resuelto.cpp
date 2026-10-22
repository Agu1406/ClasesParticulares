/*
E01 — Parse seguro (stoi + try/catch).

Si stoi falla muestra un mensaje; si ok muestra el numero.
En C++ no existe TryParse: se usa try { n = stoi(texto); } catch.

RESUELTO.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <stdexcept>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E01 Parse seguro ===" << endl;
    cout << "1. Ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    cout << "Introduce un entero: ";
    string texto;
    cin >> texto;

    try
    {
        int numero = stoi(texto);
        cout << "Numero valido: " << numero << endl;
    }
    catch (const exception&)
    {
        cout << "Entrada invalida." << endl;
    }
}

int main()
{
    int opcion;
    do
    {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        cout << endl;

        switch (opcion)
        {
            case 1:
                EjecutarEjercicio();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }

        cout << endl;
    } while (opcion != 0);
    return 0;
}
