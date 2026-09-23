/*
OBJETIVO: Dos objetos Punto independientes; cambia uno y verifica que el otro no cambia. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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



class Punto {
public:

    int X;
    int Y;
};



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Probar con otro valor" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        Console.WriteLine("Dos objetos Punto independientes; cambia uno y verifica que el otro no cambia.");
    }

void EjecutarEjercicio()
    {
        Punto p1;
            Punto p2;
            p1.X = 10;
            cout << "p1.X=" << (p1.X) << ", p2.X=" << (p2.X) << endl;
    }

void EjecutarInteractivo()
    {
        Punto p1;
        Punto p2;
        cout << "Nuevo valor para p1.X: ";
        if (int.TryParse(string(/*TODO cin*/), out int x))
        {
            p1.X = x;
            cout << "p1.X=" << (p1.X) << ", p2.X=" << (p2.X) << endl;
        }
        else
        {
            cout << "Valor invalido." << endl;
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
