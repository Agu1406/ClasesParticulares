/*
U03 — Limpieza tras try/catch (en C++ NO hay finally).

En C# existe finally. En C++ junior el codigo que va DESPUES del
try/catch se ejecuta igual (si no haces return). Los ficheros se cierran
solos al destruirse ofstream (RAII).

OBJETIVO:
  - Ver codigo de limpieza tras un error capturado.
  - Ver la misma limpieza cuando try termina bien.
  - Entender que ofstream se cierra al salir del bloque.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <fstream>
#include <stdexcept>
using namespace std;

void ImprimirMenu()
{
    cout << "=== U03 Limpieza (sin finally) ===" << endl;
    cout << "1. Limpieza tras error" << endl;
    cout << "2. Limpieza sin error" << endl;
    cout << "3. ofstream se cierra solo" << endl;
    cout << "0. Salir" << endl;
}

void DemoLimpiezaTrasError()
{
    cout << "¡DEMO — Limpieza tras error!\n" << endl;

    try
    {
        cout << "Entrando en try..." << endl;
        throw runtime_error("Division entre cero (simulada).");
    }
    catch (const runtime_error& e)
    {
        cout << "catch: " << e.what() << endl;
    }

    cout << "Despues del try/catch: siempre se ejecuta (tras error)." << endl;
}

void DemoLimpiezaSinError()
{
    cout << "¡DEMO — Limpieza sin error!\n" << endl;

    try
    {
        cout << "Entrando en try sin fallos..." << endl;
        int suma = 5 + 3;
        cout << "Suma correcta: " << suma << endl;
    }
    catch (const exception& e)
    {
        cout << e.what() << endl;
    }

    cout << "Despues del try/catch: siempre se ejecuta (sin error)." << endl;
}

void DemoCierreFichero()
{
    cout << "¡DEMO — ofstream se cierra solo!\n" << endl;

    bool operacionOk = false;
    try
    {
        ofstream f("demo_u03.txt");
        f << "dato " << stoi("42") << endl;
        operacionOk = true;
        cout << "Operacion OK. Al salir del try, f se destruye y cierra el fichero." << endl;
    }
    catch (const exception&)
    {
        cout << "No se pudo completar la operacion." << endl;
    }

    if (operacionOk)
    {
        cout << "Limpieza: todo fue bien." << endl;
    }
    else
    {
        cout << "Limpieza: hubo fallo." << endl;
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
                DemoLimpiezaTrasError();
                break;
            case 2:
                DemoLimpiezaSinError();
                break;
            case 3:
                DemoCierreFichero();
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
