/*
OBJETIVO: Interfaz IVolable con Despegar/Aterrizar; clase Pajaro que la implementa.
  Menu do-while.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E07 Interfaz IVolable / Pajaro ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "class IVolable { Despegar(); Aterrizar(); GetAlturaMaxima(); }  // metodos = 0" << endl;
    cout << "class Pajaro : public IVolable." << endl;
    cout << "Crea un Pajaro (o IVolable*) y llama a Despegar y Aterrizar." << endl;
}

void EjecutarEjercicio()
{
    // TODO: Crear Pajaro; Despegar y Aterrizar.
}

// TODO: class IVolable { virtual ... = 0; }; class Pajaro : public IVolable;

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
