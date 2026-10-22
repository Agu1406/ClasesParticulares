/*
OBJETIVO: Clase Circulo con radio y metodo CalcularArea(); muestra el area de r=5.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class Circulo
{
    double radio;

public:
    Circulo(double radioInicial)
    {
        radio = radioInicial;
    }

    double getRadio() const
    {
        return radio;
    }

    double CalcularArea() const
    {
        const double PI = 3.141592653589793;
        return PI * radio * radio;
    }
};

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    Circulo circulo(5);
    cout << "Area: " << circulo.CalcularArea() << endl;
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
            case 2:
                cout << "Clase Circulo con radio y metodo CalcularArea(); muestra el area de r=5." << endl;
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
