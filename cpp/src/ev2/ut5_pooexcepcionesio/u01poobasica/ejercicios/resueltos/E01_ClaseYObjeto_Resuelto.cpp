/*
OBJETIVO: Clase Coche con atributos marca y modelo; crea un objeto y muestra sus datos.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class Coche
{
private:
    string marca;
    string modelo;

public:
    void SetMarca(string m)
    {
        marca = m;
    }

    void SetModelo(string m)
    {
        modelo = m;
    }

    string GetMarca() const
    {
        return marca;
    }

    string GetModelo() const
    {
        return modelo;
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
    Coche coche;
    coche.SetMarca("Toyota");
    coche.SetModelo("Corolla");
    cout << coche.GetMarca() << " " << coche.GetModelo() << endl;
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
                cout << "Clase Coche con atributos marca y modelo; crea un objeto y muestra sus datos." << endl;
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
