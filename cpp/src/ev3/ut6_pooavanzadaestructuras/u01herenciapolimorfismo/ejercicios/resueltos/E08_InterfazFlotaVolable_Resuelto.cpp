/*
OBJETIVO: Segunda implementacion Avion de IVolable; vector IVolable* con ambos.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
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
        cout << "Avion " << modelo << ": despegue." << endl;
    }

    void Aterrizar() override
    {
        cout << "Avion " << modelo << ": aterrizaje." << endl;
    }

    int GetAlturaMaxima() override
    {
        return 12000;
    }
};

void ImprimirMenu()
{
    cout << "=== E08 Interfaz flota Pajaro/Avion (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "IVolable implementado por Pajaro y Avion." << endl;
    cout << "Guarda ambos en vector<IVolable*>; recorre Despegar, altura max y Aterrizar." << endl;
}

void EjecutarEjercicio()
{
    Pajaro p1("aguila");
    Avion a1("A320");
    Pajaro p2("gorrion");

    vector<IVolable*> flota = { &p1, &a1, &p2 };

    for (IVolable* v : flota)
    {
        v->Despegar();
        cout << "  Altura max: " << v->GetAlturaMaxima() << " m" << endl;
        v->Aterrizar();
        cout << endl;
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
