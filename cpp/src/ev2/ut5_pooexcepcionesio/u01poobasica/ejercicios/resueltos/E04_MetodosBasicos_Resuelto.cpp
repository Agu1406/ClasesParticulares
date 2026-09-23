/*
OBJETIVO: Clase Circulo con radio y metodo CalcularArea(); muestra el area de r=5. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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



class Circulo {
public:

    double Radio;

    Circulo(double radio)
    {
        Radio = radio;
    };

    double CalcularArea()
    {
        return Math.PI * Radio * Radio;
    }
}



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Calcular area con otro radio" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "Clase Circulo con radio y metodo CalcularArea( << endl; muestra el area de r=5.");
    }

void EjecutarEjercicio()
    {
        Circulo circulo = new Circulo(5);
            cout << "Area: " << (circulo.CalcularArea():F2) << endl;
    }

void EjecutarInteractivo()
    {
        cout << "Radio: ";
        string? texto = cin.get();
        if (double.TryParse(texto, out double radio))
        {
            Circulo circulo = new Circulo(radio);
            cout << "Area: " << (circulo.CalcularArea():F2) << endl;
        }
        else
        {
            cout << "Radio invalido." << endl;
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
