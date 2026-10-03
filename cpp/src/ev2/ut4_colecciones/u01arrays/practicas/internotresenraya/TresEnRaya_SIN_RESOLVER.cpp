/*
Practica interna: Tres en raya — SIN RESOLVER.

Objetivo: tres en raya en char[3][3]. Dos jugadores (1 = X, 2 = O).
Pintar el tablero al inicio de cada turno y luego pedir la casilla.
Menu do-while, opcion 0 para salir. DRY: menu, E/S y cambio de turno
en funciones.

Solucion: TresEnRaya_RESUELTO.cpp

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
    // TODO: linea en blanco, ¡Menú del programa! + [1]/[2]/[0]
    // + "Introduce una opción => " y return ReadInt().
    return 0;
}

void MostrarObjetivo()
{
    // TODO: explicar tablero, fichas, victoria y empate.
}

char FichaDelTurno(int turno)
{
    // TODO: 1 → 'X', 2 → 'O'.
    (void)turno;
    return VACIO;
}

int CambiarTurno(int turno)
{
    // TODO: 1 ↔ 2 (devuelve el nuevo turno, no uses referencia).
    (void)turno;
    return 0;
}

void InicializarTablero(char tablero[3][3])
{
    // TODO: rellenar con VACIO.
    (void)tablero;
}

void PintarCaja(string texto)
{
    // TODO: Write("[" + texto + "]");
    (void)texto;
}

void PintarTablero(char tablero[3][3])
{
    // TODO: cabecera de columnas y filas con indice + casillas.
    (void)tablero;
}

bool HayGanador(char tablero[3][3], char ficha)
{
    // TODO: filas, columnas y diagonales.
    (void)tablero;
    (void)ficha;
    return false;
}

bool TableroLleno(char tablero[3][3])
{
    // TODO: true si no queda VACIO.
    (void)tablero;
    return false;
}

int PedirIndice(string mensaje)
{
    // TODO: Write(mensaje) + ReadInt().
    (void)mensaje;
    return 0;
}

void JugarPartida()
{
    // TODO: bucle de turnos; pintar → pedir casilla → colocar → ganar/empate/CambiarTurno.
}

int main()
{
    // TODO: do-while; ImprimirMenu(); 1 jugar, 2 objetivo, 0 salir.
    return 0;
}
