/*
U04 — Recorrer un map.

OBJETIVO:
  - Recorrer cada par con range-for: par.first (clave) y par.second (valor).
  - Recorrer solo claves o solo valores.
  - Usar if dentro del recorrido (aprobados / suspensos).

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <map>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U04 Recorridos map ===" << endl;
    cout << "1. Recorrer pares clave-valor" << endl;
    cout << "2. Solo claves" << endl;
    cout << "3. Solo valores" << endl;
    cout << "4. Logica en el recorrido" << endl;
    cout << "5. Resumen" << endl;
    cout << "0. Salir" << endl;
}

map<string, int> CrearNotas()
{
    map<string, int> notas;
    notas["Matematicas"] = 7;
    notas["Lengua"] = 8;
    notas["Historia"] = 6;
    return notas;
}

void DemoPares()
{
    cout << "¡DEMO — Pares first / second!\n" << endl;

    map<string, int> notas = CrearNotas();
    for (pair<string, int> par : notas)
    {
        cout << "  " << par.first << " -> " << par.second << endl;
    }
}

void DemoSoloClaves()
{
    cout << "¡DEMO — Solo claves!\n" << endl;

    map<string, int> notas = CrearNotas();
    for (pair<string, int> par : notas)
    {
        cout << "  Asignatura: " << par.first << endl;
    }
}

void DemoSoloValores()
{
    cout << "¡DEMO — Solo valores!\n" << endl;

    map<string, int> notas = CrearNotas();
    for (pair<string, int> par : notas)
    {
        cout << "  Nota: " << par.second << endl;
    }
}

void DemoLogicaRecorrido()
{
    cout << "¡DEMO — Logica en el recorrido!\n" << endl;

    map<string, int> notas = CrearNotas();
    int aprobados = 0;

    for (pair<string, int> par : notas)
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

void DemoResumen()
{
    cout << "¡DEMO — Resumen!\n" << endl;

    map<string, int> notas = CrearNotas();
    for (pair<string, int> par : notas)
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
                DemoPares();
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
                DemoResumen();
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
