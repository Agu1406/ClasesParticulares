/*
U04 — Paso en C (puntero) vs C++ (referencia).

OBJETIVO:
  - En C no hay int&. Se pasa int* y se llama con &c.
  - En C++: void cuadrado(int& num); se llama cuadrado(c);
  - SDL esta en C: sus funciones piden punteros (por eso &rect).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void CuadradoC(int* num)
{
    *num = (*num) * (*num);
}

void CuadradoCpp(int& num)
{
    num = num * num;
}

void ImprimirMenu()
{
    cout << "=== U04 C vs C++ ===" << endl;
    cout << "1. Estilo C (int*)" << endl;
    cout << "2. Estilo C++ (int&)" << endl;
    cout << "0. Salir" << endl;
}

void DemoC()
{
    cout << "¡DEMO — C!\n" << endl;
    int c = 13;
    CuadradoC(&c);
    cout << c << endl;
}

void DemoCpp()
{
    cout << "¡DEMO — C++!\n" << endl;
    int c = 13;
    CuadradoCpp(c);
    cout << c << endl;
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
                DemoC();
                break;
            case 2:
                DemoCpp();
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
