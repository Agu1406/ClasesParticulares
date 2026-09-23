/*
OBJETIVO: Clase abstracta Figura con CalcularArea; Circulo implementa el area.
  Menu do-while: completar desde un menu interactivo con opcion 0 para salir.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <cmath>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E03 Polimorfismo Circulo ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "class Figura con CalcularArea() = 0 (abstracto)." << endl;
    cout << "Circulo : public Figura con radio; area = PI * r * r." << endl;
    cout << "Crea un Circulo y muestra su area." << endl;
}

void EjecutarEjercicio()
{
    // TODO: Crear Circulo y mostrar CalcularArea().
}

// TODO: class Figura { virtual double CalcularArea() = 0; };
// TODO: class Circulo : public Figura;

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
