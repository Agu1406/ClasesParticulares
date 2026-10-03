/*
U03 — Introduccion a map (el Dictionary de C++).

OBJETIVO:
  - Crear map<string, int> para pares clave-valor.
  - Escribir y leer con el indexador: edades["Ana"] = 20;
  - Comprobar si existe la clave con count() (0 o 1) antes de leer.
  - En C#/Java es Dictionary; aqui map. Las claves no se repiten.

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
    cout << "=== U03 Introduccion a map ===" << endl;
    cout << "1. Crear y escribir claves" << endl;
    cout << "2. Indexador [clave]" << endl;
    cout << "3. Consulta segura con count" << endl;
    cout << "4. count antes de leer" << endl;
    cout << "0. Salir" << endl;
}

void DemoAddYCreacion()
{
    cout << "¡DEMO — Crear y escribir!\n" << endl;

    map<string, int> edades;
    edades["Ana"] = 20;
    edades["Luis"] = 25;

    cout << "Entradas: Ana->20, Luis->25" << endl;
    cout << "size(): " << edades.size() << endl;
}

void DemoIndexador()
{
    cout << "¡DEMO — Indexador [clave]!\n" << endl;

    map<string, int> edades;
    edades["Ana"] = 20;
    edades["Luis"] = 25;

    edades["Eva"] = 22;
    edades["Luis"] = 26;

    cout << "Edad de Ana: " << edades["Ana"] << endl;
    cout << "Edad de Luis (actualizada): " << edades["Luis"] << endl;
    cout << "Edad de Eva: " << edades["Eva"] << endl;
}

void DemoConsultaSegura()
{
    cout << "¡DEMO — count antes de leer!\n" << endl;

    map<string, int> edades;
    edades["Ana"] = 20;
    edades["Luis"] = 25;
    edades["Eva"] = 22;

    if (edades.count("Pedro") == 1)
    {
        cout << "Pedro tiene " << edades["Pedro"] << " anos." << endl;
    }
    else
    {
        cout << "Pedro no esta en el diccionario." << endl;
    }

    if (edades.count("Ana") == 1)
    {
        cout << "Ana tiene " << edades["Ana"] << " anos." << endl;
    }
    else
    {
        cout << "Ana no esta en el diccionario." << endl;
    }
}

void DemoContainsKey()
{
    cout << "¡DEMO — count (existe / no existe)!\n" << endl;

    map<string, int> edades;
    edades["Ana"] = 20;
    edades["Eva"] = 22;

    string clave = "Eva";
    if (edades.count(clave) == 1)
    {
        cout << clave << " -> " << edades[clave] << endl;
    }
    else
    {
        cout << "Clave " << clave << " no existe." << endl;
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
                DemoAddYCreacion();
                break;
            case 2:
                DemoIndexador();
                break;
            case 3:
                DemoConsultaSegura();
                break;
            case 4:
                DemoContainsKey();
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
