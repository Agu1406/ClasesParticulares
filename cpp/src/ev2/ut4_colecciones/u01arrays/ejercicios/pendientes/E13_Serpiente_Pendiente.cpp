/*
OBJETIVO: Serpiente por turnos en un tablero 8x8. Cuerpo en int[] posX / posY.
          Movimiento WASD un paso por turno. Sin List ni Thread.Sleep.

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
        cout << "=== E13 Serpiente ===" << endl;
        cout << "1. Trabajar ejercicio" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
    }

void MostrarObjetivo()
    {
        cout << "Tablero char[8,8]. Cuerpo: vector<int> posX, vector<int> posY y int longitud." << endl;
        cout << "Cada turno lees W/A/S/D, mueves la cabeza, desplazas el cuerpo." << endl;
        cout << "Manzana '@'. Chocar con borde o contigo mismo termina." << endl;
        cout << "No uses List ni Thread.Sleep: un paso por Console.ReadLine." << endl;
    }

void EjecutarEjercicio()
    {
        vector<int> posX = vector<int>(64);
        vector<int> posY = vector<int>(64);
        int longitud = 3;

        // TODO: Inicializa el cuerpo (por ejemplo fila 4, columnas 2,3,4).
        // TODO: Coloca una manzana en una celda libre.
        // TODO: Bucle: pintar tablero, leer WASD, calcular nueva cabeza.
        // TODO: Si come manzana, longitud++. Si choca, terminar.
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
