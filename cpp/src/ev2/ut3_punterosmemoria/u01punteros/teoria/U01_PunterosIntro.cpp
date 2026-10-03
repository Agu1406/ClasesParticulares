/*
U01 — Punteros: & y *.

OBJETIVO:
  - int* p guarda una DIRECCION, no el int.
  - &i obtiene la direccion de i.
  - *p lee o escribe el dato apuntado.
  - nullptr (o 0) = no apunta a nada valido.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U01 Punteros ===" << endl;
    cout << "1. & y *" << endl;
    cout << "2. Dos punteros, misma variable" << endl;
    cout << "3. Comparar punteros" << endl;
    cout << "0. Salir" << endl;
}

void DemoAmpersand()
{
    cout << "¡DEMO — & y *!\n" << endl;
    int i = 5;
    int* punt = nullptr;
    punt = &i;
    cout << "*punt = " << *punt << endl;
    *punt = 10;
    cout << "i = " << i << " (cambio por el puntero)" << endl;
}

void DemoCompartir()
{
    cout << "¡DEMO — Compartir!\n" << endl;
    int x = 5;
    int* p1 = nullptr;
    int* p2 = &x;
    p1 = p2;
    *p1 = 8;
    cout << "x = " << x << " (p1 y p2 apuntan a x)" << endl;
}

void DemoComparar()
{
    cout << "¡DEMO — == nullptr!\n" << endl;
    int i = 1;
    int* p = &i;
    if (p != nullptr)
    {
        cout << "Puntero no nulo." << endl;
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
                DemoAmpersand();
                break;
            case 2:
                DemoCompartir();
                break;
            case 3:
                DemoComparar();
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
