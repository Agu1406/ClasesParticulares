/*
OBJETIVO: Clase Persona (nombre, edad); crea DOS personas y muestralas.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class Persona
{
    string nombre;
    int edad;

public:
    Persona(string nombreInicial, int edadInicial)
    {
        nombre = nombreInicial;
        edad = edadInicial;
    }

    string getNombre() const
    {
        return nombre;
    }

    int getEdad() const
    {
        return edad;
    }

    void setNombre(string nuevoNombre)
    {
        nombre = nuevoNombre;
    }

    void setEdad(int nuevaEdad)
    {
        edad = nuevaEdad;
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
    Persona ana("Ana", 22);
    Persona luis("Luis", 30);

    cout << ana.getNombre() << ", " << ana.getEdad() << " anios" << endl;
    cout << luis.getNombre() << ", " << luis.getEdad() << " anios" << endl;
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
                cout << "Clase Persona (nombre, edad): crea dos personas y muestralas." << endl;
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
