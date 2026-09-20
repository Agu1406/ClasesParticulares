/*
OBJETIVO: Funcion Media(int a,int b,int c); imprime media de 6,8,10.
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
    cout << "=== E04 Repaso Funcion Media Pendiente ===" << endl;
    cout << "1. Revisar el ejercicio guiado" << endl;
    cout << "0. Salir" << endl;
}

double Media(int a, int b, int c)
{
    // TODO: devolver la media de los tres valores.
    return 0;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << "Completa la funcion Media(int a, int b, int c)." << endl;
                cout << "Despues muestra el resultado de Media(6, 8, 10)." << endl;
                cout << "Resultado actual del esqueleto: " << Media(6, 8, 10) << endl;
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
