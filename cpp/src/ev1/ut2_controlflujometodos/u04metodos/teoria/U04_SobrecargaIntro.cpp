/*
U04 — Sobrecarga de funciones (overload): mismo nombre, distintos parametros.

OBJETIVO:
  - Definir varias funciones con el mismo nombre y diferente firma.
  - Diferenciar por numero o tipo de parametros.
  - Dejar que el compilador elija la version correcta al llamar.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int Sumar(int a, int b)
{
    return a + b;
}

double Sumar(double a, double b)
{
    return a + b;
}

int Sumar(int a, int b, int c)
{
    return a + b + c;
}

void Mostrar(string texto)
{
    cout << "  [texto] " << texto << endl;
}

void Mostrar(int numero)
{
    cout << "  [entero] " << numero << endl;
}

void Mostrar(double valor, int decimales)
{
    cout << "  [decimal] " << fixed << setprecision(decimales) << valor << endl;
}

int Area(int lado)
{
    return lado * lado;
}

int Area(int baseRect, int altura)
{
    return baseRect * altura;
}

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Sumar con int y con double.
      El compilador elige segun el tipo de los argumentos.
    */
    cout << "¡DEMO 1: SUMAR INT Y DOUBLE!\n" << endl;
    cout << "Sumar(2, 3)       = " << Sumar(2, 3) << endl;
    cout << "Sumar(1.5, 2.5)   = " << Sumar(1.5, 2.5) << endl;

    /*
    SEGUNDA PARTE - Tres parametros vs dos.
    */
    cout << "\n¡DEMO 2: SUMAR DOS O TRES NUMEROS!\n" << endl;
    cout << "Sumar(1, 2, 3)    = " << Sumar(1, 2, 3) << endl;
    cout << "Sumar(10, 20)     = " << Sumar(10, 20) << endl;

    /*
    TERCERA PARTE - Mostrar con distintos tipos.
    */
    cout << "\n¡DEMO 3: MOSTRAR SOBRECARGADO!\n" << endl;
    Mostrar("Hola mundo");
    Mostrar(42);
    Mostrar(3.14, 2);  // double con decimales a mostrar

    /*
    CUARTA PARTE - Area: cuadrado (1 param) vs rectangulo (2 params).
    */
    cout << "\n¡DEMO 4: AREA SOBRECARGADA!\n" << endl;
    cout << "Area cuadrado (5)      = " << Area(5) << endl;
    cout << "Area rectangulo (4, 6) = " << Area(4, 6) << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
