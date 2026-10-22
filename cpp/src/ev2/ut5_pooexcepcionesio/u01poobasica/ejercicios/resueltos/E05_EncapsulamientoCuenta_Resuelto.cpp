/*
OBJETIVO: Clase CuentaBancaria con saldo privado; Depositar y Retirar; prueba operaciones.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class CuentaBancaria
{
private:
    double saldo;

public:
    CuentaBancaria(double saldoInicial)
    {
        if (saldoInicial >= 0)
        {
            saldo = saldoInicial;
        }
        else
        {
            saldo = 0;
        }
    }

    double GetSaldo() const
    {
        return saldo;
    }

    void Depositar(double cantidad)
    {
        if (cantidad > 0)
        {
            saldo += cantidad;
        }
    }

    bool Retirar(double cantidad)
    {
        if (cantidad <= 0)
        {
            return false;
        }
        if (cantidad > saldo)
        {
            return false;
        }
        saldo -= cantidad;
        return true;
    }
};

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    CuentaBancaria cuenta(100);
    cuenta.Depositar(50);
    cuenta.Retirar(30);
    cout << "Saldo: " << cuenta.GetSaldo() << " EUR" << endl;
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
                cout << "Clase CuentaBancaria con saldo privado; Depositar y Retirar; prueba operaciones." << endl;
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
