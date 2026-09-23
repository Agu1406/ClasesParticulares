/*
U06 — Encapsulacion (introduccion).

Encapsular es ocultar datos sensibles (private) y ofrecer metodos o
propiedades publicas que validan antes de modificar. Asi el saldo de
una cuenta no se puede corromper desde fuera con asignaciones directas.

OBJETIVO:
  - Usar campos private y propiedades publicas de solo lectura.
  - Implementar Depositar y Retirar con validacion en bloques { }.
  - Impedir retiros invalidos sin romper el programa.
  - Ver que el usuario de la clase solo llama metodos seguros, no toca saldo.

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

void DemoCuenta();

void DemoDepositar();

void DemoRetirar();



class CuentaBancaria {
public:

    double saldo;

    string Iban { get; };
    double Saldo
    {
        get
        {
            return saldo;
        }
    }

    CuentaBancaria(string iban, double saldoInicial)
    {
        Iban = iban;
        if (saldoInicial >= 0)
        {
            saldo = saldoInicial;
        }
        else
        {
            saldo = 0;
        }
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
}



void ImprimirMenu()
    {
        cout << "=== U06 Encapsulacion ===" << endl;
        cout << "1. Cuenta con encapsulacion" << endl;
        cout << "2. Depositar" << endl;
        cout << "3. Retirar" << endl;
        cout << "0. Salir" << endl;
    }

/*
    PRIMERA PARTE — Crear cuenta con saldo inicial via constructor.
      Saldo es solo lectura desde fuera (propiedad calculada sobre campo private).
    */
void DemoCuenta()
    {
        cout << "¡DEMO — Cuenta con encapsulacion!\n" << endl;

        CuentaBancaria cuenta = new CuentaBancaria("ES001", 100);
        cout << "IBAN: " << (cuenta.Iban) << endl;
        cout << "Saldo inicial: " << (cuenta.Saldo) << " €" << endl;
    }

/*
    SEGUNDA PARTE — Depositar cantidades validas.
      Cantidades <= 0 se ignoran dentro del metodo (no modifican saldo).
    */
void DemoDepositar()
    {
        cout << "¡DEMO — Depositar!\n" << endl;

        CuentaBancaria cuenta = new CuentaBancaria("ES001", 100);
        cout << "Saldo inicial: " << (cuenta.Saldo) << " €" << endl;

        cuenta.Depositar(50);
        cout << "Saldo tras depositar 50 €: " << (cuenta.Saldo) << " €" << endl;

        cuenta.Depositar(-10);
        cout << "Saldo tras intentar depositar -10 € (ignorado): " << (cuenta.Saldo) << " €" << endl;
    }

/*
    TERCERA PARTE — Retirar con validacion: devuelve true/false.
      No permite retirar mas del saldo ni cantidades negativas.
    */
void DemoRetirar()
    {
        cout << "¡DEMO — Retirar!\n" << endl;

        CuentaBancaria cuenta = new CuentaBancaria("ES001", 150);

        bool ok1 = cuenta.Retirar(30);
        cout << $"Retirar 30 € -> {(ok1 ? "OK" : "Rechazado")}. Saldo: {cuenta.Saldo} €" << endl;

        bool ok2 = cuenta.Retirar(200);
        cout << $"Retirar 200 € -> {(ok2 ? "OK" : "Rechazado")}. Saldo: {cuenta.Saldo} €" << endl;

        bool ok3 = cuenta.Retirar(0);
        cout << $"Retirar 0 € -> {(ok3 ? "OK" : "Rechazado")}. Saldo: {cuenta.Saldo} €" << endl;

        cout << "\\nSaldo final: " << (cuenta.Saldo) << " €" << endl;
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
                    DemoCuenta();
                    break;
                case 2:
                    DemoDepositar();
                    break;
                case 3:
                    DemoRetirar();
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
