/*
OBJETIVO: Repaso: clase Alumno con Nombre y Nota; crear objeto y mostrarlo. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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



class Alumno {
public:

    string Nombre;
    double Nota;
};



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Crear alumno interactivo" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        Console.WriteLine("Repaso: clase Alumno con Nombre y Nota; crear objeto y mostrarlo.");
    }

void EjecutarEjercicio()
    {
        Alumno alumno = new Alumno { Nombre = "Pedro", Nota = 7.5 };
            cout << (alumno.Nombre) << ": " << (alumno.Nota) << endl;
    }

void EjecutarInteractivo()
    {
        cout << "Nombre: ";
        string? nombre = cin.get();
        cout << "Nota: ";
        if (double.TryParse(string(/*TODO cin*/), out double nota))
        {
            Alumno alumno = new Alumno { Nombre = nombre ?? "", Nota = nota };
            cout << (alumno.Nombre) << ": " << (alumno.Nota) << endl;
        }
        else
        {
            cout << "Nota invalida." << endl;
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
