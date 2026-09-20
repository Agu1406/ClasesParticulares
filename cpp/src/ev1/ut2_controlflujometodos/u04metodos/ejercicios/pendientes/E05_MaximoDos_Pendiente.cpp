/*
OBJETIVO: Funcion int Maximo(int a, int b); imprime Maximo(12, 9).
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
    cout << "=== E05 Maximo Dos Pendiente ===" << endl;
    cout << "1. Preparar y revisar el ejercicio" << endl;
    cout << "0. Salir" << endl;
}

int Maximo(int a, int b)
{
    // TODO: devolver el mayor de los dos numeros.
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
                cout << "Completa la funcion Maximo(int a, int b)." << endl;
                cout << "Prueba preparada: Maximo(12, 9)." << endl;
                cout << "Resultado actual del esqueleto: " << Maximo(12, 9) << endl;
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
