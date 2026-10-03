/*
Practica interna: Batalla naval — RESUELTO.

Dos jugadores (hotseat). Cada uno: flota (bool[][]), ataque y propio (char[][]).
Tablero 10x10; al pintar se ve 11x11: letras A-J arriba (columnas) y numeros
0-9 a la izquierda (filas). Ataque tipo A7 = columna A, fila 7.

Colocacion: H/V al azar + casilla al azar; si no cabe o solapa, reintenta.
Agua = ' ', fallo = 'F', tocado = 'X'.
Victoria: contar X en el radar == celdas de barco (sin int& / contador externo).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
using namespace std;

const int TAMANO = 10;
const int NUM_BARCOS = 4;
const int LONGITUDES[NUM_BARCOS] = {5, 4, 3, 2};
const char VACIO = ' ';
const char BARCO = 'B';
const char FALLO = 'F';
const char TOCADO = 'X';

const int DISPARO_REINTENTAR = -1;
const int DISPARO_AGUA = 0;
const int DISPARO_TOCADO = 1;
const int TURNO_SEGUIR = 0;
const int TURNO_GANADA = 1;

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

string ReadLine()
{
    string texto;
    cin >> texto;
    return texto;
}

int CambiarTurno(int turno)
{
    if (turno == 1)
    {
        return 2;
    }
    return 1;
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
    WriteLine("Dos jugadores en el mismo PC. Cada uno: flota (bool), ataque y propio (char).");
    WriteLine("Tablero 10x10 (al pintar 11x11: letras A-J arriba, numeros 0-9 a la izquierda).");
    WriteLine("Barcos al azar: 5, 4, 3 y 2. H/V y casilla aleatoria; si no cabe o solapa, reintenta.");
    WriteLine("Cada turno: enemigo arriba (solo F/X) y propio abajo (B + impactos).");
    WriteLine("Ataca con una casilla tipo A7 (letra = columna, numero = fila).");
    WriteLine("Espacio = agua, F = fallo, X = tocado. Casilla invalida: se reintenta.");
    WriteLine("Gana quien hunde toda la flota rival.");
}

void InicializarBool(bool tablero[TAMANO][TAMANO])
{
    for (int fila = 0; fila < TAMANO; fila++)
    {
        for (int col = 0; col < TAMANO; col++)
        {
            tablero[fila][col] = false;
        }
    }
}

void InicializarChar(char tablero[TAMANO][TAMANO])
{
    for (int fila = 0; fila < TAMANO; fila++)
    {
        for (int col = 0; col < TAMANO; col++)
        {
            tablero[fila][col] = VACIO;
        }
    }
}

int ContarCeldasBarco()
{
    int total = 0;
    for (int i = 0; i < NUM_BARCOS; i++)
    {
        total += LONGITUDES[i];
    }
    return total;
}

int ContarCasillas(char tablero[TAMANO][TAMANO], char valor)
{
    int total = 0;
    for (int fila = 0; fila < TAMANO; fila++)
    {
        for (int col = 0; col < TAMANO; col++)
        {
            if (tablero[fila][col] == valor)
            {
                total++;
            }
        }
    }
    return total;
}

char AMayuscula(char letra)
{
    if (letra >= 'a' && letra <= 'z')
    {
        return letra - ('a' - 'A');
    }
    return letra;
}

bool InterpretarCasilla(string texto, int &fila, int &col)
{
    if (texto.length() != 2)
    {
        return false;
    }

    char letra = AMayuscula(texto[0]);
    char cifra = texto[1];
    char ultimaLetra = 'A' + (TAMANO - 1);

    if (letra < 'A' || letra > ultimaLetra)
    {
        return false;
    }
    if (cifra < '0' || cifra > '9')
    {
        return false;
    }

    col = letra - 'A';
    fila = cifra - '0';
    return true;
}

bool EsPosicionValida(int fila, int col)
{
    return fila >= 0 && fila < TAMANO && col >= 0 && col < TAMANO;
}

bool CabeBarco(bool flota[TAMANO][TAMANO], int fila, int col, int longitud, bool horizontal)
{
    for (int i = 0; i < longitud; i++)
    {
        int f = fila;
        int c = col;
        if (horizontal)
        {
            c = col + i;
        }
        else
        {
            f = fila + i;
        }
        if (!EsPosicionValida(f, c))
        {
            return false;
        }
        if (flota[f][c])
        {
            return false;
        }
    }
    return true;
}

void ColocarUnBarco(bool flota[TAMANO][TAMANO], char propio[TAMANO][TAMANO], int longitud)
{
    bool colocado = false;
    while (!colocado)
    {
        bool horizontal = (rand() % 2 == 0);
        int fila = rand() % TAMANO;
        int col = rand() % TAMANO;

        if (CabeBarco(flota, fila, col, longitud, horizontal))
        {
            for (int i = 0; i < longitud; i++)
            {
                int f = fila;
                int c = col;
                if (horizontal)
                {
                    c = col + i;
                }
                else
                {
                    f = fila + i;
                }
                flota[f][c] = true;
                propio[f][c] = BARCO;
            }
            colocado = true;
        }
    }
}

void ColocarBarcos(bool flota[TAMANO][TAMANO], char propio[TAMANO][TAMANO])
{
    for (int i = 0; i < NUM_BARCOS; i++)
    {
        ColocarUnBarco(flota, propio, LONGITUDES[i]);
    }
}

void PintarCaja(string texto)
{
    Write("[" + texto + "]");
}

void PintarTablero(char tablero[TAMANO][TAMANO])
{
    PintarCaja(" ");
    for (int col = 0; col < TAMANO; col++)
    {
        PintarCaja(string(1, (char)('A' + col)));
    }
    WriteLine("");

    for (int fila = 0; fila < TAMANO; fila++)
    {
        PintarCaja(to_string(fila));
        for (int col = 0; col < TAMANO; col++)
        {
            PintarCaja(string(1, tablero[fila][col]));
        }
        WriteLine("");
    }
    WriteLine("");
}

void PintarTurno(char ataque[TAMANO][TAMANO], char propio[TAMANO][TAMANO])
{
    WriteLine("¡TABLERO ENEMIGO!");
    PintarTablero(ataque);
    WriteLine("¡TABLERO PROPIO!");
    PintarTablero(propio);
}

int IntentarDisparo(char ataque[TAMANO][TAMANO], bool flotaRival[TAMANO][TAMANO], char propioRival[TAMANO][TAMANO])
{
    Write("Ataca => ");
    string casilla = ReadLine();

    int fila;
    int col;
    if (!InterpretarCasilla(casilla, fila, col) || !EsPosicionValida(fila, col))
    {
        WriteLine("Casilla no válida. Ejemplo: A7");
        return DISPARO_REINTENTAR;
    }
    if (ataque[fila][col] != VACIO)
    {
        WriteLine("Ya disparaste ahí.");
        return DISPARO_REINTENTAR;
    }

    if (flotaRival[fila][col])
    {
        ataque[fila][col] = TOCADO;
        propioRival[fila][col] = TOCADO;
        return DISPARO_TOCADO;
    }

    ataque[fila][col] = FALLO;
    propioRival[fila][col] = FALLO;
    WriteLine("Fallo.");
    return DISPARO_AGUA;
}

int JugarTurno(int jugador, char ataque[TAMANO][TAMANO], char propio[TAMANO][TAMANO],
               bool flotaRival[TAMANO][TAMANO], char propioRival[TAMANO][TAMANO])
{
    WriteLine("");
    WriteLine("Turno del jugador " + to_string(jugador) + ".");
    PintarTurno(ataque, propio);

    int resultado = IntentarDisparo(ataque, flotaRival, propioRival);
    if (resultado == DISPARO_REINTENTAR)
    {
        return DISPARO_REINTENTAR;
    }

    if (resultado == DISPARO_TOCADO)
    {
        WriteLine("¡Tocado!");
        if (ContarCasillas(ataque, TOCADO) == ContarCeldasBarco())
        {
            PintarTurno(ataque, propio);
            WriteLine("¡Gana el jugador " + to_string(jugador) + "!");
            return TURNO_GANADA;
        }
    }

    return TURNO_SEGUIR;
}

void JugarPartida()
{
    srand((unsigned int)time(0));
    WriteLine("¡Batalla naval a dos jugadores!");

    bool flotaJ1[TAMANO][TAMANO];
    bool flotaJ2[TAMANO][TAMANO];
    char propioJ1[TAMANO][TAMANO];
    char propioJ2[TAMANO][TAMANO];
    char ataqueJ1[TAMANO][TAMANO];
    char ataqueJ2[TAMANO][TAMANO];

    InicializarBool(flotaJ1);
    InicializarBool(flotaJ2);
    InicializarChar(propioJ1);
    InicializarChar(propioJ2);
    InicializarChar(ataqueJ1);
    InicializarChar(ataqueJ2);

    ColocarBarcos(flotaJ1, propioJ1);
    ColocarBarcos(flotaJ2, propioJ2);

    int turno = 1;
    bool terminada = false;

    while (!terminada)
    {
        int estado;
        if (turno == 1)
        {
            estado = JugarTurno(1, ataqueJ1, propioJ1, flotaJ2, propioJ2);
        }
        else
        {
            estado = JugarTurno(2, ataqueJ2, propioJ2, flotaJ1, propioJ1);
        }

        if (estado == DISPARO_REINTENTAR)
        {
            continue;
        }
        if (estado == TURNO_GANADA)
        {
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
