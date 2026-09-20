/*
OBJETIVO: Funcion double AreaTriangulo(double baseT, double altura); imprime area de 10 y 4.
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
    cout << "=== E03 Area Triangulo Pendiente ===" << endl;
    cout << "1. Preparar y revisar el ejercicio" << endl;
    cout << "0. Salir" << endl;
}

double AreaTriangulo(double baseT, double altura)
{
    // TODO: devolver baseT * altura / 2.
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
                cout << "Completa la funcion AreaTriangulo(double baseT, double altura)." << endl;
                cout << "Prueba preparada: AreaTriangulo(10, 4)." << endl;
                cout << "Resultado actual del esqueleto: " << AreaTriangulo(10, 4) << endl;
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
