/*
OBJETIVO: Repaso: leer "alumnos.txt" y mostrar cada nombre.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    ofstream preparar("alumnos.txt");
    preparar << "Ana" << endl;
    preparar << "Luis" << endl;
    preparar << "Sara" << endl;

    // TODO: abre alumnos.txt con ifstream
    // TODO: while (getline(f, nombre)) y muestra cada nombre
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
                cout << "Repaso: leer alumnos.txt y mostrar cada nombre." << endl;
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
