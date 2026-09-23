/*
OBJETIVO: Buscaminas 5x5 con 4 minas. Revelar una celda por turno y mostrar
          el numero de minas vecinas (bucle ±1, sin recursion). Menu do-while.
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

int ContarVecinas(bool[,] minas, int fila, int col);

void Pintar(bool[,] minas, int[,] vecinas, bool[,] revelado, bool mostrarMinas);

void EjecutarEjercicio();



void ImprimirMenu()
    {
        cout << "=== E12 Buscaminas ===" << endl;
        cout << "1. Jugar" << endl;
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

int ContarVecinas(bool[,] minas, int fila, int col)
    {
        int total = 0;
        for (int df = -1; df <= 1; df++)
        {
            for (int dc = -1; dc <= 1; dc++)
            {
                if (df == 0 && dc == 0)
                {
                    continue;
                }
                int nf = fila + df;
                int nc = col + dc;
                if (nf >= 0 && nf < 5 && nc >= 0 && nc < 5)
                {
                    if (minas[nf, nc])
                    {
                        total++;
                    }
                }
            }
        }
        return total;
    }

void Pintar(bool[,] minas, int[,] vecinas, bool[,] revelado, bool mostrarMinas)
    {
        cout << "   ";
        for (int col = 0; col < 5; col++)
        {
            cout << col << " ";
        }
        cout << endl;
        for (int fila = 0; fila < 5; fila++)
        {
            cout << fila << "  ";
            for (int col = 0; col < 5; col++)
            {
                if (mostrarMinas && minas[fila, col])
                {
                    cout << "* ";
                }
                else if (!revelado[fila, col])
                {
                    cout << ". ";
                }
                else
                {
                    cout << vecinas[fila, col] << " ";
                }
            }
            cout << endl;
        }
    }

void EjecutarEjercicio()
    {
        bool[,] minas = new bool[5, 5];
        int[,] vecinas = vector<vector<int>>(5, vector<int>(5));
        bool[,] revelado = new bool[5, 5];

        // 4 minas fijas (didactico).
        minas[0, 1] = true;
        minas[1, 3] = true;
        minas[3, 0] = true;
        minas[4, 4] = true;

        for (int fila = 0; fila < 5; fila++)
        {
            for (int col = 0; col < 5; col++)
            {
                vecinas[fila, col] = ContarVecinas(minas, fila, col);
            }
        }

        int reveladas = 0;
        bool explotado = false;
        while (!explotado && reveladas < 21)
        {
            Pintar(minas, vecinas, revelado, false);
            cout << "Fila (0-4): ";
            int cin >> fila;
            cout << "Columna (0-4): ";
            int cin >> col;

            if (fila < 0 || fila > 4 || col < 0 || col > 4)
            {
                cout << "Fuera del tablero." << endl;
                continue;
            }
            if (revelado[fila, col])
            {
                cout << "Ya revelada." << endl;
                continue;
            }

            if (minas[fila, col])
            {
                explotado = true;
                cout << "Mina. Has perdido." << endl;
                Pintar(minas, vecinas, revelado, true);
            }
            else
            {
                revelado[fila, col] = true;
                reveladas++;
                cout << "Vecinas: " << vecinas[fila, col] << endl;
            }
        }

        if (!explotado)
        {
            Pintar(minas, vecinas, revelado, true);
            cout << "Has ganado." << endl;
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
