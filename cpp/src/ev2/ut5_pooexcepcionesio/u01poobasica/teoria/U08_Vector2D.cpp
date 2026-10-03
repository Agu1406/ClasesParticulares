/*
U08 — Vector2D (PDF POO). NO es std::vector.

OBJETIVO:
  - Clase con x, y (matematica 2D, videojuegos).
  - getX, getY, normalize, operator+, operator* (escalar y producto).
  - Instancias EN LA PILA: Vector2D a(1, 1); sin new.
  - operator<< para imprimir (x,y).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <cmath>
using namespace std;

class Vector2D
{
private:
    double x;
    double y;

public:
    Vector2D() : x(0), y(0) {}
    Vector2D(double x, double y) : x(x), y(y) {}

    double getX() const { return x; }
    double getY() const { return y; }

    void normalize()
    {
        double mag = sqrt(x * x + y * y);
        if (mag > 0.0)
        {
            x = x / mag;
            y = y / mag;
        }
    }

    Vector2D operator+(const Vector2D& v) const
    {
        return Vector2D(x + v.x, y + v.y);
    }

    Vector2D operator*(double d) const
    {
        return Vector2D(x * d, y * d);
    }

    double operator*(const Vector2D& v) const
    {
        return x * v.x + y * v.y;
    }

    friend ostream& operator<<(ostream& os, const Vector2D& v);
};

ostream& operator<<(ostream& os, const Vector2D& v)
{
    os << "(" << v.x << "," << v.y << ")";
    return os;
}

void ImprimirMenu()
{
    cout << "=== U08 Vector2D ===" << endl;
    cout << "1. Suma y escalar" << endl;
    cout << "2. Producto escalar y normalize" << endl;
    cout << "0. Salir" << endl;
}

void DemoSuma()
{
    cout << "¡DEMO — Suma!\n" << endl;
    Vector2D a(1, 1);
    Vector2D b(2, 2);
    a = a * 2;
    Vector2D c = a + b;
    cout << "a = " << a << endl;
    cout << "c = a + b = " << c << endl;
}

void DemoProducto()
{
    cout << "¡DEMO — Producto y normalize!\n" << endl;
    Vector2D a(2, 2);
    Vector2D b(2, 2);
    cout << "a * b = " << (a * b) << endl;
    Vector2D c = a + b;
    c.normalize();
    cout << "normalize(a+b) = " << c << endl;
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
                DemoSuma();
                break;
            case 2:
                DemoProducto();
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
