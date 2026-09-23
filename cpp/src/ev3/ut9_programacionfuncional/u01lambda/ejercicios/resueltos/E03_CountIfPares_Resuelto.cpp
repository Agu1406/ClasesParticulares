/*
OBJETIVO: Cuenta cuantos numeros pares hay con count_if y lambda.
SOLUCION: count_if(..., [](int n){ return n % 2 == 0; }).

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
    cout << "=== E03 CountIfPares (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Cuenta cuantos numeros pares hay con count_if y lambda." << endl;
}

void EjecutarEjercicio()
{
    vector<int> numeros = {1, 3, 5, 7, 9, 2, 4, 6, 8};
    int pares = count_if(numeros.begin(), numeros.end(),
                         [](int n) { return n % 2 == 0; });
    cout << pares << endl;
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
