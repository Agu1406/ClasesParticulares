/*
U03 — transform y accumulate.

transform proyecta cada elemento (map); accumulate reduce una secuencia a un valor
(suma, producto, concatenacion...). Ambos aceptan lambdas como operacion.

OBJETIVO:
  - Usar transform para longitudes / mayusculas.
  - Usar accumulate para sumar y reducir.
  - Encadenar ideas: filtrar (copy_if) + transformar + acumular.

En Java: map / reduce.
En C#: Select / Aggregate / Sum.
En C++: transform / accumulate (+ copy_if).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <functional>
#include <numeric>
#include <iterator>
#include <cctype>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U03 Transform / Accumulate ===" << endl;
    cout << "1. transform (map)" << endl;
    cout << "2. accumulate (reduce)" << endl;
    cout << "3. copy_if + transform + accumulate" << endl;
    cout << "0. Salir" << endl;
}

/*
PRIMERA PARTE — transform: proyectar a otro tipo / forma.
*/
void DemoTransform()
{
    cout << "¡DEMO — transform!\n" << endl;
    vector<string> palabras = {"sol", "programacion", "pf"};

    vector<int> longitudes(palabras.size());
    transform(palabras.begin(), palabras.end(), longitudes.begin(),
              [](const string& p) { return static_cast<int>(p.size()); });
    cout << "Longitudes: ";
    for (size_t i = 0; i < longitudes.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << longitudes[i];
    }
    cout << endl;

    vector<string> mayus = palabras;
    transform(mayus.begin(), mayus.end(), mayus.begin(), [](string p) {
        transform(p.begin(), p.end(), p.begin(),
                  [](unsigned char c) { return static_cast<char>(toupper(c)); });
        return p;
    });
    cout << "Mayusculas: ";
    for (size_t i = 0; i < mayus.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << mayus[i];
    }
    cout << endl;
}

/*
SEGUNDA PARTE — accumulate: reducir a un valor.
*/
void DemoAccumulate()
{
    cout << "¡DEMO — accumulate!\n" << endl;
    vector<int> numeros = {1, 2, 3, 4, 5};

    int suma = accumulate(numeros.begin(), numeros.end(), 0);
    cout << "Suma: " << suma << endl;

    int producto = accumulate(numeros.begin(), numeros.end(), 1,
                              [](int acc, int n) { return acc * n; });
    cout << "Producto: " << producto << endl;

    vector<string> partes = {"pro", "gra", "ma"};
    string juntar = accumulate(partes.begin(), partes.end(), string(""),
                               [](const string& acc, const string& p) { return acc + p; });
    cout << "Concat: " << juntar << endl;
}

/*
TERCERA PARTE — copy_if (filtrar) + transform + accumulate.
*/
void DemoEncadenar()
{
    cout << "¡DEMO — copy_if + transform + accumulate!\n" << endl;
    vector<int> fuente = {1, 2, 3, 4, 5, 6, 7, 8};

    vector<int> pares;
    copy_if(fuente.begin(), fuente.end(), back_inserter(pares),
            [](int n) { return n % 2 == 0; });

    vector<int> porDiez(pares.size());
    transform(pares.begin(), pares.end(), porDiez.begin(),
              [](int n) { return n * 10; });

    sort(porDiez.begin(), porDiez.end());
    int total = accumulate(porDiez.begin(), porDiez.end(), 0);

    cout << "Pares*10 ordenados: ";
    for (size_t i = 0; i < porDiez.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << porDiez[i];
    }
    cout << endl;
    cout << "Suma: " << total << endl;
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
                DemoTransform();
                break;
            case 2:
                DemoAccumulate();
                break;
            case 3:
                DemoEncadenar();
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
