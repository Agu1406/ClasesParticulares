/*
U04 — Recorrer un Dictionary.

OBJETIVO:
  - Iterar con foreach sobre KeyValuePair<TKey, TValue>.
  - Mostrar cada par clave -> valor en consola.
  - Recorrer solo claves (Keys) o solo valores (Values).
  - Usar llaves { } en todos los foreach.

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

map<string, int> CrearNotas();

void DemoKeyValuePair();

void DemoSoloClaves();

void DemoSoloValores();

void DemoLogicaRecorrido();

void DemoResumenVar();



void ImprimirMenu()
    {
        cout << "=== U04 Recorridos Dictionary ===" << endl;
        cout << "1. foreach KeyValuePair" << endl;
        cout << "2. Solo claves (Keys)" << endl;
        cout << "3. Solo valores (Values)" << endl;
        cout << "4. Logica en el recorrido" << endl;
        cout << "5. Resumen con var" << endl;
        cout << "0. Salir" << endl;
    }

map<string, int> CrearNotas()
    {
        return new map<string, int>
        {
            { "Matematicas", 7 },
            { "Lengua", 8 },
            { "Historia", 6 }
        };
    }

/*
    PRIMERA PARTE — foreach sobre KeyValuePair.
      Cada elemento es un par: par.first (asignatura) y par.second (nota).
    */
void DemoKeyValuePair()
    {
        cout << "¡DEMO — foreach KeyValuePair!\n" << endl;

        map<string, int> notas = CrearNotas();

        for (KeyValuePair<string, int> par : notas)
        {
            cout << "  " << par.first << " -> " << par.second << endl;
        }
    }

/*
    SEGUNDA PARTE — Recorrer solo claves con notas.Keys.
      Util cuando necesitas listar nombres sin el valor asociado.
    */
void DemoSoloClaves()
    {
        cout << "¡DEMO — Solo claves (Keys)!\n" << endl;

        map<string, int> notas = CrearNotas();

        for (string asignatura : notas.Keys)
        {
            cout << "  Asignatura: " << asignatura << endl;
        }
    }

/*
    TERCERA PARTE — Recorrer solo valores con notas.Values.
      Los valores pueden repetirse; las claves no.
    */
void DemoSoloValores()
    {
        cout << "¡DEMO — Solo valores (Values)!\n" << endl;

        map<string, int> notas = CrearNotas();

        for (int nota : notas.Values)
        {
            cout << "  Nota: " << nota << endl;
        }
    }

/*
    CUARTA PARTE — Recorrido con logica: contar aprobados y mostrar suspensos.
    */
void DemoLogicaRecorrido()
    {
        cout << "¡DEMO — Logica en el recorrido!\n" << endl;

        map<string, int> notas = CrearNotas();
        int aprobados = 0;

        for (KeyValuePair<string, int> par : notas)
        {
            if (par.second >= 5)
            {
                aprobados++;
                cout << "  Aprobado: " << par.first << " (" << par.second << ")" << endl;
            }
            else
            {
                cout << "  Suspenso: " << par.first << " (" << par.second << ")" << endl;
            }
        }

        cout << "Total aprobados: " << aprobados << endl;
    }

/*
    QUINTA PARTE — Desestructuracion en foreach (var par).
    */
void DemoResumenVar()
    {
        cout << "¡DEMO — Resumen ordenado!\n" << endl;

        map<string, int> notas = CrearNotas();

        for (var par : notas)
        {
            cout << "  [" << par.first << "] = " << par.second << endl;
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
                    DemoKeyValuePair();
                    break;
                case 2:
                    DemoSoloClaves();
                    break;
                case 3:
                    DemoSoloValores();
                    break;
                case 4:
                    DemoLogicaRecorrido();
                    break;
                case 5:
                    DemoResumenVar();
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
