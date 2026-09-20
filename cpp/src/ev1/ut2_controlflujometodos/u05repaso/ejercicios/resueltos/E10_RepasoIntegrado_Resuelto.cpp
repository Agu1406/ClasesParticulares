/*
OBJETIVO: Menu 1=Tabla 5, 2=Par/Impar 4, 0=Salir con do-while.
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
    cout << "=== E10 Repaso Integrado Resuelto ===" << endl;
    cout << "1. Tabla del 5" << endl;
    cout << "2. Par o impar de 4" << endl;
    cout << "0. Salir" << endl;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                for (int i = 1; i <= 10; i++)
                {
                    cout << "5 x " << i << " = " << (5 * i) << endl;
                }
                break;
            case 2:
                cout << (4 % 2 == 0 ? "Par" : "Impar") << endl;
                break;
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
