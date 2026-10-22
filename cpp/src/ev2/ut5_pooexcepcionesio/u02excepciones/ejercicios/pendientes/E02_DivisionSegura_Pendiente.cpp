/*
E02 — Division segura.

Dividir a/b con try/catch. En C++ la division entre 0 NO lanza sola:
hay que comprobar if (b == 0) y throw runtime_error.

PENDIENTE: completa los TODO.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <stdexcept>
using namespace std;

int Dividir(int a, int b)
{
    // TODO: si b == 0, throw runtime_error("No se puede dividir entre cero.");
    //       si no, return a / b;
    return 0;
}

void ImprimirMenu()
{
    cout << "=== E02 Division segura ===" << endl;
    cout << "1. Ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    int a = 10;
    int b = 0;

    // TODO: try { mostrar Dividir(a, b) }
    //       catch (const runtime_error& e) { cout << e.what(); }
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
