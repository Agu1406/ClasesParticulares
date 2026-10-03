/*
U09 — VectorOfDoubles (el "vector" casero del PDF POO).

OBJETIVO:
  - capacity, numElems, double* elems (new[]).
  - push_back, pop_back, operator[], size, empty.
  - reallocate: cuando esta lleno, capacidad * 2 y copiar.
  - ~VectorOfDoubles hace delete[].
  - NO copies el objeto (v2 = v1): el PDF avisa de copia superficial.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class VectorOfDoubles
{
private:
    static constexpr size_t DEFAULT_CAPACITY = 5;
    size_t capacity;
    size_t numElems;
    double* elems;

    void reallocate()
    {
        capacity = capacity * 2;
        double* nuevos = new double[capacity];
        for (size_t i = 0; i < numElems; i++)
        {
            nuevos[i] = elems[i];
        }
        delete[] elems;
        elems = nuevos;
    }

public:
    VectorOfDoubles() : capacity(DEFAULT_CAPACITY), numElems(0), elems(new double[capacity]) {}

    ~VectorOfDoubles()
    {
        delete[] elems;
        numElems = 0;
        elems = nullptr;
    }

    size_t size() const { return numElems; }
    bool empty() const { return numElems == 0; }

    double operator[](int i) const { return elems[i]; }
    double& operator[](int i) { return elems[i]; }

    void push_back(double e)
    {
        if (numElems == capacity)
        {
            reallocate();
        }
        elems[numElems] = e;
        numElems++;
    }

    void pop_back()
    {
        if (numElems > 0)
        {
            numElems--;
        }
    }
};

void ImprimirMenu()
{
    cout << "=== U09 VectorOfDoubles ===" << endl;
    cout << "1. push_back y size" << endl;
    cout << "2. Crecer mas alla de 5 (reallocate)" << endl;
    cout << "3. pop_back y []" << endl;
    cout << "0. Salir" << endl;
}

void DemoPush()
{
    cout << "¡DEMO — push_back!\n" << endl;
    VectorOfDoubles v;
    v.push_back(1.5);
    v.push_back(2.5);
    cout << "size = " << v.size() << endl;
    cout << "v[0] = " << v[0] << endl;
}

void DemoCrece()
{
    cout << "¡DEMO — reallocate!\n" << endl;
    VectorOfDoubles v;
    for (int i = 0; i < 6; i++)
    {
        v.push_back(i);
    }
    cout << "6 push_back (capacidad inicial 5). size = " << v.size() << endl;
    cout << "v[5] = " << v[5] << endl;
}

void DemoPop()
{
    cout << "¡DEMO — pop_back!\n" << endl;
    VectorOfDoubles v;
    v.push_back(10);
    v.push_back(20);
    v.pop_back();
    cout << "size = " << v.size() << " (quedo el 10)" << endl;
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
                DemoPush();
                break;
            case 2:
                DemoCrece();
                break;
            case 3:
                DemoPop();
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
