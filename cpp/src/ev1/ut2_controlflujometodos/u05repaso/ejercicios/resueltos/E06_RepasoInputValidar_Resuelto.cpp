/*
OBJETIVO: Lee entero; si es negativo muestra Error, si no OK.
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
    cout << "=== E06 Repaso Input Validar Resuelto ===" << endl;
    cout << "1. Ejecutar validacion" << endl;
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
                int n;
                cout << "Numero: ";
                cin >> n;
                if (n < 0)
                {
                    cout << "Error" << endl;
                }
                else
                {
                    cout << "OK" << endl;
                }
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
