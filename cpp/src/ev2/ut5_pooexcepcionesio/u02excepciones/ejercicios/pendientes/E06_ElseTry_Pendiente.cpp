/*
E06 — try ok vs error.

El "else" de Python (codigo solo si no lanzo) en C++ es el codigo
al FINAL del try: si stoi lanza, ese cout no se ejecuta.

PENDIENTE: completa los TODO.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <stdexcept>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E06 try ok vs error ===" << endl;
    cout << "1. Ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void ConvertirYMostrar(const string& entrada)
{
    // TODO: try { int valor = stoi(entrada);
    //             cout << "Exito: " << valor;   // solo si no lanza
    //       }
    //       catch (const exception&) { "Fallo al convertir." }
}

void EjecutarEjercicio()
{
    cout << "Caso ok:" << endl;
    ConvertirYMostrar("5");

    cout << "Caso error:" << endl;
    ConvertirYMostrar("abc");
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
