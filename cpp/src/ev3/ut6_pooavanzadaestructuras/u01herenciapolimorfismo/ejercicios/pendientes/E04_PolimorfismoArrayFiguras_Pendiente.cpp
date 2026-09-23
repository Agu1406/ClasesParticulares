/*
OBJETIVO: Array/vector de Figura con Circulo y Rectangulo; recorrer y sumar areas.
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E04 Polimorfismo array de Figura ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Figura abstracta; Circulo y Rectangulo concretas." << endl;
    cout << "Guarda varias en vector<Figura*>; recorre e imprime cada area; suma el total." << endl;
}

void EjecutarEjercicio()
{
    // TODO: Vector de Figura* con circulos y rectangulos; imprimir areas y suma.
}

// TODO: Figura, Circulo, Rectangulo.

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
            case 2:
                MostrarObjetivo();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida. Intenta de nuevo." << endl;
                break;
        }

        cout << endl;
    } while (opcion != 0);

    return 0;
}
