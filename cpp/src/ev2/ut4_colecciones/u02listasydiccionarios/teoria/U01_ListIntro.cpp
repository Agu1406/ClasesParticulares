/*
U01 — Introduccion a vector (la List de C++).

OBJETIVO:
  - Entender que vector<int> es un array dinamico: crece al agregar.
  - En C#/Java se llama List; en C++ el equivalente junior es vector.
    std::list es otra cosa (lista enlazada, sin [i]): se ve en U06.
  - Agregar con push_back y consultar cuantos hay con size().
  - Acceder por indice como en un array: lista[0], lista[1], etc.
  - size vs capacity, at(), pop_back e insertar/borrar: U07 de esta unidad.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U01 Introduccion a vector ===" << endl;
    cout << "1. Crear y push_back" << endl;
    cout << "2. Acceso por indice" << endl;
    cout << "3. Vector con valores iniciales" << endl;
    cout << "4. Modificar por indice" << endl;
    cout << "0. Salir" << endl;
}

void DemoCrearYAdd()
{
    cout << "¡DEMO — Crear y push_back!\n" << endl;

    vector<int> numeros;
    numeros.push_back(10);
    numeros.push_back(20);
    numeros.push_back(30);

    cout << "Elementos agregados: 10, 20, 30" << endl;
    cout << "size() despues de push_back: " << numeros.size() << endl;
}

void DemoAccesoPorIndice()
{
    cout << "¡DEMO — Acceso por indice!\n" << endl;

    vector<int> numeros;
    numeros.push_back(10);
    numeros.push_back(20);
    numeros.push_back(30);

    cout << "numeros[0] = " << numeros[0] << endl;
    cout << "numeros[1] = " << numeros[1] << endl;
    cout << "numeros[2] = " << numeros[2] << endl;

    for (int i = 0; i < (int)numeros.size(); i++)
    {
        cout << "  Posicion " << i << ": " << numeros[i] << endl;
    }
}

void DemoValoresIniciales()
{
    cout << "¡DEMO — Vector con valores iniciales!\n" << endl;

    vector<string> nombres = { "Ana", "Luis" };

    cout << "size() inicial: " << nombres.size() << endl;

    nombres.push_back("Eva");
    nombres.push_back("Pedro");

    cout << "size() tras push_back: " << nombres.size() << endl;

    for (string nombre : nombres)
    {
        cout << "  Nombre: " << nombre << endl;
    }
}

void DemoModificarPorIndice()
{
    cout << "¡DEMO — Modificar por indice!\n" << endl;

    vector<int> numeros;
    numeros.push_back(10);
    numeros.push_back(20);
    numeros.push_back(30);

    numeros[1] = 99;
    cout << "numeros[1] cambiado a 99" << endl;

    for (int i = 0; i < (int)numeros.size(); i++)
    {
        cout << "  numeros[" << i << "] = " << numeros[i] << endl;
    }
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
                DemoCrearYAdd();
                break;
            case 2:
                DemoAccesoPorIndice();
                break;
            case 3:
                DemoValoresIniciales();
                break;
            case 4:
                DemoModificarPorIndice();
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
