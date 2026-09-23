/*
OBJETIVO: Ordena nombres alfabeticamente con sort (orden natural de string).
SOLUCION: sort(nombres.begin(), nombres.end()) e imprimir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <functional>
#include <numeric>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E02 OrdenAlfabetico (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Ordena nombres alfabeticamente con sort (orden natural de string)." << endl;
}

void EjecutarEjercicio()
{
    vector<string> nombres = {"Zoe", "Ana", "Luis", "Marta"};
    sort(nombres.begin(), nombres.end());
    for (size_t i = 0; i < nombres.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << nombres[i];
    }
    cout << endl;
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
            case 2:
                MostrarObjetivo();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida. Intenta de nuevo." << endl;
                break;
        }

        cout << endl;
    } while (opcion != 0);

    return 0;
}
