/*
U03 — Referencias (&) como parametros.

OBJETIVO:
  - int& es un alias: no es una copia.
  - Parametro de salida: void divEntera(..., int& c, int& r);
  - const Fecha& para no copiar ni modificar (PDF: entrada de tipo no basico).
  - En C# seria out / ref. Aqui NO se pone & al llamar (a diferencia de C).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

struct Fecha
{
    int dia;
    int mes;
    int anio;
};

void Cuadrado(int& num)
{
    num = num * num;
}

void DivEntera(int D, int d, int& c, int& r)
{
    c = D / d;
    r = D % d;
}

void EscribirFecha(const Fecha& fecha)
{
    cout << fecha.dia << "/" << fecha.mes << "/" << fecha.anio << endl;
}

void ImprimirMenu()
{
    cout << "=== U03 Referencias ===" << endl;
    cout << "1. Entrada/salida (cuadrado)" << endl;
    cout << "2. Dos salidas (division entera)" << endl;
    cout << "3. const& (no copia el struct)" << endl;
    cout << "0. Salir" << endl;
}

void DemoCuadrado()
{
    cout << "¡DEMO — int&!\n" << endl;
    int c = 13;
    Cuadrado(c);
    cout << "13 al cuadrado: " << c << endl;
}

void DemoDivision()
{
    cout << "¡DEMO — dos referencias!\n" << endl;
    int c;
    int r;
    DivEntera(20, 13, c, r);
    cout << "20 / 13 = " << c << " resto " << r << endl;
}

void DemoConstRef()
{
    cout << "¡DEMO — const Fecha&!\n" << endl;
    Fecha f = {2, 1, 2019};
    EscribirFecha(f);
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
                DemoCuadrado();
                break;
            case 2:
                DemoDivision();
                break;
            case 3:
                DemoConstRef();
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
