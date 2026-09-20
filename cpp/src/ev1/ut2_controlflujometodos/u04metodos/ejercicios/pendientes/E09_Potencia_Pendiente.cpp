/*
OBJETIVO: Funcion int Potencia(int baseP, int exp); imprime 2 elevado a 5.
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
    cout << "=== E09 Potencia Pendiente ===" << endl;
    cout << "1. Preparar y revisar el ejercicio" << endl;
    cout << "0. Salir" << endl;
}

int Potencia(int baseP, int exp)
{
    // TODO: usar un bucle para multiplicar la base tantas veces como indique exp.
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
                cout << "Completa la funcion Potencia(int baseP, int exp)." << endl;
                cout << "Prueba preparada: Potencia(2, 5)." << endl;
                cout << "Resultado actual del esqueleto: " << Potencia(2, 5) << endl;
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
