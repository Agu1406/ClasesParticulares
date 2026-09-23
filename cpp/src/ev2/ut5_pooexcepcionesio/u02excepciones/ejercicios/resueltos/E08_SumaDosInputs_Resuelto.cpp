/*
OBJETIVO: Pedir dos numeros y sumarlos de forma segura (TryParse o try/catch). Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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
        cout << "Pedir dos numeros y sumarlos de forma segura (TryParse o try/catch)." << endl;
    }

void EjecutarEjercicio()
    {
        cout << "Primer numero: ";
            string? aTexto = cin.get();
            cout << "Segundo numero: ";
            string? bTexto = cin.get();

            if (int.TryParse(aTexto, out int a) && int.TryParse(bTexto, out int b))
            {
                cout << "Suma: " << (a + b) << endl;
            }
            else
            {
                cout << "Ambos valores deben ser enteros validos." << endl;
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
