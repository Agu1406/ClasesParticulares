/*
U01 — Introduccion a List<T>.

OBJETIVO:
  - Crear una List<int> dinamica (crece al agregar elementos).
  - Agregar elementos con Add y consultar cuantos hay con Count.
  - Acceder por indice como en un array: lista[0], lista[1], etc.
  - Comparar List con array: tamano fijo vs tamano variable.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/



#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <fstream>
#include <sstream>
#include <regex>
#include <stdexcept>
#include <limits>
using namespace std;



void ImprimirMenu();

void DemoCrearYAdd();

void DemoAccesoPorIndice();

void DemoValoresIniciales();

void DemoModificarPorIndice();



void ImprimirMenu()
    {
        cout << "=== U01 Introduccion a List ===" << endl;
        cout << "1. Crear y Add" << endl;
        cout << "2. Acceso por indice" << endl;
        cout << "3. Lista con valores iniciales" << endl;
        cout << "4. Modificar por indice" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Crear lista vacia y agregar con Add.
      vector<int> numeros = vector<int>(); empieza sin elementos.
      numeros.push_back(10); inserta al final y la lista crece sola.
    */
void DemoCrearYAdd()
    {
        cout << "¡DEMO — Crear y Add!\n" << endl;

        vector<int> numeros = vector<int>();
        numeros.push_back(10);
        numeros.push_back(20);
        numeros.push_back(30);

        cout << "Elementos agregados: 10, 20, 30" << endl;
        cout << "Count despues de Add: " << numeros.size() << endl;
    }

/*
    SEGUNDA PARTE — Acceso por indice (igual que array).
      Los indices empiezan en 0. Count indica cuantos elementos hay.
    */
void DemoAccesoPorIndice()
    {
        cout << "¡DEMO — Acceso por indice!\n" << endl;

        vector<int> numeros = vector<int>();
        numeros.push_back(10);
        numeros.push_back(20);
        numeros.push_back(30);

        cout << "numeros[0] = " << numeros[0] << endl;
        cout << "numeros[1] = " << numeros[1] << endl;
        cout << "numeros[2] = " << numeros[2] << endl;

        for (int i = 0; i < numeros.size(); i++)
        {
            cout << "  Posicion " << i << ": " << numeros[i] << endl;
        }
    }

/*
    TERCERA PARTE — Inicializacion con valores y mas Add.
      Se puede crear con elementos iniciales: new vector<int> { 1, 2, 3 }.
    */
void DemoValoresIniciales()
    {
        cout << "¡DEMO — Lista con valores iniciales!\n" << endl;

        vector<string> nombres = new vector<string> { "Ana", "Luis" };

        cout << "Count inicial: " << nombres.size() << endl;

        nombres.push_back("Eva");
        nombres.push_back("Pedro");

        cout << "Count tras Add: " << nombres.size() << endl;

        for (string nombre : nombres)
        {
            cout << "  Nombre: " << nombre << endl;
        }
    }

/*
    CUARTA PARTE — Modificar por indice.
      lista[indice] = valor; reemplaza el elemento en esa posicion.
    */
void DemoModificarPorIndice()
    {
        cout << "¡DEMO — Modificar por indice!\n" << endl;

        vector<int> numeros = vector<int>();
        numeros.push_back(10);
        numeros.push_back(20);
        numeros.push_back(30);

        numeros[1] = 99;
        cout << "numeros[1] cambiado a 99" << endl;

        for (int i = 0; i < numeros.size(); i++)
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
