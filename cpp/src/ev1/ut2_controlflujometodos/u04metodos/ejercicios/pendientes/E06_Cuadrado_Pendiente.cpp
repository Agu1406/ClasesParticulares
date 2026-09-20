/*
OBJETIVO: Funcion int Cuadrado(int n); imprime Cuadrado(5).
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
    cout << "=== E06 Cuadrado Pendiente ===" << endl;
    cout << "1. Preparar y revisar el ejercicio" << endl;
    cout << "0. Salir" << endl;
}

int Cuadrado(int n)
{
    // TODO: devolver n * n.
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
                cout << "Completa la funcion Cuadrado(int n)." << endl;
                cout << "Prueba preparada: Cuadrado(5)." << endl;
                cout << "Resultado actual del esqueleto: " << Cuadrado(5) << endl;
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
