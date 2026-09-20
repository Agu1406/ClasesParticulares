/*
U03 — Parametros: pasar datos a una funcion.

OBJETIVO:
  - Definir funciones con uno o varios parametros tipados.
  - Pasar valores concretos al llamar (argumentos).
  - Reutilizar la misma logica con distintos datos de entrada.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

void MostrarMensaje(string texto, int veces)
{
    for (int i = 0; i < veces; i++)
    {
        cout << "  [" << (i + 1) << "] " << texto << endl;
    }
}

int AreaRectangulo(int baseRect, int altura)
{
    return baseRect * altura;
}

int PerimetroCuadrado(int lado)
{
    return 4 * lado;
}

void PresentarPersona(string nombre, int edad, double altura)
{
    cout << "  " << nombre << ": " << edad << " años, " << altura << " m" << endl;
}

double CalcularPrecioConIva(double baseImponible, double porcentajeIva)
{
    return baseImponible * (1 + porcentajeIva / 100.0);
}

int main() {
    cout << "\n¡INICIO DEL PROGRAMA!\n" << endl;

    /*
    PRIMERA PARTE - Parametros en funcion void.
    */
    cout << "¡DEMO 1: REPETIR MENSAJE!\n" << endl;
    MostrarMensaje("C++ es genial", 3);
    MostrarMensaje("Fin de demo", 1);

    /*
    SEGUNDA PARTE - Parametros en funcion con return.
    */
    cout << "\n¡DEMO 2: AREA Y PERIMETRO!\n" << endl;
    cout << "Rectangulo 5x3 -> area = " << AreaRectangulo(5, 3) << endl;
    cout << "Cuadrado lado 4 -> perimetro = " << PerimetroCuadrado(4) << endl;

    /*
    TERCERA PARTE - Varios parametros de distinto tipo.
    */
    cout << "\n¡DEMO 3: PRESENTAR PERSONA!\n" << endl;
    PresentarPersona("Agustin", 26, 1.76);
    PresentarPersona("Eduardo", 29, 1.74);

    /*
    CUARTA PARTE - Parametros usados en calculos compuestos.
    */
    cout << "\n¡DEMO 4: PRECIO CON IVA!\n" << endl;
    double precio1 = CalcularPrecioConIva(100, 21);
    double precio2 = CalcularPrecioConIva(49.99, 10);
    cout << fixed << setprecision(2);
    cout << "100 + 21% IVA = " << precio1 << " euros" << endl;
    cout << "49,99 + 10% IVA = " << precio2 << " euros" << endl;

    cout << "\n¡FIN DEL PROGRAMA!\n" << endl;
    return 0;
}
