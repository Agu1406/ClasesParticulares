/*
OBJETIVO: Segunda implementacion Avion de IVolable; vector IVolable* con ambos.
  Menu do-while.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E08 Interfaz flota Pajaro/Avion ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
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
    // TODO: vector<IVolable*> con Pajaro y Avion; recorrer la flota.
}

// TODO: IVolable, Pajaro, Avion.

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
