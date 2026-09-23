/*
OBJETIVO: Transforma palabras en sus longitudes con transform (equivalente a map).
SOLUCION: transform a vector<int> con [](p){ return p.size(); }.

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
    cout << "=== E05 TransformLongitudes (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Transforma palabras en sus longitudes con transform (equivalente a map)." << endl;
}

void EjecutarEjercicio()
{
    vector<string> palabras = {"sol", "programacion", "pf"};
    vector<int> longitudes(palabras.size());
    transform(palabras.begin(), palabras.end(), longitudes.begin(),
              [](const string& p) { return static_cast<int>(p.size()); });
    for (size_t i = 0; i < longitudes.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << longitudes[i];
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
