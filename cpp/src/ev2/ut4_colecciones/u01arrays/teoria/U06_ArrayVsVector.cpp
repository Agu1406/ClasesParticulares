/*
U06 — Del array fijo al vector (puente hacia u02).

OBJETIVO:
  - Recordar: int notas[3] tiene tamano fijo. No se puede "anadir un 4.o".
  - Ver vector<int> como un array que SI crece: push_back y size().
  - Acceder igual: notas[0], bucle for con i < size().
  - No sustituye al array: el array sigue siendo el modelo de indices (u01).
    El vector es la List de C#/Java. Se trabaja en u02.

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
    cout << "=== U06 Array vs vector ===" << endl;
    cout << "1. Array fijo (no crece)" << endl;
    cout << "2. vector que crece con push_back" << endl;
    cout << "3. Mismo acceso por indice" << endl;
    cout << "4. Cuando usar cada uno" << endl;
    cout << "0. Salir" << endl;
}

void DemoArrayFijo()
{
    cout << "¡DEMO — Array fijo!\n" << endl;

    int notas[3] = {7, 8, 9};
    const int N = 3;

    cout << "Tenemos exactamente " << N << " notas." << endl;
    for (int i = 0; i < N; i++)
    {
        cout << "  notas[" << i << "] = " << notas[i] << endl;
    }

    cout << "No hay notas[3]. El tamano 3 se escribio en el codigo." << endl;
}

void DemoVectorCrece()
{
    cout << "¡DEMO — vector que crece!\n" << endl;

    vector<int> notas;
    cout << "Al crear: size() = " << notas.size() << endl;

    notas.push_back(7);
    notas.push_back(8);
    notas.push_back(9);
    cout << "Tras 3 push_back: size() = " << notas.size() << endl;

    notas.push_back(10);
    cout << "Tras otro push_back: size() = " << notas.size() << endl;
    cout << "El cuarto valor cabe porque el vector crece solo." << endl;
}

void DemoMismoIndice()
{
    cout << "¡DEMO — Mismo acceso por indice!\n" << endl;

    int fijo[3] = {7, 8, 9};
    vector<int> dinamico;
    dinamico.push_back(7);
    dinamico.push_back(8);
    dinamico.push_back(9);

    cout << "Array  fijo[0]     = " << fijo[0] << endl;
    cout << "vector dinamico[0] = " << dinamico[0] << endl;
    cout << "Los indices empiezan en 0 en los dos." << endl;
}

void DemoCuandoUsar()
{
    cout << "¡DEMO — Lo que ve el alumno en el PDF de Intro C++!\n" << endl;
    cout << "1. Array estatico:   int datos[5];     tamano fijo, pila, SIN size()." << endl;
    cout << "2. array de la STL:  array<int,5>      tamano fijo, SI tiene size() (U07)." << endl;
    cout << "3. Array dinamico:   new int[n];       tamano en ejecucion, delete[] (U08)." << endl;
    cout << "4. vector:           vector<int>       crece solo (u02). Es la List de C#." << endl;
    cout << endl;
    cout << "Ojo: Vector2D del PDF de POO es una CLASE (x, y), no una coleccion." << endl;
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
                DemoArrayFijo();
                break;
            case 2:
                DemoVectorCrece();
                break;
            case 3:
                DemoMismoIndice();
                break;
            case 4:
                DemoCuandoUsar();
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
