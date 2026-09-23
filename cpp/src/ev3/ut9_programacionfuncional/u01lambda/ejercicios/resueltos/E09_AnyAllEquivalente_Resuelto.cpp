/*
OBJETIVO: Usa any_of y all_of con lambdas (equivalente a Any / All de LINQ).
SOLUCION: any_of (hay par) y all_of (todos positivos).

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
    cout << "=== E09 AnyAllEquivalente (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Usa any_of y all_of con lambdas." << endl;
    cout << "any_of: ¿hay algun par?  all_of: ¿todos positivos?" << endl;
}

void EjecutarEjercicio()
{
    vector<int> numeros = {1, 3, 5, 8};
    bool hayPar = any_of(numeros.begin(), numeros.end(),
                         [](int n) { return n % 2 == 0; });
    bool todosPositivos = all_of(numeros.begin(), numeros.end(),
                                 [](int n) { return n > 0; });
    cout << boolalpha;
    cout << "any_of pares: " << hayPar << endl;
    cout << "all_of positivos: " << todosPositivos << endl;
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
