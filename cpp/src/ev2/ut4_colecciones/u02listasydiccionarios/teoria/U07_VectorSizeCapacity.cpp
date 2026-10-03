/*
U07 — size, capacity y el VectorOfDoubles del PDF.

OBJETIVO:
  - Distinguir size() (elementos usados) de capacity() (huecos reservados).
  - push_back / pop_back como en el PDF (VectorOfDoubles).
  - Insertar y borrar en una posicion desplazando (shift), sin iteradores.
  - vector(5) crea 5 celdas a 0; at(i) lee con comprobacion (el PDF lo usa
    en excepciones: v.at(10) lanza out_of_range).
  - Vector2D del PDF de POO NO es esto: es una clase con x e y.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

void ImprimirLista(vector<int> lista)
{
    cout << "size() = " << lista.size() << "  capacity() = " << lista.capacity() << endl;
    for (int i = 0; i < (int)lista.size(); i++)
    {
        cout << "  [" << i << "] = " << lista[i] << endl;
    }
}

void ImprimirMenu()
{
    cout << "=== U07 size, capacity, insertar y borrar ===" << endl;
    cout << "1. vector(n), empty, at" << endl;
    cout << "2. size vs capacity (crece al push_back)" << endl;
    cout << "3. pop_back" << endl;
    cout << "4. Insertar desplazando (shift derecha)" << endl;
    cout << "5. Borrar desplazando (shift izquierda)" << endl;
    cout << "0. Salir" << endl;
}

void DemoCrearAt()
{
    cout << "¡DEMO — vector(n) y at()!\n" << endl;

    vector<int> v(5);
    cout << "vector<int> v(5) crea 5 ceros. empty()? ";
    if (v.empty())
    {
        cout << "si" << endl;
    }
    else
    {
        cout << "no" << endl;
    }

    v[0] = 10;
    v[1] = 20;
    cout << "v[0]  = " << v[0] << endl;
    cout << "v.at(1) = " << v.at(1) << endl;
    cout << "v.at(i) comprueba el indice. Si te sales, lanza excepcion." << endl;
}

void DemoCapacity()
{
    cout << "¡DEMO — size vs capacity!\n" << endl;

    vector<int> nums;
    cout << "Al crear: size=" << nums.size() << " capacity=" << nums.capacity() << endl;

    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(3);
    cout << "Tras 3 push_back: size=" << nums.size() << " capacity=" << nums.capacity() << endl;

    nums.push_back(4);
    nums.push_back(5);
    nums.push_back(6);
    cout << "Tras 6 push_back: size=" << nums.size() << " capacity=" << nums.capacity() << endl;
    cout << "Cuando size == capacity, el vector pide un bloque mas grande (reallocate del PDF)." << endl;
}

void DemoPopBack()
{
    cout << "¡DEMO — pop_back!\n" << endl;

    vector<int> nums = {10, 20, 30};
    ImprimirLista(nums);

    nums.pop_back();
    cout << "Tras pop_back (quita el ultimo):" << endl;
    ImprimirLista(nums);
}

void DemoInsertar()
{
    cout << "¡DEMO — insertar en la posicion 1 (desplaza a la derecha)!\n" << endl;

    vector<int> nums = {10, 20, 30};
    ImprimirLista(nums);

    int posicion = 1;
    int valor = 99;
    nums.push_back(0);
    for (int i = (int)nums.size() - 1; i > posicion; i--)
    {
        nums[i] = nums[i - 1];
    }
    nums[posicion] = valor;

    cout << "Tras insertar 99 en [1]:" << endl;
    ImprimirLista(nums);
}

void DemoBorrar()
{
    cout << "¡DEMO — borrar la posicion 1 (desplaza a la izquierda)!\n" << endl;

    vector<int> nums = {10, 99, 20, 30};
    ImprimirLista(nums);

    int posicion = 1;
    for (int i = posicion; i < (int)nums.size() - 1; i++)
    {
        nums[i] = nums[i + 1];
    }
    nums.pop_back();

    cout << "Tras borrar [1]:" << endl;
    ImprimirLista(nums);
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
                DemoCrearAt();
                break;
            case 2:
                DemoCapacity();
                break;
            case 3:
                DemoPopBack();
                break;
            case 4:
                DemoInsertar();
                break;
            case 5:
                DemoBorrar();
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
