/*
U01 — Enumerados.

OBJETIVO:
  - Declarar enum Nombre { Valor1, Valor2 };
  - Guardar un valor del enumerado en una variable.
  - Comparar con if / switch (el PDF: switch solo con enteros o char).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

enum Color { Rojo, Verde, Azul };

void ImprimirMenu()
{
    cout << "=== U01 Enum ===" << endl;
    cout << "1. Crear y comparar" << endl;
    cout << "2. switch con enum" << endl;
    cout << "0. Salir" << endl;
}

void DemoCrear()
{
    cout << "¡DEMO — Crear y comparar!\n" << endl;
    Color c = Verde;
    if (c == Verde)
    {
        cout << "El color es Verde." << endl;
    }
}

void DemoSwitch()
{
    cout << "¡DEMO — switch!\n" << endl;
    Color c = Azul;
    switch (c)
    {
        case Rojo:
            cout << "Rojo" << endl;
            break;
        case Verde:
            cout << "Verde" << endl;
            break;
        case Azul:
            cout << "Azul" << endl;
            break;
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
                DemoCrear();
                break;
            case 2:
                DemoSwitch();
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
