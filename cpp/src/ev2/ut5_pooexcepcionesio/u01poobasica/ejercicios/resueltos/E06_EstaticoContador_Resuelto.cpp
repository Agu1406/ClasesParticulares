/*
OBJETIVO: Clase Contador con miembro estatico; incrementa N veces (pide N) y muestra el total.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

class Contador
{
public:
    static int valor;

    static void Incrementar()
    {
        valor++;
    }

    static void Reiniciar()
    {
        valor = 0;
    }
};

int Contador::valor = 0;

void ImprimirMenu()
{
    cout << "=== EJERCICIO ===" << endl;
    cout << "1. Ejecutar solucion" << endl;
    cout << "2. Ver objetivo" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    Contador::Reiniciar();

    int n;
    cout << "Cuantas veces incrementar: ";
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        Contador::Incrementar();
    }

    cout << "Valor total: " << Contador::valor << endl;
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
                cout << "Contador estatico: pide N, incrementa N veces y muestra el total." << endl;
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
