/*
OBJETIVO: Leer letras hasta q; w/s imprimen UP/DOWN; q imprime QUIT y sale.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    bool exitLoop = false;
    while (!exitLoop)
    {
        cout << "evento => ";
        string ev;
        cin >> ev;
        if (ev == "q")
        {
            cout << "QUIT" << endl;
            exitLoop = true;
        }
        else if (ev == "w")
        {
            cout << "UP" << endl;
        }
        else if (ev == "s")
        {
            cout << "DOWN" << endl;
        }
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
                EjecutarEjercicio();
                break;
            case 2:
                cout << "q=QUIT, w=UP, s=DOWN." << endl;
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
