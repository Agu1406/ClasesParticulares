/*
U01 — Repaso general EV1: UT1 variables y UT2 control de flujo.

OBJETIVO:
  - Repasar tipos basicos, operadores y estructuras de control en un solo programa.
  - Conectar variables (UT1) con if, bucles y funciones (UT2).
  - Servir como mapa mental antes del repaso practico de la unidad.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

int Doble(int n)
{
    return n * 2;
}

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - UT1: variables y tipos basicos.
    */
    cout << "¡UT1: VARIABLES Y TIPOS!\n" << endl;

    string nombre = "Agustin";
    int edad = 26;
    double altura = 1.76;
    bool activo = true;
    cout << boolalpha;
    cout << nombre << ", " << edad << " años, " << altura << " m, activo=" << activo << endl;

    /*
    SEGUNDA PARTE - UT2 u01: operadores aritmeticos y compuestos.
    */
    cout << "\n¡UT2 u01: OPERADORES!\n" << endl;

    int a = 10, b = 3;
    cout << a << "+" << b << "=" << (a + b) << " | " << a << "/" << b << " entera=" << (a / b) << " | " << a << "%" << b << "=" << (a % b) << endl;
    int x = 5;
    x += 3;
    x++;
    cout << "Tras x+=3 y x++: x=" << x << endl;

    /*
    TERCERA PARTE - UT2 u02-u03: condicionales y bucles.
    */
    cout << "\n¡UT2 u02-u03: IF Y FOR!\n" << endl;

    if (edad >= 18)
    {
        cout << "Mayor de edad" << endl;
    }

    cout << "Conteo 1-5: ";
    for (int i = 1; i <= 5; i++)
    {
        cout << i << " ";
    }
    cout << endl;

    /*
    CUARTA PARTE - UT2 u04: idea de funcion.
      En archivos de funciones definimos las funciones fuera de main.
    */
    cout << "\n¡UT2 u04: FUNCIONES!\n" << endl;
    cout << "Doble de 7 = " << Doble(7) << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
