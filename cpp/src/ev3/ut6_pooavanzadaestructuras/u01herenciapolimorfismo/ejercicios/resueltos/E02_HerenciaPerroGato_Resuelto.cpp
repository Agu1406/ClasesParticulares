/*
OBJETIVO: Anadir Gato a la jerarquia Animal y demostrar Base(...) + dos sonidos distintos.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
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
    cout << "=== E02 Herencia Perro y Gato (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Jerarquia Animal <- Perro, Gato." << endl;
    cout << "Ambas llaman Animal(nombre) en el constructor." << endl;
    cout << "Crea un Perro y un Gato; llama a HacerSonido() en cada uno." << endl;
}

void EjecutarEjercicio()
{
    Perro perro("Rex", "Pastor aleman");
    Gato gato("Michi");

    perro.HacerSonido();
    gato.HacerSonido();
    cout << "Perro raza: " << perro.GetRaza() << endl;
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
