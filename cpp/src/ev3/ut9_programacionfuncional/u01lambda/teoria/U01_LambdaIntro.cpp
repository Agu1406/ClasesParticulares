/*
U01 — Introduccion a lambdas en C++17.

Una lambda es una funcion anonima: [captura](parametros) { cuerpo }.
Se pasa a algoritmos STL (sort, count_if, transform, accumulate) como predicado
o transformacion, sin escribir funtores con operator() a mano.

OBJETIVO:
  - Escribir lambdas []( ){ } y guardarlas en auto / std::function.
  - Contar con count_if y ordenar con sort + lambda.
  - Comparar bucle tradicional vs estilo funcional con <algorithm>.

En Java: (a, b) -> ..., Predicate / Function.
En C#: x => ..., Action / Func + LINQ.
En C++: []( ){ }, std::function, algoritmos STL.

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
    cout << "=== U01 Lambda: intro + count_if / sort ===" << endl;
    cout << "1. Contar pares (bucle vs count_if)" << endl;
    cout << "2. Sumar pares * 10 (bucle vs accumulate)" << endl;
    cout << "3. Lambda en auto / function y sort" << endl;
    cout << "0. Salir" << endl;
}

/*
PRIMERA PARTE — Contar pares: bucle vs count_if + lambda.
  Lista: 1,3,5,7,9,2,4,6,8 -> pares: 4.
*/
void DemoContarPares()
{
    cout << "¡DEMO — Contar pares!\n" << endl;
    vector<int> listaNumeros = {1, 3, 5, 7, 9, 2, 4, 6, 8};

    int totalTradicional = 0;
    for (int numero : listaNumeros)
    {
        if (numero % 2 == 0)
        {
            totalTradicional++;
        }
    }
    cout << "Tradicional: " << totalTradicional << " pares" << endl;

    int pares = count_if(listaNumeros.begin(), listaNumeros.end(),
                         [](int n) { return n % 2 == 0; });
    cout << "count_if + lambda: " << pares << " pares" << endl;
}

/*
SEGUNDA PARTE — Sumar (pares * 10): bucle vs accumulate con lambda.
*/
void DemoSumarParesPorDiez()
{
    cout << "¡DEMO — Sumar pares * 10!\n" << endl;
    vector<int> numeros = {1, 2, 3, 4, 5, 6, 7, 8};

    int resultadoImperativo = 0;
    for (int n : numeros)
    {
        if (n % 2 == 0)
        {
            resultadoImperativo += n * 10;
        }
    }
    cout << "Tradicional: " << resultadoImperativo << endl;

    int resultadoFuncional = accumulate(
        numeros.begin(), numeros.end(), 0,
        [](int acc, int n) { return (n % 2 == 0) ? acc + n * 10 : acc; });
    cout << "accumulate + lambda: " << resultadoFuncional << endl;
}

/*
TERCERA PARTE — auto / std::function y sort por longitud.
*/
void DemoLambdaYSort()
{
    cout << "¡DEMO — Lambda y sort!\n" << endl;

    auto saludo = []() { cout << "Hola desde lambda" << endl; };
    saludo();

    function<void(const string&)> imprimir = [](const string& texto) {
        cout << ">> " << texto << endl;
    };
    imprimir("Consumer / function de ejemplo");

    function<int(int, int)> multiplicar = [](int a, int b) { return a * b; };
    cout << "function(6,7) -> " << multiplicar(6, 7) << endl;

    vector<string> palabras = {"java", "lambda", "stream", "pf"};
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
                DemoContarPares();
                break;
            case 2:
                DemoSumarParesPorDiez();
                break;
            case 3:
                DemoLambdaYSort();
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
