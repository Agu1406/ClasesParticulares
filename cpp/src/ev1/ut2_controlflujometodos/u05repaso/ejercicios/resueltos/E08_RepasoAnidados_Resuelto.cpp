/*
OBJETIVO: Nota 8: anidados SB/NT/AP/SS.
SOLUCION: ver codigo.
PATRON: Menu do-while con opcion 0 salir y uso de cin.
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
using namespace std;

void ImprimirMenu() {
    cout << endl;
    cout << "=== E08 Repaso Anidados Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo con nota 8" << endl;
    cout << "2. Probar con otra nota" << endl;
    cout << "0. Salir" << endl;
}

void MostrarCalificacion(int nota)
{
    if (nota >= 5)
    {
        if (nota >= 9)
        {
            cout << "SB" << endl;
        }
        else if (nota >= 7)
        {
            cout << "NT" << endl;
        }
        else
        {
            cout << "AP" << endl;
        }
    }
    else
    {
        cout << "SS" << endl;
    }
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                MostrarCalificacion(8);
                break;
            case 2: {
                int nota;
                cout << "Nota: ";
                cin >> nota;
                MostrarCalificacion(nota);
                break;
            }
            case 0:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida." << endl;
                break;
        }
    } while (opcion != 0);
    return 0;
}
