/*
OBJETIVO: main llama a una funcion void Bienvenida() que imprime un mensaje.
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
    cout << "=== E10 Main Saludo Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo del enunciado" << endl;
    cout << "2. Probar con tus datos" << endl;
    cout << "0. Salir" << endl;
}

void Bienvenida()
{
    cout << "Bienvenido al programa" << endl;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                Bienvenida();
                break;
            case 2:
                Bienvenida();
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
