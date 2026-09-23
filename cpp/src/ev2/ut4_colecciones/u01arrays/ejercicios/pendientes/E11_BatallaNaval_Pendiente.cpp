/*
OBJETIVO: Batalla naval 6x6 con un barco de 3 celdas. Disparar por fila y columna
          (agua / tocado). Menu do-while, opcion 0 para salir.

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
        cout << "=== E11 Batalla naval ===" << endl;
        cout << "1. Trabajar ejercicio" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
    }

void MostrarObjetivo()
    {
        cout << "Tablero char[6,6]. Un barco de 3 celdas (horizontal o vertical)." << endl;
        cout << "El jugador dispara indicando fila y columna (0-5)." << endl;
        cout << "~ agua, * disparo al agua, X barco tocado. Hundir las 3 celdas." << endl;
    }

void EjecutarEjercicio()
    {
        char[,] oculto = new char[6, 6];
        char[,] visible = new char[6, 6];

        // TODO: Rellena ambos tableros con '~'.
        // TODO: Coloca un barco de 3 celdas (fijo o aleatorio) en oculto usando 'B'.
        // TODO: Bucle: pintar visible, pedir fila y columna, actualizar disparo.
        // TODO: Gana cuando las 3 celdas del barco estan tocadas (X).
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
