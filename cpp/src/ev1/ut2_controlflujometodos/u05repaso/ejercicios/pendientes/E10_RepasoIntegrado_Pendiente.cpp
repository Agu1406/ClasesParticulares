/*
OBJETIVO: Menu 1=Tabla 5, 2=Par/Impar 4, 0=Salir con do-while.
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
    cout << "=== E10 Repaso Integrado Pendiente ===" << endl;
    cout << "1. Ver lo que debe hacer la opcion Tabla 5" << endl;
    cout << "2. Ver lo que debe hacer la opcion Par/Impar 4" << endl;
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
                cout << "Completa un bucle que muestre la tabla del 5 del 1 al 10." << endl;
                // TODO: tabla del 5.
                break;
            case 2:
                cout << "Completa la comprobacion para decidir si 4 es par o impar." << endl;
                // TODO: par o impar de 4.
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
