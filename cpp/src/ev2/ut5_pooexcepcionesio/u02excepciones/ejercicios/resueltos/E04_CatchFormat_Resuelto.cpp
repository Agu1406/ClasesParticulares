/*
OBJETIVO: int.Parse con catch especifico de FormatException. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
        cout << "3. Probar con otro texto" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "int.Parse con catch especifico de invalid_argument." << endl;
    }

void EjecutarEjercicio()
    {
        string texto = "doce";

            try
            {
                int numero = int.Parse(texto);
                cout << numero << endl;
            }
            catch (invalid_argument)
            {
                cout << "Formato invalido: no es un entero." << endl;
            }
    }

void EjecutarInteractivo()
    {
        cout << "Texto a parsear: ";
        string? texto = cin.get();
        try
        {
            int numero = int.Parse(texto);
            cout << numero << endl;
        }
        catch (invalid_argument)
        {
            cout << "Formato invalido: no es un entero." << endl;
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
