/*
OBJETIVO: Repaso: clase Rectangulo con propiedades Ancho/Alto y area calculada. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
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



class Rectangulo {
public:

    double Ancho;
    double Alto;
    double Area => Ancho * Alto;
};



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Calcular con otros valores" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        cout << "Repaso: clase Rectangulo con propiedades Ancho/Alto y area calculada." << endl;
    }

void EjecutarEjercicio()
    {
        Rectangulo r = new Rectangulo { Ancho = 6, Alto = 4 };
            cout << "Ancho=" << (r.Ancho) << ", Alto=" << (r.Alto) << ", Area=" << (r.Area) << endl;
    }

void EjecutarInteractivo()
    {
        cout << "Ancho: ";
        double.TryParse(string(/*TODO cin*/), out double ancho);
        cout << "Alto: ";
        double.TryParse(string(/*TODO cin*/), out double alto);
        Rectangulo r = new Rectangulo { Ancho = ancho, Alto = alto };
        cout << "Ancho=" << (r.Ancho) << ", Alto=" << (r.Alto) << ", Area=" << (r.Area) << endl;
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
