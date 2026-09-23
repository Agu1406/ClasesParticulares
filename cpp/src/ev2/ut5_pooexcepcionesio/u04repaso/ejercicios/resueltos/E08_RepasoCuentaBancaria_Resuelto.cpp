/*
OBJETIVO: Repaso: CuentaBancaria con saldo encapsulado; depositar y retirar. Menu do-while: mantener la solucion y ejecutarla desde menu interactivo.
SOLUCION: ver codigo.

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

void MostrarObjetivo();

void EjecutarEjercicio();

void EjecutarInteractivo();



class CuentaBancaria {
public:

    double saldo;
    double Saldo => saldo;

    CuentaBancaria(double inicial) => saldo = inicial;

    void Depositar(double c) { if (c > 0) saldo += c; };

    bool Retirar(double c)
    {
        if (c <= 0 || c > saldo) return false;
        saldo -= c;
        return true;
    }
}



void ImprimirMenu()
    {
        cout << "=== EJERCICIO ===" << endl;
        cout << "1. Ejecutar solucion" << endl;
        cout << "2. Ver objetivo" << endl;
        cout << "3. Operar cuenta interactiva" << endl;
        cout << "0. Salir" << endl;
        
    }

void MostrarObjetivo()
    {
        Console.WriteLine("Repaso: CuentaBancaria con saldo encapsulado; depositar y retirar.");
    }

void EjecutarEjercicio()
    {
        CuentaBancaria cuenta = new CuentaBancaria(200);
            cuenta.Depositar(50);
            cuenta.Retirar(80);
            cout << "Saldo: " << (cuenta.Saldo) << " EUR" << endl;
    }

void EjecutarInteractivo()
    {
        cout << "Saldo inicial: ";
        if (!double.TryParse(string(/*TODO cin*/), out double inicial))
        {
            cout << "Saldo invalido." << endl;
            return;
        }
        CuentaBancaria cuenta = new CuentaBancaria(inicial);
        cout << "Deposito: ";
        if (double.TryParse(string(/*TODO cin*/), out double deposito))
        {
            cuenta.Depositar(deposito);
        }
        cout << "Retiro: ";
        if (double.TryParse(string(/*TODO cin*/), out double retiro))
        {
            if (!cuenta.Retirar(retiro))
            {
                cout << "Retiro rechazado." << endl;
            }
        }
        cout << "Saldo: " << (cuenta.Saldo) << " EUR" << endl;
    }



int main()
    {
        int opcion;

        do
        {
            ImprimirMenu();
            cout << "Introduce una opcion -> ";
            cin >> opcion;

            switch (opcion)
            {
                case 1:
                    EjecutarEjercicio();
                    break;
                case 3:
                    EjecutarInteractivo();
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

            if (opcion != 0)
            {
                cout << endl;
                cout << "Pulsa ENTER para continuar..." << endl;
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cin.get();
                // clear omitido
            }
        } while (opcion != 0);
        return 0;
}
