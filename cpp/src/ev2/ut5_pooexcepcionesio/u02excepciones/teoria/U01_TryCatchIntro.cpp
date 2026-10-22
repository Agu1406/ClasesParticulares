/*
U01 — try/catch basico.

Si algo puede fallar (stoi con texto raro, at() fuera de rango), se pone
en try. catch captura la excepcion y el programa no se cierra.

En C++: stoi lanza invalid_argument. vector.at lanza out_of_range.
El mensaje se lee con e.what() (no .Message). operator[] NO lanza.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <stdexcept>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U01 try/catch basico ===" << endl;
    cout << "1. Parse invalido (stoi)" << endl;
    cout << "2. Parse valido" << endl;
    cout << "3. Indice fuera de rango (at)" << endl;
    cout << "0. Salir" << endl;
}

void DemoParseInvalido()
{
    cout << "¡DEMO — try/catch con parse invalido!\n" << endl;

    try
    {
        int numero = stoi("abc");
        cout << "Numero convertido: " << numero << endl;
    }
    catch (const exception& e)
    {
        cout << "Error capturado: " << e.what() << endl;
    }

    cout << "El programa sigue ejecutandose tras el catch." << endl;
}

void DemoParseValido()
{
    cout << "¡DEMO — try/catch con parse valido!\n" << endl;

    try
    {
        int edad = stoi("25");
        cout << "Edad leida correctamente: " << edad << endl;
    }
    catch (const exception& e)
    {
        cout << "Error capturado: " << e.what() << endl;
    }
}

void DemoArrayIndice()
{
    cout << "¡DEMO — try/catch con at()!\n" << endl;

    try
    {
        vector<int> valores = { 10, 20, 30 };
        cout << valores.at(5) << endl;
    }
    catch (const exception& e)
    {
        cout << "Error capturado: " << e.what() << endl;
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
                DemoParseInvalido();
                break;
            case 2:
                DemoParseValido();
                break;
            case 3:
                DemoArrayIndice();
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
