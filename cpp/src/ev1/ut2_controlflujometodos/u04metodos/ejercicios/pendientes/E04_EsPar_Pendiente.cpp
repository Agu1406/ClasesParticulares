/*
OBJETIVO: Funcion bool EsPar(int n); imprime EsPar(8) y EsPar(7).
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
    cout << "=== E04 Es Par Pendiente ===" << endl;
    cout << "1. Preparar y revisar el ejercicio" << endl;
    cout << "0. Salir" << endl;
}

bool EsPar(int n)
{
    // TODO: devolver true si n es par.
    return false;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << "Completa la funcion EsPar(int n)." << endl;
                cout << "Pruebas preparadas: EsPar(8) y EsPar(7)." << endl;
                cout << boolalpha;
                cout << "EsPar(8): " << EsPar(8) << endl;
                cout << "EsPar(7): " << EsPar(7) << endl;
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
