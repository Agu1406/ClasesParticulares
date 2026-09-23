/*
OBJETIVO: Repaso: List<Persona> con varias personas; recorrer y mostrar. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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

    string Nombre { get; };
    int Edad { get; }

    Persona(string nombre, int edad)
    {
        Nombre = nombre;
        Edad = edad;
    }
}



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Anadir persona interactiva" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        Console.WriteLine("Repaso: vector<Persona> con varias personas; recorrer y mostrar.");
    }

void EjecutarEjercicio()
    {
        vector<Persona> personas = new vector<Persona>
            {
                new Persona("Ana", 20),
                new Persona("Luis", 25),
                new Persona("Sara", 22)
            };

            for (Persona p : personas)
            {
                cout << (p.Nombre) << ", " << (p.Edad) << " anos" << endl;
            }
    }

void EjecutarInteractivo()
    {
        vector<Persona> personas = vector<Persona>();
        cout << "Nombre: ";
        string? nombre = cin.get();
        cout << "Edad: ";
        if (int.TryParse(string(/*TODO cin*/), out int edad))
        {
            personas[new Persona(nombre ?? ""] = edad);
            for (Persona p : personas)
            {
                cout << (p.Nombre) << ", " << (p.Edad) << " anos" << endl;
            }
        }
        else
        {
            cout << "Edad invalida." << endl;
        }
    }



int main()
    {
        using System.Collections.Generic;

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
