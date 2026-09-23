/*
OBJETIVO: Copia a otro vector las palabras que NO empiezan por 'x' (ignore case).
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

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
#include <iterator>
#include <cctype>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E04 FiltrarPrefijo ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Copia a otro vector las palabras que NO empiezan por 'x' (ignore case)." << endl;
    cout << "Usa copy_if + lambda (equivalente a filter / Where)." << endl;
}

void EjecutarEjercicio()
{
    vector<string> palabras = {"xilofono", "casa", "Xeno", "sol"};
    // TODO: copy_if a otro vector; esperado: casa, sol
    // vector<string> filtradas;
    // copy_if(...);
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
