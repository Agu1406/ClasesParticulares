/*
U05 — Recorridos utiles sobre arrays.

OBJETIVO:
  - Calcular la suma de todos los elementos de un array.
  - Encontrar el valor maximo recorriendo el array.
  - Buscar un valor concreto y saber si existe.
  - Usar llaves { } en if, for y range-for dentro de los recorridos.
  - Practicar funciones + main + menu do-while (EV1).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U05 Recorridos utiles ===" << endl;
    cout << "1. Suma de elementos" << endl;
    cout << "2. Valor maximo" << endl;
    cout << "3. Buscar un valor" << endl;
    cout << "4. Recorrido combinado" << endl;
    cout << "0. Salir" << endl;
}

void DemoSuma()
{
    cout << "¡DEMO — Suma de elementos!\n" << endl;
    const int N = 5;
    int datos[N] = {4, 9, 2, 7, 5};
    int suma = 0;

    for (int n : datos)
    {
        suma += n;
    }

    cout << "Array: 4, 9, 2, 7, 5" << endl;
    cout << "Suma total: " << suma << endl;
    cout << "Media: " << (suma / (double)N) << endl;
}

void DemoMaximo()
{
    cout << "¡DEMO — Valor maximo!\n" << endl;
    const int N = 5;
    int datos[N] = {4, 9, 2, 7, 5};
    int maximo = datos[0];

    for (int i = 0; i < N; i++)
    {
        if (datos[i] > maximo)
        {
            maximo = datos[i];
        }
    }

    cout << "Maximo encontrado: " << maximo << endl;
}

void DemoBuscar()
{
    cout << "¡DEMO — Buscar valor!\n" << endl;
    const int N = 5;
    int datos[N] = {4, 9, 2, 7, 5};
    int buscado = 7;
    bool encontrado = false;
    int posicionEncontrada = -1;

    for (int i = 0; i < N; i++)
    {
        if (datos[i] == buscado)
        {
            encontrado = true;
            posicionEncontrada = i;
        }
    }

    if (encontrado)
    {
        cout << "El valor " << buscado << " esta en la posicion " << posicionEncontrada << endl;
    }
    else
    {
        cout << "El valor " << buscado << " no esta en el array" << endl;
    }

    int otroBuscado = 99;
    encontrado = false;
    for (int n : datos)
    {
        if (n == otroBuscado)
        {
            encontrado = true;
        }
    }

    if (encontrado)
    {
        cout << "El valor " << otroBuscado << " existe." << endl;
    }
    else
    {
        cout << "El valor " << otroBuscado << " no existe." << endl;
    }
}

void DemoCombinado()
{
    cout << "¡DEMO — Recorrido combinado!\n" << endl;
    const int N = 5;
    int datos[N] = {4, 9, 2, 7, 5};
    int buscadoCombinado = 2;
    int suma = 0;
    int maximo = datos[0];
    bool encontrado = false;

    for (int i = 0; i < N; i++)
    {
        suma += datos[i];

        if (datos[i] > maximo)
        {
            maximo = datos[i];
        }

        if (datos[i] == buscadoCombinado)
        {
            encontrado = true;
        }
    }

    cout << "Suma: " << suma << " | Max: " << maximo << " | Contiene " << buscadoCombinado << ": ";
    if (encontrado)
    {
        cout << "si" << endl;
    }
    else
    {
        cout << "no" << endl;
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
                DemoSuma();
                break;
            case 2:
                DemoMaximo();
                break;
            case 3:
                DemoBuscar();
                break;
            case 4:
                DemoCombinado();
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
