/*
OBJETIVO: Clase Persona con Nombre y Edad; crea dos personas y muestralas. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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



class Persona {
public:

    string Nombre;
    int Edad;
};



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Crear persona interactiva" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        Console.WriteLine("Clase Persona con Nombre y Edad; crea dos personas y muestralas.");
    }

void EjecutarEjercicio()
    {
        Persona ana = new Persona { Nombre = "Ana", Edad = 22 };
            Persona luis = new Persona { Nombre = "Luis", Edad = 30 };
            cout << (ana.Nombre) << ", " << (ana.Edad) << " anos" << endl;
            cout << (luis.Nombre) << ", " << (luis.Edad) << " anos" << endl;
    }

void EjecutarInteractivo()
    {
        cout << "Nombre: ";
        string? nombre = cin.get();
        cout << "Edad: ";
        if (int.TryParse(string(/*TODO cin*/), out int edad))
        {
            Persona persona = new Persona { Nombre = nombre ?? "", Edad = edad };
            cout << (persona.Nombre) << ", " << (persona.Edad) << " anos" << endl;
        }
        else
        {
            cout << "Edad invalida." << endl;
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
