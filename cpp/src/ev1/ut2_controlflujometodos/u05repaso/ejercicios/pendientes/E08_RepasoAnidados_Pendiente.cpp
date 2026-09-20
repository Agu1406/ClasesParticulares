/*
OBJETIVO: Nota 8: anidados SB/NT/AP/SS.
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
    cout << "=== E08 Repaso Anidados Pendiente ===" << endl;
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
                cout << "Usa if anidados con nota = 8." << endl;
                cout << "Debe mostrar SB, NT, AP o SS segun corresponda." << endl;
                cout << "Pista: primero comprueba si esta aprobado." << endl;
                // TODO: completar if anidados con nota = 8.
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
