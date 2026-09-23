/*
OBJETIVO: Anadir CuentaCredito (descubierto) y comparar Retirar con CuentaAhorro
  usando referencia Cuenta. SOLUCION: ver codigo.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
#include <vector>
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
        if (cantidad > limiteRetiroDiario || cantidad > saldo)
        {
            cout << "[Ahorro] Retiro rechazado." << endl;
            return;
        }
        saldo -= cantidad;
        cout << "[Ahorro] Retiro " << cantidad << " OK." << endl;
    }
};

class CuentaCredito : public Cuenta
{
private:
    double limiteCredito;

public:
    CuentaCredito(string titular, double saldoInicial, double limiteCredito)
        : Cuenta(titular, saldoInicial)
    {
        this->limiteCredito = limiteCredito;
    }

    void Retirar(double cantidad) override
    {
        if (saldo - cantidad < -limiteCredito)
        {
            cout << "[Credito] Retiro rechazado." << endl;
            return;
        }
        saldo -= cantidad;
        cout << "[Credito] Retiro " << cantidad << " OK." << endl;
    }
};

void ImprimirMenu()
{
    cout << "=== E06 Abstraccion CuentaCredito (resuelto) ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
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
    CuentaAhorro ahorro("Ana", 800, 200);
    CuentaCredito credito("Luis", 50, 300);

    vector<Cuenta*> cuentas = { &ahorro, &credito };

    for (Cuenta* c : cuentas)
    {
        cout << "--- " << c->GetTitular() << " ---" << endl;
        c->Retirar(100);
        cout << "Saldo: " << c->GetSaldo() << endl;
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
