/*
OBJETIVO: Serpiente por turnos en un tablero 8x8. Cuerpo en int[] posX / posY.
          Movimiento WASD un paso por turno. Sin List ni Thread.Sleep.
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

void Pintar(vector<int> posX, vector<int> posY, int longitud, int manzanaX, int manzanaY);

bool CeldaOcupada(vector<int> posX, vector<int> posY, int longitud, int x, int y);

void ColocarManzana(vector<int> posX, vector<int> posY, int longitud, out int manzanaX, out int manzanaY);

void EjecutarEjercicio();



void ImprimirMenu()
    {
        cout << "=== E13 Serpiente ===" << endl;
        cout << "1. Jugar" << endl;
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

void Pintar(vector<int> posX, vector<int> posY, int longitud, int manzanaX, int manzanaY)
    {
        char[,] tablero = new char[8, 8];
        for (int fila = 0; fila < 8; fila++)
        {
            for (int col = 0; col < 8; col++)
            {
                tablero[fila, col] = '.';
            }
        }

        tablero[manzanaY, manzanaX] = '@';
        for (int i = 0; i < longitud; i++)
        {
            tablero[posY[i], posX[i]] = i == 0 ? 'O' : 'o';
        }

        for (int fila = 0; fila < 8; fila++)
        {
            for (int col = 0; col < 8; col++)
            {
                cout << tablero[fila, col];
            }
            cout << endl;
        }
    }

bool CeldaOcupada(vector<int> posX, vector<int> posY, int longitud, int x, int y)
    {
        for (int i = 0; i < longitud; i++)
        {
            if (posX[i] == x && posY[i] == y)
            {
                return true;
            }
        }
        return false;
    }

void ColocarManzana(vector<int> posX, vector<int> posY, int longitud, out int manzanaX, out int manzanaY)
    {
        manzanaX = 6;
        manzanaY = 1;
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                if (!CeldaOcupada(posX, posY, longitud, x, y))
                {
                    manzanaX = x;
                    manzanaY = y;
                    return;
                }
            }
        }
    }

void EjecutarEjercicio()
    {
        vector<int> posX = vector<int>(64);
        vector<int> posY = vector<int>(64);
        int longitud = 3;
        posX[0] = 4;
        posY[0] = 4;
        posX[1] = 3;
        posY[1] = 4;
        posX[2] = 2;
        posY[2] = 4;

        int manzanaX;
        int manzanaY;
        ColocarManzana(posX, posY, longitud, out manzanaX, out manzanaY);

        bool viva = true;
        while (viva)
        {
            // clear omitido
            Pintar(posX, posY, longitud, manzanaX, manzanaY);
            cout << "WASD (o Q para rendirse): ";
            string tecla = (string(/*TODO cin*/) ?? "").Trim().ToUpper();
            if (tecla == "Q")
            {
                cout << "Fin." << endl;
                break;
            }

            int dx = 0;
            int dy = 0;
            if (tecla == "W")
            {
                dy = -1;
            }
            else if (tecla == "S")
            {
                dy = 1;
            }
            else if (tecla == "A")
            {
                dx = -1;
            }
            else if (tecla == "D")
            {
                dx = 1;
            }
            else
            {
                cout << "Usa W A S D." << endl;
                cin.get();
                continue;
            }

            int nuevaX = posX[0] + dx;
            int nuevaY = posY[0] + dy;

            if (nuevaX < 0 || nuevaX > 7 || nuevaY < 0 || nuevaY > 7)
            {
                cout << "Chocaste con el borde." << endl;
                viva = false;
                continue;
            }

            bool come = nuevaX == manzanaX && nuevaY == manzanaY;
            int limiteCuerpo = come ? longitud : longitud - 1;
            if (CeldaOcupada(posX, posY, limiteCuerpo, nuevaX, nuevaY))
            {
                cout << "Chocaste contigo." << endl;
                viva = false;
                continue;
            }

            int colaX = posX[longitud - 1];
            int colaY = posY[longitud - 1];

            for (int i = longitud - 1; i >= 1; i--)
            {
                posX[i] = posX[i - 1];
                posY[i] = posY[i - 1];
            }
            posX[0] = nuevaX;
            posY[0] = nuevaY;

            if (come)
            {
                posX[longitud] = colaX;
                posY[longitud] = colaY;
                longitud++;
                ColocarManzana(posX, posY, longitud, out manzanaX, out manzanaY);
                cout << "Manzana. Longitud = " << longitud << endl;
            }
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
