/*
OBJETIVO: Switch con opcion 1-3: Nuevo, Abrir, Salir.
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
    cout << "=== E03 Repaso Switch Menu Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo con opcion 2" << endl;
    cout << "2. Elegir una opcion del switch" << endl;
    cout << "0. Salir" << endl;
}

void EjecutarSwitch(int op)
{
    switch (op)
    {
        case 1:
            cout << "Nuevo" << endl;
            break;
        case 2:
            cout << "Abrir" << endl;
            break;
        case 3:
            cout << "Salir" << endl;
            break;
        default:
            cout << "Invalida" << endl;
            break;
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
                EjecutarSwitch(2);
                break;
            case 2: {
                int opInterna;
                cout << "Opcion interna (1-3): ";
                cin >> opInterna;
                EjecutarSwitch(opInterna);
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
