/*
U05 — Introduccion a set (el HashSet de C++).

OBJETIVO:
  - Crear set<string> para elementos unicos (sin duplicados).
  - Agregar con insert y preguntar con count().
  - Ver que insertar un valor repetido no aumenta size().
  - Recorrer el conjunto con range-for.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
#include <set>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U05 Introduccion a set ===" << endl;
    cout << "1. insert en set" << endl;
    cout << "2. Sin duplicados" << endl;
    cout << "3. count (pertenencia)" << endl;
    cout << "4. Recorrido y emails unicos" << endl;
    cout << "0. Salir" << endl;
}

void DemoAdd()
{
    cout << "¡DEMO — insert en set!\n" << endl;

    set<string> colores;
    colores.insert("Rojo");
    colores.insert("Verde");
    colores.insert("Azul");

    cout << "Agregados: Rojo, Verde, Azul" << endl;
    cout << "size(): " << colores.size() << endl;
}

void DemoSinDuplicados()
{
    cout << "¡DEMO — Sin duplicados!\n" << endl;

    set<string> colores;
    colores.insert("Rojo");
    colores.insert("Verde");
    colores.insert("Azul");

    int antes = (int)colores.size();
    colores.insert("Rojo");
    cout << "insert(\"Rojo\") otra vez. size() sigue siendo " << colores.size();
    cout << " (antes era " << antes << ")." << endl;

    colores.insert("Amarillo");
    cout << "insert(\"Amarillo\"). size() ahora: " << colores.size() << endl;
}

void DemoContains()
{
    cout << "¡DEMO — count!\n" << endl;

    set<string> colores;
    colores.insert("Rojo");
    colores.insert("Verde");
    colores.insert("Azul");

    if (colores.count("Verde") == 1)
    {
        cout << "Contiene Verde: si" << endl;
    }
    else
    {
        cout << "Contiene Verde: no" << endl;
    }

    if (colores.count("Negro") == 1)
    {
        cout << "Contiene Negro: si" << endl;
    }
    else
    {
        cout << "Contiene Negro: no" << endl;
    }

    if (colores.count("Azul") == 1)
    {
        cout << "Azul esta en el conjunto." << endl;
    }
    else
    {
        cout << "Azul no esta." << endl;
    }
}

void DemoRecorridoYEmails()
{
    cout << "¡DEMO — Recorrido y emails unicos!\n" << endl;

    set<string> colores;
    colores.insert("Rojo");
    colores.insert("Verde");
    colores.insert("Azul");
    colores.insert("Amarillo");

    cout << "Colores en el set:" << endl;
    for (string c : colores)
    {
        cout << "  " << c << endl;
    }

    set<string> emailsUnicos;
    vector<string> emailsRecibidos = { "a@mail.com", "b@mail.com", "a@mail.com", "c@mail.com", "b@mail.com" };

    for (string email : emailsRecibidos)
    {
        emailsUnicos.insert(email);
    }

    cout << endl;
    cout << "Emails recibidos: " << emailsRecibidos.size() << endl;
    cout << "Emails unicos: " << emailsUnicos.size() << endl;

    for (string email : emailsUnicos)
    {
        cout << "  " << email << endl;
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
                DemoAdd();
                break;
            case 2:
                DemoSinDuplicados();
                break;
            case 3:
                DemoContains();
                break;
            case 4:
                DemoRecorridoYEmails();
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
