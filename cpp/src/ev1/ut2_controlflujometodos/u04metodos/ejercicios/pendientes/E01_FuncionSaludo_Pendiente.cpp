/*
OBJETIVO: Funcion void Saludar(string nombre); llamala dos veces.
PATRON: Menu do-while con opcion 0 salir y uso de cin.
Autor: Agustin. A. Marquez. Pina
Contacto: agu1406@outlook.es
Repositorio GitHub: https://github.com/Agu1406/ClasesParticulares
Sitio web: https://www.agustinmarquez.dev
*/

#include <iostream>
#include <string>
using namespace std;

void ImprimirMenu() {
    cout << endl;
    cout << "=== E01 Funcion Saludo Pendiente ===" << endl;
    cout << "1. Preparar y revisar el ejercicio" << endl;
    cout << "0. Salir" << endl;
}

void Saludar(string nombre)
{
    cout << "TODO: completar Saludar para mostrar un saludo a " << nombre << "." << endl;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << "Completa la funcion Saludar(string nombre) y usala dos veces." << endl;
                cout << "Prueba preparada: Saludar(\"Luis\") y Saludar(\"Sara\")." << endl;
                Saludar("Luis");
                Saludar("Sara");
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
