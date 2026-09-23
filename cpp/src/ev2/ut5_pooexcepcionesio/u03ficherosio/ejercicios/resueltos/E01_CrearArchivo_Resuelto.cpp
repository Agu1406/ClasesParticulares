/*
OBJETIVO: Crear fichero "salida.txt" con File.WriteAllText y un mensaje inicial. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/



#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <fstream>
#include <sstream>
#include <regex>
#include <stdexcept>
#include <limits>
using namespace std;



void ImprimirMenu();

void MostrarObjetivo();

void EjecutarEjercicio();

void EjecutarInteractivo();



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Crear con nombre y texto personalizados" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "Crear fichero \"salida.txt\" con File.WriteAllText y un mensaje inicial." << endl;
    }

void EjecutarEjercicio()
    {
        { ofstream _ofs("salida.txt"); _ofs << ("Archivo creado"); };
            cout << "salida.txt creado correctamente." << endl;
    }

void EjecutarInteractivo()
    {
        cout << "Nombre fichero: ";
        string? nombre = cin.get();
        cout << "Contenido: ";
        string? contenido = cin.get();
        if (!string.IsNullOrWhiteSpace(nombre))
        {
            { ofstream _ofs(nombre); _ofs << (contenido ?? ""); };
            cout << (nombre) << " creado correctamente." << endl;
        }
    }



int main()
    {
        using System.IO;

        int opcion;

        do
        {
            ImprimirMenu();
            cout << "Introduce una opcion -> ";
            cin >> opcion;

            switch (opcion)
            {
                case 1:
                    EjecutarEjercicio();
                    break;
                case 3:
                    EjecutarInteractivo();
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

            if (opcion != 0)
            {
                cout << endl;
                cout << "Pulsa ENTER para continuar..." << endl;
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cin.get();
                // clear omitido
            }
        } while (opcion != 0);
        return 0;
}
