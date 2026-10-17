/*
CuentaBancaria — Encapsulacion (introduccion).

Encapsular es ocultar datos sensibles (private) y ofrecer metodos
publicos que validan antes de modificar. Asi el saldo no se puede
corromper desde fuera con asignaciones directas.

OBJETIVO:
  - Usar campos private y getters publicos de solo lectura.
  - Implementar Depositar y Retirar con validacion.
  - Impedir retiros invalidos sin romper el programa.
  - Ver que el usuario de la clase solo llama metodos seguros, no toca saldo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class CuentaBancaria
{
private:
    string iban;
    double saldo;

public:
    CuentaBancaria(string iban, double saldoInicial)
    {
        this->iban = iban;
        if (saldoInicial >= 0)
        {
            saldo = saldoInicial;
        }
        else
        {
            saldo = 0;
        }
    }

    string GetIban() const
    {
        return iban;
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
    cout << "=== CuentaBancaria: encapsulacion ===" << endl;
    cout << "1. Cuenta con encapsulacion" << endl;
    cout << "2. Depositar" << endl;
    cout << "3. Retirar" << endl;
    cout << "0. Salir" << endl;
}

/*
    PRIMERA PARTE — Crear cuenta con saldo inicial via constructor.
      GetSaldo es solo lectura: desde fuera no se puede hacer cuenta.saldo = -10.
    */
void DemoCuenta()
{
    cout << "¡DEMO — Cuenta con encapsulacion!\n" << endl;

    CuentaBancaria cuenta("ES001", 100);
    cout << "IBAN: " << cuenta.GetIban() << endl;
    cout << "Saldo inicial: " << cuenta.GetSaldo() << " EUR" << endl;
}

/*
    SEGUNDA PARTE — Depositar cantidades validas.
      Cantidades <= 0 se ignoran dentro del metodo (no modifican saldo).
    */
void DemoDepositar()
{
    cout << "¡DEMO — Depositar!\n" << endl;

    CuentaBancaria cuenta("ES001", 100);
    cout << "Saldo inicial: " << cuenta.GetSaldo() << " EUR" << endl;

    cuenta.Depositar(50);
    cout << "Saldo tras depositar 50 EUR: " << cuenta.GetSaldo() << " EUR" << endl;

    cuenta.Depositar(-10);
    cout << "Saldo tras intentar depositar -10 EUR (ignorado): " << cuenta.GetSaldo() << " EUR" << endl;
}

/*
    TERCERA PARTE — Retirar con validacion: devuelve true/false.
      No permite retirar mas del saldo ni cantidades negativas.
    */
void DemoRetirar()
{
    cout << "¡DEMO — Retirar!\n" << endl;

    CuentaBancaria cuenta("ES001", 150);

    bool ok1 = cuenta.Retirar(30);
    cout << "Retirar 30 EUR -> " << (ok1 ? "OK" : "Rechazado")
         << ". Saldo: " << cuenta.GetSaldo() << " EUR" << endl;

    bool ok2 = cuenta.Retirar(200);
    cout << "Retirar 200 EUR -> " << (ok2 ? "OK" : "Rechazado")
         << ". Saldo: " << cuenta.GetSaldo() << " EUR" << endl;

    bool ok3 = cuenta.Retirar(0);
    cout << "Retirar 0 EUR -> " << (ok3 ? "OK" : "Rechazado")
         << ". Saldo: " << cuenta.GetSaldo() << " EUR" << endl;

    cout << endl << "Saldo final: " << cuenta.GetSaldo() << " EUR" << endl;
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
