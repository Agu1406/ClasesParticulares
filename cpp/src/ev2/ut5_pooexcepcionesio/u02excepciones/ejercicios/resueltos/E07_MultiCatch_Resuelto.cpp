/*
E07 — Multi catch: invalid_argument + runtime_error.

Un mismo try puede capturar formato invalido (stoi) y division entre 0
(throw runtime_error). Lo mas concreto va primero.

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

int Dividir(int a, int b)
{
    if (b == 0)
    {
        throw runtime_error("Division entre cero.");
    }
    return a / b;
}

void ImprimirMenu()
{
    cout << "=== E07 Multi catch ===" << endl;
    cout << "1. Ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void Probar(const string& entrada, int divisor)
{
    try
    {
        int numero = stoi(entrada);
        cout << Dividir(numero, divisor) << endl;
    }
    catch (const invalid_argument&)
    {
        cout << "Error de formato." << endl;
    }
    catch (const runtime_error& e)
    {
        cout << e.what() << endl;
    }
}

void EjecutarEjercicio()
{
    cout << "Caso division 0:" << endl;
    Probar("10", 0);

    cout << "Caso formato invalido:" << endl;
    Probar("abc", 2);
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
