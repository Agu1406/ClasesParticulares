/*
Practica interna: Tres en raya — RESUELTO.

Tablero char[3][3]. Dos jugadores (1 = X, 2 = O). Pintar el tablero
al inicio de cada turno y luego pedir la casilla. Menu do-while,
opcion 0 para salir. DRY: menu, cajas y cambio de turno en funciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

const int LADO = 3;
const char VACIO = ' ';

void Write(string texto)
{
    cout << texto;
}

void WriteLine(string texto)
{
    cout << texto << endl;
}

int ReadInt()
{
    int numero;
    cin >> numero;
    return numero;
}

int ImprimirMenu()
{
    WriteLine("");
    WriteLine("¡Menú del programa!");
    WriteLine("[1] - Jugar partida (dos jugadores).");
    WriteLine("[2] - Ver objetivo.");
    WriteLine("[0] - Salir.");
    Write("Introduce una opción => ");
    return ReadInt();
}

void MostrarObjetivo()
{
    WriteLine("Tablero char[3][3]. Hueco = espacio, jugador 1 = X, jugador 2 = O.");
    WriteLine("Cada turno se pinta el tablero y el jugador elige fila y columna (0-2).");
    WriteLine("Gana 3 en raya (fila, columna o diagonal). Si no quedan huecos: empate.");
}

char FichaDelTurno(int turno)
{
    if (turno == 1)
    {
        return 'X';
    }
    return 'O';
}

int CambiarTurno(int turno)
{
    if (turno == 1)
    {
        return 2;
    }
    return 1;
}

void InicializarTablero(char tablero[3][3])
{
    for (int fila = 0; fila < LADO; fila++)
    {
        for (int col = 0; col < LADO; col++)
        {
            tablero[fila][col] = VACIO;
        }
    }
}

void PintarCaja(string texto)
{
    Write("[" + texto + "]");
}

void PintarTablero(char tablero[3][3])
{
    WriteLine("¡TABLERO DE JUEGO ACTUAL!");
    for (int col = 0; col < LADO; col++)
    {
        PintarCaja(to_string(col));
    }
    WriteLine("");

    for (int fila = 0; fila < LADO; fila++)
    {
        PintarCaja(to_string(fila));
        for (int col = 0; col < LADO; col++)
        {
            PintarCaja(string(1, tablero[fila][col]));
        }
        WriteLine("");
    }
}

bool HayGanador(char tablero[3][3], char ficha)
{
    for (int i = 0; i < LADO; i++)
    {
        if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha)
        {
            return true;
        }
        if (tablero[0][i] == ficha && tablero[1][i] == ficha && tablero[2][i] == ficha)
        {
            return true;
        }
    }
    if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha)
    {
        return true;
    }
    if (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha)
    {
        return true;
    }
    return false;
}

bool TableroLleno(char tablero[3][3])
{
    for (int fila = 0; fila < LADO; fila++)
    {
        for (int col = 0; col < LADO; col++)
        {
            if (tablero[fila][col] == VACIO)
            {
                return false;
            }
        }
    }
    return true;
}

int PedirIndice(string mensaje)
{
    Write(mensaje);
    return ReadInt();
}

void JugarPartida()
{
    WriteLine("¡Partida a dos jugadores!");
    char tablero[3][3];
    InicializarTablero(tablero);

    int turno = 1;
    bool terminada = false;
    while (!terminada)
    {
        PintarTablero(tablero);
        WriteLine("Turno del jugador " + to_string(turno) + " (" + string(1, FichaDelTurno(turno)) + ").");

        int fila = PedirIndice("Introduce una fila => ");
        int col = PedirIndice("Introduce una columna => ");

        if (fila < 0 || fila >= LADO || col < 0 || col >= LADO)
        {
            WriteLine("Índice fuera de rango.");
            continue;
        }
        if (tablero[fila][col] != VACIO)
        {
            WriteLine("Casilla ocupada.");
            continue;
        }

        char ficha = FichaDelTurno(turno);
        tablero[fila][col] = ficha;

        if (HayGanador(tablero, ficha))
        {
            PintarTablero(tablero);
            WriteLine("¡Gana el jugador " + to_string(turno) + "!");
            terminada = true;
        }
        else if (TableroLleno(tablero))
        {
            PintarTablero(tablero);
            WriteLine("Empate.");
            terminada = true;
        }
        else
        {
            turno = CambiarTurno(turno);
        }
    }
}

int main()
{
    int opcion;
    do
    {
        opcion = ImprimirMenu();
        switch (opcion)
        {
            case 1:
                JugarPartida();
                break;
            case 2:
                MostrarObjetivo();
                break;
            case 0:
                WriteLine("Saliendo...");
                break;
            default:
                WriteLine("Opción no válida.");
                break;
        }
    } while (opcion != 0);
    return 0;
}
