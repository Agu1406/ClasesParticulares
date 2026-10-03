/*
U02 — new y delete (un dato en el heap).

OBJETIVO:
  - tipo* p = new tipo; pide memoria al heap.
  - delete p; la marca libre. Luego p = nullptr.
  - Olvidar delete = fuga. delete dos veces = error (PDF).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U02 new / delete ===" << endl;
    cout << "1. new double y delete" << endl;
    cout << "2. Pila vs heap (idea)" << endl;
    cout << "0. Salir" << endl;
}

void DemoNew()
{
    cout << "¡DEMO — new / delete!\n" << endl;
    double a = 1.5;
    double* p1 = &a;
    double* p2 = new double;
    *p2 = *p1;
    double* p3 = new double;
    *p3 = 123.45;
    cout << *p1 << endl;
    cout << *p2 << endl;
    cout << *p3 << endl;
    delete p2;
    delete p3;
    p2 = nullptr;
    p3 = nullptr;
}

void DemoIdea()
{
    cout << "¡DEMO — Pila vs heap!\n" << endl;
    cout << "Pila:  double a = 1.5; se borra sola al salir de la funcion." << endl;
    cout << "Heap:  new double; TU haces delete. Si no, la memoria se pierde." << endl;
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
                DemoNew();
                break;
            case 2:
                DemoIdea();
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
