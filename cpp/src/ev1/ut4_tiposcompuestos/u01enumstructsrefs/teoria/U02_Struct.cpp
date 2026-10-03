/*
U02 — Estructuras (struct) en la pila.

OBJETIVO:
  - Declarar struct Fecha { int dia; int mes; int anio; };
  - Inicializar: Fecha f = {11, 9, 2025};
  - Acceder a campos con f.dia (sin punteros).
  - El PDF: un struct en la pila se destruye solo al salir de ambito.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

struct Fecha
{
    int dia;
    int mes;
    int anio;
};

void EscribirFecha(Fecha fecha)
{
    cout << fecha.dia << "/" << fecha.mes << "/" << fecha.anio << endl;
}

void ImprimirMenu()
{
    cout << "=== U02 Struct ===" << endl;
    cout << "1. Crear e imprimir" << endl;
    cout << "2. Cambiar un campo" << endl;
    cout << "0. Salir" << endl;
}

void DemoCrear()
{
    cout << "¡DEMO — Crear!\n" << endl;
    Fecha f1 = {11, 9, 2025};
    Fecha f2;
    f2.dia = 1;
    f2.mes = 1;
    f2.anio = 2026;
    EscribirFecha(f1);
    EscribirFecha(f2);
}

void DemoCambiar()
{
    cout << "¡DEMO — Cambiar campo!\n" << endl;
    Fecha f = {4, 1, 2019};
    f.dia = 5;
    EscribirFecha(f);
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
                DemoCrear();
                break;
            case 2:
                DemoCambiar();
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
