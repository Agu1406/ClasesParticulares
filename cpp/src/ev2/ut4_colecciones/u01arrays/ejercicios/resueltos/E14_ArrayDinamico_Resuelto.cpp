/*
OBJETIVO: Pedir n, crear int* arr = new int[n], rellenar 0..n-1, imprimir y delete[].

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Pedir n, new int[n], rellenar 0..n-1, imprimir y delete[]." << endl;
}

void EjecutarEjercicio()
{
    cout << "n => ";
    int n;
    cin >> n;
    if (n < 1)
    {
        n = 1;
    }

    int* arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        arr[i] = i;
        cout << arr[i] << endl;
    }

    delete[] arr;
    arr = nullptr;
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
                MostrarObjetivo();
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
