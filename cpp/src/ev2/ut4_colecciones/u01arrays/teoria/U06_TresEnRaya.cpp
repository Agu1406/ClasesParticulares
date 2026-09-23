/*
U06 — Tres en raya: un tablero es una matriz char[3,3].

OBJETIVO:
  - Representar un tablero con char[,] (fila, columna).
  - Pintar la matriz en consola con for anidados.
  - Detectar ganador recorriendo filas, columnas y diagonales.
  - Jugar una partida a dos jugadores con menu do-while.

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

void PintarTablero(char[,] tablero);

bool HayGanador(char[,] tablero, char ficha);

bool TableroLleno(char[,] tablero);

void JugarPartida();

void DemoPintarTablero();

void DemoComprobarGanador();



void ImprimirMenu()
    {
        cout << "=== U06 Tres en raya ===" << endl;
        cout << "1. Jugar partida (dos jugadores)" << endl;
        cout << "2. Demo: pintar tablero" << endl;
        cout << "3. Demo: comprobar ganador" << endl;
        cout << "0. Salir" << endl;
    }

/*
    Hueco = ' '. Jugador 1 = 'X'. Jugador 2 = 'O'.
    Indices: fila 0..2, columna 0..2.
    */
void PintarTablero(char[,] tablero)
    {
        cout << "    0   1   2" << endl;
        for (int fila = 0; fila < 3; fila++)
        {
            cout << " " << fila << " ";
            for (int col = 0; col < 3; col++)
            {
                cout << " " << tablero[fila, col] << " ";
                if (col < 2)
                {
                    cout << "|";
                }
            }
            cout << endl;
            if (fila < 2)
            {
                cout << "   ---+---+---" << endl;
            }
        }
    }

bool HayGanador(char[,] tablero, char ficha)
    {
        for (int i = 0; i < 3; i++)
        {
            if (tablero[i, 0] == ficha && tablero[i, 1] == ficha && tablero[i, 2] == ficha)
            {
                return true;
            }
            if (tablero[0, i] == ficha && tablero[1, i] == ficha && tablero[2, i] == ficha)
            {
                return true;
            }
        }

        if (tablero[0, 0] == ficha && tablero[1, 1] == ficha && tablero[2, 2] == ficha)
        {
            return true;
        }
        if (tablero[0, 2] == ficha && tablero[1, 1] == ficha && tablero[2, 0] == ficha)
        {
            return true;
        }

        return false;
    }

bool TableroLleno(char[,] tablero)
    {
        for (int fila = 0; fila < 3; fila++)
        {
            for (int col = 0; col < 3; col++)
            {
                if (tablero[fila, col] == ' ')
                {
                    return false;
                }
            }
        }
        return true;
    }

void JugarPartida()
    {
        cout << "¡PARTIDA — dos jugadores!\n" << endl;
        char[,] tablero = new char[3, 3];
        for (int fila = 0; fila < 3; fila++)
        {
            for (int col = 0; col < 3; col++)
            {
                tablero[fila, col] = ' ';
            }
        }

        char turno = 'X';
        bool terminada = false;
        while (!terminada)
        {
            PintarTablero(tablero);
            cout << "Turno de " << turno << endl;
            cout << "Fila (0-2): ";
            int cin >> fila;
            cout << "Columna (0-2): ";
            int cin >> col;

            if (fila < 0 || fila > 2 || col < 0 || col > 2)
            {
                cout << "Indice fuera de rango." << endl;
                continue;
            }
            if (tablero[fila, col] != ' ')
            {
                cout << "Casilla ocupada." << endl;
                continue;
            }

            tablero[fila, col] = turno;

            if (HayGanador(tablero, turno))
            {
                PintarTablero(tablero);
                cout << "Gana " << turno << "!" << endl;
                terminada = true;
            }
            else if (TableroLleno(tablero))
            {
                PintarTablero(tablero);
                cout << "Empate." << endl;
                terminada = true;
            }
            else
            {
                if (turno == 'X')
                {
                    turno = 'O';
                }
                else
                {
                    turno = 'X';
                }
            }
        }
    }

void DemoPintarTablero()
    {
        cout << "¡DEMO — tablero vacio y con una jugada!\n" << endl;
        char[,] vacio = new char[3, 3];
        for (int fila = 0; fila < 3; fila++)
        {
            for (int col = 0; col < 3; col++)
            {
                vacio[fila, col] = ' ';
            }
        }
        PintarTablero(vacio);

        cout << endl;
        char[,] ejemplo = {
            { 'X', ' ', 'O' },
            { ' ', 'X', ' ' },
            { ' ', ' ', ' ' }
        };
        PintarTablero(ejemplo);
    }

void DemoComprobarGanador()
    {
        cout << "¡DEMO — tres en raya en diagonal!\n" << endl;
        char[,] tablero = {
            { 'X', 'O', ' ' },
            { 'O', 'X', ' ' },
            { ' ', ' ', 'X' }
        };
        PintarTablero(tablero);
        cout << "HayGanador X: " << HayGanador(tablero, 'X') << endl;
        cout << "HayGanador O: " << HayGanador(tablero, 'O') << endl;
    }



int main()
    {
        int opcion;
        do
        {
            ImprimirMenu();
            cout << "Introduce una opcion -> ";
            cin >> opcion;
            cout << endl;

            switch (opcion)
            {
                case 1:
                    JugarPartida();
                    break;
                case 2:
                    DemoPintarTablero();
                    break;
                case 3:
                    DemoComprobarGanador();
                    break;
                case 0:
                    cout << "Saliendo..." << endl;
                    break;
                default:
                    cout << "Opcion no valida." << endl;
                    break;
            }

            cout << endl;
        } while (opcion != 0);
        return 0;
}
