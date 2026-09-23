/*
OBJETIVO: Mezcla herencia + dynamic_cast: vector Animal* con Perro/Gato;
  detectar Perro y mostrar la raza. SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
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
        cout << nombre << " hace un sonido generico..." << endl;
    }
};

class Perro : public Animal
{
private:
    string raza;

public:
    Perro(string nombre, string raza) : Animal(nombre)
    {
        this->raza = raza;
    }

    void HacerSonido() override
    {
        cout << nombre << " dice: ¡Guau!" << endl;
    }

    string GetRaza()
    {
        return raza;
    }
};

class Gato : public Animal
{
public:
    Gato(string nombre) : Animal(nombre)
    {
    }

    void HacerSonido() override
    {
        cout << nombre << " dice: ¡Miau!" << endl;
    }
};

void ImprimirMenu()
{
    cout << "=== E09 Herencia + is/as (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "vector<Animal*> con Perro y Gato." << endl;
    cout << "Recorre: HacerSonido() en todos." << endl;
    cout << "Si dynamic_cast<Perro*>(a) != nullptr, muestra la raza." << endl;
}

void EjecutarEjercicio()
{
    Perro p1("Rex", "Pastor aleman");
    Gato g1("Michi");
    Perro p2("Luna", "Labrador");

    vector<Animal*> animales = { &p1, &g1, &p2 };

    for (Animal* a : animales)
    {
        a->HacerSonido();

        Perro* p = dynamic_cast<Perro*>(a);
        if (p != nullptr)
        {
            cout << "  -> Es un Perro de raza " << p->GetRaza() << endl;
        }
        else if (dynamic_cast<Gato*>(a) != nullptr)
        {
            cout << "  -> Es un Gato" << endl;
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
