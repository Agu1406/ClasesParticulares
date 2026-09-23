/*
OBJETIVO: abstract class Cuenta con Depositar concreto y Retirar abstracto;
  CuentaAhorro con limite diario. Menu do-while.

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
    cout << "=== E05 Abstraccion CuentaAhorro ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void MostrarObjetivo()
{
    cout << "class Cuenta: titular, saldo, Depositar, Retirar() = 0." << endl;
    cout << "CuentaAhorro: limite de retiro diario; sin saldo negativo." << endl;
    cout << "Crea una CuentaAhorro, deposita y retira; muestra el saldo." << endl;
}

void EjecutarEjercicio()
{
    // TODO: Crear CuentaAhorro; Depositar y Retirar; mostrar saldo.
}

// TODO: class Cuenta { virtual void Retirar(double) = 0; };
// TODO: class CuentaAhorro : public Cuenta;

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
