/*
OBJETIVO: Funcion void ContarHasta(int n); imprime 1..n con bucle.
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
    cout << "=== E08 Contar Hasta Pendiente ===" << endl;
    cout << "1. Preparar y revisar el ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void ContarHasta(int n)
{
    cout << "TODO: completar un bucle que muestre del 1 al " << n << "." << endl;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << "Completa la funcion ContarHasta(int n) para mostrar del 1 al valor indicado." << endl;
                cout << "Prueba preparada: ContarHasta(5)." << endl;
                ContarHasta(5);
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
