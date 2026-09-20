/*
U02 — Funciones con return: devolver un valor al llamador.

OBJETIVO:
  - Declarar funciones que devuelven int, double, bool, string, etc.
  - Usar return para entregar el resultado y salir de la funcion.
  - Guardar el valor devuelto en variables o usarlo en expresiones.

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

double AreaCirculo(double radio)
{
    const double PI = 3.141592653589793;
    return PI * radio * radio;
}

bool EsPar(int n)
{
    return n % 2 == 0;
}

string ObtenerCalificacion(int nota)
{
    if (nota >= 9)
    {
        return "Sobresaliente";
    }
    if (nota >= 7)
    {
        return "Notable";
    }
    if (nota >= 5)
    {
        return "Aprobado";
    }
    return "Suspenso";
}

int Doble(int n)
{
    return n * 2;
}

int Triple(int n)
{
    return n * 3;
}

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Funcion que devuelve int.
    */
    cout << "¡DEMO 1: SUMAR!\n" << endl;
    int total = Sumar(3, 4);
    cout << "3 + 4 = " << total << endl;
    cout << "10 + 2 = " << Sumar(10, 2) << endl;

    /*
    SEGUNDA PARTE - Funcion que devuelve double.
    */
    cout << "\n¡DEMO 2: AREA DE CIRCULO!\n" << endl;
    double radio = 5.0;
    double area = AreaCirculo(radio);
    cout << "Radio " << radio << " -> area = " << fixed << setprecision(2) << area << endl;

    /*
    TERCERA PARTE - Funcion que devuelve bool y string.
    */
    cout << "\n¡DEMO 3: ES PAR Y CALIFICACION!\n" << endl;
    int numero = 14;
    cout << boolalpha;
    cout << "¿" << numero << " es par? " << EsPar(numero) << endl;

    int nota = 8;
    cout << "Nota " << nota << " -> " << ObtenerCalificacion(nota) << endl;

    /*
    CUARTA PARTE - Usar el return directamente en una expresion.
    */
    cout << "\n¡DEMO 4: DOBLE Y TRIPLE!\n" << endl;
    int x = 7;
    cout << "Doble de " << x << " = " << Doble(x) << ", triple = " << Triple(x) << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
