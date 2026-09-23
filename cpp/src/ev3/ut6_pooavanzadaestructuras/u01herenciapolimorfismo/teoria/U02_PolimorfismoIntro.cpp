/*
U02 — Introduccion al polimorfismo.

Misma llamada (CalcularArea), distinto comportamiento segun el objeto real.
Tratas Circulo y Rectangulo como Figura; el runtime elige el metodo correcto.
Para bajar al tipo concreto usas dynamic_cast (equivalente a is / as en C#).

OBJETIVO:
  - Guardar subtipos en un vector de punteros a la clase base.
  - Ver enlace dinamico al llamar metodos virtuales/override.
  - Usar dynamic_cast para comprobar y convertir el tipo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <iomanip>
using namespace std;

class Figura
{
protected:
    string nombre;
    string color;

    Figura(string nombre, string color)
    {
        this->nombre = nombre;
        this->color = color;
    }

public:
    virtual ~Figura() {}

    virtual double CalcularArea() = 0;

    string GetNombre()
    {
        return nombre;
    }

    string GetColor()
    {
        return color;
    }

    virtual string ToString()
    {
        // area formateada a 2 decimales de forma sencilla
        return nombre + " (" + color + ") area=" + to_string(CalcularArea());
    }
};

class Circulo : public Figura
{
private:
    double radio;

public:
    Circulo(double radio) : Circulo(radio, "negro")
    {
    }

    Circulo(double radio, string color) : Figura("Circulo", color)
    {
        this->radio = radio;
    }

    double GetRadio()
    {
        return radio;
    }

    double CalcularArea() override
    {
        return 3.141592653589793 * radio * radio;
    }
};

class Rectangulo : public Figura
{
private:
    double baseFigura;
    double altura;

public:
    Rectangulo(double baseFigura, double altura) : Rectangulo(baseFigura, altura, "negro")
    {
    }

    Rectangulo(double baseFigura, double altura, string color) : Figura("Rectangulo", color)
    {
        this->baseFigura = baseFigura;
        this->altura = altura;
    }

    double GetBase()
    {
        return baseFigura;
    }

    double GetAltura()
    {
        return altura;
    }

    double CalcularArea() override
    {
        return baseFigura * altura;
    }
};

void ImprimirMenu()
{
    cout << "=== U02 Polimorfismo: Figura / Circulo / Rectangulo ===" << endl;
    cout << "1. Vector de Figura*" << endl;
    cout << "2. Suma de areas (enlace dinamico)" << endl;
    cout << "3. dynamic_cast (downcast seguro)" << endl;
    cout << "0. Salir" << endl;
}

/*
PRIMERA PARTE — Un vector tipado como Figura* puede guardar
  Circulo y Rectangulo: el tipo declarado es el de la base.
*/
void DemoArrayFiguras()
{
    cout << "¡DEMO — Vector de Figura*!\n" << endl;

    Circulo c1(2.5);
    Rectangulo r1(3, 4);
    Circulo c2(1.0, "rojo");
    Rectangulo r2(2, 5, "azul");

    vector<Figura*> figuras = { &c1, &r1, &c2, &r2 };

    for (Figura* f : figuras)
    {
        cout << f->ToString() << endl;
    }
}

/*
SEGUNDA PARTE — CalcularArea se resuelve en la clase real
  (Circulo o Rectangulo), no en Figura.
*/
void DemoSumaAreas()
{
    cout << "¡DEMO — Suma de areas!\n" << endl;

    Circulo c1(2.5);
    Rectangulo r1(3, 4);
    Circulo c2(1.0, "rojo");
    Rectangulo r2(2, 5, "azul");

    vector<Figura*> figuras = { &c1, &r1, &c2, &r2 };

    double suma = 0;
    cout << fixed << setprecision(2);
    for (Figura* f : figuras)
    {
        double area = f->CalcularArea();
        cout << f->GetNombre() << ": area = " << area << endl;
        suma += area;
    }
    cout << "\nSuma de areas: " << suma << endl;
}

/*
TERCERA PARTE — dynamic_cast comprueba el tipo y convierte o devuelve nullptr.
  Equivalente pedagogico a is / as en C# o instanceof + cast en Java.
*/
void DemoIsAs()
{
    cout << "¡DEMO — dynamic_cast!\n" << endl;

    Circulo c1(2.5);
    Rectangulo r1(3, 4);
    Circulo c2(1.0, "rojo");

    vector<Figura*> figuras = { &c1, &r1, &c2 };

    for (Figura* f : figuras)
    {
        Circulo* c = dynamic_cast<Circulo*>(f);
        if (c != nullptr)
        {
            cout << c->GetNombre() << " radio=" << c->GetRadio() << endl;
            continue;
        }

        Rectangulo* r = dynamic_cast<Rectangulo*>(f);
        if (r != nullptr)
        {
            cout << r->GetNombre() << " base=" << r->GetBase()
                 << " altura=" << r->GetAltura() << endl;
        }
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
                DemoArrayFiguras();
                break;
            case 2:
                DemoSumaAreas();
                break;
            case 3:
                DemoIsAs();
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
