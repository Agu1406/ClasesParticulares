/*
OBJETIVO: Crear Animal (base) y Perro (subclase) con HacerSonido virtual/override.
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

    string GetNombre()
    {
        return nombre;
    }

    virtual void HacerSonido()
    {
        cout << nombre << " hace un sonido generico..." << endl;
    }
};

class Perro : public Animal
{
public:
    Perro(string nombre) : Animal(nombre)
    {
    }

    void HacerSonido() override
    {
        cout << nombre << " dice: ¡Guau!" << endl;
    }
};

void ImprimirMenu()
{
    cout << "=== E01 Herencia Animal / Perro (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Clase Animal con nombre (protected) y HacerSonido virtual." << endl;
    cout << "Subclase Perro : public Animal que hace override y dice Guau." << endl;
    cout << "Crea un Perro y llama a HacerSonido()." << endl;
}

void EjecutarEjercicio()
{
    Perro perro("Rex");
    perro.HacerSonido();
    cout << "Nombre: " << perro.GetNombre() << endl;
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
