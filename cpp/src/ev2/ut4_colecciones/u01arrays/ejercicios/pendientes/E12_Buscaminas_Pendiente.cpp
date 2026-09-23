/*
OBJETIVO: Buscaminas 5x5 con 4 minas. Revelar una celda por turno y mostrar
          el numero de minas vecinas (bucle ±1, sin recursion). Menu do-while.

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
        cout << "=== E12 Buscaminas ===" << endl;
        cout << "1. Trabajar ejercicio" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
    }

void MostrarObjetivo()
    {
        cout << "bool[5,5] minas + int[5,5] vecinas + bool[5,5] revelado." << endl;
        cout << "Coloca 4 minas. Recorre vecinos fila±1, col±1 (dentro de rango)." << endl;
        cout << "Cada turno revelas UNA celda. Si hay mina, pierdes." << endl;
        cout << "Ganas al revelar las 21 celdas sin mina. Sin recursion." << endl;
    }

void EjecutarEjercicio()
    {
        bool[,] minas = new bool[5, 5];
        int[,] vecinas = vector<vector<int>>(5, vector<int>(5));
        bool[,] revelado = new bool[5, 5];

        // TODO: Coloca 4 minas (fijas o aleatorias) en minas[,].
        // TODO: Para cada celda, cuenta minas en las 8 vecinas (for df, dc de -1 a 1).
        // TODO: Bucle: pedir fila/columna, revelar, pintar tablero, comprobar victoria/derrota.
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
