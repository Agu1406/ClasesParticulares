/*
OBJETIVO: Array/vector de Figura con Circulo y Rectangulo; recorrer y sumar areas.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <iomanip>
using namespace std;

class Figura
{
public:
    virtual ~Figura() {}
    virtual double CalcularArea() = 0;
    virtual string GetNombre() = 0;
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

    double CalcularArea() override
    {
        return acos(-1.0) * radio * radio;
    }

    string GetNombre() override
    {
        return "Circulo";
    }
};

class Rectangulo : public Figura
{
private:
    double baseFigura;
    double altura;

public:
    Rectangulo(double baseFigura, double altura)
    {
        this->baseFigura = baseFigura;
        this->altura = altura;
    }

    double CalcularArea() override
    {
        return baseFigura * altura;
    }

    string GetNombre() override
    {
        return "Rectangulo";
    }
};

void ImprimirMenu()
{
    cout << "=== E04 Polimorfismo array de Figura (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
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
    Circulo c1(2.5);
    Rectangulo r1(3, 4);
    Circulo c2(1.0);
    Rectangulo r2(2, 5);

    vector<Figura*> figuras = { &c1, &r1, &c2, &r2 };

    double suma = 0;
    cout << fixed << setprecision(2);
    for (Figura* f : figuras)
    {
        double area = f->CalcularArea();
        cout << f->GetNombre() << ": area = " << area << endl;
        suma += area;
    }
    cout << "Suma de areas: " << suma << endl;
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
