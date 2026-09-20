/*
OBJETIVO: Switch con opcion 1-3: Nuevo, Abrir, Salir.
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
    cout << "=== E03 Repaso Switch Menu Pendiente ===" << endl;
    cout << "1. Practicar el switch del ejercicio" << endl;
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
                cout << "Crea otro menu interno con opciones 1, 2 y 3." << endl;
                cout << "Debes usar switch para mostrar Nuevo, Abrir o Salir." << endl;
                cout << "Anade un default para opciones no validas." << endl;
                // TODO: completar el switch interno (1=Nuevo, 2=Abrir, 3=Salir).
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
