/*
OBJETIVO: Clase abstracta Figura con CalcularArea; Circulo implementa el area.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

class Figura
{
public:
    virtual ~Figura() {}
    virtual double CalcularArea() = 0;
};

class Circulo : public Figura
{
private:
    double radio;

public:
    Circulo(double radio)
    {
        this->radio = radio;
    }

    double GetRadio()
    {
        return radio;
    }

    double CalcularArea() override
    {
        return acos(-1.0) * radio * radio; // PI portable
    }
};

void ImprimirMenu()
{
    cout << "=== E03 Polimorfismo Circulo (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "class Figura con CalcularArea() = 0." << endl;
    cout << "Circulo : public Figura con radio; area = PI * r * r." << endl;
    cout << "Crea un Circulo y muestra su area." << endl;
}

void EjecutarEjercicio()
{
    Circulo c(2.5);
    cout << fixed << setprecision(2);
    cout << "Circulo radio=" << c.GetRadio() << " area=" << c.CalcularArea() << endl;
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
