/*
OBJETIVO: Repaso: throw ArgumentException si nota fuera de rango 0..10. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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

void ValidarNota(double nota);



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Validar nota introducida" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "Repaso: throw invalid_argument si nota fuera de rango 0..10." << endl;
    }

void EjecutarEjercicio()
    {
        try
            {
                ValidarNota(11);
            }
            catch (invalid_argument& ex)
            {
                cout << ex.Message << endl;
            }
    }

void EjecutarInteractivo()
    {
        cout << "Nota: ";
        if (double.TryParse(string(/*TODO cin*/), out double nota))
        {
            try
            {
                ValidarNota(nota);
            }
            catch (invalid_argument& ex)
            {
                cout << ex.Message << endl;
            }
        }
        else
        {
            cout << "Nota invalida." << endl;
        }
    }

void ValidarNota(double nota)
    {
        if (nota < 0 || nota > 10)
        {
            throw invalid_argument("La nota debe estar entre 0 y 10.");
        }
        cout << "Nota valida: " << (nota) << endl;
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
