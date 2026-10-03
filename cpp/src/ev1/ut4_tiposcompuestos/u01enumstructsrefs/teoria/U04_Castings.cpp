/*
U04 — Conversiones (castings) del PDF.

OBJETIVO:
  - Casting ascendente: se hace solo (short a int, int a double).
  - Casting descendente: puede perder datos. Sintaxis tipo(expr).
  - 5/9 es division entera (0). Usar 5.0/9.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U04 Castings ===" << endl;
    cout << "1. Ascendente (automatico)" << endl;
    cout << "2. Descendente (explicito)" << endl;
    cout << "3. Fahrenheit a Celsius" << endl;
    cout << "0. Salir" << endl;
}

void DemoAscendente()
{
    cout << "¡DEMO — Ascendente!\n" << endl;
    short i = 3;
    int j = 2;
    double a = 1.5;
    double b = a + i * j;
    cout << "1.5 + 3 * 2 = " << b << endl;
}

void DemoDescendente()
{
    cout << "¡DEMO — Descendente!\n" << endl;
    int a = 3;
    int b = 2;
    cout << "3 / 2 (int) = " << (a / b) << endl;
    cout << "double(3) / 2 = " << (double(a) / b) << endl;
}

void DemoFahrenheit()
{
    cout << "¡DEMO — Formula!\n" << endl;
    double f = 212;
    cout << "(5/9)*(f-32)   = " << ((5 / 9) * (f - 32)) << "  (siempre 0)" << endl;
    cout << "(5.0/9)*(f-32) = " << ((5.0 / 9) * (f - 32)) << endl;
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
                DemoAscendente();
                break;
            case 2:
                DemoDescendente();
                break;
            case 3:
                DemoFahrenheit();
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
