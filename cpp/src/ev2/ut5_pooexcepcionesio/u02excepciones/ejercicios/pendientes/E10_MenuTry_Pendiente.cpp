/*
E10 — Menu 1=dividir 2=salir con try/catch.

El propio programa es el menu. Opcion 1 pide a y b, convierte con stoi
y divide. Si b==0 se lanza runtime_error. Opcion 2 sale.

PENDIENTE: completa los TODO.

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
    // TODO: si b == 0, throw runtime_error("No se puede dividir entre cero.");
    return 0;
}

void ImprimirMenu()
{
    cout << "=== E10 Menu dividir ===" << endl;
    cout << "1. Dividir" << endl;
    cout << "2. Salir" << endl;
}

void EjecutarDivision()
{
    cout << "a: ";
    string aTexto;
    cin >> aTexto;
    cout << "b: ";
    string bTexto;
    cin >> bTexto;

    // TODO: try { a = stoi(aTexto); b = stoi(bTexto); mostrar Dividir(a, b) }
    //       catch (const exception& e) { cout << e.what(); }
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
                EjecutarDivision();
                break;
            case 2:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }

        cout << endl;
    } while (opcion != 2);
    return 0;
}
