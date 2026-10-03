/*
U03 — Array dinamico new[] / delete[] (PDF + UT4 U08).

OBJETIVO:
  - int* arr = new int[n]; n se sabe en ejecucion.
  - delete[] arr; (con corchetes). arr = nullptr.
  - El array NO guarda n: llevas n a mano.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U03 new[] ===" << endl;
    cout << "1. Crear, rellenar, borrar" << endl;
    cout << "2. Errores del PDF (solo texto)" << endl;
    cout << "0. Salir" << endl;
}

void DemoArray()
{
    cout << "¡DEMO — new int[n]!\n" << endl;
    int n = 4;
    int* arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        arr[i] = i;
        cout << arr[i] << endl;
    }
    delete[] arr;
    arr = nullptr;
}

void DemoErrores()
{
    cout << "¡DEMO — Errores (no se ejecutan)!\n" << endl;
    cout << "1. Olvidar delete[]: fuga." << endl;
    cout << "2. delete dos veces el mismo bloque." << endl;
    cout << "3. f1 = f2 sin delete del primero: referencia perdida." << endl;
    cout << "4. Usar *p despues de delete p." << endl;
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
                DemoArray();
                break;
            case 2:
                DemoErrores();
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
