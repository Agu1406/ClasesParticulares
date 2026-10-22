/*
OBJETIVO: Leer "notas.txt" con ifstream y mostrar el contenido en consola.
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
    ofstream preparar("notas.txt");
    preparar << "Contenido de prueba" << endl;
    preparar.close();

    ifstream f("notas.txt");
    if (!f)
    {
        cout << "No se pudo abrir notas.txt" << endl;
        return;
    }

    string linea;
    while (getline(f, linea))
    {
        cout << linea << endl;
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
                cout << "Leer notas.txt con ifstream y mostrar el contenido en consola." << endl;
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
