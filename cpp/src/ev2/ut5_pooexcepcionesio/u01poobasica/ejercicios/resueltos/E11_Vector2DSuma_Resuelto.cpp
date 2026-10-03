/*
OBJETIVO: Vector2D a(1,0) y b(0,1); c = a+b; imprimir getX y getY (1 y 1).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class Vector2D
{
    double x;
    double y;
public:
    Vector2D(double x, double y) : x(x), y(y) {}
    double getX() const { return x; }
    double getY() const { return y; }
    Vector2D operator+(const Vector2D& v) const
    {
        return Vector2D(x + v.x, y + v.y);
    }
};

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    Vector2D a(1, 0);
    Vector2D b(0, 1);
    Vector2D c = a + b;
    cout << c.getX() << " " << c.getY() << endl;
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
                EjecutarEjercicio();
                break;
            case 2:
                cout << "a(1,0)+b(0,1) -> 1 1." << endl;
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
