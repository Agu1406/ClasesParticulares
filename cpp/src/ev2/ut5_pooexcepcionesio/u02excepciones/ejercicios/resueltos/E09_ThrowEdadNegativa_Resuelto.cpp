/*
OBJETIVO: Metodo ValidarEdad que lance ArgumentException si edad < 0. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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

void ValidarEdad(int edad);



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Validar edad introducida" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "Metodo ValidarEdad que lance invalid_argument si edad < 0." << endl;
    }

void EjecutarEjercicio()
    {
        try
            {
                ValidarEdad(-3);
            }
            catch (invalid_argument& ex)
            {
                cout << ex.Message << endl;
            }
    }

void EjecutarInteractivo()
    {
        cout << "Edad: ";
        if (int.TryParse(string(/*TODO cin*/), out int edad))
        {
            try
            {
                ValidarEdad(edad);
            }
            catch (invalid_argument& ex)
            {
                cout << ex.Message << endl;
            }
        }
        else
        {
            cout << "Edad invalida." << endl;
        }
    }

void ValidarEdad(int edad)
    {
        if (edad < 0)
        {
            throw invalid_argument("La edad no puede ser negativa.");
        }
        cout << "Edad valida: " << (edad) << endl;
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
