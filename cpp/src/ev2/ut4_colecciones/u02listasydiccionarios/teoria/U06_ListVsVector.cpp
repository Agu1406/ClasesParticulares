/*
U06 — vector vs list.

OBJETIVO:
  - Distinguir vector (array dinamico, SI tiene [i]) de list (lista enlazada).
  - En C#/Java, List es como vector. En C++, list es OTRA plantilla.
  - Ver que list se recorre con range-for, pero list[0] no compila.
  - Quedarse con vector para el dia a dia junior.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <list>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U06 vector vs list ===" << endl;
    cout << "1. vector: push_back y [i]" << endl;
    cout << "2. list: push_back, sin [i]" << endl;
    cout << "3. Recorrer las dos igual (range-for)" << endl;
    cout << "4. Cual usar" << endl;
    cout << "0. Salir" << endl;
}

void DemoVector()
{
    cout << "¡DEMO — vector!\n" << endl;

    vector<int> numeros;
    numeros.push_back(10);
    numeros.push_back(20);
    numeros.push_back(30);

    cout << "numeros[0] = " << numeros[0] << endl;
    cout << "numeros[2] = " << numeros[2] << endl;
    cout << "size() = " << numeros.size() << endl;
}

void DemoList()
{
    cout << "¡DEMO — list!\n" << endl;

    list<int> numeros;
    numeros.push_back(10);
    numeros.push_back(20);
    numeros.push_back(30);

    cout << "size() = " << numeros.size() << endl;
    cout << "list NO tiene numeros[0]. Si lo escribes, no compila." << endl;
    cout << "Para leer, se recorre:" << endl;
    for (int n : numeros)
    {
        cout << "  " << n << endl;
    }
}

void DemoRecorridoIgual()
{
    cout << "¡DEMO — Mismo range-for!\n" << endl;

    vector<string> conVector = { "Ana", "Luis" };
    list<string> conList;
    conList.push_back("Ana");
    conList.push_back("Luis");

    cout << "vector:" << endl;
    for (string nombre : conVector)
    {
        cout << "  " << nombre << endl;
    }

    cout << "list:" << endl;
    for (string nombre : conList)
    {
        cout << "  " << nombre << endl;
    }
}

void DemoCualUsar()
{
    cout << "¡DEMO — Cual usar!\n" << endl;
    cout << "vector  = List de C#/Java. Indices, crece, es lo habitual." << endl;
    cout << "list    = nodos enlazados. Bien para insertar/borrar en medio;" << endl;
    cout << "          mal si quieres notas[2]. En esta unidad casi no se usa." << endl;
    cout << "map     = Dictionary (clave -> valor)." << endl;
    cout << "set     = HashSet (unicos)." << endl;
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
                DemoVector();
                break;
            case 2:
                DemoList();
                break;
            case 3:
                DemoRecorridoIgual();
                break;
            case 4:
                DemoCualUsar();
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
