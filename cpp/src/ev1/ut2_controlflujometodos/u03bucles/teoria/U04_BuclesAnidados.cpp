/*
U04 — Bucles anidados: un bucle dentro de otro.

OBJETIVO:
  - Combinar for externo e interno para tablas y patrones.
  - Dibujar un triangulo de asteriscos con bucles anidados.
  - Generar una tabla de multiplicar completa (filas y columnas).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Tabla de multiplicar 3x3 (filas x columnas).
      Bucle externo = filas; bucle interno = columnas.
    */
    cout << "¡DEMO 1: TABLA 3x3!\n" << endl;

    for (int fila = 1; fila <= 3; fila++)
    {
        for (int col = 1; col <= 3; col++)
        {
            cout << fila << "x" << col << "=" << setw(3) << (fila * col) << "  ";
        }
        cout << endl;
    }

    /*
    SEGUNDA PARTE - Triangulo de asteriscos.
      Fila 1 imprime 1 *, fila 2 imprime 2 *, etc.
    */
    cout << "\n¡DEMO 2: TRIANGULO DE ASTERISCOS!\n" << endl;

    int altura = 5;
    for (int fila = 1; fila <= altura; fila++)
    {
        for (int estrella = 1; estrella <= fila; estrella++)
        {
            cout << "* ";
        }
        cout << endl;
    }

    /*
    TERCERA PARTE - Tabla de multiplicar del 1 al 5 (formato compacto).
    */
    cout << "\n¡DEMO 3: TABLA COMPLETA 1-5!\n" << endl;

    cout << "    |";
    for (int cab = 1; cab <= 5; cab++)
    {
        cout << setw(4) << cab;
    }
    cout << endl;
    cout << "----+----" << endl;

    for (int i = 1; i <= 5; i++)
    {
        cout << setw(3) << i << " |";
        for (int j = 1; j <= 5; j++)
        {
            cout << setw(4) << (i * j);
        }
        cout << endl;
    }

    /*
    CUARTA PARTE - Patron de numeros: cada fila repite su numero.
    */
    cout << "\n¡DEMO 4: PATRON NUMERICO!\n" << endl;

    for (int f = 1; f <= 4; f++)
    {
        for (int c = 1; c <= f; c++)
        {
            cout << f << " ";
        }
        cout << endl;
    }

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
