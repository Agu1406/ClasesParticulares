/*
OBJETIVO: Repaso integrado: clase Contacto, guardar en "contacto.txt" con try/catch.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <fstream>
#include <stdexcept>
using namespace std;

class Contacto
{
public:
    string nombre;
    string email;

    Contacto(string n, string e)
    {
        nombre = n;
        email = e;
    }

    string ToLinea() const
    {
        return nombre + ";" + email;
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
    Contacto c("Laura", "laura@mail.com");
    try
    {
        ofstream f("contacto.txt");
        if (!f)
        {
            throw runtime_error("No se pudo abrir contacto.txt");
        }
        f << c.ToLinea() << endl;
        cout << "Contacto guardado en contacto.txt" << endl;
    }
    catch (const runtime_error& e)
    {
        cout << "Error al escribir: " << e.what() << endl;
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
                cout << "Repaso integrado: clase Contacto, guardar en contacto.txt con try/catch." << endl;
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
