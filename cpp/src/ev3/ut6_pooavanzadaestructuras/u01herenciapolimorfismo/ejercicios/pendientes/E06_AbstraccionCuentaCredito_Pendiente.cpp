/*
OBJETIVO: Anadir CuentaCredito (descubierto) y comparar Retirar con CuentaAhorro
  usando referencia/puntero Cuenta. Menu do-while.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E06 Abstraccion CuentaCredito ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "Cuenta abstracta; CuentaAhorro y CuentaCredito." << endl;
    cout << "Credito permite saldo negativo hasta limiteCredito." << endl;
    cout << "Crea ambas como vector<Cuenta*>; retira la misma cantidad y compara saldos." << endl;
}

void EjecutarEjercicio()
{
    // TODO: vector<Cuenta*> con ahorro y credito; Retirar(100) en cada una.
}

// TODO: Cuenta, CuentaAhorro, CuentaCredito.

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
                MostrarObjetivo();
                break;
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida. Intenta de nuevo." << endl;
                break;
        }

        cout << endl;
    } while (opcion != 0);

    return 0;
}
