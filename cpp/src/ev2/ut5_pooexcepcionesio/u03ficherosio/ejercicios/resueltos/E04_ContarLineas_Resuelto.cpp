/*
OBJETIVO: Contar lineas de "datos.txt" con ifstream y getline.
SOLUCION: ver codigo.

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
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    ofstream preparar("datos.txt");
    preparar << "a" << endl;
    preparar << "b" << endl;
    preparar << "c" << endl;
    preparar << "d" << endl;
    preparar.close();

    ifstream f("datos.txt");
    if (!f)
    {
        cout << "No se pudo abrir datos.txt" << endl;
        return;
    }

    string linea;
    int total = 0;
    while (getline(f, linea))
    {
        total++;
    }
    cout << "Lineas: " << total << endl;
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
                cout << "Contar lineas de datos.txt con ifstream y getline." << endl;
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
