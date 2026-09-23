/*
OBJETIVO: Repaso: lista ints, dict resumen min/max/suma. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "Repaso: lista ints, dict resumen min/max/suma." << endl;
    }

void EjecutarEjercicio()
    {
        vector<int> nums = new vector<int> { 4, 9, 2, 7 };
        int suma = 0, max = nums[0], min = nums[0];
        for (int n : nums)
        {
            suma += n;
            if (n > max) max = n;
            if (n < min) min = n;
        }
        map<string, int> resumen = new map<string, int>
        {
            { "suma", suma },
            { "max", max },
            { "min", min }
        };
        for (KeyValuePair<string, int> par : resumen)
        {
            cout << par.first << ": " << par.second << endl;
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
