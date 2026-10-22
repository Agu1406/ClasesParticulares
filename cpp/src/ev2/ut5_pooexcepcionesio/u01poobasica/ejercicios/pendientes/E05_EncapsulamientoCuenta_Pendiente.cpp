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
    // TODO: atributo privado saldo (double)
public:
    // TODO: constructor CuentaBancaria(double saldoInicial)
    // TODO: getter GetSaldo (solo lectura)
    // TODO: metodo Depositar(double cantidad): suma si cantidad > 0
    // TODO: metodo Retirar(double cantidad): resta si hay saldo suficiente y cantidad > 0
};

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Trabajar ejercicio" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    // TODO: crea una cuenta con 100 EUR
    // TODO: deposita 50 y retira 30
    // TODO: muestra el saldo final con GetSaldo (debe ser 120)
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
