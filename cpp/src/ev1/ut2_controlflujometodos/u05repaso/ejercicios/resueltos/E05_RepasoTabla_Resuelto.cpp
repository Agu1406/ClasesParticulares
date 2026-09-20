/*
OBJETIVO: Tabla del 7 del 1 al 10 con for.
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
    cout << "=== E05 Repaso Tabla Resuelto ===" << endl;
    cout << "1. Ejecutar tabla del 7" << endl;
    cout << "2. Probar otra tabla" << endl;
    cout << "0. Salir" << endl;
}

void MostrarTabla(int n)
{
    for (int i = 1; i <= 10; i++)
    {
        cout << n << " x " << i << " = " << (n * i) << endl;
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
                MostrarTabla(7);
                break;
            case 2: {
                int n;
                cout << "Tabla del numero: ";
                cin >> n;
                MostrarTabla(n);
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
