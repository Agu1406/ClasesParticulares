/*
OBJETIVO: Dos objetos Punto independientes; cambia uno y verifica que el otro no cambia.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class Punto
{
    int x;
    int y;

public:
    Punto()
    {
        x = 0;
        y = 0;
    }

    Punto(int xInicial, int yInicial)
    {
        x = xInicial;
        y = yInicial;
    }

    int getX() const
    {
        return x;
    }

    int getY() const
    {
        return y;
    }

    void setX(int nuevoX)
    {
        x = nuevoX;
    }

    void setY(int nuevoY)
    {
        y = nuevoY;
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
    Punto p1;
    Punto p2;

    cout << "Antes -> p1.x=" << p1.getX() << ", p2.x=" << p2.getX() << endl;

    p1.setX(10);

    cout << "Despues de p1.setX(10) -> p1.x=" << p1.getX()
         << ", p2.x=" << p2.getX() << endl;
    cout << "Cambiar p1 no afecta a p2: cada objeto tiene su propio estado." << endl;
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
                cout << "Dos Punto independientes: cambia uno y el otro no cambia." << endl;
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
