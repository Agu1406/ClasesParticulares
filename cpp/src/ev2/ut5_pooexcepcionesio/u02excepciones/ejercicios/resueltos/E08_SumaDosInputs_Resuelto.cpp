/*
E08 — Suma de dos inputs con stoi + try/catch.

Pide dos textos, convierte con stoi y muestra la suma.
Si alguno no es entero, un solo catch muestra el error.

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
    cout << "=== E08 Suma dos inputs ===" << endl;
    cout << "1. Ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    cout << "Primer numero: ";
    string aTexto;
    cin >> aTexto;
    cout << "Segundo numero: ";
    string bTexto;
    cin >> bTexto;

    try
    {
        int a = stoi(aTexto);
        int b = stoi(bTexto);
        cout << "Suma: " << (a + b) << endl;
    }
    catch (const exception&)
    {
        cout << "Ambos valores deben ser enteros validos." << endl;
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
