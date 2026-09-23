/*
OBJETIVO: abstract class Cuenta con Depositar concreto y Retirar abstracto;
  CuentaAhorro con limite diario. SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

class Cuenta
{
private:
    string titular;

protected:
    double saldo;

public:
    Cuenta(string titular, double saldoInicial)
    {
        this->titular = titular;
        saldo = saldoInicial;
    }

    virtual ~Cuenta() {}

    string GetTitular()
    {
        return titular;
    }

    double GetSaldo()
    {
        return saldo;
    }

    void Depositar(double cantidad)
    {
        if (cantidad <= 0)
        {
            cout << "Cantidad invalida." << endl;
            return;
        }
        saldo += cantidad;
        cout << "Deposito " << cantidad << ". Saldo: " << saldo << endl;
    }

    virtual void Retirar(double cantidad) = 0;
};

class CuentaAhorro : public Cuenta
{
private:
    double limiteRetiroDiario;

public:
    CuentaAhorro(string titular, double saldoInicial, double limiteRetiroDiario)
        : Cuenta(titular, saldoInicial)
    {
        this->limiteRetiroDiario = limiteRetiroDiario;
    }

    void Retirar(double cantidad) override
    {
        if (cantidad <= 0)
        {
            cout << "[Ahorro] Cantidad invalida." << endl;
            return;
        }
        if (cantidad > limiteRetiroDiario)
        {
            cout << "[Ahorro] Supera limite diario (" << limiteRetiroDiario << ")." << endl;
            return;
        }
        if (cantidad > saldo)
        {
            cout << "[Ahorro] Saldo insuficiente." << endl;
            return;
        }
        saldo -= cantidad;
        cout << "[Ahorro] Retiro " << cantidad << ". Saldo: " << saldo << endl;
    }
};

void ImprimirMenu()
{
    cout << "=== E05 Abstraccion CuentaAhorro (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
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
    CuentaAhorro ahorro("Lucia", 1000, 300);
    ahorro.Depositar(200);
    ahorro.Retirar(150);
    ahorro.Retirar(400);
    cout << "Saldo final: " << ahorro.GetSaldo() << endl;
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
