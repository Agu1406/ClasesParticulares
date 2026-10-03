/*
U05 — Excepcion como objeto (PDF POO + Intro).

OBJETIVO:
  - class Error { what(); }; throw Error("...");
  - catch (Error& e) por referencia (no copiar).
  - vector.at(i) lanza out_of_range (PDF Intro).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <stdexcept>
using namespace std;

class Error
{
    string mensaje;
public:
    Error(const string& m) : mensaje(m) {}
    const string& what() const { return mensaje; }
};

void ImprimirMenu()
{
    cout << "=== U05 Excepcion objeto ===" << endl;
    cout << "1. throw Error" << endl;
    cout << "2. vector.at fuera de rango" << endl;
    cout << "0. Salir" << endl;
}

void DemoError()
{
    cout << "¡DEMO — Error!\n" << endl;
    try
    {
        throw Error("Empty vector exception");
    }
    catch (Error& e)
    {
        cout << e.what() << endl;
    }
}

void DemoAt()
{
    cout << "¡DEMO — at()!\n" << endl;
    try
    {
        vector<int> v(5);
        cout << v.at(10) << endl;
    }
    catch (const exception& e)
    {
        cout << e.what() << endl;
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
                DemoError();
                break;
            case 2:
                DemoAt();
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
