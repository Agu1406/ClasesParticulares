/*
OBJETIVO: Copiar contenido de "origen.txt" a "destino.txt".
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
    ofstream preparar("origen.txt");
    preparar << "Texto a copiar" << endl;
    preparar.close();

    ifstream origen("origen.txt");
    if (!origen)
    {
        cout << "No se pudo abrir origen.txt" << endl;
        return;
    }

    ofstream destino("destino.txt");
    string linea;
    while (getline(origen, linea))
    {
        destino << linea << endl;
    }
    cout << "Copia realizada." << endl;
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
                cout << "Copiar contenido de origen.txt a destino.txt." << endl;
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
