/*
OBJETIVO: Menu 1=dividir 2=salir; try/catch en opcion dividir. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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

void EjecutarMenuDivision();



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Menu de division interactivo" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        Console.WriteLine("Menu 1=dividir 2=salir; try/catch en opcion dividir.");
    }

void EjecutarEjercicio()
    {
        cout << "Demo: division 10 / 0 con try/catch." << endl;
            try
            {
                cout << "Resultado: " << (10 / 0) << endl;
            }
            catch (DivideByZeroException)
            {
                cout << "No se puede dividir entre cero." << endl;
            }
    }

void EjecutarMenuDivision()
    {
        while (true)
        {
            cout << "1. Dividir  2. Volver" << endl;
            cout << "Opcion: ";
            string? op = cin.get();

            if (op == "2")
            {
                break;
            }

            if (op == "1")
            {
                cout << "a: ";
                int.TryParse(string(/*TODO cin*/), out int a);
                cout << "b: ";
                int.TryParse(string(/*TODO cin*/), out int b);
                try
                {
                    cout << "Resultado: " << (a / b) << endl;
                }
                catch (DivideByZeroException)
                {
                    cout << "No se puede dividir entre cero." << endl;
                }
            }
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
                    EjecutarMenuDivision();
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
