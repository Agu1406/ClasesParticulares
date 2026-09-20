/*
OBJETIVO: int nota=7; if >=5 Aprobado else Suspenso.
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
    cout << "=== E01 Repaso Variables If Pendiente ===" << endl;
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
            case 1: {
                cout << "Declara int nota = 7 y completa el if/else." << endl;
                cout << "Si nota es 5 o mayor, debe mostrar Aprobado." << endl;
                cout << "En caso contrario, debe mostrar Suspenso." << endl;
                int nota = 7;
                cout << "Valor de prueba preparado: nota = " << nota << endl;
                // TODO: completar el if/else con nota.
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
