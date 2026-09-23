/*
U04 — Arrays bidimensionales (matrices).

OBJETIVO:
  - Declarar una matriz con int[,] (filas y columnas).
  - Acceder a elementos con dos indices: matriz[fila, columna].
  - Recorrer una matriz con for anidados y llaves { }.
  - Entender la diferencia basica entre matriz rectangular y array escalonado.
  - Practicar class + Main + menu do-while (EV1).
  - Aplicacion: U06 Tres en raya (tablero char[3,3]).

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

void DemoCrearMatriz();

void DemoForAnidados();

void DemoTablaNotas();

void DemoEscalonado();



void ImprimirMenu()
    {
        cout << "=== U04 Arrays bidimensionales ===" << endl;
        cout << "1. Crear y acceder a int[,]" << endl;
        cout << "2. Recorrido con for anidados" << endl;
        cout << "3. Tabla de notas 3x2" << endl;
        cout << "4. Array escalonado (referencia)" << endl;
        cout << "0. Salir" << endl;
    }

void DemoCrearMatriz()
    {
        cout << "¡DEMO — Crear y acceder a int[,]!\n" << endl;
        int[,] matriz = {
            { 1, 2 },
            { 3, 4 }
        };

        cout << "matriz[0,0] = " << matriz[0, 0] << endl;
        cout << "matriz[0,1] = " << matriz[0, 1] << endl;
        cout << "matriz[1,0] = " << matriz[1, 0] << endl;
        cout << "matriz[1,1] = " << matriz[1, 1] << endl;
        cout << "Filas (GetLength(0)): " << matriz.GetLength(0) << endl;
        cout << "Columnas (GetLength(1)): " << matriz.GetLength(1) << endl;
    }

void DemoForAnidados()
    {
        cout << "¡DEMO — Recorrido con for anidados!\n" << endl;
        int[,] matriz = {
            { 1, 2 },
            { 3, 4 }
        };

        for (int fila = 0; fila < matriz.GetLength(0); fila++)
        {
            for (int col = 0; col < matriz.GetLength(1); col++)
            {
                cout << "  matriz[" << fila << "," << col << "] = " << matriz[fila, col] << endl;
            }
        }
    }

void DemoTablaNotas()
    {
        cout << "¡DEMO — Tabla de notas 3x2!\n" << endl;
        int[,] notas = vector<vector<int>>(3, vector<int>(2));
        notas[0, 0] = 7;
        notas[0, 1] = 8;
        notas[1, 0] = 6;
        notas[1, 1] = 9;
        notas[2, 0] = 5;
        notas[2, 1] = 7;

        for (int fila = 0; fila < notas.GetLength(0); fila++)
        {
            cout << "  Alumno " << (fila + 1) << ": ";
            for (int col = 0; col < notas.GetLength(1); col++)
            {
                cout << notas[fila, col];
                if (col < notas.GetLength(1) - 1)
                {
                    cout << ", ";
                }
            }
            cout << endl;
        }
    }

void DemoEscalonado()
    {
        cout << "¡DEMO — Array escalonado (referencia)!\n" << endl;
        vector<int>[] escalonada = vector<int>(2)[];
        escalonada[0] = new vector<int> { 10, 20 };
        escalonada[1] = new vector<int> { 30, 40, 50 };

        for (int f = 0; f < escalonada.size(); f++)
        {
            for (int c = 0; c < escalonada[f].size(); c++)
            {
                cout << "  escalonada[" << f << "][" << c << "] = " << escalonada[f][c] << endl;
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
            cout << endl;

            switch (opcion)
            {
                case 1:
                    DemoCrearMatriz();
                    break;
                case 2:
                    DemoForAnidados();
                    break;
                case 3:
                    DemoTablaNotas();
                    break;
                case 4:
                    DemoEscalonado();
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
