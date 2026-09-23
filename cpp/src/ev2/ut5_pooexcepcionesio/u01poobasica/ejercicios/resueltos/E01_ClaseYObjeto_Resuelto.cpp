/*
OBJETIVO: Clase Coche con Marca y Modelo; crea un objeto y muestra sus datos. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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



class Coche {
public:

    string Marca;
    string Modelo;
};



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Crear coche interactivo" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        Console.WriteLine("Clase Coche con Marca y Modelo; crea un objeto y muestra sus datos.");
    }

void EjecutarEjercicio()
    {
        Coche coche;
            coche.Marca = "Toyota";
            coche.Modelo = "Corolla";
            cout << (coche.Marca) << " " << (coche.Modelo) << endl;
    }

void EjecutarInteractivo()
    {
        cout << "Marca: ";
        string? marca = cin.get();
        cout << "Modelo: ";
        string? modelo = cin.get();
        Coche coche = new Coche { Marca = marca ?? "", Modelo = modelo ?? "" };
        cout << (coche.Marca) << " " << (coche.Modelo) << endl;
    }



int main()
    {
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
