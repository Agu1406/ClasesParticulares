/*
U04 — Introduccion a interfaces.

Una interfaz define un contrato (puede volar) que clases no emparentadas
por herencia (Pajaro, Avion) pueden cumplir. En C++ no hay keyword interface:
se modela con una clase que solo tiene metodos virtuales puros (= 0).
El nombre suele llevar prefijo I (IVolable), como en C#.

OBJETIVO:
  - Declarar IVolable (clase abstracta pura) e implementarla en varias clases.
  - Usar polimorfismo con tipo interfaz (IVolable* v = &pajaro).
  - Comparar idea de interface vs abstract class (herencia multiple de contratos).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

// "Interface" en C++: clase con solo metodos virtuales puros
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

    string GetEspecie()
    {
        return especie;
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
        cout << "Avion " << modelo << ": motores a maxima potencia. Despegue." << endl;
    }

    void Aterrizar() override
    {
        cout << "Avion " << modelo << ": tren de aterrizaje abajo. Aterrizaje." << endl;
    }

    int GetAlturaMaxima() override
    {
        return 12000;
    }

    string GetModelo()
    {
        return modelo;
    }
};

void ImprimirMenu()
{
    cout << "=== U04 Interfaces: IVolable / Pajaro / Avion ===" << endl;
    cout << "1. Flota polimorfica (vector<IVolable*>)" << endl;
    cout << "2. Comparar abstract class vs interface" << endl;
    cout << "3. Una llamada, dos comportamientos" << endl;
    cout << "0. Salir" << endl;
}

void DemoFlota()
{
    cout << "¡DEMO — Flota IVolable!\n" << endl;

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

void DemoComparacion()
{
    cout << "¡DEMO — abstract class vs interface!\n" << endl;
    cout << "  |                  | abstract class | interface (= 0) |" << endl;
    cout << "  | Estado (campos)  | Si             | No (tipico)     |" << endl;
    cout << "  | Herencia multiple| No (1 base)    | Si (varias I)   |" << endl;
    cout << "  | Constructores    | Si             | No             |" << endl;
    cout << "\nUsa abstract cuando hay estado/comportamiento comun." << endl;
    cout << "Usa interface cuando solo defines un contrato de capacidad." << endl;
}

void DemoMismaLlamada()
{
    cout << "¡DEMO — Misma llamada Despegar(), distinto cuerpo!\n" << endl;

    Pajaro pajaroObj("halcon");
    Avion avionObj("B737");

    IVolable* pajaro = &pajaroObj;
    IVolable* avion = &avionObj;

    pajaro->Despegar();
    avion->Despegar();
    cout << "\nTipo declarado: IVolable* | Tipos reales: Pajaro y Avion." << endl;
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
                DemoFlota();
                break;
            case 2:
                DemoComparacion();
                break;
            case 3:
                DemoMismaLlamada();
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
