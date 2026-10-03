/*
U04 — Arrays bidimensionales (matrices).

OBJETIVO:
  - Declarar una matriz clasica: int matriz[FILAS][COLS].
  - Acceder con dos indices: matriz[fila][columna] (no coma como en C#).
  - Recorrer una matriz con for anidados y llaves { }.
  - Entender que en C++ junior la matriz es rectangular (todas las filas igual de largas).
  - Practicar funciones + main + menu do-while (EV1).
  - Aplicacion: practicas/internotresenraya (tablero char[3][3]).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U04 Arrays bidimensionales ===" << endl;
    cout << "1. Crear y acceder a int[2][2]" << endl;
    cout << "2. Recorrido con for anidados" << endl;
    cout << "3. Tabla de notas 3x2" << endl;
    cout << "4. Matriz rectangular (no escalonada)" << endl;
    cout << "0. Salir" << endl;
}

void DemoCrearMatriz()
{
    cout << "¡DEMO — Crear y acceder a int[2][2]!\n" << endl;
    const int FILAS = 2;
    const int COLS = 2;
    int matriz[FILAS][COLS] = {
        {1, 2},
        {3, 4}
    };

    cout << "matriz[0][0] = " << matriz[0][0] << endl;
    cout << "matriz[0][1] = " << matriz[0][1] << endl;
    cout << "matriz[1][0] = " << matriz[1][0] << endl;
    cout << "matriz[1][1] = " << matriz[1][1] << endl;
    cout << "Filas: " << FILAS << endl;
    cout << "Columnas: " << COLS << endl;
}

void DemoForAnidados()
{
    cout << "¡DEMO — Recorrido con for anidados!\n" << endl;
    const int FILAS = 2;
    const int COLS = 2;
    int matriz[FILAS][COLS] = {
        {1, 2},
        {3, 4}
    };

    for (int fila = 0; fila < FILAS; fila++)
    {
        for (int col = 0; col < COLS; col++)
        {
            cout << "  matriz[" << fila << "][" << col << "] = " << matriz[fila][col] << endl;
        }
    }
}

void DemoTablaNotas()
{
    cout << "¡DEMO — Tabla de notas 3x2!\n" << endl;
    const int FILAS = 3;
    const int COLS = 2;
    int notas[FILAS][COLS] = {};
    notas[0][0] = 7;
    notas[0][1] = 8;
    notas[1][0] = 6;
    notas[1][1] = 9;
    notas[2][0] = 5;
    notas[2][1] = 7;

    for (int fila = 0; fila < FILAS; fila++)
    {
        cout << "  Alumno " << (fila + 1) << ": ";
        for (int col = 0; col < COLS; col++)
        {
            cout << notas[fila][col];
            if (col < COLS - 1)
            {
                cout << ", ";
            }
        }
        cout << endl;
    }
}

/*
C# tiene int[][] (cada fila un array de largo distinto).
En C++ junior int m[FILAS][COLS] es SIEMPRE rectangular: mismas columnas en cada fila.
vector (listas) se ve en u02; aqui no.
*/
void DemoRectangular()
{
    cout << "¡DEMO — Matriz rectangular (no escalonada)!\n" << endl;
    const int FILAS = 2;
    const int COLS = 3;
    int rectangular[FILAS][COLS] = {
        {10, 20, 0},
        {30, 40, 50}
    };

    cout << "Todas las filas tienen " << COLS << " columnas." << endl;
    for (int f = 0; f < FILAS; f++)
    {
        for (int c = 0; c < COLS; c++)
        {
            cout << "  rectangular[" << f << "][" << c << "] = " << rectangular[f][c] << endl;
        }
    }

    cout << "\nIdea de filas de distinto largo: dos arrays 1D separados." << endl;
    int filaCorta[] = {10, 20};
    int filaLarga[] = {30, 40, 50};
    const int N_CORTA = 2;
    const int N_LARGA = 3;

    cout << "filaCorta (" << N_CORTA << "): ";
    for (int i = 0; i < N_CORTA; i++)
    {
        cout << filaCorta[i] << " ";
    }
    cout << endl;

    cout << "filaLarga (" << N_LARGA << "): ";
    for (int i = 0; i < N_LARGA; i++)
    {
        cout << filaLarga[i] << " ";
    }
    cout << endl;
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
                DemoRectangular();
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
