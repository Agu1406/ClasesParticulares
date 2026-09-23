/*
OBJETIVO: Interfaz IVolable con Despegar/Aterrizar; clase Pajaro que la implementa.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class IVolable
{
public:
    virtual ~IVolable() {}
    virtual void Despegar() = 0;
    virtual void Aterrizar() = 0;
    virtual int GetAlturaMaxima() = 0;
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
        cout << especie << " bate las alas y despega." << endl;
    }

    void Aterrizar() override
    {
        cout << especie << " aterriza en una rama." << endl;
    }

    int GetAlturaMaxima() override
    {
        return 500;
    }
};

void ImprimirMenu()
{
    cout << "=== E07 Interfaz IVolable / Pajaro (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "class IVolable { Despegar(); Aterrizar(); GetAlturaMaxima(); }  // = 0" << endl;
    cout << "class Pajaro : public IVolable." << endl;
    cout << "Crea un Pajaro (o IVolable*) y llama a Despegar y Aterrizar." << endl;
}

void EjecutarEjercicio()
{
    Pajaro pajaroObj("aguila");
    IVolable* pajaro = &pajaroObj;
    pajaro->Despegar();
    cout << "Altura max: " << pajaro->GetAlturaMaxima() << " m" << endl;
    pajaro->Aterrizar();
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
