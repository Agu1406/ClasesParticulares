/*
E09 — throw si edad < 0.

ValidarEdad lanza invalid_argument si la edad es negativa.
Se captura con catch (const invalid_argument& e) y e.what().

PENDIENTE: completa los TODO.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <stdexcept>
using namespace std;

void ValidarEdad(int edad)
{
    // TODO: si edad < 0, throw invalid_argument("La edad no puede ser negativa.");
    //       si no, cout << "Edad valida: " << edad
}

void ImprimirMenu()
{
    cout << "=== E09 Throw edad negativa ===" << endl;
    cout << "1. Ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    // TODO: try { ValidarEdad(-3); }
    //       catch (const invalid_argument& e) { cout << e.what(); }
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
