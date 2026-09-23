/*
OBJETIVO: Ordena ciudades ignorando mayusculas con sort + lambda (tolower).
SOLUCION: sort con comparador que convierte a minusculas.

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
#include <cctype>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E08 SortIgnoreCase (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Ordena ciudades ignorando mayusculas con sort + lambda (tolower)." << endl;
}

void EjecutarEjercicio()
{
    vector<string> ciudades = {"barcelona", "Almeria", "cadiz"};
    auto aMinusculas = [](string s) {
        transform(s.begin(), s.end(), s.begin(),
                  [](unsigned char c) { return static_cast<char>(tolower(c)); });
        return s;
    };
    sort(ciudades.begin(), ciudades.end(),
         [&](const string& a, const string& b) {
             return aMinusculas(a) < aMinusculas(b);
         });
    for (size_t i = 0; i < ciudades.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << ciudades[i];
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
