/*
E03 — Pedir entero hasta que sea valido.

Bucle + stoi + try/catch: se pide un entero hasta que la conversion funcione.

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
    cout << "=== E03 Pedir entero ===" << endl;
    cout << "1. Ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    int numero = 0;
    while (true)
    {
        cout << "Introduce un entero: ";
        string texto;
        cin >> texto;

        try
        {
            numero = stoi(texto);
            break;
        }
        catch (const exception&)
        {
            cout << "Entrada invalida, intentalo de nuevo." << endl;
        }
    }

    cout << "Has introducido: " << numero << endl;
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
