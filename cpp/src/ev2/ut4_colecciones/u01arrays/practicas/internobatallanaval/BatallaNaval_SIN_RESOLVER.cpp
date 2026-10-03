/*
Practica interna: Batalla naval — SIN RESOLVER.

Hotseat 10x10 (al pintar 11x11: letras A-J arriba = columnas, numeros 0-9
a la izquierda = filas). Ataque tipo A7. Flota bool; ataque y propio char.
Barcos 5, 4, 3 y 2. Victoria: ContarCasillas(ataque, TOCADO) == ContarCeldasBarco().

Solucion: BatallaNaval_RESUELTO.cpp

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
    // TODO: 1 ↔ 2.
    (void)turno;
    return 0;
}

int ImprimirMenu()
{
    // TODO: ¡Menú del programa! + [1]/[2]/[0] + "Introduce una opción => " y return.
    return 0;
}

void MostrarObjetivo()
{
    // TODO: ejes A-J / 0-9, barcos 5-4-3-2, dos tableros por turno, victoria.
}

void InicializarBool(bool tablero[TAMANO][TAMANO])
{
    // TODO: todas las celdas a false.
    (void)tablero;
}

void InicializarChar(char tablero[TAMANO][TAMANO])
{
    // TODO: rellenar con VACIO.
    (void)tablero;
}

int ContarCeldasBarco()
{
    // TODO: sumar LONGITUDES.
    return 0;
}

int ContarCasillas(char tablero[TAMANO][TAMANO], char valor)
{
    // TODO: recorrer el tablero y contar coincidencias.
    (void)tablero;
    (void)valor;
    return 0;
}

char AMayuscula(char letra)
{
    // TODO: si es minuscula, pasar a mayuscula.
    (void)letra;
    return 'A';
}

bool InterpretarCasilla(string texto, int &fila, int &col)
{
    // TODO: length == 2; col = letra - 'A'; fila = cifra - '0'.
    (void)texto;
    (void)fila;
    (void)col;
    return false;
}

bool EsPosicionValida(int fila, int col)
{
    // TODO: 0 .. TAMANO-1.
    (void)fila;
    (void)col;
    return false;
}

bool CabeBarco(bool flota[TAMANO][TAMANO], int fila, int col, int longitud, bool horizontal)
{
    // TODO: false si se sale del tablero o si alguna celda ya tiene barco.
    (void)flota;
    (void)fila;
    (void)col;
    (void)longitud;
    (void)horizontal;
    return false;
}

void ColocarUnBarco(bool flota[TAMANO][TAMANO], char propio[TAMANO][TAMANO], int longitud)
{
    // TODO: H/V al azar; fila/col al azar en todo el array; si CabeBarco, colocar.
    (void)flota;
    (void)propio;
    (void)longitud;
}

void ColocarBarcos(bool flota[TAMANO][TAMANO], char propio[TAMANO][TAMANO])
{
    // TODO: para cada longitud, ColocarUnBarco.
    (void)flota;
    (void)propio;
}

void PintarCaja(string texto)
{
    // TODO: Write("[" + texto + "]");
    (void)texto;
}

void PintarTablero(char tablero[TAMANO][TAMANO])
{
    // TODO: esquina + letras A-J; cada fila: numero 0-9 + celdas.
    (void)tablero;
}

void PintarTurno(char ataque[TAMANO][TAMANO], char propio[TAMANO][TAMANO])
{
    // TODO: enemigo arriba, propio abajo.
    (void)ataque;
    (void)propio;
}

int IntentarDisparo(char ataque[TAMANO][TAMANO], bool flotaRival[TAMANO][TAMANO], char propioRival[TAMANO][TAMANO])
{
    // TODO: "Ataca => "; InterpretarCasilla; REINTENTAR / AGUA / TOCADO. Mensaje "Fallo."
    (void)ataque;
    (void)flotaRival;
    (void)propioRival;
    return DISPARO_REINTENTAR;
}

int JugarTurno(int jugador, char ataque[TAMANO][TAMANO], char propio[TAMANO][TAMANO],
               bool flotaRival[TAMANO][TAMANO], char propioRival[TAMANO][TAMANO])
{
    // TODO: PintarTurno → IntentarDisparo.
    // TODO: si TOCADO y ContarCasillas(ataque, TOCADO) == ContarCeldasBarco() → GANADA.
    (void)jugador;
    (void)ataque;
    (void)propio;
    (void)flotaRival;
    (void)propioRival;
    return DISPARO_REINTENTAR;
}

void JugarPartida()
{
    // TODO: srand, tableros, ColocarBarcos, bucle con JugarTurno(1/2, ...).
    // TODO: REINTENTAR → continue; GANADA → fin; si no, CambiarTurno.
}

int main()
{
    // TODO: do-while; ImprimirMenu(); 1 jugar, 2 objetivo, 0 salir.
    return 0;
}
