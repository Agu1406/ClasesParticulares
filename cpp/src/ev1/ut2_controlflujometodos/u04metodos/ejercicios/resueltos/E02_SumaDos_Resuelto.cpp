/*
OBJETIVO: Funcion int Sumar(int a, int b); imprime Sumar(4,6).
SOLUCION: ver codigo.
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
    cout << "=== E02 Suma Dos Resuelto ===" << endl;
    cout << "1. Ejecutar ejemplo del enunciado" << endl;
    cout << "2. Probar con tus datos" << endl;
    cout << "0. Salir" << endl;
}

int LeerEntero(string mensaje)
{
    int valor;
    cout << mensaje;
    cin >> valor;
    return valor;
}

int Sumar(int a, int b)
{
    return a + b;
}

int main() {
    int opcion;
    do {
        ImprimirMenu();
        cout << "Introduce una opcion -> ";
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << Sumar(4, 6) << endl;
                break;
            case 2: {
                int a = LeerEntero("Primer numero: ");
                int b = LeerEntero("Segundo numero: ");
                cout << "Suma = " << Sumar(a, b) << endl;
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
