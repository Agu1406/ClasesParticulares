/*
OBJETIVO: Usar VectorOfDoubles: 3 push_back y imprimir size() == 3.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class VectorOfDoubles
{
    size_t cap;
    size_t n;
    double* e;
public:
    VectorOfDoubles() : cap(5), n(0), e(new double[5]) {}
    ~VectorOfDoubles() { delete[] e; }
    size_t size() const { return n; }
    void push_back(double v)
    {
        if (n < cap)
        {
            e[n] = v;
            n++;
        }
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
    VectorOfDoubles v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(3);
    cout << v.size() << endl;
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
                cout << "3 push_back; size 3." << endl;
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
