/*
OBJETIVO: Mini-repaso integrado: menu con 2-3 demos de jerarquia
  (herencia animales, figuras, volables). SOLUCION: ver codigo.

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

class Animal
{
protected:
    string nombre;

public:
    Animal(string nombre)
    {
        this->nombre = nombre;
    }

    virtual ~Animal() {}

    virtual void HacerSonido()
    {
        cout << nombre << "..." << endl;
    }
};

class Perro : public Animal
{
public:
    Perro(string nombre) : Animal(nombre) {}

    void HacerSonido() override
    {
        cout << nombre << " dice: ¡Guau!" << endl;
    }
};

class Gato : public Animal
{
public:
    Gato(string nombre) : Animal(nombre) {}

    void HacerSonido() override
    {
        cout << nombre << " dice: ¡Miau!" << endl;
    }
};

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
    double b;
    double h;

public:
    Rectangulo(double b, double h)
    {
        this->b = b;
        this->h = h;
    }

    double CalcularArea() override
    {
        return b * h;
    }

    string GetNombre() override
    {
        return "Rectangulo";
    }
};

class IVolable
{
public:
    virtual ~IVolable() {}
    virtual void Despegar() = 0;
    virtual void Aterrizar() = 0;
};

class Pajaro : public IVolable
{
private:
    string especie;

public:
    Pajaro(string especie)
    {
        this->especie = especie;
    }

    void Despegar() override
    {
        cout << especie << " despega." << endl;
    }

    void Aterrizar() override
    {
        cout << especie << " aterriza." << endl;
    }
};

class Avion : public IVolable
{
private:
    string modelo;

public:
    Avion(string modelo)
    {
        this->modelo = modelo;
    }

    void Despegar() override
    {
        cout << "Avion " << modelo << " despega." << endl;
    }

    void Aterrizar() override
    {
        cout << "Avion " << modelo << " aterriza." << endl;
    }
};

void ImprimirMenu()
{
    cout << "=== E10 Mini-repaso integrado (resuelto) ===" << endl;
    cout << "1. Demo animales (herencia)" << endl;
    cout << "2. Demo figuras (polimorfismo)" << endl;
    cout << "3. Demo volables (interfaces)" << endl;
    cout << "4. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Integra tres demos en el mismo archivo:" << endl;
    cout << "  A) Animal/Perro/Gato + HacerSonido" << endl;
    cout << "  B) vector<Figura*> + CalcularArea" << endl;
    cout << "  C) vector<IVolable*> + Despegar/Aterrizar" << endl;
}

void DemoAnimales()
{
    cout << "--- Animales ---\n" << endl;
    Perro perro("Rex");
    Gato gato("Michi");
    vector<Animal*> animales = { &perro, &gato };
    for (Animal* a : animales)
    {
        a->HacerSonido();
    }
}

void DemoFiguras()
{
    cout << "--- Figuras ---\n" << endl;
    Circulo c(2);
    Rectangulo r(3, 4);
    vector<Figura*> figuras = { &c, &r };
    cout << fixed << setprecision(2);
    for (Figura* f : figuras)
    {
        cout << f->GetNombre() << ": " << f->CalcularArea() << endl;
    }
}

void DemoVolables()
{
    cout << "--- Volables ---\n" << endl;
    Pajaro pajaro("halcon");
    Avion avion("A320");
    vector<IVolable*> flota = { &pajaro, &avion };
    for (IVolable* v : flota)
    {
        v->Despegar();
        v->Aterrizar();
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
                DemoAnimales();
                break;
            case 2:
                DemoFiguras();
                break;
            case 3:
                DemoVolables();
                break;
            case 4:
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
