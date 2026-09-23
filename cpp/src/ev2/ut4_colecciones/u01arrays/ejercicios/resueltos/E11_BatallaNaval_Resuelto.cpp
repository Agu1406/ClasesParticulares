/*
OBJETIVO: Batalla naval 6x6 con un barco de 3 celdas. Disparar por fila y columna
          (agua / tocado). Menu do-while, opcion 0 para salir.
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

void Pintar(char[,] tablero);

void EjecutarEjercicio();



void ImprimirMenu()
    {
        cout << "=== E11 Batalla naval ===" << endl;
        cout << "1. Jugar" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "0. Salir" << endl;
    }

void MostrarObjetivo()
    {
        cout << "Tablero char[6,6]. Un barco de 3 celdas (horizontal o vertical)." << endl;
        cout << "El jugador dispara indicando fila y columna (0-5)." << endl;
        cout << "~ agua, * disparo al agua, X barco tocado. Hundir las 3 celdas." << endl;
    }

void Pintar(char[,] tablero)
    {
        cout << "   ";
        for (int col = 0; col < 6; col++)
        {
            cout << col << " ";
        }
        cout << endl;
        for (int fila = 0; fila < 6; fila++)
        {
            cout << fila << "  ";
            for (int col = 0; col < 6; col++)
            {
                cout << tablero[fila, col] << " ";
            }
            cout << endl;
        }
    }

void EjecutarEjercicio()
    {
        char[,] oculto = new char[6, 6];
        char[,] visible = new char[6, 6];
        for (int fila = 0; fila < 6; fila++)
        {
            for (int col = 0; col < 6; col++)
            {
                oculto[fila, col] = '~';
                visible[fila, col] = '~';
            }
        }

        // Barco fijo horizontal en fila 2, columnas 1-3 (didactico).
        oculto[2, 1] = 'B';
        oculto[2, 2] = 'B';
        oculto[2, 3] = 'B';

        int toques = 0;
        while (toques < 3)
        {
            Pintar(visible);
            cout << "Fila (0-5): ";
            int cin >> fila;
            cout << "Columna (0-5): ";
            int cin >> col;

            if (fila < 0 || fila > 5 || col < 0 || col > 5)
            {
                cout << "Fuera del tablero." << endl;
                continue;
            }
            if (visible[fila, col] == '*' || visible[fila, col] == 'X')
            {
                cout << "Ya disparaste ahi." << endl;
                continue;
            }

            if (oculto[fila, col] == 'B')
            {
                visible[fila, col] = 'X';
                toques++;
                cout << "Tocado! (" << toques << "/3)" << endl;
            }
            else
            {
                visible[fila, col] = '*';
                cout << "Agua." << endl;
            }
        }

        Pintar(visible);
        cout << "Hundido. Has ganado." << endl;
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
