/*
U08 — Arrays dinamicos (new[] / delete[] del PDF).

OBJETIVO:
  - Crear un array cuyo tamano se sabe en EJECUCION: int* arr = new int[n];
  - Recorrerlo con [i] igual que el array de la pila.
  - Liberar con delete[] arr; y poner arr = nullptr;
  - Ver que el array NO guarda n: hay que llevar el tamano a mano.
  - Diferencia: esto es el heap. vector (u02) hace new/delete por ti.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U08 Arrays dinamicos ===" << endl;
    cout << "1. new int[n] y delete[]" << endl;
    cout << "2. El tamano se pide al usuario" << endl;
    cout << "3. Hay que llevar n a mano" << endl;
    cout << "4. Por que existe vector" << endl;
    cout << "0. Salir" << endl;
}

void DemoNewDelete()
{
    cout << "¡DEMO — new[] y delete[]!\n" << endl;

    int n = 5;
    int* arr = new int[n];

    for (int i = 0; i < n; i++)
    {
        arr[i] = i;
    }

    for (int i = 0; i < n; i++)
    {
        cout << "  arr[" << i << "] = " << arr[i] << endl;
    }

    delete[] arr;
    arr = nullptr;
    cout << "Memoria liberada. arr = nullptr." << endl;
}

void DemoTamanoUsuario()
{
    cout << "¡DEMO — Tamano en ejecucion!\n" << endl;
    cout << "Cuantos enteros (1-10) => ";
    int n;
    cin >> n;
    if (n < 1)
    {
        n = 1;
    }
    if (n > 10)
    {
        n = 10;
    }

    int* arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        arr[i] = (i + 1) * 10;
        cout << "  arr[" << i << "] = " << arr[i] << endl;
    }

    delete[] arr;
    arr = nullptr;
}

void DemoSinLongitud()
{
    cout << "¡DEMO — El array no guarda n!\n" << endl;
    cout << "int* arr = new int[n];" << endl;
    cout << "arr no sabe si n era 5 o 50. Tu variable n es la longitud." << endl;
    cout << "Si pierdes n, no puedes recorrer ni hacer delete[] con seguridad de uso." << endl;
}

void DemoPorQueVector()
{
    cout << "¡DEMO — Por que existe vector!\n" << endl;
    cout << "new[] obliga a: pedir n, recorrer, delete[], nullptr." << endl;
    cout << "Si se te olvida delete[], hay fuga de memoria (el PDF lo marca)." << endl;
    cout << "vector hace eso por dentro y ademas CRECE (push_back)." << endl;
    cout << "En el PDF de POO, VectorOfDoubles es un vector casero: capacity, elems, reallocate." << endl;
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
                DemoNewDelete();
                break;
            case 2:
                DemoTamanoUsuario();
                break;
            case 3:
                DemoSinLongitud();
                break;
            case 4:
                DemoPorQueVector();
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
