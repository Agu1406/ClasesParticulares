/*
OBJETIVO: Pasar dos vector paralelos (nombres y edades) a un map.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Convertir nombres y edades paralelas a un map." << endl;
}

void EjecutarEjercicio()
{
    vector<string> nombres = { "Ana", "Luis" };
    vector<int> edades = { 20, 25 };
    map<string, int> mapa;

    for (int i = 0; i < (int)nombres.size(); i++)
    {
        mapa[nombres[i]] = edades[i];
    }

    for (pair<string, int> par : mapa)
    {
        cout << par.first << " -> " << par.second << endl;
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
            case 2:
                MostrarObjetivo();
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
