/*
U02 — Algoritmos STL: sort, count_if y find_if.

Los algoritmos de <algorithm> reciben iteradores y predicados (a menudo lambdas).
sort reordena; count_if cuenta; find_if busca el primer elemento que cumple.

OBJETIVO:
  - Ordenar con sort y un comparador lambda.
  - Contar con count_if.
  - Buscar con find_if y comprobar el iterador contra end().

En Java: stream().sorted().filter().findFirst().
En C#: OrderBy / Count / FirstOrDefault.
En C++: sort / count_if / find_if.

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
using namespace std;

void ImprimirMenu()
{
    cout << "=== U02 Algorithm: sort / count_if / find_if ===" << endl;
    cout << "1. sort con lambda" << endl;
    cout << "2. count_if (pares y largas)" << endl;
    cout << "3. find_if (primer elemento)" << endl;
    cout << "0. Salir" << endl;
}

/*
PRIMERA PARTE — sort: ordenar por longitud y por valor descendente.
*/
void DemoSort()
{
    cout << "¡DEMO — sort!\n" << endl;
    vector<string> palabras = {"stream", "java", "lambda", "pf"};

    sort(palabras.begin(), palabras.end(),
         [](const string& a, const string& b) { return a.size() < b.size(); });
    cout << "sort por longitud: ";
    for (size_t i = 0; i < palabras.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << palabras[i];
    }
    cout << endl;

    vector<int> numeros = {3, 10, 1, 8};
    sort(numeros.begin(), numeros.end(), [](int a, int b) { return a > b; });
    cout << "sort descendente: ";
    for (size_t i = 0; i < numeros.size(); i++)
    {
        if (i > 0)
        {
            cout << ", ";
        }
        cout << numeros[i];
    }
    cout << endl;
}

/*
SEGUNDA PARTE — count_if: cuantos cumplen el predicado.
*/
void DemoCountIf()
{
    cout << "¡DEMO — count_if!\n" << endl;
    vector<int> numeros = {1, 2, 3, 4, 5, 6, 7, 8};
    int pares = count_if(numeros.begin(), numeros.end(),
                         [](int n) { return n % 2 == 0; });
    cout << "Pares: " << pares << endl;

    vector<string> palabras = {"pf", "java", "lambda", "stream", "xilofono"};
    int largas = count_if(palabras.begin(), palabras.end(),
                          [](const string& p) { return p.size() > 4; });
    cout << "Palabras largas (>4): " << largas << endl;
}

/*
TERCERA PARTE — find_if: primer elemento que cumple (o end() si no hay).
*/
void DemoFindIf()
{
    cout << "¡DEMO — find_if!\n" << endl;
    vector<string> palabras = {"pf", "java", "lambda", "stream"};

    auto it = find_if(palabras.begin(), palabras.end(),
                      [](const string& p) { return p.size() > 4; });
    if (it != palabras.end())
    {
        cout << "Primera larga (>4): " << *it << endl;
    }
    else
    {
        cout << "No hay palabra larga." << endl;
    }

    auto itX = find_if(palabras.begin(), palabras.end(),
                       [](const string& p) { return !p.empty() && (p[0] == 'x' || p[0] == 'X'); });
    if (itX == palabras.end())
    {
        cout << "Ninguna empieza por x." << endl;
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
                DemoSort();
                break;
            case 2:
                DemoCountIf();
                break;
            case 3:
                DemoFindIf();
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
