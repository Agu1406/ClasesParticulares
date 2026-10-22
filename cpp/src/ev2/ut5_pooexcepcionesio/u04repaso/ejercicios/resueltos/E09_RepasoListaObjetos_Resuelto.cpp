/*
OBJETIVO: Repaso: vector<Persona> con varias personas; recorrer y mostrar.
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

class Persona
{
public:
    string nombre;
    int edad;

    Persona(string n, int e)
    {
        nombre = n;
        edad = e;
    }
};

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    vector<Persona> personas;
    personas.push_back(Persona("Ana", 20));
    personas.push_back(Persona("Luis", 25));
    personas.push_back(Persona("Sara", 22));

    for (Persona p : personas)
    {
        cout << p.nombre << ", " << p.edad << " anos" << endl;
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
                cout << "Repaso: vector<Persona> con varias personas; recorrer y mostrar." << endl;
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
