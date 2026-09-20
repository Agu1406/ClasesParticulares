/*
OBJETIVO: Do-while: pide numeros hasta 0.
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
    cout << "=== E07 Repaso Do While Pendiente ===" << endl;
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
                cout << "Debes crear un do-while que pida numeros hasta introducir 0." << endl;
                cout << "Pista: lee al menos una vez antes de comprobar la condicion." << endl;
                // TODO: completar el do-while que pide numeros hasta 0.
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
