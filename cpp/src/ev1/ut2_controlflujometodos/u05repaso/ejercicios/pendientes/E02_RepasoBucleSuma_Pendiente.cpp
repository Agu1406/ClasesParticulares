/*
OBJETIVO: For: suma del 1 al 10.
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
    cout << "=== E02 Repaso Bucle Suma Pendiente ===" << endl;
    cout << "1. Revisar el ejercicio guiado" << endl;
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
                cout << "Prepara una variable acumuladora y un bucle for del 1 al 10." << endl;
                cout << "Al final debes mostrar la suma total." << endl;
                cout << "Pista: empieza con s = 0." << endl;
                // TODO: completar el bucle for que suma del 1 al 10.
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
