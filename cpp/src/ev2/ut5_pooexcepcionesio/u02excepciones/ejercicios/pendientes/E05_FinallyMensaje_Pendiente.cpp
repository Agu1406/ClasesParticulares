/*
E05 — Limpieza tras try/catch (en C++ NO hay finally).

El mensaje "Operacion finalizada" se escribe DESPUES del try/catch.
Division 8/0: if (b == 0) throw runtime_error.

PENDIENTE: completa los TODO.

Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <stdexcept>
using namespace std;

void ImprimirMenu()
{
    cout << "=== E05 Limpieza (sin finally) ===" << endl;
    cout << "1. Ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarEjercicio()
{
    // TODO: try { dividir 8/0; si b==0 throw runtime_error }
    //       catch (const runtime_error& e) { mostrar e.what() }
    //       DESPUES del try/catch: cout << "Operacion finalizada."
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
