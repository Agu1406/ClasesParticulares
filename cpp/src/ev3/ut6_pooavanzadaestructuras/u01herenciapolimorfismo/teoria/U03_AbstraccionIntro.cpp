/*
U03 — Introduccion a la abstraccion (clase abstracta).

En el banco existen cuentas de ahorro y de credito, pero no una
"cuenta generica" que puedas abrir tal cual. Eso se modela con metodos
virtuales puros (= 0): datos/operaciones comunes + metodos sin implementar
que cada hija completa.

OBJETIVO:
  - Declarar metodos = 0 (clase abstracta) y completarlos en las hijas.
  - Entender que Cuenta c("Ana", 100); no compila si hay metodos puros.
  - Implementar Retirar / TipoCuenta en CuentaAhorro y CuentaCredito.
  - Usar puntero/referencia abstracta apuntando a objetos concretos.

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
    string cotitular; // vacio = sin cotitular (equivalente a null en C#)

protected:
    double saldo;

public:
    Cuenta(string nuevoTitular, string nuevoCotitular, double saldoInicial)
    {
        titular = nuevoTitular;
        cotitular = nuevoCotitular;
        saldo = saldoInicial;
    }

    Cuenta(string nuevoTitular, double saldoInicial)
        : Cuenta(nuevoTitular, "", saldoInicial)
    {
    }

    virtual ~Cuenta() {}

    string GetTitular()
    {
        return titular;
    }

    string GetCotitular()
    {
        return cotitular;
    }

    double GetSaldo()
    {
        return saldo;
    }

    void Depositar(double cantidad)
    {
        if (cantidad <= 0)
        {
            cout << "La cantidad a depositar debe ser positiva." << endl;
            return;
        }
        saldo += cantidad;
        cout << "Deposito de " << cantidad << " OK. Saldo: " << saldo << endl;
    }

    virtual void Retirar(double cantidad) = 0;
    virtual string TipoCuenta() = 0;

    virtual string ToString()
    {
        string texto = "\n¡Datos de la cuenta!\nTipo: " + TipoCuenta()
                     + "\nTitular: " + titular + "\n";
        if (!cotitular.empty())
        {
            texto += "Cotitular: " + cotitular + "\n";
        }
        texto += "Saldo actual: " + to_string(saldo) + "\n";
        return texto;
    }
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

    CuentaAhorro(string titular, string cotitular, double saldoInicial, double limiteRetiroDiario)
        : Cuenta(titular, cotitular, saldoInicial)
    {
        this->limiteRetiroDiario = limiteRetiroDiario;
    }

    void Retirar(double cantidad) override
    {
        if (cantidad <= 0)
        {
            cout << "[Ahorro] La cantidad debe ser positiva." << endl;
            return;
        }
        if (cantidad > limiteRetiroDiario)
        {
            cout << "[Ahorro] Supera el limite diario (" << limiteRetiroDiario << ")." << endl;
            return;
        }
        if (cantidad > saldo)
        {
            cout << "[Ahorro] Saldo insuficiente." << endl;
            return;
        }
        saldo -= cantidad;
        cout << "[Ahorro] Retiro de " << cantidad << " OK. Saldo: " << saldo << endl;
    }

    string TipoCuenta() override
    {
        return "Cuenta ahorro";
    }

    string ToString() override
    {
        return Cuenta::ToString() + "Limite de retiro diario: "
             + to_string(limiteRetiroDiario) + "\n";
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

    CuentaCredito(string titular, string cotitular, double saldoInicial, double limiteCredito)
        : Cuenta(titular, cotitular, saldoInicial)
    {
        this->limiteCredito = limiteCredito;
    }

    void Retirar(double cantidad) override
    {
        if (cantidad <= 0)
        {
            cout << "[Credito] La cantidad debe ser positiva." << endl;
            return;
        }
        if (saldo - cantidad < -limiteCredito)
        {
            cout << "[Credito] Supera el limite de credito (" << limiteCredito << ")." << endl;
            return;
        }
        saldo -= cantidad;
        cout << "[Credito] Retiro de " << cantidad << " OK. Saldo: " << saldo << endl;
    }

    string TipoCuenta() override
    {
        return "Cuenta credito";
    }

    string ToString() override
    {
        return Cuenta::ToString() + "Limite de credito: "
             + to_string(limiteCredito) + "\n";
    }
};

void ImprimirMenu()
{
    cout << "=== U03 Abstraccion: Cuenta / Ahorro / Credito ===" << endl;
    cout << "1. Por que abstract?" << endl;
    cout << "2. Demo CuentaAhorro" << endl;
    cout << "3. Demo CuentaCredito" << endl;
    cout << "4. Vector de Cuenta* (polimorfismo + abstraccion)" << endl;
    cout << "0. Salir" << endl;
}

void DemoPorQueAbstract()
{
    cout << "¡DEMO — Por que abstract?\n" << endl;
    cout << "Cuenta = molde comun. Ahorro y Credito = productos reales." << endl;
    cout << "No tiene sentido: Cuenta c(\"Ana\", 100);  // NO COMPILA (metodos = 0)" << endl;
    cout << "Si una clase declara un metodo = 0, no se puede instanciar." << endl;
    cout << "La primera subclase concreta debe implementar todos los puros." << endl;
}

void DemoCuentaAhorro()
{
    cout << "¡DEMO — CuentaAhorro (limite diario, sin descubierto)!\n" << endl;

    CuentaAhorro ahorro("Lucia", "Pedro", 1000, 300);
    cout << ahorro.ToString();
    ahorro.Depositar(200);
    ahorro.Retirar(150);  // OK
    ahorro.Retirar(400);  // supera limite diario
    ahorro.Retirar(2000); // saldo insuficiente
}

void DemoCuentaCredito()
{
    cout << "¡DEMO — CuentaCredito (descubierto hasta el limite)!\n" << endl;

    CuentaCredito credito("Daniel", 100, 500);
    cout << credito.ToString();
    credito.Retirar(200);  // saldo -100, dentro del credito
    credito.Retirar(500);  // intentaria -600; limite 500 -> rechazado
    cout << credito.ToString();
}

void DemoArrayCuentas()
{
    cout << "¡DEMO — Misma referencia abstracta, distinto Retirar()!\n" << endl;

    CuentaAhorro ahorro("Ana", 800, 200);
    CuentaCredito credito("Luis", 50, 300);

    vector<Cuenta*> cuentas = { &ahorro, &credito };

    for (Cuenta* c : cuentas)
    {
        cout << "--- " << c->TipoCuenta() << " ---" << endl;
        c->Retirar(100);
        cout << "Saldo tras retiro: " << c->GetSaldo() << endl;
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
                DemoPorQueAbstract();
                break;
            case 2:
                DemoCuentaAhorro();
                break;
            case 3:
                DemoCuentaCredito();
                break;
            case 4:
                DemoArrayCuentas();
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
