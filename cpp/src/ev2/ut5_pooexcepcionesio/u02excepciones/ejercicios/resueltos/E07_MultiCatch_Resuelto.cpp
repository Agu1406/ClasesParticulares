/*
OBJETIVO: Varios catch: FormatException y DivideByZeroException en un mismo try. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
        cout << "3. Probar con otros valores" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "Varios catch: invalid_argument y DivideByZeroException en un mismo try." << endl;
    }

void EjecutarEjercicio()
    {
        string entrada = "10";
            int divisor = 0;

            try
            {
                int numero = int.Parse(entrada);
                cout << numero / divisor << endl;
            }
            catch (invalid_argument)
            {
                cout << "Error de formato." << endl;
            }
            catch (DivideByZeroException)
            {
                cout << "Division entre cero." << endl;
            }
    }

void EjecutarInteractivo()
    {
        cout << "Entrada: ";
        string? entrada = cin.get();
        cout << "Divisor: ";
        int.TryParse(string(/*TODO cin*/), out int divisor);
        try
        {
            int numero = int.Parse(entrada);
            cout << numero / divisor << endl;
        }
        catch (invalid_argument)
        {
            cout << "Error de formato." << endl;
        }
        catch (DivideByZeroException)
        {
            cout << "Division entre cero." << endl;
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
