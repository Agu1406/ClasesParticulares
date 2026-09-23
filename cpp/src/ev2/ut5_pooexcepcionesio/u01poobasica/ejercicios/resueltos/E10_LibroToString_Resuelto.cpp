/*
OBJETIVO: Clase Libro con override ToString() o metodo Imprimir(); muestra datos formateados. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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



class Libro {
public:

    string Titulo { get; };
    string Autor { get; }

    Libro(string titulo, string autor)
    {
        Titulo = titulo;
        Autor = autor;
    }

    string ToString()
    {
        return $"Libro: {Titulo} ({Autor})";
    }
}



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Crear libro interactivo" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "Clase Libro con ToString() o metodo Imprimir( << endl; muestra datos formateados.");
    }

void EjecutarEjercicio()
    {
        Libro libro = new Libro("1984", "George Orwell");
            cout << libro << endl;
    }

void EjecutarInteractivo()
    {
        cout << "Titulo: ";
        string? titulo = cin.get();
        cout << "Autor: ";
        string? autor = cin.get();
        Libro libro = new Libro(titulo ?? "", autor ?? "");
        cout << libro << endl;
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
