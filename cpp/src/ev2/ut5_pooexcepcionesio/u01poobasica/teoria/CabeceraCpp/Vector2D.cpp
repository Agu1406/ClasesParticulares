/*
CabeceraCpp — Implementacion.

Aqui va el CODIGO de los metodos declarados en Vector2D.h.
En clase junior se compila este unico .cpp (incluye el .h).
En un proyecto real: g++ Main.cpp Vector2D.cpp

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include "Vector2D.h"

Vector2D::Vector2D() : x(0), y(0) {}

Vector2D::Vector2D(double x, double y) : x(x), y(y) {}

double Vector2D::getX() const
{
    return x;
}

double Vector2D::getY() const
{
    return y;
}

ostream& operator<<(ostream& os, const Vector2D& v)
{
    os << "(" << v.x << "," << v.y << ")";
    return os;
}

void ImprimirMenu()
{
    cout << "=== Cabecera .h y .cpp ===" << endl;
    cout << "1. Que va en cada fichero" << endl;
    cout << "2. Include guards" << endl;
    cout << "3. Usar la clase (implementacion en el .cpp)" << endl;
    cout << "0. Salir" << endl;
}

void DemoFicheros()
{
    cout << "¡DEMO — Separacion!\n" << endl;
    cout << "Vector2D.h  : class Vector2D { declaraciones };" << endl;
    cout << "Vector2D.cpp: #include \"Vector2D.h\" y el codigo de los metodos." << endl;
    cout << "Compila este Vector2D.cpp (un solo fichero, regla junior)." << endl;
}

void DemoGuards()
{
    cout << "¡DEMO — #ifndef!\n" << endl;
    cout << "#ifndef VECTOR2D_H_" << endl;
    cout << "#define VECTOR2D_H_" << endl;
    cout << "  ... class ..." << endl;
    cout << "#endif" << endl;
    cout << "Si dos .cpp incluyen el mismo .h, el compilador no duplica la clase." << endl;
}

void DemoUsarClase()
{
    cout << "¡DEMO — Objeto creado con el .h + .cpp!\n" << endl;
    Vector2D a;
    Vector2D b(3, 4);
    cout << "a (ctor vacio) = " << a << endl;
    cout << "b (3, 4) = " << b << "  getX=" << b.getX() << " getY=" << b.getY() << endl;
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
                DemoFicheros();
                break;
            case 2:
                DemoGuards();
                break;
            case 3:
                DemoUsarClase();
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
