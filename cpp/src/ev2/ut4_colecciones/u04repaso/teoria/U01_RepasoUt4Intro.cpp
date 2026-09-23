/*
U01 — Repaso UT4: arrays, listas, diccionarios y HashSet.

OBJETIVO:
  - Repasar operaciones basicas con array (suma, recorrido).
  - Usar List<T> para CRUD simple (Add, Remove, Count).
  - Consultar Dictionary con TryGetValue y recorrer pares.
  - Aplicar HashSet para eliminar duplicados en una coleccion.
  - Consolidar recorridos con foreach y llaves { }.

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

void DemoArray();

void DemoList();

void DemoDictionary();

void DemoHashSet();



void ImprimirMenu()
    {
        cout << "=== U01 Repaso UT4 ===" << endl;
        cout << "1. Array" << endl;
        cout << "2. List" << endl;
        cout << "3. Dictionary" << endl;
        cout << "4. HashSet" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Array: suma y recorrido.
    */
void DemoArray()
    {
        cout << "¡DEMO — Array!\n" << endl;

        vector<int> nums = { 1, 2, 3, 4, 5 };
        int suma = 0;

        for (int n : nums)
        {
            suma += n;
        }

        cout << "Array: 1, 2, 3, 4, 5" << endl;
        cout << "Suma: " << suma << endl;

        for (int i = 0; i < nums.size(); i++)
        {
            cout << "  nums[" << i << "] = " << nums[i] << endl;
        }
    }

/*
    SEGUNDA PARTE — List: agregar, eliminar, ordenar.
    */
void DemoList()
    {
        cout << "¡DEMO — List!\n" << endl;

        vector<string> nombres = new vector<string> { "Ana", "Luis" };
        nombres.push_back("Eva");
        nombres.push_back("Pedro");
        nombres.erase("Luis");

        cout << "Count tras Add y Remove: " << nombres.size() << endl;

        for (string nombre : nombres)
        {
            cout << "  " << nombre << endl;
        }
    }

/*
    TERCERA PARTE — Dictionary: notas por alumno.
    */
void DemoDictionary()
    {
        cout << "¡DEMO — Dictionary!\n" << endl;

        map<string, int> notas = new map<string, int>
        {
            { "Ana", 7 },
            { "Luis", 8 }
        };
        notas["Eva"] = 9;

        for (KeyValuePair<string, int> par : notas)
        {
            cout << "  " << par.first << ": " << par.second << endl;
        }

        if (notas.TryGetValue("Ana", out int notaAna))
        {
            cout << "Nota de Ana (TryGetValue): " << notaAna << endl;
        }
        else
        {
            cout << "Ana no tiene nota registrada." << endl;
        }
    }

/*
    CUARTA PARTE — HashSet: tags unicos sin repetir.
    */
void DemoHashSet()
    {
        cout << "¡DEMO — HashSet!\n" << endl;

        vector<string> tagsEntrada = { "csharp", "dotnet", "csharp", "ut4", "dotnet" };
        set<string> tagsUnicos = set<string>();

        for (string tag : tagsEntrada)
        {
            tagsUnicos.push_back(tag);
        }

        cout << "Tags recibidos: " << tagsEntrada.size() << endl;
        cout << "Tags unicos: " << tagsUnicos.size() << endl;

        for (string tag : tagsUnicos)
        {
            cout << "  #" << tag << endl;
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
                    DemoArray();
                    break;
                case 2:
                    DemoList();
                    break;
                case 3:
                    DemoDictionary();
                    break;
                case 4:
                    DemoHashSet();
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
